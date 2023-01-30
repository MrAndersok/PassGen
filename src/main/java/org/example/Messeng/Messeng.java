package org.example.Messeng;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Messeng {
    private JButton OKButton;
    private JPanel panel1;
    private JLabel label1;
    private JFrame frameMasseng;

    public Messeng() {
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameMasseng.hide();
            }
        });
    }

    public void openMesseng(String nameMesseng)
    {
        label1.setText(nameMesseng);
        frameMasseng = new JFrame("Login");
        frameMasseng.setContentPane(panel1);
        frameMasseng.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frameMasseng.pack();
        frameMasseng.setVisible(true);
    }
}
