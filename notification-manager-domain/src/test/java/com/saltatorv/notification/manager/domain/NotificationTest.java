package com.saltatorv.notification.manager.domain;

import org.junit.jupiter.api.Test;

import static com.saltatorv.notification.manager.domain.NotificationBuilder.buildNotification;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NotificationTest {

    private Notification notification;

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

    private void sendNotification() {
        notification.send();
    }

    private void assertMessageIsSent() {
        assertTrue(notification.isSent());
    }

    private void assertMessageIsNotSent() {
        assertFalse(notification.isSent());
    }


}
