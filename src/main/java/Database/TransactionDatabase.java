/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Colors.ColorPalette;
import java.time.LocalDateTime;
import Models.Transaction;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import java.time.format.DateTimeFormatter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Ruell
 */
public class TransactionDatabase {

    
    public static ArrayList<Transaction> TransactionList = new ArrayList<>();

    public TransactionDatabase() {
//        addTransaction("Juan Dela Cruz", "SPB1000000001", "SPB1000000002", "Maria Santos",
//                LocalDateTime.of(2023, 1, 19, 5, 47, 58), "Deposit", 0.00);
//        addTransaction("Maria Santos", "SPB1000000002", "SPB1000000001", "Juan Dela Cruz",
//                LocalDateTime.of(2023, 1, 19, 5, 47, 58), "Received", 0.00);
    }

    static {
        addTransaction(
                "REF0000000001",
                "Juan Dela Cruz",
                "SPB1000000001",
                "Initial Deposit",
                "BANK SYSTEM",
                LocalDateTime.of(2023, 1, 15, 10, 0, 1),
                "Deposit",
                25000.00
        );

        addTransaction(
                "REF0000000002",
                "Maria Santos",
                "SPB1000000002",
                "Initial Deposit",
                "BANK SYSTEM",
                LocalDateTime.of(2022, 11, 8, 9, 30, 2),
                "Deposit",
                150000.00
        );

        addTransaction(
                "REF0000000003",
                "Carlos Reyes",
                "SPB1000000003",
                "Initial Deposit",
                "BANK SYSTEM",
                LocalDateTime.of(2021, 6, 21, 14, 15, 3),
                "Deposit",
                8900.50
        );

        addTransaction(
                "REF0000000004",
                "Ana Lopez",
                "SPB1000000004",
                "Initial Deposit",
                "BANK SYSTEM",
                LocalDateTime.of(2023, 3, 10, 11, 45, 4),
                "Deposit",
                45600.00
        );

        addTransaction(
                "REF0000000005",
                "Mark Bautista",
                "SPB1000000005",
                "Initial Deposit",
                "BANK SYSTEM",
                LocalDateTime.of(2020, 9, 5, 16, 20, 5),
                "Deposit",
                98000.00
        );

        addTransaction(
                "REF0000000006",
                "Liza Gomez",
                "SPB1000000006",
                "Initial Deposit",
                "BANK SYSTEM",
                LocalDateTime.of(2022, 7, 19, 10, 10, 7),
                "Deposit",
                12340.75
        );

        addTransaction(
                "REF0000000007",
                "Paul Navarro",
                "SPB1000000007",
                "Initial Deposit",
                "BANK SYSTEM",
                LocalDateTime.of(2021, 12, 1, 13, 0, 8),
                "Deposit",
                78500.00
        );

        addTransaction(
                "REF0000000008",
                "Karla Mendoza",
                "SPB1000000008",
                "Initial Deposit",
                "BANK SYSTEM",
                LocalDateTime.of(2023, 5, 25, 9, 0, 9),
                "Deposit",
                33210.90
        );
    }

    public static void addTransaction(String refNumber, String accName,
            String accNumber, String transacInfo,
            String altAccName, LocalDateTime transacDate,
            String historyType, double transacAmount) {
        Transaction transact = new Transaction(refNumber, accName, accNumber, transacInfo,
             altAccName, transacDate, historyType, transacAmount);
        TransactionList.add(transact);
    }

    public ArrayList<Transaction> getAllTransList() {
        return TransactionList;
    }

    public JTable createStyledTable(ArrayList<Transaction> trans, String[] cols) {
        Object[][] data = new Object[trans.size()][7];
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        for (int i = 0; i < trans.size(); i++) {
            Transaction t = trans.get(i);
            data[i][0] = t.getAccName();
            data[i][1] = t.getAccNumber();
            data[i][2] = t.getTransacInfo();
            data[i][3] = t.getAltAccName();
            data[i][4] = t.getTransacDate().format(dateTimeFormatter);
            data[i][5] = t.getHistoryType();
            data[i][6] = String.format("PHP %,.2f", t.getTransacAmount());
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

    public ArrayList<Transaction> getListByNumber(String accSearch) {
        ArrayList<Transaction> QueryList = new ArrayList<>();
        for (Transaction Trans : TransactionList) {
            boolean matches = Trans.getAccNumber().equals(accSearch.trim());
            if (matches) {
                QueryList.add(Trans);
            }
        }
        return QueryList;
    }

    public ArrayList<Transaction> getList(String accSearch, String historyType, LocalDateTime DateStart, LocalDateTime DateEnd) {
        ArrayList<Transaction> QueryList = new ArrayList<>();
        boolean search = !accSearchIsNull(accSearch);
        boolean history = !historyTypeIsNull(historyType);
        boolean startDate = !dateStartISNull(DateStart);
        boolean endDate = !dateEndISNull(DateEnd);
        for (Transaction Trans : TransactionList) {
            boolean matches = true;
            if (search) {
                matches &= Trans.getAccName().toLowerCase().contains(accSearch.trim().toLowerCase()) || Trans.getAccNumber().equals(accSearch.trim());
            }
            if (history) {
                matches &= Trans.getHistoryType().equals(historyType);
            }
            if (startDate) {
                matches &= Trans.getTransacDate().isAfter(DateStart);
            }
            if (endDate) {
                matches &= Trans.getTransacDate().isBefore(DateEnd);
            }
            if (matches) {
                QueryList.add(Trans);
            }
        }
        return QueryList;
    }

    public ArrayList<Transaction> noData() {
        ArrayList<Transaction> NoData = new ArrayList<>();
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
