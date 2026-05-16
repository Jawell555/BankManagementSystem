/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank_ManageAccounts;

import Colors.ColorPalette;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class NewAccountBoard extends JPanel {

    private JLabel lblMTitle, lblSubt1,
            lblName, lblDOB, lblGender, // Row 1
            lblMobNum, lblIdType, lblIdNum, // Row 2 
            lblEmail, lblFN, // Row 3
            lblSubt2, lblImage, lblImagePath, // Row 4
            lblSubt3, lblPC, lblHA, lblCity, // Row 5
            lblSubt4, lblAccTitle, lblAccBal, lblAccType; // Row 6
    
    private JTextField txtAccNum, 
            txtName, txtDOB, txtGender, // Row 1
            txtMobNum, txtIdType, txtIdNum, // Row 2 
            txtEmail, txtFN, // Row 3
            txtPC, txtHA, txtCity, // Row 5
            txtAccTitle, txtAccBal, txtAccType; // Row 6
    
    private ImageIcon icon;
    private JButton btnRegister, btnImage; 
    private JComboBox<String> cbGender,cbIdType, cbAccType;
    private JSeparator topSep, midSep1, midSep2, botSep;

    public NewAccountBoard() {
        setLayout(null);
        setBackground(new Color(235, 235, 235));
        setBounds(0, 0, 1670, 1080);

        //Title & Acc Num Row
        lblMTitle = new JLabel("New Account Form");
        lblMTitle.setBounds(50, 40, 400, 40);
        lblMTitle.setFont(new Font("Segoe UI", Font.BOLD, 25));
        add(lblMTitle);
        
        txtAccNum = new JTextField("SPB1000000009");
        txtAccNum.setHorizontalAlignment(JTextField.RIGHT);
        txtAccNum.setEditable(false);
        txtAccNum.setBackground(ColorPalette.Gray);
        txtAccNum.setBounds(1120, 40, 500, 40);
        txtAccNum.setFont(new Font("Segoe UI", Font.BOLD, 25));
        add(txtAccNum);
        
        // Blue Separator
        topSep = new JSeparator();
        topSep.setBounds(50, 100, 1585, 2);
        topSep.setBackground(ColorPalette.Blue5);
        add(topSep);
        
        //For fontstyle
        Font subtFont = new Font("Segoe UI", Font.BOLD, 18);
        Font labelFont = new Font("Segoe UI", Font.BOLD, 16);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 16);

        // Personal Infos: Row 1        
        lblSubt1 = new JLabel("Personal Information");
        lblSubt1.setBounds(50, 125, 200, 20);
        lblSubt1.setFont(subtFont);
        add(lblSubt1);
        
        lblName = new JLabel("Name");
        lblName.setBounds(60, 160, 100, 22);
        lblName.setFont(labelFont);
        add(lblName);

        txtName = new JTextField("Enter full name");
        txtName.setBounds(60, 185, 450, 35);
        txtName.setFont(fieldFont);
        txtName.setEditable(false);
        add(txtName);
        
        lblDOB = new JLabel("Date of Birth");
        lblDOB.setBounds(550, 160, 150, 22);
        lblDOB.setFont(labelFont);
        add(lblDOB);
        
        txtDOB = new JTextField("MM/DD/YYYY");
        txtDOB.setBounds(550, 185, 450, 35);
        txtDOB.setFont(fieldFont);
        txtDOB.setEditable(false);
        add(txtDOB);
        
        lblFN = new JLabel("Gender");
        lblFN.setBounds(1050, 160, 150, 22);
        lblFN.setFont(labelFont);
        add(lblFN);
        
        cbGender = new JComboBox<>(new String[]{"Select gender","Male","Female"});
        cbGender.setFont(fieldFont);
        cbGender.setBounds(1050, 185, 450, 35);
        add(cbGender);

        // Personal Infos: Row 2
        lblMobNum = new JLabel("Mobile Number");
        lblMobNum.setBounds(60, 235, 150, 22);
        lblMobNum.setFont(labelFont);
        add(lblMobNum);
        
        txtMobNum = new JTextField("Enter mobile number");
        txtMobNum.setBounds(60, 260, 450, 35);
        txtMobNum.setFont(fieldFont);
        txtMobNum.setEditable(false);
        add(txtMobNum);
        
        lblIdType = new JLabel("Type of Valid ID");
        lblIdType.setBounds(550, 235, 150, 22);
        lblIdType.setFont(labelFont);
        add(lblIdType);
        
        cbIdType = new JComboBox<>(new String[]{"Select ID type","National ID","Passport","Driver's License"});
        cbIdType.setFont(fieldFont);
        cbIdType.setBounds(550, 260, 450, 35);
        add(cbIdType);
        
        lblIdNum = new JLabel("ID Number");
        lblIdNum.setBounds(1050, 235, 150, 22);
        lblIdNum.setFont(labelFont);
        add(lblIdNum);
        
        txtIdNum = new JTextField("Enter ID number");
        txtIdNum.setBounds(1050, 260, 450, 35);
        txtIdNum.setFont(fieldFont);
        txtIdNum.setEditable(false);
        add(txtIdNum);
        
        // Personal Infos: Row 3
        lblEmail = new JLabel("Email");
        lblEmail.setBounds(60, 310, 100, 22);
        lblEmail.setFont(labelFont);
        add(lblEmail);
        
        txtEmail = new JTextField("Enter email account");
        txtEmail.setBounds(60, 335, 450, 35);
        txtEmail.setFont(fieldFont);
        txtEmail.setEditable(false);
        add(txtEmail);
        
        lblFN = new JLabel("Father Name");
        lblFN.setBounds(550, 310, 150, 22);
        lblFN.setFont(labelFont);
        add(lblFN);
        
        txtFN = new JTextField("Enter father name");
        txtFN.setBounds(550, 335, 450, 35);
        txtFN.setFont(fieldFont);
        txtFN.setEditable(false);
        add(txtFN);
        
        // Blue Separator
        midSep1 = new JSeparator();
        midSep1.setBounds(50, 390, 1585, 2);
        midSep1.setBackground(ColorPalette.Blue5);
        add(midSep1);
        
        // Profile section: Row 4
        lblSubt2 = new JLabel("Profile Image");
        lblSubt2.setBounds(50, 420, 150, 28);
        lblSubt2.setFont(subtFont);
        add(lblSubt2);
        
        lblImage = new JLabel();
        lblImage.setBounds(800, 425, 120, 120);
        lblImage.setBorder(new LineBorder(Color.GRAY, 1, true));

        icon = new ImageIcon(getClass().getResource("/profile.png"));
        Image img = icon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        lblImage.setIcon(new ImageIcon(img));
        add(lblImage);
        
        btnImage = new JButton("Choose Image");
        btnImage.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnImage.setBounds(60, 540, 150, 25);
        btnImage.setFocusPainted(false);
        btnImage.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnImage.addActionListener(e -> chooseImage());
        add(btnImage);
        
        lblImagePath = new JLabel("No file chosen");
        lblImagePath.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblImagePath.setBounds(220, 540, 150, 22);
        add(lblImagePath);
        
        // Blue Separator
        botSep = new JSeparator();
        botSep.setBounds(50, 580, 1585, 2);
        botSep.setBackground(ColorPalette.Blue5);
        add(botSep);
        
        // Address: Row 5
        lblSubt3 = new JLabel("Address");
        lblSubt3.setBounds(50, 610, 150, 25);
        lblSubt3.setFont(subtFont);
        add(lblSubt3);
        
        lblPC = new JLabel("Postal Code");
        lblPC.setBounds(60, 645, 130, 22);
        lblPC.setFont(labelFont);
        add(lblPC);
        
        txtPC = new JTextField("Enter postal code");
        txtPC.setBounds(60, 670, 450, 35);
        txtPC.setFont(fieldFont);
        txtPC.setEditable(false);
        add(txtPC);
        
        lblHA = new JLabel("Home Address");
        lblHA.setBounds(550, 645, 130, 22);
        lblHA.setFont(labelFont);
        add(lblHA);
        
        txtHA = new JTextField("Enter home address");
        txtHA.setBounds(550, 670, 450, 35);
        txtHA.setFont(fieldFont);
        txtHA.setEditable(false);
        add(txtHA);
        
        lblCity = new JLabel("City");
        lblCity.setBounds(1050, 645, 130, 22);
        lblCity.setFont(labelFont);
        add(lblCity);
        
        txtCity = new JTextField("Enter city name");
        txtCity.setBounds(1050, 670, 450, 35);
        txtCity.setFont(fieldFont);
        txtCity.setEditable(false);
        add(txtCity);
        
        // Blue Separator
        midSep2 = new JSeparator();
        midSep2.setBounds(50, 725, 1585, 2);
        midSep2.setBackground(ColorPalette.Blue5);
        add(midSep2);
        
        // Account Info: Row 6
        lblSubt4 = new JLabel("Account Information");
        lblSubt4.setBounds(50, 755, 200, 25);
        lblSubt4.setFont(subtFont);
        add(lblSubt4);
        
        lblAccTitle = new JLabel("Account Title");
        lblAccTitle.setBounds(60, 790, 130, 22);
        lblAccTitle.setFont(labelFont);
        add(lblAccTitle);
        
        txtAccTitle = new JTextField("Enter account title");
        txtAccTitle.setBounds(60, 815, 450, 35);
        txtAccTitle.setFont(fieldFont);
        txtAccTitle.setEditable(false);
        add(txtAccTitle);
        
        lblAccBal = new JLabel("Account Balance");
        lblAccBal.setBounds(550, 790, 130, 22);
        lblAccBal.setFont(labelFont);
        add(lblAccBal);
        
        txtAccBal = new JTextField("Enter account balance");
        txtAccBal.setBounds(550, 815, 450, 35);
        txtAccBal.setFont(fieldFont);
        txtAccBal.setEditable(false);
        add(txtAccBal);
        
        lblAccType = new JLabel("Account Type");
        lblAccType.setBounds(1050, 790, 130, 22);
        lblAccType.setFont(labelFont);
        add(lblAccType);
        
        cbAccType = new JComboBox<>(new String[]{"Select account type","Current","Saving"});
        cbAccType.setFont(fieldFont);
        cbAccType.setBounds(1050, 815, 450, 35);
        add(cbAccType);

        // Blue Separator
        botSep = new JSeparator();
        botSep.setBounds(50, 870, 1585, 2);
        botSep.setBackground(ColorPalette.Blue5);
        add(botSep);
        
        //Register Button
        btnRegister = new JButton("Register Account");
        btnRegister.setBounds(530, 900, 500, 45);
        styleButton(btnRegister);
        btnRegister.addActionListener(e -> saveAccount());
        add(btnRegister);
    }

    private void styleButton(JButton btn) {
        btn.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btn.setForeground(Color.WHITE);
        btn.setBackground(ColorPalette.Blue5);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
    }

    private void saveAccount() {
        if (txtName.getText().trim().isEmpty()
            || txtDOB.getText().trim().isEmpty()
            || txtMobNum.getText().trim().isEmpty()
            || txtIdNum.getText().trim().isEmpty()
            || txtEmail.getText().trim().isEmpty()
            || txtFN.getText().trim().isEmpty()
            || txtPC.getText().trim().isEmpty()
            || txtHA.getText().trim().isEmpty()
            || txtCity.getText().trim().isEmpty()
            || txtAccTitle.getText().trim().isEmpty()
            || txtAccBal.getText().trim().isEmpty()
            || cbGender.getSelectedItem() == null
            || cbGender.getSelectedItem().toString().equals("Select Gender")
            || cbIdType.getSelectedItem() == null
            || cbIdType.getSelectedItem().toString().equals("Select ID Type")
            || cbAccType.getSelectedItem() == null
            || cbAccType.getSelectedItem().toString().equals("Select Account Type")) 
        {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }
        
        JOptionPane.showMessageDialog(this, "Account form submitted.\n");
        clearFields();
        
    }
    
    private void chooseImage() {
        
        JOptionPane.showMessageDialog(this,
                "This feature is not yet available :( \n");
    }

    private void clearFields() {
        txtAccNum.setText("");
        txtName.setText("");
        txtDOB.setText("");
        txtMobNum.setText("");
        txtIdNum.setText("");
        txtEmail.setText("");
        txtFN.setText("");
        txtPC.setText("");
        txtHA.setText("");
        txtCity.setText("");
        txtAccTitle.setText("");
        txtAccBal.setText("");
        cbGender.setSelectedIndex(0);
        cbIdType.setSelectedIndex(0);
        cbAccType.setSelectedIndex(0);
    }
 
}