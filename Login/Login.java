package com.codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JTextField nome;
    private JTextField ip;
    private JButton enter;
    private JPanel login;
    private static JFrame log;


     Login() {
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log.setDefaultCloseOperation(1);
                JFrame frame = new JFrame("App");
                frame.setContentPane(new App().panel1);
                frame.setSize(1000, 1000);
                frame.setMinimumSize(new Dimension(500,500));
                frame.setMaximumSize(new Dimension(500,500));
                frame.setPreferredSize(new Dimension(500,500));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        log = new JFrame("Login");
        log.setContentPane(new Login().login);
        log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        log.pack();
        log.setVisible(true);
        log.setMinimumSize(new Dimension(400, 400));
        log.setMaximumSize(new Dimension(400, 400));
        log.setPreferredSize(new Dimension(400, 400));


    }
}
