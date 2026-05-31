package LoginForm;

import BankManagementMain.adminSidebarPanelFrame;
import BankManagementMain.empSidebarPanelFrame;
import Colors.ImagePanel;
import Colors.ColorPalette;
import Database.EmployeeDatabase;
import Database.EmployeeSQL;
import Models.Employee;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginFormFrame extends JFrame implements ActionListener {
    
    JPanel pnlBG, pnlLogo, pnlSq, pnlLoginArea, pnlTitle;
    JLabel lblTitle, lblUser, lblPassword;
    JPasswordField passPass;
    JTextField txtUser;
    JButton btnLogin, btnExit;
    private String pass, user;
    
    Font fntTitle = new Font("Segoe UI", Font.BOLD, 50);
    Font fntX = new Font("Segoe UI", Font.BOLD, 30);
    Font fntText = new Font("Segoe UI", Font.BOLD, 15);
    Font fntTxtField = new Font("Segoe UI", Font.PLAIN, 15);
    
    
    private final Border errorBorder = BorderFactory.createCompoundBorder(new LineBorder(ColorPalette.redPastel, 2), BorderFactory.createEmptyBorder(2, 4, 2, 4));
    
    public LoginFormFrame() {
        setTitle("Bank Login");
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        
        Action toggleFullscreen = new AbstractAction() {
        boolean fullscreen = true; 

        @Override
        public void actionPerformed(ActionEvent e) {
            fullscreen = !fullscreen;

            GraphicsDevice device = GraphicsEnvironment
                    .getLocalGraphicsEnvironment()
                    .getDefaultScreenDevice();

            dispose();
            setUndecorated(fullscreen);

                if (fullscreen) {
                    device.setFullScreenWindow(LoginFormFrame.this);
                } else {
                    device.setFullScreenWindow(null);
                    setExtendedState(JFrame.MAXIMIZED_BOTH);
                    setLocationRelativeTo(null);
                }

                setVisible(true);
                getRootPane().setDefaultButton(btnLogin);
            }
        };

        // Bind F11 key
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke("F11"), "toggleFullscreen");

        getRootPane().getActionMap()
                .put("toggleFullscreen", toggleFullscreen);
        
        //Set Icon Image
        ImageIcon icon = new ImageIcon(getClass().getResource("/bank_logo.png"));
        setIconImage(icon.getImage());
        
        pnlBG = new ImagePanel("/bg.jpg");
        pnlBG.setLayout(null);
        pnlBG.setBounds(0, 0, 1920, 1080);
        add(pnlBG);
        
        //Exit Button
        btnExit = createButton("X",Color.RED,Color.PINK);
        btnExit.setBounds(1850, 10, 60, 60);
        btnExit.setFont(fntX);
        btnExit.setBackground(Color.RED);
        btnExit.setForeground(Color.WHITE);
        pnlBG.add(btnExit);

        //Bottom Rectangle
        pnlLoginArea = new JPanel(null);
        pnlLoginArea.setBounds(710, 370, 500, 300);
        pnlLoginArea.setOpaque(false);
        pnlBG.add(pnlLoginArea);

        //Login button
        btnLogin = createButton("Login",ColorPalette.Blue4,ColorPalette.Blue3);
        btnLogin.setBounds(175, 175, 150, 60);
        btnLogin.setFont(fntText);
        btnLogin.setBackground(ColorPalette.Blue4);
        btnLogin.setForeground(ColorPalette.Blue1);
        pnlLoginArea.add(btnLogin);
        
        lblUser = new JLabel("Username:");
        lblUser.setBounds(60, 50, 90, 30);
        lblUser.setFont(fntText);
        lblUser.setForeground(ColorPalette.Blue1);
        pnlLoginArea.add(lblUser);
        
        txtUser = new JTextField();
        txtUser.setBounds(150, 50, 280, 30);
        txtUser.setFont(fntTxtField);
        pnlLoginArea.add(txtUser);
        
        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(60, 110, 90, 30);
        lblPassword.setFont(fntText);
        lblPassword.setForeground(ColorPalette.Blue1);
        pnlLoginArea.add(lblPassword);
        
        passPass = new JPasswordField();
        passPass.setBounds(150, 110, 280, 30);
        passPass.setFont(fntTxtField);
        pnlLoginArea.add(passPass);

        //Top Title & Rectangle
        pnlTitle = new JPanel(null);
        pnlTitle.setBounds(710, 300, 500, 80);
        pnlTitle.setOpaque(false);
        pnlBG.add(pnlTitle);
        
        lblTitle = new JLabel("Summit PhilBank", SwingConstants.CENTER);
        lblTitle.setBounds(60, 0, 440, 80);
        lblTitle.setFont(fntTitle);
        lblTitle.setForeground(ColorPalette.Blue1);
        pnlTitle.add(lblTitle);
        
        pnlLogo = new ImagePanel("/bank_logo.jpg");
        pnlLogo.setLayout(null);
        pnlLogo.setBounds(0, 10, 60, 60);
        pnlTitle.add(pnlLogo);
        
        
        getRootPane().setDefaultButton(btnLogin);
        btnExit.addActionListener(this);
        btnLogin.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        user = txtUser.getText();
        pass = String.valueOf(passPass.getPassword());

        if (e.getSource() == btnLogin) {

            try {

                Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/BankManagementSystem",
                    "root",
                    ""
                );

                String sql = "SELECT emp_id, emp_type FROM employees WHERE username=? AND password=?";

                PreparedStatement pst = conn.prepareStatement(sql);

                pst.setString(1, user);
                pst.setString(2, pass);

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    String empID = rs.getString("emp_id");
                
                    EmployeeSQL.currentEmployee = EmployeeSQL.getEmployeeByID(empID);
                    
                    String role = rs.getString("emp_type");

                    if (role.equalsIgnoreCase("admin")) {

                        adminSidebarPanelFrame sf = new adminSidebarPanelFrame();

                        sf.setVisible(true);
                        dispose();

                    } else if (role.equalsIgnoreCase("employee")) {

                        empSidebarPanelFrame sf = new empSidebarPanelFrame();

                        sf.setVisible(true);
                        dispose();
                    }

                } else {

                    passPass.setText("");

                    txtUser.setBorder(errorBorder);
                    passPass.setBorder(errorBorder);

                    JOptionPane.showMessageDialog(
                            null,
                            "Incorrect Credentials. Try Again.",
                            "Login Failed",
                            JOptionPane.ERROR_MESSAGE
                    );
                }

                rs.close();
                pst.close();
                conn.close();

            } catch (SQLException ex) {

                ex.printStackTrace();

                JOptionPane.showMessageDialog(
                        null,
                        "Database Connection Failed!"
                );
            }

        } else if (e.getSource() == btnExit) {

            System.exit(0);
        }
    }
    
    private JButton createButton(String strN, Color c1, Color c2){
        JButton btn = new JButton(strN);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setFocusPainted(false);
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(c2);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn.setBackground(c1);
            }
        }
        );
        return btn;
    }
    
}
