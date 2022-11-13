package org.example;


import java.io.File;

enum SocketDataType {
    STRING,
    INTEGER,
    FILE
}
public class SocketData <T> implements java.io.Serializable {
    private SocketDataType type;
    private T data;

    public SocketData(T data) {

        this.data = data;

        if (data.getClass().equals(String.class)) {

            type = SocketDataType.STRING;
        }
        else if (data.getClass().equals(Integer.class)) {
            type = SocketDataType.INTEGER;
        }
        else if (data.getClass().equals(File.class)) {

            type = SocketDataType.FILE;
        }

        //Add more types checks here using else if


    }


    public SocketDataType getType() {
        return type;
    }

    //get data
    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "SocketData{" +
                "type=" + type +
                ", data=" + data +
                '}';
    }
}
