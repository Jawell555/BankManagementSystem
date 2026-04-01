/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colors;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Ruell
 */
public class ImagePanel extends JPanel{

        protected Image backgroundImage;
        
        public ImagePanel (String path){
            backgroundImage = new ImageIcon(getClass().getResource(path)).getImage();
        }
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(),getHeight(),this);
        }
    
}
