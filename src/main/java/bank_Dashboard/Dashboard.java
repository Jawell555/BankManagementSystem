package bank_Dashboard;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JPanel {
    
    public Dashboard() {
        
        setLayout(null);
        setBounds(0, 0, 1670, 1080);
        JLabel lblTitle = new JLabel("Dash");
        lblTitle.setBounds(50, 50, 700, 50);
        add(lblTitle);

    }
}