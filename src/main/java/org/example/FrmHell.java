package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FrmHell {

    private JPanel pnlHell;
    private JTextArea textArea1;
    private JPanel txtAMessage;
    private JLabel lblHeader;
    private JButton btnSend;
    private JTextArea txtAMessages;
    private JScrollPane spMessages;

    public FrmHell() {
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Message message = new Message("Matthew", "Server", textArea1.getText(), MessageType.MESSAGE);
                try {

                    Client.connection.sendMesssage(message);

                    Message returnMessage = Client.connection.receiveMessage();

                    if(returnMessage.getType() == MessageType.MESSAGE){
                        txtAMessages.append(returnMessage.getSender() + ": " + returnMessage.getMessage() +"\n");
                    }

                    System.out.println("[ " + returnMessage.getSender() + " ] : " +returnMessage.getMessage());

                } catch (IOException ioException) {

                    ioException.printStackTrace();

                } catch (ClassNotFoundException ex) {

                    throw new RuntimeException(ex);
                }

                JOptionPane.showMessageDialog(null, "Hello World!");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Book Order System");
        frame.setContentPane(new FrmHell().pnlHell);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setVisible(true);

    }
}
