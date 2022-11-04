package org.example;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

class ClientHandler implements Runnable
{
    Scanner scn = new Scanner(System.in);
    private String name;
    final ObjectInputStream is;
    final ObjectOutputStream os;
    Socket s;
    boolean isloggedin;

    // constructor
    public ClientHandler(Socket s, String name, ObjectInputStream is, ObjectOutputStream os) {
        this.is = is;
        this.os = os;
        this.s = s;
        this.isloggedin=true;
    }

    @Override
    public void run() {

        Message received;
        while (true)
        {
            try
            {
                // receive the message sent from the client
                received = (Message) is.readObject();

                System.out.println(received);
                if(received.getMessage().equals("logout")){
                    this.isloggedin=false;
                    this.s.close();
                    break;
                }



                name = received.getSender();
                
                // search for the recipient in the connected devices list.
                // ar is the vector storing client of active users

                for (ClientHandler clientHandler : MTSever.handlers)
                {
                    // if the recipient is found, write on its

                    // output stream
                    if (clientHandler.name.equals(received.getSender()) && clientHandler.isloggedin==true)
                    {
                        clientHandler.os.writeObject(new Message("MTServer", received.getSender(), "Message received", MessageType.MESSAGE));
                        break;
                    }
                }
            } catch (IOException | ClassNotFoundException e) {

                e.printStackTrace();
            }

        }
        try
        {
            // closing resources
            this.is.close();
            this.os.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
