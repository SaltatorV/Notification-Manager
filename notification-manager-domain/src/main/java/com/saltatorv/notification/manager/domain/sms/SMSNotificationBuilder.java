package com.saltatorv.notification.manager.domain.sms;

import com.saltatorv.notification.manager.domain.Channel;
import com.saltatorv.notification.manager.domain.Notification;
import com.saltatorv.notification.manager.domain.shared.NotificationFinalStep;

public class SMSNotificationBuilder implements SMSNotificationRecipientStep, SMSNotificationTextMessageStep, NotificationFinalStep {

    private String recipient;
    private String message;

    @Override
    public SMSNotificationTextMessageStep recipient(String recipient) {
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
        Channel channel = new SMSChannel(recipient, message);
        return new Notification(channel);
    }
}
