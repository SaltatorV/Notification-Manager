package com.saltatorv.notification.manager.domain.exception;

import com.saltatorv.notification.manager.domain.Generated;

public abstract class DomainException extends RuntimeException {

    @Generated
    public abstract String getReason();
}
