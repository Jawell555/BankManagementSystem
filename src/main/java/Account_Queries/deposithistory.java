/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Account_Queries;
import Colors.ColorPalette;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.JTableHeader;
/**
 *
 * @author Ron
 */
public class DepositHistory extends JPanel{
    
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
    
    public DepositHistory() {
        this.months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        this.historyChoices = new String[]{"Deposit", "Withdrawal", "Transfer", "Received"};
        for(int i = 1; i<=31; i++){
            this.days[i-1] = i;
        }
        
        setLayout(null);
        setBounds(0, 0, 1670, 1080);
        
        //HEAD
        {
        lblTitle = new JLabel("Deposit History");
        lblTitle.setBounds(50, 40, 700, 50);
        lblTitle.setFont(fntTitle);
        add(lblTitle);
        
        }
        //SEARCH
        {
        pnlSearch = new JPanel(null);
        pnlSearch.setBounds(50, 100, 1570, 140);
        pnlSearch.setBorder(ColorPalette.panelBorder("Search Board"));
        pnlSearch.setFont(fntText);
        add(pnlSearch);
        
        txtSearch = new JTextField("Enter account number for hisory");
        txtSearch. setBounds(20, 40, 1075 , 30);
        txtSearch.setFont(fntText);
        txtSearch.setBackground(Color.white);
        pnlSearch.add(txtSearch);
        
        btnFilter = new JButton("Search");
        btnFilter.setBounds(1140, 40, 120, 30);
        btnFilter.setFont(fntText);
        btnFilter.setForeground(Color.WHITE);
        btnFilter.setBackground(ColorPalette.Blue4);
        pnlSearch.add(btnFilter);
        
        comboHistoryType = new JComboBox<>(historyChoices);
        comboHistoryType. setBounds(20, 80, 700 , 30);
        comboHistoryType.setFont(fntText);
        comboHistoryType.setBackground(Color.white);
        pnlSearch.add(comboHistoryType);
        
        cmbStartMonth = new JComboBox<>(months);
        cmbStartMonth.setBounds(730, 80, 300, 30);
        cmbStartMonth.setFont(fntText);
        cmbStartMonth.setBackground(Color.white);
        pnlSearch.add(cmbStartMonth);
        
        cmbEndMonth = new JComboBox<>(months);
        cmbEndMonth.setBounds(1040, 80, 300, 30);
        cmbEndMonth.setFont(fntText);
        cmbEndMonth.setBackground(Color.white);
        pnlSearch.add(cmbEndMonth);
                
        btnFilter = new JButton("Filter");
        btnFilter.setBounds(1390, 80, 120, 30);
        btnFilter.setFont(fntText);
        btnFilter.setForeground(Color.WHITE);
        btnFilter.setBackground(ColorPalette.Blue4);
        pnlSearch.add(btnFilter);
        }
        //TABLE
        {
        pnlTblContainer = new JPanel(null);
        pnlTblContainer.setBounds(50, 240, 1570, 830);
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
            table.setDefaultEditor(Object.class,null);

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
