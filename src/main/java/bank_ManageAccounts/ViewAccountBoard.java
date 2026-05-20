/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank_ManageAccounts;

import Colors.ColorPalette;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

public class ViewAccountBoard extends JPanel {

    JLabel lblTitle, lblFrom, lblTo;
    JPanel pnlTblContainer, pnlSearch;
    JTextField txtSearch, txtStartYear, txtEndYear;
    JTable tblAccounts;
    JScrollPane scpnAccounts;
    JComboBox<String> cmbAccountType, cmbStartMonth, cmbEndMonth;
    JComboBox<Integer> cmbStartDay, cmbEndDay;
    JButton btnFilter, btnReset;
    JTableHeader header;
    DefaultTableModel model;
    TableRowSorter<DefaultTableModel> sorter;

    private final String[] accTypes;
    private final String[] months;
    private final Integer[] days = new Integer[31];

    Font fntTitle = new Font("Segoe UI", Font.BOLD, 25);
    Font fntText = new Font("Segoe UI", Font.PLAIN, 12);

    public ViewAccountBoard() {
        this.months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        this.accTypes = new String[]{"Savings", "Current", "All"};
        for(int i = 1; i<=31; i++){
            this.days[i-1] = i;
        }

        setLayout(null);
        setBounds(0, 0, 1670, 1080);

        // Title
        lblTitle = new JLabel("Accounts List");
        lblTitle.setBounds(50, 40, 700, 50);
        lblTitle.setFont(fntTitle);
        add(lblTitle);

        // Filter/search section
        pnlSearch = new JPanel(null);
        pnlSearch.setBounds(50, 100, 1570, 70);
        pnlSearch.setBorder(ColorPalette.panelBorder("Search Board"));
        add(pnlSearch);
        
        // Search bar
        txtSearch = new JTextField("Search account");
        txtSearch.setBounds(20, 25, 470, 30);
        txtSearch.setFont(fntText);
        txtSearch.setBackground(Color.white);
        pnlSearch.add(txtSearch);

        // Account Types
        cmbAccountType = new JComboBox<>(accTypes);
        cmbAccountType.setBounds(510, 25, 120, 30);
        cmbAccountType.setFont(fntText);
        cmbAccountType.setBackground(Color.white);
        pnlSearch.add(cmbAccountType);

        lblFrom = new JLabel("From:");
        lblFrom.setBounds(650, 25, 40, 30);
        lblFrom.setFont(fntText);
        pnlSearch.add(lblFrom);

        cmbStartMonth = new JComboBox<>(months);
        cmbStartMonth.setBounds(695, 25, 95, 30);
        cmbStartMonth.setFont(fntText);
        cmbStartMonth.setBackground(Color.white);
        pnlSearch.add(cmbStartMonth);

        cmbStartDay = new JComboBox<>(days);
        cmbStartDay.setBounds(790, 25, 60, 30);
        cmbStartDay.setFont(fntText);
        cmbStartDay.setBackground(Color.white);
        pnlSearch.add(cmbStartDay);

        txtStartYear = new JTextField("Year");
        txtStartYear.setBounds(850, 25, 70, 30);
        txtStartYear.setFont(fntText);
        txtStartYear.setBackground(Color.white);
        pnlSearch.add(txtStartYear);

        lblTo = new JLabel("To:");
        lblTo.setBounds(950, 25, 25, 30);
        lblTo.setFont(fntText);
        pnlSearch.add(lblTo);

        cmbEndMonth = new JComboBox<>(months);
        cmbEndMonth.setBounds(980, 25, 95, 30);
        cmbEndMonth.setFont(fntText);
        cmbEndMonth.setBackground(Color.white);
        pnlSearch.add(cmbEndMonth);

        cmbEndDay = new JComboBox<>(days);
        cmbEndDay.setBounds(1075, 25, 60, 30);
        cmbEndDay.setFont(fntText);
        cmbEndDay.setBackground(Color.white);
        pnlSearch.add(cmbEndDay);

        txtEndYear = new JTextField("Year");
        txtEndYear.setBounds(1135, 25, 70, 30);
        txtEndYear.setFont(fntText);
        txtEndYear.setBackground(Color.white);
        pnlSearch.add(txtEndYear);

        btnFilter = new JButton("Search");
        btnFilter.setBounds(1260, 25, 100, 30);
        styleButton(btnFilter);
        pnlSearch.add(btnFilter);

        btnReset = new JButton("Reset");
        btnReset.setBounds(1390, 25, 100, 30);
        styleButton(btnReset);
        pnlSearch.add(btnReset);

        // Account Table
        pnlTblContainer = new JPanel(null);
        pnlTblContainer.setBounds(50, 180, 1570, 820);
        pnlTblContainer.setBorder(ColorPalette.panelBorder("Accounts Table"));
        add(pnlTblContainer);

        // Image (will be replaced by user image)
        ImageIcon icon = new ImageIcon(getClass().getResource("/profile.png"));
        Image img = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon tableIcon = new ImageIcon(img);

        // Account data
        String[] columns = {"Image", "Name", "ID Number", "Account Title", "Account Number", "Account Type", "Date", "Operation"};
        
        Object[][] data = {{tableIcon, "Juan Dela Cruz", "2147483647","Juan", "SPB10000001", "Savings", "2026-01-15", "Action"}, 
                          {tableIcon, "Maria Santos", "93209109", "Maria", "SPB10000002", "Current", "2026-03-20", "Action"},
                          {tableIcon, "Carlos Reyes", "2147483000", "Carlos", "SPB10000003", "Savings", "2026-04-01", "Action"}
        };
        
        model = new DefaultTableModel(data, columns) {
            
        @Override
            public Class<?> getColumnClass(int column) {
                if (column == 0) {
                    return Icon.class;
                }
                return String.class;
            }

        @Override
            public boolean isCellEditable(int row, int column) {
                return column == 7;
            }
        };

        tblAccounts = new JTable(model);
        tblAccounts.setRowHeight(50);
        tblAccounts.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tblAccounts.setGridColor(new Color(230, 230, 230));
        
        header = tblAccounts.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 15));
        header.setBackground(ColorPalette.Blue4);
        header.setForeground(Color.WHITE);
        header.setResizingAllowed(false);
        header.setReorderingAllowed(false);
        header.setPreferredSize(new Dimension(100, 40));
        
        tblAccounts.getColumnModel().getColumn(0).setPreferredWidth(55);
        tblAccounts.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblAccounts.getColumnModel().getColumn(2).setPreferredWidth(130);
        tblAccounts.getColumnModel().getColumn(3).setPreferredWidth(150);
        tblAccounts.getColumnModel().getColumn(4).setPreferredWidth(170);
        tblAccounts.getColumnModel().getColumn(5).setPreferredWidth(120);
        tblAccounts.getColumnModel().getColumn(6).setPreferredWidth(70);
        tblAccounts.getColumnModel().getColumn(7).setPreferredWidth(200);

        tblAccounts.getColumnModel().getColumn(7).setCellRenderer(new ButtonRenderer());
        tblAccounts.getColumnModel().getColumn(7).setCellEditor(new ButtonEditor(new JCheckBox()));

        scpnAccounts = new JScrollPane(tblAccounts);
        scpnAccounts.setBounds(20, 25, 1530, 780);
        scpnAccounts.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        pnlTblContainer.add(scpnAccounts);

        sorter = new TableRowSorter<>(model);
        tblAccounts.setRowSorter(sorter);

        btnFilter.addActionListener(e -> filterTable());
        btnReset.addActionListener(e -> resetFields());
    }

    private void styleButton(JButton btn) {
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setForeground(Color.WHITE);
        btn.setBackground(ColorPalette.Blue4);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void styleTableButton(JButton btn) {
        btn.setPreferredSize(new Dimension(75, 30));
        btn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btn.setForeground(Color.WHITE);
        btn.setBackground(ColorPalette.Blue4);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void filterTable() {
        String search = txtSearch.getText();
        String type = cmbAccountType.getSelectedItem().toString();

        if (search.trim().length() == 0 && type.equals("All")) {
            sorter.setRowFilter(null);
        } else if (type.equals("All")) {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + search));
        } else {
            sorter.setRowFilter(RowFilter.regexFilter(type, 5));
        }
    }

    private void resetFields() {
        txtSearch.setText("Search account");
        cmbAccountType.setSelectedIndex(2);
        cmbStartMonth.setSelectedIndex(0);
        cmbStartDay.setSelectedIndex(0);
        txtStartYear.setText("Year");
        cmbEndMonth.setSelectedIndex(0);
        cmbEndDay.setSelectedIndex(0);
        txtEndYear.setText("Year");
        sorter.setRowFilter(null);
    }

    class ButtonRenderer extends JPanel implements javax.swing.table.TableCellRenderer {

        JButton btnView = new JButton("View");
        JButton btnEdit = new JButton("Edit");
        JButton btnDelete = new JButton("Delete");

        public ButtonRenderer() {
            setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));

            styleTableButton(btnView);
            add(btnView);
            styleTableButton(btnEdit);
            add(btnEdit);
            styleTableButton(btnDelete);
            add(btnDelete);
        }

    @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {

        JPanel panel;

        JButton btnView = new JButton("View");
        JButton btnEdit = new JButton("Edit");
        JButton btnDelete = new JButton("Delete");

        public ButtonEditor(JCheckBox checkBox) {

            super(checkBox);

            panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 3, 10));
            
            styleTableButton(btnView);
            panel.add(btnView);
            btnView.addActionListener(e -> {int row = tblAccounts.getSelectedRow();
            JOptionPane.showMessageDialog(null, "View account of " + tblAccounts.getValueAt(row, 1));
            });
            
            styleTableButton(btnEdit);
            panel.add(btnEdit);
            btnEdit.addActionListener(e -> {int row = tblAccounts.getSelectedRow();
            JOptionPane.showMessageDialog(null, "Edit account of " + tblAccounts.getValueAt(row, 1));
            });
            
            styleTableButton(btnDelete); 
            panel.add(btnDelete);
            btnDelete.addActionListener(e -> {int row = tblAccounts.getSelectedRow();
                if (row != -1) {
                    model.removeRow(tblAccounts.convertRowIndexToModel(row));
                }
            });
        }

    @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return panel;
        }
    }
}