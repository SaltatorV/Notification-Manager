package com.saltatorv.notification.manager.domain.sms;

import com.saltatorv.notification.manager.domain.attempt.Channel;
import com.saltatorv.notification.manager.domain.attempt.DeliveryAttempt;
import com.saltatorv.notification.manager.domain.Notification;
import com.saltatorv.notification.manager.domain.shared.NotificationDeliveryAttemptStep;
import com.saltatorv.notification.manager.domain.shared.NotificationFinalStep;

public class SMSNotificationBuilder implements SMSNotificationRecipientStep, SMSNotificationTextMessageStep, NotificationDeliveryAttemptStep, NotificationFinalStep {

    private String recipient;
    private String message;
    private int maxAttemptsCounter;

    @Override
    public SMSNotificationTextMessageStep recipient(String recipient) {
        this.recipient = recipient;
        return this;
    }

    @Override
    public NotificationDeliveryAttemptStep message(String message) {
        this.message = message;
        return this;
    }


    @Override
    public NotificationFinalStep maxDeliveryAttempts(int maxAttemptsCounter) {
        this.maxAttemptsCounter = maxAttemptsCounter;
        return this;
    }

    @Override
    public Notification create() {
        Channel channel = new SMSChannel(recipient, message);
        return Notification.create(channel, new DeliveryAttempt(maxAttemptsCounter));
    }
}
