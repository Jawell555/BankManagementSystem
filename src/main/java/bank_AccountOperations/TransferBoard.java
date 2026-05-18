package bank_AccountOperations;

import Colors.ColorPalette; 
import Database.AccountDatabase;
import Database.TransactionDatabase;
import Models.Account;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class TransferBoard extends JPanel implements ActionListener {
    
    private TransactionDatabase transactionDB = new TransactionDatabase();
    
    //Main Panel Title
    private JLabel lblTitle;

    //Components declaration of search board
    private JPanel searchBoard;
    private JLabel lblHeaderTitle, lblSenderAcc, lblReceiverAcc;
    private JTextField txtSenderAcc, txtReceiverAcc;
    private JButton btnSearch;

    //Components declaration of sender and receiver board
    private JPanel senderPanel, receiverPanel;
    private JLabel lblSenderTitle, lblSenderBalance, lblSenderNum, lblSenderAccStatus, lblSenderBank;
    private JTextField txtSenderTitle, txtSenderBalance, txtSenderNum, txtSenderAccStatus, txtSenderBank;
    private JCheckBox chkSignature;
    
    private JLabel lblReceiverTitle, lblReceiverNum, lblReceiverAccStatus, lblReceiverBank, lblReceiverAccType;
    private JTextField txtReceiverTitle, txtReceiverNum, txtReceiverAccStatus, txtReceiverBank, txtReceiverAccType;

    //Components declaration of action board
    private JPanel actionBoard;
    private JLabel lblRefNum, lblProcBy, lblDate, lblTransType, lblAmount, lblTransFee, lblCostFee, lblTotalTitle, lblTotalValue;
    private JTextField txtRefNum, txtProcBy, txtDate, txtAmount;
    private JComboBox<String> cmbTransType; 
    private JButton btnTransfer;
    private double amountToTransfer = 0;

    public TransferBoard() {
        setLayout(null);
        setBackground(new Color(235, 235, 235));
        setBounds(0, 0, 1670, 1080); 

        lblTitle = new JLabel("Transfer Board");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30)); 
        lblTitle.setBounds(60, 30, 700, 40); 
        add(lblTitle);

        //SEARCH BOARD
        searchBoard = new JPanel();
        searchBoard.setLayout(null); 
        searchBoard.setBackground(ColorPalette.Blue5);
        searchBoard.setBounds(60, 100, 1520, 150); 
        
        lblHeaderTitle = new JLabel("   Search Board"); 
        lblHeaderTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblHeaderTitle.setForeground(Color.WHITE); 
        lblHeaderTitle.setBackground(ColorPalette.Blue4); 
        lblHeaderTitle.setOpaque(true); 
        lblHeaderTitle.setBounds(0, 0, 1520, 35); 
        searchBoard.add(lblHeaderTitle);
        
        lblSenderAcc = new JLabel("Sender Account Number");
        lblSenderAcc.setForeground(Color.WHITE);
        lblSenderAcc.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblSenderAcc.setBounds(50, 50, 200, 25);
        searchBoard.add(lblSenderAcc);

        txtSenderAcc = new JTextField("SPB100000000");
        txtSenderAcc.setForeground(Color.BLACK); 
        txtSenderAcc.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txtSenderAcc.setBounds(50, 80, 500, 40); 
        searchBoard.add(txtSenderAcc);

        lblReceiverAcc = new JLabel("Receiver Account Number");
        lblReceiverAcc.setForeground(Color.WHITE);
        lblReceiverAcc.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblReceiverAcc.setBounds(600, 50, 200, 25);
        searchBoard.add(lblReceiverAcc);

        txtReceiverAcc = new JTextField();
        txtReceiverAcc.setForeground(Color.BLACK); 
        txtReceiverAcc.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txtReceiverAcc.setBounds(600, 80, 500, 40); 
        searchBoard.add(txtReceiverAcc);

        btnSearch = new JButton("Search");
        btnSearch.setBackground(Color.decode("#0C3D70"));
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnSearch.setBounds(1150, 80, 200, 40); 
        btnSearch.addActionListener(this); 
        searchBoard.add(btnSearch);

        add(searchBoard); 

        //SENDER INFORMATION BOARD
        senderPanel = new JPanel();
        senderPanel.setLayout(null);
        senderPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ColorPalette.Blue4, 3), "Sender Information"));
        senderPanel.setBounds(60, 275, 740, 280); 

        lblSenderTitle = new JLabel("Account Title");
        lblSenderTitle.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblSenderTitle.setBounds(30, 30, 200, 25);
        senderPanel.add(lblSenderTitle);

        txtSenderTitle = new JTextField();
        txtSenderTitle.setEditable(false);
        txtSenderTitle.setBackground(new Color(225, 225, 225)); 
        txtSenderTitle.setBorder(BorderFactory.createLineBorder(ColorPalette.Blue5, 1));
        txtSenderTitle.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtSenderTitle.setBounds(30, 60, 320, 40); 
        senderPanel.add(txtSenderTitle);

        lblSenderNum = new JLabel("Account Number");
        lblSenderNum.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblSenderNum.setBounds(390, 30, 250, 25);
        senderPanel.add(lblSenderNum);

        txtSenderNum = new JTextField("");
        txtSenderNum.setEditable(false);
        txtSenderNum.setBackground(new Color(225, 225, 225)); 
        txtSenderNum.setBorder(BorderFactory.createLineBorder(ColorPalette.Blue5, 1));
        txtSenderNum.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtSenderNum.setBounds(390, 60, 320, 40); 
        senderPanel.add(txtSenderNum);

        lblSenderBank = new JLabel("Bank Name");
        lblSenderBank.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblSenderBank.setBounds(30, 110, 200, 25);
        senderPanel.add(lblSenderBank);

        txtSenderBank = new JTextField("Summit PhilBank");
        txtSenderBank.setEditable(false);
        txtSenderBank.setBackground(new Color(225, 225, 225)); 
        txtSenderBank.setBorder(BorderFactory.createLineBorder(ColorPalette.Blue5, 1));
        txtSenderBank.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtSenderBank.setBounds(30, 140, 320, 40); 
        senderPanel.add(txtSenderBank);

        lblSenderAccStatus = new JLabel("Account Status");
        lblSenderAccStatus.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblSenderAccStatus.setBounds(390, 110, 250, 25);
        senderPanel.add(lblSenderAccStatus);

        txtSenderAccStatus = new JTextField();
        txtSenderAccStatus.setEditable(false);
        txtSenderAccStatus.setBackground(new Color(225, 225, 225)); 
        txtSenderAccStatus.setFont(new Font("Segoe UI", Font.BOLD, 15));
        txtSenderAccStatus.setBorder(BorderFactory.createLineBorder(ColorPalette.Blue5, 1));
        txtSenderAccStatus.setBounds(390, 140, 320, 40); 
        senderPanel.add(txtSenderAccStatus);

        lblSenderBalance = new JLabel("Available Balance");
        lblSenderBalance.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblSenderBalance.setBounds(30, 190, 200, 25);
        senderPanel.add(lblSenderBalance);

        txtSenderBalance = new JTextField("PHP 0.00");
        txtSenderBalance.setEditable(false);
        txtSenderBalance.setBackground(new Color(225, 225, 225)); 
        txtSenderBalance.setFont(new Font("Segoe UI", Font.BOLD, 16));
        txtSenderBalance.setBorder(BorderFactory.createLineBorder(ColorPalette.Blue5, 1));
        txtSenderBalance.setBounds(30, 220, 320, 40); 
        senderPanel.add(txtSenderBalance);

        chkSignature = new JCheckBox("Signature Verified");
        chkSignature.setSelected(true);
        chkSignature.setOpaque(false);
        chkSignature.setFont(new Font("Segoe UI", Font.BOLD, 15));
        chkSignature.setForeground(Color.decode("#182b45")); 
        chkSignature.setBounds(390, 225, 200, 25);
        senderPanel.add(chkSignature);

        add(senderPanel);

        //RECEIVER INFORMATION BOARD
        receiverPanel = new JPanel();
        receiverPanel.setLayout(null);
        receiverPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ColorPalette.Blue4, 3), "Receiver Information"));
        receiverPanel.setBounds(840, 275, 740, 280); 

        lblReceiverTitle = new JLabel("Account Title");
        lblReceiverTitle.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblReceiverTitle.setBounds(30, 30, 200, 25);
        receiverPanel.add(lblReceiverTitle);

        txtReceiverTitle = new JTextField();
        txtReceiverTitle.setEditable(false);
        txtReceiverTitle.setBackground(new Color(225, 225, 225)); 
        txtReceiverTitle.setBorder(BorderFactory.createLineBorder(ColorPalette.Blue5, 1));
        txtReceiverTitle.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtReceiverTitle.setBounds(30, 60, 320, 40); 
        receiverPanel.add(txtReceiverTitle);

        lblReceiverNum = new JLabel("Account Number");
        lblReceiverNum.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblReceiverNum.setBounds(390, 30, 250, 25);
        receiverPanel.add(lblReceiverNum);

        txtReceiverNum = new JTextField();
        txtReceiverNum.setEditable(false);
        txtReceiverNum.setBackground(new Color(225, 225, 225)); 
        txtReceiverNum.setBorder(BorderFactory.createLineBorder(ColorPalette.Blue5, 1));
        txtReceiverNum.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtReceiverNum.setBounds(390, 60, 320, 40); 
        receiverPanel.add(txtReceiverNum);

        lblReceiverBank = new JLabel("Bank Name");
        lblReceiverBank.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblReceiverBank.setBounds(30, 110, 200, 25);
        receiverPanel.add(lblReceiverBank);

        txtReceiverBank = new JTextField(); 
        txtReceiverBank.setEditable(false);
        txtReceiverBank.setBackground(new Color(225, 225, 225)); 
        txtReceiverBank.setBorder(BorderFactory.createLineBorder(ColorPalette.Blue5, 1));
        txtReceiverBank.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtReceiverBank.setBounds(30, 140, 320, 40); 
        receiverPanel.add(txtReceiverBank);

        lblReceiverAccStatus = new JLabel("Account Status");
        lblReceiverAccStatus.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblReceiverAccStatus.setBounds(390, 110, 250, 25);
        receiverPanel.add(lblReceiverAccStatus);

        txtReceiverAccStatus = new JTextField();
        txtReceiverAccStatus.setEditable(false);
        txtReceiverAccStatus.setBackground(new Color(225, 225, 225)); 
        txtReceiverAccStatus.setFont(new Font("Segoe UI", Font.BOLD, 15));
        txtReceiverAccStatus.setBorder(BorderFactory.createLineBorder(ColorPalette.Blue5, 1));
        txtReceiverAccStatus.setBounds(390, 140, 320, 40); 
        receiverPanel.add(txtReceiverAccStatus);

        lblReceiverAccType = new JLabel("Account Type");
        lblReceiverAccType.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblReceiverAccType.setBounds(30, 190, 200, 25);
        receiverPanel.add(lblReceiverAccType);

        txtReceiverAccType = new JTextField();
        txtReceiverAccType.setEditable(false);
        txtReceiverAccType.setBackground(new Color(225, 225, 225)); 
        txtReceiverAccType.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtReceiverAccType.setBorder(BorderFactory.createLineBorder(ColorPalette.Blue5, 1));
        txtReceiverAccType.setBounds(30, 220, 320, 40); 
        receiverPanel.add(txtReceiverAccType);

        add(receiverPanel);

        //ACTION BOARD
        actionBoard = new JPanel();
        actionBoard.setLayout(null);      
        actionBoard.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ColorPalette.Blue4, 3), "Action Board"));
        actionBoard.setBounds(60, 580, 1520, 320); 
        add(actionBoard); 

        lblRefNum = new JLabel("Reference Number");
        lblRefNum.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblRefNum.setBounds(50, 40, 200, 25);
        actionBoard.add(lblRefNum);

        txtRefNum = new JTextField("REF987654321"); 
        txtRefNum.setEditable(false); 
        txtRefNum.setBackground(new Color(225, 225, 225)); 
        txtRefNum.setBorder(BorderFactory.createLineBorder(ColorPalette.Blue5, 1));
        txtRefNum.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txtRefNum.setBounds(50, 70, 400, 40); 
        actionBoard.add(txtRefNum);

        lblProcBy = new JLabel("Processed By");
        lblProcBy.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblProcBy.setBounds(50, 130, 200, 25);
        actionBoard.add(lblProcBy);

        txtProcBy = new JTextField("Teller ID: 2006 - Juan Dela Cruz");
        txtProcBy.setEditable(false); 
        txtProcBy.setBackground(new Color(225, 225, 225)); 
        txtProcBy.setBorder(BorderFactory.createLineBorder(ColorPalette.Blue5, 1));
        txtProcBy.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txtProcBy.setBounds(50, 160, 400, 40); 
        actionBoard.add(txtProcBy);

        lblDate = new JLabel("Transaction Date & Time");
        lblDate.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblDate.setBounds(50, 220, 200, 25);
        actionBoard.add(lblDate);

        String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        txtDate = new JTextField(currentDate);
        txtDate.setEditable(false); 
        txtDate.setBackground(new Color(225, 225, 225)); 
        txtDate.setBorder(BorderFactory.createLineBorder(ColorPalette.Blue5, 1));
        txtDate.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txtDate.setBounds(50, 250, 400, 40); 
        actionBoard.add(txtDate);

        lblTransType = new JLabel("Transfer Type");
        lblTransType.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblTransType.setBounds(550, 40, 200, 25);
        actionBoard.add(lblTransType);

        String[] transferTypes = {"Summit PhilBank to Summit PhilBank", "Summit PhilBank to Other Bank"};
        cmbTransType = new JComboBox<>(transferTypes);
        cmbTransType.setSelectedIndex(0); 
        cmbTransType.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        cmbTransType.setBounds(550, 70, 400, 40);
        
        //Listener to update fee when changing transfer type
        cmbTransType.addActionListener(e -> updateCalculations());
        actionBoard.add(cmbTransType);

        lblAmount = new JLabel("Transfer Amount");
        lblAmount.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblAmount.setBounds(550, 130, 250, 25);
        actionBoard.add(lblAmount);

        txtAmount = new JTextField();
        txtAmount.setFont(new Font("Segoe UI", Font.BOLD, 20));
        txtAmount.setBorder(BorderFactory.createLineBorder(ColorPalette.Blue5, 2)); 
        txtAmount.setBounds(550, 160, 400, 45); 
        
        //Listener to capture text input in real-time
        txtAmount.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { updateCalculations(); }
            @Override
            public void removeUpdate(DocumentEvent e) { updateCalculations(); }
            @Override
            public void changedUpdate(DocumentEvent e) { updateCalculations(); }
        });
        actionBoard.add(txtAmount);

        lblTransFee = new JLabel("Transfer Fee:");
        lblTransFee.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        lblTransFee.setBounds(1050, 70, 150, 30);
        actionBoard.add(lblTransFee);

        lblCostFee = new JLabel("PHP 0.00");
        lblCostFee.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblCostFee.setForeground(Color.RED); 
        lblCostFee.setBounds(1250, 70, 200, 30);
        actionBoard.add(lblCostFee);

        lblTotalTitle = new JLabel("Total Deduction:");
        lblTotalTitle.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        lblTotalTitle.setBounds(1050, 130, 200, 30);
        actionBoard.add(lblTotalTitle);

        lblTotalValue = new JLabel("PHP 0.00");
        lblTotalValue.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTotalValue.setBounds(1250, 130, 250, 30);
        actionBoard.add(lblTotalValue);

        btnTransfer = new JButton("TRANSFER");
        btnTransfer.setBackground(ColorPalette.Blue4);
        btnTransfer.setForeground(Color.WHITE);
        btnTransfer.setFont(new Font("Segoe UI", Font.BOLD, 22)); 
        btnTransfer.setBounds(1050, 200, 400, 60);
        btnTransfer.addActionListener(this); 
        actionBoard.add(btnTransfer);
    }

    //ACTION LISTENER INTERFACE METHODS
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {
            performSearch();
        } else if (e.getSource() == btnTransfer) {
            showTransferDialog();
        }
    }

    //LOGIC & FUNCTION METHODS
    //Auto-computes fee and total in real-time
    private void updateCalculations() {
        double amount = 0;
        try {
            String textInput = txtAmount.getText().trim();
            if (!textInput.isEmpty()) {
                amount = Double.parseDouble(textInput);
            }
        } catch (NumberFormatException e) {
            amount = 0; 
        }

        double fee = 0;
        if (amount > 0) {
            fee = (cmbTransType.getSelectedIndex() == 0) ? 0.00 : 15.00; //Same bank (free)
        }

        double total = amount + fee;

        lblCostFee.setText(String.format("PHP %,.2f", fee));
        lblTotalValue.setText(String.format("PHP %,.2f", total));
    }

    //Handles searching for both sender and receiver
    private void performSearch() {
        String senderAccNum = txtSenderAcc.getText().trim();
        String receiverAccNum = txtReceiverAcc.getText().trim();

        if (senderAccNum.isEmpty() || receiverAccNum.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both Sender and Receiver account numbers.", "Empty Fields", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (senderAccNum.equals(receiverAccNum)) {
            JOptionPane.showMessageDialog(this, "Sender and Receiver cannot be the same account.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Account sender = AccountDatabase.getAccountByNumber(senderAccNum);
        Account receiver = AccountDatabase.getAccountByNumber(receiverAccNum);

        boolean hasError = false;

        if (sender != null) {
            txtSenderTitle.setText(sender.getAccTitle());
            txtSenderNum.setText(sender.getAccNo());
            txtSenderBalance.setText(String.format("PHP %,.2f", sender.getAccBal()));
            txtSenderAccStatus.setText(sender.getAccStatus());
        } else {
            txtSenderTitle.setText("");
            txtSenderNum.setText("");
            txtSenderBalance.setText("PHP 0.00");
            txtSenderAccStatus.setText("");
            JOptionPane.showMessageDialog(this, "Sender account not found in the system.", "Error", JOptionPane.ERROR_MESSAGE);
            hasError = true;
        }

        if (receiver != null) {
            txtReceiverTitle.setText(receiver.getAccTitle());
            txtReceiverNum.setText(receiver.getAccNo());
            txtReceiverAccStatus.setText(receiver.getAccStatus());
            txtReceiverAccType.setText(receiver.getAccType());
            txtReceiverBank.setText("Summit PhilBank");
        } else {
            txtReceiverTitle.setText("");
            txtReceiverNum.setText("");
            txtReceiverAccStatus.setText("");
            txtReceiverAccType.setText("");
            txtReceiverBank.setText("");
            if (!hasError) { 
                JOptionPane.showMessageDialog(this, "Receiver account not found in the system.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    //Confirmation of transfer
    private void showTransferDialog() {
        String senderName = txtSenderTitle.getText();
        String senderNum = txtSenderNum.getText();
        String receiverName = txtReceiverTitle.getText();
        String receiverNum = txtReceiverNum.getText();
        String amountInput = txtAmount.getText().trim();

        if (senderName.isEmpty() || receiverName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please search for valid Sender and Receiver accounts first.", "Action Required", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
        try {
            amountToTransfer = Double.parseDouble(amountInput);
            if (amountToTransfer <= 0) {
                JOptionPane.showMessageDialog(this, "Amount must be greater than zero.", "Invalid Amount", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //Check insufficient balance logic including fees
            double fee = (cmbTransType.getSelectedIndex() == 0) ? 0.00 : 15.00;
            double totalDeduction = amountToTransfer + fee;
            
            Account senderAcc = AccountDatabase.getAccountByNumber(senderNum);
            if (senderAcc != null && totalDeduction > senderAcc.getAccBal()) {
                JOptionPane.showMessageDialog(this, "Sender has insufficient balance for this transaction + fees.", "Transaction Failed", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric amount.", "Invalid Amount", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        JDialog dialog = new JDialog((JFrame)parentWindow, "Transfer Confirmation", true);
        dialog.setSize(450, 420); 
        dialog.setLayout(null);
        dialog.getContentPane().setBackground(Color.WHITE);
        dialog.setLocationRelativeTo(parentWindow); 

        JPanel header = new JPanel();
        header.setBackground(ColorPalette.Blue4);
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

        //Confirmation details
        JLabel lblSenderTitle = new JLabel("Sender:");
        lblSenderTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblSenderTitle.setBounds(30, 100, 120, 20);
        dialog.add(lblSenderTitle);

        JLabel lblSenderVal = new JLabel(senderName + " (" + senderNum + ")");
        lblSenderVal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSenderVal.setBounds(150, 100, 280, 20);
        dialog.add(lblSenderVal);

        JLabel lblReceiverTitle = new JLabel("Receiver:");
        lblReceiverTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblReceiverTitle.setBounds(30, 130, 120, 20);
        dialog.add(lblReceiverTitle);

        JLabel lblReceiverVal = new JLabel(receiverName + " (" + receiverNum + ")");
        lblReceiverVal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblReceiverVal.setBounds(150, 130, 280, 20);
        dialog.add(lblReceiverVal);

        JLabel lblTypeTitle = new JLabel("Transfer Type:");
        lblTypeTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblTypeTitle.setBounds(30, 160, 120, 20);
        dialog.add(lblTypeTitle);

        JLabel lblTypeVal = new JLabel(cmbTransType.getSelectedItem().toString());
        lblTypeVal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblTypeVal.setBounds(150, 160, 280, 20);
        dialog.add(lblTypeVal);

        JLabel lblAmtTitle = new JLabel("Amount:");
        lblAmtTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblAmtTitle.setBounds(30, 190, 120, 20);
        dialog.add(lblAmtTitle);

        JLabel lblAmtVal = new JLabel(String.format("PHP %,.2f", amountToTransfer));
        lblAmtVal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblAmtVal.setBounds(150, 190, 250, 20);
        dialog.add(lblAmtVal);

        JLabel lblFeeTitle = new JLabel("Transfer Fee:");
        lblFeeTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblFeeTitle.setBounds(30, 220, 120, 20);
        dialog.add(lblFeeTitle);

        double fee = cmbTransType.getSelectedIndex() == 1 ? 15.00 : 0.00;
        double totalDeduction = amountToTransfer + fee;

        JLabel lblFeeVal = new JLabel(String.format("PHP %,.2f", fee));
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

        JLabel lblTotalVal = new JLabel(String.format("PHP %,.2f", totalDeduction));
        lblTotalVal.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTotalVal.setBounds(190, 278, 200, 30);
        dialog.add(lblTotalVal);

        JButton btnConfirm = new JButton("Confirm");
        btnConfirm.setBackground(Color.decode("#0C3D70")); 
        btnConfirm.setForeground(Color.WHITE);
        btnConfirm.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnConfirm.setBounds(50, 330, 150, 40);
  
        btnConfirm.addActionListener(e -> {

            Account senderAcc = AccountDatabase.getAccountByNumber(senderNum);
            Account receiverAcc = AccountDatabase.getAccountByNumber(receiverNum);

            if (senderAcc != null && receiverAcc != null) {

                // Deduct from sender (amount + fee)
                senderAcc.setAccBal(senderAcc.getAccBal() - totalDeduction);

                // Add ONLY transfer amount to receiver
                receiverAcc.setAccBal(receiverAcc.getAccBal() + amountToTransfer);

                // Refresh displayed balances
                txtSenderBalance.setText(
                    String.format("PHP %,.2f", senderAcc.getAccBal())
                );
                
                // Sender record (DEBIT)
                transactionDB.addTransaction(
                    senderAcc.getName(),
                    senderAcc.getAccNo(),
                    receiverAcc.getAccNo(),
                    receiverAcc.getName(),
                    LocalDateTime.now(),
                    "Transfer Sent",
                    amountToTransfer
                );

                // Receiver record (CREDIT)
                transactionDB.addTransaction(
                    receiverAcc.getName(),
                    receiverAcc.getAccNo(),
                    senderAcc.getAccNo(),
                    senderAcc.getName(),
                    LocalDateTime.now(),
                    "Transfer Received",
                    amountToTransfer
                );

                dialog.dispose();

                JOptionPane.showMessageDialog(
                    parentWindow,
                    "Transferred successfully!",
                    "Transaction Complete",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBackground(Color.LIGHT_GRAY); 
        btnCancel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnCancel.setBounds(230, 330, 150, 40);
 
        btnCancel.addActionListener(e -> {
            dialog.dispose(); 
            JOptionPane.showMessageDialog(parentWindow, "Transaction Cancelled.", "Transaction Cancelled", JOptionPane.ERROR_MESSAGE);
        }); 

        dialog.add(btnConfirm);
        dialog.add(btnCancel);
        dialog.setVisible(true); 
    }
}