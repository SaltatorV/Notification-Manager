package com.saltatorv.notification.manager.domain.attempt;

import com.saltatorv.notification.manager.domain.exception.InvalidDeliveryAttemptsCountException;
import com.saltatorv.notification.manager.domain.exception.DeliveryAttemptLimitExceededException;
import com.saltatorv.notification.manager.domain.exception.DuplicateDeliveryAttemptResultException;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class DeliveryAttempt {
    private static final int MIN_ATTEMPTS_TO_SEND = 1;

    private final int maxAttemptsCounter;
    private final Set<AttemptResult> attemptResults;

    public DeliveryAttempt(int maxAttemptsCounter) {
        if (maxAttemptsCounter < MIN_ATTEMPTS_TO_SEND) {
            throw new InvalidDeliveryAttemptsCountException();
        }
        this.maxAttemptsCounter = maxAttemptsCounter;
        this.attemptResults = new HashSet<>(maxAttemptsCounter);
    }

    public boolean hasRemainingSendAttempts() {
        return canAttempt() && !wasSuccessful();
    }

    public void registerAttempt(AttemptResult attemptResult) {
        if (!hasRemainingSendAttempts()) {
            throw new DeliveryAttemptLimitExceededException();
        }

        if (attemptResults.contains(attemptResult)) {
            throw new DuplicateDeliveryAttemptResultException();
        }
        attemptResults.add(attemptResult);
    }

    public boolean wasSuccessful() {
        return attemptResults.stream()
                .anyMatch(attempt -> attempt.getStatus() == AttemptStatus.SUCCESS);
    }

    public AttemptResult getLatestAttemptResult() {

        if (attemptResults.isEmpty()) {
            throw new RuntimeException("No attempts have been registered.");
        }

        return attemptResults.stream()
                .max(Comparator.comparing(AttemptResult::getDatetime)).get();
    }

    private boolean canAttempt() {
        return this.attemptResults.size() < this.maxAttemptsCounter;
    }
}
