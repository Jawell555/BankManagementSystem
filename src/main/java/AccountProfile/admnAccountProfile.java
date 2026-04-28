package AccountProfile;

import Colors.ColorPalette;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class admnAccountProfile extends JPanel {

    private JLabel lblTitle, profileLabel, imageLabel, personalInfoLabel,
            nameLabel, fatherLabel, dobLabel, idLabel, mobileLabel,
            emailLabel, genderLabel, addressLabel, postalLabel, homeLabel, cityLabel;

    private JTextField txtTotalBal, nameField, fatherField, dobField, idField,
            mobileField, emailField, genderField, postalField, homeField, cityField;

    private JSeparator topSep, midSep, bottomSep;
    private ImageIcon icon;

    public admnAccountProfile() {
        setLayout(null);
        setBackground(new Color(245, 247, 250));
        setBounds(0, 0, 1670, 1080);

        Font titleFont = new Font("Segoe UI", Font.BOLD, 34);
        Font sectionFont = new Font("Segoe UI", Font.BOLD, 22);
        Font labelFont = new Font("Segoe UI", Font.BOLD, 17);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 17);
        Font idFont = new Font("Segoe UI", Font.BOLD, 24);

        Color darkBlue = new Color(3, 27, 66);
        Color borderColor = new Color(190, 198, 210);

        lblTitle = new JLabel("Account Profile");
        lblTitle.setBounds(50, 35, 700, 55);
        lblTitle.setFont(titleFont);
        lblTitle.setForeground(darkBlue);
        add(lblTitle);

        txtTotalBal = new JTextField("ADM1001");
        txtTotalBal.setHorizontalAlignment(JTextField.RIGHT);
        txtTotalBal.setEditable(false);
        txtTotalBal.setBackground(ColorPalette.Gray);
        txtTotalBal.setBounds(1120, 40, 500, 45);
        txtTotalBal.setFont(idFont);
        txtTotalBal.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderColor, 1, true),
                BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        add(txtTotalBal);

        topSep = new JSeparator();
        topSep.setBounds(50, 105, 1585, 2);
        topSep.setBackground(ColorPalette.Blue5);
        add(topSep);

        profileLabel = new JLabel("Profile Image");
        profileLabel.setFont(sectionFont);
        profileLabel.setForeground(darkBlue);
        profileLabel.setBounds(50, 130, 250, 35);
        add(profileLabel);

        imageLabel = new JLabel();
        imageLabel.setBounds(755, 165, 160, 160);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setBorder(new LineBorder(borderColor, 2, true));
        imageLabel.setOpaque(true);
        imageLabel.setBackground(Color.WHITE);

        icon = new ImageIcon(getClass().getResource("/profile.png"));
        Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(img));
        add(imageLabel);

        midSep = new JSeparator();
        midSep.setBounds(50, 355, 1585, 2);
        midSep.setBackground(ColorPalette.Blue5);
        add(midSep);

        personalInfoLabel = new JLabel("Personal Information");
        personalInfoLabel.setFont(sectionFont);
        personalInfoLabel.setForeground(darkBlue);
        personalInfoLabel.setBounds(50, 385, 300, 35);
        add(personalInfoLabel);

        nameLabel = new JLabel("Name");
        nameLabel.setFont(labelFont);
        nameLabel.setForeground(darkBlue);
        nameLabel.setBounds(50, 440, 250, 28);
        add(nameLabel);

        nameField = new JTextField("Admin SummitPhilBank");
        nameField.setBounds(50, 472, 450, 45);
        nameField.setEditable(false);
        nameField.setBackground(Color.WHITE);
        nameField.setFont(fieldFont);
        nameField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderColor, 1, true),
                BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        add(nameField);

        fatherLabel = new JLabel("Father Name");
        fatherLabel.setFont(labelFont);
        fatherLabel.setForeground(darkBlue);
        fatherLabel.setBounds(530, 440, 250, 28);
        add(fatherLabel);

        fatherField = new JTextField("Admin SummitPhilBank");
        fatherField.setBounds(530, 472, 450, 45);
        fatherField.setEditable(false);
        fatherField.setBackground(Color.WHITE);
        fatherField.setFont(fieldFont);
        fatherField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderColor, 1, true),
                BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        add(fatherField);

        dobLabel = new JLabel("Date Of Birth");
        dobLabel.setFont(labelFont);
        dobLabel.setForeground(darkBlue);
        dobLabel.setBounds(1010, 440, 250, 28);
        add(dobLabel);

        dobField = new JTextField("0000-00-00");
        dobField.setBounds(1010, 472, 450, 45);
        dobField.setEditable(false);
        dobField.setBackground(Color.WHITE);
        dobField.setFont(fieldFont);
        dobField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderColor, 1, true),
                BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        add(dobField);

        idLabel = new JLabel("ID Number");
        idLabel.setFont(labelFont);
        idLabel.setForeground(darkBlue);
        idLabel.setBounds(50, 545, 250, 28);
        add(idLabel);

        idField = new JTextField("0000000000000");
        idField.setBounds(50, 577, 450, 45);
        idField.setEditable(false);
        idField.setBackground(Color.WHITE);
        idField.setFont(fieldFont);
        idField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderColor, 1, true),
                BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        add(idField);

        mobileLabel = new JLabel("Mobile Number");
        mobileLabel.setFont(labelFont);
        mobileLabel.setForeground(darkBlue);
        mobileLabel.setBounds(530, 545, 250, 28);
        add(mobileLabel);

        mobileField = new JTextField("00000000000");
        mobileField.setBounds(530, 577, 450, 45);
        mobileField.setEditable(false);
        mobileField.setBackground(Color.WHITE);
        mobileField.setFont(fieldFont);
        mobileField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderColor, 1, true),
                BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        add(mobileField);

        emailLabel = new JLabel("Email Account");
        emailLabel.setFont(labelFont);
        emailLabel.setForeground(darkBlue);
        emailLabel.setBounds(1010, 545, 250, 28);
        add(emailLabel);

        emailField = new JTextField("admin@summitphilbank.com");
        emailField.setBounds(1010, 577, 450, 45);
        emailField.setEditable(false);
        emailField.setBackground(Color.WHITE);
        emailField.setFont(fieldFont);
        emailField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderColor, 1, true),
                BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        add(emailField);

        genderLabel = new JLabel("Gender");
        genderLabel.setFont(labelFont);
        genderLabel.setForeground(darkBlue);
        genderLabel.setBounds(50, 650, 250, 28);
        add(genderLabel);

        genderField = new JTextField("Male");
        genderField.setBounds(50, 682, 450, 45);
        genderField.setEditable(false);
        genderField.setBackground(Color.WHITE);
        genderField.setFont(fieldFont);
        genderField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderColor, 1, true),
                BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        add(genderField);

        bottomSep = new JSeparator();
        bottomSep.setBounds(50, 765, 1585, 2);
        bottomSep.setBackground(ColorPalette.Blue5);
        add(bottomSep);

        addressLabel = new JLabel("Address");
        addressLabel.setFont(sectionFont);
        addressLabel.setForeground(darkBlue);
        addressLabel.setBounds(50, 795, 250, 35);
        add(addressLabel);

        postalLabel = new JLabel("Postal Code");
        postalLabel.setFont(labelFont);
        postalLabel.setForeground(darkBlue);
        postalLabel.setBounds(50, 850, 250, 28);
        add(postalLabel);

        postalField = new JTextField("4024");
        postalField.setBounds(50, 882, 450, 45);
        postalField.setEditable(false);
        postalField.setBackground(Color.WHITE);
        postalField.setFont(fieldFont);
        postalField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderColor, 1, true),
                BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        add(postalField);

        homeLabel = new JLabel("Home Address");
        homeLabel.setFont(labelFont);
        homeLabel.setForeground(darkBlue);
        homeLabel.setBounds(530, 850, 250, 28);
        add(homeLabel);

        homeField = new JTextField("Street, Subdivision, Barangay");
        homeField.setBounds(530, 882, 450, 45);
        homeField.setEditable(false);
        homeField.setBackground(Color.WHITE);
        homeField.setFont(fieldFont);
        homeField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderColor, 1, true),
                BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        add(homeField);

        cityLabel = new JLabel("City");
        cityLabel.setFont(labelFont);
        cityLabel.setForeground(darkBlue);
        cityLabel.setBounds(1010, 850, 250, 28);
        add(cityLabel);

        cityField = new JTextField("City");
        cityField.setBounds(1010, 882, 450, 45);
        cityField.setEditable(false);
        cityField.setBackground(Color.WHITE);
        cityField.setFont(fieldFont);
        cityField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderColor, 1, true),
                BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        add(cityField);
    }
}