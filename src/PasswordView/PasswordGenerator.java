package PasswordView;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PasswordGenerator {
    private JTextField nameTextField;
    private JSlider slider1;
    private JCheckBox specialSignsCheckBox;
    private JButton GENERETEButton;
    private JPanel panel1;
    private JFrame frameGenerator;

    private String file;
    public PasswordGenerator() {
        GENERETEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generation();
                ViewPasswords vp = new ViewPasswords();
                vp.viewOpen(file);
                frameGenerator.hide();
            }
        });
    }

    public void generation(){
        String abc ="";
        String password = "";
        if(specialSignsCheckBox.isSelected() == true) {
            abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()";
        }
        else {
            abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        }
        Random rd = new Random();
        for(int i = 0; i < slider1.getValue()/8; i++) {
            char letter = abc.charAt(rd.nextInt(abc.length()));
            password += letter;
        }
        System.out.println(password);
    }

    public void GeneratorOpen(String pathFile)
    {
        file = pathFile;
        frameGenerator = new JFrame("Generator");
        frameGenerator.setContentPane(panel1);
        frameGenerator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGenerator.pack();
        frameGenerator.setVisible(true);
        slider1.setMajorTickSpacing(20);
        slider1.setPaintLabels(true);
    }
}
