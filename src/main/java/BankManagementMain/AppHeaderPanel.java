/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankManagementMain;

import Colors.ColorPallete;
import javax.swing.*;
import java.awt.*;

public class AppHeaderPanel extends JPanel {

    private JLabel headerLabel, lblLogo;
    private JButton btnLogout;
    
    public AppHeaderPanel() {
        setLayout(null);
        setBounds(0, 0, 1920, 60);
        setBackground(ColorPallete.Blue5);

        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/bank_logo.png"));
        Image scaledLogo = logoIcon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        lblLogo = new JLabel(new ImageIcon(scaledLogo));
        lblLogo.setBounds(20, 14, 32, 32);
        add(lblLogo);

        headerLabel = new JLabel("Summit PhilBank System");
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        headerLabel.setBounds(62, 15, 320, 30);
        add(headerLabel);
        
        btnLogout = new JButton("Logout");
        btnLogout.setForeground(Color.WHITE);
        btnLogout.setBackground(ColorPallete.Blue3);
        btnLogout.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btnLogout.setBounds(1800, 15, 100, 30);
        btnLogout.setFocusPainted(false);
        btnLogout.setBorderPainted(false);
        btnLogout.setContentAreaFilled(false);  
        btnLogout.setOpaque(true);
        btnLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(btnLogout);
       
    }
}