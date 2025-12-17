package com.saltatorv.notification.manager.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class NotificationTest {

    private Notification notification;

    @Test
    public void testShouldSendNotification() {
        // given
        var message = "example message";
        createNotification();

        // when
        sendNotification(message);

        // then
        assertMessageIsSent(message);
    }

    private void assertMessageIsSent(String message) {
        assertTrue(notification.getMessages().contains(message));
    }

    private void sendNotification(String notificationMessage) {
        notification.send(notificationMessage);
    }

    private void createNotification() {
        notification = new Notification();
    }
}
