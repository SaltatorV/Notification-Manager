package com.saltatorv.notification.manager.domain.email;

import com.saltatorv.notification.manager.domain.shared.NotificationFinalStep;

public interface EmailNotificationBodyStep {
    NotificationFinalStep body(String body);
}
