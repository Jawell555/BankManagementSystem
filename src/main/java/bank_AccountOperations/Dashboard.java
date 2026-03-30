package bank_AccountOperations;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JPanel {
    
    public Dashboard() {
        
        setLayout(null);
        setBounds(0, 0, 1670, 1080);
        JLabel lblTitle = new JLabel("Dito Dashboard ni Bembank");
        lblTitle.setBounds(50, 50, 700, 50);
        add(lblTitle);

    }
}