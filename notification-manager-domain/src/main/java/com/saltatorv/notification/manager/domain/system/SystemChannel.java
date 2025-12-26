package com.saltatorv.notification.manager.domain.system;

import com.saltatorv.notification.manager.domain.AttemptResult;
import com.saltatorv.notification.manager.domain.Channel;

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
