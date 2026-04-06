/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank_ManageEmployees;

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

public class AddEmployeesBoard extends JPanel {

    private JTextField txtEmployeeId, txtEmployeeName, txtFatherName, txtEmail, txtIdNumber, txtDate;
    private JComboBox<String> cbType;

    public AddEmployeesBoard() {
        setLayout(null);
        setBounds(0, 0, 1670, 1080);
        setBackground(new Color(245, 247, 250));

        JLabel lblTitle = new JLabel("Add Employee");
        lblTitle.setBounds(50, 30, 400, 40);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
        lblTitle.setForeground(new Color(33, 37, 41));
        add(lblTitle);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBounds(50, 100, 900, 500);
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createLineBorder(new Color(225, 230, 235), 1));
        add(formPanel);

        JLabel lblEmpId = new JLabel("Employee ID");
        lblEmpId.setBounds(40, 30, 200, 20);
        lblEmpId.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        formPanel.add(lblEmpId);

        txtEmployeeId = new JTextField();
        txtEmployeeId.setBounds(40, 30 + 25, 320, 35);
        formPanel.add(txtEmployeeId);

        JLabel lblEmpName = new JLabel("Employee Name");
        lblEmpName.setBounds(470, 30, 200, 20);
        lblEmpName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        formPanel.add(lblEmpName);

        txtEmployeeName = new JTextField();
        txtEmployeeName.setBounds(470, 30 + 25, 320, 35);
        formPanel.add(txtEmployeeName);

        JLabel lblFatherName = new JLabel("Father Name");
        lblFatherName.setBounds(40, 30 + 75, 200, 20);
        lblFatherName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        formPanel.add(lblFatherName);

        txtFatherName = new JTextField();
        txtFatherName.setBounds(40, 30 + 75 + 25, 320, 35);
        formPanel.add(txtFatherName);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(470, 30 + 75, 200, 20);
        lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        formPanel.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(470, 30 + 75 + 25, 320, 35);
        formPanel.add(txtEmail);

        JLabel lblIdNumber = new JLabel("ID Number");
        lblIdNumber.setBounds(40, 30 + 75 * 2, 200, 20);
        lblIdNumber.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        formPanel.add(lblIdNumber);

        txtIdNumber = new JTextField();
        txtIdNumber.setBounds(40, 30 + 75 * 2 + 25, 320, 35);
        formPanel.add(txtIdNumber);

        JLabel lblDate = new JLabel("Date");
        lblDate.setBounds(470, 30 + 75 * 2, 200, 20);
        lblDate.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        formPanel.add(lblDate);

        txtDate = new JTextField();
        txtDate.setBounds(470, 30 + 75 * 2 + 25, 320, 35);
        formPanel.add(txtDate);

        JLabel lblType = new JLabel("Type");
        lblType.setBounds(40, 30 + 75 * 3, 200, 20);
        lblType.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        formPanel.add(lblType);

        cbType = new JComboBox<>(new String[]{"Employee"});
        cbType.setBounds(40, 30 + 75 * 3 + 25, 320, 35);
        formPanel.add(cbType);

        JButton btnSave = new JButton("Save Employee");
        btnSave.setBounds(470, 30 + 75 * 3 + 20, 170, 40);
        styleButton(btnSave);
        btnSave.addActionListener(e -> saveEmployee());
        formPanel.add(btnSave);

        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(470 + 190, 30 + 75 * 3 + 20, 130, 40);
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

    private void saveEmployee() {
        if (txtEmployeeId.getText().trim().isEmpty()
                || txtEmployeeName.getText().trim().isEmpty()
                || txtFatherName.getText().trim().isEmpty()
                || txtEmail.getText().trim().isEmpty()
                || txtIdNumber.getText().trim().isEmpty()
                || txtDate.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }

        JOptionPane.showMessageDialog(this,
                "Employee form submitted.\n");
        clearFields();
    }

    private void clearFields() {
        txtEmployeeId.setText("");
        txtEmployeeName.setText("");
        txtFatherName.setText("");
        txtEmail.setText("");
        txtIdNumber.setText("");
        txtDate.setText("");
        cbType.setSelectedIndex(0);
    }
}