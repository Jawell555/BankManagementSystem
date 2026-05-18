package Account_Queries;

import Colors.ColorPalette;
import Database.AccountDatabase;
import Models.Account;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Database.TransactionDatabase;
import Models.Transaction;
import java.time.LocalDateTime;

public class CheckBalance extends JPanel implements ActionListener {

    TransactionDatabase BankLogic = new TransactionDatabase();

    JLabel lblTitle, lblFrom, lblTo, lblHeaderTitle, lblAccNum, lblAccNo, lblAccType, lblHolderName, lblAccBal;
    JPanel pnlTblContainer, pnlSearch, infoBoard, searchBoard;
    JTextField txtAccNum, txtAccNo, txtAccType, txtStartYear, txtEndYear, txtHolderName, txtAccBal;
    JComboBox<String> cmbHistoryType, cmbStartMonth, cmbEndMonth, cmbStartDay, cmbEndDay;
    JButton btnHistoryFilter, btnSearch;
    JTable tblBalHistory;
    JSeparator infoSep1;
    JScrollPane scpnBalHistory;

    private final String[] historyChoices;
    private final String[] months;
    private final String[] days = new String[32];
    private String[] historyColumns = {"Name", "Account Number", "Sender/Receiver Account", "Sender/Receiver Name", "Date & Time", "History Type", "Amount"};

    Font fntTitle = new Font("Segoe UI", Font.BOLD, 25);
    Font fntText = new Font("Segoe UI", Font.PLAIN, 12);
    Font fntHeader = new Font("Segoe UI", Font.BOLD, 18);


    // ACCOUNT LIST
    ArrayList<Account> accounts = new ArrayList<>();

    public CheckBalance() {
        this.months = new String[]{"Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        this.historyChoices = new String[]{"History Type", "Deposit", "Withdrawal", "Transfer", "Received"};
        for (int i = 0; i <= 31; i++) {
            if (i == 0) {
                this.days[i] = "Day";
            } else {
                this.days[i] = "" + i;
            }
        }
        setLayout(null);
        setBounds(0, 0, 1670, 1080);

        // SAMPLE DATA
        
        //HEAD
        {
            lblTitle = new JLabel("Balance Board");
            lblTitle.setBounds(50, 40, 700, 50);
            lblTitle.setFont(fntTitle);
            add(lblTitle);

        }

        // SEARCH
        {

            searchBoard = new JPanel();
            searchBoard.setLayout(null);
            searchBoard.setBackground(Color.decode("#031B42"));
            searchBoard.setBounds(60, 100, 1520, 150);

            lblHeaderTitle = new JLabel("   Search Board");
            lblHeaderTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
            lblHeaderTitle.setForeground(Color.WHITE);
            lblHeaderTitle.setBackground(Color.decode("#0E447D"));
            lblHeaderTitle.setOpaque(true);
            lblHeaderTitle.setBounds(0, 0, 1520, 35);
            searchBoard.add(lblHeaderTitle);

            //Search account
            lblAccNum = new JLabel("Account Number");
            lblAccNum.setForeground(Color.WHITE);
            lblAccNum.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            lblAccNum.setBounds(50, 50, 200, 25);
            searchBoard.add(lblAccNum);

            txtAccNum  = new JTextField("Enter account number");
            txtAccNum .setForeground(Color.GRAY);
            txtAccNum .setFont(new Font("Segoe UI", Font.PLAIN, 15));
            txtAccNum .setBounds(50, 80, 730, 40);
            searchBoard.add(txtAccNum );

            btnSearch = new JButton("Search Account");
            btnSearch.setBackground(Color.decode("#0C3D70"));
            btnSearch.setForeground(Color.WHITE);
            btnSearch.setFont(new Font("Segoe UI", Font.BOLD, 18));
            btnSearch.setBounds(800, 80, 190, 40);
            searchBoard.add(btnSearch);

            add(searchBoard);

             // INFORMATION BOARD
            infoBoard = new JPanel();
            infoBoard.setLayout(null);

            infoBoard.setBorder(
                    BorderFactory.createTitledBorder(
                            BorderFactory.createLineBorder(
                                    Color.decode("#0E447D"), 3),
                            "Information Board"
                    )
            );

            infoBoard.setBounds(60, 275, 1520, 280);

            // Account Title
            lblHolderName = new JLabel("Account Holder Name");
            lblHolderName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            lblHolderName.setBounds(50, 40, 200, 25);
            infoBoard.add(lblHolderName);

            txtHolderName = new JTextField();
            txtHolderName.setEditable(false);
            txtHolderName.setBackground(new Color(225, 225, 225));
            txtHolderName.setBorder(
                    BorderFactory.createLineBorder(
                            Color.decode("#031B42"), 1));
            txtHolderName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            txtHolderName.setBounds(50, 70, 650, 40);
            infoBoard.add(txtHolderName);

            // Account Number
            lblAccNo = new JLabel("Account Number");
            lblAccNo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            lblAccNo.setBounds(50, 130, 200, 25);
            infoBoard.add(lblAccNo);

            txtAccNo = new JTextField("SPB100000000");
            txtAccNo.setEditable(false);
            txtAccNo.setBackground(new Color(225, 225, 225));
            txtAccNo.setFont(new Font("Segoe UI", Font.BOLD, 15));
            txtAccNo.setBorder(
                    BorderFactory.createLineBorder(
                            Color.decode("#031B42"), 1));
            txtAccNo.setBounds(50, 160, 650, 40);
            infoBoard.add(txtAccNo);

            // Separator
            infoSep1 = new JSeparator(SwingConstants.VERTICAL);
            infoSep1.setBounds(760, 40, 10, 200);
            infoBoard.add(infoSep1);

            // Account Type
            lblAccType = new JLabel("Account Type");
            lblAccType.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            lblAccType.setBounds(800, 40, 250, 25);
            infoBoard.add(lblAccType);

            txtAccType = new JTextField();
            txtAccType.setEditable(false);
            txtAccType.setBackground(new Color(225, 225, 225));
            txtAccType.setBorder(
                    BorderFactory.createLineBorder(
                            Color.decode("#031B42"), 1));
            txtAccType.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            txtAccType.setBounds(800, 70, 650, 40);
            infoBoard.add(txtAccType);

            // Balance
            lblAccBal = new JLabel("Current Balance");
            lblAccBal.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            lblAccBal.setBounds(800, 130, 250, 25);
            infoBoard.add(lblAccBal);

            txtAccBal = new JTextField();
            txtAccBal.setEditable(false);
            txtAccBal.setBackground(new Color(225, 225, 225));
            txtAccBal.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            txtAccBal.setBorder(
                    BorderFactory.createLineBorder(
                            Color.decode("#031B42"), 1));
            txtAccBal.setBounds(800, 160, 650, 40);
            infoBoard.add(txtAccBal);

            add(infoBoard);
        }
        //SEARCH
        {
            pnlSearch = new JPanel(null);
            pnlSearch.setBounds(60, 585, 1520, 70);
            pnlSearch.setBorder(ColorPalette.panelBorder("Search Board"));
            pnlSearch.setFont(fntText);
            add(pnlSearch);

            btnHistoryFilter = new JButton("Filter");
            btnHistoryFilter.setBounds(820, 25, 120, 30);
            btnHistoryFilter.setFont(fntText);
            btnHistoryFilter.setForeground(Color.WHITE);
            btnHistoryFilter.setBackground(ColorPalette.Blue4);
            pnlSearch.add(btnHistoryFilter);

            cmbHistoryType = new JComboBox<>(historyChoices);
            cmbHistoryType.setBounds(50, 25, 115, 30);
            cmbHistoryType.setFont(fntText);
            cmbHistoryType.setBackground(Color.white);
            pnlSearch.add(cmbHistoryType);

            lblFrom = new JLabel("From:", SwingConstants.RIGHT);
            lblFrom.setBounds(200, 25, 35, 31);
            lblFrom.setFont(fntText);
            lblFrom.setBackground(Color.white);
            pnlSearch.add(lblFrom);

            cmbStartMonth = new JComboBox<>(months);
            cmbStartMonth.setBounds(240, 25, 90, 30);
            cmbStartMonth.setFont(fntText);
            cmbStartMonth.setBackground(Color.white);
            pnlSearch.add(cmbStartMonth);

            cmbStartDay = new JComboBox<>(days);
            cmbStartDay.setBounds(330, 25, 70, 30);
            cmbStartDay.setFont(fntText);
            cmbStartDay.setBackground(Color.white);
            pnlSearch.add(cmbStartDay);

            txtStartYear = new JTextField("Year");
            txtStartYear.setBounds(400, 25, 70, 31);
            txtStartYear.setFont(fntText);
            txtStartYear.setBackground(Color.white);
            pnlSearch.add(txtStartYear);

            lblTo = new JLabel("To:", SwingConstants.RIGHT);
            lblTo.setBounds(490, 25, 35, 31);
            lblTo.setFont(fntText);
            lblTo.setBackground(Color.white);
            pnlSearch.add(lblTo);

            cmbEndMonth = new JComboBox<>(months);
            cmbEndMonth.setBounds(530, 25, 90, 30);
            cmbEndMonth.setFont(fntText);
            cmbEndMonth.setBackground(Color.white);
            pnlSearch.add(cmbEndMonth);

            cmbEndDay = new JComboBox<>(days);
            cmbEndDay.setBounds(620, 25, 70, 30);
            cmbEndDay.setFont(fntText);
            cmbEndDay.setBackground(Color.white);
            pnlSearch.add(cmbEndDay);

            txtEndYear = new JTextField("Year");
            txtEndYear.setBounds(690, 25, 70, 31);
            txtEndYear.setFont(fntText);
            txtEndYear.setBackground(Color.white);
            pnlSearch.add(txtEndYear);
        }
        //TABLE
        {
            pnlTblContainer = new JPanel(null);
            pnlTblContainer.setBounds(60, 685, 1520, 305);
            pnlTblContainer.setBorder(ColorPalette.panelBorder("Balance History"));
            pnlTblContainer.setFont(fntText);
            add(pnlTblContainer);

            tblBalHistory = BankLogic.createStyledTable(BankLogic.noData(), historyColumns);
            scpnBalHistory = new JScrollPane(tblBalHistory);
            scpnBalHistory.setBounds(20, 25, 1480, 255);
            pnlTblContainer.add(scpnBalHistory);
        }
        // BUTTON FUNCTION
        btnSearch.addActionListener(this);
        btnHistoryFilter.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {
            boardSearch();
            searchByNumber();
            reset();
        } else 
            if (e.getSource() == btnHistoryFilter) {
            generalFilter();
        }
    }
    

    public void generalFilter() {
        LocalDateTime startDate = convertDate(cmbStartMonth.getSelectedIndex(), cmbStartDay.getSelectedIndex(), txtStartYear.getText());
        LocalDateTime endDate = convertDate(cmbEndMonth.getSelectedIndex(), cmbEndDay.getSelectedIndex(), txtEndYear.getText());

        pnlTblContainer.remove(scpnBalHistory);
        ArrayList<Transaction> filtered = BankLogic.getList(txtAccNum.getText(), (String) cmbHistoryType.getSelectedItem(), startDate, endDate);
        tblBalHistory = BankLogic.createStyledTable(filtered, historyColumns);
        scpnBalHistory = new JScrollPane(tblBalHistory);
        scpnBalHistory.setBounds(20, 25, 1480, 255);
        pnlTblContainer.add(scpnBalHistory);
    }

    public void searchByNumber() {
        pnlTblContainer.remove(scpnBalHistory);
        ArrayList<Transaction> filtered = BankLogic.getListByNumber(txtAccNum.getText());
        tblBalHistory = BankLogic.createStyledTable(filtered, historyColumns);
        scpnBalHistory = new JScrollPane(tblBalHistory);
        scpnBalHistory.setBounds(20, 25, 1480, 255);
        pnlTblContainer.add(scpnBalHistory);
    }
    
    public void boardSearch() {
                String searchAccNo = txtAccNum.getText().trim();

                Account acc =
                        AccountDatabase.getAccountByNumber(searchAccNo);

                if (acc != null) {
                    txtHolderName.setText(acc.getName());
                    txtAccNo.setText(acc.getAccNo());
                    txtAccType.setText(acc.getAccType());

                    txtAccBal.setText(
                            "PHP " + String.format("%,.2f",
                                    acc.getAccBal()));
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Account not found!"
                    );
                    txtHolderName.setText("");
                    txtAccNo.setText("");
                    txtAccType.setText("");
                    txtAccBal.setText("");
                }
            }
    
    public LocalDateTime convertDate(int month, int day, String year) {
        try {
            if (year.trim().isEmpty() || year.trim().equals("Year")) {
                return null;
            }
            int intYear = Integer.parseInt(year);
            if (month == 0) {
                return null;
            }
            if (day == 0) {
                return null;
            }
            return LocalDateTime.of(intYear, month, day, 0, 0, 0);
        } catch (NumberFormatException e) {
            return null;
        }
    }
   
    public void reset(){
        cmbHistoryType.setSelectedIndex(0);
        cmbStartMonth.setSelectedIndex(0);
        cmbStartDay.setSelectedIndex(0);
        txtStartYear.setText("Year");
        cmbEndMonth.setSelectedIndex(0);
        cmbEndDay.setSelectedIndex(0);
        txtEndYear.setText("Year");
    }
}

