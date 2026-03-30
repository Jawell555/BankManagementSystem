package bank_AccountOperations;

import javax.swing.*;
import java.awt.*;

public class BembankMain extends JFrame {

    private JPanel window; 

    public BembankMain() {
        setTitle("BEMBANK");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
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
    
    public static void main(String[] args) {
            BembankMain bm = new BembankMain();
            bm.setVisible(true);
        };
    }
