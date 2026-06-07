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


public class TransactionDatabase {

    
    public static ArrayList<Transaction> TransactionList = new ArrayList<>();

    
    public static void addT(String refNumber, String accName,
            String accNumber, String transacInfo,
            String altAccName, LocalDateTime transacDate,
            String historyType, String processedBy ,double transacAmount) {
        Transaction transact = new Transaction(refNumber, accName, accNumber, transacInfo,
             altAccName, transacDate, historyType, processedBy,transacAmount);
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
