package com.saltatorv.notification.manager.domain.events;

import com.saltatorv.notification.manager.domain.Generated;
import com.saltatorv.notification.manager.domain.NotificationId;

import java.time.Instant;

public class NotificationSendFailureEvent implements DomainEvent {
    private final DomainEventId domainEventId;
    private final NotificationId notificationId;
    private final Instant occurredOn;
    private final String reason;

    private NotificationSendFailureEvent(NotificationId notificationId, Instant occurredOn, String reason) {
        this.domainEventId = DomainEventId.generate();
        this.notificationId = notificationId;
        this.occurredOn = occurredOn;
        this.reason = reason;
    }

    @Generated
    public static DomainEvent generate(NotificationId id, String exceptionMessage) {
        return new  NotificationSendFailureEvent(id, Instant.now(), exceptionMessage);
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

    @Generated
    public String getReason() {
        return reason;
    }
}
