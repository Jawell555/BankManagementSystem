package AccountProfile;

import Colors.ColorPalette;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class employeeAccountProfile extends JPanel {

    private JLabel lblTitle, profileLabel, imageLabel, personalInfoLabel, nameLabel, fatherLabel, dobLabel, idLabel,
            mobileLabel, emailLabel, genderLabel, addressLabel, postalLabel, homeLabel, cityLabel, educationLabel,
            educationlvlLabel, currjobLabel, experienceLabel, accDetailsLabel, usernameLabel, typeLabel, registerLabel;

    private JTextField txtTotalBal, nameField, fatherField, dobField, idField, mobileField, emailField, genderField,
            postalField, homeField, cityField, educationlvlField, currjobField, experienceField, usernameField,
            typeField, registerField;

    private JSeparator topSep, midSep1, midSep2, midSep3, bottomSep;
    private ImageIcon icon;

    public employeeAccountProfile() {
        setLayout(null);
        setBackground(new Color(245, 247, 250));
        setBounds(0, 0, 1670, 1080);

        Font titleFont = new Font("Segoe UI", Font.BOLD, 32);
        Font sectionFont = new Font("Segoe UI", Font.BOLD, 20);
        Font labelFont = new Font("Segoe UI", Font.BOLD, 16);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 16);
        Font idFont = new Font("Segoe UI", Font.BOLD, 23);

        Color darkBlue = new Color(3, 27, 66);
        Color borderColor = new Color(190, 198, 210);

        lblTitle = new JLabel("Account Profile");
        lblTitle.setBounds(50, 25, 700, 48);
        lblTitle.setFont(titleFont);
        lblTitle.setForeground(darkBlue);
        add(lblTitle);

        txtTotalBal = new JTextField("EMP2001");
        txtTotalBal.setHorizontalAlignment(JTextField.RIGHT);
        txtTotalBal.setEditable(false);
        txtTotalBal.setBackground(ColorPalette.Gray);
        txtTotalBal.setBounds(1120, 30, 500, 40);
        txtTotalBal.setFont(idFont);
        txtTotalBal.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderColor, 1, true),
                BorderFactory.createEmptyBorder(4, 12, 4, 12)
        ));
        add(txtTotalBal);

        topSep = new JSeparator();
        topSep.setBounds(50, 85, 1585, 2);
        topSep.setBackground(ColorPalette.Blue5);
        add(topSep);

        profileLabel = new JLabel("Profile Image");
        profileLabel.setFont(sectionFont);
        profileLabel.setForeground(darkBlue);
        profileLabel.setBounds(50, 100, 250, 28);
        add(profileLabel);

        imageLabel = new JLabel();
        imageLabel.setBounds(765, 125, 135, 135);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setBorder(new LineBorder(borderColor, 2, true));
        imageLabel.setOpaque(true);
        imageLabel.setBackground(Color.WHITE);

        icon = new ImageIcon(getClass().getResource("/profile.png"));
        Image img = icon.getImage().getScaledInstance(125, 125, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(img));
        add(imageLabel);

        midSep1 = new JSeparator();
        midSep1.setBounds(50, 280, 1585, 2);
        midSep1.setBackground(ColorPalette.Blue5);
        add(midSep1);

        personalInfoLabel = new JLabel("Personal Information");
        personalInfoLabel.setFont(sectionFont);
        personalInfoLabel.setForeground(darkBlue);
        personalInfoLabel.setBounds(50, 295, 300, 28);
        add(personalInfoLabel);

        nameLabel = new JLabel("Name");
        nameLabel.setFont(labelFont);
        nameLabel.setForeground(darkBlue);
        nameLabel.setBounds(50, 330, 250, 24);
        add(nameLabel);

        nameField = new JTextField("Employee SummitPhilBank");
        nameField.setBounds(50, 354, 450, 38);
        nameField.setEditable(false);
        nameField.setBackground(Color.WHITE);
        nameField.setFont(fieldFont);
        nameField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderColor, 1, true),
                BorderFactory.createEmptyBorder(4, 12, 4, 12)
        ));
        add(nameField);

        fatherLabel = new JLabel("Father Name");
        fatherLabel.setFont(labelFont);
        fatherLabel.setForeground(darkBlue);
        fatherLabel.setBounds(530, 330, 250, 24);
        add(fatherLabel);

        fatherField = new JTextField("Employee SummitPhilBank");
        fatherField.setBounds(530, 354, 450, 38);
        fatherField.setEditable(false);
        fatherField.setBackground(Color.WHITE);
        fatherField.setFont(fieldFont);
        fatherField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderColor, 1, true),
                BorderFactory.createEmptyBorder(4, 12, 4, 12)
        ));
        add(fatherField);

        dobLabel = new JLabel("Date Of Birth");
        dobLabel.setFont(labelFont);
        dobLabel.setForeground(darkBlue);
        dobLabel.setBounds(1010, 330, 250, 24);
        add(dobLabel);

        dobField = new JTextField("0000-00-00");
        dobField.setBounds(1010, 354, 450, 38);
        dobField.setEditable(false);
        dobField.setBackground(Color.WHITE);
        dobField.setFont(fieldFont);
        dobField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderColor, 1, true),
                BorderFactory.createEmptyBorder(4, 12, 4, 12)
        ));
        add(dobField);

        idLabel = new JLabel("ID Number");
        idLabel.setFont(labelFont);
        idLabel.setForeground(darkBlue);
        idLabel.setBounds(50, 407, 250, 24);
        add(idLabel);

        idField = new JTextField("0000000000000");
        idField.setBounds(50, 431, 450, 38);
        idField.setEditable(false);
        idField.setBackground(Color.WHITE);
        idField.setFont(fieldFont);
        idField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderColor, 1, true),
                BorderFactory.createEmptyBorder(4, 12, 4, 12)
        ));
        add(idField);

        mobileLabel = new JLabel("Mobile Number");
        mobileLabel.setFont(labelFont);
        mobileLabel.setForeground(darkBlue);
        mobileLabel.setBounds(530, 407, 250, 24);
        add(mobileLabel);

        mobileField = new JTextField("00000000000");
        mobileField.setBounds(530, 431, 450, 38);
        mobileField.setEditable(false);
        mobileField.setBackground(Color.WHITE);
        mobileField.setFont(fieldFont);
        mobileField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderColor, 1, true),
                BorderFactory.createEmptyBorder(4, 12, 4, 12)
        ));
        add(mobileField);

        emailLabel = new JLabel("Email Account");
        emailLabel.setFont(labelFont);
        emailLabel.setForeground(darkBlue);
        emailLabel.setBounds(1010, 407, 250, 24);
        add(emailLabel);

        emailField = new JTextField("employee@summitphilbank.com");
        emailField.setBounds(1010, 431, 450, 38);
        emailField.setEditable(false);
        emailField.setBackground(Color.WHITE);
        emailField.setFont(fieldFont);
        emailField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderColor, 1, true),
                BorderFactory.createEmptyBorder(4, 12, 4, 12)
        ));
        add(emailField);

        genderLabel = new JLabel("Gender");
        genderLabel.setFont(labelFont);
        genderLabel.setForeground(darkBlue);
        genderLabel.setBounds(50, 484, 250, 24);
        add(genderLabel);

        genderField = new JTextField("Male");
        genderField.setBounds(50, 508, 450, 38);
        genderField.setEditable(false);
        genderField.setBackground(Color.WHITE);
        genderField.setFont(fieldFont);
        genderField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderColor, 1, true),
                BorderFactory.createEmptyBorder(4, 12, 4, 12)
        ));
        add(genderField);

        midSep2 = new JSeparator();
        midSep2.setBounds(50, 565, 1585, 2);
        midSep2.setBackground(ColorPalette.Blue5);
        add(midSep2);

        addressLabel = new JLabel("Address");
        addressLabel.setFont(sectionFont);
        addressLabel.setForeground(darkBlue);
        addressLabel.setBounds(50, 580, 250, 28);
        add(addressLabel);

        postalLabel = new JLabel("Postal Code");
        postalLabel.setFont(labelFont);
        postalLabel.setForeground(darkBlue);
        postalLabel.setBounds(50, 615, 250, 24);
        add(postalLabel);

        postalField = new JTextField("4024");
        postalField.setBounds(50, 639, 450, 38);
        postalField.setEditable(false);
        postalField.setBackground(Color.WHITE);
        postalField.setFont(fieldFont);
        postalField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderColor, 1, true),
                BorderFactory.createEmptyBorder(4, 12, 4, 12)
        ));
        add(postalField);

        homeLabel = new JLabel("Home Address");
        homeLabel.setFont(labelFont);
        homeLabel.setForeground(darkBlue);
        homeLabel.setBounds(530, 615, 250, 24);
        add(homeLabel);

        homeField = new JTextField("Street, Subdivision, Barangay");
        homeField.setBounds(530, 639, 450, 38);
        homeField.setEditable(false);
        homeField.setBackground(Color.WHITE);
        homeField.setFont(fieldFont);
        homeField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderColor, 1, true),
                BorderFactory.createEmptyBorder(4, 12, 4, 12)
        ));
        add(homeField);

        cityLabel = new JLabel("City");
        cityLabel.setFont(labelFont);
        cityLabel.setForeground(darkBlue);
        cityLabel.setBounds(1010, 615, 250, 24);
        add(cityLabel);

        cityField = new JTextField("City");
        cityField.setBounds(1010, 639, 450, 38);
        cityField.setEditable(false);
        cityField.setBackground(Color.WHITE);
        cityField.setFont(fieldFont);
        cityField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderColor, 1, true),
                BorderFactory.createEmptyBorder(4, 12, 4, 12)
        ));
        add(cityField);

        midSep3 = new JSeparator();
        midSep3.setBounds(50, 695, 1585, 2);
        midSep3.setBackground(ColorPalette.Blue5);
        add(midSep3);

        educationLabel = new JLabel("Education & Experience");
        educationLabel.setFont(sectionFont);
        educationLabel.setForeground(darkBlue);
        educationLabel.setBounds(50, 710, 350, 28);
        add(educationLabel);

        educationlvlLabel = new JLabel("Education Level");
        educationlvlLabel.setFont(labelFont);
        educationlvlLabel.setForeground(darkBlue);
        educationlvlLabel.setBounds(50, 745, 250, 24);
        add(educationlvlLabel);

        educationlvlField = new JTextField("Bachelor's Degree in ___");
        educationlvlField.setBounds(50, 769, 450, 38);
        educationlvlField.setEditable(false);
        educationlvlField.setBackground(Color.WHITE);
        educationlvlField.setFont(fieldFont);
        educationlvlField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderColor, 1, true),
                BorderFactory.createEmptyBorder(4, 12, 4, 12)
        ));
        add(educationlvlField);

        currjobLabel = new JLabel("Current Job");
        currjobLabel.setFont(labelFont);
        currjobLabel.setForeground(darkBlue);
        currjobLabel.setBounds(530, 745, 250, 24);
        add(currjobLabel);

        currjobField = new JTextField("___");
        currjobField.setBounds(530, 769, 450, 38);
        currjobField.setEditable(false);
        currjobField.setBackground(Color.WHITE);
        currjobField.setFont(fieldFont);
        currjobField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderColor, 1, true),
                BorderFactory.createEmptyBorder(4, 12, 4, 12)
        ));
        add(currjobField);

        experienceLabel = new JLabel("Experience");
        experienceLabel.setFont(labelFont);
        experienceLabel.setForeground(darkBlue);
        experienceLabel.setBounds(1010, 745, 250, 24);
        add(experienceLabel);

        experienceField = new JTextField("Junior");
        experienceField.setBounds(1010, 769, 450, 38);
        experienceField.setEditable(false);
        experienceField.setBackground(Color.WHITE);
        experienceField.setFont(fieldFont);
        experienceField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderColor, 1, true),
                BorderFactory.createEmptyBorder(4, 12, 4, 12)
        ));
        add(experienceField);

        bottomSep = new JSeparator();
        bottomSep.setBounds(50, 825, 1585, 2);
        bottomSep.setBackground(ColorPalette.Blue5);
        add(bottomSep);

        accDetailsLabel = new JLabel("Account Details");
        accDetailsLabel.setFont(sectionFont);
        accDetailsLabel.setForeground(darkBlue);
        accDetailsLabel.setBounds(50, 840, 250, 28);
        add(accDetailsLabel);

        usernameLabel = new JLabel("Username");
        usernameLabel.setFont(labelFont);
        usernameLabel.setForeground(darkBlue);
        usernameLabel.setBounds(50, 875, 250, 24);
        add(usernameLabel);

        usernameField = new JTextField("username@summitphilbank.com");
        usernameField.setBounds(50, 899, 450, 38);
        usernameField.setEditable(false);
        usernameField.setBackground(Color.WHITE);
        usernameField.setFont(fieldFont);
        usernameField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderColor, 1, true),
                BorderFactory.createEmptyBorder(4, 12, 4, 12)
        ));
        add(usernameField);

        typeLabel = new JLabel("User Type");
        typeLabel.setFont(labelFont);
        typeLabel.setForeground(darkBlue);
        typeLabel.setBounds(530, 875, 250, 24);
        add(typeLabel);

        typeField = new JTextField("Employee");
        typeField.setBounds(530, 899, 450, 38);
        typeField.setEditable(false);
        typeField.setBackground(Color.WHITE);
        typeField.setFont(fieldFont);
        typeField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderColor, 1, true),
                BorderFactory.createEmptyBorder(4, 12, 4, 12)
        ));
        add(typeField);

        registerLabel = new JLabel("Registered Date");
        registerLabel.setFont(labelFont);
        registerLabel.setForeground(darkBlue);
        registerLabel.setBounds(1010, 875, 250, 24);
        add(registerLabel);

        registerField = new JTextField("0000-00-00");
        registerField.setBounds(1010, 899, 450, 38);
        registerField.setEditable(false);
        registerField.setBackground(Color.WHITE);
        registerField.setFont(fieldFont);
        registerField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderColor, 1, true),
                BorderFactory.createEmptyBorder(4, 12, 4, 12)
        ));
        add(registerField);
    }
}