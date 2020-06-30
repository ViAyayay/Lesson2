import java.io.IOException;
import java.net.Socket;

public class MainClient {
    private static final String SERVER_ADDR = "localhost";
    private static final int SERVER_PORT = 8081;
    private static Socket socket;
    private static String name = "Client";

    public static void main(String[] args) throws IOException {
        runClient();
    }

    private static void runClient() throws IOException {
        socket = new Socket(SERVER_ADDR, SERVER_PORT);
        InStream inputStream = new InStream(socket);
        OutStream outStream = new OutStream(socket, name);

        outStream.start();
        inputStream.start();

    }
}
