package com.saltatorv.notification.manager.domain.builder.steps.sms;

import com.saltatorv.notification.manager.domain.builder.steps.shared.NotificationFinalStep;

public interface SMSNotificationTextMessageStep {

    NotificationFinalStep message(String message);
}
