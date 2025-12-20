package com.saltatorv.notification.manager.domain;

import org.junit.jupiter.api.Test;

import static com.saltatorv.notification.manager.domain.builder.NotificationBuilder.buildNotification;
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
                .create();

        // when
        sendNotification();

        // then
        assertMessageIsSent();
    }

    private void assertMessageIsSent() {
        assertTrue(notification.isSent());
    }

    private void sendNotification() {
        notification.send();
    }

    private void createNotification(String message) {
        notification = new Notification(message);
    }
}
