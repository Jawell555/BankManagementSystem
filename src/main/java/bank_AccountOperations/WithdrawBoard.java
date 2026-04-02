package bank_AccountOperations;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WithdrawBoard extends JPanel {

    public WithdrawBoard() {
        setLayout(null);
        setBackground(new Color(235, 235, 235));
        setBounds(0, 0, 1670, 1080); 

        JLabel lblTitle = new JLabel("Withdrawal Board");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30)); 
        lblTitle.setBounds(60, 30, 700, 40); 
        add(lblTitle);

        //Search board
        JPanel searchBoard = new JPanel();
        searchBoard.setLayout(null); 
        searchBoard.setBackground(Color.decode("#031B42"));
        searchBoard.setBounds(60, 100, 1520, 150); 
        
        JLabel lblHeaderTitle = new JLabel("   Search Board"); 
        lblHeaderTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblHeaderTitle.setForeground(Color.WHITE); 
        lblHeaderTitle.setBackground(Color.decode("#0E447D")); 
        lblHeaderTitle.setOpaque(true); 
        lblHeaderTitle.setBounds(0, 0, 1520, 35); 
        searchBoard.add(lblHeaderTitle);

        //Search account
        JLabel lblAccNum = new JLabel("Account Number");
        lblAccNum.setForeground(Color.WHITE);
        lblAccNum.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblAccNum.setBounds(50, 50, 200, 25);
        searchBoard.add(lblAccNum);

        JTextField txtAccNum = new JTextField("Enter account number to withdraw from");
        txtAccNum.setForeground(Color.GRAY);
        txtAccNum.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtAccNum.setBounds(50, 80, 730, 40); 
        searchBoard.add(txtAccNum);

        JButton btnSearch = new JButton("Search Account");
        btnSearch.setBackground(Color.decode("#0C3D70"));
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnSearch.setBounds(800, 80, 190, 40); 
        searchBoard.add(btnSearch);

        add(searchBoard); 

        //Information board panel
        JPanel infoBoard = new JPanel();
        infoBoard.setLayout(null);
        infoBoard.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#0E447D"), 3), "Information Board"));
        infoBoard.setBounds(60, 275, 1520, 280); 

        //Account details
        JLabel lblAccTitle = new JLabel("Account Title");
        lblAccTitle.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblAccTitle.setBounds(50, 40, 200, 25);
        infoBoard.add(lblAccTitle);

        JTextField txtAccTitle = new JTextField("Ryza Reyes");
        txtAccTitle.setEditable(false);
        txtAccTitle.setBackground(new Color(225, 225, 225)); 
        txtAccTitle.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtAccTitle.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtAccTitle.setBounds(50, 70, 400, 40);
        infoBoard.add(txtAccTitle);

        JLabel lblAccStatus = new JLabel("Account Status");
        lblAccStatus.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblAccStatus.setBounds(50, 130, 200, 25);
        infoBoard.add(lblAccStatus);

        JTextField txtAccStatus = new JTextField("ACTIVE");
        txtAccStatus.setEditable(false);
        txtAccStatus.setBackground(new Color(225, 225, 225));  
        txtAccStatus.setFont(new Font("Segoe UI", Font.BOLD, 15));
        txtAccStatus.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtAccStatus.setBounds(50, 160, 400, 40);
        infoBoard.add(txtAccStatus);

        JSeparator infoSep1 = new JSeparator(SwingConstants.VERTICAL);
        infoSep1.setBounds(500, 40, 10, 200);
        infoBoard.add(infoSep1);

        JLabel lblHolderName = new JLabel("Account Holder Name");
        lblHolderName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblHolderName.setBounds(550, 40, 250, 25);
        infoBoard.add(lblHolderName);

        JTextField txtHolderName = new JTextField("Ryza");
        txtHolderName.setEditable(false);
        txtHolderName.setBackground(new Color(225, 225, 225)); 
        txtHolderName.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtHolderName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtHolderName.setBounds(550, 70, 400, 40);
        infoBoard.add(txtHolderName);

        JLabel lblAccType = new JLabel("Account Type");
        lblAccType.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblAccType.setBounds(550, 130, 250, 25);
        infoBoard.add(lblAccType);

        JTextField txtAccType = new JTextField("Savings");
        txtAccType.setEditable(false);
        txtAccType.setBackground(new Color(225, 225, 225)); 
        txtAccType.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtAccType.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtAccType.setBounds(550, 160, 400, 40);
        infoBoard.add(txtAccType);

        JSeparator infoSep2 = new JSeparator(SwingConstants.VERTICAL);
        infoSep2.setBounds(1000, 40, 10, 200);
        infoBoard.add(infoSep2);

        JLabel lblDisplayAccNum = new JLabel("Account Number");
        lblDisplayAccNum.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblDisplayAccNum.setBounds(1050, 40, 250, 25);
        infoBoard.add(lblDisplayAccNum);

        JTextField txtDisplayAccNum = new JTextField("0101010101");
        txtDisplayAccNum.setEditable(false);
        txtDisplayAccNum.setBackground(new Color(225, 225, 225)); 
        txtDisplayAccNum.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtDisplayAccNum.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtDisplayAccNum.setBounds(1050, 70, 400, 40);
        infoBoard.add(txtDisplayAccNum);

        JLabel lblBalance = new JLabel("Available Balance");
        lblBalance.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblBalance.setBounds(1050, 130, 200, 25);
        infoBoard.add(lblBalance);

        JTextField txtBalance = new JTextField("PHP 1,000,000.00");
        txtBalance.setEditable(false);
        txtBalance.setBackground(new Color(225, 225, 225)); 
        txtBalance.setFont(new Font("Segoe UI", Font.BOLD, 16));
        txtBalance.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtBalance.setBounds(1050, 160, 400, 40);
        infoBoard.add(txtBalance);

        add(infoBoard); 

        //Action board
        JPanel actionBoard = new JPanel();
        actionBoard.setLayout(null);      
        actionBoard.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#0E447D"), 3), "Action Board"));
        actionBoard.setBounds(60, 580, 1520, 320); 
        add(actionBoard); 

        JLabel lblRefNum = new JLabel("Withdrawal Reference No.");
        lblRefNum.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblRefNum.setBounds(50, 40, 200, 20);
        actionBoard.add(lblRefNum);

        JTextField txtRefNum = new JTextField("0101-01010-01010");
        txtRefNum.setEditable(false); 
        txtRefNum.setBackground(new Color(225, 225, 225)); 
        txtRefNum.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtRefNum.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtRefNum.setBounds(50, 70, 400, 40); 
        actionBoard.add(txtRefNum);

        JLabel lblDate = new JLabel("Transaction Date & Time");
        lblDate.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblDate.setBounds(50, 130, 200, 20);
        actionBoard.add(lblDate);

        String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        JTextField txtDate = new JTextField(currentDate);
        txtDate.setEditable(false); 
        txtDate.setBackground(new Color(225, 225, 225)); 
        txtDate.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtDate.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtDate.setBounds(50, 160, 400, 40); 
        actionBoard.add(txtDate);

        JLabel lblIdType = new JLabel("Valid ID Presented");
        lblIdType.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblIdType.setBounds(50, 220, 200, 20);
        actionBoard.add(lblIdType);

        String[] idTypes = {"Driver's License", "National ID / PhilSys", "Passport", "Company ID"};
        JComboBox<String> cmbIdType = new JComboBox<>(idTypes);
        cmbIdType.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        cmbIdType.setBounds(50, 250, 400, 40); 
        actionBoard.add(cmbIdType);

        JSeparator actSep1 = new JSeparator(SwingConstants.VERTICAL);
        actSep1.setBounds(500, 40, 10, 250);
        actionBoard.add(actSep1);

        JLabel lblWithdrawer = new JLabel("Withdrawer's Full Name");
        lblWithdrawer.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblWithdrawer.setBounds(550, 40, 200, 20);
        actionBoard.add(lblWithdrawer);

        JTextField txtWithdrawer = new JTextField("Enter name of person withdrawing");
        txtWithdrawer.setForeground(Color.GRAY);
        txtWithdrawer.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtWithdrawer.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtWithdrawer.setBounds(550, 70, 400, 40); 
        actionBoard.add(txtWithdrawer);

        JLabel lblMethod = new JLabel("Withdrawal Method");
        lblMethod.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblMethod.setBounds(550, 130, 200, 20);
        actionBoard.add(lblMethod);

        String[] methods = {"Over-the-counter", "ATM", "Online transfer"};
        JComboBox<String> cmbMethod = new JComboBox<>(methods);
        cmbMethod.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        cmbMethod.setBounds(550, 160, 400, 40); 
        actionBoard.add(cmbMethod);

        JSeparator actSep2 = new JSeparator(SwingConstants.VERTICAL);
        actSep2.setBounds(1000, 40, 10, 250);
        actionBoard.add(actSep2);

        JLabel lblAmount = new JLabel("Withdrawal Amount");
        lblAmount.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblAmount.setBounds(1050, 40, 200, 20);
        actionBoard.add(lblAmount);

        JTextField txtAmount = new JTextField("PHP 50,000.00");
        txtAmount.setFont(new Font("Segoe UI", Font.BOLD, 20)); 
        txtAmount.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 2)); 
        txtAmount.setBounds(1050, 70, 400, 45); 
        actionBoard.add(txtAmount);

        JLabel lblFeeTitle = new JLabel("Withdrawal Fee:");
        lblFeeTitle.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lblFeeTitle.setBounds(1050, 140, 150, 30);
        actionBoard.add(lblFeeTitle);

        JLabel lblFeeVal = new JLabel("PHP 15.00");
        lblFeeVal.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblFeeVal.setForeground(Color.RED); 
        lblFeeVal.setBounds(1250, 140, 150, 30);
        actionBoard.add(lblFeeVal);

        JLabel lblTotalTitle = new JLabel("Total Deduction:");
        lblTotalTitle.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        lblTotalTitle.setBounds(1050, 180, 200, 30);
        actionBoard.add(lblTotalTitle);

        JLabel lblTotalVal = new JLabel("PHP 50,015.00");
        lblTotalVal.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTotalVal.setBounds(1250, 180, 200, 30);
        actionBoard.add(lblTotalVal);

        //Withdraw button
        JButton btnWithdraw = new JButton("WITHDRAW");
        btnWithdraw.setBackground(Color.decode("#0C3D70")); 
        btnWithdraw.setForeground(Color.WHITE);
        btnWithdraw.setFont(new Font("Segoe UI", Font.BOLD, 24)); 
        btnWithdraw.setBounds(1050, 230, 400, 60); 
        btnWithdraw.addActionListener(e -> showWithdrawDialog());
        actionBoard.add(btnWithdraw);
    }

    //Withdraw confirmation
    private void showWithdrawDialog() {
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        JDialog dialog = new JDialog((JFrame)parentWindow, "Withdrawal Confirmation", true);
        dialog.setSize(420, 540); 
        dialog.setLayout(null);
        dialog.getContentPane().setBackground(Color.WHITE);
        dialog.setLocationRelativeTo(parentWindow); 

        JPanel header = new JPanel();
        header.setBackground(Color.decode("#0E447D"));
        header.setBounds(0, 0, 420, 40);
        header.setLayout(null);
        
        JLabel lblDialogTitle = new JLabel("Verify Withdrawal Details", SwingConstants.CENTER);
        lblDialogTitle.setForeground(Color.WHITE);
        lblDialogTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblDialogTitle.setBounds(0, 10, 420, 20);
        header.add(lblDialogTitle);
        dialog.add(header);

        JLabel msg = new JLabel("Please verify identity and ensure sufficient funds.");
        msg.setFont(new Font("Segoe UI", Font.ITALIC, 13));
        msg.setBounds(30, 60, 350, 20);
        dialog.add(msg);

        JLabel lblNameTitle = new JLabel("Account Name:");
        lblNameTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblNameTitle.setBounds(30, 100, 120, 20);
        dialog.add(lblNameTitle);

        JLabel lblNameVal = new JLabel("Ryza Reyes");
        lblNameVal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNameVal.setBounds(175, 100, 200, 20);
        dialog.add(lblNameVal);

        JLabel lblAccTitle = new JLabel("Account No:");
        lblAccTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblAccTitle.setBounds(30, 130, 120, 20);
        dialog.add(lblAccTitle);

        JLabel lblAccVal = new JLabel("0101010101");
        lblAccVal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblAccVal.setBounds(175, 130, 200, 20);
        dialog.add(lblAccVal);

        JLabel lblMethodTitle = new JLabel("Method:");
        lblMethodTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblMethodTitle.setBounds(30, 160, 120, 20);
        dialog.add(lblMethodTitle);

        JLabel lblMethodVal = new JLabel("Over-the-counter");
        lblMethodVal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblMethodVal.setBounds(175, 160, 200, 20);
        dialog.add(lblMethodVal);

        JSeparator sep1 = new JSeparator();
        sep1.setBounds(30, 190, 340, 2);
        dialog.add(sep1);

        JLabel lblAmtTitle = new JLabel("Amount:");
        lblAmtTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblAmtTitle.setBounds(30, 205, 120, 20);
        dialog.add(lblAmtTitle);

        JLabel lblAmtVal = new JLabel("PHP 5,000.00");
        lblAmtVal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblAmtVal.setBounds(175, 205, 150, 20);
        dialog.add(lblAmtVal);

        JLabel lblFeeTitle = new JLabel("Withdrawal Fee:");
        lblFeeTitle.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblFeeTitle.setBounds(30, 230, 120, 20);
        dialog.add(lblFeeTitle);

        JLabel lblFeeVal = new JLabel("PHP 15.00");
        lblFeeVal.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblFeeVal.setForeground(Color.RED);
        lblFeeVal.setBounds(175, 230, 150, 20);
        dialog.add(lblFeeVal);

        JLabel lblTotalTitle = new JLabel("Total Deduction:");
        lblTotalTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblTotalTitle.setBounds(30, 260, 200, 20);
        dialog.add(lblTotalTitle);

        JLabel lblTotalVal = new JLabel("PHP 50,015.00");
        lblTotalVal.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTotalVal.setBounds(175, 258, 150, 25);
        dialog.add(lblTotalVal);

        JLabel lblRemTitle = new JLabel("Remaining Balance:");
        lblRemTitle.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblRemTitle.setBounds(30, 290, 150, 20);
        dialog.add(lblRemTitle);

        JLabel lblRemVal = new JLabel("PHP 994,985.00");
        lblRemVal.setForeground(new Color(0, 153, 51));        
        lblRemVal.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblRemVal.setBounds(175, 290, 150, 20);
        dialog.add(lblRemVal);

        JSeparator sep2 = new JSeparator();
        sep2.setBounds(30, 320, 340, 2);
        dialog.add(sep2);

        JLabel lblAuthTitle = new JLabel("Teller Authorization");
        lblAuthTitle.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblAuthTitle.setForeground(Color.decode("#0E447D"));
        lblAuthTitle.setBounds(30, 335, 200, 20);
        dialog.add(lblAuthTitle);

        JLabel lblTellerName = new JLabel("Teller Name:");
        lblTellerName.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblTellerName.setBounds(30, 365, 100, 25);
        dialog.add(lblTellerName);

        JTextField txtTellerName = new JTextField("Teller 2006 - hatdog8080"); 
        txtTellerName.setEditable(false);
        txtTellerName.setBackground(new Color(235, 235, 235));
        txtTellerName.setBounds(110, 365, 260, 25);
        dialog.add(txtTellerName);

        //Teller needs to enter the pin before proceeding for security purposes
        JLabel lblTellerPin = new JLabel("Teller PIN:");
        lblTellerPin.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblTellerPin.setBounds(30, 400, 100, 25);
        dialog.add(lblTellerPin);

        JPasswordField txtTellerPin = new JPasswordField(); 
        txtTellerPin.setBounds(110, 400, 260, 25);
        dialog.add(txtTellerPin);

        JButton btnConfirm = new JButton("Confirm");
        btnConfirm.setBackground(Color.decode("#0C3D70"));
        btnConfirm.setForeground(Color.WHITE);
        btnConfirm.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnConfirm.setBounds(40, 445, 150, 40);
  
        //If the deposit confirmed, as well as the validations
        btnConfirm.addActionListener(e -> {
            String enteredPin = new String(txtTellerPin.getPassword());
            
            if (enteredPin.trim().isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "Please enter your Teller PIN to authorize this withdrawal.", "Authorization Error", JOptionPane.WARNING_MESSAGE);
            } else {
                dialog.dispose(); 
                JOptionPane.showMessageDialog(parentWindow, "Withdrawal authorized successfully! Please dispense cash.", "Transaction Complete", JOptionPane.INFORMATION_MESSAGE);
            }
        }); 

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBackground(Color.LIGHT_GRAY);
        btnCancel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnCancel.setBounds(210, 445, 150, 40);
        
        //If deposit cancelled was cancelled
        btnCancel.addActionListener(e -> {
            dialog.dispose(); 
            JOptionPane.showMessageDialog(parentWindow, "Transaction Cancelled.", "Transaction Cancelled", JOptionPane.ERROR_MESSAGE);
        }); 

        dialog.add(btnConfirm);
        dialog.add(btnCancel);
        dialog.setVisible(true); 
    }
}