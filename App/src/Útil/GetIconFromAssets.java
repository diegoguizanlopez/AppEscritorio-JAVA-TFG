/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Útil;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author diego
 */
public class GetIconFromAssets {

    public static ImageIcon GetIcon(InputStream ruta) {
        ImageIcon imageIco;
        try {
            imageIco = new ImageIcon(ImageIO.read(ruta));
            Image image = imageIco.getImage();
            Image newimg = image.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
            return new ImageIcon(newimg);
        } catch (IOException ex) {
            Logger.getLogger(GetIconFromAssets.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
