package com.saltatorv.notification.manager.domain;

import com.saltatorv.notification.manager.domain.attempt.AttemptResult;
import com.saltatorv.notification.manager.domain.attempt.Channel;
import com.saltatorv.notification.manager.domain.attempt.DeliveryAttempt;

public class Notification {
    private final NotificationId id;
    private final Channel channel;
    private final DeliveryAttempt deliveryAttempt;


    public Notification(Channel channel, DeliveryAttempt deliveryAttempt) {
        this.id = NotificationId.generate();
        this.deliveryAttempt = deliveryAttempt;
        this.channel = channel;
    }

    public void send() {
        if (deliveryAttempt.hasRemainingSendAttempts()) {
            AttemptResult attemptResult = channel.send();
            deliveryAttempt.registerAttempt(attemptResult);
        }
    }

    public boolean isSent() {
        return deliveryAttempt.wasSuccessful();
    }
}
