package Seminar1.ChatClient;

import Seminar1.ChatClient.Gui.ClientGUI;
import Seminar1.ChatClient.Gui.ServerGUI;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerGUI serverGUI = new ServerGUI();
        new ClientGUI(serverGUI);





    }

}
