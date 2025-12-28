package com.saltatorv.notification.manager.domain.channel.sms;

import com.saltatorv.notification.manager.domain.shared.NotificationDeliveryAttemptStep;

public interface SMSNotificationTextMessageStep {

    NotificationDeliveryAttemptStep message(String message);
}
