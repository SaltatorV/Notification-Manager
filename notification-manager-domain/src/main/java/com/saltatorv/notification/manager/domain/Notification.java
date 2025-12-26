package com.saltatorv.notification.manager.domain;

import com.saltatorv.notification.manager.domain.attempt.AttemptResult;
import com.saltatorv.notification.manager.domain.attempt.Channel;
import com.saltatorv.notification.manager.domain.attempt.DeliveryAttempt;
import com.saltatorv.notification.manager.domain.events.DomainEvent;
import com.saltatorv.notification.manager.domain.events.NotificationSendFailureEvent;
import com.saltatorv.notification.manager.domain.events.NotificationSentEvent;

import java.time.Instant;
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

    public void send() {
        if (deliveryAttempt.hasRemainingSendAttempts()) {
            AttemptResult attemptResult = channel.send();
            deliveryAttempt.registerAttempt(attemptResult);
            if (deliveryAttempt.wasSuccessful()) {
                events.add(new NotificationSentEvent(id, Instant.now()));
            } else {
                events.add(new NotificationSendFailureEvent(id, Instant.now(), attemptResult.getExceptionMessage()));
            }
        }
    }

    public boolean isSent() {
        return deliveryAttempt.wasSuccessful();
    }

    public List<DomainEvent> pullDomainEvents() {
        List<DomainEvent> eventsToReturn = new ArrayList<>(events);
        events.clear();
        return eventsToReturn;
    }
}
