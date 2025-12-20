package com.saltatorv.notification.manager.domain.builder.steps.system;

import com.saltatorv.notification.manager.domain.builder.steps.shared.NotificationFinalStep;

public interface SystemNotificationMessageStep {

    NotificationFinalStep message(String message);
}
