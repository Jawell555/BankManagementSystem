package bank_ManageAccounts;

import Colors.ColorPalette;
import Database.AccountDatabase;
import Database.AccountSQL;
import Models.Account;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.*;
import javax.swing.border.LineBorder;
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
        this.accTypes = new String[]{"All", "Current", "Savings"};
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
        String[] columns = {"Image", "Name", "ID Type", "ID Number", "Account Title", "Account Number", "Account Type", "Date", "Operation"};
       
        model = new DefaultTableModel(columns, 0) {
            
        @Override
            public Class<?> getColumnClass(int column) {
                if (column == 0) {
                    return Icon.class;
                }
                return String.class;
            }

        @Override
            public boolean isCellEditable(int row, int column) {
                return column == 8;
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
        tblAccounts.getColumnModel().getColumn(5).setPreferredWidth(150);
        tblAccounts.getColumnModel().getColumn(6).setPreferredWidth(120);
        tblAccounts.getColumnModel().getColumn(7).setPreferredWidth(120);
        tblAccounts.getColumnModel().getColumn(8).setPreferredWidth(250);

        // Operation column
        tblAccounts.getColumnModel().getColumn(8).setCellRenderer(new ButtonRenderer());
        tblAccounts.getColumnModel().getColumn(8).setCellEditor(new ButtonEditor(new JCheckBox()));

        scpnAccounts = new JScrollPane(tblAccounts);
        scpnAccounts.setBounds(20, 25, 1530, 780);
        scpnAccounts.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        pnlTblContainer.add(scpnAccounts);

        sorter = new TableRowSorter<>(model);
        tblAccounts.setRowSorter(sorter);
        loadAccounts();

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

        java.util.List<RowFilter<Object, Object>> filters = new java.util.ArrayList<>();

        // Search filter
        String search = txtSearch.getText().trim();

        if (!search.isEmpty() &&
            !search.equalsIgnoreCase("Search account")) {

            filters.add(
                RowFilter.orFilter(java.util.Arrays.asList(
                    RowFilter.regexFilter(
                        "(?i)" + java.util.regex.Pattern.quote(search), 1),
                    RowFilter.regexFilter(
                        "(?i)" + java.util.regex.Pattern.quote(search), 4),
                    RowFilter.regexFilter(
                        "(?i)" + java.util.regex.Pattern.quote(search), 5)
                ))
            );
        }

        // Account Type filter
        String accountType = cmbAccountType.getSelectedItem().toString();

        if (!accountType.equals("All")) {

            filters.add(
                RowFilter.regexFilter(
                    "^" + accountType + "$",
                    6 // Account Type column
                )
            );
        }

        // Date range filter
        try {

            String startDate =
                    txtStartYear.getText().trim() + "-"
                    + String.format("%02d", cmbStartMonth.getSelectedIndex() + 1)
                    + "-"
                    + String.format("%02d", cmbStartDay.getSelectedItem());

            String endDate =
                    txtEndYear.getText().trim() + "-"
                    + String.format("%02d", cmbEndMonth.getSelectedIndex() + 1)
                    + "-"
                    + String.format("%02d", cmbEndDay.getSelectedItem());

            java.time.LocalDate from =
                    java.time.LocalDate.parse(startDate);

            java.time.LocalDate to =
                    java.time.LocalDate.parse(endDate);

            filters.add(new RowFilter<Object, Object>() {

                @Override
                public boolean include(
                        Entry<? extends Object,
                        ? extends Object> entry) {

                    try {

                        String dateValue =
                                entry.getStringValue(7); // Date column

                        java.time.LocalDate rowDate =
                                java.time.LocalDate.parse(dateValue);

                        return !rowDate.isBefore(from)
                                && !rowDate.isAfter(to);

                    } catch (Exception ex) {
                        return false;
                    }
                }
            });

        } catch (Exception ex) {
            // Ignore invalid date fields
        }

        if (filters.isEmpty()) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.andFilter(filters));
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
            btnView.addActionListener(e -> {

                int row = tblAccounts.getSelectedRow();

                if (row != -1) {

                    int modelRow =
                            tblAccounts.convertRowIndexToModel(row);

                    String accNo =
                            model.getValueAt(modelRow, 5).toString();

                    Account acc =
                            AccountSQL.getAccountByNumber(accNo);

                    if (acc != null) {
                        showViewDialog(acc);
                    }
                }
            });
            
            styleTableButton(btnEdit);
            panel.add(btnEdit);
            btnEdit.addActionListener(e -> {

                            int row = tblAccounts.getSelectedRow();

                            if (row != -1) {

                                int modelRow =
                                        tblAccounts.convertRowIndexToModel(row);

                                String accNo =
                                        model.getValueAt(modelRow, 5).toString();

                                Account acc =
                                        AccountSQL.getAccountByNumber(accNo);

                                if (acc != null) {
                                    showEditDialog(acc);
                                }
                            }
                        });

            styleTableButton(btnDelete); 
            panel.add(btnDelete);
            btnDelete.addActionListener(e -> {

                int row = tblAccounts.getSelectedRow();

                if (row != -1) {

                    int modelRow = tblAccounts.convertRowIndexToModel(row);

                    String accNo = model.getValueAt(modelRow, 5).toString();

                    boolean deleted = AccountSQL.deleteAccount(accNo);

                    if (deleted) {
                        model.removeRow(modelRow);
                    } else {
                        JOptionPane.showMessageDialog(null, "Delete failed!");
                    }
                }
            });
        }

    @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return panel;
        }
    }
    
    private void loadAccounts() {

        model.setRowCount(0);

        ImageIcon tableIcon;

        for (Account acc : AccountSQL.getAllAccounts()) {

            if (acc.getProfileImage()!= null &&
                !acc.getProfileImage().isEmpty()) {

                ImageIcon icon =
                        new ImageIcon(acc.getProfileImage());

                Image img = icon.getImage()
                        .getScaledInstance(
                                40,
                                40,
                                Image.SCALE_SMOOTH);

                tableIcon = new ImageIcon(img);

            } else {

                ImageIcon icon =
                        new ImageIcon(
                                getClass().getResource("/profile.png"));

                Image img = icon.getImage()
                        .getScaledInstance(
                                40,
                                40,
                                Image.SCALE_SMOOTH);

                tableIcon = new ImageIcon(img);
            }

            model.addRow(new Object[]{
                tableIcon,
                acc.getName(),
                acc.getIdType(),
                acc.getIdNumber(),
                acc.getAccTitle(),
                acc.getAccNo(),
                acc.getAccType(),
                acc.getDate(),
                "Action"
            });
        }
    }
    
    private void showViewDialog(Account acc) {

        Window parentWindow = SwingUtilities.getWindowAncestor(this);

        JDialog dialog = new JDialog(
                (JFrame) parentWindow,
                "Account Information",
                true
        );

        dialog.setSize(700, 850);
        dialog.setLayout(null);
        dialog.setLocationRelativeTo(parentWindow);
        dialog.getContentPane().setBackground(Color.WHITE);

        // HEADER
        JPanel header = new JPanel();
        header.setBackground(ColorPalette.Blue4);
        header.setBounds(0, 0, 700, 50);
        header.setLayout(null);

        JLabel lblTitle = new JLabel(
                "Account Information",
                SwingConstants.CENTER
        );

        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitle.setBounds(0, 10, 700, 30);

        header.add(lblTitle);
        dialog.add(header);

        int y = 70;
        
        JLabel lblProfile = new JLabel();
        lblProfile.setBounds(520, y, 120, 120);

        if (acc.getProfileImage()!= null && !acc.getProfileImage().isEmpty()) {
            ImageIcon icon =new ImageIcon(acc.getProfileImage());
            Image img = icon.getImage().getScaledInstance(120, 120,Image.SCALE_SMOOTH);
            lblProfile.setIcon(new ImageIcon(img));

        } else {
            ImageIcon icon = new ImageIcon(getClass().getResource("/profile.png"));
            Image img = icon.getImage().getScaledInstance(120,120,Image.SCALE_SMOOTH);
            lblProfile.setIcon(new ImageIcon(img));
        }

        dialog.add(lblProfile);
       
        // Account Number
        JLabel lblAccNo = new JLabel("Account Number:");
        lblAccNo.setBounds(30, y, 150, 25);
        dialog.add(lblAccNo);

        JLabel valAccNo = new JLabel(acc.getAccNo());
        valAccNo.setBounds(200, y, 450, 25);
        dialog.add(valAccNo);

        y += 35;

        // Account Holder
        JLabel lblName = new JLabel("Account Holder:");
        lblName.setBounds(30, y, 150, 25);
        dialog.add(lblName);

        JLabel valName = new JLabel(acc.getName());
        valName.setBounds(200, y, 450, 25);
        dialog.add(valName);

        y += 35;

        // Father Name
        JLabel lblFather = new JLabel("Father Name:");
        lblFather.setBounds(30, y, 150, 25);
        dialog.add(lblFather);

        JLabel valFather = new JLabel(acc.getFatherName());
        valFather.setBounds(200, y, 450, 25);
        dialog.add(valFather);

        y += 35;

        // Email
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(30, y, 150, 25);
        dialog.add(lblEmail);

        JLabel valEmail = new JLabel(acc.getEmail());
        valEmail.setBounds(200, y, 450, 25);
        dialog.add(valEmail);

        y += 35;

        // ID Type
        JLabel lblIDType = new JLabel("ID Type:");
        lblIDType.setBounds(30, y, 150, 25);
        dialog.add(lblIDType);

        JLabel valIDType = new JLabel(acc.getIdType());
        valIDType.setBounds(200, y, 450, 25);
        dialog.add(valIDType);

        y += 35;

        // ID Number
        JLabel lblIDNumber = new JLabel("ID Number:");
        lblIDNumber.setBounds(30, y, 150, 25);
        dialog.add(lblIDNumber);

        JLabel valIDNumber = new JLabel(acc.getIdNumber());
        valIDNumber.setBounds(200, y, 450, 25);
        dialog.add(valIDNumber);

        y += 35;

        // Date Opened
        JLabel lblDate = new JLabel("Date Opened:");
        lblDate.setBounds(30, y, 150, 25);
        dialog.add(lblDate);

        JLabel valDate = new JLabel(acc.getDate());
        valDate.setBounds(200, y, 450, 25);
        dialog.add(valDate);

        y += 35;

        // Account Type
        JLabel lblAccType = new JLabel("Account Type:");
        lblAccType.setBounds(30, y, 150, 25);
        dialog.add(lblAccType);

        JLabel valAccType = new JLabel(acc.getAccType());
        valAccType.setBounds(200, y, 450, 25);
        dialog.add(valAccType);

        y += 35;

        // Account Title
        JLabel lblAccTitle = new JLabel("Account Title:");
        lblAccTitle.setBounds(30, y, 150, 25);
        dialog.add(lblAccTitle);

        JLabel valAccTitle = new JLabel(acc.getAccTitle());
        valAccTitle.setBounds(200, y, 450, 25);
        dialog.add(valAccTitle);
        
        y += 35;
        
        JLabel lblBalance = new JLabel("Balance:");
        lblBalance.setBounds(30, y, 150, 25);
        dialog.add(lblBalance);

        JLabel valBalance = new JLabel(
                String.format("PHP %,.2f", acc.getAccBal())
        );
       
        valBalance.setBounds(200, y, 450, 25);
        valBalance.setForeground(new Color(0, 153, 51));
        valBalance.setFont(new Font("Segoe UI", Font.BOLD, 14));
        dialog.add(valBalance);

        y += 45;

        JSeparator sep = new JSeparator();
        sep.setBounds(30, y, 620, 2);
        dialog.add(sep);

        y += 20;

        JLabel lblPersonal = new JLabel("Personal Information");
        lblPersonal.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblPersonal.setForeground(ColorPalette.Blue4);
        lblPersonal.setBounds(30, y, 250, 25);
        dialog.add(lblPersonal);

        y += 40;

        // DOB
        JLabel lblDOB = new JLabel("Date of Birth:");
        lblDOB.setBounds(30, y, 150, 25);
        dialog.add(lblDOB);

        JLabel valDOB = new JLabel(
                acc.getDob() == null ? "" : acc.getDob()
        );

        valDOB.setBounds(200, y, 450, 25);
        dialog.add(valDOB);

        y += 35;

        // Gender
        JLabel lblGender = new JLabel("Gender:");
        lblGender.setBounds(30, y, 150, 25);
        dialog.add(lblGender);

        JLabel valGender = new JLabel(
                acc.getGender() == null ? "" : acc.getGender()
        );

        valGender.setBounds(200, y, 450, 25);
        dialog.add(valGender);

        y += 35;

        // Mobile Number
        JLabel lblMobile = new JLabel("Mobile Number:");
        lblMobile.setBounds(30, y, 150, 25);
        dialog.add(lblMobile);

        JLabel valMobile = new JLabel(
                acc.getMobileNumber() == null ? "" : acc.getMobileNumber()
        );

        valMobile.setBounds(200, y, 450, 25);
        dialog.add(valMobile);

        y += 35;

        // Postal Code
        JLabel lblPostal = new JLabel("Postal Code:");
        lblPostal.setBounds(30, y, 150, 25);
        dialog.add(lblPostal);

        JLabel valPostal = new JLabel(
                acc.getPostalCode() == null ? "" : acc.getPostalCode()
        );

        valPostal.setBounds(200, y, 450, 25);
        dialog.add(valPostal);

        y += 35;

        // Home Address
        JLabel lblAddress = new JLabel("Home Address:");
        lblAddress.setBounds(30, y, 150, 25);
        dialog.add(lblAddress);

        JLabel valAddress = new JLabel(
                acc.getHomeAddress() == null ? "" : acc.getHomeAddress()
        );

        valAddress.setBounds(200, y, 450, 25);
        dialog.add(valAddress);

        y += 35;

        // City
        JLabel lblCity = new JLabel("City:");
        lblCity.setBounds(30, y, 150, 25);
        dialog.add(lblCity);

        JLabel valCity = new JLabel(
                acc.getCity() == null ? "" : acc.getCity()
        );

        valCity.setBounds(200, y, 450, 25);
        dialog.add(valCity);

        // Close Button
        JButton btnClose = new JButton("Close");
        btnClose.setBounds(275, 730, 150, 40);

        btnClose.setBackground(ColorPalette.Blue4);
        btnClose.setForeground(Color.WHITE);
        btnClose.setFont(new Font("Segoe UI", Font.BOLD, 14));

        btnClose.addActionListener(e -> dialog.dispose());

        dialog.add(btnClose);

        dialog.setVisible(true);
    }
    
    private void showEditDialog(Account acc) {

        Window parentWindow = SwingUtilities.getWindowAncestor(this);

        JDialog dialog = new JDialog(
                (JFrame) parentWindow,
                "Edit Account",
                true
        );

        dialog.setSize(900, 900);
        dialog.setLayout(null);
        dialog.setLocationRelativeTo(parentWindow);
        dialog.getContentPane().setBackground(Color.WHITE);

        JPanel header = new JPanel();
        header.setBackground(ColorPalette.Blue4);
        header.setBounds(0, 0, 900, 50);
        header.setLayout(null);

        JLabel lblTitle = new JLabel(
                "Edit Account Information",
                SwingConstants.CENTER
        );

        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitle.setBounds(0, 10, 900, 30);

        header.add(lblTitle);
        dialog.add(header);

        int y = 70;
        
        JLabel lblProfile = new JLabel();
        lblProfile.setBounds(680, 80, 150, 150);
        lblProfile.setBorder(new LineBorder(Color.GRAY, 1, true));

        if (acc.getProfileImage()!= null && !acc.getProfileImage().isEmpty()) {
            ImageIcon icon =new ImageIcon(acc.getProfileImage());
            Image img = icon.getImage().getScaledInstance(150, 150,Image.SCALE_SMOOTH);
            lblProfile.setIcon(new ImageIcon(img));

        } else {
            ImageIcon icon = new ImageIcon(getClass().getResource("/profile.png"));
            Image img = icon.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH);
            lblProfile.setIcon(new ImageIcon(img));
        }

        dialog.add(lblProfile);
        
        JButton btnChooseImage =new JButton("Choose New Profile");
        
        btnChooseImage.setBounds(655, 250, 200, 35);
        styleButton(btnChooseImage);

        dialog.add(btnChooseImage);
        
        final String[] newImagePath = {null};
        
        btnChooseImage.addActionListener(e -> {
            
            JFileChooser chooser = new JFileChooser();

            int result = chooser.showOpenDialog(dialog);

            if (result == JFileChooser.APPROVE_OPTION) {

                File file = chooser.getSelectedFile();

                newImagePath[0] =
                        file.getAbsolutePath();

                ImageIcon icon = new ImageIcon(newImagePath[0]);

                Image img = icon.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH);

                lblProfile.setIcon(new ImageIcon(img)
                );
            }
        });
        
        JLabel lblAccNo = new JLabel("Account Number:");
        lblAccNo.setBounds(30, y, 150, 25);
        dialog.add(lblAccNo);

        JTextField txtAccNo = new JTextField(acc.getAccNo());
        txtAccNo.setBounds(200, y, 400, 25);
        txtAccNo.setEditable(false);
        dialog.add(txtAccNo);

        y += 35;

        JLabel lblName = new JLabel("Account Holder:");
        lblName.setBounds(30, y, 150, 25);
        dialog.add(lblName);

        JTextField txtName = new JTextField(acc.getName());
        txtName.setBounds(200, y, 400, 25);
        dialog.add(txtName);

        y += 35;

        JLabel lblFather = new JLabel("Father Name:");
        lblFather.setBounds(30, y, 150, 25);
        dialog.add(lblFather);

        JTextField txtFather = new JTextField(acc.getFatherName());
        txtFather.setBounds(200, y, 400, 25);
        dialog.add(txtFather);

        y += 35;

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(30, y, 150, 25);
        dialog.add(lblEmail);

        JTextField txtEmail = new JTextField(acc.getEmail());
        txtEmail.setBounds(200, y, 400, 25);
        dialog.add(txtEmail);

        y += 35;

        JLabel lblIDType = new JLabel("ID Type:");
        lblIDType.setBounds(30, y, 150, 25);
        dialog.add(lblIDType);

        JComboBox<String> cmbIDType = new JComboBox<>(new String[]{
            "National ID",
            "Passport",
            "Driver's License",
            "SSS",
            "UMID",
            "PhilHealth"
        });

        cmbIDType.setBounds(200, y, 400, 25);
        cmbIDType.setSelectedItem(acc.getIdType());
        dialog.add(cmbIDType);

        y += 35;

        JLabel lblIDNumber = new JLabel("ID Number:");
        lblIDNumber.setBounds(30, y, 150, 25);
        dialog.add(lblIDNumber);

        JTextField txtIDNumber = new JTextField(acc.getIdNumber());
        txtIDNumber.setBounds(200, y, 400, 25);
        dialog.add(txtIDNumber);

        y += 35;

        JLabel lblDate = new JLabel("Date Opened:");
        lblDate.setBounds(30, y, 150, 25);
        dialog.add(lblDate);

        JTextField txtDate = new JTextField(acc.getDate());
        txtDate.setBounds(200, y, 400, 25);
        txtDate.setEditable(false);
        dialog.add(txtDate);

        y += 35;

        JLabel lblAccType = new JLabel("Account Type:");
        lblAccType.setBounds(30, y, 150, 25);
        dialog.add(lblAccType);

        JComboBox<String> cmbAccType = new JComboBox<>(new String[]{
            "Savings",
            "Current"
        });

        cmbAccType.setBounds(200, y, 400, 25);
        cmbAccType.setSelectedItem(acc.getAccType());
        dialog.add(cmbAccType);

        y += 35;

        JLabel lblAccTitle = new JLabel("Account Title:");
        lblAccTitle.setBounds(30, y, 150, 25);
        dialog.add(lblAccTitle);

        JTextField txtAccTitle = new JTextField(acc.getAccTitle());
        txtAccTitle.setBounds(200, y, 400, 25);
        dialog.add(txtAccTitle);

        y += 35;

        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setBounds(30, y, 150, 25);
        dialog.add(lblStatus);

        JComboBox<String> cmbStatus = new JComboBox<>(new String[]{
            "Active",
            "Inactive",
            "Dormant"
        });

        cmbStatus.setBounds(200, y, 400, 25);
        cmbStatus.setSelectedItem(acc.getAccStatus());
        dialog.add(cmbStatus);

        y += 35;

        JLabel lblBalance = new JLabel("Balance:");
        lblBalance.setBounds(30, y, 150, 25);
        dialog.add(lblBalance);

        JTextField txtBalance = new JTextField(
                String.format("%.2f", acc.getAccBal())
        );

        txtBalance.setBounds(200, y, 400, 25);
        txtBalance.setEditable(false);
        dialog.add(txtBalance);

        y += 45;

        JSeparator sep = new JSeparator();
        sep.setBounds(30, y, 620, 2);
        dialog.add(sep);

        y += 20;

        JLabel lblPersonal = new JLabel("Personal Information");
        lblPersonal.setForeground(ColorPalette.Blue4);
        lblPersonal.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblPersonal.setBounds(30, y, 250, 25);
        dialog.add(lblPersonal);

        y += 40;

        JLabel lblDOB = new JLabel("Date of Birth:");
        lblDOB.setBounds(30, y, 150, 25);
        dialog.add(lblDOB);

        JTextField txtDOB = new JTextField(
                acc.getDob() == null ? "" : acc.getDob()
        );

        txtDOB.setBounds(200, y, 400, 25);
        dialog.add(txtDOB);

        y += 35;

        JLabel lblGender = new JLabel("Gender:");
        lblGender.setBounds(30, y, 150, 25);
        dialog.add(lblGender);

        JComboBox<String> cmbGender = new JComboBox<>(new String[]{
            "Male",
            "Female"
        });

        cmbGender.setBounds(200, y, 400, 25);

        if (acc.getGender() != null) {
            cmbGender.setSelectedItem(acc.getGender());
        }

        dialog.add(cmbGender);

        y += 35;

        JLabel lblMobile = new JLabel("Mobile Number:");
        lblMobile.setBounds(30, y, 150, 25);
        dialog.add(lblMobile);

        JTextField txtMobile = new JTextField(
                acc.getMobileNumber() == null ? "" : acc.getMobileNumber()
        );

        txtMobile.setBounds(200, y, 400, 25);
        dialog.add(txtMobile);

        y += 35;

        JLabel lblPostal = new JLabel("Postal Code:");
        lblPostal.setBounds(30, y, 150, 25);
        dialog.add(lblPostal);

        JTextField txtPostal = new JTextField(
                acc.getPostalCode() == null ? "" : acc.getPostalCode()
        );

        txtPostal.setBounds(200, y, 400, 25);
        dialog.add(txtPostal);

        y += 35;

        JLabel lblAddress = new JLabel("Home Address:");
        lblAddress.setBounds(30, y, 150, 25);
        dialog.add(lblAddress);

        JTextField txtAddress = new JTextField(
                acc.getHomeAddress() == null ? "" : acc.getHomeAddress()
        );

        txtAddress.setBounds(200, y, 400, 25);
        dialog.add(txtAddress);

        y += 35;

        JLabel lblCity = new JLabel("City:");
        lblCity.setBounds(30, y, 150, 25);
        dialog.add(lblCity);

        JTextField txtCity = new JTextField(
                acc.getCity() == null ? "" : acc.getCity()
        );

        txtCity.setBounds(200, y, 400, 25);
        dialog.add(txtCity);

        JButton btnSave = new JButton("Save");
        btnSave.setBounds(170, 790, 150, 40);
        styleButton(btnSave);
        
        btnSave.addActionListener(e -> {

            acc.setName(txtName.getText());
            acc.setFatherName(txtFather.getText());
            acc.setEmail(txtEmail.getText());

            acc.setIdType(
                    cmbIDType.getSelectedItem().toString()
            );

            acc.setIdNumber(txtIDNumber.getText());

            acc.setAccType(
                    cmbAccType.getSelectedItem().toString()
            );

            acc.setAccTitle(
                    txtAccTitle.getText()
            );

            acc.setAccStatus(
                    cmbStatus.getSelectedItem().toString()
            );

            acc.setDob(txtDOB.getText());

            acc.setGender(
                    cmbGender.getSelectedItem().toString()
            );

            acc.setMobileNumber(
                    txtMobile.getText()
            );

            acc.setPostalCode(
                    txtPostal.getText()
            );

            acc.setHomeAddress(
                    txtAddress.getText()
            );

            acc.setCity(
                    txtCity.getText()
            );
            
            boolean updated = AccountSQL.updateAccount(acc);

            if (!updated) {
                JOptionPane.showMessageDialog(
                        dialog,
                        "Failed to update account.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
            
            if (newImagePath[0] != null) {

                try {

                    File source = new File(newImagePath[0]);

                    File folder = new File("profile_images");

                    if (!folder.exists()) {
                        folder.mkdirs();
                    }

                    String extension = "";

                    int dot = source.getName().lastIndexOf('.');

                    if (dot > 0) {
                        extension = source.getName().substring(dot);
                    }

                    File destination =
                            new File(
                                    folder,
                                    acc.getAccNo() + extension
                            );

                    Files.copy(
                            source.toPath(),
                            destination.toPath(),
                            StandardCopyOption.REPLACE_EXISTING
                    );

                    acc.setProfileImage(
                            destination.getPath()
                    );

                } catch (IOException ex) {

                    JOptionPane.showMessageDialog(
                            dialog,
                            "Failed to save profile image."
                    );
                }
            }

            loadAccounts();

            JOptionPane.showMessageDialog(
                    dialog,
                    "Account updated successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );

            dialog.dispose();
        });

        dialog.add(btnSave);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(370, 790, 150, 40);

        btnCancel.setBackground(Color.LIGHT_GRAY);
        btnCancel.setFont(new Font("Segoe UI", Font.BOLD, 14));

        btnCancel.addActionListener(e -> dialog.dispose());

        dialog.add(btnCancel);

        dialog.setVisible(true);
    }
}