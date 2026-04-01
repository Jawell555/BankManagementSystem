package bank_Dashboard;

import Colors.ColorPallete;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.JTableHeader;

public class Dashboard extends JPanel {
    
    private JLabel lblTitle, lblTitleEmp, lblEmpValue, lblTitleCurrAcc, lblCurrAccValue, lblTitleSavAcc, lblSavAccValue, lblTitleBankBalance,
            lblSavBankBalance, lblTitleWithdraw, lblWithdrawValue, lblTitleDeposit, lblDepositValue, lblTitleTrans, lblTransValue, lblInfoBoard;
    private JPanel headerTop, statsPanel, empCard, currAccCard, savAccCard, bankBalanceCard, withdrawCard, depositCard, transCard, tableContainer;
    private JButton btnEmployees, btnAccounts, btnTransactions;
    private JTable employeeTable, accountsTable, transTable, table;
    private JScrollPane scrollPaneEmployee, scrollPaneAccounts, scrollPaneTrans;
    private JTableHeader header;

    public Dashboard() {
        
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

        // Employee card
        empCard = createCardPanel();
        empCard.setBounds(0, 10, 330, 90); 

        lblTitleEmp = createCardTitle("EMPLOYEES");
        lblTitleEmp.setBounds(18, 12, 160, 20);
        empCard.add(lblTitleEmp);

        lblEmpValue = createCardValue("10");
        lblEmpValue.setBounds(18, 38, 130, 30);
        empCard.add(lblEmpValue);

        statsPanel.add(empCard);
        
        // Current Accounts card
        currAccCard = createCardPanel();
        currAccCard.setBounds(370, 10, 330, 90); 

        lblTitleCurrAcc = createCardTitle("CURRENT ACCOUNTS");
        lblTitleCurrAcc.setBounds(18, 12, 180, 20);
        currAccCard.add(lblTitleCurrAcc);

        lblCurrAccValue = createCardValue("10");
        lblCurrAccValue.setBounds(18, 38, 130, 30);
        currAccCard.add(lblCurrAccValue);

        statsPanel.add(currAccCard);
        
        // Saving Accounts card
        savAccCard = createCardPanel();
        savAccCard.setBounds(740, 10, 330, 90); 

        lblTitleSavAcc = createCardTitle("SAVINGS ACCOUNTS");
        lblTitleSavAcc.setBounds(18, 12, 180, 20);
        savAccCard.add(lblTitleSavAcc);

        lblSavAccValue = createCardValue("11");
        lblSavAccValue.setBounds(18, 38, 130, 30);
        savAccCard.add(lblSavAccValue);
        
        statsPanel.add(savAccCard);
        
        // Bank Balance card
        bankBalanceCard = createCardPanel();
        bankBalanceCard.setBounds(1110, 10, 330, 90); 

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
        withdrawCard.setBounds(0, 130, 330, 90); 

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

        btnEmployees.addActionListener(e -> showTable("EMP"));
        btnAccounts.addActionListener(e -> showTable("ACC"));
        btnTransactions.addActionListener(e -> showTable("TRANS"));
    }

    private JPanel createCardPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(ColorPallete.Blue4);
        panel.setBorder(BorderFactory.createLineBorder(new Color(92, 132, 170), 1));
        return panel;
    }

    private JLabel createCardTitle(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(ColorPallete.Blue1);
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
        btn.setBackground(ColorPallete.Blue5);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void initTables() {
        Rectangle tableBounds = new Rectangle(15, 15, 1470, 395);

        // Employee Table
        String[] empCols = {"Employee ID", "Employee Name", "Father Name", "Email", "ID Number", "Date", "Type"};

        Object[][] empData = {
            {"EMP2001", "Juan Dela Cruz", "Pedro Dela Cruz", "juan.delacruz@summitphilbank.com", "901234567890", "2023-01-15", "Employee"},
            {"EMP2002", "Maria Santos", "Jose Santos", "maria.santos@summitphilbank.com", "902345678901", "2022-11-08", "Employee"},
            {"EMP2003", "Carlos Reyes", "Antonio Reyes", "carlos.reyes@summitphilbank.com", "903456789012", "2021-06-21", "Employee"},
            {"EMP2004", "Ana Lopez", "Ricardo Lopez", "ana.lopez@summitphilbank.com", "904567890123", "2023-03-10", "Employee"},
            {"EMP2005", "Mark Bautista", "Daniel Bautista", "mark.bautista@summitphilbank.com", "905678901234", "2020-09-05", "Employee"},
            {"EMP2006", "Liza Gomez", "Fernando Gomez", "liza.gomez@summitphilbank.com", "906789012345", "2022-07-19", "Employee"},
            {"EMP2007", "Paul Navarro", "Victor Navarro", "paul.navarro@summitphilbank.com", "907890123456", "2021-12-01", "Employee"},
            {"EMP2008", "Karla Mendoza", "Ernesto Mendoza", "karla.mendoza@summitphilbank.com", "908901234567", "2023-05-25", "Employee"},
            {"EMP2009", "Ryan Castillo", "Oscar Castillo", "ryan.castillo@summitphilbank.com", "909012345678", "2022-02-14", "Employee"},
            {"EMP2010", "Sophia Ramos", "Luis Ramos", "sophia.ramos@summitphilbank.com", "910123456789", "2023-08-30", "Employee"}
        };
        employeeTable = createStyledTable(empData, empCols);
        scrollPaneEmployee = new JScrollPane(employeeTable);
        scrollPaneEmployee.setBounds(tableBounds);
        scrollPaneEmployee.setBorder(BorderFactory.createEmptyBorder());
        tableContainer.add(scrollPaneEmployee);

        // Accounts Table
        String[] accCols = {"Account Number", "Name", "Father Name", "Email","Type of ID", "ID Number", "Date", "Type"};
        Object[][] accData = {
            {"SPB1000000001", "Juan Dela Cruz", "Pedro Dela Cruz", "juan.delacruz@mail.com", "National ID", "901234567890", "2023-01-15", "Savings"},
            {"SPB1000000002", "Maria Santos", "Jose Santos", "maria.santos@mail.com", "Passport", "P1234567", "2022-11-08", "Current"},
            {"SPB1000000003", "Carlos Reyes", "Antonio Reyes", "carlos.reyes@mail.com", "Driver's License", "D-987654321", "2021-06-21", "Savings"},
            {"SPB1000000004", "Ana Lopez", "Ricardo Lopez", "ana.lopez@mail.com", "National ID", "904567890123", "2023-03-10", "Savings"},
            {"SPB1000000005", "Mark Bautista", "Daniel Bautista", "mark.bautista@mail.com", "Passport", "P7654321", "2020-09-05", "Current"},
            {"SPB1000000006", "Liza Gomez", "Fernando Gomez", "liza.gomez@mail.com", "National ID", "906789012345", "2022-07-19", "Savings"},
            {"SPB1000000007", "Paul Navarro", "Victor Navarro", "paul.navarro@mail.com", "Driver's License", "D-123456789", "2021-12-01", "Current"},
            {"SPB1000000008", "Karla Mendoza", "Ernesto Mendoza", "karla.mendoza@mail.com", "National ID", "908901234567", "2023-05-25", "Savings"}
        };
        accountsTable = createStyledTable(accData, accCols);
        scrollPaneAccounts = new JScrollPane(accountsTable);
        scrollPaneAccounts.setBounds(tableBounds);
        scrollPaneAccounts.setBorder(BorderFactory.createEmptyBorder());
        scrollPaneAccounts.setVisible(false);
        tableContainer.add(scrollPaneAccounts);

        String[] transCols = {"No", "Holder Name", "Account Number", "Type", "Amount", "Date", "Time"};
        Object[][] transData = {
            {"1", "Juan Dela Cruz", "SPB1000000001", "Deposit", "25,000.00 PHP", "2026-03-20", "09:15:22"},
            {"2", "Maria Santos", "SPB1000000002", "Withdraw", "5,000.00 PHP", "2026-03-20", "10:45:10"},
            {"3", "Carlos Reyes", "SPB1000000003", "Deposit", "12,500.00 PHP", "2026-03-21", "11:05:33"},
            {"4", "Ana Lopez", "SPB1000000004", "Withdraw", "3,200.00 PHP", "2026-03-21", "13:20:41"},
            {"5", "Mark Bautista", "SPB1000000005", "Deposit", "50,000.00 PHP", "2026-03-22", "14:55:02"},
            {"6", "Liza Gomez", "SPB1000000006", "Withdraw", "7,800.00 PHP", "2026-03-22", "16:12:18"},
            {"7", "Paul Navarro", "SPB1000000007", "Deposit", "18,000.00 PHP", "2026-03-23", "08:30:27"},
            {"8", "Karla Mendoza", "SPB1000000008", "Withdraw", "2,500.00 PHP", "2026-03-23", "17:45:59"}
        };
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
        table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        table.setGridColor(new Color(230, 233, 238));
        table.setSelectionBackground(ColorPallete.Blue2);
        table.setSelectionForeground(new Color(33, 37, 41));
        table.setShowVerticalLines(false);
        table.setIntercellSpacing(new Dimension(0, 1));

        header = table.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 13));
        header.setBackground(ColorPallete.Blue4);
        header.setForeground(Color.WHITE);
        header.setPreferredSize(new Dimension(100, 38));

        return table;
    }
}
