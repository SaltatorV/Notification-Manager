package com.saltatorv.notification.manager.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class NotificationIdTest {
    NotificationId notificationId;

    @Test
    public void testShouldGenerateNotificationId() {
        //given

        //when
        generate();

        //then
        assertNotNull(notificationId);
    }

    private void generate() {
        notificationId = NotificationId.generate();
    }


}
