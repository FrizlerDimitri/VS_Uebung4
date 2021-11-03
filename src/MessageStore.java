import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageStore {

    private static Map <String, List<String>> store= new HashMap<String,List<String>>();

    public static void regUser(String user )
    {


        if(!store.keySet().contains(user))
        {
            List<String> list = new ArrayList<>();
            store.put(user,list);
        }
        System.out.println("You are registed as : "+user);

    }


    public static void sentMessage(String fullMessage )
    {
        String[] arr=fullMessage.split("#");

        if(arr.length != 3)
        {
            System.out.println("It didn't worked!");
            return;
        }

        String from=arr[0];
        String to =arr[1];
        String message=arr[2];

        if(!store.containsKey(to))
        {
            System.out.println(to + " doesn't exist in this System!");
        }
        store.get(to).add(message);
    }

    public static void getAllMessagesByUser(String user)
    {
       List<String> list = store.get(user);
        System.out.println(list.toString());
    }






}
