package LoginWindow;

import Hash.Blowfish;
import Hash.md5Hash;
import PasswordView.ViewPasswords;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Login {
    public JPanel panel1;
    private JFormattedTextField loginFormattedTextField;
    private JTextField PINTextField;
    private JButton logInButton;
    private JButton button1;
    private JLabel labelerror;
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
                if(loginFormattedTextField.getText() == "")
                {
                    labelerror.setText("Account not exist");
                }
                else{
                    try {
                        Blowfish blowfish1 = new Blowfish(loginFormattedTextField.getText());
                        FileInputStream fis2 = new FileInputStream(loginFormattedTextField.getText() + ".txt");
                        FileOutputStream fos2 = new FileOutputStream("rob.txt");
                        blowfish1.decrypt(fis2, fos2);
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        FileInputStream date = new FileInputStream("rob.txt");
                        BufferedReader reader = new BufferedReader(new InputStreamReader(date));
                        boolean log = false;
                        ArrayList<String> password = new ArrayList<String>();
                        while(reader.ready()) {
                            String line = reader.readLine();
                            System.out.println(line);
                            if(log == true || PINTextField.getText().equals(line))
                            {
                                log = true;
                                password.add(line);
                            }
                            else {
                                labelerror.setText("PIN error");
                                break;
                            }
                        }
                        date.close();
                        File f = new File("rob.txt");
                        //f.delete();
                        if(log == true)
                        {
                            ViewPasswords vp = new ViewPasswords();
                            vp.viewOpen(loginFormattedTextField.getText(),password);
                            frameLogin.hide();
                        }
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }

            }
        });
    }
    public void createLogin(){
        frameLogin = new JFrame("Login");
        frameLogin.setContentPane(panel1);
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLogin.pack();
        frameLogin.setVisible(true);
        /*
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
        }*/

    }
}
