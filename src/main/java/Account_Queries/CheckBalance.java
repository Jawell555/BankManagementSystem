package Account_Queries;

import Colors.ColorPalette;
import Models.AccountModel;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class CheckBalance extends JPanel {

    JLabel lblTitle, lblHeaderTitle, lblAccNum, lblHolderName,
            lblAccNo, lblAccType, lblAccBal;

    JPanel searchBoard, infoBoard;

    JTextField txtAccNum, txtHolderName,
            txtAccNo, txtAccType, txtAccBal;

    JButton btnSearch;
    JSeparator infoSep1;

    Font fntTitle = new Font("Segoe UI", Font.BOLD, 25);
    Font fntText = new Font("Segoe UI", Font.PLAIN, 12);
    Font fntHeader = new Font("Segoe UI", Font.BOLD, 18);

    // ACCOUNT LIST
    ArrayList<AccountModel> accounts = new ArrayList<>();

    public CheckBalance() {

        setLayout(null);
        setBounds(0, 0, 1670, 1080);

        // SAMPLE DATA
        loadAccounts();

        // HEAD
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

            // Search account
            lblAccNum = new JLabel("Account Number");
            lblAccNum.setForeground(Color.WHITE);
            lblAccNum.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            lblAccNum.setBounds(50, 50, 200, 25);
            searchBoard.add(lblAccNum);

            txtAccNum = new JTextField("SPB100000000");
            txtAccNum.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            txtAccNum.setBounds(50, 80, 730, 40);
            searchBoard.add(txtAccNum);

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

            txtAccNo = new JTextField();
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

        // BUTTON FUNCTION
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String searchAccNo = txtAccNum.getText().trim();

                boolean found = false;

                for (AccountModel acc : accounts) {

                    if (acc.getAccNo().equals(searchAccNo)) {

                        txtHolderName.setText(acc.getName());
                        txtAccNo.setText(acc.getAccNo());
                        txtAccType.setText(acc.getAccType());

                        txtAccBal.setText(
                                "Php " + String.format("%.2f",
                                        acc.getAccBal()));

                        found = true;
                        break;
                    }
                }

                if (!found) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Account not found!"
                    );

                    txtHolderName.setText("");
                    txtAccNo.setText("");
                    txtHolderName.setText("");
                    txtAccBal.setText("");
                }
            }
        });
    }

    // LOAD SAMPLE ACCOUNTS
    public void loadAccounts() {

        AccountModel acc1 = new AccountModel();
        acc1.setAccNo("SPB1000000001");
        acc1.setName("Juan Dela Cruz");
        acc1.setAccType("Savings");
        acc1.setAccBal(25000.75);
        accounts.add(acc1);

        AccountModel acc2 = new AccountModel();
        acc2.setAccNo("SPB1000000002");
        acc2.setName("Maria Santos");
        acc2.setAccType("Current");
        acc2.setAccBal(150000.00);
        accounts.add(acc2);

        AccountModel acc3 = new AccountModel();
        acc3.setAccNo("SPB1000000003");
        acc3.setName("Carlos Reyes");
        acc3.setAccType("Savings");
        acc3.setAccBal(8900.50);
        accounts.add(acc3);

        AccountModel acc4 = new AccountModel();
        acc4.setAccNo("SPB1000000004");
        acc4.setName("Ana Lopez");
        acc4.setAccType("Savings");
        acc4.setAccBal(45600.00);
        accounts.add(acc4);

        AccountModel acc5 = new AccountModel();
        acc5.setAccNo("SPB1000000005");
        acc5.setName("Mark Bautista");
        acc5.setAccType("Current");
        acc5.setAccBal(98000.25);
        accounts.add(acc5);

        AccountModel acc6 = new AccountModel();
        acc6.setAccNo("SPB1000000006");
        acc6.setName("Liza Gomez");
        acc6.setAccType("Savings");
        acc6.setAccBal(12340.75);
        accounts.add(acc6);

        AccountModel acc7 = new AccountModel();
        acc7.setAccNo("SPB1000000007");
        acc7.setName("Paul Navarro");
        acc7.setAccType("Current");
        acc7.setAccBal(78500.00);
        accounts.add(acc7);

        AccountModel acc8 = new AccountModel();
        acc8.setAccNo("SPB1000000008");
        acc8.setName("Karla Mendoza");
        acc8.setAccType("Savings");
        acc8.setAccBal(33210.90);
        accounts.add(acc8);
    }
}