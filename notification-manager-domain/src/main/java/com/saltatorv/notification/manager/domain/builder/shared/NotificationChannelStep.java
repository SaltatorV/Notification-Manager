package com.saltatorv.notification.manager.domain.builder.shared;

import com.saltatorv.notification.manager.domain.builder.email.EmailNotificationRecipientStep;
import com.saltatorv.notification.manager.domain.builder.sms.SMSNotificationRecipientStep;
import com.saltatorv.notification.manager.domain.builder.system.SystemNotificationRecipientStep;

public interface NotificationChannelStep {

    SMSNotificationRecipientStep forSms();

    EmailNotificationRecipientStep forMail();

    SystemNotificationRecipientStep forSystem();

}
