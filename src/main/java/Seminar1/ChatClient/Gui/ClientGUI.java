package Seminar1.ChatClient;

import Seminar1.ChatClient.client.Client;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientGUI extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;


    private final JTextArea log = new JTextArea();
    // Понель поключения к серверу.
    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private final JTextField tfIPAddress = new JTextField("127.1.1.0");
    private final JTextField tfPort = new JTextField("8189");
    private final JTextField empty = new JTextField();
    private final JTextField tfLogin = new JTextField("ivan13/Igorevich");
    private final JPasswordField tfPassword = new JPasswordField("1982cfA");
    private final JButton btnLogin = new JButton("login");

    // Понель отправки сообщения.
    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JTextField textField = new JTextField();
    private final JButton btnSend = new JButton("Send");

    private static Client client;

    ClientGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setTitle("Chat Client");
        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(empty);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        add(panelTop, BorderLayout.NORTH);

        panelBottom.add(textField, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);
        add(panelBottom, BorderLayout.SOUTH);

        log.setEditable(false);
        JScrollPane scrollog = new JScrollPane();
        add(scrollog);

        setVisible(true);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.getName();
            }
        });
    }
    public void settingsWindow(){
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Chat server");
        setAlwaysOnTop(true);

        // Добавление окна сообщений
        JScrollPane scrollog = new JScrollPane();
        add(scrollog);

        // Добавление кнопок нижней панели
        buttons.add(btnStart);
        buttons.add(btnStop);
        add(buttons, BorderLayout.SOUTH);
    }
}