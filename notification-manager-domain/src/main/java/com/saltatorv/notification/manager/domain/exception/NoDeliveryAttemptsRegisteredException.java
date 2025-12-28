package com.saltatorv.notification.manager.domain.exception;

import com.saltatorv.notification.manager.domain.Generated;

@Generated
public class NoDeliveryAttemptsRegisteredException extends DomainException {
    private final static String MESSAGE = "No attempts have been registered.";

    public NoDeliveryAttemptsRegisteredException() {
        super(MESSAGE);
    }

    public NoDeliveryAttemptsRegisteredException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
