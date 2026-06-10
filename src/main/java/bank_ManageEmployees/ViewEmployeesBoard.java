package bank_ManageEmployees;

import Colors.ColorPalette;
import Database.EmployeeDatabase;
import Database.EmployeeSQL;
import Models.Employee;
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

public class ViewEmployeesBoard extends JPanel {

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

    public ViewEmployeesBoard() {
        this.months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        this.accTypes = new String[]{"Employee", "Admin", "All"};
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

        // Date
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

        // Date
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

        // Search/filter and Reset button
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
        String[] columns = {"Image", "Employee ID", "Name", "Email", "Contact", "Employee Type", "Status", "Operation"};

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
        tblAccounts.getColumnModel().getColumn(1).setPreferredWidth(60);
        tblAccounts.getColumnModel().getColumn(2).setPreferredWidth(130);
        tblAccounts.getColumnModel().getColumn(3).setPreferredWidth(170);
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
        
        loadEmployees();

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
            setLayout(new FlowLayout(FlowLayout.CENTER, 3, 10));

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

            panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 10));
            
            styleTableButton(btnView);
            panel.add(btnView);
            btnView.addActionListener(e -> {

                int row = tblAccounts.getSelectedRow();

                if (row == -1) {
                    return;
                }

                int modelRow = tblAccounts.convertRowIndexToModel(row);

                String empID = model.getValueAt(modelRow, 1).toString();
                Employee emp = EmployeeSQL.getEmployeeByID(empID);
                
                showViewDialog(emp);
            });
            
            styleTableButton(btnEdit);
            panel.add(btnEdit);
            btnEdit.addActionListener(e -> {

                int row = tblAccounts.getSelectedRow();

                if (row == -1) {
                    return;
                }

                int modelRow = tblAccounts.convertRowIndexToModel(row);

                String empID = model.getValueAt(modelRow, 1).toString();
                Employee emp = EmployeeSQL.getEmployeeByID(empID);

                showEditDialog(emp);
            });
            
            styleTableButton(btnDelete); 
            panel.add(btnDelete);
            btnDelete.addActionListener(e -> {

                int row = tblAccounts.getSelectedRow();

                if (row == -1) {
                    return;
                }

                int modelRow = tblAccounts.convertRowIndexToModel(row);
                String empID = model.getValueAt(modelRow, 1).toString();

                int choice = JOptionPane.showConfirmDialog(panel,"Are you sure you want to delete Employee " + empID + "?", "Confirm Delete",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);

                if (choice == JOptionPane.YES_OPTION) {

                    boolean deleted = EmployeeSQL.deleteEmployee(empID);

                    if (deleted) {

                        loadEmployees();

                        JOptionPane.showMessageDialog(panel,"Employee deleted successfully.", "Success",JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(panel, "Failed to delete employee.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
        }

    @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return panel;
        }
    }
    
    private void loadEmployees() {

    model.setRowCount(0);
    
    ImageIcon tableIcon;

        for (Employee emp : EmployeeSQL.getAllEmployees()) {
            
            if (emp.getProfileImage()!= null &&
                !emp.getProfileImage().isEmpty()) {

                ImageIcon icon = new ImageIcon(emp.getProfileImage());
                Image img = icon.getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH);
                tableIcon = new ImageIcon(img);
                

            } else {
                ImageIcon icon = new ImageIcon(getClass().getResource("/profile.png"));
                Image img = icon.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
                tableIcon = new ImageIcon(img);
            }
            
            model.addRow(new Object[]{
                tableIcon,
                emp.getEmpID(),
                emp.getEmpName(),
                emp.getEmail(),
                emp.getMobileNumber(),
                emp.getEmpType(),
                emp.getStatus(),
                "Action"
            });
        }
    }
    
    private void showViewDialog(Employee emp) {

        Window parentWindow = SwingUtilities.getWindowAncestor(this);

        JDialog dialog = new JDialog((JFrame) parentWindow, "Employee Information", true);

        dialog.setSize(700, 800);
        dialog.setLayout(null);
        dialog.setLocationRelativeTo(parentWindow);
        dialog.getContentPane().setBackground(Color.WHITE);

        JPanel header = new JPanel();
        header.setBackground(ColorPalette.Blue4);
        header.setBounds(0, 0, 700, 50);
        header.setLayout(null);

        JLabel lblTitle = new JLabel("Employee Profile",SwingConstants.CENTER);

        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitle.setBounds(0, 10, 700, 30);

        header.add(lblTitle);
        dialog.add(header);

        int y = 70;
        
        JLabel lblProfile = new JLabel();
        lblProfile.setBounds(520, y, 120, 120);

        if (emp.getProfileImage()!= null && !emp.getProfileImage().isEmpty()) {
            ImageIcon icon =new ImageIcon(emp.getProfileImage());
            Image img = icon.getImage().getScaledInstance(120, 120,Image.SCALE_SMOOTH);
            lblProfile.setIcon(new ImageIcon(img));

        } else {
            ImageIcon icon = new ImageIcon(getClass().getResource("/profile.png"));
            Image img = icon.getImage().getScaledInstance(120,120,Image.SCALE_SMOOTH);
            lblProfile.setIcon(new ImageIcon(img));
        }

        dialog.add(lblProfile);

        JLabel lblEmpID = new JLabel("Employee ID:");
        lblEmpID.setBounds(30, y, 150, 20);
        lblEmpID.setFont(new Font("Segoe UI", Font.BOLD, 13));
        dialog.add(lblEmpID);

        JLabel lblEmpIDValue = new JLabel(emp.getEmpID());
        lblEmpIDValue.setBounds(180, y, 400, 20);
        dialog.add(lblEmpIDValue);

        y += 30;

        JLabel lblName = new JLabel("Full Name:");
        lblName.setBounds(30, y, 150, 20);
        lblName.setFont(new Font("Segoe UI", Font.BOLD, 13));
        dialog.add(lblName);

        JLabel lblNameValue = new JLabel(emp.getEmpName());
        lblNameValue.setBounds(180, y, 400, 20);
        dialog.add(lblNameValue);

        y += 30;

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(30, y, 150, 20);
        lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 13));
        dialog.add(lblEmail);

        JLabel lblEmailValue = new JLabel(emp.getEmail());
        lblEmailValue.setBounds(180, y, 400, 20);
        dialog.add(lblEmailValue);

        y += 30;

        JLabel lblIDNo = new JLabel("ID Number:");
        lblIDNo.setBounds(30, y, 150, 20);
        lblIDNo.setFont(new Font("Segoe UI", Font.BOLD, 13));
        dialog.add(lblIDNo);

        JLabel lblIDNoValue = new JLabel(emp.getIdNumber());
        lblIDNoValue.setBounds(180, y, 400, 20);
        dialog.add(lblIDNoValue);

        y += 30;

        JLabel lblHireDate = new JLabel("Date Hired:");
        lblHireDate.setBounds(30, y, 150, 20);
        lblHireDate.setFont(new Font("Segoe UI", Font.BOLD, 13));
        dialog.add(lblHireDate);

        JLabel lblHireDateValue = new JLabel(emp.getDate());
        lblHireDateValue.setBounds(180, y, 400, 20);
        dialog.add(lblHireDateValue);

        y += 30;

        JLabel lblType = new JLabel("Employee Type:");
        lblType.setBounds(30, y, 150, 20);
        lblType.setFont(new Font("Segoe UI", Font.BOLD, 13));
        dialog.add(lblType);

        JLabel lblTypeValue = new JLabel(emp.getEmpType());
        lblTypeValue.setBounds(180, y, 400, 20);
        dialog.add(lblTypeValue);

        y += 30;

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(30, y, 150, 20);
        lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 13));
        dialog.add(lblUsername);

        JLabel lblUsernameValue = new JLabel(emp.getUsername());
        lblUsernameValue.setBounds(180, y, 400, 20);
        dialog.add(lblUsernameValue);

        y += 30;

        JLabel lblDOB = new JLabel("Date of Birth:");
        lblDOB.setBounds(30, y, 150, 20);
        lblDOB.setFont(new Font("Segoe UI", Font.BOLD, 13));
        dialog.add(lblDOB);

        JLabel lblDOBValue = new JLabel(emp.getDob());
        lblDOBValue.setBounds(180, y, 400, 20);
        dialog.add(lblDOBValue);

        y += 30;

        JLabel lblGender = new JLabel("Gender:");
        lblGender.setBounds(30, y, 150, 20);
        lblGender.setFont(new Font("Segoe UI", Font.BOLD, 13));
        dialog.add(lblGender);

        JLabel lblGenderValue = new JLabel(emp.getGender());
        lblGenderValue.setBounds(180, y, 400, 20);
        dialog.add(lblGenderValue);

        y += 30;

        JLabel lblMarital = new JLabel("Marital Status:");
        lblMarital.setBounds(30, y, 150, 20);
        lblMarital.setFont(new Font("Segoe UI", Font.BOLD, 13));
        dialog.add(lblMarital);

        JLabel lblMaritalValue = new JLabel(emp.getMaritalStatus());
        lblMaritalValue.setBounds(180, y, 400, 20);
        dialog.add(lblMaritalValue);

        y += 30;

        JLabel lblMobile = new JLabel("Mobile Number:");
        lblMobile.setBounds(30, y, 150, 20);
        lblMobile.setFont(new Font("Segoe UI", Font.BOLD, 13));
        dialog.add(lblMobile);

        JLabel lblMobileValue = new JLabel(emp.getMobileNumber());
        lblMobileValue.setBounds(180, y, 400, 20);
        dialog.add(lblMobileValue);

        y += 30;

        JLabel lblPostal = new JLabel("Postal Code:");
        lblPostal.setBounds(30, y, 150, 20);
        lblPostal.setFont(new Font("Segoe UI", Font.BOLD, 13));
        dialog.add(lblPostal);

        JLabel lblPostalValue = new JLabel(emp.getPostalCode());
        lblPostalValue.setBounds(180, y, 400, 20);
        dialog.add(lblPostalValue);

        y += 30;

        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setBounds(30, y, 150, 20);
        lblAddress.setFont(new Font("Segoe UI", Font.BOLD, 13));
        dialog.add(lblAddress);

        JLabel lblAddressValue = new JLabel(emp.getHomeAddress());
        lblAddressValue.setBounds(180, y, 400, 20);
        dialog.add(lblAddressValue);

        y += 30;

        JLabel lblCity = new JLabel("City:");
        lblCity.setBounds(30, y, 150, 20);
        lblCity.setFont(new Font("Segoe UI", Font.BOLD, 13));
        dialog.add(lblCity);

        JLabel lblCityValue = new JLabel(emp.getCity());
        lblCityValue.setBounds(180, y, 400, 20);
        dialog.add(lblCityValue);

        y += 30;

        JLabel lblEducation = new JLabel("Education:");
        lblEducation.setBounds(30, y, 150, 20);
        lblEducation.setFont(new Font("Segoe UI", Font.BOLD, 13));
        dialog.add(lblEducation);

        JLabel lblEducationValue = new JLabel(emp.getEducationLevel());
        lblEducationValue.setBounds(180, y, 400, 20);
        dialog.add(lblEducationValue);

        y += 30;

        JLabel lblJob = new JLabel("Current Job:");
        lblJob.setBounds(30, y, 150, 20);
        lblJob.setFont(new Font("Segoe UI", Font.BOLD, 13));
        dialog.add(lblJob);

        JLabel lblJobValue = new JLabel(emp.getCurrentJob());
        lblJobValue.setBounds(180, y, 400, 20);
        dialog.add(lblJobValue);

        y += 30;

        JLabel lblExp = new JLabel("Years Experience:");
        lblExp.setBounds(30, y, 150, 20);
        lblExp.setFont(new Font("Segoe UI", Font.BOLD, 13));
        dialog.add(lblExp);

        JLabel lblExpValue = new JLabel(emp.getYearsExperience());
        lblExpValue.setBounds(180, y, 400, 20);
        dialog.add(lblExpValue);

        y += 30;

        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setBounds(30, y, 150, 20);
        lblStatus.setFont(new Font("Segoe UI", Font.BOLD, 13));
        dialog.add(lblStatus);

        JLabel lblStatusValue = new JLabel(emp.getStatus());
        lblStatusValue.setBounds(180, y, 400, 20);
        dialog.add(lblStatusValue);

        JButton btnClose = new JButton("Close");
        btnClose.setBounds(275, 680, 120, 40);
        styleButton(btnClose);

        btnClose.addActionListener(e -> dialog.dispose());

        dialog.add(btnClose);

        dialog.setVisible(true);
    }
    
    private void showEditDialog(Employee emp) {

        Window parentWindow = SwingUtilities.getWindowAncestor(this);

        JDialog dialog = new JDialog((JFrame) parentWindow,"Edit Employee",true);

        dialog.setSize(900, 900);
        dialog.setLayout(null);
        dialog.setLocationRelativeTo(parentWindow);
        dialog.getContentPane().setBackground(Color.WHITE);

        // HEADER
        JPanel header = new JPanel();
        header.setBackground(ColorPalette.Blue4);
        header.setBounds(0, 0, 900, 50);
        header.setLayout(null);

        JLabel lblTitle = new JLabel("Edit Employee Profile", SwingConstants.CENTER);

        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitle.setBounds(0, 10, 900, 30);

        header.add(lblTitle);
        dialog.add(header);

        int y = 70;
        
        //Profle
        JLabel lblProfile = new JLabel();
        lblProfile.setBounds(680, 80, 150, 150);
        lblProfile.setBorder(new LineBorder(Color.GRAY, 1, true));

        if (emp.getProfileImage()!= null && !emp.getProfileImage().isEmpty()) {
            ImageIcon icon =new ImageIcon(emp.getProfileImage());
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

                newImagePath[0] = file.getAbsolutePath();

                ImageIcon icon = new ImageIcon(newImagePath[0]);

                Image img = icon.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH);

                lblProfile.setIcon(new ImageIcon(img)
                );
            }
        });

        // Employee ID
        JLabel lblEmpID = new JLabel("Employee ID:");
        lblEmpID.setBounds(30, y, 150, 25);
        dialog.add(lblEmpID);

        JTextField txtEmpID = new JTextField(emp.getEmpID());
        txtEmpID.setBounds(200, y, 400, 25);
        txtEmpID.setEditable(false);
        dialog.add(txtEmpID);

        y += 35;

        // Name
        JLabel lblName = new JLabel("Full Name:");
        lblName.setBounds(30, y, 150, 25);
        dialog.add(lblName);

        JTextField txtName = new JTextField(emp.getEmpName());
        txtName.setBounds(200, y, 400, 25);
        dialog.add(txtName);

        y += 35;

        // Email
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(30, y, 150, 25);
        dialog.add(lblEmail);

        JTextField txtEmail = new JTextField(emp.getEmail());
        txtEmail.setBounds(200, y, 400, 25);
        dialog.add(txtEmail);

        y += 35;

        // ID Number
        JLabel lblIDNo = new JLabel("ID Number:");
        lblIDNo.setBounds(30, y, 150, 25);
        dialog.add(lblIDNo);

        JTextField txtIDNo = new JTextField(emp.getIdNumber());
        txtIDNo.setBounds(200, y, 400, 25);
        dialog.add(txtIDNo);

        y += 35;

        // Date Hired
        JLabel lblDateHired = new JLabel("Date Hired:");
        lblDateHired.setBounds(30, y, 150, 25);
        dialog.add(lblDateHired);

        JTextField txtDateHired = new JTextField(emp.getDate());
        txtDateHired.setBounds(200, y, 400, 25);
        txtDateHired.setEditable(false);
        dialog.add(txtDateHired);

        y += 35;

        // Employee Type
        JLabel lblType = new JLabel("Employee Type:");
        lblType.setBounds(30, y, 150, 25);
        dialog.add(lblType);

        JComboBox<String> cmbType =new JComboBox<>(new String[]{"Employee","Admin"});

        cmbType.setBounds(200, y, 400, 25);
        cmbType.setSelectedItem(emp.getEmpType());
        dialog.add(cmbType);

        y += 35;

        // Username
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(30, y, 150, 25);
        dialog.add(lblUsername);

        JTextField txtUsername = new JTextField(emp.getUsername());
        txtUsername.setBounds(200, y, 400, 25);
        txtUsername.setEditable(true);
        dialog.add(txtUsername);

        y += 35;

        // Password
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(30, y, 150, 25);
        dialog.add(lblPassword);

        JPasswordField txtPassword = new JPasswordField(emp.getPassword());

        txtPassword.setBounds(200, y, 400, 25);
        dialog.add(txtPassword);

        y += 35;

        // DOB
        JLabel lblDOB = new JLabel("Date of Birth:");
        lblDOB.setBounds(30, y, 150, 25);
        dialog.add(lblDOB);

        JTextField txtDOB = new JTextField(emp.getDob());
        txtDOB.setBounds(200, y, 400, 25);
        dialog.add(txtDOB);

        y += 35;

        // Gender
        JLabel lblGender = new JLabel("Gender:");
        lblGender.setBounds(30, y, 150, 25);
        dialog.add(lblGender);

        JComboBox<String> cmbGender = new JComboBox<>(new String[]{"Male","Female"});

        cmbGender.setBounds(200, y, 400, 25);
        cmbGender.setSelectedItem(emp.getGender());
        dialog.add(cmbGender);

        y += 35;

        // Marital Status
        JLabel lblMarital = new JLabel("Marital Status:");
        lblMarital.setBounds(30, y, 150, 25);
        dialog.add(lblMarital);

        JComboBox<String> cmbMarital = new JComboBox<>(new String[]{"Single","Married","Widowed"});

        cmbMarital.setBounds(200, y, 400, 25);
        cmbMarital.setSelectedItem(emp.getMaritalStatus());
        dialog.add(cmbMarital);

        y += 35;

        // Mobile Number
        JLabel lblMobile = new JLabel("Mobile Number:");
        lblMobile.setBounds(30, y, 150, 25);
        dialog.add(lblMobile);

        JTextField txtMobile = new JTextField(emp.getMobileNumber());

        txtMobile.setBounds(200, y, 400, 25);
        dialog.add(txtMobile);

        y += 35;

        // Postal Code
        JLabel lblPostal = new JLabel("Postal Code:");
        lblPostal.setBounds(30, y, 150, 25);
        dialog.add(lblPostal);

        JTextField txtPostal = new JTextField(emp.getPostalCode());

        txtPostal.setBounds(200, y, 400, 25);
        dialog.add(txtPostal);

        y += 35;

        // Address
        JLabel lblAddress = new JLabel("Home Address:");
        lblAddress.setBounds(30, y, 150, 25);
        dialog.add(lblAddress);

        JTextField txtAddress = new JTextField(emp.getHomeAddress());

        txtAddress.setBounds(200, y, 400, 25);
        dialog.add(txtAddress);

        y += 35;

        // City
        JLabel lblCity = new JLabel("City:");
        lblCity.setBounds(30, y, 150, 25);
        dialog.add(lblCity);

        JTextField txtCity = new JTextField(emp.getCity());

        txtCity.setBounds(200, y, 400, 25);
        dialog.add(txtCity);

        y += 35;

        // Education
        JLabel lblEducation = new JLabel("Education Level:");
        lblEducation.setBounds(30, y, 150, 25);
        dialog.add(lblEducation);

        JTextField txtEducation = new JTextField(emp.getEducationLevel());

        txtEducation.setBounds(200, y, 400, 25);
        dialog.add(txtEducation);

        y += 35;

        // Current Job
        JLabel lblCurrentJob = new JLabel("Current Job:");
        lblCurrentJob.setBounds(30, y, 150, 25);
        dialog.add(lblCurrentJob);

        JTextField txtCurrentJob = new JTextField(emp.getCurrentJob());

        txtCurrentJob.setBounds(200, y, 400, 25);
        dialog.add(txtCurrentJob);

        y += 35;

        // Experience
        JLabel lblExperience = new JLabel("Years Experience:");
        lblExperience.setBounds(30, y, 150, 25);
        dialog.add(lblExperience);

        JTextField txtExperience = new JTextField(emp.getYearsExperience());

        txtExperience.setBounds(200, y, 400, 25);
        dialog.add(txtExperience);

        y += 35;

        // Status
        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setBounds(30, y, 150, 25);
        dialog.add(lblStatus);

        JComboBox<String> cmbStatus = new JComboBox<>(new String[]{"Active", "Inactive", "Suspended"});

        cmbStatus.setBounds(200, y, 400, 25);
        cmbStatus.setSelectedItem(emp.getStatus());
        dialog.add(cmbStatus);

        // SAVE BUTTON
        JButton btnSave = new JButton("Save");
        btnSave.setBounds(170, 740, 150, 40);
        styleButton(btnSave);

        btnSave.addActionListener(e -> {
            // Email validation
        if (!txtEmail.getText().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            JOptionPane.showMessageDialog(dialog, "Invalid email format.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // DOB validation (yyyy-MM-dd)
        if (!txtDOB.getText().matches("\\d{4}-\\d{2}-\\d{2}")) {
            JOptionPane.showMessageDialog(dialog, "Date of Birth must be in YYYY-MM-DD format.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Mobile number validation
        if (!txtMobile.getText().matches("\\d{11}")) {
            JOptionPane.showMessageDialog(dialog, "Mobile number must contain exactly 11 digits.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Postal code validation
        if (!txtPostal.getText().matches("\\d+")) {
            JOptionPane.showMessageDialog(dialog, "Postal code must contain numbers only.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Experience validation
        if (!txtExperience.getText().matches("\\d+")) {
            JOptionPane.showMessageDialog(dialog, "Years of experience must be a valid number.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

            emp.setEmpName(txtName.getText());
            emp.setEmail(txtEmail.getText());
            emp.setIdNumber(txtIDNo.getText());
            emp.setEmpType(cmbType.getSelectedItem().toString());
            emp.setUsername(txtUsername.getText());
            emp.setPassword(new String(txtPassword.getPassword()));
            emp.setDob(txtDOB.getText());
            emp.setGender(cmbGender.getSelectedItem().toString());
            emp.setMaritalStatus(cmbMarital.getSelectedItem().toString());
            emp.setMobileNumber(txtMobile.getText());
            emp.setPostalCode(txtPostal.getText());
            emp.setHomeAddress(txtAddress.getText() );
            emp.setCity(txtCity.getText());
            emp.setEducationLevel(txtEducation.getText());
            emp.setCurrentJob(txtCurrentJob.getText());
            emp.setYearsExperience(txtExperience.getText());
            emp.setStatus(cmbStatus.getSelectedItem().toString());
            
            
            
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

                    File destination = new File(folder, emp.getEmpID()+ extension);

                    Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);

                    emp.setProfileImage(destination.getPath());

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(dialog, "Failed to save profile image.");
                }
            }
            boolean success = EmployeeSQL.updateEmployee(emp);
            if(success){
                loadEmployees();

                JOptionPane.showMessageDialog(dialog, "Employee updated successfully!","Success", JOptionPane.INFORMATION_MESSAGE);
                dialog.dispose();
            }else{
                JOptionPane.showMessageDialog(dialog, "Failed to update employee.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            
            loadEmployees();

            dialog.dispose();
        });

        dialog.add(btnSave);

        // CANCEL BUTTON
        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(370, 740, 150, 40);

        btnCancel.setBackground(Color.LIGHT_GRAY);
        btnCancel.setFont(new Font("Segoe UI", Font.BOLD, 14));

        btnCancel.addActionListener(e -> dialog.dispose());

        dialog.add(btnCancel);

        dialog.setVisible(true);
    }

}


