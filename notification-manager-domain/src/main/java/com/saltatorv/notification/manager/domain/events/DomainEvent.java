package com.saltatorv.notification.manager.domain.events;

import java.time.Instant;

public interface DomainEvent {
    Instant getOccurredOn();
    DomainEventId getDomainEventId();
}
