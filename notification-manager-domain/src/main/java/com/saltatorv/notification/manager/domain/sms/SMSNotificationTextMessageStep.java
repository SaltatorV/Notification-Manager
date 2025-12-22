package com.saltatorv.notification.manager.domain.sms;

import com.saltatorv.notification.manager.domain.shared.NotificationDeliveryAttemptStep;

public interface SMSNotificationTextMessageStep {

    NotificationDeliveryAttemptStep message(String message);
}
