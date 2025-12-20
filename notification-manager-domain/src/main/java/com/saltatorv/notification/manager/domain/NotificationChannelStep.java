package com.saltatorv.notification.manager.domain;

public interface NotificationChannelStep {

    SMSNotificationRecipientStep forSms();

    EmailNotificationStep forMail();

    SystemNotificationStep forSystem();

}
