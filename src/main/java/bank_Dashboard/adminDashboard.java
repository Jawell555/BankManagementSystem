package bank_Dashboard;

import Colors.ColorPalette;
import Database.AccountSQL;
import Database.EmployeeSQL;
import Database.TransactionDatabase;
import Database.TransactionSQL;
import Models.Account;
import Models.Employee;
import Models.Transaction;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class adminDashboard extends JPanel {
    
    private JLabel lblTitle, lblTitleAdm, lblAdmValue, lblTitleEmp, lblEmpValue, lblTitleCurrAcc, lblCurrAccValue, lblTitleSavAcc, lblSavAccValue, lblTitleBankBalance,
            lblSavBankBalance, lblTitleWithdraw, lblWithdrawValue, lblTitleDeposit, lblDepositValue, lblTitleTrans, lblTransValue, lblInfoBoard;
    private JPanel headerTop, statsPanel, admCard, empCard, currAccCard, savAccCard, bankBalanceCard, withdrawCard, depositCard, transCard, tableContainer;
    private JButton btnEmployees, btnAccounts, btnTransactions;
    private JTable employeeTable, accountsTable, transTable, table;
    private JScrollPane scrollPaneEmployee, scrollPaneAccounts, scrollPaneTrans;
    private JTableHeader header;

    public adminDashboard() {
        TransactionSQL transactionSQL = new TransactionSQL();
        DefaultTableModel model = transactionSQL.getAllTransactionData();
        
        setLayout(null);
        setBounds(0, 0, 1670, 1080);
        setBackground(new Color(245, 247, 250));
        
        lblTitle = new JLabel("Dashboard");
        lblTitle.setBounds(50, 30, 700, 40);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
        lblTitle.setForeground(new Color(33, 37, 41));
        add(lblTitle);
        
        statsPanel = new JPanel();
        statsPanel.setLayout(null);
        statsPanel.setOpaque(false);
        statsPanel.setBounds(50, 90, 1630, 250); 
        add(statsPanel);
        
         // Bank Balance card
        admCard = createCardPanel();
        admCard.setBounds(0, 10, 330, 90); 

        lblTitleAdm = createCardTitle("ADMINS");
        lblTitleAdm.setBounds(18, 12, 160, 20);
        admCard.add(lblTitleAdm);

        lblAdmValue = createCardValue("6");
        lblAdmValue.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblAdmValue.setBounds(18, 38, 260, 30);
        admCard.add(lblAdmValue);
        
        statsPanel.add(admCard);

        // Employee card
        empCard = createCardPanel();
        empCard.setBounds(370, 10, 330, 90); 

        lblTitleEmp = createCardTitle("EMPLOYEES");
        lblTitleEmp.setBounds(18, 12, 160, 20);
        empCard.add(lblTitleEmp);

        lblEmpValue = createCardValue("10");
        lblEmpValue.setBounds(18, 38, 130, 30);
        empCard.add(lblEmpValue);

        statsPanel.add(empCard);
        
        // Current Accounts card
        currAccCard = createCardPanel();
        currAccCard.setBounds(740, 10, 330, 90); 

        lblTitleCurrAcc = createCardTitle("CURRENT ACCOUNTS");
        lblTitleCurrAcc.setBounds(18, 12, 180, 20);
        currAccCard.add(lblTitleCurrAcc);

        lblCurrAccValue = createCardValue("10");
        lblCurrAccValue.setBounds(18, 38, 130, 30);
        currAccCard.add(lblCurrAccValue);

        statsPanel.add(currAccCard);
        
        // Saving Accounts card
        savAccCard = createCardPanel();
        savAccCard.setBounds(1110, 10, 330, 90); 

        lblTitleSavAcc = createCardTitle("SAVINGS ACCOUNTS");
        lblTitleSavAcc.setBounds(18, 12, 180, 20);
        savAccCard.add(lblTitleSavAcc);

        lblSavAccValue = createCardValue("11");
        lblSavAccValue.setBounds(18, 38, 130, 30);
        savAccCard.add(lblSavAccValue);
        
        statsPanel.add(savAccCard);
            
         // Bank Balance card
        bankBalanceCard = createCardPanel();
        bankBalanceCard.setBounds(0, 130, 330, 90); 

        lblTitleBankBalance = createCardTitle("BANK BALANCE");
        lblTitleBankBalance.setBounds(18, 12, 160, 20);
        bankBalanceCard.add(lblTitleBankBalance);

        lblSavBankBalance = createCardValue("PHP 123,456,789");
        lblSavBankBalance.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblSavBankBalance.setBounds(18, 38, 260, 30);
        bankBalanceCard.add(lblSavBankBalance);
        
        statsPanel.add(bankBalanceCard);
        
        // Withdrawn Money card
        withdrawCard = createCardPanel();
        withdrawCard.setBounds(1110, 130, 330, 90); 

        lblTitleWithdraw = createCardTitle("WITHDRAW TOTAL");
        lblTitleWithdraw.setBounds(18, 12, 160, 20);
        withdrawCard.add(lblTitleWithdraw);

        lblWithdrawValue = createCardValue("PHP 123,456,789");
        lblWithdrawValue.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblWithdrawValue.setBounds(18, 38, 260, 30);
        withdrawCard.add(lblWithdrawValue);

        statsPanel.add(withdrawCard);
        
        // Deposited Money card
        depositCard = createCardPanel();
        depositCard.setBounds(370, 130, 330, 90); 

        lblTitleDeposit = createCardTitle("DEPOSIT TOTAL");
        lblTitleDeposit.setBounds(18, 12, 160, 20);
        depositCard.add(lblTitleDeposit);

        lblDepositValue = createCardValue("PHP 123,456,789");
        lblDepositValue.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblDepositValue.setBounds(18, 38, 260, 30);
        depositCard.add(lblDepositValue);

        statsPanel.add(depositCard);
        
        // Transacted Money card
        transCard = createCardPanel();
        transCard.setBounds(740, 130, 330, 90); 
        
        lblTitleTrans = createCardTitle("TRANSACTED TOTAL");
        lblTitleTrans.setBounds(18, 12, 180, 20);
        transCard.add(lblTitleTrans);

        lblTransValue = createCardValue("PHP 123,456,789");
        lblTransValue.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTransValue.setBounds(18, 38, 260, 30);
        transCard.add(lblTransValue);
        
        statsPanel.add(transCard);
        
        lblInfoBoard = new JLabel("Info Board");
        lblInfoBoard.setBounds(50, 345, 700, 40);
        lblInfoBoard.setFont(new Font("Segoe UI", Font.BOLD, 26));
        lblInfoBoard.setForeground(new Color(33, 37, 41));
        add(lblInfoBoard);
        
        btnEmployees = new JButton("Employees");
        btnAccounts = new JButton("Accounts");
        btnTransactions = new JButton("Transactions");

        btnEmployees.setBounds(450, 340, 180, 45);
        btnAccounts.setBounds(670, 340, 180, 45);
        btnTransactions.setBounds(890, 340, 180, 45);

        styleButton(btnEmployees);
        styleButton(btnAccounts);
        styleButton(btnTransactions);
        
        add(btnEmployees);
        add(btnAccounts);
        add(btnTransactions);

        tableContainer = new JPanel();
        tableContainer.setLayout(null);
        tableContainer.setBounds(50, 410, 1500, 430);
        tableContainer.setBackground(Color.WHITE);
        tableContainer.setBorder(BorderFactory.createLineBorder(new Color(225, 230, 235), 1));
        add(tableContainer);
        
        initTables();
        loadDashboardData();
        btnEmployees.addActionListener(e -> showTable("EMP"));
        btnAccounts.addActionListener(e -> showTable("ACC"));
        btnTransactions.addActionListener(e -> showTable("TRANS"));
    }

    private JPanel createCardPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(ColorPalette.Blue4);
        panel.setBorder(BorderFactory.createLineBorder(new Color(92, 132, 170), 1));
        return panel;
    }

    private JLabel createCardTitle(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(ColorPalette.Blue1);
        label.setFont(new Font("Segoe UI", Font.BOLD, 11));
        return label;
    }

    private JLabel createCardValue(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Segoe UI", Font.BOLD, 24));
        return label;
    }

    private void styleButton(JButton btn) {
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setForeground(Color.WHITE);
        btn.setBackground(ColorPalette.Blue5);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void initTables() {
        Rectangle tableBounds = new Rectangle(15, 15, 1470, 395);

        // Employee Table
        String[] empCols = {"Employee ID", "Employee Name", "Email", "ID Number", "Date", "Type"};

        Object[][] empData = new Object[EmployeeSQL.getAllEmployees().size()][6];
        for (int i = 0; i < EmployeeSQL.getAllEmployees().size(); i++) {

            Employee emp = EmployeeSQL.getAllEmployees().get(i);

            empData[i][0] = emp.getEmpID();
            empData[i][1] = emp.getEmpName();
            empData[i][2] = emp.getEmail();
            empData[i][3] = emp.getIdNumber();
            empData[i][4] = emp.getDate();
            empData[i][5] = emp.getEmpType();

        }
        
        employeeTable = createStyledTable(empData, empCols);
        scrollPaneEmployee = new JScrollPane(employeeTable);
        scrollPaneEmployee.setBounds(tableBounds);
        scrollPaneEmployee.setBorder(BorderFactory.createEmptyBorder());
        tableContainer.add(scrollPaneEmployee);

        // Accounts Table
        String[] accCols = {"Account Number", "Name", "Father Name", "Email","Type of ID", "ID Number", "Date", "Type"};
       Object[][] accData = new Object[AccountSQL.getAllAccounts().size()][8];

        for (int i = 0; i < AccountSQL.getAllAccounts().size(); i++) {

            Account acc = AccountSQL.getAllAccounts().get(i);

            accData[i][0] = acc.getAccNo();
            accData[i][1] = acc.getName();
            accData[i][2] = acc.getFatherName();
            accData[i][3] = acc.getEmail();
            accData[i][4] = acc.getIdType();
            accData[i][5] = acc.getIdNumber();
            accData[i][6] = acc.getDate();
            accData[i][7] = acc.getAccType();
        }
        accountsTable = createStyledTable(accData, accCols);
        scrollPaneAccounts = new JScrollPane(accountsTable);
        scrollPaneAccounts.setBounds(tableBounds);
        scrollPaneAccounts.setBorder(BorderFactory.createEmptyBorder());
        scrollPaneAccounts.setVisible(false);
        tableContainer.add(scrollPaneAccounts);
        
        TransactionSQL transactionSQL = new TransactionSQL();
        ArrayList<Transaction> list = transactionSQL.getAllTransactions();

        String[] transCols = {"Account Name", "Account No", "Type", "Amount", "Date"};

        Object[][] transData = new Object[list.size()][5];

        for (int i = 0; i < list.size(); i++) {
            Transaction t = list.get(i);

            transData[i][0] = t.getAccName();
            transData[i][1] = t.getAccNumber();
            transData[i][2] = t.getHistoryType();
            transData[i][3] = String.format("PHP %,.2f", t.getTransacAmount());
            transData[i][4] = t.getTransacDate();
        }        
        
        transTable = createStyledTable(transData, transCols);
        scrollPaneTrans = new JScrollPane(transTable);
        scrollPaneTrans.setBounds(tableBounds);
        scrollPaneTrans.setBorder(BorderFactory.createEmptyBorder());
        scrollPaneTrans.setVisible(false);
        tableContainer.add(scrollPaneTrans);
    }

    private void showTable(String type) {
        scrollPaneEmployee.setVisible(type.equals("EMP"));
        scrollPaneAccounts.setVisible(type.equals("ACC"));
        scrollPaneTrans.setVisible(type.equals("TRANS"));
        repaint();
    }

    private JTable createStyledTable(Object[][] data, String[] cols) {
        table = new JTable(data, cols);
        table.setRowHeight(32);
        table.setDefaultEditor(Object.class,null);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        table.setGridColor(new Color(230, 233, 238));
        table.setSelectionBackground(ColorPalette.Blue2);
        table.setSelectionForeground(new Color(33, 37, 41));
        table.setShowVerticalLines(false);
        table.setIntercellSpacing(new Dimension(0, 1));

        header = table.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 13));
        header.setBackground(ColorPalette.Blue4);
        header.setForeground(Color.WHITE);
        header.setResizingAllowed(false);
        header.setReorderingAllowed(false);
        header.setPreferredSize(new Dimension(100, 38));

        return table;
    }
    
    private void loadDashboardData() {

        int savings = 0;
        int current = 0;
        int employees = 0;

        double totalBankBalance = 0;

        for (Account acc : AccountSQL.getAllAccounts()) {

            if (acc.getAccType().equalsIgnoreCase("Savings")) {
                savings++;
            }

            if (acc.getAccType().equalsIgnoreCase("Current")) {
                current++;
            }

            totalBankBalance += acc.getAccBal();
        }

        // CARD VALUES
        lblCurrAccValue.setText(String.valueOf(current));
        lblSavAccValue.setText(String.valueOf(savings));

        lblSavBankBalance.setText("PHP " + String.format("%,.2f", totalBankBalance));

        for(Employee emp : EmployeeSQL.getAllEmployees()){
            if(emp.getEmpType().equalsIgnoreCase("Employee")){
                employees++;
            }
        }
        
        lblEmpValue.setText(String.valueOf(employees));

        double totalDeposit = 0;
        double totalWithdraw = 0;
        TransactionSQL transactionSQL = new TransactionSQL();
        for (Transaction t : transactionSQL.getAllTransactions()) {

            if (t.getHistoryType().equalsIgnoreCase("Deposit")
                || t.getHistoryType().toLowerCase().contains("received")) {

                totalDeposit += t.getTransacAmount();
            }

            if (t.getHistoryType().equalsIgnoreCase("Withdrawal")
                || t.getHistoryType().toLowerCase().contains("sent")) {

                totalWithdraw += t.getTransacAmount();
            }
        }

        lblDepositValue.setText("PHP " + String.format("%,.2f", totalDeposit));
        lblWithdrawValue.setText("PHP " + String.format("%,.2f", totalWithdraw));
        lblTransValue.setText("PHP " + String.format("%,.2f", totalDeposit + totalWithdraw));
    }
    
}
