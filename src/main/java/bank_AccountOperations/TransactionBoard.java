package bank_AccountOperations;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionBoard extends JPanel {

    public TransactionBoard() {
        setLayout(null);
        setBackground(new Color(235, 235, 235));
        setBounds(0, 0, 1670, 1080);

        JLabel lblTitle = new JLabel("Transaction Board");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 24)); 
        lblTitle.setBounds(30, 25, 300, 40); 
        add(lblTitle);

        JPanel searchBoard = new JPanel();
        searchBoard.setLayout(null); 
        searchBoard.setBackground(Color.decode("#031B42"));
        searchBoard.setBounds(30, 65, 1050, 110); 
        
        JLabel lblHeaderTitle = new JLabel("   Search Board"); 
        lblHeaderTitle.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblHeaderTitle.setForeground(Color.WHITE); 
        lblHeaderTitle.setBackground(Color.decode("#0E447D")); 
        lblHeaderTitle.setOpaque(true); 
        lblHeaderTitle.setBounds(0, 0, 1250, 25); 
        searchBoard.add(lblHeaderTitle);
        
        JLabel lblSenderAcc = new JLabel("Sender Account");
        lblSenderAcc.setForeground(Color.WHITE);
        lblSenderAcc.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblSenderAcc.setBounds(50, 40, 200, 20);
        searchBoard.add(lblSenderAcc);

        JTextField txtSenderAcc = new JTextField("Enter sender account number");
        txtSenderAcc.setForeground(Color.GRAY);
        txtSenderAcc.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtSenderAcc.setBounds(50, 65, 380, 30); 
        searchBoard.add(txtSenderAcc);

        JLabel lblReceiverAcc = new JLabel("Receiver Account");
        lblReceiverAcc.setForeground(Color.WHITE);
        lblReceiverAcc.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblReceiverAcc.setBounds(460, 40, 200, 25);
        searchBoard.add(lblReceiverAcc);

        JTextField txtReceiverAcc = new JTextField("Enter receiver account number");
        txtReceiverAcc.setForeground(Color.GRAY);
        txtReceiverAcc.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtReceiverAcc.setBounds(460, 65, 380, 30); 
        searchBoard.add(txtReceiverAcc);

        JButton btnSearch = new JButton("Search");
        btnSearch.setBackground(Color.decode("#0C3D70"));
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        btnSearch.setBounds(870, 65, 100, 30); 
        searchBoard.add(btnSearch);

        add(searchBoard); 

        JPanel infoBoard = new JPanel();
        infoBoard.setLayout(null);
        infoBoard.setBackground(new Color(235, 235, 235));
        infoBoard.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#0E447D"), 3), "Information Board"));
        infoBoard.setBounds(30, 190, 1050, 210); 

        JLabel lblSenderTitle = new JLabel("Sender Account Title");
        lblSenderTitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSenderTitle.setBounds(26, 25, 200, 25);
        infoBoard.add(lblSenderTitle);

        JTextField txtSenderTitle = new JTextField("Jawel");
        txtSenderTitle.setEditable(false);
        txtSenderTitle.setBackground(new Color(225, 225, 225)); 
        txtSenderTitle.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtSenderTitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtSenderTitle.setBounds(26, 50, 230, 35);
        infoBoard.add(txtSenderTitle);

        JLabel lblSenderNum = new JLabel("Sender Account Number");
        lblSenderNum.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSenderNum.setBounds(276, 25, 250, 25);
        infoBoard.add(lblSenderNum);

        JTextField txtSenderNum = new JTextField("0101010101");
        txtSenderNum.setEditable(false);
        txtSenderNum.setBackground(new Color(225, 225, 225)); 
        txtSenderNum.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtSenderNum.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtSenderNum.setBounds(276, 50, 230, 35);
        infoBoard.add(txtSenderNum);
        
        JLabel lblSenderBalance = new JLabel("Available Balance");
        lblSenderBalance.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSenderBalance.setBounds(26, 100, 200, 25);
        infoBoard.add(lblSenderBalance);

        JTextField txtSenderBalance = new JTextField("PHP 10000.00");
        txtSenderBalance.setEditable(false);
        txtSenderBalance.setBackground(new Color(225, 225, 225)); 
        txtSenderBalance.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtSenderBalance.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtSenderBalance.setBounds(26, 125, 230, 35);
        infoBoard.add(txtSenderBalance);

        JLabel lblSenderAccStatus = new JLabel("Account Status");
        lblSenderAccStatus.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSenderAccStatus.setBounds(276, 100, 250, 25);
        infoBoard.add(lblSenderAccStatus);

        JTextField txtSenderAccStatus = new JTextField("ACTIVE");
        txtSenderAccStatus.setEditable(false);
        txtSenderAccStatus.setBackground(new Color(225, 225, 225)); 
        txtSenderAccStatus.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtSenderAccStatus.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtSenderAccStatus.setBounds(276, 125, 230, 35);
        infoBoard.add(txtSenderAccStatus);
        
        JCheckBox chkSignature = new JCheckBox("Signature Verified");
        chkSignature.setSelected(true);
        chkSignature.setOpaque(false);
        chkSignature.setFont(new Font("Segoe UI", Font.BOLD, 13));
        chkSignature.setForeground(Color.decode("#182b45")); 
        chkSignature.setBounds(26, 170, 200, 25);
        infoBoard.add(chkSignature);
        
        JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
        separator.setBounds(525, 25, 10, 170);
        infoBoard.add(separator);
        
        JLabel lblReceiverTitle = new JLabel("Receiver Account Title");
        lblReceiverTitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblReceiverTitle.setBounds(544, 25, 200, 25);
        infoBoard.add(lblReceiverTitle);

        JTextField txtReceiverTitle = new JTextField("Ryza");
        txtReceiverTitle.setEditable(false);
        txtReceiverTitle.setBackground(new Color(225, 225, 225)); 
        txtReceiverTitle.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtReceiverTitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtReceiverTitle.setBounds(544, 50, 230, 35);
        infoBoard.add(txtReceiverTitle);

        JLabel lblReceiverNum = new JLabel("Receiver Account Number");
        lblReceiverNum.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblReceiverNum.setBounds(794, 25, 250, 25);
        infoBoard.add(lblReceiverNum);

        JTextField txtReceiverNum = new JTextField("11110000");
        txtReceiverNum.setEditable(false);
        txtReceiverNum.setBackground(new Color(225, 225, 225)); 
        txtReceiverNum.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtReceiverNum.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtReceiverNum.setBounds(794, 50, 230, 35);
        infoBoard.add(txtReceiverNum);
        
        JLabel lblReceiverBalance = new JLabel("Account Type");
        lblReceiverBalance.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblReceiverBalance.setBounds(544, 100, 200, 25);
        infoBoard.add(lblReceiverBalance);

        JTextField txtReceiverAccType = new JTextField("Credit");
        txtReceiverAccType.setEditable(false);
        txtReceiverAccType.setBackground(new Color(225, 225, 225)); 
        txtReceiverAccType.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtReceiverAccType.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtReceiverAccType.setBounds(544, 125, 230, 35);
        infoBoard.add(txtReceiverAccType);

        JLabel lblReceiverAccStatus = new JLabel("Account Status");
        lblReceiverAccStatus.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblReceiverAccStatus.setBounds(794, 100, 250, 25);
        infoBoard.add(lblReceiverAccStatus);

        JTextField txtReceiverAccStatus = new JTextField("ACTIVE");
        txtReceiverAccStatus.setEditable(false);
        txtReceiverAccStatus.setBackground(new Color(225, 225, 225)); 
        txtReceiverAccStatus.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtReceiverAccStatus.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtReceiverAccStatus.setBounds(794, 125, 230, 35);
        infoBoard.add(txtReceiverAccStatus);

        add(infoBoard); 

        JPanel actionBoard = new JPanel();
        actionBoard.setLayout(null);      
        actionBoard.setBackground(new Color(235, 235, 235));
        actionBoard.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 3), "Action Board"));
        actionBoard.setBounds(30, 420, 1050, 250); 
        add(actionBoard); 

        JLabel lblRefNum = new JLabel("Reference Number");
        lblRefNum.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblRefNum.setBounds(30, 35, 200, 20);
        actionBoard.add(lblRefNum);

        JTextField txtRefNum = new JTextField("12345ABCDE");
        txtRefNum.setEditable(false); 
        txtRefNum.setBackground(new Color(225, 225, 225)); 
        txtRefNum.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtRefNum.setBounds(30, 55, 250, 35); 
        actionBoard.add(txtRefNum);

        JLabel lblProcBy = new JLabel("Processed By");
        lblProcBy.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblProcBy.setBounds(30, 100, 200, 20);
        actionBoard.add(lblProcBy);

        JTextField txtProcBy = new JTextField("Teller ID: 2006 - hatdog8080");
        txtProcBy.setEditable(false); 
        txtProcBy.setBackground(new Color(225, 225, 225)); 
        txtProcBy.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtProcBy.setBounds(30, 120, 250, 35); 
        actionBoard.add(txtProcBy);

        JLabel lblDate = new JLabel("Transaction Date & Time");
        lblDate.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblDate.setBounds(30, 165, 200, 20);
        actionBoard.add(lblDate);

        String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        JTextField txtDate = new JTextField(currentDate);
        txtDate.setEditable(false); 
        txtDate.setBackground(new Color(225, 225, 225)); 
        txtDate.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtDate.setBounds(30, 185, 250, 35); 
        actionBoard.add(txtDate);

        JLabel lblTransType = new JLabel("Transfer Type");
        lblTransType.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblTransType.setBounds(340, 35, 200, 20);
        actionBoard.add(lblTransType);

        String[] transferTypes = {"Bembank to Bembank", "Bembank to Other Bank"};
        JComboBox<String> cmbTransType = new JComboBox<>(transferTypes);
        cmbTransType.setSelectedIndex(1); 
        cmbTransType.setBounds(340, 55, 280, 35);
        actionBoard.add(cmbTransType);

        JLabel lblAmount = new JLabel("Transfer Amount");
        lblAmount.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblAmount.setBounds(340, 100, 200, 20);
        actionBoard.add(lblAmount);

        JTextField txtAmount = new JTextField(" PHP 1,000,000.00");
        txtAmount.setFont(new Font("Segoe UI", Font.BOLD, 16));
        txtAmount.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 2));
        txtAmount.setBounds(340, 120, 280, 35);
        actionBoard.add(txtAmount);

        JLabel lblTransFee= new JLabel("Transfer Fee:");
        lblTransFee.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblTransFee.setBounds(680, 55, 150, 20);
        actionBoard.add(lblTransFee);

        JLabel lblCostFee = new JLabel("PHP 0.00");
        lblCostFee.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblCostFee.setForeground(Color.RED); 
        lblCostFee.setBounds(830, 55, 150, 20);
        actionBoard.add(lblCostFee);

        JLabel lblTotalTitle = new JLabel("Total Deduction:");
        lblTotalTitle.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblTotalTitle.setBounds(680, 95, 150, 20);
        actionBoard.add(lblTotalTitle);

        JLabel lblTotalValue = new JLabel("PHP 0.00");
        lblTotalValue.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTotalValue.setBounds(830, 90, 200, 30);
        actionBoard.add(lblTotalValue);

        JButton btnTransfer = new JButton("Transfer");
        btnTransfer.setBackground(Color.decode("#0E447D"));
        btnTransfer.setForeground(Color.WHITE);
        btnTransfer.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnTransfer.setBounds(680, 140, 330, 50); 
        actionBoard.add(btnTransfer);

        add(actionBoard);
    }
}
