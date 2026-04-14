/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankManagementMain;
import bank_Dashboard.employeeDashboard;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class empSidebarPanelFrame extends JFrame {

    private JPanel window;
    private AppHeaderPanel header;

    public empSidebarPanelFrame() {
        setTitle("SUMMIT PHILBANK");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        
        //Set Image Icon
        ImageIcon icon = new ImageIcon(getClass().getResource("/bank_logo.png"));
        setIconImage(icon.getImage());

        // Shared header
        header = new AppHeaderPanel();
        header.setBounds(0, 0, 1920, 60);
        add(header);

        // Sidebar
        empSidebarPanel sidebar = new empSidebarPanel(this);
        sidebar.setBounds(0, 60, 250, 1020); 
        add(sidebar);

        // Main content area
        window = new JPanel();
        window.setLayout(null);
        window.setBounds(250, 60, 1670, 1020); 
        window.setBackground(new Color(235, 235, 235));
        add(window);

        turnPage(new employeeDashboard());
    }

    public void turnPage(JPanel newPage) {
        window.removeAll();
        newPage.setBounds(0, 0, 1670, 1020);
        window.add(newPage);
        window.revalidate();
        window.repaint();
    }
}