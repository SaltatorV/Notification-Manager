package com.saltatorv.notification.manager.domain.exception;

public class InvalidDeliveryAttemptsCountException extends DomainException {
    private final static String MESSAGE = "Max attempts counter must be positive number";

    public InvalidDeliveryAttemptsCountException() {
        super(MESSAGE);
    }

    public InvalidDeliveryAttemptsCountException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
