package ChangePassword;

import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class ChangePasswordPanel extends JPanel {

    private JLabel titleLabel, oldPasswordLabel, newPasswordLabel, confirmPasswordLabel;
    private JPasswordField oldPasswordField, newPasswordField, confirmPasswordField;
    private JButton changePasswordButton;
    private JSeparator separator;

    public ChangePasswordPanel() {
        setLayout(null);
        setBackground(new Color(245, 247, 250));
        setBounds(0, 0, 1670, 450);

        Font titleFont = new Font("Segoe UI", Font.BOLD, 20);
        Font labelFont = new Font("Segoe UI", Font.BOLD, 15);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 15);
        Font buttonFont = new Font("Segoe UI", Font.BOLD, 15);

        Color darkBlue = new Color(3, 27, 66);
        Color borderColor = new Color(190, 198, 210);
        Color buttonColor = new Color(3, 27, 66);
        Color buttonHover = new Color(10, 40, 90);

        // Title
        titleLabel = new JLabel("Change Password");
        titleLabel.setBounds(30, 25, 300, 30);
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(darkBlue);
        add(titleLabel);

        // Separator
        separator = new JSeparator();
        separator.setBounds(30, 65, 1600, 2);
        separator.setBackground(new Color(200, 200, 200));
        add(separator);

        // Center form width
        int fieldWidth = 600;
        int centerX = (1670 - fieldWidth) / 2;

        // Old Password
        oldPasswordLabel = new JLabel("Old Password");
        oldPasswordLabel.setBounds(centerX, 110, 300, 25);
        oldPasswordLabel.setFont(labelFont);
        oldPasswordLabel.setForeground(darkBlue);
        add(oldPasswordLabel);

        oldPasswordField = new JPasswordField();
        oldPasswordField.setBounds(centerX, 135, fieldWidth, 40);
        oldPasswordField.setFont(fieldFont);
        oldPasswordField.setBackground(Color.WHITE);
        oldPasswordField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderColor, 1, true),
                BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        add(oldPasswordField);

        // New Password
        newPasswordLabel = new JLabel("New Password");
        newPasswordLabel.setBounds(centerX, 185, 300, 25);
        newPasswordLabel.setFont(labelFont);
        newPasswordLabel.setForeground(darkBlue);
        add(newPasswordLabel);

        newPasswordField = new JPasswordField();
        newPasswordField.setBounds(centerX, 210, fieldWidth, 40);
        newPasswordField.setFont(fieldFont);
        newPasswordField.setBackground(Color.WHITE);
        newPasswordField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderColor, 1, true),
                BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        add(newPasswordField);

        // Confirm Password
        confirmPasswordLabel = new JLabel("Confirm Password");
        confirmPasswordLabel.setBounds(centerX, 260, 300, 25);
        confirmPasswordLabel.setFont(labelFont);
        confirmPasswordLabel.setForeground(darkBlue);
        add(confirmPasswordLabel);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(centerX, 285, fieldWidth, 40);
        confirmPasswordField.setFont(fieldFont);
        confirmPasswordField.setBackground(Color.WHITE);
        confirmPasswordField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderColor, 1, true),
                BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        add(confirmPasswordField);

        // Button
        changePasswordButton = new JButton("Change Password");
        changePasswordButton.setBounds(centerX + 180, 345, 240, 45);
        changePasswordButton.setFont(buttonFont);
        changePasswordButton.setForeground(Color.WHITE);
        changePasswordButton.setBackground(buttonColor);
        changePasswordButton.setFocusPainted(false);
        changePasswordButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        changePasswordButton.setBorder(new LineBorder(buttonColor, 1, true));

        // Hover effect
        changePasswordButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                changePasswordButton.setBackground(buttonHover);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                changePasswordButton.setBackground(buttonColor);
            }
        });

        add(changePasswordButton);
    }
}