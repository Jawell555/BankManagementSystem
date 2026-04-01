package bank_AccountOperations;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DepositBoard extends JPanel {

    public DepositBoard() {
        setLayout(null);
        setBackground(new Color(235, 235, 235));
        setBounds(0, 0, 1670, 1080); 

        JLabel lblTitle = new JLabel("Deposit Board");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 35)); 
        lblTitle.setBounds(50, 40, 400, 50); 
        add(lblTitle);

        JPanel searchBoard = new JPanel();
        searchBoard.setLayout(null); 
        searchBoard.setBackground(Color.decode("#031B42"));
        searchBoard.setBounds(50, 120, 1570, 180); 
        
        JLabel lblHeaderTitle = new JLabel("   Search Board"); 
        lblHeaderTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblHeaderTitle.setForeground(Color.WHITE); 
        lblHeaderTitle.setBackground(Color.decode("#0E447D")); 
        lblHeaderTitle.setOpaque(true); 
        lblHeaderTitle.setBounds(0, 0, 1570, 35); 
        searchBoard.add(lblHeaderTitle);
        
        JLabel lblAccNum = new JLabel("Account Number");
        lblAccNum.setForeground(Color.WHITE);
        lblAccNum.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblAccNum.setBounds(50, 60, 200, 25);
        searchBoard.add(lblAccNum);

        JTextField txtAccNum = new JTextField("Enter account number to deposit into");
        txtAccNum.setForeground(Color.GRAY);
        txtAccNum.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtAccNum.setBounds(50, 95, 730, 50); 
        searchBoard.add(txtAccNum);

        JButton btnSearch = new JButton("Search Account");
        btnSearch.setBackground(Color.decode("#0C3D70"));
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnSearch.setBounds(800, 95, 190, 50); 
        searchBoard.add(btnSearch);

        add(searchBoard); 

        JPanel infoBoard = new JPanel();
        infoBoard.setLayout(null);
        infoBoard.setBackground(new Color(235, 235, 235));
        infoBoard.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#0E447D"), 3), "Information Board"));
        infoBoard.setBounds(50, 325, 1570, 310); 

        JLabel lblAccTitle = new JLabel("Account Title");
        lblAccTitle.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblAccTitle.setBounds(50, 60, 200, 25);
        infoBoard.add(lblAccTitle);

        JTextField txtAccTitle = new JTextField("Ryza Reyes");
        txtAccTitle.setEditable(false);
        txtAccTitle.setBackground(new Color(225, 225, 225)); 
        txtAccTitle.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtAccTitle.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtAccTitle.setBounds(50, 90, 400, 45);
        infoBoard.add(txtAccTitle);

        JLabel lblAccStatus = new JLabel("Account Status");
        lblAccStatus.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblAccStatus.setBounds(50, 165, 200, 25);
        infoBoard.add(lblAccStatus);

        JTextField txtAccStatus = new JTextField("ACTIVE");
        txtAccStatus.setEditable(false);
        txtAccStatus.setBackground(new Color(225, 225, 225)); 
        txtAccStatus.setFont(new Font("Segoe UI", Font.BOLD, 15));
        txtAccStatus.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtAccStatus.setBounds(50, 195, 400, 45);
        infoBoard.add(txtAccStatus);

        JSeparator infoSep1 = new JSeparator(SwingConstants.VERTICAL);
        infoSep1.setBounds(500, 40, 10, 230);
        infoBoard.add(infoSep1);

        JLabel lblHolderName = new JLabel("Account Holder Name");
        lblHolderName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblHolderName.setBounds(550, 60, 250, 25);
        infoBoard.add(lblHolderName);

        JTextField txtHolderName = new JTextField("Ryza");
        txtHolderName.setEditable(false);
        txtHolderName.setBackground(new Color(225, 225, 225)); 
        txtHolderName.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtHolderName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtHolderName.setBounds(550, 90, 400, 45);
        infoBoard.add(txtHolderName);

        JLabel lblAccType = new JLabel("Account Type");
        lblAccType.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblAccType.setBounds(550, 165, 250, 25);
        infoBoard.add(lblAccType);

        JTextField txtAccType = new JTextField("Savings");
        txtAccType.setEditable(false);
        txtAccType.setBackground(new Color(225, 225, 225)); 
        txtAccType.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtAccType.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtAccType.setBounds(550, 195, 400, 45);
        infoBoard.add(txtAccType);

        JSeparator infoSep2 = new JSeparator(SwingConstants.VERTICAL);
        infoSep2.setBounds(1000, 40, 10, 230);
        infoBoard.add(infoSep2);

        JLabel lblDisplayAccNum = new JLabel("Account Number");
        lblDisplayAccNum.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblDisplayAccNum.setBounds(1050, 60, 250, 25);
        infoBoard.add(lblDisplayAccNum);

        JTextField txtDisplayAccNum = new JTextField("0101010101");
        txtDisplayAccNum.setEditable(false);
        txtDisplayAccNum.setBackground(new Color(225, 225, 225)); 
        txtDisplayAccNum.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtDisplayAccNum.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtDisplayAccNum.setBounds(1050, 90, 400, 45);
        infoBoard.add(txtDisplayAccNum);

        JLabel lblBalance = new JLabel("Current Balance");
        lblBalance.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblBalance.setBounds(1050, 165, 200, 25);
        infoBoard.add(lblBalance);

        JTextField txtBalance = new JTextField("PHP  1,000,000.00");
        txtBalance.setEditable(false);
        txtBalance.setBackground(new Color(225, 225, 225)); 
        txtBalance.setFont(new Font("Segoe UI", Font.BOLD, 16));
        txtBalance.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtBalance.setBounds(1050, 195, 400, 45);
        infoBoard.add(txtBalance);

        add(infoBoard); 

        JPanel actionBoard = new JPanel();
        actionBoard.setLayout(null);      
        actionBoard.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#0E447D"), 3), "Action Board"));
        actionBoard.setBounds(50, 670, 1570, 360); 
        add(actionBoard); 

        JLabel lblRefNum = new JLabel("Deposit Reference No.");
        lblRefNum.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblRefNum.setBounds(50, 60, 200, 20);
        actionBoard.add(lblRefNum);

        JTextField txtRefNum = new JTextField("REF12345678");
        txtRefNum.setEditable(false); 
        txtRefNum.setBackground(new Color(225, 225, 225)); 
        txtRefNum.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtRefNum.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtRefNum.setBounds(50, 90, 400, 50); 
        actionBoard.add(txtRefNum);

        JLabel lblDate = new JLabel("Transaction Date & Time");
        lblDate.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblDate.setBounds(50, 170, 200, 20);
        actionBoard.add(lblDate);

        String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        JTextField txtDate = new JTextField(currentDate);
        txtDate.setEditable(false); 
        txtDate.setBackground(new Color(225, 225, 225)); 
        txtDate.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtDate.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtDate.setBounds(50, 200, 400, 50); 
        actionBoard.add(txtDate);

        JSeparator actSep1 = new JSeparator(SwingConstants.VERTICAL);
        actSep1.setBounds(500, 50, 10, 275);
        actionBoard.add(actSep1);

        JLabel lblDepositor = new JLabel("Depositor's Full Name");
        lblDepositor.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblDepositor.setBounds(550, 60, 200, 20);
        actionBoard.add(lblDepositor);

        JTextField txtDepositor = new JTextField("Enter name of person depositing");
        txtDepositor.setForeground(Color.GRAY);
        txtDepositor.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtDepositor.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtDepositor.setBounds(550, 90, 400, 50); 
        actionBoard.add(txtDepositor);

        JLabel lblDepMethod = new JLabel("Deposit Method");
        lblDepMethod.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblDepMethod.setBounds(550, 170, 200, 20);
        actionBoard.add(lblDepMethod);

        String[] methods = {"Cash Deposit", "Check Deposit", "Fund Transfer"};
        JComboBox<String> cmbDepMethod = new JComboBox<>(methods);
        cmbDepMethod.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        cmbDepMethod.setBounds(550, 200, 400, 50); 
        actionBoard.add(cmbDepMethod);

        JSeparator actSep2 = new JSeparator(SwingConstants.VERTICAL);
        actSep2.setBounds(1000, 50, 10, 275);
        actionBoard.add(actSep2);

        JLabel lblAmount = new JLabel("Deposit Amount");
        lblAmount.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblAmount.setBounds(1050, 60, 200, 20);
        actionBoard.add(lblAmount);

        JTextField txtAmount = new JTextField(" PHP 0.00");
        txtAmount.setFont(new Font("Segoe UI", Font.BOLD, 20)); 
        txtAmount.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 2)); 
        txtAmount.setBounds(1050, 90, 400, 50);
        actionBoard.add(txtAmount);

        JButton btnDeposit = new JButton("DEPOSIT");
        btnDeposit.setBackground(Color.decode("#0C3D70")); 
        btnDeposit.setForeground(Color.WHITE);
        btnDeposit.setFont(new Font("Segoe UI", Font.BOLD, 22)); 
        btnDeposit.setBounds(1050, 200, 400, 70); 
        btnDeposit.addActionListener(e -> showDepositDialog());
        actionBoard.add(btnDeposit);
    }
   
    private void showDepositDialog() {
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        JDialog dialog = new JDialog((JFrame)parentWindow, "Deposit Confirmation", true);
        dialog.setSize(420, 360);
        dialog.setLayout(null);
        dialog.getContentPane().setBackground(Color.WHITE);
        dialog.setLocationRelativeTo(parentWindow); 

        JPanel header = new JPanel();
        header.setBackground(Color.decode("#0E447D"));
        header.setBounds(0, 0, 420, 40);
        header.setLayout(null);
        
        JLabel lblDialogTitle = new JLabel("Verify Deposit Details", SwingConstants.CENTER);
        lblDialogTitle.setForeground(Color.WHITE);
        lblDialogTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblDialogTitle.setBounds(0, 10, 420, 20);
        header.add(lblDialogTitle);
        dialog.add(header);

        JLabel msg = new JLabel("Please ensure cash is received before confirming.");
        msg.setFont(new Font("Segoe UI", Font.ITALIC, 13));
        msg.setBounds(30, 60, 350, 20);
        dialog.add(msg);

        JLabel lblNameTitle = new JLabel("Account Name:");
        lblNameTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblNameTitle.setBounds(30, 100, 120, 20);
        dialog.add(lblNameTitle);

        JLabel lblNameVal = new JLabel("Ryza Reyes");
        lblNameVal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNameVal.setBounds(150, 100, 200, 20);
        dialog.add(lblNameVal);

        JLabel lblAccTitle = new JLabel("Account No:");
        lblAccTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblAccTitle.setBounds(30, 130, 120, 20);
        dialog.add(lblAccTitle);

        JLabel lblAccVal = new JLabel("0101010101");
        lblAccVal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblAccVal.setBounds(150, 130, 200, 20);
        dialog.add(lblAccVal);

        JLabel lblMethodTitle = new JLabel("Method:");
        lblMethodTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblMethodTitle.setBounds(30, 160, 120, 20);
        dialog.add(lblMethodTitle);

        JLabel lblMethodVal = new JLabel("Cash Deposit");
        lblMethodVal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblMethodVal.setBounds(150, 160, 200, 20);
        dialog.add(lblMethodVal);

        JSeparator sep = new JSeparator();
        sep.setBounds(30, 200, 340, 2);
        dialog.add(sep);

        JLabel lblTotalTitle = new JLabel("AMOUNT TO DEPOSIT:");
        lblTotalTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblTotalTitle.setBounds(30, 220, 200, 20);
        dialog.add(lblTotalTitle);

        JLabel lblTotalVal = new JLabel("PHP 5,000.00"); 
        lblTotalVal.setFont(new Font("Segoe UI", Font.BOLD, 19));
        lblTotalVal.setBounds(210, 218, 150, 25);
        dialog.add(lblTotalVal);

        JButton btnConfirm = new JButton("Confirm");
        btnConfirm.setBackground(Color.decode("#0C3D70"));
        btnConfirm.setForeground(Color.WHITE);
        btnConfirm.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnConfirm.setBounds(40, 270, 150, 40);
        
        btnConfirm.addActionListener(e -> {
            dialog.dispose(); 
            JOptionPane.showMessageDialog(parentWindow, "Deposited successfully!", "Transaction Complete", JOptionPane.INFORMATION_MESSAGE);
        }); 

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBackground(Color.LIGHT_GRAY);
        btnCancel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnCancel.setBounds(210, 270, 150, 40);
        btnCancel.addActionListener(e -> dialog.dispose()); 
        
        btnCancel.addActionListener(e -> {
            dialog.dispose(); 
            JOptionPane.showMessageDialog(parentWindow, "Transaction Cancelled.", "Transaction Cancelled", JOptionPane.ERROR_MESSAGE);
        }); 

        dialog.add(btnConfirm);
        dialog.add(btnCancel);
        dialog.setVisible(true); 
    }
}

    