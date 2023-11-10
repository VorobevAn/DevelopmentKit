package Seminar1.ChatClient.server;

import Seminar1.ChatClient.client.Client;

import java.util.ArrayList;
import java.util.List;

public class DBClient {
   List<Client> baseClient = new ArrayList<>();

    public List<Client> getBaseClient() {
        return baseClient;
    }
    public void addClient(){
        Client Vasiliy = new Client("Vasiliy","Vasiliy", 123);
        Client Oleg = new Client("Oleg","Oleg", 123);
        baseClient.add(Vasiliy);
        baseClient.add(Oleg);
    }

    /**
     * Проверка аудентификации пользователя.
     *
     * @param
     * @return
     */
    public boolean thereIsAClientInTheDatabase(String login) {
        for (int i = 0; i <baseClient.size(); i++) {
            System.out.println(baseClient.get(i).getLogin());
            if (baseClient.get(i).getLogin().equals(login)) {

                return true;
            }
        }
        return false;

    }



}
