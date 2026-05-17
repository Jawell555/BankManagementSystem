/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankQueryLogic;

import Colors.ColorPalette;
import java.time.LocalDate;
import java.time.LocalDateTime;
import Models.Transaction;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Ruell
 */
public class BankQueries {

    public List<Transaction> TransactionList = new ArrayList<>();

    public BankQueries() {
        Transaction dummyTransac1 = new Transaction("Jawell", "PHP1082523700", "PHP1082523701", "Ryza",
                LocalDateTime.of(2026, 1, 4, 5, 47, 58), "Deposit", 1000000.00);
        Transaction dummyTransac2 = new Transaction("Ryza", "PHP1082523701", "PHP1082523700", "Jawell",
                LocalDateTime.of(2026, 1, 4, 5, 47, 58), "Received", 1000000.00);

        TransactionList.add(dummyTransac2);
        TransactionList.add(dummyTransac1);
    }

    public void add(Transaction transaction) {
        TransactionList.add(transaction);
    }

    public List<Transaction> getAllTransList() {
        return TransactionList;
    }

    public JTable createStyledTable(List<Transaction> trans, String[] cols) {
        Object[][] data = new Object[trans.size()][7];

        for (int i = 0; i < trans.size(); i++) {
            Transaction t = trans.get(i);
            data[i][0] = t.getAccName();
            data[i][1] = t.getAccNumber();
            data[i][2] = t.getAltAccNumber();
            data[i][3] = t.getAltAccName();
            data[i][4] = t.getTransacDate();
            data[i][5] = t.getHistoryType();
            data[i][6] = String.format("%.2f", t.getTransacAmount());
        }

        JTable table = new JTable(data, cols);
        table.setRowHeight(35);
        table.setDefaultEditor(Object.class, null);
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
    
    public List<Transaction> getListByNumber(String accSearch){
        List<Transaction> QueryList = new ArrayList<>();
        boolean search = !accSearchIsNull(accSearch);
        for (Transaction Trans : TransactionList) {
            boolean matches = true;
            matches&=Trans.getAccNumber().equals(accSearch.trim());
            if(matches)QueryList.add(Trans);
        }
        return QueryList;
    }

    public List<Transaction> getList(String accSearch, String historyType, LocalDateTime DateStart, LocalDateTime DateEnd) {
        List<Transaction> QueryList = new ArrayList<>();
        boolean search = !accSearchIsNull(accSearch);
        boolean history = !historyTypeIsNull(historyType);
        boolean startDate = !dateStartISNull(DateStart);
        boolean endDate = !dateEndISNull(DateEnd);
        for (Transaction Trans : TransactionList) {
            boolean matches = true;
            if(search){
                matches&=Trans.getAccName().toLowerCase().contains(accSearch.trim().toLowerCase())||Trans.getAccNumber().equals(accSearch.trim());
            }
            if(history) {
                matches&=Trans.getHistoryType().equals(historyType);
            }
            if(startDate){
                matches&=Trans.getTransacDate().isAfter(DateStart);
            }
            if(endDate){
                matches&=Trans.getTransacDate().isBefore(DateEnd);
            }
            if(matches)QueryList.add(Trans);
        }
        return QueryList;
    }
    public List<Transaction> noData(){
        List<Transaction> NoData = new ArrayList<>();
        return NoData;
    }

    public boolean accSearchIsNull(String accSearch) {
        return accSearch.trim().equalsIgnoreCase("Search with Name or Account No.") || accSearch.trim().isEmpty();
    }

    public boolean historyTypeIsNull(String historyType) {
        return historyType.equals("History Type");
    }

    public boolean dateStartISNull(LocalDateTime dateStart) {
        return dateStart == null;
    }

    public boolean dateEndISNull(LocalDateTime dateEnd) {
        return dateEnd == null;
    }

}
