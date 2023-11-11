package Seminar2.server.server;

import Seminar2.server.repository.Workrepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerWindow extends JFrame implements IServerView {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;

    JButton btnStart, btnStop;
    JTextArea log;

    private final Server server;

    public ServerWindow() {
        Workrepository workrepository = new Workrepository();
        server = new Server(this, workrepository);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setLocationRelativeTo(null);
        createPanel();
        setVisible(true);
    }

    public void appendLog(String text) {
        log.append(text + "\n");
    }

    private void createPanel() {
        log = new JTextArea();
        add(log);
        add(createButtons(), BorderLayout.SOUTH);
    }

    private Component createButtons() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (server.isWork()) {
                    appendLog("Сервер уже был запущен");
                } else {
                    server.setWork(true);
                    appendLog("Сервер запущен!");
                }
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!server.isWork()) {
                    appendLog("Сервер уже был остановлен");
                } else {
                    server.setWork(false);
//                   server.processWindowEvent(EXIT_ON_CLOSE);
                }

                appendLog("Сервер остановлен!");
            }

        });

        panel.add(btnStart);
        panel.add(btnStop);
        return panel;

    }public Server isServer() {
        return server;
}
}
