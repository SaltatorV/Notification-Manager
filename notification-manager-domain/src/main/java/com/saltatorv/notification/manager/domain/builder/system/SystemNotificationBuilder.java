package com.saltatorv.notification.manager.domain.builder.system;

import com.saltatorv.notification.manager.domain.Notification;
import com.saltatorv.notification.manager.domain.builder.shared.NotificationFinalStep;

public class SystemNotificationBuilder implements SystemNotificationRecipientStep, SystemNotificationMessageStep, NotificationFinalStep {
    private String recipient;
    private String message;

    @Override
    public SystemNotificationMessageStep recipient(String recipient) {
        this.recipient = recipient;
        return this;
    }

    @Override
    public NotificationFinalStep message(String message) {
        this.message = message;
        return this;
    }

    @Override
    public Notification create() {
        return new Notification(this.message);
    }
}
