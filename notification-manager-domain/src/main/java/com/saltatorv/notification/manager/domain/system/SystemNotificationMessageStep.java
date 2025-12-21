package com.saltatorv.notification.manager.domain.system;

import com.saltatorv.notification.manager.domain.shared.NotificationFinalStep;

public interface SystemNotificationMessageStep {

    NotificationFinalStep message(String message);
}
