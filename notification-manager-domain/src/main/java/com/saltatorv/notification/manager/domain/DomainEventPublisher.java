package com.saltatorv.notification.manager.domain;

public interface DomainEventPublisher {
    void publish(DomainEvent event);
}
