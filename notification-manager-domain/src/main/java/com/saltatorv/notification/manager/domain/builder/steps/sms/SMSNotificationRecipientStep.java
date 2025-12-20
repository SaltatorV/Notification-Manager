package com.saltatorv.notification.manager.domain.builder.steps.sms;

import com.saltatorv.notification.manager.domain.builder.steps.shared.NotificationTextMessageStep;

public interface SMSNotificationRecipientStep {

    NotificationTextMessageStep recipient(String recipient);
}
