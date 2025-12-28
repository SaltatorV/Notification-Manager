package com.saltatorv.notification.manager.domain.event;

import java.time.Instant;

public interface DomainEvent {
    Instant getOccurredOn();
    DomainEventId getDomainEventId();
}
