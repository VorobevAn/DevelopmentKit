package Seminar2.server.Registry;

import Seminar1.ChatClient.Gui.ServerGUI;
import Seminar2.server.server.ServerWindow;

import javax.swing.*;
import java.awt.*;

public class RegistryGUI extends JFrame {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;

    private JTextArea log;
    private JTextField tfIPAddress, tfPort, tfLogin, tfMessage;
    private JPasswordField password;
    private JButton btnLogin, btnRegistry, btnSend;
    private JPanel headerPanel;

    public RegistryGUI(ServerWindow serverWindow) {
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat client");
        setLocation(serverWindow.getX() - 500, serverWindow.getY());

        createPanel();

        setVisible(true);
    }
    public void createPanel(){

    }
}
