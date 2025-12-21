package com.saltatorv.notification.manager.domain;

public class Notification {
    private final NotificationId id;
    private final Channel channel;

    private boolean isSent;

    public Notification(Channel channel) {
        this.id = NotificationId.generate();
        this.channel = channel;

        this.isSent = false;
    }

    public void send() {
        channel.send();
        this.isSent = true;
    }

    public boolean isSent() {
        return isSent;
    }
}
