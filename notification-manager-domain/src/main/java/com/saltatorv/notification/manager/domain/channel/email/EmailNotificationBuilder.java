package com.saltatorv.notification.manager.domain.channel.email;

import com.saltatorv.notification.manager.domain.channel.Channel;
import com.saltatorv.notification.manager.domain.attempt.DeliveryAttempt;
import com.saltatorv.notification.manager.domain.Notification;
import com.saltatorv.notification.manager.domain.shared.NotificationDeliveryAttemptStep;
import com.saltatorv.notification.manager.domain.shared.NotificationFinalStep;

public class EmailNotificationBuilder implements EmailNotificationRecipientStep, EmailNotificationSubjectStep, EmailNotificationBodyStep, NotificationDeliveryAttemptStep, NotificationFinalStep {

    private String recipient;
    private String subject;
    private String body;
    private int maxAttemptsCounter;

    @Override
    public EmailNotificationSubjectStep recipient(String recipient) {
        this.recipient = recipient;
        return this;
    }

    @Override
    public EmailNotificationBodyStep subject(String subject) {
        this.subject = subject;
        return this;
    }

    @Override
    public NotificationDeliveryAttemptStep body(String body) {
        this.body = body;
        return this;
    }

    @Override
    public NotificationFinalStep maxDeliveryAttempts(int maxAttemptsCounter) {
        this.maxAttemptsCounter = maxAttemptsCounter;
        return this;
    }

    @Override
    public Notification create() {
        Channel channel = new EmailChannel(recipient, subject, body);
        return Notification.create(channel, new DeliveryAttempt(maxAttemptsCounter));
    }


}
