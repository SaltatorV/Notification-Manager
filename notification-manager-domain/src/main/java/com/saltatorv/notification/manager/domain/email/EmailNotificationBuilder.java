package com.saltatorv.notification.manager.domain.email;

import com.saltatorv.notification.manager.domain.Notification;
import com.saltatorv.notification.manager.domain.shared.NotificationFinalStep;

public class EmailNotificationBuilder implements EmailNotificationRecipientStep, EmailNotificationSubjectStep, EmailNotificationBodyStep, NotificationFinalStep {

    private String recipient;
    private String subject;
    private String body;

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
    public NotificationFinalStep body(String body) {
        this.body = body;
        return this;
    }

    @Override
    public Notification create() {
        return new Notification(this.body);
    }


}
