package com.saltatorv.notification.manager.domain;

public interface NotificationChannelStep {

    void forSms();
    void forMail();
    void forSystem();

}
