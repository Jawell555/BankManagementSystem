package bank_AccountOperations;

import Colors.ColorPalette;
import Database.AccountDatabase;
import Database.AccountSQL;
import Database.EmployeeSQL;
import Database.TransactionDatabase;
import Database.TransactionSQL;
import Models.Account;
import bank_Dashboard.adminDashboard;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class WithdrawBoard extends JPanel implements ActionListener {

    private TransactionSQL transactionSql = new TransactionSQL();

    //Main Panel Title
    private JLabel lblTitle;

    //Components declaration of search board
    private JPanel searchBoard;
    private JLabel lblHeaderTitle, lblAccNum;
    private JTextField txtAccNum;
    private JButton btnSearch;

    //Components declaration of information board
    private JPanel infoBoard;
    private JLabel lblAccTitle, lblAccStatus, lblHolderName, lblAccType, lblDisplayAccNum, lblBalance;
    private JTextField txtAccTitle, txtAccStatus, txtHolderName, txtAccType, txtDisplayAccNum, txtBalance;
    private JSeparator infoSep1, infoSep2;

    //Components declaration of action board
    private JPanel actionBoard;
    private JLabel lblRefNum, lblDate, lblIdType, lblWithdrawer, lblMethod, lblAmount, lblFeeTitle, lblFeeVal, lblTotalTitle, lblTotalVal, lblCheck, lblProcBy; // Declared lblProcBy
    private JTextField txtRefNum, txtDate, txtWithdrawer, txtAmount, txtCheck, txtProcBy; // Declared txtProcBy
    private JComboBox<String> cmbIdType, cmbMethod;
    private JSeparator actSep1, actSep2;
    private JButton btnWithdraw;
    private String[] methods = {"Over-the-counter", "Check Withdrawal"};
    private String[] idTypes = {"Driver's License", "National ID / PhilSys", "Passport", "Company ID"};
    double amountToWithdraw = 0;

    public WithdrawBoard() {
        setLayout(null);
        setBackground(new Color(235, 235, 235));
        setBounds(0, 0, 1670, 1080);

        lblTitle = new JLabel("Withdrawal Board");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
        lblTitle.setBounds(60, 30, 700, 40);
        add(lblTitle);

        //SEARCH BOARD
        searchBoard = new JPanel();
        searchBoard.setLayout(null);
        searchBoard.setBackground(ColorPalette.Blue5);
        searchBoard.setBounds(60, 100, 1520, 150);

        lblHeaderTitle = new JLabel("    Search Board");
        lblHeaderTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblHeaderTitle.setForeground(Color.WHITE);
        lblHeaderTitle.setBackground(ColorPalette.Blue4);
        lblHeaderTitle.setOpaque(true);
        lblHeaderTitle.setBounds(0, 0, 1520, 35);
        searchBoard.add(lblHeaderTitle);

        lblAccNum = new JLabel("Account Number");
        lblAccNum.setForeground(Color.WHITE);
        lblAccNum.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblAccNum.setBounds(50, 50, 200, 25);
        searchBoard.add(lblAccNum);

        txtAccNum = new JTextField("SPB100000000");
        txtAccNum.setForeground(Color.BLACK);
        txtAccNum.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtAccNum.setBounds(50, 80, 730, 40);
        searchBoard.add(txtAccNum);

        btnSearch = new JButton("Search Account");
        btnSearch.setBackground(Color.decode("#0C3D70"));
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnSearch.setBounds(800, 80, 190, 40);
        btnSearch.addActionListener(this);
        searchBoard.add(btnSearch);

        add(searchBoard);

        //INFORMATION BOARD
        infoBoard = new JPanel();
        infoBoard.setLayout(null);
        infoBoard.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ColorPalette.Blue4, 3), "Information Board"));
        infoBoard.setBounds(60, 275, 1520, 280);

        lblAccTitle = new JLabel("Account Title");
        lblAccTitle.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblAccTitle.setBounds(50, 40, 200, 25);
        infoBoard.add(lblAccTitle);

        txtAccTitle = new JTextField();
        txtAccTitle.setEditable(false);
        txtAccTitle.setBackground(new Color(225, 225, 225));
        txtAccTitle.setBorder(BorderFactory.createLineBorder(ColorPalette.Blue5, 1));
        txtAccTitle.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtAccTitle.setBounds(50, 70, 400, 40);
        infoBoard.add(txtAccTitle);

        lblAccStatus = new JLabel("Account Status");
        lblAccStatus.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblAccStatus.setBounds(50, 130, 200, 25);
        infoBoard.add(lblAccStatus);

        txtAccStatus = new JTextField();
        txtAccStatus.setEditable(false);
        txtAccStatus.setBackground(new Color(225, 225, 225));
        txtAccStatus.setFont(new Font("Segoe UI", Font.BOLD, 15));
        txtAccStatus.setBorder(BorderFactory.createLineBorder(ColorPalette.Blue5, 1));
        txtAccStatus.setBounds(50, 160, 400, 40);
        infoBoard.add(txtAccStatus);

        infoSep1 = new JSeparator(SwingConstants.VERTICAL);
        infoSep1.setBounds(500, 40, 10, 200);
        infoBoard.add(infoSep1);

        lblHolderName = new JLabel("Account Holder Name");
        lblHolderName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblHolderName.setBounds(550, 40, 250, 25);
        infoBoard.add(lblHolderName);

        txtHolderName = new JTextField();
        txtHolderName.setEditable(false);
        txtHolderName.setBackground(new Color(225, 225, 225));
        txtHolderName.setBorder(BorderFactory.createLineBorder(ColorPalette.Blue5, 1));
        txtHolderName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtHolderName.setBounds(550, 70, 400, 40);
        infoBoard.add(txtHolderName);

        lblAccType = new JLabel("Account Type");
        lblAccType.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblAccType.setBounds(550, 130, 250, 25);
        infoBoard.add(lblAccType);

        txtAccType = new JTextField();
        txtAccType.setEditable(false);
        txtAccType.setBackground(new Color(225, 225, 225));
        txtAccType.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtAccType.setBorder(BorderFactory.createLineBorder(ColorPalette.Blue5, 1));
        txtAccType.setBounds(550, 160, 400, 40);
        infoBoard.add(txtAccType);

        infoSep2 = new JSeparator(SwingConstants.VERTICAL);
        infoSep2.setBounds(1000, 40, 10, 200);
        infoBoard.add(infoSep2);

        lblDisplayAccNum = new JLabel("Account Number");
        lblDisplayAccNum.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblDisplayAccNum.setBounds(1050, 40, 250, 25);
        infoBoard.add(lblDisplayAccNum);

        txtDisplayAccNum = new JTextField();
        txtDisplayAccNum.setEditable(false);
        txtDisplayAccNum.setBackground(new Color(225, 225, 225));
        txtDisplayAccNum.setBorder(BorderFactory.createLineBorder(ColorPalette.Blue5, 1));
        txtDisplayAccNum.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtDisplayAccNum.setBounds(1050, 70, 400, 40);
        infoBoard.add(txtDisplayAccNum);

        lblBalance = new JLabel("Available Balance");
        lblBalance.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblBalance.setBounds(1050, 130, 200, 25);
        infoBoard.add(lblBalance);

        txtBalance = new JTextField("PHP 0.00");
        txtBalance.setEditable(false);
        txtBalance.setBackground(new Color(225, 225, 225));
        txtBalance.setFont(new Font("Segoe UI", Font.BOLD, 16));
        txtBalance.setBorder(BorderFactory.createLineBorder(ColorPalette.Blue5, 1));
        txtBalance.setBounds(1050, 160, 400, 40);
        infoBoard.add(txtBalance);

        add(infoBoard);

        //ACTION BOARD
        actionBoard = new JPanel();
        actionBoard.setLayout(null);
        actionBoard.setBackground(new Color(235, 235, 235));
        actionBoard.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ColorPalette.Blue4, 3), "Action Board"));
        actionBoard.setBounds(60, 580, 1520, 410);
        add(actionBoard);

        lblRefNum = new JLabel("Withdrawal Reference No.");
        lblRefNum.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblRefNum.setBounds(50, 40, 200, 20);
        actionBoard.add(lblRefNum);

        txtRefNum = new JTextField(transactionSql.generateRefNumber());
        txtRefNum.setEditable(false);
        txtRefNum.setBackground(new Color(225, 225, 225));
        txtRefNum.setBorder(BorderFactory.createLineBorder(ColorPalette.Blue5, 1));
        txtRefNum.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtRefNum.setBounds(50, 70, 400, 40);
        actionBoard.add(txtRefNum);

        lblDate = new JLabel("Transaction Date & Time");
        lblDate.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblDate.setBounds(50, 130, 200, 20);
        actionBoard.add(lblDate);

        String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        txtDate = new JTextField(currentDate);
        txtDate.setEditable(false);
        txtDate.setBackground(new Color(225, 225, 225));
        txtDate.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtDate.setBorder(BorderFactory.createLineBorder(ColorPalette.Blue5, 1));
        txtDate.setBounds(50, 160, 400, 40);
        actionBoard.add(txtDate);

        lblIdType = new JLabel("Valid ID Presented");
        lblIdType.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblIdType.setBounds(50, 310, 200, 20);
        actionBoard.add(lblIdType);

        cmbIdType = new JComboBox<>(idTypes);
        cmbIdType.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        cmbIdType.setBounds(50, 340, 400, 40);
        actionBoard.add(cmbIdType);

        lblProcBy = new JLabel("Processed By");
        lblProcBy.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblProcBy.setBounds(50, 220, 200, 20);
        actionBoard.add(lblProcBy);

        String tellerInfo = "No Employee";
        if (EmployeeSQL.currentEmployee != null) {
            tellerInfo = EmployeeSQL.currentEmployee.getEmpID() + " - " + EmployeeSQL.currentEmployee.getEmpName();
        }

        txtProcBy = new JTextField(tellerInfo);
        txtProcBy.setEditable(false);
        txtProcBy.setBackground(new Color(225, 225, 225));
        txtProcBy.setBorder(BorderFactory.createLineBorder(ColorPalette.Blue5, 1));
        txtProcBy.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtProcBy.setBounds(50, 250, 400, 40);
        actionBoard.add(txtProcBy);

        actSep1 = new JSeparator(SwingConstants.VERTICAL);
        actSep1.setBounds(500, 40, 10, 340); // Expanded separator line height to account for the new layout row
        actionBoard.add(actSep1);

        lblWithdrawer = new JLabel("Withdrawer's Full Name");
        lblWithdrawer.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblWithdrawer.setBounds(550, 130, 200, 20);
        actionBoard.add(lblWithdrawer);

        txtWithdrawer = new JTextField();
        txtWithdrawer.setForeground(Color.BLACK);
        txtWithdrawer.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtWithdrawer.setBorder(BorderFactory.createLineBorder(ColorPalette.Blue5, 1));
        txtWithdrawer.setBounds(550, 160, 400, 40);
        actionBoard.add(txtWithdrawer);

        lblCheck = new JLabel("Check Number");
        lblCheck.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblCheck.setBounds(550, 220, 200, 20);
        actionBoard.add(lblCheck);
        lblCheck.setVisible(false);

        txtCheck = new JTextField();
        txtCheck.setForeground(Color.BLACK);
        txtCheck.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtCheck.setBorder(BorderFactory.createLineBorder(ColorPalette.Blue5, 1));
        txtCheck.setBounds(550, 250, 400, 40);
        actionBoard.add(txtCheck);
        txtCheck.setVisible(false);

        lblMethod = new JLabel("Withdrawal Method");
        lblMethod.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblMethod.setBounds(550, 40, 200, 20);
        actionBoard.add(lblMethod);

        cmbMethod = new JComboBox<>(methods);
        cmbMethod.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        cmbMethod.setBounds(550, 70, 400, 40);
        //Listener to update fee automatically when changing withdrawal method
        cmbMethod.addActionListener(e -> {
            int selected = cmbMethod.getSelectedIndex();
            if (selected == 0) {
                txtCheck.setText("");
                txtCheck.setVisible(false);
                lblCheck.setVisible(false);
            } else if (selected == 1) {
                txtCheck.setText("SPBCHK");
                txtCheck.setVisible(true);
                lblCheck.setVisible(true);
            }
            updateCalculations();
        });
        actionBoard.add(cmbMethod);

        actSep2 = new JSeparator(SwingConstants.VERTICAL);
        actSep2.setBounds(1000, 40, 10, 340); 
        actionBoard.add(actSep2);

        lblAmount = new JLabel("Withdrawal Amount");
        lblAmount.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblAmount.setBounds(1050, 40, 250, 20);
        actionBoard.add(lblAmount);

        txtAmount = new JTextField();
        txtAmount.setFont(new Font("Segoe UI", Font.BOLD, 20));
        txtAmount.setBorder(BorderFactory.createLineBorder(ColorPalette.Blue5, 2));
        txtAmount.setBounds(1050, 70, 400, 45);
        //Listener to capture text input in real-time
        txtAmount.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateCalculations();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateCalculations();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateCalculations();
            }
        });
        actionBoard.add(txtAmount);

        lblFeeTitle = new JLabel("Withdrawal Fee:");
        lblFeeTitle.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lblFeeTitle.setBounds(1050, 140, 150, 30);
        actionBoard.add(lblFeeTitle);

        lblFeeVal = new JLabel("PHP 0.00");
        lblFeeVal.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblFeeVal.setForeground(Color.RED);
        lblFeeVal.setBounds(1200, 140, 150, 30);
        actionBoard.add(lblFeeVal);

        lblTotalTitle = new JLabel("Total Deduction:");
        lblTotalTitle.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        lblTotalTitle.setBounds(1050, 180, 200, 30);
        actionBoard.add(lblTotalTitle);

        lblTotalVal = new JLabel("PHP 0.00");
        lblTotalVal.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTotalVal.setBounds(1200, 180, 200, 30);
        actionBoard.add(lblTotalVal);

        btnWithdraw = new JButton("WITHDRAW");
        btnWithdraw.setBackground(Color.decode("#0C3D70"));
        btnWithdraw.setForeground(Color.WHITE);
        btnWithdraw.setFont(new Font("Segoe UI", Font.BOLD, 24));
        btnWithdraw.setBounds(1050, 250, 400, 60); 
        btnWithdraw.addActionListener(this);
        actionBoard.add(btnWithdraw);
    }

    //ACTION LISTENER INTERFACE METHODS
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {
            performSearch();
        } else if (e.getSource() == btnWithdraw) {
            showWithdrawDialog();
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
            fee = (cmbMethod.getSelectedIndex() == 0) ? 0.00 : 15.00;
        }

        double total = amount + fee;

        lblFeeVal.setText(String.format("PHP %,.2f", fee));
        lblTotalVal.setText(String.format("PHP %,.2f", total));
    }

    //Handles account searching
    private void performSearch() {
        String searchedAcc = txtAccNum.getText().trim();

        if (searchedAcc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter an account number.", "Empty Field", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Account foundAcc = AccountSQL.getAccountByNumber(searchedAcc);

        if (foundAcc != null) {
            txtAccTitle.setText(foundAcc.getAccTitle());
            txtHolderName.setText(foundAcc.getName());
            txtAccStatus.setText(foundAcc.getAccStatus());
            txtAccType.setText(foundAcc.getAccType());
            txtDisplayAccNum.setText(foundAcc.getAccNo());
            txtBalance.setText(String.format("PHP %,.2f", foundAcc.getAccBal()));
        } else {
            JOptionPane.showMessageDialog(this, "Account not found in the system.", "Error", JOptionPane.ERROR_MESSAGE);
            txtAccTitle.setText("");
            txtHolderName.setText("");
            txtAccStatus.setText("");
            txtAccType.setText("");
            txtDisplayAccNum.setText("");
            txtBalance.setText("PHP 0.00");
        }
    }

    //Withdraw confirmation logic
    private void showWithdrawDialog() {
        String accName = txtAccTitle.getText();
        String accNum = txtDisplayAccNum.getText();
        String withdrawerName = txtWithdrawer.getText().trim();
        String amountInput = txtAmount.getText().trim();
        String checkNum = txtCheck.getText().trim();

        //Validation: Account searched?
        if (accName.isEmpty() || accNum.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please search for a valid account first.", "Action Required", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Validation: Withdrawer specified?
        if (withdrawerName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please specify the withdrawer's name.", "Incomplete Details", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            amountToWithdraw = Double.parseDouble(amountInput);
            if (amountToWithdraw <= 0) {
                JOptionPane.showMessageDialog(this, "Amount must be greater than zero.", "Invalid Amount", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric amount.", "Invalid Amount", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Setup parent window and dialog
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        JDialog dialog = new JDialog((JFrame) parentWindow, "Withdrawal Confirmation", true);
        dialog.setSize(420, 520);
        dialog.setLayout(null);
        dialog.getContentPane().setBackground(Color.WHITE);
        dialog.setLocationRelativeTo(parentWindow);

        JPanel header = new JPanel();
        header.setBackground(ColorPalette.Blue4);
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

        JLabel lblNameVal = new JLabel(accName);
        lblNameVal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNameVal.setBounds(175, 100, 200, 20);
        dialog.add(lblNameVal);

        JLabel lblAccTitle = new JLabel("Account No:");
        lblAccTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblAccTitle.setBounds(30, 130, 120, 20);
        dialog.add(lblAccTitle);

        JLabel lblAccVal = new JLabel(accNum);
        lblAccVal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblAccVal.setBounds(175, 130, 200, 20);
        dialog.add(lblAccVal);

        JLabel lblMethodTitle = new JLabel("Method:");
        lblMethodTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblMethodTitle.setBounds(30, 160, 120, 20);
        dialog.add(lblMethodTitle);

        JLabel lblMethodVal = new JLabel(cmbMethod.getSelectedItem().toString());
        lblMethodVal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblMethodVal.setBounds(175, 160, 200, 20);
        dialog.add(lblMethodVal);

        JSeparator sep1 = new JSeparator();
        sep1.setBounds(30, 190, 340, 2);
        dialog.add(sep1);

        //Money computations
        Account acc = AccountSQL.getAccountByNumber(accNum);
        double fee = cmbMethod.getSelectedIndex() == 0 ? 0.00 : 15.00; //OTC is free, the rest has a fee
        double totalDeduction = amountToWithdraw + fee;

        if (totalDeduction > acc.getAccBal()) {
            JOptionPane.showMessageDialog(this, "Insufficient balance for this transaction + fees.", "Transaction Failed", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double newBalance = acc.getAccBal() - totalDeduction;

        JLabel lblAmtTitle = new JLabel("Amount:");
        lblAmtTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblAmtTitle.setBounds(30, 205, 120, 20);
        dialog.add(lblAmtTitle);

        JLabel lblAmtVal = new JLabel(String.format("PHP %,.2f", amountToWithdraw));
        lblAmtVal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblAmtVal.setBounds(175, 205, 150, 20);
        dialog.add(lblAmtVal);

        JLabel lblFeeTitleLabel = new JLabel("Withdrawal Fee:");
        lblFeeTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblFeeTitleLabel.setBounds(30, 230, 120, 20);
        dialog.add(lblFeeTitleLabel);

        JLabel lblFeeValueLabel = new JLabel(String.format("PHP %,.2f", fee));
        lblFeeValueLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblFeeValueLabel.setForeground(Color.RED);
        lblFeeValueLabel.setBounds(175, 230, 150, 20);
        dialog.add(lblFeeValueLabel);

        JLabel lblTotalTitleLabel = new JLabel("Total Deduction:");
        lblTotalTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblTotalTitleLabel.setBounds(30, 260, 200, 20);
        dialog.add(lblTotalTitleLabel);

        JLabel lblTotalValueLabel = new JLabel(String.format("PHP %,.2f", totalDeduction));
        lblTotalValueLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTotalValueLabel.setBounds(175, 258, 150, 25);
        dialog.add(lblTotalValueLabel);

        JLabel lblRemTitle = new JLabel("Remaining Balance:");
        lblRemTitle.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblRemTitle.setBounds(30, 290, 150, 20);
        dialog.add(lblRemTitle);

        JLabel lblRemVal = new JLabel(String.format("PHP %,.2f", newBalance));
        lblRemVal.setForeground(new Color(0, 153, 51));
        lblRemVal.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblRemVal.setBounds(175, 290, 150, 20);
        dialog.add(lblRemVal);

        JSeparator sep2 = new JSeparator();
        sep2.setBounds(30, 320, 340, 2);
        dialog.add(sep2);

        //Security check
        JLabel lblAuthTitle = new JLabel("Teller Authorization");
        lblAuthTitle.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblAuthTitle.setForeground(ColorPalette.Blue4);
        lblAuthTitle.setBounds(30, 335, 200, 20);
        dialog.add(lblAuthTitle);

        JLabel lblTellerName = new JLabel("Teller Name:");
        lblTellerName.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblTellerName.setBounds(30, 365, 100, 25);
        dialog.add(lblTellerName);

        String tellerInfo = "No Employee";

        if (EmployeeSQL.currentEmployee != null) {
            tellerInfo = EmployeeSQL.currentEmployee.getEmpID() + " - " + EmployeeSQL.currentEmployee.getEmpName();
        }

        JTextField txtTellerName = new JTextField(tellerInfo);
        txtTellerName.setEditable(false);
        txtTellerName.setBackground(new Color(235, 235, 235));
        txtTellerName.setBounds(110, 365, 260, 25);
        dialog.add(txtTellerName);

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

        btnConfirm.addActionListener(e -> {

            String enteredPin = new String(txtTellerPin.getPassword());
            String empPin = EmployeeSQL.currentEmployee.getPassword();
            if (enteredPin.trim().isEmpty()) {

                JOptionPane.showMessageDialog(dialog, "Please enter your Teller PIN.", "Authorization Error", JOptionPane.WARNING_MESSAGE);
                return;

            } else if (!enteredPin.trim().equals(empPin)) {
                JOptionPane.showMessageDialog(dialog, "Teller PIN is not correct.", "Authorization Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {

                String method = cmbMethod.getSelectedItem().toString();
                if (cmbMethod.getSelectedIndex() == 0) {
                    //Deduct BOTH withdrawal + fee
                    acc.setAccBal(newBalance);
                    AccountSQL.updateBalance(acc.getAccNo(), newBalance);

                    //Refresh balance display
                    txtBalance.setText(String.format("PHP %,.2f", acc.getAccBal()));
                    //Store transaction
                    transactionSql.addTransaction(
                            transactionSql.generateRefNumber(),
                            acc.getName(),
                            acc.getAccNo(),
                            method,
                            withdrawerName,
                            LocalDateTime.now(),
                            "Withdrawal - " + method,
                            EmployeeSQL.currentEmployee.getEmpName(),
                            amountToWithdraw
                    );
                    withdrawalSuccess(dialog, parentWindow);
                } else if (cmbMethod.getSelectedIndex() == 1) {
                    if (transactionSql.isCheckValid(checkNum)) {
                        //Deduct BOTH withdrawal + fee
                        acc.setAccBal(newBalance);
                        AccountSQL.updateBalance(acc.getAccNo(), newBalance);

                        //Refresh balance display
                        txtBalance.setText(String.format("PHP %,.2f", acc.getAccBal()));
                        //Store transaction
                        transactionSql.addTransaction(
                            transactionSql.generateRefNumber(),
                            acc.getName(),
                            acc.getAccNo(),
                            method,
                            checkNum,
                            LocalDateTime.now(),
                            "Withdrawal - " + method,
                            EmployeeSQL.currentEmployee.getEmpName(),
                            amountToWithdraw
                    );
                    withdrawalSuccess(dialog, parentWindow);
                    }else{
                        JOptionPane.showMessageDialog(this,
                                "This check is invalid / has already been used!",
                                "Check Failed",
                                JOptionPane.WARNING_MESSAGE);
                    }

                }

            }

        });

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBackground(Color.LIGHT_GRAY);
        btnCancel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnCancel.setBounds(210, 445, 150, 40);
        btnCancel.addActionListener(e -> {
            dialog.dispose();
            JOptionPane.showMessageDialog(parentWindow, "Transaction Cancelled.", "Transaction Cancelled", JOptionPane.ERROR_MESSAGE);
        });

        dialog.add(btnConfirm);
        dialog.add(btnCancel);
        dialog.setVisible(true);
    }

    public void withdrawalSuccess(JDialog dialog, Window parentWindow) {
        dialog.dispose();

        JOptionPane.showMessageDialog(parentWindow, "Withdrawal successful!", "Transaction Complete", JOptionPane.INFORMATION_MESSAGE);
        txtWithdrawer.setText("");
        txtAmount.setText("");
        txtCheck.setText("SPBCHK");
    }
}
