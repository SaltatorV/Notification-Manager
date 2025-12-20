package com.saltatorv.notification.manager.domain.builder.steps;

public interface NotificationChannelStep {

    SMSNotificationRecipientStep forSms();

    EmailNotificationStep forMail();

    SystemNotificationStep forSystem();

}
