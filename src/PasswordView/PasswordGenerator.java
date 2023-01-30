package PasswordView;

import Hash.Blowfish;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Random;

public class PasswordGenerator {
    private JTextField nameTextField;
    private JSlider slider1;
    private JCheckBox specialSignsCheckBox;
    private JButton GENERETEButton;
    private JPanel panel1;
    private JLabel Error;
    private JFrame frameGenerator;

    private ArrayList<String> passwordlist;

    private String fileName;
    public PasswordGenerator() {
        GENERETEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nameTextField.getText() == "")
                {
                    Error.setText("Name password empty");
                }
                else{
                    generation();
                    ViewPasswords vp = new ViewPasswords();
                    vp.viewOpen(fileName,passwordlist);
                    frameGenerator.hide();
                }
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
        passwordlist.add(nameTextField.getText()+'\t'+password);
        try {
            String i = "\n" + nameTextField.getText() + "\t" + password;
            Files.write(Paths.get("rob.txt"),i.getBytes(), StandardOpenOption.APPEND);
            Blowfish blowfish = new Blowfish(fileName);
            FileInputStream fis = new FileInputStream("rob.txt");
            FileOutputStream fos = new FileOutputStream(fileName+".txt");
            blowfish.encrypt(fis,fos);
            File del = new File(fileName+"En.txt");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void GeneratorOpen(String pathFile, ArrayList<String> ps)
    {
        passwordlist = ps;
        fileName = pathFile;
        frameGenerator = new JFrame("Generator");
        frameGenerator.setContentPane(panel1);
        frameGenerator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGenerator.pack();
        frameGenerator.setVisible(true);
        slider1.setMajorTickSpacing(20);
        slider1.setPaintLabels(true);
    }
}
