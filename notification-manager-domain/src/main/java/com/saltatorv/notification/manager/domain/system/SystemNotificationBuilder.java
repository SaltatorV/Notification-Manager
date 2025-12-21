package com.saltatorv.notification.manager.domain.system;

import com.saltatorv.notification.manager.domain.Channel;
import com.saltatorv.notification.manager.domain.Notification;
import com.saltatorv.notification.manager.domain.shared.NotificationFinalStep;

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

        Channel channel = new SystemChannel(recipient, message);
        return new Notification(channel);
    }
}
