package _Telefonbok_A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_Server {

    TCP_Database database = new TCP_Database();

    public TCP_Server() {

        try (ServerSocket serverSocket = new ServerSocket(44444);
             Socket socket = serverSocket.accept();
             PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            printWriter.println("Welcome! Please type in a name;");

            String clientRequest;

            while ((clientRequest = bufferedReader.readLine()) != null) {

                String dataBaseAnswer = database.search(clientRequest.trim());
                printWriter.println(dataBaseAnswer);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        TCP_Server tcp_server = new TCP_Server();
    }
}
