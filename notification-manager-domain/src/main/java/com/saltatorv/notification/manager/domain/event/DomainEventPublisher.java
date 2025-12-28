package com.saltatorv.notification.manager.domain.event;

public interface DomainEventPublisher {
    void publish(DomainEvent event);
}
