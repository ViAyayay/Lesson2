package task_8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Timer;
import java.util.TimerTask;

public class ClientHandler {
    private MyServer myServer;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    private String name;

    public String getName(){
        return name;
    }

    public ClientHandler(MyServer myServer, Socket socket){
        try{
            this.myServer = myServer;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            this.name = "";
            socket.setSoTimeout(120*1000);
            new Thread(() ->{
                try {
                    authentication();
                    readMessages();
                }catch (InterruptedIOException e){
                    System.out.printf("пользователь %s отключён за неактивность\n", name);
                    sendMsg("/disconnect Вы отключены за неактивность");
                }catch (IOException e){
                    e.printStackTrace();
                }finally {
                    closeConnection();
                }
            }).start();
        }catch (IOException e){
            throw new RuntimeException("Проблемы при создании обработчика клиента");
        }
    }

    public void authentication() throws IOException{
        while (true){
            String str = in.readUTF();
            socket.setSoTimeout(120 * 1000);
            if(str.startsWith("/auth")){
                String[] parts = str.split("\\s");
                String nick = myServer.getAuthService().getNickByLoginPass(parts[1], parts[2]);
                if(nick!= null){
                    if(myServer.isNickFree(nick)){
                        sendMsg("/authok "+nick);
                        name = nick;
                        myServer.broadcastMsg(name+" звшел в чат");
                        myServer.subscribe(this);
                        return;
                    }else {
                        sendMsg("Учетная запись уже используется");
                    }
                }else {
                    sendMsg("Неверный логин/пароль");
                }
            }
        }
    }

    public void readMessages() throws IOException{
        while (true){
            String strFromClient = in.readUTF();
            socket.setSoTimeout(120*1000);
            if(strFromClient.startsWith("/")){
                if (strFromClient.equals("/end")){
                    break;
                }
                if ((strFromClient.startsWith("/w "))){
                    String[] tokens = strFromClient.split("\\s");
                    String nick = tokens[1];
                    String msg = strFromClient.substring(4 + nick.length());
                    myServer.sendPrivateMsg(this, nick, msg);
                }
                continue;
            }
            System.out.println("от " + name+": " + strFromClient);
            myServer.broadcastMsg(name  + ": " + strFromClient);
        }
    }

    public void sendMsg(String msg){
        try {
            out.writeUTF(msg);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void closeConnection(){
        myServer.unsubscribe(this);
        myServer.broadcastMsg(name + " вышел из чата");
        try{
            in.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        try{
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}