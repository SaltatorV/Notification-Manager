package com.saltatorv.notification.manager.domain.builder.sms;

import com.saltatorv.notification.manager.domain.builder.shared.NotificationFinalStep;

public interface SMSNotificationTextMessageStep {

    NotificationFinalStep message(String message);
}
