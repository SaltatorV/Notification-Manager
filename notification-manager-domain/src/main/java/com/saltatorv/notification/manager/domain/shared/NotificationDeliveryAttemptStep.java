package com.saltatorv.notification.manager.domain.shared;

public interface NotificationDeliveryAttemptStep {

    NotificationFinalStep maxDeliveryAttempts(int maxAttemptsCounter);
}
