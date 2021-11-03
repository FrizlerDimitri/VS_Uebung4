import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientWriter implements Runnable {


    private Socket socket;


    public ClientWriter(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        while (!socket.isClosed() || socket != null) {
            try {

                OutputStream out= socket.getOutputStream();
                PrintWriter writer= new PrintWriter(out);

                Scanner scanner = new Scanner(System.in);
                String message= scanner.nextLine();

                writer.println(message);
                writer.flush();

            } catch (IOException e) {

                e.printStackTrace();
            }


        }




    }
}
