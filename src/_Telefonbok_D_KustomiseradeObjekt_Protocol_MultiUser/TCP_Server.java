package _Telefonbok_D_KustomiseradeObjekt_Protocol_MultiUser;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_Server extends Thread {

    TCP_Database database = new TCP_Database();
    Protocol protocol = new Protocol();

        Socket socket;

        public TCP_Server(Socket socket) {

            this.socket = socket;

        }

    public void run() {


        try (ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())) {

            String inputLine;

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
}
