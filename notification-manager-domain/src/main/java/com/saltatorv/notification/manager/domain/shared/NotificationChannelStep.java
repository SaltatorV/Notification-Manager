package com.saltatorv.notification.manager.domain.shared;

import com.saltatorv.notification.manager.domain.email.EmailNotificationRecipientStep;
import com.saltatorv.notification.manager.domain.sms.SMSNotificationRecipientStep;
import com.saltatorv.notification.manager.domain.system.SystemNotificationRecipientStep;

public interface NotificationChannelStep {

    SMSNotificationRecipientStep forSms();

    EmailNotificationRecipientStep forMail();

    SystemNotificationRecipientStep forSystem();

}
