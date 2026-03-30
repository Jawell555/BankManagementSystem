package bank_AccountOperations;

import javax.swing.*;
import java.awt.*;

public class SidebarPanel extends JPanel {

    private JButton btnHome, btnManageEmp, btnManageAcc, btnAccOps, btnAccQueries, btnBankBalance, btnAccProfile, btnChangePass;
    private JButton btnSubTrans, btnSubDeposit, btnSubWithdraw; //add nyo dito mga sub categ if meron
    
    private boolean isAccOpsExpanded = false; //create din kayo ng variable tas i-false muna

    public SidebarPanel(BembankMain mainSystem) {
        setLayout(null);
        setBackground(Color.decode("#0e1a2b")); 
        setBounds(0, 0, 250, 1080);

        JPanel profilePanel = new JPanel();
        profilePanel.setLayout(null);
        profilePanel.setBackground(Color.decode("#182b45")); 
        profilePanel.setBounds(0, 0, 250, 150);

        //picture ng emp

        JLabel lblName = new JLabel("hatdog", SwingConstants.CENTER);
        lblName.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblName.setForeground(Color.WHITE);
        lblName.setBounds(0, 95, 250, 20); 
        profilePanel.add(lblName);

        JLabel lblEmail = new JLabel("hatdoog8080@bembank.com", SwingConstants.CENTER);
        lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        lblEmail.setForeground(Color.LIGHT_GRAY);
        lblEmail.setBounds(0, 115, 250, 20); 
        profilePanel.add(lblEmail);

        add(profilePanel);

        JLabel lblNavTitle = new JLabel("MAIN NAVIGATION");
        lblNavTitle.setFont(new Font("Segoe UI", Font.BOLD, 10));
        lblNavTitle.setForeground(Color.GRAY);
        lblNavTitle.setBounds(20, 160, 200, 20); 
        add(lblNavTitle);
        
        btnHome = createMainButton("Home");
        btnHome.addActionListener(e -> mainSystem.turnPage(new Dashboard()));
        
        //gayahin nyo lang yung home
        btnManageEmp = createMainButton("Manage Employees");
        btnManageAcc = createMainButton("Manage Accounts");
        
        btnAccOps = createMainButton("Account Operations         +");
        btnAccOps.addActionListener(e -> {
            isAccOpsExpanded = !isAccOpsExpanded; // true na yung kanina
            
            if (isAccOpsExpanded) {
                btnAccOps.setText("Account Operations          -");
            } else {
                btnAccOps.setText("Account Operations          +");
                btnAccOps.setForeground(Color.WHITE);
            }
            
            updateMenuPositions(); //taga-adjust para umurong
        });
        
        //mga subbuttom ko sa account operations
        btnSubTrans = createSubButton("Transaction");
        btnSubTrans.addActionListener(e -> mainSystem.turnPage(new TransactionBoard()));        
        btnSubDeposit = createSubButton("Deposit Balance");
        btnSubWithdraw = createSubButton("Withdraw Balance");

        btnAccQueries = createMainButton("Account Queries");
        btnBankBalance = createMainButton("Bank Balance");
        btnAccProfile = createMainButton("Account Profile");
        btnChangePass = createMainButton("Change Password");

        // add nyo dito para malagay sa panel
        add(btnHome); 
        add(btnManageEmp); 
        add(btnManageAcc); 
        add(btnAccOps);
        add(btnSubTrans); 
        add(btnSubDeposit); 
        add(btnSubWithdraw);
        add(btnAccQueries); 
        add(btnBankBalance); 
        add(btnAccProfile); 
        add(btnChangePass);

        updateMenuPositions();
    }

    private void updateMenuPositions() {
        
        //formula: laging +40 sa y)
        btnHome.setBounds(0, 190, 250, 35); 
        btnManageEmp.setBounds(0, 230, 250, 35); 
        btnManageAcc.setBounds(0, 270, 250, 35); 
        btnAccOps.setBounds(0, 310, 250, 35); 

        if (isAccOpsExpanded) {
            // formula: +35 pababa, sa y lang lagi magbabgo
            btnSubTrans.setVisible(true);
            btnSubTrans.setBounds(0, 350, 250, 30); 

            btnSubDeposit.setVisible(true);
            btnSubDeposit.setBounds(0, 385, 250, 30); 

            btnSubWithdraw.setVisible(true);
            btnSubWithdraw.setBounds(0, 420, 250, 30); 

            //nag-start sa 460 para may space yung subs, tapos +40)
            btnAccQueries.setBounds(0, 460, 250, 35); 
            btnBankBalance.setBounds(0, 500, 250, 35); 
            btnAccProfile.setBounds(0, 540, 250, 35); 
            btnChangePass.setBounds(0, 580, 250, 35); 
        } 
        else {
            btnSubTrans.setVisible(false);
            btnSubDeposit.setVisible(false);
            btnSubWithdraw.setVisible(false);
            
            //Formula para bumalik pataas: nakadikit agad sa acc ops kaya nag-start sa 350, tapos +40
            btnAccQueries.setBounds(0, 350, 250, 35); 
            btnBankBalance.setBounds(0, 390, 250, 35); 
            btnAccProfile.setBounds(0, 430, 250, 35); 
            btnChangePass.setBounds(0, 470, 250, 35); 
        }

        repaint();
    }

    private JButton createMainButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btn.setBackground(Color.decode("#0e1a2b")); 
        btn.setForeground(Color.WHITE);
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setMargin(new Insets(0, 20, 0, 0)); 
        btn.setFocusPainted(false);
        btn.setBorderPainted(false); 
        btn.setContentAreaFilled(false);  
        btn.setOpaque(true);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        return btn;
    }

    private JButton createSubButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btn.setBackground(Color.decode("#0e1a2b")); 
        btn.setForeground(Color.LIGHT_GRAY);
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setMargin(new Insets(0, 50, 0, 0)); 
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);  
        btn.setOpaque(true);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return btn;
    }
}