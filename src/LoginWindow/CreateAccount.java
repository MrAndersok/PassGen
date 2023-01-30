package LoginWindow;

import Messeng.Messeng;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAccount {
    JPanel panel1;
    private JTextField loginTextField;
    private JTextField PINTextField;
    private JTextField PINAgainTextField;
    private JButton createButton;
    private JButton cancelButton;
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
            Login lg = new Login();
            lg.createLogin();
            frameRegister.hide();
            //todo if date ok
            Messeng ms = new Messeng();
            ms.openMesseng("Account created");
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
