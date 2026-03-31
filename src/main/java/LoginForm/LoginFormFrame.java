/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LoginForm;

import Colors.ColorPallete;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author Ruell
 */
public class LoginFormFrame extends JFrame implements ActionListener {

    JLabel lblLoginArea, lblTitle, lblUser, lblPassword;
    JPasswordField passPass;
    JTextField txtUser;
    JButton btnLogin;
    private String pass, user;

    private String username = "Lorenzo";
    private String password = "Lorenzo123!";

    Font fntTitle = new Font("Segoe UI", Font.BOLD, 30);
    Font fntText = new Font("Segoe UI", Font.BOLD, 15);
    Font fntTxtField = new Font("Segoe UI", Font.PLAIN, 15);


    
    private final Border errorBorder = BorderFactory.createCompoundBorder(new LineBorder(ColorPallete.redPastel, 2), BorderFactory.createEmptyBorder(2, 4, 2, 4));
    
    public LoginFormFrame() {
        setSize(1920, 1080);
        setTitle("Bank Login");
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(ColorPallete.Blue5);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Login button
        btnLogin = new JButton("Login");
        btnLogin.setBounds(840, 530, 150, 60);
        btnLogin.setFont(fntText);
        btnLogin.setBackground(ColorPallete.Blue3);
        btnLogin.setForeground(ColorPallete.Blue1);
        add(btnLogin);

        lblUser = new JLabel("Username:", SwingConstants.CENTER);
        lblUser.setBounds(760, 420, 85, 30);
        lblUser.setFont(fntText);
        lblUser.setForeground(ColorPallete.Blue1);
        add(lblUser);

        txtUser = new JTextField();
        txtUser.setBounds(860, 420, 195, 30);
        txtUser.setFont(fntTxtField);
        add(txtUser);

        lblPassword = new JLabel("Password:", SwingConstants.CENTER);
        lblPassword.setBounds(760, 480, 85, 30);
        lblPassword.setFont(fntText);
        lblPassword.setForeground(ColorPallete.Blue1);
        add(lblPassword);

        passPass = new JPasswordField();
        passPass.setBounds(860, 480, 195, 30);
        passPass.setFont(fntTxtField);
        add(passPass);

        //Top Title & Rectangle
        lblTitle = new JLabel("BEMBANK LOGIN", SwingConstants.CENTER);
        lblTitle.setBounds(665, 250, 500, 80);
        lblTitle.setFont(fntTitle);
        lblTitle.setOpaque(true);
        lblTitle.setBackground(ColorPallete.Blue4);
        lblTitle.setForeground(ColorPallete.Blue1);
       
        add(lblTitle);

        //Bottom Rectangle
        lblLoginArea = new JLabel();
        lblLoginArea.setBounds(665, 370, 500, 250);
        lblLoginArea.setOpaque(true);
        lblLoginArea.setBackground(ColorPallete.Blue4);
        add(lblLoginArea);

        getRootPane().setDefaultButton(btnLogin);
        btnLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        user = txtUser.getText();
        pass = passPass.getText();
        if (e.getSource() == btnLogin) {
            if (user.equals(username) && pass.equals(password)) {
                //LORENZO CODE MO DITO
                dispose();
            } else {
                passPass.setText("");
                txtUser.setBorder(errorBorder);
                passPass.setBorder(errorBorder);
                JOptionPane.showMessageDialog(null, "Incorrect Credentials. Try Again.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
