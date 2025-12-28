package com.saltatorv.notification.manager.domain.channel.system;

import com.saltatorv.notification.manager.domain.attempt.AttemptResult;
import com.saltatorv.notification.manager.domain.channel.Channel;

public class SystemChannel extends Channel {
    private final String recipient;
    private final String message;

    public SystemChannel(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
    }

    @Override
    public AttemptResult send() {
        return AttemptResult.createForSuccess();
    }
}
