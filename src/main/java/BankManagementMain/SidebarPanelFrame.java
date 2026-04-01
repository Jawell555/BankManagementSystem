package BankManagementMain;

import bank_Dashboard.Dashboard;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SidebarPanelFrame extends JFrame {

    private JPanel window; 

    public SidebarPanelFrame() {
        setTitle("SUMMIT PHILBANK");
        setSize(1920, 1080); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setLayout(null); 

        SidebarPanel sidebar = new SidebarPanel(this);
        add(sidebar);

        window = new JPanel();
        window.setLayout(null);
        window.setBounds(250, 0, 1670, 1080); 
        window.setBackground(new Color(235, 235, 235));
        
        add(window);

        turnPage(new Dashboard());
    }

    public void turnPage(JPanel newPage) {
        window.removeAll();        
        window.add(newPage);     
        window.revalidate();       
        window.repaint();           
    }
}