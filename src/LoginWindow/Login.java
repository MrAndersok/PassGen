package LoginWindow;

import PasswordView.ViewPasswords;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    }
}
