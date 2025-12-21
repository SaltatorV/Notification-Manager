package com.saltatorv.notification.manager.domain;

class EmailChannel extends Channel {
    private final String recipient;
    private final String subject;
    private final String body;

    public EmailChannel(String recipient, String subject, String body) {
        this.recipient = recipient;
        this.subject = subject;
        this.body = body;
    }

    @Override
    void send() {
        System.out.println("Sending Email to " + recipient + ": " + subject + ": " + body);
    }
}
