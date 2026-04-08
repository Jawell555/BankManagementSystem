/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Account_Queries;

import Colors.ColorPalette;
import java.awt.*;
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
        pnlSearch = new JPanel(null);
        pnlSearch.setBounds(50, 100, 1570, 100);
        pnlSearch.setBorder(ColorPalette.panelBorder("Search Board"));
        pnlSearch.setFont(fntText);
        add(pnlSearch);
        
        txtSearch = new JTextField("Enter account number");
        txtSearch. setBounds(20, 40, 1075 , 30);
        txtSearch.setFont(fntText);
        txtSearch.setBackground(Color.white);
        pnlSearch.add(txtSearch);
        
        btnFilter = new JButton("Search");
        btnFilter.setBounds(1140, 40, 120, 30);
        btnFilter.setFont(fntText);
        btnFilter.setForeground(Color.WHITE);
        btnFilter.setBackground(ColorPalette.Blue4);
        pnlSearch.add(btnFilter);
        
        pnlBalance = new JPanel(null);
        pnlBalance.setBounds(50, 200, 1570, 200);
        pnlBalance.setBorder(ColorPalette.panelBorder("Information Board"));
        pnlBalance.setFont(fntText);
        add(pnlBalance);
        
        lblAccount = new JLabel("Account Title");
        lblAccount.setBounds(20, 30, 700, 50);
        lblAccount.setFont(fntText);
        pnlBalance.add(lblAccount);
        
        txtAccount = new JTextField(" ");
        txtAccount. setBounds(20, 70, 700 , 30);
        txtAccount.setFont(fntText);
        txtAccount.setBackground(Color.white);
        pnlBalance.add(txtAccount);
        
        lblHolder = new JLabel("Account Holder Name");
        lblHolder.setBounds(750, 30, 700, 50);
        lblHolder.setFont(fntText);
        pnlBalance.add(lblHolder);
        
        txtHolder = new JTextField(" ");
        txtHolder. setBounds(750, 70, 700 , 30);
        txtHolder.setFont(fntText);
        txtHolder.setBackground(Color.white);
        pnlBalance.add(txtHolder);
        
        lblAccount = new JLabel("Account Number");
        lblAccount.setBounds(20, 100, 700, 50);
        lblAccount.setFont(fntText);
        pnlBalance.add(lblAccount);
        
        txtAccount = new JTextField(" ");
        txtAccount. setBounds(20, 140, 700 , 30);
        txtAccount.setFont(fntText);
        txtAccount.setBackground(Color.white);
        pnlBalance.add(txtAccount);
        
        lblHolder = new JLabel("Current Balance");
        lblHolder.setBounds(750, 100, 700, 50);
        lblHolder.setFont(fntText);
        pnlBalance.add(lblHolder);
        
        txtHolder = new JTextField(" ");
        txtHolder. setBounds(750, 140, 700 , 30);
        txtHolder.setFont(fntText);
        txtHolder.setBackground(Color.white);
        pnlBalance.add(txtHolder);
        }
    
    }
}
