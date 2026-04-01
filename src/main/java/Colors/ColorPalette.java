/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colors;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author Ruell
 */
public class ColorPalette {
    //Color Pallete Mas Mataas, mas madilim

    public static final Color Blue5 = Color.decode("#031B42");
    public static final Color Blue4 = Color.decode("#0E447D");
    public static final Color Blue3 = Color.decode("#4878A5");
    public static final Color Blue2 = Color.decode("#C1D2E3");
    public static final Color Blue1 = Color.decode("#E1F4FF");
    public static final Color redPastel = Color.decode("#EA7B7B");
    public static final Color Gray = new Color(225, 225, 225);

    //panel border
    public static TitledBorder panelBorder(String borderName) {
        return BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Blue4, 3), borderName);
    }
}
