/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LoginForm;

import BankManagementMain.SidebarPanelFrame;
import Colors.ImagePanel;
import Colors.ColorPalette;
import java.awt.Font;
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

    JPanel pnlBG, pnlLogo, pnlSq, pnlLoginArea, pnlTitle;
    JLabel lblTitle, lblUser, lblPassword;
    JPasswordField passPass;
    JTextField txtUser;
    JButton btnLogin;
    private String pass, user;

    private String username = "Admin";
    private String password = "Admin123!";

    Font fntTitle = new Font("Segoe UI", Font.BOLD, 50);
    Font fntText = new Font("Segoe UI", Font.BOLD, 15);
    Font fntTxtField = new Font("Segoe UI", Font.PLAIN, 15);

    private final Border errorBorder = BorderFactory.createCompoundBorder(new LineBorder(ColorPalette.redPastel, 2), BorderFactory.createEmptyBorder(2, 4, 2, 4));

    public LoginFormFrame() {
        setSize(1920, 1080);
        setTitle("Bank Login");
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pnlBG = new ImagePanel("/bg.jpg");
        pnlBG.setLayout(null);
        pnlBG.setBounds(0, 0, 1920, 1080);
        add(pnlBG);

        //Bottom Rectangle
        pnlLoginArea = new JPanel(null);
        pnlLoginArea.setBounds(710, 370, 500, 300);
        pnlLoginArea.setOpaque(false);
        pnlBG.add(pnlLoginArea);

        //Login button
        btnLogin = new JButton("Login");
        btnLogin.setBounds(175, 175, 150, 60);
        btnLogin.setFont(fntText);
        btnLogin.setBackground(ColorPalette.Blue4);
        btnLogin.setForeground(ColorPalette.Blue1);
        pnlLoginArea.add(btnLogin);

        lblUser = new JLabel("Username:");
        lblUser.setBounds(60, 50, 90, 30);
        lblUser.setFont(fntText);
        lblUser.setForeground(ColorPalette.Blue1);
        pnlLoginArea.add(lblUser);

        txtUser = new JTextField();
        txtUser.setBounds(150, 50, 280, 30);
        txtUser.setFont(fntTxtField);
        pnlLoginArea.add(txtUser);

        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(60, 110, 90, 30);
        lblPassword.setFont(fntText);
        lblPassword.setForeground(ColorPalette.Blue1);
        pnlLoginArea.add(lblPassword);

        passPass = new JPasswordField();
        passPass.setBounds(150, 110, 280, 30);
        passPass.setFont(fntTxtField);
        pnlLoginArea.add(passPass);

        
        
        //Top Title & Rectangle
        pnlTitle = new JPanel(null);
        pnlTitle.setBounds(710, 300, 500, 80);
        pnlTitle.setOpaque(false);
        pnlBG.add(pnlTitle);

        lblTitle = new JLabel("Summit PhilBank", SwingConstants.CENTER);
        lblTitle.setBounds(60, 0, 440, 80);
        lblTitle.setFont(fntTitle);
        lblTitle.setForeground(ColorPalette.Blue1);
        pnlTitle.add(lblTitle);

        pnlLogo = new ImagePanel("/bank_logo.jpg");
        pnlLogo.setLayout(null);
        pnlLogo.setBounds(0, 10, 60, 60);
        pnlTitle.add(pnlLogo);
        

        getRootPane().setDefaultButton(btnLogin);
        btnLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        user = txtUser.getText();
        pass = passPass.getText();
        if (e.getSource() == btnLogin) {
            if (user.equals(username) && pass.equals(password)) {
                SidebarPanelFrame sf = new SidebarPanelFrame();
                    sf.setVisible(true);
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
