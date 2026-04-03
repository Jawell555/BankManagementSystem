package BankManagementMain;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class ImagePanel extends JPanel {
    private Image backgroundImage;

    public ImagePanel(String path) {
        backgroundImage = new ImageIcon(getClass().getResource(path)).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}