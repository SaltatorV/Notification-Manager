package com.saltatorv.notification.manager.domain.exception;

public class DeliveryAttemptInvalidMaxAttemptsCounter extends DomainException {
    private final static String MESSAGE = "Max attempts counter must be positive number";

    public DeliveryAttemptInvalidMaxAttemptsCounter() {
        super(MESSAGE);
    }

    public DeliveryAttemptInvalidMaxAttemptsCounter(Throwable cause) {
        super(MESSAGE, cause);
    }
}
