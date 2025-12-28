package com.saltatorv.notification.manager.domain.shared;

import com.saltatorv.notification.manager.domain.channel.email.EmailNotificationRecipientStep;
import com.saltatorv.notification.manager.domain.channel.sms.SMSNotificationRecipientStep;
import com.saltatorv.notification.manager.domain.channel.system.SystemNotificationRecipientStep;

public interface NotificationChannelStep {

    SMSNotificationRecipientStep forSms();

    EmailNotificationRecipientStep forMail();

    SystemNotificationRecipientStep forSystem();

}
