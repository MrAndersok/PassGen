package PasswordView;

import LoginWindow.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewPasswords {
    private JList list1;
    private JButton logOutButton;
    private JButton addPasswordButton;
    private JPanel panel1;
    private JFrame frameView;
    private String file;

    public ViewPasswords() {
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login lg = new Login();
                lg.createLogin();
                frameView.hide();
            }
        });
        addPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PasswordGenerator pg = new PasswordGenerator();
                pg.GeneratorOpen(file);
                frameView.hide();
            }
        });
    }

    public void viewOpen(String pathFile)
    {
        file = pathFile;
        frameView = new JFrame("ViewPassword");
        frameView.setContentPane(panel1);
        frameView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameView.pack();
        frameView.setVisible(true);
    }
    {

    }
}
