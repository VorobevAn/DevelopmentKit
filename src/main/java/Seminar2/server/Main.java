package Seminar2.server;

import Seminar2.server.client.ClientGUI;
import Seminar2.server.server.ServerWindow;


public class Main {
    public static void main(String[] args) {
        ServerWindow serverWindow = new ServerWindow();
        new ClientGUI(serverWindow);
        new ClientGUI(serverWindow);
    }
}

