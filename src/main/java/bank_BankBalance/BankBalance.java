/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank_BankBalance;

import Colors.ColorPalette;
import Database.AccountDatabase;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import Database.TransactionDatabase;
import Models.Transaction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ruell
 */
public class BankBalance extends JPanel implements ActionListener {

    TransactionDatabase BankLogic = new TransactionDatabase();
    AccountDatabase db = new AccountDatabase();

    JLabel lblTitle, lblFrom, lblTo;
    JPanel pnlTblContainer, pnlSearch;
    JTextField txtTotalBal, txtSearch, txtStartYear, txtEndYear;
    JTable tblBalHistory;
    JScrollPane scpnBalHistory;
    JComboBox<String> cmbHistoryType, cmbStartMonth, cmbEndMonth, cmbStartDay, cmbEndDay;
    JButton btnFilter;

    private final String[] historyChoices;
    private final String[] months;
    private final String[] days = new String[32];
    private String[] historyColumns = {"Name", "Account Number", "Transaction Information", "Sender/Receiver Name", "Date & Time", "History Type", "Amount"};

    double TotalBal = db.getTotalBalance();
    String formattedTotal = String.format("Php %,.2f", TotalBal);

    Font fntTitle = new Font("Segoe UI", Font.BOLD, 25);
    Font fntText = new Font("Segoe UI", Font.PLAIN, 12);

    public BankBalance() {
        this.months = new String[]{"Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        this.historyChoices = new String[]{"History Type", "Deposit", "Withdrawal", "Transfer", "Received"};
        for (int i = 0; i <= 31; i++) {
            if (i == 0) {
                this.days[i] = "Day";
            } else {
                this.days[i] = "" + i;
            }
        }

        setLayout(null);
        setBounds(0, 0, 1670, 1080);

        //HEAD
        {
            lblTitle = new JLabel("Bank Balance");
            lblTitle.setBounds(50, 40, 700, 50);
            lblTitle.setFont(fntTitle);
            add(lblTitle);

            txtTotalBal = new JTextField(formattedTotal);
            txtTotalBal.setHorizontalAlignment(JTextField.RIGHT);
            txtTotalBal.setEditable(false);
            txtTotalBal.setBackground(ColorPalette.Gray);
            txtTotalBal.setBounds(1120, 40, 500, 40);
            txtTotalBal.setFont(fntTitle);
            add(txtTotalBal);

        }
        //SEARCH
        {
            pnlSearch = new JPanel(null);
            pnlSearch.setBounds(50, 100, 1570, 70);
            pnlSearch.setBorder(ColorPalette.panelBorder("Search / Filter"));
            pnlSearch.setFont(fntText);
            add(pnlSearch);

            txtSearch = new JTextField("Search with Name or Account No.");
            txtSearch.setBounds(20, 25, 575, 30);
            txtSearch.setFont(fntText);
            txtSearch.setBackground(Color.white);
            pnlSearch.add(txtSearch);

            cmbHistoryType = new JComboBox<>(historyChoices);
            cmbHistoryType.setBounds(615, 25, 115, 30);
            cmbHistoryType.setFont(fntText);
            cmbHistoryType.setBackground(Color.white);
            pnlSearch.add(cmbHistoryType);

            lblFrom = new JLabel("From:", SwingConstants.RIGHT);
            lblFrom.setBounds(750, 25, 35, 31);
            lblFrom.setFont(fntText);
            lblFrom.setBackground(Color.white);
            pnlSearch.add(lblFrom);

            cmbStartMonth = new JComboBox<>(months);
            cmbStartMonth.setBounds(790, 25, 90, 30);
            cmbStartMonth.setFont(fntText);
            cmbStartMonth.setBackground(Color.white);
            pnlSearch.add(cmbStartMonth);

            cmbStartDay = new JComboBox<>(days);
            cmbStartDay.setBounds(880, 25, 70, 30);
            cmbStartDay.setFont(fntText);
            cmbStartDay.setBackground(Color.white);
            pnlSearch.add(cmbStartDay);

            txtStartYear = new JTextField("Year");
            txtStartYear.setBounds(950, 25, 70, 31);
            txtStartYear.setFont(fntText);
            txtStartYear.setBackground(Color.white);
            pnlSearch.add(txtStartYear);

            lblTo = new JLabel("To:", SwingConstants.RIGHT);
            lblTo.setBounds(1040, 25, 35, 31);
            lblTo.setFont(fntText);
            lblTo.setBackground(Color.white);
            pnlSearch.add(lblTo);

            cmbEndMonth = new JComboBox<>(months);
            cmbEndMonth.setBounds(1080, 25, 90, 30);
            cmbEndMonth.setFont(fntText);
            cmbEndMonth.setBackground(Color.white);
            pnlSearch.add(cmbEndMonth);

            cmbEndDay = new JComboBox<>(days);
            cmbEndDay.setBounds(1170, 25, 70, 30);
            cmbEndDay.setFont(fntText);
            cmbEndDay.setBackground(Color.white);
            pnlSearch.add(cmbEndDay);

            txtEndYear = new JTextField("Year");
            txtEndYear.setBounds(1240, 25, 70, 31);
            txtEndYear.setFont(fntText);
            txtEndYear.setBackground(Color.white);
            pnlSearch.add(txtEndYear);

            btnFilter = new JButton("Filter");
            btnFilter.setBounds(1390, 25, 120, 30);
            btnFilter.setFont(fntText);
            btnFilter.setForeground(Color.WHITE);
            btnFilter.setBackground(ColorPalette.Blue4);
            pnlSearch.add(btnFilter);
        }
        //TABLE
        {
            pnlTblContainer = new JPanel(null);
            pnlTblContainer.setBounds(50, 180, 1570, 750);
            pnlTblContainer.setBorder(ColorPalette.panelBorder("Balance History"));
            pnlTblContainer.setFont(fntText);
            add(pnlTblContainer);

            tblBalHistory = BankLogic.createStyledTable(BankLogic.TransactionList, historyColumns);
            scpnBalHistory = new JScrollPane(tblBalHistory);
            scpnBalHistory.setBounds(20, 25, 1530, 700);
            pnlTblContainer.add(scpnBalHistory);
        }

        btnFilter.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnFilter) {
            LocalDateTime startDate = convertDate(cmbStartMonth.getSelectedIndex(), cmbStartDay.getSelectedIndex(), txtStartYear.getText());
            LocalDateTime endDate = convertDate(cmbEndMonth.getSelectedIndex(), cmbEndDay.getSelectedIndex(), txtEndYear.getText());
            pnlTblContainer.remove(scpnBalHistory);
            ArrayList<Transaction> filtered = BankLogic.getList(txtSearch.getText(), (String) cmbHistoryType.getSelectedItem(), startDate, endDate);
            tblBalHistory = BankLogic.createStyledTable(filtered, historyColumns);
            scpnBalHistory = new JScrollPane(tblBalHistory);
            scpnBalHistory.setBounds(20, 25, 1530, 700);
            pnlTblContainer.add(scpnBalHistory);
        }
    }

    public LocalDateTime convertDate(int month, int day, String year) {
        try {
            if (year.trim().isEmpty() || year.trim().equals("Year")) {
                return null;
            }
            int intYear = Integer.parseInt(year);
            if (month == 0) {
                return null;
            }
            if (day == 0) {
                return null;
            }
            return LocalDateTime.of(intYear, month, day, 0, 0, 0);
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
