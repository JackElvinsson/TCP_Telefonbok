package _Telefonbok_D_KustomiseradeObjekt_Protocol;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_Server {

    TCP_Database database = new TCP_Database();

    public TCP_Server() {

        try (ServerSocket serverSocket = new ServerSocket(44444);
             Socket socket = serverSocket.accept();
             ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())) {

            String inputLine;
            Protocol protocol = new Protocol();
            outputStream.writeObject(protocol.getOutput(null));

            while ((inputLine = (String) inputStream.readObject()) != null) {

                outputStream.writeObject(protocol.getOutput(inputLine));
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
