package com.saltatorv.notification.manager.domain;

import com.saltatorv.notification.manager.domain.attempt.AttemptResult;
import com.saltatorv.notification.manager.domain.channel.Channel;
import com.saltatorv.notification.manager.domain.attempt.DeliveryAttempt;
import com.saltatorv.notification.manager.domain.event.DomainEvent;
import com.saltatorv.notification.manager.domain.event.NotificationSendFailureEvent;
import com.saltatorv.notification.manager.domain.event.NotificationSentEvent;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.saltatorv.notification.manager.domain.NotificationBuilder.buildNotification;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NotificationTest {

    private Notification notification;
    private List<DomainEvent> domainEvents;

    @Test
    public void testShouldSendSMSNotification() {
        // given
        notification = buildNotification()
                .forSms()
                .recipient("+48123456789")
                .message("Sample message")
                .maxDeliveryAttempts(1)
                .create();

        // when
        sendNotification();

        // then
        assertMessageIsSent();
    }

    @Test
    public void testShouldSendEmailNotification() {
        // given
        notification = buildNotification()
                .forMail()
                .recipient("example@example.com")
                .subject("Test")
                .body("Test body")
                .maxDeliveryAttempts(1)
                .create();

        // when
        sendNotification();

        // then
        assertMessageIsSent();
    }

    @Test
    public void testShouldSendSystemNotification() {
        // given
        notification = buildNotification()
                .forSystem()
                .recipient("example@example.com")
                .message("Sample message")
                .maxDeliveryAttempts(1)
                .create();

        // when
        sendNotification();

        // then
        assertMessageIsSent();
    }

    @Test
    public void testShouldNotSentNotificationWhenThereIsNoAttemptsLeft() {
        // given
        notification = buildNotification()
                .forSystem()
                .recipient("example@example.com")
                .message("Sample message")
                .maxDeliveryAttempts(1)
                .create();

        // when
        sendNotification();
        sendNotification();

        // then
        assertMessageIsSent();
    }

    @Test
    public void testNotificationShouldNotBeSentWhenCreated() {
        // given

        // when
        notification = buildNotification()
                .forSystem()
                .recipient("example@example.com")
                .message("Sample message")
                .maxDeliveryAttempts(1)
                .create();

        // then
        assertMessageIsNotSent();
    }

    @Test
    public void testShouldClearEventsAfterPullSuccessfulSentAttempt() {
        // given
        notification = buildNotification()
                .forSms()
                .recipient("+48123456789")
                .message("Sample message")
                .maxDeliveryAttempts(1)
                .create();

        sendNotification();

        // when
        pullEvents();

        // then
        assertDomainEventsAreClear();
        assertPulledEventsContainsNotificationSentEvent();
    }

    @Test
    public void testShouldClearEventsAfterPullFailedSentAttempt() {
        // given
        createNotificationWithFailingChannel();
        sendNotification();
        
        // when 
        pullEvents();

        // then
        assertDomainEventsAreClear();
        assertPulledEventsContainsNotificationSendFailureEvent();
    }

    private void createNotificationWithFailingChannel() {
        notification = Notification.create(new FailingChannel(), new DeliveryAttempt(2));
    }


    private void sendNotification() {
        notification.send();
    }

    private void pullEvents() {
        domainEvents = notification.pullDomainEvents();
    }

    private void assertMessageIsSent() {
        assertTrue(notification.isSent());
    }

    private void assertMessageIsNotSent() {
        assertFalse(notification.isSent());
    }

    private void assertDomainEventsAreClear() {
        assertTrue(notification.pullDomainEvents().isEmpty());
    }

    private void assertPulledEventsContainsNotificationSentEvent() {
        assertTrue(domainEvents.stream().anyMatch(NotificationSentEvent.class::isInstance));
    }
    
    private void assertPulledEventsContainsNotificationSendFailureEvent() {
        assertTrue(domainEvents.stream().anyMatch(NotificationSendFailureEvent.class::isInstance));
    }

    private class FailingChannel extends Channel {

        @Override
        public AttemptResult send() {
            return AttemptResult.createForFailure("Fail");
        }
    }

}
