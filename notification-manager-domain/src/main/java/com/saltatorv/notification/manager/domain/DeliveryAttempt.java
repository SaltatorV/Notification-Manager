package com.saltatorv.notification.manager.domain;

class DeliveryAttempt {
    private final int maxAttemptsCounter;
    private int attempts;

    public DeliveryAttempt(int maxAttemptsCounter) {
        this.maxAttemptsCounter = maxAttemptsCounter;
        this.attempts = 0;
    }

    public void sendAttempt() {
        this.attempts++;
    }

    public boolean hasRemainingSendAttempts() {
        return this.attempts < this.maxAttemptsCounter;
    }
}
