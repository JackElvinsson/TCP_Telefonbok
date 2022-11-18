package _Telefonbok_D_KustomiseradeObjekt_Protocol_MultiUser;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCP_Client {

    public TCP_Client() {

        try (Socket socket = new Socket("127.0.0.1", 44444);
             ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())) {

            Object messageFromServer = "";
            String messageFromUser = "";
            BufferedReader readUser = new BufferedReader(new InputStreamReader(System.in));


            while ((messageFromServer = inputStream.readObject()) != null) {

                if (messageFromServer instanceof Initiator) {
                    System.out.println("Connection complete");

                } else if (messageFromServer instanceof Response) {
                    if (!((Response) messageFromServer).getSuccess()) {
                        System.out.println("That name does not exist in the database");

                    } else {
                        System.out.println(((Response) messageFromServer).getPerson().getAdress());
                    }
                }
                System.out.println("What name would you like to look up?");
                messageFromUser = readUser.readLine();

                if (messageFromUser != null) {
                    outputStream.writeObject(messageFromUser);
                }
            }


        } catch (
                UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        } catch (
                ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {

        TCP_Client tcp_client = new TCP_Client();
    }

}
