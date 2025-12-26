package com.saltatorv.notification.manager.domain;

import java.util.UUID;

public class NotificationId {
    private final String id;

    private NotificationId() {
        this.id = UUID.randomUUID().toString();
    }

    @Generated
    public static NotificationId generate() {
        return new NotificationId();
    }

    @Generated
    public String getId() {
        return id;
    }
}
