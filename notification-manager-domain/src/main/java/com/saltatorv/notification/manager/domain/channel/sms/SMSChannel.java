package com.saltatorv.notification.manager.domain.channel.sms;

import com.saltatorv.notification.manager.domain.attempt.AttemptResult;
import com.saltatorv.notification.manager.domain.channel.Channel;

public class SMSChannel extends Channel {
    private final String recipient;
    private final String message;

    public SMSChannel(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
    }

    @Override
    public AttemptResult send() {
        return AttemptResult.createForSuccess();
    }
}
