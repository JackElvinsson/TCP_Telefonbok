package _Telefonbok_A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCP_Client {

    public TCP_Client() {

        try (Socket socket = new Socket("127.0.0.1", 44444);
             PrintWriter printOut = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader readIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader readUser = new BufferedReader(new InputStreamReader(System.in))) {

            String messageFromServer = "";
            String messageFromUser = "";

            messageFromServer = readIn.readLine();
            System.out.println(messageFromServer);


            // Läser in välkomstmeddelande från server och lägger sig i en loop
            // Låter användaren skriva in ett regnummer
            // Läser in svaret och lägger sig och väntar på input igen
            while ((messageFromUser = readUser.readLine()) != null) {
                printOut.println(messageFromUser);
                System.out.println("Sent to server: " + messageFromUser);

                messageFromServer = readIn.readLine();
                System.out.println(messageFromServer);
            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        TCP_Client tcp_client = new TCP_Client();
    }

}
