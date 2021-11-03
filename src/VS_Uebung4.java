


public class VS_Uebung4 {

    public static void main(String[] args) {



        String host= "localhost";
        int port = 8090;


        MessagingService s = new MessagingService();

        new Thread( () -> s.startServer(port)).start();

        // Client c =new Client();
       // c.startClient(port,host);

//        Client c2 =new Client();
//        c2.startClient(port,host);




    }

}
