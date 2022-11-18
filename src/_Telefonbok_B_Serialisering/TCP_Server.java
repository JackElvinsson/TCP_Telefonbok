package _Telefonbok_B_Serialisering;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_Server {

    TCP_Database database = new TCP_Database();

    public TCP_Server() {

        try (ServerSocket serverSocket = new ServerSocket(44444);
             Socket socket = serverSocket.accept();
             ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            outputStream.writeObject("Welcome! Please type in a name;");

            String clientRequest;

            while ((clientRequest = bufferedReader.readLine()) != null) {

                TCP_Object dataBaseAnswer = database.search(clientRequest.trim());
                if (dataBaseAnswer != null) {
                    outputStream.writeObject(dataBaseAnswer);
                }
                else
                    outputStream.writeObject("The name could not be found in the phone book");
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        TCP_Server tcp_server = new TCP_Server();
    }
}
