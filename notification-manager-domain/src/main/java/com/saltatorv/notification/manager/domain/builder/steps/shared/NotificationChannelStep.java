package com.saltatorv.notification.manager.domain.builder.steps.shared;

import com.saltatorv.notification.manager.domain.builder.steps.email.EmailNotificationRecipientStep;
import com.saltatorv.notification.manager.domain.builder.steps.sms.SMSNotificationRecipientStep;
import com.saltatorv.notification.manager.domain.builder.steps.system.SystemNotificationStep;

public interface NotificationChannelStep {

    SMSNotificationRecipientStep forSms();

    EmailNotificationRecipientStep forMail();

    SystemNotificationStep forSystem();

}
