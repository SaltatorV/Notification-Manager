package com.saltatorv.notification.manager.domain;

public interface NotificationChannelStep {

    SMSNotificationStep forSms();

    EmailNotificationStep forMail();

    SystemNotificationStep forSystem();

}
