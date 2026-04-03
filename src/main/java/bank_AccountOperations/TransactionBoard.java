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
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30)); 
        lblTitle.setBounds(60, 30, 700, 40); 
        add(lblTitle);

        //Search board panel
        JPanel searchBoard = new JPanel();
        searchBoard.setLayout(null); 
        searchBoard.setBackground(Color.decode("#031B42"));
        searchBoard.setBounds(60, 100, 1520, 150); 
        
        JLabel lblHeaderTitle = new JLabel("   Search Board"); 
        lblHeaderTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblHeaderTitle.setForeground(Color.WHITE); 
        lblHeaderTitle.setBackground(Color.decode("#0E447D")); 
        lblHeaderTitle.setOpaque(true); 
        lblHeaderTitle.setBounds(0, 0, 1520, 35); 
        searchBoard.add(lblHeaderTitle);
        
        //Sender and receiver's account number to search
        JLabel lblSenderAcc = new JLabel("Sender Account");
        lblSenderAcc.setForeground(Color.WHITE);
        lblSenderAcc.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblSenderAcc.setBounds(50, 50, 200, 25);
        searchBoard.add(lblSenderAcc);

        JTextField txtSenderAcc = new JTextField("Enter sender account number");
        txtSenderAcc.setForeground(Color.GRAY);
        txtSenderAcc.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txtSenderAcc.setBounds(50, 80, 500, 40); 
        searchBoard.add(txtSenderAcc);

        JLabel lblReceiverAcc = new JLabel("Receiver Account");
        lblReceiverAcc.setForeground(Color.WHITE);
        lblReceiverAcc.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblReceiverAcc.setBounds(600, 50, 200, 25);
        searchBoard.add(lblReceiverAcc);

        JTextField txtReceiverAcc = new JTextField("Enter receiver account number");
        txtReceiverAcc.setForeground(Color.GRAY);
        txtReceiverAcc.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txtReceiverAcc.setBounds(600, 80, 500, 40); 
        searchBoard.add(txtReceiverAcc);

        //Search account button
        JButton btnSearch = new JButton("Search");
        btnSearch.setBackground(Color.decode("#0C3D70"));
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnSearch.setBounds(1150, 80, 200, 40); 
        searchBoard.add(btnSearch);

        add(searchBoard); 

        //Information board panel
        JPanel infoBoard = new JPanel();
        infoBoard.setLayout(null);
        infoBoard.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#0E447D"), 3), "Information Board"));
        infoBoard.setBounds(60, 275, 1520, 280); 

        //Sender account details
        JLabel lblSenderTitle = new JLabel("Sender Account Title");
        lblSenderTitle.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblSenderTitle.setBounds(50, 40, 200, 25);
        infoBoard.add(lblSenderTitle);

        JTextField txtSenderTitle = new JTextField("Jawel");
        txtSenderTitle.setEditable(false);
        txtSenderTitle.setBackground(new Color(225, 225, 225)); 
        txtSenderTitle.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtSenderTitle.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txtSenderTitle.setBounds(50, 70, 400, 40); 
        infoBoard.add(txtSenderTitle);

        JLabel lblSenderBalance = new JLabel("Available Balance");
        lblSenderBalance.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblSenderBalance.setBounds(50, 130, 200, 25);
        infoBoard.add(lblSenderBalance);

        JTextField txtSenderBalance = new JTextField("PHP 10000.00");
        txtSenderBalance.setEditable(false);
        txtSenderBalance.setBackground(new Color(225, 225, 225)); 
        txtSenderBalance.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txtSenderBalance.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtSenderBalance.setBounds(50, 160, 400, 40); 
        infoBoard.add(txtSenderBalance);

        JCheckBox chkSignature = new JCheckBox("Signature Verified");
        chkSignature.setSelected(true);
        chkSignature.setOpaque(false);
        chkSignature.setFont(new Font("Segoe UI", Font.BOLD, 16));
        chkSignature.setForeground(Color.decode("#182b45")); 
        chkSignature.setBounds(50, 220, 200, 25);
        infoBoard.add(chkSignature);
        
        JSeparator separator1 = new JSeparator(SwingConstants.VERTICAL);
        separator1.setBounds(500, 40, 10, 200); 
        infoBoard.add(separator1);

        JLabel lblSenderNum = new JLabel("Sender Account Number");
        lblSenderNum.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblSenderNum.setBounds(550, 40, 250, 25);
        infoBoard.add(lblSenderNum);

        JTextField txtSenderNum = new JTextField("0101010101");
        txtSenderNum.setEditable(false);
        txtSenderNum.setBackground(new Color(225, 225, 225)); 
        txtSenderNum.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtSenderNum.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txtSenderNum.setBounds(550, 70, 400, 40); 
        infoBoard.add(txtSenderNum);

        JLabel lblSenderAccStatus = new JLabel("Account Status");
        lblSenderAccStatus.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblSenderAccStatus.setBounds(550, 130, 250, 25);
        infoBoard.add(lblSenderAccStatus);

        JTextField txtSenderAccStatus = new JTextField("ACTIVE");
        txtSenderAccStatus.setEditable(false);
        txtSenderAccStatus.setBackground(new Color(225, 225, 225)); 
        txtSenderAccStatus.setFont(new Font("Segoe UI", Font.BOLD, 16));
        txtSenderAccStatus.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtSenderAccStatus.setBounds(550, 160, 400, 40); 
        infoBoard.add(txtSenderAccStatus);

        JSeparator separator2 = new JSeparator(SwingConstants.VERTICAL);
        separator2.setBounds(1000, 40, 10, 200); 
        infoBoard.add(separator2);
        
        //Receiver account details
        JLabel lblReceiverTitle = new JLabel("Receiver Account Title");
        lblReceiverTitle.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblReceiverTitle.setBounds(1050, 40, 200, 25);
        infoBoard.add(lblReceiverTitle);

        JTextField txtReceiverTitle = new JTextField("Ryza");
        txtReceiverTitle.setEditable(false);
        txtReceiverTitle.setBackground(new Color(225, 225, 225)); 
        txtReceiverTitle.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtReceiverTitle.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txtReceiverTitle.setBounds(1050, 70, 400, 40); 
        infoBoard.add(txtReceiverTitle);

        JLabel lblReceiverNum = new JLabel("Receiver Account Number");
        lblReceiverNum.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblReceiverNum.setBounds(1050, 130, 250, 25);
        infoBoard.add(lblReceiverNum);

        JTextField txtReceiverNum = new JTextField("11110000");
        txtReceiverNum.setEditable(false);
        txtReceiverNum.setBackground(new Color(225, 225, 225)); 
        txtReceiverNum.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtReceiverNum.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txtReceiverNum.setBounds(1050, 160, 400, 40); 
        infoBoard.add(txtReceiverNum);

        add(infoBoard); 

        //Action board
        JPanel actionBoard = new JPanel();
        actionBoard.setLayout(null);      
        actionBoard.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#0E447D"), 3), "Action Board"));
        actionBoard.setBounds(60, 580, 1520, 320); 
        add(actionBoard); 

        JLabel lblRefNum = new JLabel("Reference Number");
        lblRefNum.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblRefNum.setBounds(50, 40, 200, 25);
        actionBoard.add(lblRefNum);

        JTextField txtRefNum = new JTextField("12345ABCD");
        txtRefNum.setEditable(false); 
        txtRefNum.setBackground(new Color(225, 225, 225)); 
        txtRefNum.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtRefNum.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txtRefNum.setBounds(50, 70, 400, 40); 
        actionBoard.add(txtRefNum);

        JLabel lblProcBy = new JLabel("Processed By");
        lblProcBy.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblProcBy.setBounds(50, 130, 200, 25);
        actionBoard.add(lblProcBy);

        JTextField txtProcBy = new JTextField("Teller ID: 2006 - hatdog8080");
        txtProcBy.setEditable(false); 
        txtProcBy.setBackground(new Color(225, 225, 225)); 
        txtProcBy.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtProcBy.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txtProcBy.setBounds(50, 160, 400, 40); 
        actionBoard.add(txtProcBy);

        JLabel lblDate = new JLabel("Transaction Date & Time");
        lblDate.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblDate.setBounds(50, 220, 200, 25);
        actionBoard.add(lblDate);

        String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        JTextField txtDate = new JTextField(currentDate);
        txtDate.setEditable(false); 
        txtDate.setBackground(new Color(225, 225, 225)); 
        txtDate.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtDate.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txtDate.setBounds(50, 250, 400, 40); 
        actionBoard.add(txtDate);

        JLabel lblTransType = new JLabel("Transfer Type");
        lblTransType.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblTransType.setBounds(550, 40, 200, 25);
        actionBoard.add(lblTransType);

        String[] transferTypes = {"Summit PhilBank to Summit PhilBank", "Summit PhilBank to Other Bank"};
        JComboBox<String> cmbTransType = new JComboBox<>(transferTypes);
        cmbTransType.setSelectedIndex(1); 
        cmbTransType.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        cmbTransType.setBounds(550, 70, 400, 40);
        actionBoard.add(cmbTransType);

        JLabel lblAmount = new JLabel("Transfer Amount");
        lblAmount.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblAmount.setBounds(550, 130, 200, 25);
        actionBoard.add(lblAmount);

        JTextField txtAmount = new JTextField("PHP 1,000,000.00");
        txtAmount.setFont(new Font("Segoe UI", Font.BOLD, 20));
        txtAmount.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 2));
        txtAmount.setBounds(550, 160, 400, 45); 
        actionBoard.add(txtAmount);

        JLabel lblTransFee = new JLabel("Transfer Fee:");
        lblTransFee.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        lblTransFee.setBounds(1050, 70, 150, 30);
        actionBoard.add(lblTransFee);

        JLabel lblCostFee = new JLabel("PHP 0.00");
        lblCostFee.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblCostFee.setForeground(Color.RED); 
        lblCostFee.setBounds(1250, 70, 200, 30);
        actionBoard.add(lblCostFee);

        JLabel lblTotalTitle = new JLabel("Total Deduction:");
        lblTotalTitle.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        lblTotalTitle.setBounds(1050, 130, 200, 30);
        actionBoard.add(lblTotalTitle);

        JLabel lblTotalValue = new JLabel("PHP 0.00");
        lblTotalValue.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTotalValue.setBounds(1250, 130, 250, 30);
        actionBoard.add(lblTotalValue);

        //Transfer button
        JButton btnTransfer = new JButton("TRANSFER");
        btnTransfer.setBackground(Color.decode("#0E447D"));
        btnTransfer.setForeground(Color.WHITE);
        btnTransfer.setFont(new Font("Segoe UI", Font.BOLD, 22)); 
        btnTransfer.setBounds(1050, 200, 400, 60);
        
        btnTransfer.addActionListener(e -> showTransferDialog());
        
        actionBoard.add(btnTransfer);
    }

    //Confirmation of transfer
    private void showTransferDialog() {
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        JDialog dialog = new JDialog((JFrame)parentWindow, "Transfer Confirmation", true);
        dialog.setSize(450, 420); 
        dialog.setLayout(null);
        dialog.getContentPane().setBackground(Color.WHITE);
        dialog.setLocationRelativeTo(parentWindow); 

        JPanel header = new JPanel();
        header.setBackground(Color.decode("#0E447D"));
        header.setBounds(0, 0, 450, 40);
        header.setLayout(null);
        
        JLabel lblDialogTitle = new JLabel("Verify Transfer Details", SwingConstants.CENTER);
        lblDialogTitle.setForeground(Color.WHITE);
        lblDialogTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblDialogTitle.setBounds(0, 10, 450, 20);
        header.add(lblDialogTitle);
        dialog.add(header);

        JLabel msg = new JLabel("Please review the transaction details below.");
        msg.setFont(new Font("Segoe UI", Font.ITALIC, 13));
        msg.setBounds(30, 60, 350, 20);
        dialog.add(msg);

        JLabel lblSenderTitle = new JLabel("Sender:");
        lblSenderTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblSenderTitle.setBounds(30, 100, 120, 20);
        dialog.add(lblSenderTitle);

        JLabel lblSenderVal = new JLabel("Jawel (0101010101)");
        lblSenderVal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSenderVal.setBounds(150, 100, 250, 20);
        dialog.add(lblSenderVal);

        JLabel lblReceiverTitle = new JLabel("Receiver:");
        lblReceiverTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblReceiverTitle.setBounds(30, 130, 120, 20);
        dialog.add(lblReceiverTitle);

        JLabel lblReceiverVal = new JLabel("Ryza (11110000)");
        lblReceiverVal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblReceiverVal.setBounds(150, 130, 250, 20);
        dialog.add(lblReceiverVal);

        JLabel lblTypeTitle = new JLabel("Transfer Type:");
        lblTypeTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblTypeTitle.setBounds(30, 160, 120, 20);
        dialog.add(lblTypeTitle);

        JLabel lblTypeVal = new JLabel("Bembank to Other Bank");
        lblTypeVal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblTypeVal.setBounds(150, 160, 250, 20);
        dialog.add(lblTypeVal);

        JLabel lblAmtTitle = new JLabel("Amount:");
        lblAmtTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblAmtTitle.setBounds(30, 190, 120, 20);
        dialog.add(lblAmtTitle);

        JLabel lblAmtVal = new JLabel("PHP 1,000,000.00");
        lblAmtVal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblAmtVal.setBounds(150, 190, 250, 20);
        dialog.add(lblAmtVal);

        JLabel lblFeeTitle = new JLabel("Transfer Fee:");
        lblFeeTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblFeeTitle.setBounds(30, 220, 120, 20);
        dialog.add(lblFeeTitle);

        JLabel lblFeeVal = new JLabel("PHP 0.00");
        lblFeeVal.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblFeeVal.setBounds(150, 220, 250, 20);
        dialog.add(lblFeeVal);

        JSeparator sep = new JSeparator();
        sep.setBounds(30, 260, 370, 2);
        dialog.add(sep);

        JLabel lblTotalTitle = new JLabel("TOTAL :");
        lblTotalTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblTotalTitle.setBounds(30, 280, 200, 20);
        dialog.add(lblTotalTitle);

        JLabel lblTotalVal = new JLabel("PHP 1,000,000.00");
        lblTotalVal.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTotalVal.setBounds(190, 278, 200, 30);
        dialog.add(lblTotalVal);

        JButton btnConfirm = new JButton("Confirm");
        btnConfirm.setBackground(Color.decode("#0C3D70"));
        btnConfirm.setForeground(Color.WHITE);
        btnConfirm.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnConfirm.setBounds(50, 330, 150, 40);
  
        //If transfer confirmed
        btnConfirm.addActionListener(e -> {
            dialog.dispose(); 
            JOptionPane.showMessageDialog(parentWindow, "Transferred successfully!", "Transaction Complete", JOptionPane.INFORMATION_MESSAGE);
        }); 

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBackground(Color.LIGHT_GRAY);
        btnCancel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnCancel.setBounds(230, 330, 150, 40);
 
        //If the transfer was cancelled
        btnCancel.addActionListener(e -> {
            dialog.dispose(); 
            JOptionPane.showMessageDialog(parentWindow, "Transaction Cancelled.", "Transaction Cancelled", JOptionPane.ERROR_MESSAGE);
        }); 

        dialog.add(btnConfirm);
        dialog.add(btnCancel);
        dialog.setVisible(true); 
    }
}