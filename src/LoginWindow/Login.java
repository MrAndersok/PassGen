package LoginWindow;

import Hash.Blowfish;
import Hash.md5Hash;
import PasswordView.ViewPasswords;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Login {
    public JPanel panel1;
    private JFormattedTextField loginFormattedTextField;
    private JTextField PINTextField;
    private JButton logInButton;
    private JButton button1;
    private JFrame frameLogin;
    public Login()
    {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateAccount cr = new CreateAccount();
                cr.openRegister();
                frameLogin.hide();
            }
        });
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //todo validation
                ViewPasswords vp = new ViewPasswords();
                vp.viewOpen("pathfiletodate");
                frameLogin.hide();
            }
        });
    }
    public void createLogin(){
        frameLogin = new JFrame("Login");
        frameLogin.setContentPane(panel1);
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLogin.pack();
        frameLogin.setVisible(true);
        //Test data
        md5Hash md5HashFunc = new md5Hash("text");
        System.out.println(md5HashFunc.getMd5Hex());

        try {
            Blowfish blowfish = new Blowfish(md5HashFunc.getMd5Hex());
            FileInputStream fis = new FileInputStream("test.txt");
            FileOutputStream fos = new FileOutputStream("encode.txt");
            blowfish.encrypt(fis,fos);
            Blowfish blowfish1 = new Blowfish(md5HashFunc.getMd5Hex());
            FileInputStream fis2 = new FileInputStream("encode.txt");
            FileOutputStream fos2 = new FileOutputStream("decode.txt");
            blowfish1.decrypt(fis2,fos2);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
