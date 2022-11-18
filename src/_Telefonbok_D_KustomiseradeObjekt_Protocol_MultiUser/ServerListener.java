package _Telefonbok_D_KustomiseradeObjekt_Protocol_MultiUser;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListener {

    public ServerListener() {

        try (ServerSocket serverSocket = new ServerSocket(44444)) {

            while (true) {

                Socket socket = serverSocket.accept();
                TCP_Server server = new TCP_Server(socket);
                server.start();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {

        ServerListener serverListener = new ServerListener();
    }
}
