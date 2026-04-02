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
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30)); 
        lblTitle.setBounds(60, 30, 700, 40); 
        add(lblTitle);

        //Search board panel
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

        JTextField txtAccNum = new JTextField("Enter account number to deposit into");
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

        JLabel lblBalance = new JLabel("Current Balance");
        lblBalance.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblBalance.setBounds(1050, 130, 200, 25);
        infoBoard.add(lblBalance);

        JTextField txtBalance = new JTextField("PHP  1,000,000.00");
        txtBalance.setEditable(false);
        txtBalance.setBackground(new Color(225, 225, 225)); 
        txtBalance.setFont(new Font("Segoe UI", Font.BOLD, 16));
        txtBalance.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtBalance.setBounds(1050, 160, 400, 40);
        infoBoard.add(txtBalance);

        add(infoBoard); 

        //Action board panel
        JPanel actionBoard = new JPanel();
        actionBoard.setLayout(null);      
        actionBoard.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#0E447D"), 3), "Action Board"));
        actionBoard.setBounds(60, 580, 1520, 320); 
        add(actionBoard); 

        JLabel lblRefNum = new JLabel("Deposit Reference No.");
        lblRefNum.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblRefNum.setBounds(50, 40, 200, 20);
        actionBoard.add(lblRefNum);

        JTextField txtRefNum = new JTextField("REF12345678");
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

        JSeparator actSep1 = new JSeparator(SwingConstants.VERTICAL);
        actSep1.setBounds(500, 40, 10, 230);
        actionBoard.add(actSep1);

        JLabel lblDepositor = new JLabel("Depositor's Full Name");
        lblDepositor.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblDepositor.setBounds(550, 40, 200, 20);
        actionBoard.add(lblDepositor);

        JTextField txtDepositor = new JTextField("Enter name of person depositing");
        txtDepositor.setForeground(Color.GRAY);
        txtDepositor.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtDepositor.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtDepositor.setBounds(550, 70, 400, 40); 
        actionBoard.add(txtDepositor);

        JLabel lblDepMethod = new JLabel("Deposit Method");
        lblDepMethod.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblDepMethod.setBounds(550, 130, 200, 20);
        actionBoard.add(lblDepMethod);

        String[] methods = {"Cash Deposit", "Check Deposit", "Fund Transfer"};
        JComboBox<String> cmbDepMethod = new JComboBox<>(methods);
        cmbDepMethod.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        cmbDepMethod.setBounds(550, 160, 400, 40); 
        actionBoard.add(cmbDepMethod);

        JSeparator actSep2 = new JSeparator(SwingConstants.VERTICAL);
        actSep2.setBounds(1000, 40, 10, 230);
        actionBoard.add(actSep2);

        JLabel lblAmount = new JLabel("Deposit Amount");
        lblAmount.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblAmount.setBounds(1050, 40, 200, 20);
        actionBoard.add(lblAmount);

        JTextField txtAmount = new JTextField(" PHP 0.00");
        txtAmount.setFont(new Font("Segoe UI", Font.BOLD, 20)); 
        txtAmount.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 2)); 
        txtAmount.setBounds(1050, 70, 400, 45); 
        actionBoard.add(txtAmount);

        JButton btnDeposit = new JButton("DEPOSIT");
        btnDeposit.setBackground(Color.decode("#0C3D70")); 
        btnDeposit.setForeground(Color.WHITE);
        btnDeposit.setFont(new Font("Segoe UI", Font.BOLD, 22)); 
        btnDeposit.setBounds(1050, 180, 400, 60); 
        btnDeposit.addActionListener(e -> showDepositDialog());
        actionBoard.add(btnDeposit);
    }
   
    //Confirmation dialog
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

        //Confirm transaction
        JButton btnConfirm = new JButton("Confirm");
        btnConfirm.setBackground(Color.decode("#0C3D70"));
        btnConfirm.setForeground(Color.WHITE);
        btnConfirm.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnConfirm.setBounds(40, 270, 150, 40);
   
        //If deposit confirmed
        btnConfirm.addActionListener(e -> {
            dialog.dispose(); 
            JOptionPane.showMessageDialog(parentWindow, "Deposited successfully!", "Transaction Complete", JOptionPane.INFORMATION_MESSAGE);
        }); 

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBackground(Color.LIGHT_GRAY);
        btnCancel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnCancel.setBounds(210, 270, 150, 40);
        
        //If the deposit was cancelled
        btnCancel.addActionListener(e -> {
            dialog.dispose(); 
            JOptionPane.showMessageDialog(parentWindow, "Transaction Cancelled.", "Transaction Cancelled", JOptionPane.ERROR_MESSAGE);
        }); 

        dialog.add(btnConfirm);
        dialog.add(btnCancel);
        dialog.setVisible(true); 
    }
}