package com.saltatorv.notification.manager.domain.events;

public interface DomainEventPublisher {
    void publish(DomainEvent event);
}
