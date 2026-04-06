/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank_ManageEmployees;

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

public class ViewEmployeesBoard extends JPanel {

    private JTable employeeTable;
    private DefaultTableModel model;
    private JTextField txtSearch;
    private TableRowSorter<DefaultTableModel> sorter;

    public ViewEmployeesBoard() {
        setLayout(null);
        setBounds(0, 0, 1670, 1080);
        setBackground(new Color(245, 247, 250));

        JLabel lblTitle = new JLabel("View Employees");
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
            "Employee ID", "Employee Name", "Father Name", "Email", "ID Number", "Date", "Type"
        };

        Object[][] data = {
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

        model = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        employeeTable = new JTable(model);
        employeeTable.setRowHeight(32);
        employeeTable.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        employeeTable.setGridColor(new Color(230, 233, 238));
        employeeTable.setSelectionBackground(ColorPalette.Blue2);
        employeeTable.setSelectionForeground(new Color(33, 37, 41));
        employeeTable.setShowVerticalLines(false);
        employeeTable.setIntercellSpacing(new Dimension(0, 1));

        JTableHeader header = employeeTable.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 13));
        header.setBackground(ColorPalette.Blue4);
        header.setForeground(Color.WHITE);
        header.setResizingAllowed(false);
        header.setReorderingAllowed(false);
        header.setPreferredSize(new Dimension(100, 38));

        sorter = new TableRowSorter<>(model);
        employeeTable.setRowSorter(sorter);

        JScrollPane scrollPane = new JScrollPane(employeeTable);
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
            int row = employeeTable.getSelectedRow();
            if (row != -1) {
                javax.swing.JOptionPane.showMessageDialog(this,
                        "Update logic can be added later.\nSelected Employee: "
                        + employeeTable.getValueAt(row, 1));
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Please select an employee first.");
            }
        });

        btnDelete.addActionListener(e -> {
            int row = employeeTable.getSelectedRow();
            if (row != -1) {
                model.removeRow(employeeTable.convertRowIndexToModel(row));
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Please select an employee first.");
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
