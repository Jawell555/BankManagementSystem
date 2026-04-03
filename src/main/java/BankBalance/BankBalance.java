/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankBalance;

import Colors.ColorPalette;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Ruell
 */
public class BankBalance extends JPanel{
    
    JLabel lblTitle, lblFrom, lblTo;
    JPanel pnlTblContainer, pnlSearch;
    JTextField txtTotalBal, txtSearch, txtStartYear, txtEndYear;
    JTable tblBalHistory;
    JScrollPane scpnBalHistory;
    JComboBox<String> comboHistoryType,cmbStartMonth, cmbEndMonth;
    JComboBox<Integer> cmbStartDay, cmbEndDay;
    JButton btnFilter;
    
    private final String[] historyChoices;
    private final String[] months;
    private final Integer[] days = new Integer[31];
    
    double TotalBal;
    
    Font fntTitle = new Font("Segoe UI", Font.BOLD, 25);
    Font fntText = new Font("Segoe UI", Font.PLAIN, 12);
    Font fntHeader = new Font("Segoe UI", Font.BOLD, 18);
    
    public BankBalance() {
        this.months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        this.historyChoices = new String[]{"Deposit", "Withdrawal", "Transfer", "Received"};
        for(int i = 1; i<=31; i++){
            this.days[i-1] = i;
        }
        
        setLayout(null);
        setBounds(0, 0, 1670, 1080);
        
        //HEAD
        {
        lblTitle = new JLabel("Bank Balance");
        lblTitle.setBounds(50, 40, 700, 50);
        lblTitle.setFont(fntTitle);
        add(lblTitle);
        
        txtTotalBal = new JTextField(""+TotalBal);
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
        txtSearch. setBounds(20, 25, 575 , 30);
        txtSearch.setFont(fntText);
        txtSearch.setBackground(Color.white);
        pnlSearch.add(txtSearch);
        
        comboHistoryType = new JComboBox<>(historyChoices);
        comboHistoryType. setBounds(615, 25, 115 , 30);
        comboHistoryType.setFont(fntText);
        comboHistoryType.setBackground(Color.white);
        pnlSearch.add(comboHistoryType);

        lblFrom = new JLabel("From:", SwingConstants.RIGHT);
        lblFrom. setBounds(750, 25, 35 , 31);
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
        
        txtStartYear = new JTextField("Enter Year");
        txtStartYear.setBounds(950, 25, 70, 31);
        txtStartYear.setFont(fntText);
        txtStartYear.setBackground(Color.white);
        pnlSearch.add(txtStartYear);
        
        lblTo = new JLabel("To:", SwingConstants.RIGHT);
        lblTo. setBounds(1040, 25, 35 , 31);
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
        
        txtEndYear = new JTextField("Enter Year");
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
        pnlTblContainer.setBounds(50, 180, 1570, 830);
        pnlTblContainer.setBorder(ColorPalette.panelBorder("Balance History"));
        pnlTblContainer.setFont(fntText);
        add(pnlTblContainer);
        
        String[] historyColumns = {"Name", "Account Number", "Sender/Receiver Account", "Sender/Receiver Name", "Date & Time", "History Type", "Amount"};
        Object[][] historyData = {{"Asim Ghafoor", "PHP1082523800", "PHP1082523819", "Sobhan", "6-21-2026 05:47:58", "Received", "2000.00"},
                                  {"Jawell", "PHP1082523700", "PHP1082523701", "Ryza", "4-01-2026 05:47:58", "Transfer", "1000000.00"} };
        tblBalHistory = createStyledTable(historyData, historyColumns);
        scpnBalHistory = new JScrollPane(tblBalHistory);
        scpnBalHistory.setBounds(20, 25, 1530, 780);
        pnlTblContainer.add(scpnBalHistory);
        }
    
    }
    private JTable createStyledTable(Object[][] data, String[] cols) {
            JTable table = new JTable(data, cols);
            table.setRowHeight(35);
            table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            table.setGridColor(new Color(230, 230, 230));
            

            JTableHeader header = table.getTableHeader();
            header.setFont(new Font("Segoe UI", Font.BOLD, 13));
            header.setBackground(ColorPalette.Blue4);
            header.setForeground(Color.WHITE);
            header.setResizingAllowed(false);
            header.setReorderingAllowed(false);
            header.setPreferredSize(new Dimension(100, 40));

            return table;
        }
    
        
}
