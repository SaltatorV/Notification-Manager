package com.saltatorv.notification.manager.domain.builder.email;

import com.saltatorv.notification.manager.domain.builder.shared.NotificationFinalStep;

public interface EmailNotificationBodyStep {
    NotificationFinalStep body(String body);
}
