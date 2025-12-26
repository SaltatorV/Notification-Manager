package com.saltatorv.notification.manager.domain.events;

import com.saltatorv.notification.manager.domain.Generated;

import java.util.UUID;

public class DomainEventId {
    private final String id;

    private DomainEventId() {
        this.id = UUID.randomUUID().toString();
    }

    @Generated
    public static DomainEventId generate() {
        return new DomainEventId();
    }

    @Generated
    public String getId() {
        return id;
    }
}
