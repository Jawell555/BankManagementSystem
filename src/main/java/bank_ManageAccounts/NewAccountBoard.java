package bank_ManageAccounts;

import Colors.ColorPalette;
import Database.AccountDatabase;
import Database.AccountSQL;
import Database.TransactionSQL;
import Models.Account;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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
    
    private final Border normalBorder = new LineBorder(Color.GRAY, 1);
    private final Border errorBorder = new LineBorder(Color.RED, 2);
    
    private String selectedImagePath;

    public NewAccountBoard() {
        setLayout(null);
        setBackground(new Color(235, 235, 235));
        setBounds(0, 0, 1670, 1080);

        //Title & Acc Num Row
        lblMTitle = new JLabel("New Account Form");
        lblMTitle.setBounds(50, 40, 400, 40);
        lblMTitle.setFont(new Font("Segoe UI", Font.BOLD, 25));
        add(lblMTitle);
        
        txtAccNum = new JTextField(generateAccountID());
        txtAccNum.setHorizontalAlignment(JTextField.RIGHT);
        txtAccNum.setBackground(ColorPalette.Gray);
        txtAccNum.setBounds(1120, 40, 500, 40);
        txtAccNum.setFont(new Font("Segoe UI", Font.BOLD, 25));
        txtAccNum.setEditable(false);
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
        add(txtName);
        
        lblDOB = new JLabel("Date of Birth");
        lblDOB.setBounds(550, 160, 150, 22);
        lblDOB.setFont(labelFont);
        add(lblDOB);
        
        txtDOB = new JTextField("MM/DD/YYYY");
        txtDOB.setBounds(550, 185, 450, 35);
        txtDOB.setFont(fieldFont);
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
        add(txtIdNum);
        
        // Personal Infos: Row 3
        lblEmail = new JLabel("Email");
        lblEmail.setBounds(60, 310, 100, 22);
        lblEmail.setFont(labelFont);
        add(lblEmail);
        
        txtEmail = new JTextField("Enter email account");
        txtEmail.setBounds(60, 335, 450, 35);
        txtEmail.setFont(fieldFont);
        add(txtEmail);
        
        lblFN = new JLabel("Father Name");
        lblFN.setBounds(550, 310, 150, 22);
        lblFN.setFont(labelFont);
        add(lblFN);
        
        txtFN = new JTextField("Enter father name");
        txtFN.setBounds(550, 335, 450, 35);
        txtFN.setFont(fieldFont);
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
        add(txtPC);
        
        lblHA = new JLabel("Home Address");
        lblHA.setBounds(550, 645, 130, 22);
        lblHA.setFont(labelFont);
        add(lblHA);
        
        txtHA = new JTextField("Enter home address");
        txtHA.setBounds(550, 670, 450, 35);
        txtHA.setFont(fieldFont);
        add(txtHA);
        
        lblCity = new JLabel("City");
        lblCity.setBounds(1050, 645, 130, 22);
        lblCity.setFont(labelFont);
        add(lblCity);
        
        txtCity = new JTextField("Enter city name");
        txtCity.setBounds(1050, 670, 450, 35);
        txtCity.setFont(fieldFont);
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
        add(txtAccTitle);
        
        lblAccBal = new JLabel("Account Balance");
        lblAccBal.setBounds(550, 790, 130, 22);
        lblAccBal.setFont(labelFont);
        add(lblAccBal);
        
        txtAccBal = new JTextField("Enter account balance");
        txtAccBal.setBounds(550, 815, 450, 35);
        txtAccBal.setFont(fieldFont);
        add(txtAccBal);
        
        lblAccType = new JLabel("Account Type");
        lblAccType.setBounds(1050, 790, 130, 22);
        lblAccType.setFont(labelFont);
        add(lblAccType);
        
        cbAccType = new JComboBox<>(new String[]{"Select account type","Savings","Current"});
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
        if (!validateForm()) {
            JOptionPane.showMessageDialog(this, "Please fix highlighted fields.");
            return;
        }
        
        Account acc = new Account();

        acc.setAccNo(txtAccNum.getText());
        acc.setName(txtName.getText());
        acc.setFatherName(txtFN.getText());
        
        //Email format validation
        String email = txtEmail.getText().trim();
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            JOptionPane.showMessageDialog(this, "Invalid email format.");
            return;
        }
        acc.setEmail(email);
        acc.setIdType(cbIdType.getSelectedItem().toString());
        acc.setIdNumber(txtIdNum.getText());
        acc.setAccType(cbAccType.getSelectedItem().toString());
        acc.setAccTitle(txtAccTitle.getText());
        
        //Balance Validation
        double balance; 
        try {
            balance = Double.parseDouble(txtAccBal.getText().trim());

            if (balance < 0) {
                JOptionPane.showMessageDialog(this, "Balance cannot be negative.");
                return;
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Balance must be a valid number (e.g. 1000.50).");
            return;
        }

        acc.setAccBal(balance);
        acc.setDate(java.time.LocalDate.now().toString());
        acc.setAccStatus("Active");
        String dobInput = txtDOB.getText().trim();

        try {

            DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
          
            LocalDate dob = LocalDate.parse(dobInput, inputFormat);
            acc.setDob(dob.toString()); // yyyy-MM-dd
            
            LocalDate birthDate = LocalDate.parse(dobInput, inputFormat);
            
            //Future Date Validation
            if (birthDate.isAfter(LocalDate.now())) {
            JOptionPane.showMessageDialog(this,"Birth date cannot be in the future.");
            markInvalid(txtDOB);
            }
            
            // Age validation
            int age = Period.between(birthDate,LocalDate.now()).getYears();

            if (age < 18) {
                JOptionPane.showMessageDialog(this,"Customer must be at least 18 years old.");
                markInvalid(txtDOB);
            }

            markValid(txtDOB);

        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this,"Invalid Date of Birth format.\nUse MM/DD/YYYY");
            return;
        }
        acc.setGender(cbGender.getSelectedItem().toString());
        
        //Mobile # format validation
        String mobile = txtMobNum.getText().trim();
        if (!mobile.matches("^09\\d{9}$")) {
            JOptionPane.showMessageDialog(this, "Invalid mobile number. Use 09XXXXXXXXX format.");
            return;
        }
        acc.setMobileNumber(mobile);

        acc.setPostalCode(txtPC.getText());
        acc.setHomeAddress(txtHA.getText());
        acc.setCity(txtCity.getText());
        
        //Profile Picture logic
        String savedImagePath = "profile_images/default.png";

        if (selectedImagePath != null) {

            try {

                File source = new File(selectedImagePath);

                File folder = new File("profile_images");

                if (!folder.exists()) {
                    folder.mkdirs();
                }

                String extension = "";

                int dot = source.getName().lastIndexOf('.');

                if (dot > 0) {
                    extension = source.getName().substring(dot);
                }

                File destination = new File(folder,txtAccNum.getText() + extension);
                Files.copy(source.toPath(),destination.toPath(),StandardCopyOption.REPLACE_EXISTING);
                savedImagePath = destination.getPath();

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,"Failed to save profile image.");
            }
        }
        
        acc.setProfileImage(savedImagePath);
        
      boolean success = AccountSQL.addAccount(acc);
      
        if (success && balance > 0) {

            TransactionSQL transactionSql = new TransactionSQL();

            transactionSql.addTransaction(
                    transactionSql.generateRefNumber(),
                    acc.getName(),
                    acc.getAccNo(),
                    "BANK",
                    "Opening Balance",
                    java.time.LocalDateTime.now(),
                    "Initial Deposit",
                    balance
            );
        }

        if (success) {
            JOptionPane.showMessageDialog(this,"Account Registered Successfully!");

            clearFields();

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Failed to register account."
            );
        }
        clearFields();
        
    }
    
   private void chooseImage() {

        JFileChooser chooser = new JFileChooser();

        int result = chooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {

            File file = chooser.getSelectedFile();
            selectedImagePath = file.getAbsolutePath();
            lblImagePath.setText(file.getName());
            ImageIcon icon = new ImageIcon(selectedImagePath);
            Image img = icon.getImage().getScaledInstance(120, 120,Image.SCALE_SMOOTH);
            lblImage.setIcon(new ImageIcon(img));
        }
    }

    private void clearFields() {
        txtAccNum.setText(generateAccountID());
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
        
        selectedImagePath = null;
        lblImagePath.setText("No file chosen");

        ImageIcon icon = new ImageIcon(getClass().getResource("/profile.png"));

        Image img = icon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);

        lblImage.setIcon(new ImageIcon(img));
    }
    private String generateAccountID() {

           long highest = 1000000000L;

           for (Account acc : AccountSQL.getAllAccounts()) {

               if (acc.getAccNo()!= null &&
                   acc.getAccNo().startsWith("SPB")) {

                   try {

                       long num = Long.parseLong(acc.getAccNo().substring(3));

                       if (num > highest) {
                           highest = num;
                       }

                   } catch (NumberFormatException ex) {
                       // Ignore invalid IDs
                   }
               }
           }

           return "SPB" + (highest + 1);
    }
    
    private boolean validateField(JTextField field, String placeholder) {
        String value = field.getText().trim();

        if (value.isEmpty() || value.equalsIgnoreCase(placeholder)) {
            markInvalid(field);
            return false;
        } else {
            markValid(field);
            return true;
        }
    }
    private void markValid(JTextField field) {
        field.setBorder(normalBorder);
    }

    private void markInvalid(JTextField field) {
        field.setBorder(errorBorder);
    }
    
    //Form Validation
    private boolean validateForm() {

        boolean valid = true;

        valid &= validateField(txtName, "Enter full name");
        valid &= validateField(txtDOB, "MM/DD/YYYY");
        valid &= validateField(txtMobNum, "Enter mobile number");
        valid &= validateField(txtIdNum, "Enter ID number");
        valid &= validateField(txtEmail, "Enter email account");
        valid &= validateField(txtFN, "Enter father name");
        valid &= validateField(txtPC, "Enter postal code");
        valid &= validateField(txtHA, "Enter home address");
        valid &= validateField(txtCity, "Enter city name");
        valid &= validateField(txtAccTitle, "Enter account title");
        valid &= validateField(txtAccBal, "Enter account balance");

        // Combo boxes
        if (cbGender.getSelectedIndex() == 0) {
            cbGender.setBorder(errorBorder);
            valid = false;
        } else {
            cbGender.setBorder(normalBorder);
        }

        if (cbIdType.getSelectedIndex() == 0) {
            cbIdType.setBorder(errorBorder);
            valid = false;
        } else {
            cbIdType.setBorder(normalBorder);
        }

        if (cbAccType.getSelectedIndex() == 0) {
            cbAccType.setBorder(errorBorder);
            valid = false;
        } else {
            cbAccType.setBorder(normalBorder);
        }

        // Balance numeric check
        try {
            double bal = Double.parseDouble(txtAccBal.getText().trim());
            if (bal < 0) {
                markInvalid(txtAccBal);
                valid = false;
            }
        } catch (Exception e) {
            markInvalid(txtAccBal);
            valid = false;
        }

        return valid;
    }
}