package org.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

    public static class connection{
        static Socket socket ;
        static ObjectOutputStream os;
        static ObjectInputStream is;

        static{

            try {
                socket =  new Socket("localhost", 4444);
//                socket =  new Socket("localhost", 1234);
                os = new ObjectOutputStream(socket.getOutputStream());
                is = new ObjectInputStream(socket.getInputStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        public static void sendMesssage(Message message) throws IOException {
            os.writeObject(message);
        }

        public static Message receiveMessage() throws IOException, ClassNotFoundException {
            return (Message) is.readObject();
        }

    }
}
