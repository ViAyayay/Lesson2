import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    private static String name = "Server";

    public static void main(String[] args) {
        runServer();
    }

    private static void runServer() {
        Socket socket;
        try (ServerSocket serverSocket = new ServerSocket(8081)){
            System.out.println("Сервер запущен, ожидаем подключение...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");

            InStream inputStream = new InStream(socket);
            OutStream outStream = new OutStream(socket, name);

            inputStream.start();
            outStream.start();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
