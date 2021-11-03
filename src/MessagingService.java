import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessagingService {


    public void startServer(int port) {

        try (ServerSocket serverSocket = new ServerSocket(port);) {
            System.out.println("MessagingService is running on port : " + port);

            while (true)
            {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                new Thread(new ClientRequest(socket)).start();

            }







        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
