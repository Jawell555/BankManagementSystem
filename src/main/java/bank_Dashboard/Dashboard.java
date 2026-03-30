package bank_DashBoard;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.JTableHeader;

public class Dashboard extends JPanel {
    
    private JLabel lblTitle, lblTitleEmp, lblEmpValue, lblTitleCurrAcc, lblCurrAccValue, lblTitleSavAcc, lblSavAccValue, lblTitleBankBalance,
            lblSavBankBalance, lblTitleWithdraw, lblWithdrawValue, lblTitleDeposit,lblDepositValue, lblTitleTrans, lblTransValue, lblInfoBoard;
    private JPanel headerTop, statsPanel, empCard, currAccCard, savAccCard, bankBalanceCard, withdrawCard, depositCard, transCard, tableContainer;
    private JButton btnEmployees, btnAccounts, btnTransactions;
    private JTable employeeTable, accountsTable, transTable, table;
    private JScrollPane scrollPaneEmployee, scrollPaneAccounts, scrollPaneTrans;
    private JTableHeader header;
    public Dashboard() {
        
        setLayout(null);
        setBounds(0, 0, 1670, 1080);
        lblTitle = new JLabel("Dashboard");
        lblTitle.setBounds(50, 60, 700, 50);
        lblTitle.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        add(lblTitle);
        
        headerTop = new JPanel();
        headerTop.setLayout(null);
        headerTop.setBounds(0, 0, 1920, 55);
        headerTop.setBackground(new Color(231, 76, 30));
        add(headerTop);
        
        JLabel headerLabel = new JLabel("BEMBANK SYSTEM");
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        headerLabel.setBounds(20, 15, 300, 30); // Relative to the header
        headerTop.add(headerLabel);
        
        statsPanel = new JPanel();
        statsPanel.setLayout(null);
        statsPanel.setBounds(50, 100, 1630, 250); 
        add(statsPanel);

        // Employee card
        empCard = new JPanel();
        empCard.setLayout(null);
        empCard.setBackground(new Color(52, 152, 219));
        empCard.setBounds(0, 10, 330, 80); 

        lblTitleEmp = new JLabel("EMPLOYEES");
        lblTitleEmp.setForeground(Color.WHITE);
        lblTitleEmp.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblTitleEmp.setBounds(10, 10, 130, 20);
        empCard.add(lblTitleEmp);

        lblEmpValue = new JLabel("10");
        lblEmpValue.setForeground(Color.WHITE);
        lblEmpValue.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblEmpValue.setBounds(10, 40, 130, 25);
        empCard.add(lblEmpValue);

        statsPanel.add(empCard);
        
        // Current Accounts card
        currAccCard = new JPanel();
        currAccCard.setLayout(null);
        currAccCard.setBackground(new Color(52, 152, 219)); 
        currAccCard.setBounds(370, 10, 330, 80); 

        lblTitleCurrAcc = new JLabel("CURRENT ACCOUNTS");
        lblTitleCurrAcc.setForeground(Color.WHITE);
        lblTitleCurrAcc.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblTitleCurrAcc.setBounds(10, 10, 130, 20);
        currAccCard.add(lblTitleCurrAcc);

        lblCurrAccValue = new JLabel("10");
        lblCurrAccValue.setForeground(Color.WHITE);
        lblCurrAccValue.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblCurrAccValue.setBounds(10, 40, 130, 25);
        currAccCard.add(lblCurrAccValue);

        statsPanel.add(currAccCard);
        
        //Saving Accounts card
        savAccCard = new JPanel();
        savAccCard.setLayout(null);
        savAccCard.setBackground(new Color(52, 152, 219)); 
        savAccCard.setBounds(740, 10, 330, 80); 

        lblTitleSavAcc = new JLabel("SAVINGS ACCOUNTS");
        lblTitleSavAcc.setForeground(Color.WHITE);
        lblTitleSavAcc.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblTitleSavAcc.setBounds(10, 10, 130, 20);
        savAccCard.add(lblTitleSavAcc);

        lblSavAccValue = new JLabel("11");
        lblSavAccValue.setForeground(Color.WHITE);
        lblSavAccValue.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblSavAccValue.setBounds(10, 40, 130, 25);
        savAccCard.add(lblSavAccValue);
        
        statsPanel.add(savAccCard);
        
        //Bank Balance card
        bankBalanceCard = new JPanel();
        bankBalanceCard.setLayout(null);
        bankBalanceCard.setBackground(new Color(52, 152, 219)); 
        bankBalanceCard.setBounds(1110, 10, 330, 80); 

        lblTitleBankBalance = new JLabel("BANK BALANCE");
        lblTitleBankBalance.setForeground(Color.WHITE);
        lblTitleBankBalance.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblTitleBankBalance.setBounds(10, 10, 130, 20);
        bankBalanceCard.add(lblTitleBankBalance);

        lblSavBankBalance = new JLabel("PHP 123456789");
        lblSavBankBalance.setForeground(Color.WHITE);
        lblSavBankBalance.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblSavBankBalance.setBounds(10, 40, 170, 25);
        bankBalanceCard.add(lblSavBankBalance);
        
        statsPanel.add(bankBalanceCard);
        
        //Withdrawn Money card
        withdrawCard = new JPanel();
        withdrawCard.setLayout(null);
        withdrawCard.setBackground(new Color(52, 152, 219)); 
        withdrawCard.setBounds(0, 130, 330, 80); 

        lblTitleWithdraw = new JLabel("WITHDRAW TOTAL");
        lblTitleWithdraw.setForeground(Color.WHITE);
        lblTitleWithdraw.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblTitleWithdraw.setBounds(10, 10, 130, 20);
        withdrawCard.add(lblTitleWithdraw);

        lblWithdrawValue = new JLabel("PHP 123456789");
        lblWithdrawValue.setForeground(Color.WHITE);
        lblWithdrawValue.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblWithdrawValue.setBounds(10, 40, 170, 25);
        withdrawCard.add(lblWithdrawValue);

        statsPanel.add(withdrawCard);
        
        //Deposited Money card
        depositCard = new JPanel();
        depositCard.setLayout(null);
        depositCard.setBackground(new Color(52, 152, 219)); 
        depositCard.setBounds(370, 130, 330, 80); 

        lblTitleDeposit = new JLabel("DEPOSIT TOTAL");
        lblTitleDeposit.setForeground(Color.WHITE);
        lblTitleDeposit.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblTitleDeposit.setBounds(10, 10, 130, 20);
        depositCard.add(lblTitleDeposit);

        lblDepositValue = new JLabel("PHP 123456789");
        lblDepositValue.setForeground(Color.WHITE);
        lblDepositValue.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblDepositValue.setBounds(10, 40, 170, 25);
        depositCard.add(lblDepositValue);

        statsPanel.add(depositCard);
        
        //Transacted Money card
        transCard = new JPanel();
        transCard.setLayout(null);
        transCard.setBackground(new Color(52, 152, 219));
        transCard.setBounds(740, 130, 330, 80); 
        
        lblTitleTrans = new JLabel("TRANSACTED TOTAL");
        lblTitleTrans.setForeground(Color.WHITE);
        lblTitleTrans.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblTitleTrans.setBounds(10, 10, 130, 20);
        transCard.add(lblTitleTrans);

        lblTransValue = new JLabel("PHP 123456789");
        lblTransValue.setForeground(Color.WHITE);
        lblTransValue.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTransValue.setBounds(10, 40, 170, 25);
        transCard.add(lblTransValue);
        
        statsPanel.add(transCard);
        
        lblInfoBoard = new JLabel("Info Board");
        lblInfoBoard.setBounds(50, 345, 700, 50);
        lblInfoBoard.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        add(lblInfoBoard);
        
        btnEmployees = new JButton("Employees");
        btnAccounts = new JButton("Accounts");
        btnTransactions = new JButton("Transactions");

        btnEmployees.setBounds(450, 375, 200, 80);
        btnAccounts.setBounds(700, 375, 200, 80);
        btnTransactions.setBounds(950, 375, 200, 80);

        styleButton(btnEmployees);
        styleButton(btnAccounts);
        styleButton(btnTransactions);
        
        add(btnEmployees);
        add(btnAccounts);
        add(btnTransactions);
        
        initTables();

        btnEmployees.addActionListener(e -> showTable("EMP"));
        btnAccounts.addActionListener(e -> showTable("ACC"));
        btnTransactions.addActionListener(e -> showTable("TRANS"));
    }

        private void styleButton(JButton btn) {
            btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
            btn.setForeground(Color.WHITE);
            btn.setBackground(new Color(41, 128, 185)); 
            btn.setFocusPainted(false); 
            btn.setBorderPainted(false); 
        }
        private void initTables() {
            Rectangle tableBounds = new Rectangle(50, 500, 1500, 450);

            // Employee Table
            String[] empCols = {"Employee ID", "Employee Name", "Father Name", "Email", "CNIC", "Date", "Type"};
            Object[][] empData = {{"EMP2013", "Ronaldo", "Crostino", "ron@mail.com", "989821", "2021-06-21", "Employee"}};
            employeeTable = createStyledTable(empData, empCols);
            scrollPaneEmployee = new JScrollPane(employeeTable);
            scrollPaneEmployee.setBounds(tableBounds);
            add(scrollPaneEmployee);

            // Accounts Table
            String[] accCols = {"Account Number", "Name", "Father Name", "Email", "CNIC", "Date", "Type"};
            Object[][] accData = {{"PKR1082523810", "Ali Khan", "Zahoor Ali", "ali@mail.com", "90210921", "2021-06-22", "Saving"}};
            accountsTable = createStyledTable(accData, accCols);
            scrollPaneAccounts = new JScrollPane(accountsTable);
            scrollPaneAccounts.setBounds(tableBounds);
            scrollPaneAccounts.setVisible(false);
            add(scrollPaneAccounts);

            // Transactions Table
            String[] transCols = {"No", "Holder Name", "Account Number", "Type", "Amount", "Date", "Time"};
            Object[][] transData = {{"1", "Asim Ghafoor", "PKR1082523800", "Withdraw", "16000.00PHP", "2026-03-21", "01:12:55"}};
            transTable = createStyledTable(transData, transCols);
            scrollPaneTrans = new JScrollPane(transTable);
            scrollPaneTrans.setBounds(tableBounds);
            scrollPaneTrans.setVisible(false);
            add(scrollPaneTrans);
        }

        private void showTable(String type) {
            scrollPaneEmployee.setVisible(type.equals("EMP"));
            scrollPaneAccounts.setVisible(type.equals("ACC"));
            scrollPaneTrans.setVisible(type.equals("TRANS"));
            repaint();
        }

        private JTable createStyledTable(Object[][] data, String[] cols) {
            table = new JTable(data, cols);
            table.setRowHeight(35);
            table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            table.setGridColor(new Color(230, 230, 230));

            header = table.getTableHeader();
            header.setFont(new Font("Segoe UI", Font.BOLD, 13));
            header.setBackground(Color.WHITE);
            header.setPreferredSize(new Dimension(100, 40));

            return table;
        }

}

