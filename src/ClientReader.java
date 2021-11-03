import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReader implements Runnable {


    private Socket socket;

    public ClientReader(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {


        while (!socket.isClosed() || socket != null) {
            try {
                InputStream in = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                if(reader.readLine()!=null)
                {
                    String serverMessage = reader.readLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


        }


    }
}
