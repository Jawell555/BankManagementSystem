/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LoginForm;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.TextField;
import javax.swing.*;

/**
 *
 * @author Ruell
 */
public class LoginFormFrame extends JFrame{

    JLabel lblLoginArea, lblTitle, lblUser, lblPassword;
    JPasswordField passPass;
    JTextField txtUser;
    JButton btnLogin;
    
    Font fntTitle = new Font("Helvetica", Font.BOLD, 30);
    Font fntText = new Font("Helvetica", Font.BOLD, 15);
    Font fntTxtField = new Font("Helvetica", Font.PLAIN, 15);
    
    
    public LoginFormFrame(){
        setSize(1920,1080);
        setTitle("Bank Login");
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#C2D9FF"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btnLogin = new JButton("Login");
        btnLogin.setBounds(840,530,150,60);
        btnLogin.setFont(fntText);
        btnLogin.setBackground(Color.decode("#7752FE"));
        btnLogin.setForeground(Color.decode("#190482"));
        add(btnLogin);
        
        lblUser = new JLabel("Username:",SwingConstants.CENTER);
        lblUser.setBounds(760,420,85,30);
        lblUser.setFont(fntText);
        lblUser.setForeground(Color.decode("#190482"));
        add(lblUser);
        
        txtUser = new JTextField();
        txtUser.setBounds(860,420,195,30);
        txtUser.setFont(fntTxtField);
        add(txtUser);
        
        lblPassword = new JLabel("Password:", SwingConstants.CENTER);
        lblPassword.setBounds(760,480,85,30);
        lblPassword.setFont(fntText);
        lblPassword.setForeground(Color.decode("#190482"));
        add(lblPassword);
        
        passPass = new JPasswordField();
        passPass.setBounds(860,480,195,30);
        passPass.setFont(fntTxtField);
        add(passPass);
        
        lblTitle = new JLabel("BEMBANK LOGIN", SwingConstants.CENTER);
        lblTitle.setBounds(665,250,500,80);
        lblTitle.setFont(fntTitle);
        lblTitle.setOpaque(true);
        lblTitle.setBackground(Color.decode("#8E8FFA"));
        lblTitle.setForeground(Color.decode("#190482"));
        add(lblTitle);
        
        lblLoginArea = new JLabel();
        lblLoginArea.setBounds(665,370,500,250);
        lblLoginArea.setOpaque(true);
        lblLoginArea.setBackground(Color.decode("#8E8FFA"));
        add(lblLoginArea);
        
  
    }
    
}
