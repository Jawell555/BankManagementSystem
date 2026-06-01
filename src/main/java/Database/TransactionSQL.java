package Database;

import Colors.ColorPalette;
import Models.Transaction;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Ruell
 */
public class TransactionSQL extends TransactionDatabase {

    private static final String url = "jdbc:mysql://localhost:3306/BankManagementSystem";
    private static final String user = "root";
    private static final String pass = "";
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

    public TransactionSQL() {

    }
    
    public boolean addTransaction(
            String refID,
            String accName,
            String accNumber,
            String transacInfo,
            String altAccName,
            LocalDateTime transacDate,
            String historyType,
            double amount
    ) {

        String sql = """
            INSERT INTO transactions (
                refID,
                accName,
                accNumber,
                transacInfo,
                altAccName,
                transacDate,
                historyType,
                transacAmount
            ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)
        """;

        try (
            Connection conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, refID);
            ps.setString(2, accName);
            ps.setString(3, accNumber);
            ps.setString(4, transacInfo);
            ps.setString(5, altAccName);
            ps.setObject(6, transacDate);
            ps.setString(7, historyType);
            ps.setDouble(8, amount);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public DefaultTableModel getListByAccNum(String accSearch) {
        DefaultTableModel model = new DefaultTableModel();
        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            String query = "SELECT * FROM transactions WHERE accNumber = ?";

            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, accSearch.trim());
                ResultSet rs = pstmt.executeQuery();
                model.addColumn("Reference No.");
                model.addColumn("Account Name");
                model.addColumn("Account No.");
                model.addColumn("Transaction Information");
                model.addColumn("Sender/Receiver Name");
                model.addColumn("Date & Time");
                model.addColumn("History Type");
                model.addColumn("Amount");

                while (rs.next()) {
                    Object[] row = {
                        rs.getString("refID"),
                        rs.getString("accName"),
                        rs.getString("accNumber"),
                        rs.getString("transacInfo"),
                        rs.getString("altAccName"),
                        rs.getObject("transacDate", LocalDateTime.class).format(dateTimeFormatter),
                        rs.getString("historyType"),
                        "PHP " + decimalFormat.format(rs.getDouble("transacAmount"))
                    };
                    model.addRow(row);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Connection Failed!");
        }
        return model;
    }

    public DefaultTableModel getFilteredList(String accSearch, String historyType,
            LocalDateTime DateStart, LocalDateTime DateEnd) {
        DefaultTableModel model = new DefaultTableModel();

        try {
            Connection conn = DriverManager.getConnection(url, user, pass);

            model.addColumn("Reference No.");
            model.addColumn("Account Name");
            model.addColumn("Account No.");
            model.addColumn("Transaction Information");
            model.addColumn("Sender/Receiver Name");
            model.addColumn("Date & Time");
            model.addColumn("History Type");
            model.addColumn("Amount");

            StringBuilder query = new StringBuilder("SELECT * FROM transactions WHERE 1=1");
            ArrayList<Object> params = new ArrayList<>();

            boolean search = !accSearchIsNull(accSearch);
            boolean history = !historyTypeIsNull(historyType);
            boolean startDate = !dateStartISNull(DateStart);
            boolean endDate = !dateEndISNull(DateEnd);

            if (search) {
                query.append(" AND (LOWER(accName) LIKE ? OR accNumber = ?)");
                params.add("%" + accSearch.trim().toLowerCase() + "%");
                params.add(accSearch.trim());
            }
            if (history) {
                query.append(" AND historyType LIKE ?");
                params.add(historyType);
            }
            if (startDate) {
                query.append(" AND transacDate >= ?");
                params.add(DateStart);
            }
            if (endDate) {
                query.append(" AND transacDate <= ?");
                params.add(DateEnd);
            }

            try (PreparedStatement pstmt = conn.prepareStatement(query.toString())) {
                for (int i = 0; i < params.size(); i++) {
                    pstmt.setObject(i + 1, params.get(i));
                }

                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    Object[] row = {
                        rs.getString("refID"),
                        rs.getString("accName"),
                        rs.getString("accNumber"),
                        rs.getString("transacInfo"),
                        rs.getString("altAccName"),
                        rs.getObject("transacDate", LocalDateTime.class).format(dateTimeFormatter),
                        rs.getString("historyType"),
                        "PHP " + decimalFormat.format(rs.getDouble("transacAmount"))
                    };
                    model.addRow(row);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Connection Failed!");
        }
        return model;
    }

    public String getLastRefNumber() {
        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            String query = "SELECT refID FROM transactions ORDER BY refID DESC LIMIT 1;";

            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                if (rs.next()) {
                    return rs.getString("refID");
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Connection Failed!");
        }
        return null;
    }

    public String generateRefNumber() {

        String lastID = getLastRefNumber();
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        // default first reference of the day
        if (lastID == null || lastID.isEmpty()) {
            return "REF" + today + "000001";
        }

        try {
            // check if same day as last transaction
            String lastDate = lastID.substring(3, 11); // REF + YYYYMMDD
            String lastSeqStr = lastID.substring(11);   // remaining digits

            int nextSeq;

            if (lastDate.equals(today)) {
                nextSeq = Integer.parseInt(lastSeqStr) + 1;
            } else {
                nextSeq = 1; // reset daily
            }

            return "REF" + today + String.format("%06d", nextSeq);

        } catch (Exception e) {
            return "REF" + today + "000001";
        }
    }

    public JTable createStyledTable(DefaultTableModel model) {

        JTable table = new JTable(model);
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

    public DefaultTableModel getAllTransactionData() {
        DefaultTableModel model = new DefaultTableModel();
        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            String query = "SELECT * FROM transactions;";

            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                model.addColumn("Reference No.");
                model.addColumn("Account Name");
                model.addColumn("Account No.");
                model.addColumn("Transaction Information");
                model.addColumn("Sender/Receiver Name");
                model.addColumn("Date & Time");
                model.addColumn("History Type");
                model.addColumn("Amount");

                while (rs.next()) {
                    Object[] row = {
                        rs.getString("refID"),
                        rs.getString("accName"),
                        rs.getString("accNumber"),
                        rs.getString("transacInfo"),
                        rs.getString("altAccName"),
                        rs.getObject("transacDate", LocalDateTime.class).format(dateTimeFormatter),
                        rs.getString("historyType"),
                        "PHP " + decimalFormat.format(rs.getDouble("transacAmount"))
                    };
                    model.addRow(row);
                }
            }
        } catch (SQLException ex) {

        }
        return model;
    }
    
       public ArrayList<Transaction> getAllTransactions() {

        ArrayList<Transaction> list = new ArrayList<>();

        try (
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM transactions")
        ) {

            while (rs.next()) {

                Transaction t = new Transaction(
                    rs.getString("refID"),
                    rs.getString("accName"),
                    rs.getString("accNumber"),
                    rs.getString("transacInfo"),
                    rs.getString("altAccName"),
                    rs.getObject("transacDate", LocalDateTime.class),
                    rs.getString("historyType"),
                    rs.getDouble("transacAmount")
                );

                list.add(t);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
