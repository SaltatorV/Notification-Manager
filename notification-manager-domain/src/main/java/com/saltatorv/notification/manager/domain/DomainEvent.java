package com.saltatorv.notification.manager.domain;

import java.time.Instant;

public interface DomainEvent {
    Instant occurredOn();
}
