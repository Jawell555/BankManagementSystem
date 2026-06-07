package bank_ManageEmployees;

import Colors.ColorPalette;
import Database.EmployeeDatabase;
import Database.EmployeeSQL;
import Models.Employee;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
            lblSubt5, lblUsername, lblUserType, lblPassword; // Row 7
    
    private JTextField txtAccNum, 
            txtName, txtDOB, txtGender, // Row 1
            txtMobNum, txtIdNum, // Row 2 
            txtEmail, txtFN, // Row 3
            txtPC, txtHA, txtCity, // Row 5
            txtEducLvl, txtCurrJob,txtYrExp, // Row 6
            txtUsername, txtUserType, txtPassword; // Row 7
    
    private ImageIcon icon;
    private JButton btnRegister, btnImage; 
    private JComboBox<String> cbGender,cbMarital;
    private JSeparator topSep, midSep1, midSep2, midSep3, botSep, botSep2;
    
    private JPanel contentPanel;
    private JScrollPane scrollPane;
    
    private final LineBorder RED_BORDER = new LineBorder(Color.RED, 2);
    private final LineBorder DEFAULT_BORDER = new LineBorder(Color.GRAY, 1);
    
    private String selectedImagePath;

    public AddEmployeesBoard() {
        setLayout(null);
        setBackground(new Color(235, 235, 235));
        setBounds(0, 0, 1670, 1080);
        setLayout(new java.awt.BorderLayout());
        
        contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setBackground(new Color(235, 235, 235));
        contentPanel.setPreferredSize(new Dimension(1670, 1100));
        
        //Title & Acc Num Row
        lblMTitle = new JLabel("Add Employee Form");
        lblMTitle.setBounds(50, 40, 400, 40);
        lblMTitle.setFont(new Font("Segoe UI", Font.BOLD, 25));
        contentPanel.add(lblMTitle);
        
        txtAccNum = new JTextField(generateEmployeeID());
        txtAccNum.setHorizontalAlignment(JTextField.RIGHT);
        txtAccNum.setBackground(ColorPalette.Gray);
        txtAccNum.setBounds(1120, 40, 500, 40);
        txtAccNum.setFont(new Font("Segoe UI", Font.BOLD, 25));
        contentPanel.add(txtAccNum);
        
        // Blue Separator
        topSep = new JSeparator();
        topSep.setBounds(50, 100, 1585, 2);
        topSep.setBackground(ColorPalette.Blue5);
        contentPanel.add(topSep);
        
        //For fontstyle
        Font subtFont = new Font("Segoe UI", Font.BOLD, 18);
        Font labelFont = new Font("Segoe UI", Font.BOLD, 16);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 16);

        // Personal Infos: Row 1        
        lblSubt1 = new JLabel("Personal Information");
        lblSubt1.setBounds(50, 125, 200, 20);
        lblSubt1.setFont(subtFont);
        contentPanel.add(lblSubt1);
        
        lblName = new JLabel("Name");
        lblName.setBounds(60, 160, 100, 22);
        lblName.setFont(labelFont);
        contentPanel.add(lblName);

        txtName = new JTextField("Enter full name");
        txtName.setBounds(60, 185, 450, 35);
        txtName.setFont(fieldFont);
        contentPanel.add(txtName);
        
        lblDOB = new JLabel("Date of Birth");
        lblDOB.setBounds(550, 160, 150, 22);
        lblDOB.setFont(labelFont);
        contentPanel.add(lblDOB);
        
        txtDOB = new JTextField("MM/DD/YYYY");
        txtDOB.setBounds(550, 185, 450, 35);
        txtDOB.setFont(fieldFont);
        contentPanel.add(txtDOB);
        
        lblGender = new JLabel("Gender");
        lblGender.setBounds(1050, 160, 150, 22);
        lblGender.setFont(labelFont);
        contentPanel.add(lblGender);
        
        cbGender = new JComboBox<>(new String[]{"Select gender","Male","Female"});
        cbGender.setFont(fieldFont);
        cbGender.setBounds(1050, 185, 450, 35);
        contentPanel.add(cbGender);

        // Personal Infos: Row 2
        lblMarital = new JLabel("Marital Status");
        lblMarital.setBounds(60, 235, 150, 22);
        lblMarital.setFont(labelFont);
        contentPanel.add(lblMarital);
        
        cbMarital = new JComboBox<>(new String[]{"Select marital status","Single","Married","Separated","Widowed"});
        cbMarital.setFont(fieldFont);
        cbMarital.setBounds(60, 260, 450, 35);
        contentPanel.add(cbMarital);
        
        lblMobNum = new JLabel("Mobile Number");
        lblMobNum.setBounds(550, 235, 150, 22);
        lblMobNum.setFont(labelFont);
        contentPanel.add(lblMobNum);
        
        txtMobNum = new JTextField("Enter mobile number");
        txtMobNum.setBounds(550, 260, 450, 35);
        txtMobNum.setFont(fieldFont);
        contentPanel.add(txtMobNum);
        
        lblIdNum = new JLabel("ID Number");
        lblIdNum.setBounds(1050, 235, 150, 22);
        lblIdNum.setFont(labelFont);
        contentPanel.add(lblIdNum);
        
        txtIdNum = new JTextField("Enter ID number");
        txtIdNum.setBounds(1050, 260, 450, 35);
        txtIdNum.setFont(fieldFont);
        contentPanel.add(txtIdNum);
        
        // Personal Infos: Row 3
        lblEmail = new JLabel("Email");
        lblEmail.setBounds(60, 310, 100, 22);
        lblEmail.setFont(labelFont);
        contentPanel.add(lblEmail);
        
        txtEmail = new JTextField("Enter email account");
        txtEmail.setBounds(60, 335, 450, 35);
        txtEmail.setFont(fieldFont);
        contentPanel.add(txtEmail);
        
        lblFN = new JLabel("Father Name");
        lblFN.setBounds(550, 310, 100, 22);
        lblFN.setFont(labelFont);
        contentPanel.add(lblFN);
        
        txtFN = new JTextField("Enter father name");
        txtFN.setBounds(550, 335, 450, 35);
        txtFN.setFont(fieldFont);
        contentPanel.add(txtFN);
        
        // Blue Separator
        midSep1 = new JSeparator();
        midSep1.setBounds(50, 390, 1585, 2);
        midSep1.setBackground(ColorPalette.Blue5);
        contentPanel.add(midSep1);
        
        // Profile section: Row 4
        lblSubt2 = new JLabel("Profile Image");
        lblSubt2.setBounds(50, 420, 150, 28);
        lblSubt2.setFont(subtFont);
        contentPanel.add(lblSubt2);
        
        lblImage = new JLabel();
        lblImage.setBounds(800, 425, 120, 120);
        lblImage.setBorder(new LineBorder(Color.GRAY, 1, true));

        icon = new ImageIcon(getClass().getResource("/profile.png"));
        Image img = icon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        lblImage.setIcon(new ImageIcon(img));
        contentPanel.add(lblImage);
        
        btnImage = new JButton("Choose Image");
        btnImage.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnImage.setBounds(60, 540, 150, 25);
        btnImage.setFocusPainted(false);
        btnImage.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnImage.addActionListener(e -> chooseImage());
        contentPanel.add(btnImage);
        
        lblImagePath = new JLabel("No file chosen");
        lblImagePath.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblImagePath.setBounds(220, 540, 150, 22);
        contentPanel.add(lblImagePath);
        
        // Blue Separator
        botSep = new JSeparator();
        botSep.setBounds(50, 580, 1585, 2);
        botSep.setBackground(ColorPalette.Blue5);
        contentPanel.add(botSep);
        
        // Address: Row 5
        lblSubt3 = new JLabel("Address");
        lblSubt3.setBounds(50, 610, 150, 25);
        lblSubt3.setFont(subtFont);
        contentPanel.add(lblSubt3);
        
        lblPC = new JLabel("Postal Code");
        lblPC.setBounds(60, 645, 130, 22);
        lblPC.setFont(labelFont);
        contentPanel.add(lblPC);
        
        txtPC = new JTextField("Enter postal code");
        txtPC.setBounds(60, 670, 450, 35);
        txtPC.setFont(fieldFont);
        contentPanel.add(txtPC);
        
        lblHA = new JLabel("Home Address");
        lblHA.setBounds(550, 645, 130, 22);
        lblHA.setFont(labelFont);
        contentPanel.add(lblHA);
        
        txtHA = new JTextField("Enter home address");
        txtHA.setBounds(550, 670, 450, 35);
        txtHA.setFont(fieldFont);
        contentPanel.add(txtHA);
        
        lblCity = new JLabel("City");
        lblCity.setBounds(1050, 645, 130, 22);
        lblCity.setFont(labelFont);
        contentPanel.add(lblCity);
        
        txtCity = new JTextField("Enter city name");
        txtCity.setBounds(1050, 670, 450, 35);
        txtCity.setFont(fieldFont);
        contentPanel.add(txtCity);
        
        // Blue Separator
        midSep2 = new JSeparator();
        midSep2.setBounds(50, 725, 1585, 2);
        midSep2.setBackground(ColorPalette.Blue5);
        contentPanel.add(midSep2);
        
        // Account Info: Row 6
        lblSubt4 = new JLabel("Education & Experience");
        lblSubt4.setBounds(50, 755, 250, 25);
        lblSubt4.setFont(subtFont);
        contentPanel.add(lblSubt4);
        
        lblEducLvl= new JLabel("Bachelor's Degree");
        lblEducLvl.setBounds(60, 790, 130, 22);
        lblEducLvl.setFont(labelFont);
        contentPanel.add(lblEducLvl);
        
        txtEducLvl = new JTextField("Enter education");
        txtEducLvl.setBounds(60, 815, 450, 35);
        txtEducLvl.setFont(fieldFont);
        contentPanel.add(txtEducLvl);
        
        lblCurrJob = new JLabel("Current Job");
        lblCurrJob.setBounds(550, 790, 130, 22);
        lblCurrJob.setFont(labelFont);
        contentPanel.add(lblCurrJob);
        
        txtCurrJob = new JTextField("Enter current job title");
        txtCurrJob.setBounds(550, 815, 450, 35);
        txtCurrJob.setFont(fieldFont);
        contentPanel.add(txtCurrJob);
        
        lblYrExp = new JLabel("Experience");
        lblYrExp.setBounds(1050, 790, 130, 22);
        lblYrExp.setFont(labelFont);
        contentPanel.add(lblYrExp);

        txtYrExp = new JTextField("Enter year experience");
        txtYrExp.setBounds(1050, 815, 450, 35);
        txtYrExp.setFont(fieldFont);
        contentPanel.add(txtYrExp);
        
         // Blue Separator
        botSep = new JSeparator();
        botSep.setBounds(50, 870, 1585, 2);
        botSep.setBackground(ColorPalette.Blue5);
        contentPanel.add(botSep);
        
        // Account Details: Row 7
        lblSubt5 = new JLabel("Account Details");
        lblSubt5.setBounds(50, 900, 200, 25);
        lblSubt5.setFont(subtFont);
        contentPanel.add(lblSubt5);
        
        lblUsername = new JLabel("Username");
        lblUsername.setBounds(60, 935, 130, 22);
        lblUsername.setFont(labelFont);
        contentPanel.add(lblUsername);
        
        txtUsername = new JTextField("Enter username for login");
        txtUsername.setBounds(60, 960, 450, 35);
        txtUsername.setFont(fieldFont);
        contentPanel.add(txtUsername);
        
        lblUserType = new JLabel("User Type");
        lblUserType.setBounds(550, 935, 130, 22);
        lblUserType.setFont(labelFont);
        contentPanel.add(lblUserType);
        
        txtUserType = new JTextField("Employee");
        txtUserType.setFont(fieldFont);
        txtUserType.setEditable(false);
        txtUserType.setBounds(550, 960, 450, 35);
        contentPanel.add(txtUserType);
        
        lblPassword = new JLabel("Password");
        lblPassword.setBounds(1050, 935, 130, 22);
        lblPassword.setFont(labelFont);
        contentPanel.add(lblPassword);
        
        txtPassword = new JTextField(generateEmployeeID());
        txtPassword.setFont(fieldFont);
        txtPassword.setEditable(false);
        txtPassword.setBounds(1050, 960, 450, 35);
        contentPanel.add(txtPassword);
        
        //Blue Separator
        botSep2 = new JSeparator();
        botSep2.setBounds(50, 1015, 1585, 2);
        botSep2.setBackground(ColorPalette.Blue5);
        contentPanel.add(botSep2);
        
        //Register Button
        btnRegister = new JButton("Register Account");
        btnRegister.setBounds(530, 1045, 500, 45);
        styleButton(btnRegister);
        btnRegister.addActionListener(e -> saveAccount());
        contentPanel.add(btnRegister);
        
        //ScrollPane
        scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setBackground(new Color(235,235,235));
        add(scrollPane, BorderLayout.CENTER);

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
            JOptionPane.showMessageDialog(this, "Please fill in all required fields.");
            return;
        }
        
        Employee emp = new Employee();

        emp.setEmpID(txtAccNum.getText());
        emp.setEmpName(txtName.getText());
        
        //Email format validation
        if (!txtEmail.getText().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            txtEmail.setBorder(RED_BORDER);
            JOptionPane.showMessageDialog(this, "Invalid email address.");
            return;
        }
        
        emp.setEmail(txtEmail.getText());
        emp.setIdNumber(txtIdNum.getText());

        emp.setDob(txtDOB.getText());
        String dobInput = txtDOB.getText().trim();

        try {
            DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
          
            LocalDate dob = LocalDate.parse(dobInput, inputFormat);
            emp.setDob(dob.toString()); // yyyy-MM-dd
            
            LocalDate birthDate = LocalDate.parse(dobInput, inputFormat);
            
            //Future Date Validation
            if (birthDate.isAfter(LocalDate.now())) {
                JOptionPane.showMessageDialog(this,"Birth date cannot be in the future.");
                txtDOB.setBorder(RED_BORDER);
            }
            
            // Age validation
            int age = Period.between(birthDate,LocalDate.now()).getYears();

            if (age < 18) {
                JOptionPane.showMessageDialog(this,"Customer must be at least 18 years old.");
                txtDOB.setBorder(RED_BORDER);
            }

      

        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this,"Invalid Date of Birth format.\nUse MM/DD/YYYY");
            return;
        }
        emp.setGender(cbGender.getSelectedItem().toString());
        emp.setMaritalStatus(cbMarital.getSelectedItem().toString());
        
        //Mobile # format validation
        if (!txtMobNum.getText().matches("^09\\d{9}$")) {
            txtMobNum.setBorder(RED_BORDER);
            JOptionPane.showMessageDialog(this, "Mobile number must be 11 digits and start with 09.");
            return;
        }
        emp.setMobileNumber(txtMobNum.getText());

        emp.setPostalCode(txtPC.getText());
        emp.setHomeAddress(txtHA.getText());
        emp.setCity(txtCity.getText());

        emp.setEducationLevel(txtEducLvl.getText());
        emp.setCurrentJob(txtCurrJob.getText());
        
        //Years of Experience validation
        try {
            int years = Integer.parseInt(txtYrExp.getText());

            if (years < 0) {
                throw new NumberFormatException();
            }

        } catch (NumberFormatException ex) {
            txtYrExp.setBorder(RED_BORDER);
            JOptionPane.showMessageDialog(this, "Years of experience must be a valid number.");
            return;
        }
        
        emp.setYearsExperience(txtYrExp.getText());
        
        for (Employee emplo : EmployeeSQL.getAllEmployees()) {

           if (emplo.getUsername().equalsIgnoreCase(txtUsername.getText().trim())) {

               txtUsername.setBorder(RED_BORDER);
               JOptionPane.showMessageDialog(this,"Username already exists.");

               return;
           }
       }
        
        emp.setUsername(txtUsername.getText());
        emp.setPassword(emp.getEmpID());

        emp.setEmpType(txtUserType.getText());
        emp.setDate(java.time.LocalDate.now().toString());
        emp.setStatus("Active");
        
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

                Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);

                savedImagePath = destination.getAbsolutePath();

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Failed to save profile image.");
            }
        }
        
        emp.setProfileImage(savedImagePath);
       
        EmployeeSQL.addEmployee(emp);

        JOptionPane.showMessageDialog(this, "Employee Registered Successfully!");
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
            Image img = icon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            lblImage.setIcon(new ImageIcon(img));
        }
    }

    private void clearFields() {
        txtAccNum.setText(generateEmployeeID());
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
    }
    
    private String generateEmployeeID() {

        int highest = 2000;

        for (Employee emp : EmployeeSQL.getAllEmployees()) {

            if (emp.getEmpID() != null &&
                emp.getEmpID().startsWith("EMP")) {

                try {

                    int num = Integer.parseInt(emp.getEmpID().substring(3));

                    if (num > highest) {
                        highest = num;
                    }

                } catch (NumberFormatException ex) {
                    // Ignore invalid IDs
                }
            }
        }

        return "EMP" + (highest + 1);
    }
    
    private boolean validateTextField(JTextField field, String placeholder) {

        String text = field.getText().trim();

        if (text.isEmpty() || text.equalsIgnoreCase(placeholder)) {
            field.setBorder(RED_BORDER);
            return false;
        }

        field.setBorder(DEFAULT_BORDER);
        return true;
    }

    private boolean validateComboBox(JComboBox<?> combo) {

        if (combo.getSelectedIndex() == 0) {
            combo.setBorder(RED_BORDER);
            return false;
        }

        combo.setBorder(UIManager.getBorder("ComboBox.border"));
        return true;
    }
    
    private boolean validateForm(){
        boolean valid = true;

        valid &= validateTextField(txtName, "Enter full name");
        valid &= validateTextField(txtDOB, "MM/DD/YYYY");
        valid &= validateTextField(txtMobNum, "Enter mobile number");
        valid &= validateTextField(txtIdNum, "Enter ID number");
        valid &= validateTextField(txtEmail, "Enter email account");
        valid &= validateTextField(txtFN, "Enter father name");

        valid &= validateTextField(txtPC, "Enter postal code");
        valid &= validateTextField(txtHA, "Enter home address");
        valid &= validateTextField(txtCity, "Enter city name");

        valid &= validateTextField(txtEducLvl, "Enter education");
        valid &= validateTextField(txtCurrJob, "Enter current job title");
        valid &= validateTextField(txtYrExp, "Enter year experience");

        valid &= validateTextField(txtUsername, "Enter username for login");

        valid &= validateComboBox(cbGender);
        valid &= validateComboBox(cbMarital);

        return valid;
    }
}