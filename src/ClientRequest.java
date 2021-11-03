import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientRequest implements Runnable {


    private Socket socket;

    public ClientRequest(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        while (!socket.isClosed()) {
            try {
                InputStream in = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String clientMessage = reader.readLine();
                useMessage(clientMessage);

            } catch (IOException e) {
            }
        }


    }


    private void useMessage(String clientMessage) {
        if (!clientMessage.contains("REG") && !clientMessage.contains("SND") && !clientMessage.contains("RCV")) {
            System.out.println("Can not use this input !");
            return;
        }

        if (clientMessage.contains("REG")) {
            String username = clientMessage.substring(3);
            MessageStore.regUser(username);
        }

        if (clientMessage.contains("SND")) {
            String fullSentMessage = clientMessage.substring(3);
            MessageStore.sentMessage(fullSentMessage);

        }

        if (clientMessage.contains("RCV")) {
            String username = clientMessage.substring(3);
            MessageStore.getAllMessagesByUser(username);

        }

        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
