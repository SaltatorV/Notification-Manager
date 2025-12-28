package com.saltatorv.notification.manager.domain.exception;

public class DuplicateDeliveryAttemptResultException extends DomainException {
    private final static String MESSAGE = "Attempt has already been registered.";

    public DuplicateDeliveryAttemptResultException() {
        super(MESSAGE);
    }

    public DuplicateDeliveryAttemptResultException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
