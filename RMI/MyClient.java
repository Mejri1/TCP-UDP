import java.rmi.Naming;

public class MyClient {
    public static void main(String[] args) {
        try {
            MyInterface obj = (MyInterface) Naming.lookup("//localhost/MyServer");
            String response = obj.performAction("Hello from client");
            System.out.println("Response from server: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
