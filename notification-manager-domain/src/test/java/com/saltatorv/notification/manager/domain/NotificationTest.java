package com.saltatorv.notification.manager.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class NotificationTest {

    private Notification notification;

    @Test
    public void testShouldSendNotification() {
        // given
        createNotification()
                .forChanel("SMS")
                .recipient("+48123456789")
                .message("Sample message");

        createNotification()
                .forChannel("EMAIL")
                .recipient("example@example.com")
                .subject("Test")
                .body("Test body");

        createNotification()
                .forChannel("SYSTEM")
                .message("Sample message")
                .recipient("example@example.com");

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
