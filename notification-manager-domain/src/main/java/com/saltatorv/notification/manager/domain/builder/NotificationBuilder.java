package com.saltatorv.notification.manager.domain.builder;

import com.saltatorv.notification.manager.domain.builder.email.EmailNotificationBuilder;
import com.saltatorv.notification.manager.domain.builder.email.EmailNotificationRecipientStep;
import com.saltatorv.notification.manager.domain.builder.shared.NotificationChannelStep;
import com.saltatorv.notification.manager.domain.builder.sms.SMSNotificationBuilder;
import com.saltatorv.notification.manager.domain.builder.sms.SMSNotificationRecipientStep;
import com.saltatorv.notification.manager.domain.builder.system.SystemNotificationBuilder;
import com.saltatorv.notification.manager.domain.builder.system.SystemNotificationRecipientStep;

public class NotificationBuilder implements NotificationChannelStep {

    private NotificationBuilder() {

    }

    public static NotificationBuilder buildNotification() {
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
