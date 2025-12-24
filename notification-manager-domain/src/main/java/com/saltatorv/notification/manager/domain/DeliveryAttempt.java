package com.saltatorv.notification.manager.domain;

import java.util.HashSet;
import java.util.Set;

public class DeliveryAttempt {
    private static final int MIN_ATTEMPTS_TO_SEND = 1;

    private final int maxAttemptsCounter;
    private Set<AttemptResult> attemptResults;

    public DeliveryAttempt(int maxAttemptsCounter) {
        if (maxAttemptsCounter < MIN_ATTEMPTS_TO_SEND) {
            throw new RuntimeException("Max attempts counter must be positive number");
        }
        this.maxAttemptsCounter = maxAttemptsCounter;
        this.attemptResults = new HashSet<>(maxAttemptsCounter);
    }

    public boolean hasRemainingSendAttempts() {
        return canAttempt() && !wasSuccessful();
    }

    public void registerAttempt(AttemptResult attemptResult) {
        if (!hasRemainingSendAttempts()) {
            throw new RuntimeException("Maximum number of attempts reached. Can not send this attempt.");
        }

        if (attemptResults.contains(attemptResult)) {
            throw new RuntimeException("Attempt has already been registered.");
        }

        attemptResults.add(attemptResult);
    }

    public boolean wasSuccessful() {
        return attemptResults.stream()
                .anyMatch(attempt -> attempt.getStatus() == AttemptStatus.SUCCESS);
    }

    private boolean canAttempt() {
        return this.attemptResults.size() < this.maxAttemptsCounter;
    }
}
