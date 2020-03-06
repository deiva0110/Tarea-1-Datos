import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) {
        boolean active = true;
        try {
            ServerSocket serverSocket = new ServerSocket(40000);
            while(active) {
                System.out.println("Listening...");
                Socket entering = serverSocket.accept();

                BufferedReader lector = new BufferedReader(
                        new InputStreamReader(entering.getInputStream()));
                String mensaje =lector.readLine();
                System.out.println("Message Received: " + mensaje);
                entering.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
