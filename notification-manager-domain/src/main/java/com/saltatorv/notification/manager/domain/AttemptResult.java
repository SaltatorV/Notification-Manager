package com.saltatorv.notification.manager.domain;

import java.time.LocalDateTime;

public class AttemptResult {
    private final AttemptStatus attemptStatus;
    private final boolean wasSuccessful;
    private final String exceptionMessage;
    private final LocalDateTime datetime;

    private AttemptResult(AttemptStatus attemptStatus, boolean wasSuccessful, String exceptionMessage, LocalDateTime datetime) {
        this.attemptStatus = attemptStatus;
        this.wasSuccessful = wasSuccessful;
        this.exceptionMessage = exceptionMessage;
        this.datetime = datetime;
    }

    public static AttemptResult createForSuccess() {
        return new AttemptResult(AttemptStatus.SUCCESS, true, null, LocalDateTime.now());
    }

    public static AttemptResult createForFailure(String exceptionMessage) {
        return new AttemptResult(AttemptStatus.FAILED, false, exceptionMessage, LocalDateTime.now());
    }

    public AttemptStatus getAttemptStatus() {
        return attemptStatus;
    }

    public boolean isWasSuccessful() {
        return wasSuccessful;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }
}
