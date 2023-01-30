package LoginWindow;

import Hash.Blowfish;
import Messeng.Messeng;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.CheckedOutputStream;

public class CreateAccount {
    JPanel panel1;
    private JTextField loginTextField;
    private JTextField PINTextField;
    private JTextField PINAgainTextField;
    private JButton createButton;
    private JButton cancelButton;
    private JLabel labelerror;
    private JFrame frameRegister;
public CreateAccount() {

    cancelButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Login lg = new Login();
            lg.createLogin();
            frameRegister.hide();
        }
    });
    createButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(loginTextField.getText() == "")
            {
                labelerror.setText("Type login");
            }
            else
            {
                if(PINTextField.getText() == "" || PINTextField.getText().length() != 4 ){
                    labelerror.setText("Type pin 4 chars!");
                }
                else {
                    if(PINAgainTextField.getText() == "")
                        labelerror.setText("Type PIN 2 times");
                    else {
                        if(!PINTextField.getText().equals(PINAgainTextField.getText()))
                        {
                            labelerror.setText("PIN's not similar");
                        }
                        else{

                            File f = new File(loginTextField.getText()+".txt");
                            if(f.exists()){
                                labelerror.setText("Account exists");
                            }
                            else {
                                try {
                                    f.createNewFile();
                                    FileOutputStream file = new FileOutputStream(loginTextField.getText()+"En.txt");
                                    file.write(PINTextField.getText().getBytes());
                                    Blowfish blowfish = new Blowfish(loginTextField.getText());
                                    FileInputStream fis = new FileInputStream(loginTextField.getText()+"En.txt");
                                    FileOutputStream fos = new FileOutputStream(loginTextField.getText()+".txt");
                                    blowfish.encrypt(fis,fos);
                                    file.close();
                                    File del = new File(loginTextField.getText()+"En.txt");
                                    del.delete();
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                                Login lg = new Login();
                                lg.createLogin();
                                frameRegister.hide();
                                Messeng ms = new Messeng();
                                ms.openMesseng("Account created");
                            }
                        }
                    }
                }
            }
        }
    });
}
    public void openRegister(){
        frameRegister = new JFrame("Register");
        frameRegister.setContentPane(panel1);
        frameRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRegister.pack();
        frameRegister.setVisible(true);
    }

}
