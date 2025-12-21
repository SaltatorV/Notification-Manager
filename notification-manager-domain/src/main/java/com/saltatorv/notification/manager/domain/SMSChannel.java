package com.saltatorv.notification.manager.domain;

class SMSChannel extends Channel {
    private final String recipient;
    private final String message;

    public SMSChannel(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
    }

    @Override
    void send() {
        System.out.println("Sending SMS to " + recipient + ": " + message);
    }
}
