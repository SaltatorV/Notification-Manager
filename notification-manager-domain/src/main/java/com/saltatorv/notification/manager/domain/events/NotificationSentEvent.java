package com.saltatorv.notification.manager.domain.events;

import com.saltatorv.notification.manager.domain.Generated;
import com.saltatorv.notification.manager.domain.NotificationId;

import java.time.Instant;

class NotificationSentEvent implements DomainEvent {
    private final NotificationId id;
    private final Instant occurredOn;

    public NotificationSentEvent(NotificationId id, Instant occurredOn) {
        this.id = id;
        this.occurredOn = occurredOn;
    }

    @Generated
    public NotificationId getId() {
        return id;
    }

    @Generated
    @Override
    public Instant getOccurredOn() {
        return occurredOn;
    }
}
