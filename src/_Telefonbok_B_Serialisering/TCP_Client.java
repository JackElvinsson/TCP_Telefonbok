package _Telefonbok_B_Serialisering;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCP_Client {

    public TCP_Client() {

        try (Socket socket = new Socket("127.0.0.1", 44444);
             PrintWriter printOut = new PrintWriter(socket.getOutputStream(), true);
             ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
             BufferedReader readUser = new BufferedReader(new InputStreamReader(System.in))) {

            Object messageFromServer = "";
            String messageFromUser = "";

            messageFromServer = inputStream.readObject();
            System.out.println(messageFromServer);




            // Läser in välkomstmeddelande från server och lägger sig i en loop
            // Låter användaren skriva in ett regnummer
            // Läser in svaret och lägger sig och väntar på input igen
            while ((messageFromUser = readUser.readLine()) != null) {
                printOut.println(messageFromUser);
                System.out.println("Sent to server: " + messageFromUser);

                messageFromServer = inputStream.readObject();

                if (messageFromServer instanceof TCP_Object tcp_object) {
                    System.out.println(tcp_object.getName() + ", " + tcp_object.getAge() + ", " + "phone number: " + tcp_object.getNumber() + ", " + "Adress: " + tcp_object.getAdress());
                }
//                System.out.println(messageFromServer);
            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        TCP_Client tcp_client = new TCP_Client();
    }

}
