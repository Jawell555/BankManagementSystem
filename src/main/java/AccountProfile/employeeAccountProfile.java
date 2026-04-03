package AccountProfile;

import Colors.ColorPalette;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class employeeAccountProfile extends JPanel {
    
    private JLabel lblTitle, profileLabel, imageLabel, personalInfoLabel, nameLabel, fatherLabel, dobLabel, idLabel, mobileLabel, emailLabel, genderLabel, addressLabel, 
            postalLabel, homeLabel, cityLabel, educationLabel, educationlvlLabel, currjobLabel, experienceLabel, accDetailsLabel, usernameLabel, typeLabel, registerLabel;
    private JTextField txtTotalBal, nameField, fatherField, dobField, idField, mobileField, emailField, genderField, postalField, homeField, cityField, educationlvlField, 
            currjobField, experienceField, usernameField, typeField, registerField;
    private JSeparator topSep, midSep1, midSep2, midSep3, bottomSep;
    private ImageIcon icon;
    
    public employeeAccountProfile(){
        setLayout(null);
        setBackground(new Color(235, 235, 235));
        setBounds(0, 0, 1670, 1080);
        
        lblTitle = new JLabel("Account Profile");
        lblTitle.setBounds(50, 40, 700, 50);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 25));
        add(lblTitle);
        
        txtTotalBal = new JTextField("EMP2001");
        txtTotalBal.setHorizontalAlignment(JTextField.RIGHT);
        txtTotalBal.setEditable(false);
        txtTotalBal.setBackground(ColorPalette.Gray);
        txtTotalBal.setBounds(1120, 40, 500, 40);
        txtTotalBal.setFont(new Font("Segoe UI", Font.BOLD, 25));
        add(txtTotalBal);
        
        // Top line
        topSep = new JSeparator();
        topSep.setBounds(50, 100, 1585, 2);
        topSep.setBackground(ColorPalette.Blue5);
        add(topSep);

        // Profile section
        profileLabel = new JLabel("Profile Image");
        profileLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        profileLabel.setBounds(50, 125, 100, 20);
        add(profileLabel);

        imageLabel = new JLabel();
        imageLabel.setBounds(800, 150, 120, 120);
        imageLabel.setBorder(new LineBorder(Color.GRAY, 1, true));

        icon = new ImageIcon(getClass().getResource("/profile.png"));
        Image img = icon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(img));
        add(imageLabel);

        // Middle line
        midSep1 = new JSeparator();
        midSep1.setBounds(50, 315, 1585, 2);
        midSep1.setBackground(ColorPalette.Blue5);
        add(midSep1);

        // Personal Information
        personalInfoLabel = new JLabel("Personal Information");
        personalInfoLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        personalInfoLabel.setBounds(50, 345, 150, 20);
        add(personalInfoLabel);

        // Row 1
        nameLabel = new JLabel("Name");
        nameLabel.setBounds(50, 375, 100, 20);
        add(nameLabel);

        nameField = new JTextField("Employee SummitPhilBank");
        nameField.setBounds(50, 400, 450, 28);
        nameField.setEditable(false);
        nameField.setBackground(Color.WHITE);
        add(nameField);

        fatherLabel = new JLabel("Father Name");
        fatherLabel.setBounds(520, 375, 100, 20);
        add(fatherLabel);

        fatherField = new JTextField("Employee SummitPhilBank");
        fatherField.setBounds(520, 400, 450, 28);
        fatherField.setEditable(false);
        fatherField.setBackground(Color.WHITE);
        add(fatherField);

        dobLabel = new JLabel("Date Of Birth");
        dobLabel.setBounds(995, 375, 100, 20);
        add(dobLabel);

        dobField = new JTextField("0000-00-00");
        dobField.setBounds(995, 400, 450, 28);
        dobField.setEditable(false);
        dobField.setBackground(Color.WHITE);
        add(dobField);

        // Row 2
        idLabel = new JLabel("ID Number");
        idLabel.setBounds(50, 435, 100, 20);
        add(idLabel);

        idField = new JTextField("0000000000000");
        idField.setBounds(50, 455, 450, 28);
        idField.setEditable(false);
        idField.setBackground(Color.WHITE);
        add(idField);

        mobileLabel = new JLabel("Mobile Number");
        mobileLabel.setBounds(520, 435, 100, 20);
        add(mobileLabel);

        mobileField = new JTextField("00000000000");
        mobileField.setBounds(520, 455, 450, 28);
        mobileField.setEditable(false);
        mobileField.setBackground(Color.WHITE);
        add(mobileField);

        emailLabel = new JLabel("Email Account");
        emailLabel.setBounds(995, 435, 100, 20);
        add(emailLabel);

        emailField = new JTextField("employee@summitphilbank.com");
        emailField.setBounds(995, 455, 450, 28);
        emailField.setEditable(false);
        emailField.setBackground(Color.WHITE);
        add(emailField);

        // Row 3
        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(50, 490, 100, 20);
        add(genderLabel);

        genderField = new JTextField("Male");
        genderField.setBounds(50, 515, 450, 28);
        genderField.setEditable(false);
        genderField.setBackground(Color.WHITE);
        add(genderField);

        // Middle line
        midSep2 = new JSeparator();
        midSep2.setBounds(50, 575, 1585, 2);
        midSep2.setBackground(ColorPalette.Blue5);
        add(midSep2);

        // Address Section
        addressLabel = new JLabel("Address");
        addressLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        addressLabel.setBounds(50, 600, 100, 20);
        add(addressLabel);

        postalLabel = new JLabel("Postal Code");
        postalLabel.setBounds(50, 635, 100, 20);
        add(postalLabel);

        postalField = new JTextField("4024");
        postalField.setBounds(50, 655, 450, 28);
        postalField.setEditable(false);
        postalField.setBackground(Color.WHITE);
        add(postalField);

        homeLabel = new JLabel("Home Address");
        homeLabel.setBounds(520, 635, 100, 20);
        add(homeLabel);

        homeField = new JTextField("Street, Subdivision, Barangay");
        homeField.setBounds(520, 655, 450, 28);
        homeField.setEditable(false);
        homeField.setBackground(Color.WHITE);
        add(homeField);

        cityLabel = new JLabel("City");
        cityLabel.setBounds(995, 635, 100, 20);
        add(cityLabel);

        cityField = new JTextField("City");
        cityField.setBounds(995, 655, 450, 28);
        cityField.setEditable(false);
        cityField.setBackground(Color.WHITE);
        add(cityField);
        
         // Middle line
        midSep3 = new JSeparator();
        midSep3.setBounds(50, 715, 1585, 2);
        midSep3.setBackground(ColorPalette.Blue5);
        add(midSep3);
        
        // Education & Experience
        educationLabel = new JLabel("Education & Experience");
        educationLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        educationLabel.setBounds(50, 730, 250, 20);
        add(educationLabel);

        educationlvlLabel = new JLabel("Education Level");
        educationlvlLabel.setBounds(50, 765, 200, 20);
        add(educationlvlLabel);

        educationlvlField = new JTextField("Bachelor's Degree in ___");
        educationlvlField.setBounds(50, 785, 450, 28);
        educationlvlField.setEditable(false);
        educationlvlField.setBackground(Color.WHITE);
        add(educationlvlField);

        currjobLabel = new JLabel("Current Job");
        currjobLabel.setBounds(520, 765, 100, 20);
        add(currjobLabel);

        currjobField = new JTextField("___");
        currjobField.setBounds(520, 785, 450, 28);
        currjobField.setEditable(false);
        currjobField.setBackground(Color.WHITE);
        add(currjobField);

        experienceLabel = new JLabel("Experience");
        experienceLabel.setBounds(995, 765, 100, 20);
        add(experienceLabel);

        experienceField = new JTextField("Junior");
        experienceField.setBounds(995, 785, 450, 28);
        experienceField.setEditable(false);
        experienceField.setBackground(Color.WHITE);
        add(experienceField);
        
        bottomSep = new JSeparator();
        bottomSep.setBounds(50, 845, 1585, 2);
        bottomSep.setBackground(ColorPalette.Blue5);
        add(bottomSep);
        
        // Account Details
        accDetailsLabel = new JLabel("Account Details");
        accDetailsLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        accDetailsLabel.setBounds(50, 860, 250, 20);
        add(accDetailsLabel);

        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(50, 895, 100, 20);
        add(usernameLabel);

        usernameField = new JTextField("username@summitphilbank.com");
        usernameField.setBounds(50, 915, 450, 28);
        usernameField.setEditable(false);
        usernameField.setBackground(Color.WHITE);
        add(usernameField);

        typeLabel = new JLabel("User Type");
        typeLabel.setBounds(520, 895, 100, 20);
        add(typeLabel);

        typeField = new JTextField("Employee");
        typeField.setBounds(520, 915, 450, 28);
        typeField.setEditable(false);
        typeField.setBackground(Color.WHITE);
        add(typeField);

        registerLabel = new JLabel("Registered Date");
        registerLabel.setBounds(995, 895, 100, 20);
        add(registerLabel);

        registerField = new JTextField("0000-00-00");
        registerField.setBounds(995, 915, 450, 28);
        registerField.setEditable(false);
        registerField.setBackground(Color.WHITE);
        add(registerField);
    }
    
}
