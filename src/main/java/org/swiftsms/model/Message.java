package org.swiftsms.model;

import java.util.List;
import java.util.Set;

public class Message {

    private int id;
    private Set<Contact> recipients;
    private String message;

    public Message() {
    }

    public Message(final Set<Contact> recipients, final String message) {
        this.recipients = recipients;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Contact> getRecipients() {
        return recipients;
    }

    public void setRecipients(Set<Contact> recipients) {
        this.recipients = recipients;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "recipients=" + recipients +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message1 = (Message) o;

        if (id != message1.id) return false;
        if (recipients != null ? !recipients.equals(message1.recipients) : message1.recipients != null) return false;
        return !(message != null ? !message.equals(message1.message) : message1.message != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (recipients != null ? recipients.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }
}
