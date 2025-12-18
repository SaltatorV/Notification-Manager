package com.saltatorv.notification.manager.domain;

class Notification {
    private final NotificationId id;
    private final String message;

    private boolean isSent;

    public Notification(String message) {
        this.id = NotificationId.generate();
        this.message = message;

        this.isSent = false;
    }

    public void send() {
        this.isSent = true;
    }

    public boolean isSent() {
        return isSent;
    }
}
