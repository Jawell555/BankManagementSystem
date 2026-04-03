package AccountProfile;

import Colors.ColorPalette;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class admnAccountProfile extends JPanel {
    
    private JLabel lblTitle, profileLabel, imageLabel, personalInfoLabel, nameLabel, fatherLabel, dobLabel, idLabel, mobileLabel, emailLabel, genderLabel, addressLabel, 
            postalLabel, homeLabel, cityLabel;
    private JTextField txtTotalBal, nameField, fatherField, dobField, idField, mobileField, emailField, genderField, postalField, homeField, cityField;
    private JSeparator topSep, midSep, bottomSep;
    private ImageIcon icon;
    
    public admnAccountProfile(){
        setLayout(null);
        setBackground(new Color(235, 235, 235));
        setBounds(0, 0, 1670, 1080);
        
        lblTitle = new JLabel("Account Profile");
        lblTitle.setBounds(50, 40, 700, 50);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 25));
        add(lblTitle);
        
        txtTotalBal = new JTextField("ADM1001");
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
        midSep = new JSeparator();
        midSep.setBounds(50, 315, 1585, 2);
        midSep.setBackground(ColorPalette.Blue5);
        add(midSep);

        // Personal Information
        personalInfoLabel = new JLabel("Personal Information");
        personalInfoLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        personalInfoLabel.setBounds(50, 345, 150, 20);
        add(personalInfoLabel);

        // Row 1
        nameLabel = new JLabel("Name");
        nameLabel.setBounds(50, 375, 100, 20);
        add(nameLabel);

        nameField = new JTextField("Admin SummitPhilBank");
        nameField.setBounds(50, 400, 450, 28);
        nameField.setEditable(false);
        nameField.setBackground(Color.WHITE);
        add(nameField);

        fatherLabel = new JLabel("Father Name");
        fatherLabel.setBounds(520, 375, 100, 20);
        add(fatherLabel);

        fatherField = new JTextField("Admin SummitPhilBank");
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

        emailField = new JTextField("admin@summitphilbank.com");
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

        // Bottom line
        bottomSep = new JSeparator();
        bottomSep.setBounds(50, 575, 1585, 2);
        bottomSep.setBackground(ColorPalette.Blue5);
        add(bottomSep);

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
    
    }
    
}
