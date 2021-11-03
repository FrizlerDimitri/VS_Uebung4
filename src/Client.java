import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {


    public void startClient(int port, String host)
    {
        try {

            Socket socket = null;

            while (true)
            {



                if (socket==null || socket.isClosed())
                {
                    socket = new Socket(host, port);
                    System.out.println("connected to MessagingService");
                    ExecutorService executorService = Executors.newFixedThreadPool(2);
                    executorService.execute(new ClientReader(socket));
                    executorService.execute(new ClientWriter(socket));


                }

            }




        } catch (IOException e) {
            e.printStackTrace();
        }

    }









}
