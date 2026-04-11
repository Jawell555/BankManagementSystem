/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank_ManageAccounts;

import Colors.ColorPalette;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class NewAccountBoard extends JPanel {

    private JLabel lblAccNo, lblTitle,lblSubt1, lblName, lblFatherName, lblEmail,lblIdType, lblIdNum, lblDate, lblType;
    private JTextField txtAccNum, txtName, txtFatherName, txtEmail, txtIdNumber, txtDate;
    private JButton btnRegister, btnClear; 
    private JComboBox<String> cbIdType, cbType;
    private JSeparator topSep;

    public NewAccountBoard() {
        setLayout(null);
        setBackground(new Color(235, 235, 235));
        setBounds(0, 0, 1670, 1080);

        //Main title
        lblTitle = new JLabel("New Account Form");
        lblTitle.setBounds(50, 40, 400, 40);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 25));
        add(lblTitle);
        
        topSep = new JSeparator();
        topSep.setBounds(50, 100, 1585, 2);
        topSep.setBackground(ColorPalette.Blue5);
        add(topSep);

        lblSubt1 = new JLabel("Personal Information");
        lblSubt1.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblSubt1.setBounds(50, 125, 150, 20);
        add(lblSubt1);
        
        //Left Column
        lblName = new JLabel("Name");
        lblName.setBounds(50, 155, 100, 20);
        add(lblName);

        txtName = new JTextField("Enter Full Name");
        txtName.setBounds(50, 175, 450, 30);
        txtName.setEditable(false);
        add(txtName);

        lblIdType = new JLabel("Type of ID");
        lblIdType.setBounds(50, 225, 200, 20);
        add(lblIdType);

        cbIdType = new JComboBox<>(new String[]{"National ID", "Passport", "Driver's License"});
        cbIdType.setBounds(50, 245, 450, 30);
        add(cbIdType);
        
        lblAccNo = new JLabel("Account Number");
        lblAccNo.setBounds(50, 295, 150, 20);
        add(lblAccNo);
        
        txtAccNum = new JTextField("Enter SPB Account Number");
        txtAccNum.setBounds(50, 315, 450, 30);
        txtAccNum.setEditable(false);
        add(txtAccNum);
 
        //Middle Column
        lblType = new JLabel("Type");
        lblType.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblType.setBounds(500, 315, 200, 20);
        add(lblType);

        cbType = new JComboBox<>(new String[]{"Savings", "Current"});
        cbType.setFont(new Font("Segoe UI", Font.BOLD, 15));
        cbType.setBounds(500, 340, 320, 35);
        add(cbType);

        btnRegister = new JButton("Save Account");
        btnRegister.setBounds(700, 880, 200, 40);
        styleButton(btnRegister);
        btnRegister.addActionListener(e -> saveAccount());
        add(btnRegister);

        btnClear = new JButton("Clear");
        btnClear.setBounds(400, 880, 200, 40);
        styleButton(btnClear);
        btnClear.addActionListener(e -> clearFields());
        add(btnClear);
    }

    private void styleButton(JButton btn) {
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setForeground(Color.WHITE);
        btn.setBackground(ColorPalette.Blue5);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
    }

    private void saveAccount() {
        if (txtAccNum.getText().trim().isEmpty()
                || txtName.getText().trim().isEmpty()
                || txtFatherName.getText().trim().isEmpty()
                || txtEmail.getText().trim().isEmpty()
                || txtIdNumber.getText().trim().isEmpty()
                || txtDate.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }

        JOptionPane.showMessageDialog(this,
                "Account form submitted.\n");
        clearFields();
    }

    private void clearFields() {
        txtAccNum.setText("");
        txtName.setText("");
        txtFatherName.setText("");
        txtEmail.setText("");
        txtIdNumber.setText("");
        txtDate.setText("");
        cbIdType.setSelectedIndex(0);
        cbType.setSelectedIndex(0);
    }
}