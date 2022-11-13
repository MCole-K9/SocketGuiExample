package org.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        System.out.println("Welcome Client!");
        Socket socket = new Socket("localhost", 4444);

        if(socket.isConnected()){
            System.out.println("You are connected to server!");
        }

        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());

        Message message = new Message("Matthew Cole","Main Server","Hello Main Server..... Hope you got the package", MessageType.MESSAGE);
        os.writeObject(new SocketData(message));

        System.out.println("Message sent to the server...");


        SocketData returnData = (SocketData) is.readObject();

        System.out.println(returnData);




        socket.close();

    }
}