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
import javax.swing.JTextField;

public class NewAccountBoard extends JPanel {

    private JTextField txtAccountNumber, txtName, txtFatherName, txtEmail, txtIdNumber, txtDate;
    private JComboBox<String> cbIdType, cbType;

    public NewAccountBoard() {
        setLayout(null);
        setBounds(0, 0, 1670, 1080);
        setBackground(new Color(245, 247, 250));

        JLabel lblTitle = new JLabel("New Account");
        lblTitle.setBounds(50, 30, 400, 40);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
        lblTitle.setForeground(new Color(33, 37, 41));
        add(lblTitle);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBounds(50, 100, 950, 520);
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createLineBorder(new Color(225, 230, 235), 1));
        add(formPanel);

        JLabel lblAccNo = new JLabel("Account Number");
        lblAccNo.setBounds(40, 30, 200, 20);
        formPanel.add(lblAccNo);

        txtAccountNumber = new JTextField();
        txtAccountNumber.setBounds(40, 30 + 25, 320, 35);
        formPanel.add(txtAccountNumber);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(500, 30, 200, 20);
        formPanel.add(lblName);

        txtName = new JTextField();
        txtName.setBounds(500, 30 + 25, 320, 35);
        formPanel.add(txtName);

        JLabel lblFatherName = new JLabel("Father Name");
        lblFatherName.setBounds(40, 30 + 75, 200, 20);
        formPanel.add(lblFatherName);

        txtFatherName = new JTextField();
        txtFatherName.setBounds(40, 30 + 75 + 25, 320, 35);
        formPanel.add(txtFatherName);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(500, 30 + 75, 200, 20);
        formPanel.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(500, 30 + 75 + 25, 320, 35);
        formPanel.add(txtEmail);

        JLabel lblIdType = new JLabel("Type of ID");
        lblIdType.setBounds(40, 30 + 75 * 2, 200, 20);
        formPanel.add(lblIdType);

        cbIdType = new JComboBox<>(new String[]{"National ID", "Passport", "Driver's License"});
        cbIdType.setBounds(40, 30 + 75 * 2 + 25, 320, 35);
        formPanel.add(cbIdType);

        JLabel lblIdNum = new JLabel("ID Number");
        lblIdNum.setBounds(500, 30 + 75 * 2, 200, 20);
        formPanel.add(lblIdNum);

        txtIdNumber = new JTextField();
        txtIdNumber.setBounds(500, 30 + 75 * 2 + 25, 320, 35);
        formPanel.add(txtIdNumber);

        JLabel lblDate = new JLabel("Date");
        lblDate.setBounds(40, 30 + 75 * 3, 200, 20);
        formPanel.add(lblDate);

        txtDate = new JTextField();
        txtDate.setBounds(40, 30 + 75 * 3 + 25, 320, 35);
        formPanel.add(txtDate);

        JLabel lblType = new JLabel("Type");
        lblType.setBounds(500, 30 + 75 * 3, 200, 20);
        formPanel.add(lblType);

        cbType = new JComboBox<>(new String[]{"Savings", "Current"});
        cbType.setBounds(500, 30 + 75 * 3 + 25, 320, 35);
        formPanel.add(cbType);

        JButton btnSave = new JButton("Save Account");
        btnSave.setBounds(500, 30 + 75 * 4 + 10, 160, 40);
        styleButton(btnSave);
        btnSave.addActionListener(e -> saveAccount());
        formPanel.add(btnSave);

        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(680, 30 + 75 * 4 + 10, 140, 40);
        styleButton(btnClear);
        btnClear.addActionListener(e -> clearFields());
        formPanel.add(btnClear);
    }

    private void styleButton(JButton btn) {
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setForeground(Color.WHITE);
        btn.setBackground(ColorPalette.Blue5);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
    }

    private void saveAccount() {
        if (txtAccountNumber.getText().trim().isEmpty()
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
        txtAccountNumber.setText("");
        txtName.setText("");
        txtFatherName.setText("");
        txtEmail.setText("");
        txtIdNumber.setText("");
        txtDate.setText("");
        cbIdType.setSelectedIndex(0);
        cbType.setSelectedIndex(0);
    }
}