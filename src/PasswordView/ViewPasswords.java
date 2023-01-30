package PasswordView;

import LoginWindow.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewPasswords {
    private JList list1;
    private JButton logOutButton;
    private JButton addPasswordButton;
    private JPanel panel1;
    private JFrame frameView;
    private String file;

    private ArrayList<String> password;

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
                pg.GeneratorOpen(file,password);
                frameView.hide();
            }
        });
    }

    public void viewOpen(String pathFile, ArrayList<String> pas)
    {
        password = pas;
        file = pathFile;
        frameView = new JFrame("ViewPassword");
        frameView.setContentPane(panel1);
        frameView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameView.pack();
        frameView.setVisible(true);
        DefaultListModel demoList = new DefaultListModel();
        int i = 0;
        for (String line: password) {
            if(i!=0) {
                String[] a = line.split("\t");
                demoList.addElement(a[0] + ": [ " + a[1] + "]");
            }
            i++;
        }
        list1.setModel(demoList);
    }
}
