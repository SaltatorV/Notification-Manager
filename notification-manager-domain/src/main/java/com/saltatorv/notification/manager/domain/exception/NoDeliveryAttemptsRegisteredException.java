package com.saltatorv.notification.manager.domain.exception;

public class NoDeliveryAttemptsRegisteredException extends DomainException {
    private final static String MESSAGE = "No attempts have been registered.";

    public NoDeliveryAttemptsRegisteredException() {
        super(MESSAGE);
    }

    public NoDeliveryAttemptsRegisteredException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
