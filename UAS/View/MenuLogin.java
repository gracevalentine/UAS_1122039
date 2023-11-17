package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.Controller;
import Model.Users;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuLogin {
    JFrame frame;

    public MenuLogin() {
        frame = new JFrame("Games Store");
        frame.setSize(400, 300);
        frame.setLayout(null);

        JLabel loginMenu = new JLabel("Menu Login");
        loginMenu.setBounds(130, 20, 200, 20);
        loginMenu.setFont(new Font(null, Font.BOLD, 14));
        frame.add(loginMenu);

        JLabel email = new JLabel("Email: ");
        email.setBounds(25, 55, 200, 25);
        frame.add(email);
        JTextField cekEmail = new JTextField();
        cekEmail.setBounds(120, 56, 200, 25);
        frame.add(cekEmail);

        JLabel password = new JLabel("Password: ");
        password.setBounds(25, 100, 200, 25);
        frame.add(password);
        JPasswordField cekPassword = new JPasswordField();
        cekPassword.setBounds(120, 101, 200, 25);
        frame.add(cekPassword);

        JButton loginButton = new JButton("LOGIN");
        loginButton.setBounds(200, 170, 100, 25);
        frame.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String isiEmail = cekEmail.getText();
                String isiPassword = new String(cekPassword.getPassword());
                Users data = Controller.loginUser(isiEmail, isiPassword);
                if (data.getIdUser() != 0) {
                    JOptionPane.showMessageDialog(null, "Anda berhasil login");
                    new GameList(data);
                } else {
                    JOptionPane.showMessageDialog(null, "Email/password Anda salah. Silakan coba lagi.");
                } 

            }
        });
        
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        new MenuLogin();
    }
}
