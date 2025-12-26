package com.saltatorv.notification.manager.domain;

import com.saltatorv.notification.manager.domain.attempt.AttemptResult;
import com.saltatorv.notification.manager.domain.attempt.Channel;
import com.saltatorv.notification.manager.domain.attempt.DeliveryAttempt;
import com.saltatorv.notification.manager.domain.events.DomainEvent;

import java.util.ArrayList;
import java.util.List;

public class Notification {
    private final NotificationId id;
    private final Channel channel;
    private final DeliveryAttempt deliveryAttempt;

    private final List<DomainEvent> events;

    private Notification(Channel channel, DeliveryAttempt deliveryAttempt, List<DomainEvent> events) {
        this.id = NotificationId.generate();
        this.deliveryAttempt = deliveryAttempt;
        this.channel = channel;
        this.events = events;
    }

    public static Notification create(Channel channel, DeliveryAttempt deliveryAttempt) {
        return new Notification(channel, deliveryAttempt, new ArrayList<>());
    }

    public static Notification restore(Channel channel, DeliveryAttempt deliveryAttempt) {
        return new Notification(channel, deliveryAttempt, new ArrayList<>());
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
