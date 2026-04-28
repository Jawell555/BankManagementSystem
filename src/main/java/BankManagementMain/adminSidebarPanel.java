package BankManagementMain;

import AccountProfile.admnAccountProfile;
import Account_Queries.CheckBalance;
import Account_Queries.DepositHistory;
import Account_Queries.TransactionHistory;
import Account_Queries.WithdrawHistory;
import Colors.ColorPalette;
import BankBalance.BankBalance;
import ChangePassword.ChangePasswordPanel;
import bank_AccountOperations.DepositBoard;
import bank_AccountOperations.TransactionBoard;
import bank_AccountOperations.WithdrawBoard;
import bank_Dashboard.adminDashboard;
import bank_ManageEmployees.AddEmployeesBoard;
import bank_ManageEmployees.ViewEmployeesBoard;
import bank_ManageAccounts.NewAccountBoard;
import bank_ManageAccounts.ViewAccountBoard;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class adminSidebarPanel extends JPanel {

    private JPanel profilePanel;
    private JLabel lblName, lblEmail, lblNavTitle, lblProfile;
    private JButton btnHome, btnManageEmp, btnManageAcc, btnAccOps, btnAccQueries, btnBankBalance, btnAccProfile, btnChangePass;
    private JButton btnSubAddEmp, btnSubViewEmp, btnSubNewAcc, btnSubViewAccList, btnSubTransHisto, btnSubCheckBalance, btnSubDepositHisto, btnSubWithdrawHisto, btnSubTrans, btnSubDeposit, btnSubWithdraw; 
    private ImageIcon profile;
    
    private boolean isManageEmpExpanded = false;
    private boolean isManageAccExpanded = false;
    private boolean isAccOpsExpanded = false; 
    private boolean isAccQueriesExpanded = false;
    
    public adminSidebarPanel(adminSidebarPanelFrame navPage) {
        setLayout(null);
        setBackground(ColorPalette.Blue5); 
        setBounds(0, 0, 250, 1080);
        
        profilePanel = new ImagePanel("/sidepanel_bg2.jpg");
        profilePanel.setLayout(null);
        profilePanel.setBounds(0, 0, 250, 150);
        
        profile = new ImageIcon(getClass().getResource("/profile.png"));
        Image scaledProfile = profile.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        lblProfile = new JLabel(new ImageIcon(scaledProfile));
        lblProfile.setBounds(90, 20, 75, 75);
        profilePanel.add(lblProfile);

        lblName = new JLabel("Admin", SwingConstants.CENTER);
        lblName.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblName.setForeground(Color.WHITE);
        lblName.setBounds(0, 95, 250, 20); 
        profilePanel.add(lblName);

        lblEmail = new JLabel("admin@summitphilbank.com", SwingConstants.CENTER);
        lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        lblEmail.setForeground(ColorPalette.Blue1);
        lblEmail.setBounds(0, 115, 250, 20); 
        profilePanel.add(lblEmail);

        add(profilePanel);

        lblNavTitle = new JLabel("MAIN NAVIGATION");
        lblNavTitle.setFont(new Font("Segoe UI", Font.BOLD, 10));
        lblNavTitle.setForeground(Color.GRAY);
        lblNavTitle.setBounds(20, 160, 200, 20); 
        add(lblNavTitle);
        
        btnHome = createMainButton("Home");
        btnHome.setForeground(ColorPalette.redPastel);
        btnHome.addActionListener(e -> {
            closeOtherMenus("");
            resetMainButtonColors();
            btnHome.setForeground(ColorPalette.redPastel);
            navPage.turnPage(new adminDashboard());
            updateMenuPositions();
        });
        
        btnManageEmp = createMainButton("Manage Employees          +");
        btnManageEmp.addActionListener(e -> {
            boolean willOpen = !isManageEmpExpanded;
            
            resetMainButtonColors();
            closeOtherMenus("EMP");
            isManageEmpExpanded = willOpen;
            
            if(isManageEmpExpanded){
                btnManageEmp.setText("Manage Employees          >");
                btnManageEmp.setForeground(ColorPalette.redPastel);
            } else {
                btnManageEmp.setText("Manage Employees          +");
                btnManageEmp.setForeground(Color.WHITE);
            }
            updateMenuPositions();
        });
        
        btnSubAddEmp = createSubButton("Add Employee");
        btnSubAddEmp.addActionListener(e -> navPage.turnPage(new AddEmployeesBoard())); //Paltan niyo nalang yung 'new Dashboard()' 
        btnSubViewEmp = createSubButton("View Employees");
        btnSubViewEmp.addActionListener(e -> navPage.turnPage(new ViewEmployeesBoard())); //Paltan niyo nalang yung 'new Dashboard()' 
        
        btnManageAcc = createMainButton("Manage Accounts            +");
        btnManageAcc.addActionListener(e -> {
            boolean willOpen = !isManageAccExpanded;
            
            resetMainButtonColors();
            closeOtherMenus("ACC");
            isManageAccExpanded = willOpen;
            
            if(isManageAccExpanded){
                btnManageAcc.setText("Manage Accounts            >");
                btnManageAcc.setForeground(ColorPalette.redPastel);
            } else {
                btnManageAcc.setText("Manage Accounts            +");
                btnManageAcc.setForeground(Color.WHITE);
            }
            updateMenuPositions();
        });
        
        btnSubNewAcc = createSubButton("New Account");
        btnSubNewAcc.addActionListener(e -> navPage.turnPage(new NewAccountBoard())); //Paltan niyo nalang yung 'new Dashboard()' 
        btnSubViewAccList = createSubButton("View Account List");
        btnSubViewAccList.addActionListener(e -> navPage.turnPage(new ViewAccountBoard())); //Paltan niyo nalang yung 'new Dashboard()' 
        
        btnAccOps = createMainButton("Account Operations         +");
        btnAccOps.addActionListener(e -> {
            boolean willOpen = !isAccOpsExpanded;
            
            resetMainButtonColors();
            closeOtherMenus("OPS");
            isAccOpsExpanded = willOpen;
            
            if (isAccOpsExpanded) {
                btnAccOps.setText("Account Operations         >");
                btnAccOps.setForeground(ColorPalette.redPastel);
            } else {
                btnAccOps.setText("Account Operations         +");
                btnAccOps.setForeground(Color.WHITE);
            }
            updateMenuPositions();
        });
       
        btnSubTrans = createSubButton("Transaction");
        btnSubTrans.addActionListener(e -> navPage.turnPage(new TransactionBoard())); //Paltan niyo nalang yung 'new Dashboard()'
        btnSubDeposit = createSubButton("Deposit Balance");
        btnSubDeposit.addActionListener(e -> navPage.turnPage(new DepositBoard())); //Paltan niyo nalang yung 'new Dashboard()'
        btnSubWithdraw = createSubButton("Withdraw Balance");
        btnSubWithdraw.addActionListener(e -> navPage.turnPage(new WithdrawBoard())); //Paltan niyo nalang yung 'new Dashboard()'
        
        btnAccQueries = createMainButton("Account Queries              +");
        btnAccQueries.addActionListener(e -> {
            boolean willOpen = !isAccQueriesExpanded;
            
            resetMainButtonColors();
            closeOtherMenus("QUERY");
            isAccQueriesExpanded = willOpen;
            
            if(isAccQueriesExpanded){
                btnAccQueries.setText("Account Queries              >");
                btnAccQueries.setForeground(ColorPalette.redPastel);
            } else {
                btnAccQueries.setText("Account Queries              +");
                btnAccQueries.setForeground(Color.WHITE);
            }
            updateMenuPositions();
        });
        
        btnSubTransHisto = createSubButton("Transaction History");
        btnSubTransHisto.addActionListener(e -> navPage.turnPage(new TransactionHistory())); //Paltan niyo nalang yung 'new Dashboard()'
        btnSubCheckBalance = createSubButton("Check Current Balance");
        btnSubCheckBalance.addActionListener(e -> navPage.turnPage(new CheckBalance())); //Paltan niyo nalang yung 'new Dashboard()'
        btnSubDepositHisto = createSubButton("Deposit History");
        btnSubDepositHisto.addActionListener(e -> navPage.turnPage(new DepositHistory())); //Paltan niyo nalang yung 'new Dashboard()'
        btnSubWithdrawHisto = createSubButton("Withdraw History");
        btnSubWithdrawHisto.addActionListener(e -> navPage.turnPage(new WithdrawHistory())); //Paltan niyo nalang yung 'new Dashboard()'
        
        btnBankBalance = createMainButton("Bank Balance");
        btnBankBalance.addActionListener(e -> {
            closeOtherMenus("");
            resetMainButtonColors();
            btnBankBalance.setForeground(ColorPalette.redPastel);
            navPage.turnPage(new BankBalance()); //Paltan niyo nalang yung 'new Dashboard()'
            updateMenuPositions();
        });
        btnAccProfile = createMainButton("Account Profile");
        btnAccProfile.addActionListener(e -> {
            closeOtherMenus("");
            resetMainButtonColors();
            btnAccProfile.setForeground(ColorPalette.redPastel);
            navPage.turnPage(new admnAccountProfile()); //Paltan niyo nalang yung 'new Dashboard()'
            updateMenuPositions();
        });
        btnChangePass = createMainButton("Change Password");
        btnChangePass.addActionListener(e -> {
            closeOtherMenus("");
            resetMainButtonColors();
            btnChangePass.setForeground(ColorPalette.redPastel);
            navPage.turnPage(new ChangePasswordPanel()); //Paltan niyo nalang yung 'new Dashboard()'
            updateMenuPositions();
        });

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
        btn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btn.setBackground(ColorPalette.Blue5); 
        btn.setForeground(Color.WHITE);
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setMargin(new Insets(0, 15, 0, 0)); 
        btn.setFocusPainted(false);
        btn.setBorderPainted(false); 
        btn.setContentAreaFilled(false);  
        btn.setOpaque(true);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(Color.decode("#0E447D")); 
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btn.setBackground(ColorPalette.Blue5); 
            }
        });
        
        return btn;
    }

    private JButton createSubButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        btn.setBackground(ColorPalette.Blue5); 
        btn.setForeground(Color.LIGHT_GRAY);
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setMargin(new Insets(0, 40, 0, 0)); 
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);  
        btn.setOpaque(true);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(Color.decode("#1c3a63")); 
                btn.setForeground(Color.WHITE); 
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btn.setBackground(ColorPalette.Blue5); 
                btn.setForeground(Color.LIGHT_GRAY); 
            }
        });

        return btn;
    }

    private void closeOtherMenus(String menuToKeepOpen) {
        if (!menuToKeepOpen.equals("EMP")) {
            isManageEmpExpanded = false;
            btnManageEmp.setText("Manage Employees          +");
            btnManageEmp.setForeground(Color.WHITE);
        }

        if (!menuToKeepOpen.equals("ACC")) {
            isManageAccExpanded = false;
            btnManageAcc.setText("Manage Accounts            +");
            btnManageAcc.setForeground(Color.WHITE);
        }

        if (!menuToKeepOpen.equals("OPS")) {
            isAccOpsExpanded = false;
            btnAccOps.setText("Account Operations         +");
            btnAccOps.setForeground(Color.WHITE);
        }

        if (!menuToKeepOpen.equals("QUERY")) {
            isAccQueriesExpanded = false;
            btnAccQueries.setText("Account Queries              +");
            btnAccQueries.setForeground(Color.WHITE);
        }
    }

    private void resetMainButtonColors() {
        btnHome.setForeground(Color.WHITE);
        btnManageEmp.setForeground(Color.WHITE);
        btnManageAcc.setForeground(Color.WHITE);
        btnAccOps.setForeground(Color.WHITE);
        btnAccQueries.setForeground(Color.WHITE);
        btnBankBalance.setForeground(Color.WHITE);
        btnAccProfile.setForeground(Color.WHITE);
        btnChangePass.setForeground(Color.WHITE);
    }
}
