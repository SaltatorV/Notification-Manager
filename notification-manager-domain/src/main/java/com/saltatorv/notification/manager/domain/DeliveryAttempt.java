package com.saltatorv.notification.manager.domain;

class DeliveryAttempt {
    private final int maxAttemptsCounter;
    private int attempts;

    public DeliveryAttempt(int maxAttemptsCounter) {
        if(maxAttemptsCounter < 1) {
            throw new RuntimeException("Max attempts counter must be positive number");
        }
        this.maxAttemptsCounter = maxAttemptsCounter;
        this.attempts = 0;
    }

    public void sendAttempt() {
        if(hasRemainingSendAttempts()) {
            this.attempts += 1;
        }
        else {
            throw new RuntimeException("Maximum number of attempts reached. Can not send this attempt.");
        }
    }

    public boolean hasRemainingSendAttempts() {
        return this.attempts < this.maxAttemptsCounter;
    }
}
