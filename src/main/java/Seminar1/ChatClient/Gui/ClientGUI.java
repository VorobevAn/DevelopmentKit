package Seminar1.ChatClient.Gui;

import Seminar1.ChatClient.server.DBClient;
import Seminar1.ChatClient.server.DBMessage;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ClientGUI extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;


    // Понель поключения к серверу.
    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private final JTextField tfIPAddress = new JTextField("127.1.1.0");
    private final JTextField tfPort = new JTextField("8189");
    private final JTextField empty = new JTextField();
    private final JTextField tfLogin = new JTextField("Vasiliy");    // установлен по умолчанию
    private final JPasswordField tfPassword = new JPasswordField("123");   // установлен по умолчанию
    private final JButton btnLogin = new JButton("login");


    // Понель отправки сообщения.
    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JTextField textField = new JTextField();
    private final JButton btnSend = new JButton("Send");
    private final JTextArea log = new JTextArea();
    private final JScrollPane scrollog = new JScrollPane(log);


    private static final DBMessage dbMessage = new DBMessage();
    private static final DBClient dbClient = new DBClient();



    public ClientGUI(ServerGUI serverGUI) {
        windowClient();
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (serverGUI.getServerWork()) {
                        if(authentication()){
                            serverGUI.logServer(tfLogin.getText(),"Подключился к серверу\n");
                            log.append(dbMessage.reedMessage());
                        }
                }else {
                    log.append("Сервер не запущен");
                }
            }
        });

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (serverGUI.getServerWork()) {
                    String message = tfLogin.getText() +": " + textField.getText();
                    dbMessage.saveMessage(message);
                    log.append(message);

                }else {
                    log.append("Сервер не запущен");
                }
            }
        });

    }


    public void windowClient() {
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
        add(scrollog);

        panelBottom.add(textField, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);
        add(panelBottom, BorderLayout.SOUTH);
        log.setEditable(false);
        setVisible(true);
    }

    /**
     * Аудентификация пользователя
     * @return
     * @throws IOException
     */
    public boolean authentication() {
        dbClient.addClient();
        if (dbClient.thereIsAClientInTheDatabase(tfLogin.getText())) {
            log.append(tfLogin.getText() + " Вы подключились к серверу\n");
            return true;
        } else {
            log.append("Ошибка. Неверный логин или пароль\n");
        }return false;

    }

}