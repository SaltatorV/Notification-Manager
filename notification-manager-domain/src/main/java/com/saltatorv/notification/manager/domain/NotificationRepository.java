package com.saltatorv.notification.manager.domain;

interface NotificationRepository {
    Notification save(Notification notification);
    Notification findById(NotificationId id);
}
