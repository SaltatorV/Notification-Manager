package com.saltatorv.notification.manager.domain.channel.email;

import com.saltatorv.notification.manager.domain.shared.NotificationDeliveryAttemptStep;

public interface EmailNotificationBodyStep {
    NotificationDeliveryAttemptStep body(String body);
}
