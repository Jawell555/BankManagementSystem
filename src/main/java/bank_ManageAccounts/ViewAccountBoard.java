/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank_ManageAccounts;

import Colors.ColorPalette;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

public class ViewAccountBoard extends JPanel {

    private JTable accountTable;
    private DefaultTableModel model;
    private JTextField txtSearch;
    private TableRowSorter<DefaultTableModel> sorter;

    public ViewAccountBoard() {
        setLayout(null);
        setBounds(0, 0, 1670, 1080);
        setBackground(new Color(245, 247, 250));

        JLabel lblTitle = new JLabel("View Accounts");
        lblTitle.setBounds(50, 30, 400, 40);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
        lblTitle.setForeground(new Color(33, 37, 41));
        add(lblTitle);

        txtSearch = new JTextField();
        txtSearch.setBounds(50, 95, 350, 38);
        txtSearch.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(txtSearch);

        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(420, 95, 120, 38);
        styleButton(btnSearch);
        add(btnSearch);

        JButton btnReset = new JButton("Reset");
        btnReset.setBounds(555, 95, 120, 38);
        styleButton(btnReset);
        add(btnReset);

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(null);
        tablePanel.setBounds(50, 160, 1500, 600);
        tablePanel.setBackground(Color.WHITE);
        tablePanel.setBorder(BorderFactory.createLineBorder(new Color(225, 230, 235), 1));
        add(tablePanel);

        String[] columns = {
            "Account Number", "Name", "Father Name", "Email", "Type of ID", "ID Number", "Date", "Type"
        };

        Object[][] data = {
            {"SPB1000000001", "Juan Dela Cruz", "Pedro Dela Cruz", "juan.delacruz@mail.com", "National ID", "901234567890", "2023-01-15", "Savings"},
            {"SPB1000000002", "Maria Santos", "Jose Santos", "maria.santos@mail.com", "Passport", "P1234567", "2022-11-08", "Current"},
            {"SPB1000000003", "Carlos Reyes", "Antonio Reyes", "carlos.reyes@mail.com", "Driver's License", "D-987654321", "2021-06-21", "Savings"},
            {"SPB1000000004", "Ana Lopez", "Ricardo Lopez", "ana.lopez@mail.com", "National ID", "904567890123", "2023-03-10", "Savings"},
            {"SPB1000000005", "Mark Bautista", "Daniel Bautista", "mark.bautista@mail.com", "Passport", "P7654321", "2020-09-05", "Current"},
            {"SPB1000000006", "Liza Gomez", "Fernando Gomez", "liza.gomez@mail.com", "National ID", "906789012345", "2022-07-19", "Savings"},
            {"SPB1000000007", "Paul Navarro", "Victor Navarro", "paul.navarro@mail.com", "Driver's License", "D-123456789", "2021-12-01", "Current"},
            {"SPB1000000008", "Karla Mendoza", "Ernesto Mendoza", "karla.mendoza@mail.com", "National ID", "908901234567", "2023-05-25", "Savings"}
        };

        model = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        accountTable = new JTable(model);
        accountTable.setRowHeight(32);
        accountTable.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        accountTable.setGridColor(new Color(230, 233, 238));
        accountTable.setSelectionBackground(ColorPalette.Blue2);
        accountTable.setSelectionForeground(new Color(33, 37, 41));
        accountTable.setShowVerticalLines(false);
        accountTable.setIntercellSpacing(new Dimension(0, 1));

        JTableHeader header = accountTable.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 13));
        header.setBackground(ColorPalette.Blue4);
        header.setForeground(Color.WHITE);
        header.setResizingAllowed(false);
        header.setReorderingAllowed(false);
        header.setPreferredSize(new Dimension(100, 38));

        sorter = new TableRowSorter<>(model);
        accountTable.setRowSorter(sorter);

        JScrollPane scrollPane = new JScrollPane(accountTable);
        scrollPane.setBounds(15, 15, 1470, 500);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        tablePanel.add(scrollPane);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(15, 535, 130, 40);
        styleButton(btnUpdate);
        tablePanel.add(btnUpdate);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(160, 535, 130, 40);
        styleButton(btnDelete);
        tablePanel.add(btnDelete);

        btnSearch.addActionListener(e -> applySearch());
        btnReset.addActionListener(e -> resetSearch());

        btnUpdate.addActionListener(e -> {
            int row = accountTable.getSelectedRow();
            if (row != -1) {
                javax.swing.JOptionPane.showMessageDialog(this,
                        "Update logic can be added later.\nSelected Account Holder: "
                        + accountTable.getValueAt(row, 1));
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Please select an account first.");
            }
        });

        btnDelete.addActionListener(e -> {
            int row = accountTable.getSelectedRow();
            if (row != -1) {
                model.removeRow(accountTable.convertRowIndexToModel(row));
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Please select an account first.");
            }
        });
    }

    private void styleButton(JButton btn) {
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setForeground(Color.WHITE);
        btn.setBackground(ColorPalette.Blue5);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void applySearch() {
        String keyword = txtSearch.getText().trim();
        if (keyword.isEmpty()) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + keyword));
        }
    }

    private void resetSearch() {
        txtSearch.setText("");
        sorter.setRowFilter(null);
    }
}
