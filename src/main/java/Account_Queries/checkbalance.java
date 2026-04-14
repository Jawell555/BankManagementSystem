/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Account_Queries;

import Colors.ColorPalette;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
/**
 *
 * @author Ron
 */
public class CheckBalance extends JPanel{
    
    JLabel lblTitle, lblAccount, lblHolder;
    JPanel pnlBalance, pnlSearch;
    JTextField txtSearch, txtAccount, txtHolder;
    JButton btnFilter;
    
    Font fntTitle = new Font("Segoe UI", Font.BOLD, 25);
    Font fntText = new Font("Segoe UI", Font.PLAIN, 12);
    Font fntHeader = new Font("Segoe UI", Font.BOLD, 18);
    
    public CheckBalance() {
        
        setLayout(null);
        setBounds(0, 0, 1670, 1080);
        
        //HEAD
        {
        lblTitle = new JLabel("Balance Board");
        lblTitle.setBounds(50, 40, 700, 50);
        lblTitle.setFont(fntTitle);
        add(lblTitle);
        
        }
        //SEARCH
        {
      
        JPanel searchBoard = new JPanel();
        searchBoard.setLayout(null); 
        searchBoard.setBackground(Color.decode("#031B42"));
        searchBoard.setBounds(60, 100, 1520, 150); 
        
        JLabel lblHeaderTitle = new JLabel("   Search Board"); 
        lblHeaderTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblHeaderTitle.setForeground(Color.WHITE); 
        lblHeaderTitle.setBackground(Color.decode("#0E447D")); 
        lblHeaderTitle.setOpaque(true); 
        lblHeaderTitle.setBounds(0, 0, 1520, 35); 
        searchBoard.add(lblHeaderTitle);
        
        //Search account
        JLabel lblAccNum = new JLabel("Account Number");
        lblAccNum.setForeground(Color.WHITE);
        lblAccNum.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblAccNum.setBounds(50, 50, 200, 25);
        searchBoard.add(lblAccNum);

        JTextField txtAccNum = new JTextField("Enter account number");
        txtAccNum.setForeground(Color.GRAY);
        txtAccNum.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtAccNum.setBounds(50, 80, 730, 40); 
        searchBoard.add(txtAccNum);

        JButton btnSearch = new JButton("Search Account");
        btnSearch.setBackground(Color.decode("#0C3D70"));
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnSearch.setBounds(800, 80, 190, 40); 
        searchBoard.add(btnSearch);

        add(searchBoard); 
        
        //Information board panel
        JPanel infoBoard = new JPanel();
        infoBoard.setLayout(null);
        infoBoard.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#0E447D"), 3), "Information Board"));
        infoBoard.setBounds(60, 275, 1520, 280); 

        //Account details
        JLabel lblAccTitle = new JLabel("Account Title");
        lblAccTitle.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblAccTitle.setBounds(50, 40, 200, 25);
        infoBoard.add(lblAccTitle);

        JTextField txtAccTitle = new JTextField("Ryza Reyes");
        txtAccTitle.setEditable(false);
        txtAccTitle.setBackground(new Color(225, 225, 225)); 
        txtAccTitle.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtAccTitle.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtAccTitle.setBounds(50, 70, 650, 40);
        infoBoard.add(txtAccTitle);

        JLabel lblAccStatus = new JLabel("Account Number");
        lblAccStatus.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblAccStatus.setBounds(50, 130, 200, 25);
        infoBoard.add(lblAccStatus);

        JTextField txtAccStatus = new JTextField("00000000000");
        txtAccStatus.setEditable(false);
        txtAccStatus.setBackground(new Color(225, 225, 225)); 
        txtAccStatus.setFont(new Font("Segoe UI", Font.BOLD, 15));
        txtAccStatus.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtAccStatus.setBounds(50, 160, 650, 40);
        infoBoard.add(txtAccStatus);

        JSeparator infoSep1 = new JSeparator(SwingConstants.VERTICAL);
        infoSep1.setBounds(760, 40, 10, 200);
        infoBoard.add(infoSep1);

        JLabel lblHolderName = new JLabel("Account Holder Name");
        lblHolderName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblHolderName.setBounds(800, 40, 250, 25);
        infoBoard.add(lblHolderName);

        JTextField txtHolderName = new JTextField("Ryza");
        txtHolderName.setEditable(false);
        txtHolderName.setBackground(new Color(225, 225, 225)); 
        txtHolderName.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtHolderName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtHolderName.setBounds(800, 70, 650, 40);
        infoBoard.add(txtHolderName);

        JLabel lblAccType = new JLabel("Current Balance");
        lblAccType.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblAccType.setBounds(800, 130, 250, 25);
        infoBoard.add(lblAccType);

        JTextField txtAccType = new JTextField("Php 00.00");
        txtAccType.setEditable(false);
        txtAccType.setBackground(new Color(225, 225, 225)); 
        txtAccType.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtAccType.setBorder(BorderFactory.createLineBorder(Color.decode("#031B42"), 1));
        txtAccType.setBounds(800, 160, 650, 40);
        infoBoard.add(txtAccType);
        
        add(infoBoard); 
    }
        }
    
    
}
