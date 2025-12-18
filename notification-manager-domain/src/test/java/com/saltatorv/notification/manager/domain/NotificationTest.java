package com.saltatorv.notification.manager.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class NotificationTest {

    private Notification notification;

    @Test
    public void testShouldSendNotification() {
        // given
        createNotification("example message");

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
