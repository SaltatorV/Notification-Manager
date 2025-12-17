package com.saltatorv.notification.manager.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Notification {
    private final List<String> messages;

    public Notification() {
        messages = new ArrayList<>();
    }

    public void send(String notificationMessage) {
        messages.add(notificationMessage);
    }

    public List<String> getMessages() {
        return Collections.unmodifiableList(messages);
    }
}
