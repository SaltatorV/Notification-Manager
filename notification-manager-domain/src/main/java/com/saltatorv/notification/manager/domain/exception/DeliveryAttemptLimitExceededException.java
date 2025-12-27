package com.saltatorv.notification.manager.domain.exception;

public class DeliveryAttemptLimitExceededException extends DomainException {
    private final static String MESSAGE = "Maximum number of attempts reached. Can not send this attempt.";

    public DeliveryAttemptLimitExceededException() {
        super(MESSAGE);
    }

    public DeliveryAttemptLimitExceededException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
