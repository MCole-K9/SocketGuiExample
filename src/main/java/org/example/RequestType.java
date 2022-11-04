package org.example;

public class RequestType {

    private boolean MESSAGE = false;

    public RequestType(Class<?> cls) {

        if (cls.equals(Message.class)) {
            MESSAGE = true;
        }
    }

    public boolean isMessage() {
        return MESSAGE;
    }


    @Override
    public String toString() {
        return "RequestType{" +
                "MESSAGE=" + MESSAGE +
                '}';
    }
}
