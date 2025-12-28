package com.saltatorv.notification.manager.domain.exception;

import com.saltatorv.notification.manager.domain.Generated;

@Generated
public class InvalidDeliveryAttemptsCountException extends DomainException {
    private final static String MESSAGE = "Max attempts counter must be positive number";

    public InvalidDeliveryAttemptsCountException() {
        super(MESSAGE);
    }

    public InvalidDeliveryAttemptsCountException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
