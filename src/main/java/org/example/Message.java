package org.example;

enum MessageType {
    MESSAGE

}
public class Message implements java.io.Serializable {
    private String sender;
    private String receiver;
    private String message;


    private MessageType type;

    public Message(String sender, String receiver, String message, MessageType type) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.type = type;

    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message [sender=" + sender + ", receiver=" + receiver + ", message=" + message + "]";
    }

    public MessageType getType() {
        return type;
    }
}
