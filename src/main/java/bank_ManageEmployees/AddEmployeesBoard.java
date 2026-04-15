/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank_ManageEmployees;

import Colors.ColorPalette;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class AddEmployeesBoard extends JPanel {

    private JLabel lblMTitle, lblSubt1,
            lblName, lblDOB, lblGender, // Row 1
            lblMarital, lblMobNum, lblIdNum, // Row 2 
            lblEmail, lblFN, // Row 3
            lblSubt2, lblImage, lblImagePath, // Row 4
            lblSubt3, lblPC, lblHA, lblCity, // Row 5
            lblSubt4, lblEducLvl, lblCurrJob, lblYrExp, // Row 6
            lblSubt5, lblUsername, lblUserType; // Row 7
    
    private JTextField txtAccNum, 
            txtName, txtDOB, txtGender, // Row 1
            txtMobNum, txtIdNum, // Row 2 
            txtEmail, txtFN, // Row 3
            txtPC, txtHA, txtCity, // Row 5
            txtEducLvl, txtCurrJob,txtYrExp, // Row 6
            txtUsername, txtUserType; // Row 7
    
    private ImageIcon icon;
    private JButton btnRegister, btnImage; 
    private JComboBox<String> cbGender,cbMarital, cbUserType;
    private JSeparator topSep, midSep1, midSep2, midSep3, botSep;

    public AddEmployeesBoard() {
        setLayout(null);
        setBackground(new Color(235, 235, 235));
        setBounds(0, 0, 1670, 1080);

        //Title & Acc Num Row
        lblMTitle = new JLabel("Add Employee Form");
        lblMTitle.setBounds(50, 40, 400, 40);
        lblMTitle.setFont(new Font("Segoe UI", Font.BOLD, 25));
        add(lblMTitle);
        
        txtAccNum = new JTextField("EMP2011");
        txtAccNum.setHorizontalAlignment(JTextField.RIGHT);
        txtAccNum.setEditable(false);
        txtAccNum.setBackground(ColorPalette.Gray);
        txtAccNum.setBounds(1120, 40, 300, 40);
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
        lblMarital = new JLabel("Marital Status");
        lblMarital.setBounds(60, 235, 150, 22);
        lblMarital.setFont(labelFont);
        add(lblMarital);
        
        cbMarital = new JComboBox<>(new String[]{"Select marital status","Single","Married","Separated","Widowed"});
        cbMarital.setFont(fieldFont);
        cbMarital.setBounds(60, 260, 450, 35);
        cbMarital.setEditable(false);
        add(cbMarital);
        
        lblMobNum = new JLabel("Mobile Number");
        lblMobNum.setBounds(550, 235, 150, 22);
        lblMobNum.setFont(labelFont);
        add(lblMobNum);
        
        txtMobNum = new JTextField("Enter mobile number");
        txtMobNum.setBounds(550, 260, 450, 35);
        txtMobNum.setFont(fieldFont);
        txtMobNum.setEditable(false);
        add(txtMobNum);
        
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
        lblSubt4 = new JLabel("Education & Experience");
        lblSubt4.setBounds(50, 755, 200, 25);
        lblSubt4.setFont(subtFont);
        add(lblSubt4);
        
        lblEducLvl= new JLabel("Education Level");
        lblEducLvl.setBounds(60, 790, 130, 22);
        lblEducLvl.setFont(labelFont);
        add(lblEducLvl);
        
        txtEducLvl = new JTextField("Enter education");
        txtEducLvl.setBounds(60, 815, 450, 35);
        txtEducLvl.setFont(fieldFont);
        txtEducLvl.setEditable(false);
        add(txtEducLvl);
        
        lblCurrJob = new JLabel("Current Job");
        lblCurrJob.setBounds(550, 790, 130, 22);
        lblCurrJob.setFont(labelFont);
        add(lblCurrJob);
        
        txtCurrJob = new JTextField("Enter current job title");
        txtCurrJob.setBounds(550, 815, 450, 35);
        txtCurrJob.setFont(fieldFont);
        txtCurrJob.setEditable(false);
        add(txtCurrJob);
        
        lblYrExp = new JLabel("Experience");
        lblYrExp.setBounds(1050, 790, 130, 22);
        lblYrExp.setFont(labelFont);
        add(lblYrExp);

        txtYrExp = new JTextField("Enter year experience");
        txtYrExp.setBounds(1050, 815, 450, 35);
        txtYrExp.setFont(fieldFont);
        txtYrExp.setEditable(false);
        add(txtYrExp);
        
         // Blue Separator
        botSep = new JSeparator();
        botSep.setBounds(50, 870, 1585, 2);
        botSep.setBackground(ColorPalette.Blue5);
        add(botSep);
        
        // Account Details: Row 7
//        lblSubt4 = new JLabel("Account Details");
//        lblSubt4.setBounds(50, 755, 200, 25);
//        lblSubt4.setFont(subtFont);
//        add(lblSubt4);
//        
//        lblAccTitle = new JLabel("Username);
//        lblAccTitle.setBounds(60, 790, 130, 22);
//        lblAccTitle.setFont(labelFont);
//        add(lblAccTitle);
//        
//        txtAccTitle = new JTextField("Enter username for login");
//        txtAccTitle.setBounds(60, 815, 450, 35);
//        txtAccTitle.setFont(fieldFont);
//        txtAccTitle.setEditable(false);
//        add(txtAccTitle);
//        
//        lblAccType = new JLabel("User Type");
//        lblAccType.setBounds(1050, 790, 130, 22);
//        lblAccType.setFont(labelFont);
//        add(lblAccType);
//        
//        cbAccType = new JComboBox<>(new String[]{"Select user type","Employee"});
//        cbAccType.setFont(fieldFont);
//        cbAccType.setBounds(1050, 815, 450, 35);
//        add(cbAccType);
//        
//        //Blue Separator
        
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
            || txtGender.getText().trim().isEmpty()
            || txtMobNum.getText().trim().isEmpty()
            || txtIdNum.getText().trim().isEmpty()
            || txtEmail.getText().trim().isEmpty()
            || txtFN.getText().trim().isEmpty()
            || txtPC.getText().trim().isEmpty()
            || txtHA.getText().trim().isEmpty()
            || txtCity.getText().trim().isEmpty()
            || txtUsername.getText().trim().isEmpty()
            || cbGender.getSelectedItem() == null
            || cbGender.getSelectedItem().toString().equals("Select Gender")
            || cbMarital.getSelectedItem() == null
            || cbMarital.getSelectedItem().toString().equals("Select marital status")
            || cbUserType.getSelectedItem() == null
            || cbUserType.getSelectedItem().toString().equals("Select user type")) 
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
        txtUsername.setText("");
        cbGender.setSelectedIndex(0);
        cbMarital.setSelectedIndex(0);
        cbUserType.setSelectedIndex(0);
    }
 
}