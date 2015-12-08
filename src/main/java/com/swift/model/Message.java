package com.swift.model;

import java.util.List;

public class Message {

    private final List<String> recipients;
    private final String message;

    public Message(final List<String> recipients, final String message) {
        this.recipients = recipients;
        this.message = message;
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "recipients=" + recipients +
                ", message='" + message + '\'' +
                '}';
    }
}
