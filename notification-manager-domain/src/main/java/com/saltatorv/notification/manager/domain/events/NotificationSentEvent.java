package com.saltatorv.notification.manager.domain.events;

import com.saltatorv.notification.manager.domain.Generated;
import com.saltatorv.notification.manager.domain.NotificationId;

import java.time.Instant;

public class NotificationSentEvent implements DomainEvent {
    private final DomainEventId domainEventId;
    private final NotificationId notificationId;
    private final Instant occurredOn;

    private NotificationSentEvent(NotificationId notificationId, Instant occurredOn) {
        this.domainEventId = DomainEventId.generate();
        this.notificationId = notificationId;
        this.occurredOn = occurredOn;
    }

    @Generated
    public static DomainEvent generate(NotificationId id) {
        return new NotificationSentEvent(id, Instant.now());
    }

    @Generated
    @Override
    public DomainEventId getDomainEventId() {
        return domainEventId;
    }

    @Generated
    public NotificationId getNotificationId() {
        return notificationId;
    }

    @Generated
    @Override
    public Instant getOccurredOn() {
        return occurredOn;
    }
}
