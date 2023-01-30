package PasswordView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                ViewPasswords vp = new ViewPasswords();
                vp.viewOpen(file);
                frameGenerator.hide();
            }
        });
    }

    public void GeneratorOpen(String pathFile)
    {
        file = pathFile;
        frameGenerator = new JFrame("Generator");
        frameGenerator.setContentPane(panel1);
        frameGenerator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGenerator.pack();
        frameGenerator.setVisible(true);
    }
}
