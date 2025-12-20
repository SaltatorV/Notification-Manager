package com.saltatorv.notification.manager.domain.builder.steps.email;

import com.saltatorv.notification.manager.domain.builder.steps.shared.NotificationFinalStep;

public interface EmailNotificationBodyStep {
    NotificationFinalStep body(String body);
}
