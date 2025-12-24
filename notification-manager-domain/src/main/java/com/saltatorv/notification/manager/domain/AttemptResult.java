package com.saltatorv.notification.manager.domain;

import java.time.LocalDateTime;

public class AttemptResult {
    private final AttemptStatus status;
    private final boolean wasSuccessful;
    private final String exceptionMessage;
    private final LocalDateTime datetime;

    private AttemptResult(AttemptStatus status, boolean wasSuccessful, String exceptionMessage, LocalDateTime datetime) {
        this.status = status;
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

    public AttemptStatus getStatus() {
        return status;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        AttemptResult that = (AttemptResult) o;
        return wasSuccessful == that.wasSuccessful && status == that.status && exceptionMessage.equals(that.exceptionMessage) && datetime.equals(that.datetime);
    }

    @Override
    public int hashCode() {
        int result = status.hashCode();
        result = 31 * result + Boolean.hashCode(wasSuccessful);
        result = 31 * result + exceptionMessage.hashCode();
        result = 31 * result + datetime.hashCode();
        return result;
    }
}
