package com.saltatorv.notification.manager.domain.sms;

import com.saltatorv.notification.manager.domain.Channel;

public class SMSChannel extends Channel {
    private final String recipient;
    private final String message;

    public SMSChannel(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
    }

    @Override
    public void send() {
        System.out.println("Sending SMS to " + recipient + ": " + message);
    }
}
