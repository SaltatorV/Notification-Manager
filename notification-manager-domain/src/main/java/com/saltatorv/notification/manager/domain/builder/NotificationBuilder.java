package com.saltatorv.notification.manager.domain.builder;

import com.saltatorv.notification.manager.domain.builder.steps.email.EmailNotificationBuilder;
import com.saltatorv.notification.manager.domain.builder.steps.email.EmailNotificationRecipientStep;
import com.saltatorv.notification.manager.domain.builder.steps.shared.NotificationChannelStep;
import com.saltatorv.notification.manager.domain.builder.steps.sms.SMSNotificationBuilder;
import com.saltatorv.notification.manager.domain.builder.steps.sms.SMSNotificationRecipientStep;
import com.saltatorv.notification.manager.domain.builder.steps.system.SystemNotificationBuilder;
import com.saltatorv.notification.manager.domain.builder.steps.system.SystemNotificationRecipientStep;

public class NotificationBuilder implements NotificationChannelStep {

    private NotificationBuilder() {

    }

    private static NotificationBuilder buildNotification() {
        return new NotificationBuilder();
    }

    @Override
    public SMSNotificationRecipientStep forSms() {
        return new SMSNotificationBuilder();
    }

    @Override
    public EmailNotificationRecipientStep forMail() {
        return new EmailNotificationBuilder();
    }

    @Override
    public SystemNotificationRecipientStep forSystem() {
        return new SystemNotificationBuilder();
    }
}
