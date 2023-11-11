package Seminar2.server.server;


import Seminar2.server.client.Client;
import Seminar2.server.repository.IRepo;

import java.util.ArrayList;
import java.util.List;

public class Server {

    private final List<Client> clientList = new ArrayList<>();
    private final IServerView iServerView;
    private IRepo iRepo;


   private boolean work;

    public Server(IServerView iServerView, IRepo iRepo) {
        this.iServerView = iServerView;
        this.iRepo = iRepo;

    }

    public boolean isWork() {
        return work;
    }
    public void setWork(boolean work) {
        this.work = work;
    }


    public boolean connectUser(Client client){
        if (!work){
            return false;
        }
        clientList.add(client);
        return true;
    }
    public void sendMessage(String text){
        if (!work){
            return;
        }
//        text += "";
        iServerView.appendLog(text);
        answerAll(text);
        iRepo.saveInLog(text);
    }
    /**
     * Отправка сообщения всем пользователям
     * @param text
     */
    private void answerAll(String text){
        for (Client client: clientList){
            client.answer(text);
        }
    }
   public String History(){
       return iRepo.getHistory();
    }

    public void disconnectUser(Client client){
        clientList.remove(client);
        if (client != null){
            client.disconnect();
        }
    }

}
