package com.saltatorv.notification.manager.domain.attempt;

import com.saltatorv.notification.manager.domain.Generated;

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
        return new AttemptResult(AttemptStatus.SUCCESS, true, "", LocalDateTime.now());
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
    @Generated
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        AttemptResult that = (AttemptResult) o;
        return datetime.equals(that.datetime);
    }

    @Override
    @Generated
    public int hashCode() {
        int result = status.hashCode();
        result = 31 * result + Boolean.hashCode(wasSuccessful);
        result = 31 * result + exceptionMessage.hashCode();
        result = 31 * result + datetime.hashCode();
        return result;
    }
}
