package org.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int port = 4444;
    private ServerSocket ss = null;



    public void runServer() throws IOException {
        try {
            ss = new ServerSocket(port);
            System.out.println("Server is RUNNING!!");
            Socket socket = ss.accept();

            ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());


            SocketData data = (SocketData) is.readObject();





            SocketData socketData = new SocketData((new Message("Server", "Client", "Hello", MessageType.MESSAGE)));

            os.writeObject(socketData);






        } catch (Exception e) {

        }

    }

    public static void main (String[]args){
        try {
            new Server().runServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

