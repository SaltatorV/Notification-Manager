package com.saltatorv.notification.manager.domain.channel;

import com.saltatorv.notification.manager.domain.attempt.AttemptResult;

public abstract class Channel {

    public abstract AttemptResult send();
}
