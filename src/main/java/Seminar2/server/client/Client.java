package Seminar2.server.client;

import Seminar2.server.server.Server;
import Seminar2.server.server.ServerWindow;

import java.net.ServerSocket;


public class Client {
    private String name;
    private ClientView clientView;
    private Server server;
    private boolean connected;

    public Client(Server server, ClientView clientView){
        this.server = server;
        this.clientView = clientView;
    }


    public boolean connectToServer(String name){
        this.name = name;
        if (server.connectUser(this)){
            printText("Вы успешно подключились!\n");
            connected = true;
            String log = server.history();
            if (log != null){
                printText(log);
            }
            return true;
        } else {
            printText("Подключение не удалось");
            return false;
        }
    }

    //мы посылаем
    public void sendMessage(String message){
        if (connected) {
            if (!message.isEmpty()) {
                server.sendMessage(name + ": " + message);
            }
        } else {
            printText("Нет подключения к серверу");
        }
    }
    //нам посылают
    public void answer(String answer){
        printText(answer);
    }

    public void disconnect(){
        if (connected) {
            connected = false;
            clientView.disconnectFromServer();
            server.disconnectUser(this);
            printText("Вы были отключены от сервера!");
        }
    }

    public String getName() {
        return name;
    }

    private void printText(String text){
        clientView.showMessage(text);
    }
}
