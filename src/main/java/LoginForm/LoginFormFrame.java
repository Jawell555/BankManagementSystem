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
        setSize(1440,720);
        setTitle("Bank Login");
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#FFFAFA"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        lblUser = new JLabel("Username:",SwingConstants.CENTER);
        lblUser.setBounds(580,320,85,30);
        lblUser.setFont(fntText);
        add(lblUser);
        
        txtUser = new JTextField();
        txtUser.setBounds(680,320,195,30);
        txtUser.setFont(fntTxtField);
        add(txtUser);
        
        lblPassword = new JLabel("Password:", SwingConstants.CENTER);
        lblPassword.setBounds(580,380,85,30);
        lblPassword.setFont(fntText);
        add(lblPassword);
        
        passPass = new JPasswordField();
        passPass.setBounds(680,380,195,30);
        passPass.setFont(fntTxtField);
        add(passPass);
        
        lblTitle = new JLabel("LOGIN", SwingConstants.CENTER);
        lblTitle.setBounds(485,150,500,80);
        lblTitle.setFont(fntTitle);
        lblTitle.setOpaque(true);
        lblTitle.setBackground(Color.decode("#FF6961"));
        add(lblTitle);
        
        lblLoginArea = new JLabel();
        lblLoginArea.setBounds(485,270,500,200);
        lblLoginArea.setOpaque(true);
        lblLoginArea.setBackground(Color.decode("#FF6961"));
        add(lblLoginArea);
        
        
        
    }
    
}
