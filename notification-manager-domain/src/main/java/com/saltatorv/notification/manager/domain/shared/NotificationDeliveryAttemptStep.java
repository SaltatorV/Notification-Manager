package com.saltatorv.notification.manager.domain.shared;

interface NotificationDeliveryAttemptStep {

    NotificationFinalStep maxDeliveryAttempts(int maxAttemptsCounter);
}
