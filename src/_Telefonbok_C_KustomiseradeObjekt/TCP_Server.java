package _Telefonbok_C_KustomiseradeObjekt;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_Server {

    TCP_Database database = new TCP_Database();

    public TCP_Server() {

        try (ServerSocket serverSocket = new ServerSocket(44444);
             Socket socket = serverSocket.accept();
             ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())) {

            Object inputLine;
            TCP_Object outputPerson;

            outputStream.writeObject(new Initiator());

            while ((inputLine = inputStream.readObject()) != null) {

                outputPerson = database.search(((String) inputLine).trim());

                if (outputPerson == null) {
                    outputStream.writeObject(new Response(false));

                } else {
                    outputStream.writeObject(new Response(true, outputPerson));
                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        TCP_Server tcp_server = new TCP_Server();
    }
}
