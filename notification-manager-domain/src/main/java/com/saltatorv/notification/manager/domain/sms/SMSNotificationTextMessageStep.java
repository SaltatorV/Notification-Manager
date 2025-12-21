package com.saltatorv.notification.manager.domain.sms;

import com.saltatorv.notification.manager.domain.shared.NotificationFinalStep;

public interface SMSNotificationTextMessageStep {

    NotificationFinalStep message(String message);
}
