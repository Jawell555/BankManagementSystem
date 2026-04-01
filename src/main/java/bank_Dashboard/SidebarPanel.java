package bank_DashBoard;

import javax.swing.*;
import java.awt.*;

public class SidebarPanel extends JPanel {

    private JButton btnHome, btnManageEmp, btnManageAcc, btnAccOps, btnAccQueries, btnBankBalance, btnAccProfile, btnChangePass;
    private JButton btnSubAddEmp, btnSubViewEmp, btnSubNewAcc, btnSubViewAccList, btnSubTransHisto, btnSubCheckBalance, btnSubDepositHisto, btnSubWithdrawHisto, btnSubTrans, btnSubDeposit, btnSubWithdraw; 
    
    private boolean isManageEmpExpanded = false;
    private boolean isManageAccExpanded = false;
    private boolean isAccOpsExpanded = false; 
    private boolean isAccQueriesExpanded = false;
    
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
        
        //Manage Employees
        btnManageEmp = createMainButton("Manage Employees          +");
        btnManageEmp.addActionListener(e -> {
            isManageEmpExpanded = !isManageEmpExpanded;
            
            if(isManageEmpExpanded){
                btnManageEmp.setText("Manage Employees          -");
            } else {
                btnManageEmp.setText("Manage Employees          +");
                btnManageEmp.setForeground(Color.WHITE);
            }
            updateMenuPositions();
        });
        
        btnSubAddEmp = createSubButton("Add Employee");
        btnSubAddEmp.addActionListener(e -> mainSystem.turnPage(new Dashboard())); //Paltan niyo nalang yung 'new Dashboard()' 
        btnSubViewEmp = createSubButton("View Employees");
        btnSubViewEmp.addActionListener(e -> mainSystem.turnPage(new Dashboard())); //Paltan niyo nalang yung 'new Dashboard()' 
        
        
        //Manage Accounts
        btnManageAcc = createMainButton("Manage Accounts            +");
        btnManageAcc.addActionListener(e -> {
            isManageAccExpanded = !isManageAccExpanded;
            
            if(isManageAccExpanded){
                btnManageAcc.setText("Manage Accounts            -");
            } else {
                btnManageAcc.setText("Manage Accounts            +");
                btnManageAcc.setForeground(Color.WHITE);
            }
            updateMenuPositions();
        });
        
        btnSubNewAcc = createSubButton("New Account");
        btnSubNewAcc.addActionListener(e -> mainSystem.turnPage(new Dashboard())); //Paltan niyo nalang yung 'new Dashboard()' 
        btnSubViewAccList = createSubButton("View Account List");
        btnSubViewAccList.addActionListener(e -> mainSystem.turnPage(new Dashboard())); //Paltan niyo nalang yung 'new Dashboard()' 
        
        //Account Operations
        btnAccOps = createMainButton("Account Operations         +");
        btnAccOps.addActionListener(e -> {
            isAccOpsExpanded = !isAccOpsExpanded; 
            
            if (isAccOpsExpanded) {
                btnAccOps.setText("Account Operations         -");
            } else {
                btnAccOps.setText("Account Operations         +");
                btnAccOps.setForeground(Color.WHITE);
            }
            
            updateMenuPositions();
        });
       
        btnSubTrans = createSubButton("Transaction");
        btnSubTrans.addActionListener(e -> mainSystem.turnPage(new Dashboard()));  //Paltan niyo nalang yung 'new Dashboard()' 
        btnSubDeposit = createSubButton("Deposit Balance");
        btnSubDeposit.addActionListener(e -> mainSystem.turnPage(new Dashboard())); //Paltan niyo nalang yung 'new Dashboard()' 
        btnSubWithdraw = createSubButton("Withdraw Balance");
        btnSubWithdraw.addActionListener(e -> mainSystem.turnPage(new Dashboard())); //Paltan niyo nalang yung 'new Dashboard()' 
        
        //Account Queries
        btnAccQueries = createMainButton("Account Queries              +");
        btnAccQueries.addActionListener(e -> {
            isAccQueriesExpanded = !isAccQueriesExpanded;
            
            if(isAccQueriesExpanded){
                btnAccQueries.setText("Account Queries              -");
            } else {
                btnAccQueries.setText("Account Queries              +");
                btnAccQueries.setForeground(Color.WHITE);
            }
            updateMenuPositions();
        });
        
        btnSubTransHisto = createSubButton("Transaction History");
        btnSubTransHisto.addActionListener(e -> mainSystem.turnPage(new Dashboard())); //Paltan niyo nalang yung 'new Dashboard()' 
        btnSubCheckBalance = createSubButton("Check Current Balance");
        btnSubCheckBalance.addActionListener(e -> mainSystem.turnPage(new Dashboard())); //Paltan niyo nalang yung 'new Dashboard()' 
        btnSubDepositHisto = createSubButton("Deposit History");
        btnSubDepositHisto.addActionListener(e -> mainSystem.turnPage(new Dashboard())); //Paltan niyo nalang yung 'new Dashboard()' 
        btnSubWithdrawHisto = createSubButton("Withdraw History");
        btnSubWithdrawHisto.addActionListener(e -> mainSystem.turnPage(new Dashboard())); //Paltan niyo nalang yung 'new Dashboard()' 
        
        //Bank Balance
        btnBankBalance = createMainButton("Bank Balance");
        btnBankBalance.addActionListener(e -> mainSystem.turnPage(new Dashboard())); //Paltan niyo nalang yung 'new Dashboard()'
        btnAccProfile = createMainButton("Account Profile");
        btnAccProfile.addActionListener(e -> mainSystem.turnPage(new Dashboard())); //Paltan niyo nalang yung 'new Dashboard()'
        btnChangePass = createMainButton("Change Password");
        btnChangePass.addActionListener(e -> mainSystem.turnPage(new Dashboard())); //Paltan niyo nalang yung 'new Dashboard()'

        //Add Buttons
        add(btnHome); 
        
        add(btnManageEmp); 
        add(btnSubAddEmp);
        add(btnSubViewEmp);
        
        add(btnManageAcc); 
        add(btnSubNewAcc);
        add(btnSubViewAccList);
        
        add(btnAccOps);
        add(btnSubTrans); 
        add(btnSubDeposit); 
        add(btnSubWithdraw);
        
        add(btnAccQueries); 
        add(btnSubTransHisto);
        add(btnSubCheckBalance);
        add(btnSubDepositHisto);
        add(btnSubWithdrawHisto);
        
        add(btnBankBalance); 
        
        add(btnAccProfile); 
        
        add(btnChangePass);

        updateMenuPositions();
    }

    private void updateMenuPositions() {

        btnHome.setBounds(0, 190, 250, 35);
        btnManageEmp.setBounds(0, 230, 250, 35);

        int y = 270;

        if (isManageEmpExpanded) {
            btnSubAddEmp.setVisible(true);
            btnSubAddEmp.setBounds(0, y, 250, 30);
            y += 35;

            btnSubViewEmp.setVisible(true);
            btnSubViewEmp.setBounds(0, y, 250, 30);
            y += 35;
        } else {
            btnSubAddEmp.setVisible(false);
            btnSubViewEmp.setVisible(false);
        }
        
        btnManageAcc.setBounds(0, y, 250, 35);
        y += 40;
        
        if(isManageAccExpanded){
            btnSubNewAcc.setVisible(true);
            btnSubNewAcc.setBounds(0, y, 250, 30);
            y += 35;
            
            btnSubViewAccList.setVisible(true);
            btnSubViewAccList.setBounds(0, y, 250, 30);
            y += 35;
        } else{
            btnSubNewAcc.setVisible(false);
            btnSubViewAccList.setVisible(false);
        }

        btnAccOps.setBounds(0, y, 250, 35);
        y += 40;

        if (isAccOpsExpanded) {
            btnSubTrans.setVisible(true);
            btnSubTrans.setBounds(0, y, 250, 30);
            y += 35;

            btnSubDeposit.setVisible(true);
            btnSubDeposit.setBounds(0, y, 250, 30);
            y += 35;

            btnSubWithdraw.setVisible(true);
            btnSubWithdraw.setBounds(0, y, 250, 30);
            y += 35;
        } else {
            btnSubTrans.setVisible(false);
            btnSubDeposit.setVisible(false);
            btnSubWithdraw.setVisible(false);
        }

        btnAccQueries.setBounds(0, y, 250, 35);
        y += 40;
        
        if (isAccQueriesExpanded) {
            btnSubTransHisto.setVisible(true);
            btnSubTransHisto.setBounds(0, y, 250, 30);
            y += 35;

            btnSubCheckBalance.setVisible(true);
            btnSubCheckBalance.setBounds(0, y, 250, 30);
            y += 35;

            btnSubDepositHisto.setVisible(true);
            btnSubDepositHisto.setBounds(0, y, 250, 30);
            y += 35;
            
            btnSubWithdrawHisto.setVisible(true);
            btnSubWithdrawHisto.setBounds(0, y, 250, 30);
            y += 35;
        } else {
            btnSubTransHisto.setVisible(false);
            btnSubCheckBalance.setVisible(false);
            btnSubDepositHisto.setVisible(false);
            btnSubWithdrawHisto.setVisible(false);
        }
        
        btnBankBalance.setBounds(0, y, 250, 35);
        y += 40;
        btnAccProfile.setBounds(0, y, 250, 35);
        y += 40;
        btnChangePass.setBounds(0, y, 250, 35);

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