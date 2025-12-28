package com.saltatorv.notification.manager.domain.channel.email;

import com.saltatorv.notification.manager.domain.attempt.AttemptResult;
import com.saltatorv.notification.manager.domain.channel.Channel;

public class EmailChannel extends Channel {
    private final String recipient;
    private final String subject;
    private final String body;

    public EmailChannel(String recipient, String subject, String body) {
        this.recipient = recipient;
        this.subject = subject;
        this.body = body;
    }

    @Override
    public AttemptResult send() {
        return AttemptResult.createForSuccess();
    }
}
