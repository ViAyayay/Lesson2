import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class InStream extends Thread{
    private final Socket socket;

    public InStream(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (DataInputStream in = new DataInputStream(socket.getInputStream())){
            while (true){
                System.out.println(in.readUTF());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
