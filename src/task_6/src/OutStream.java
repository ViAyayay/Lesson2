import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class OutStream extends Thread{
    private final Socket socket;
    private String name;

    public OutStream(Socket socket, String name) {
        this.name = name;
        this.socket = socket;
    }

    @Override
    public void run() {
        try (DataOutputStream out = new DataOutputStream(socket.getOutputStream());
             Scanner sc = new Scanner(System.in)){
            while (true){
                String str = sc.next();
                out.writeUTF(String.format("%s send: %s", name, str));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
