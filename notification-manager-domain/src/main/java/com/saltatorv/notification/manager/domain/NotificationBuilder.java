package com.saltatorv.notification.manager.domain;

import com.saltatorv.notification.manager.domain.channel.email.EmailNotificationBuilder;
import com.saltatorv.notification.manager.domain.channel.email.EmailNotificationRecipientStep;
import com.saltatorv.notification.manager.domain.shared.NotificationChannelStep;
import com.saltatorv.notification.manager.domain.channel.sms.SMSNotificationBuilder;
import com.saltatorv.notification.manager.domain.channel.sms.SMSNotificationRecipientStep;
import com.saltatorv.notification.manager.domain.channel.system.SystemNotificationBuilder;
import com.saltatorv.notification.manager.domain.channel.system.SystemNotificationRecipientStep;

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
