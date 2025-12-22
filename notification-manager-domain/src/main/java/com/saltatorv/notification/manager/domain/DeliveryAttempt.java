package com.saltatorv.notification.manager.domain;

class DeliveryAttempt {
    private static final int MIN_ATTEMPTS_TO_SEND = 1;
    private static final int DEFAULT_ATTEMPTS_VALUE = 0;

    private final int maxAttemptsCounter;
    private int attempts;

    public DeliveryAttempt(int maxAttemptsCounter) {
        if (maxAttemptsCounter < MIN_ATTEMPTS_TO_SEND) {
            throw new RuntimeException("Max attempts counter must be positive number");
        }
        this.maxAttemptsCounter = maxAttemptsCounter;
        this.attempts = DEFAULT_ATTEMPTS_VALUE;
    }

    public void sendAttempt() {
        if (hasRemainingSendAttempts()) {
            this.attempts++;
        } else {
            throw new RuntimeException("Maximum number of attempts reached. Can not send this attempt.");
        }
    }

    public boolean hasRemainingSendAttempts() {
        return this.attempts < this.maxAttemptsCounter;
    }
}
