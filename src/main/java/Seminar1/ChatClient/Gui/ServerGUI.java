package Seminar1.ChatClient.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerGUI extends JFrame{
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private static boolean serverWork = false;
    public boolean getServerWork() {
        return serverWork;
    }



    private final JPanel bottomPanel = new JPanel(new GridLayout(1,2));
    private final JButton btnStart = new JButton("Start");
    private final JButton btnExit = new JButton("Stop");
    private final JTextArea log = new JTextArea();
    private final JScrollPane scrollPaneLog = new JScrollPane(log);

    public ServerGUI(){
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH,HEIGHT);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Chat server");
        setAlwaysOnTop(true);

        // Добавление окна сообщений
        add(scrollPaneLog);

        // Добавление кнопок нижней панели

        bottomPanel.add(btnStart);
        bottomPanel.add(btnExit);
        add(bottomPanel, BorderLayout.SOUTH);
        add(scrollPaneLog);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (serverWork){
                    log.append("Сервер работает\n");
                }else {
                    workServer(true);
                    log.append("Cервер запущен\n");
                }

            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (serverWork){
                    workServer(false);
                    log.append("Cервер остановлен\n");
                }
            }
        });
    }


    /**
     * Звпуск, остановка сервера.
     * @param work режим работы
     */
    public void workServer(boolean work){
       serverWork = work;

    }
    public void logServer(String login,String message){
        log.append(login + message);
    }


}
