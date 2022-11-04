package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class MTSever {

    // Vector to store active clients
    public static Vector<ClientHandler> handlers = new Vector<>();

    // counter for clients
    static int i = 0;

    public static void main(String[] args) throws IOException
    {
        // server is listening on port 1234
        ServerSocket ss = new ServerSocket(1234);

        Socket socket;

        // running infinite loop for getting
        // client request
        while (true)
        {
            // Accept the incoming request
            socket = ss.accept();

            System.out.println("New client request received : " + socket);

            // obtain input and output streams
            ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());

            System.out.println("Creating a new handler for this client...");

            // Create a new handler object for handling this request.
            ClientHandler clientHandler = new ClientHandler(socket,"client " + i, is, os);

            // Create a new Thread with this object.
            Thread t = new Thread(clientHandler);

            System.out.println("Adding this client to active client list");

            // add this client to active clients list
            handlers.add(clientHandler);

            // start the thread.
            t.start();

            // increment i for new client.
            // i is used for naming only, and can be replaced
            // by any naming scheme
            i++;

        }
    }
}

