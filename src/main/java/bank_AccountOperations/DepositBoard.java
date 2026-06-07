package bank_AccountOperations;

import Colors.ColorPalette;
import Models.Account;
import Database.AccountDatabase;
import Database.AccountSQL;
import Database.EmployeeSQL;
import Database.TransactionDatabase;
import Database.TransactionSQL;
import bank_Dashboard.adminDashboard;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class DepositBoard extends JPanel implements ActionListener {
    
    private TransactionSQL transactionSql = new TransactionSQL();
    //Main title
    private JLabel lblTitle;

    //Search board components
    private JPanel searchBoard;
    private JLabel lblHeaderTitle, lblAccNum;
    private JTextField txtAccNum;
    private JButton btnSearch;

    //Information board components
    private JPanel infoBoard;
    private JLabel lblAccTitle, lblAccStatus, lblHolderName, lblAccType, lblDisplayAccNum, lblBalance;
    private JTextField txtAccTitle, txtAccStatus, txtHolderName, txtAccType, txtDisplayAccNum, txtBalance;
    private JSeparator infoSep1, infoSep2;

    //Action board components
    private JPanel actionBoard;
    private JLabel lblRefNum, lblDate, lblDepositor, lblDepMethod, lblAmount, lblCheck;
    private JTextField txtRefNum, txtDate, txtDepositor, txtAmount, txtCheck;
    private JSeparator actSep1, actSep2;
    private JComboBox<String> cmbDepMethod;
    private JButton btnDeposit;
    private String[] methods = {"Cash Deposit", "Check Deposit"};
    
    double amountToDeposit = 0;

    public DepositBoard() {
        setLayout(null);
        setBackground(new Color(235, 235, 235));
        setBounds(0, 0, 1670, 1080); 

        lblTitle = new JLabel("Deposit Board");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30)); 
        lblTitle.setBounds(60, 30, 700, 40); 
        add(lblTitle);

        //SEARCH BOARD
        searchBoard = new JPanel();
        searchBoard.setLayout(null); 
        searchBoard.setBackground(ColorPalette.Blue5);
        searchBoard.setBounds(60, 100, 1520, 150); 
        
        lblHeaderTitle = new JLabel("  Search Board"); 
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

        lblBalance = new JLabel("Current Balance");
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
        actionBoard.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ColorPalette.Blue4, 3), "Action Board"));
        actionBoard.setBounds(60, 580, 1520, 320); 
        add(actionBoard); 

        lblRefNum = new JLabel("Deposit Reference No.");
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

        actSep1 = new JSeparator(SwingConstants.VERTICAL);
        actSep1.setBounds(500, 40, 10, 230);
        actionBoard.add(actSep1);

        lblDepositor = new JLabel("Depositor's Full Name");
        lblDepositor.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblDepositor.setBounds(550, 130, 200, 20);
        actionBoard.add(lblDepositor);

        txtDepositor = new JTextField();
        txtDepositor.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtDepositor.setBorder(BorderFactory.createLineBorder(ColorPalette.Blue5, 1));
        txtDepositor.setBounds(550, 160, 400, 40); 
        actionBoard.add(txtDepositor);

        lblDepMethod = new JLabel("Deposit Method");
        lblDepMethod.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblDepMethod.setBounds(550, 40, 200, 20);
        actionBoard.add(lblDepMethod);

        cmbDepMethod = new JComboBox<>(methods);
        cmbDepMethod.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        cmbDepMethod.setBounds(550, 70, 400, 40); 
        actionBoard.add(cmbDepMethod);
        
        lblCheck = new JLabel("Check Number");
        lblCheck.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblCheck.setBounds(550, 220, 400, 20);
        actionBoard.add(lblCheck);
        lblCheck.setVisible(false);
        
        txtCheck = new JTextField();
        txtCheck.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtCheck.setBounds(550, 250, 400, 40);
        actionBoard.add(txtCheck);
        txtCheck.setVisible(false);
        
        cmbDepMethod.addActionListener(e ->{
        int selectedIndex = cmbDepMethod.getSelectedIndex();
        if(selectedIndex==0){
            txtCheck.setText("");
            txtCheck.setVisible(false);
            lblCheck.setVisible(false);
            
        }else if(selectedIndex==1){
            txtCheck.setText("SPBCHK");
            txtCheck.setVisible(true);
            lblCheck.setVisible(true);
        }
    });

        actSep2 = new JSeparator(SwingConstants.VERTICAL);
        actSep2.setBounds(1000, 40, 10, 230);
        actionBoard.add(actSep2);

        lblAmount = new JLabel("Deposit Amount");
        lblAmount.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblAmount.setBounds(1050, 40, 250, 20);
        actionBoard.add(lblAmount);

        txtAmount = new JTextField(""); 
        txtAmount.setFont(new Font("Segoe UI", Font.BOLD, 20)); 
        txtAmount.setBorder(BorderFactory.createLineBorder(ColorPalette.Blue5, 2)); 
        txtAmount.setBounds(1050, 70, 400, 45); 
        actionBoard.add(txtAmount);

        btnDeposit = new JButton("DEPOSIT");
        btnDeposit.setBackground(Color.decode("#0C3D70")); 
        btnDeposit.setForeground(Color.WHITE);
        btnDeposit.setFont(new Font("Segoe UI", Font.BOLD, 22)); 
        btnDeposit.setBounds(1050, 180, 400, 60); 
        btnDeposit.addActionListener(this); 
        actionBoard.add(btnDeposit);
    }

    //ACTION LISTENER INTERFACE METHODS
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {
            performSearch();
        } else if (e.getSource() == btnDeposit) {
            showDepositDialog();
        }
    }

    //LOGIC & FUNCTION METHODS
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

    //Displays the confirmation dialog
    private void showDepositDialog() {
        //Validation checks
        String accName = txtAccTitle.getText();
        String accNum = txtDisplayAccNum.getText();
        String amountInput = txtAmount.getText().trim();

        if (accName.isEmpty() || accNum.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please search for a valid account first.", "Action Required", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            amountToDeposit = Double.parseDouble(amountInput);
            if(amountToDeposit <= 0) {
                JOptionPane.showMessageDialog(this, "Amount must be greater than zero.", "Invalid Amount", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric amount.", "Invalid Amount", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Setup parent window and dialog
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        JDialog dialog = new JDialog((JFrame)parentWindow, "Deposit Confirmation", true);
        dialog.setSize(420, 360);
        dialog.setLayout(null);
        dialog.getContentPane().setBackground(Color.WHITE);
        dialog.setLocationRelativeTo(parentWindow); 

        //Dialog header
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

        JLabel lblNameVal = new JLabel(accName);
        lblNameVal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNameVal.setBounds(150, 100, 200, 20);
        dialog.add(lblNameVal);

        JLabel lblAccTitle = new JLabel("Account No:");
        lblAccTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblAccTitle.setBounds(30, 130, 120, 20);
        dialog.add(lblAccTitle);

        JLabel lblAccVal = new JLabel(accNum);
        lblAccVal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblAccVal.setBounds(150, 130, 200, 20);
        dialog.add(lblAccVal);

        JLabel lblMethodTitle = new JLabel("Method:");
        lblMethodTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblMethodTitle.setBounds(30, 160, 120, 20);
        dialog.add(lblMethodTitle);

        JLabel lblMethodVal = new JLabel(cmbDepMethod.getSelectedItem().toString());
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

        JLabel lblTotalVal = new JLabel(String.format("PHP %,.2f", amountToDeposit)); 
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
        
        //Get the account
        Account foundAcc = AccountSQL.getAccountByNumber(accNum);

        if(foundAcc != null){

            //Update balance
            double newBalance = foundAcc.getAccBal() + amountToDeposit;
            foundAcc.setAccBal(newBalance);
            AccountSQL.updateBalance(foundAcc.getAccNo(), newBalance);

            //Refresh displayed balance
            txtBalance.setText(String.format("PHP %,.2f", newBalance));
            
            String method;
            if(cmbDepMethod.getSelectedIndex() == 0){
                method = cmbDepMethod.getSelectedItem().toString();
                transactionSql.addTransaction(
                transactionSql.generateRefNumber(),
                foundAcc.getName(),
                foundAcc.getAccNo(),
                method,
                txtDepositor.getText(),
                LocalDateTime.now(),
                "Deposit - "+method,
                EmployeeSQL.currentEmployee.getEmpName(),
                amountToDeposit
            );
            } else if (cmbDepMethod.getSelectedIndex() == 1){
                method = cmbDepMethod.getSelectedItem().toString();
                transactionSql.addTransaction(
                transactionSql.generateRefNumber(),
                foundAcc.getName(),
                foundAcc.getAccNo(),
                method,
                txtDepositor.getText()+" - "+txtCheck.getText(),
                LocalDateTime.now(),
                "Deposit - "+method,
                EmployeeSQL.currentEmployee.getEmpName(),
                amountToDeposit
            );
            } 
            
            //Save transaction
            
            dialog.dispose();

            JOptionPane.showMessageDialog(parentWindow, "Deposited successfully!", "Transaction Complete",JOptionPane.INFORMATION_MESSAGE);

            //Clear fields
            txtAmount.setText("");
            txtDepositor.setText("");
            txtCheck.setText("SPBCHK");
            
        }
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