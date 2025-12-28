package com.saltatorv.notification.manager.domain.channel.system;

import com.saltatorv.notification.manager.domain.shared.NotificationDeliveryAttemptStep;

public interface SystemNotificationMessageStep {

    NotificationDeliveryAttemptStep message(String message);
}
