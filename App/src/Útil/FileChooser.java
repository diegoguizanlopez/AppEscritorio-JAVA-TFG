/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Útil;

import Vista.frmPadre;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author diego
 */
public class FileChooser {

    public static ImageIcon SetNewIcon(JLabel txtImage, frmPadre aThis) {
        FileFilter imageFilter = new FileNameExtensionFilter(
                "Image files", ImageIO.getReaderFileSuffixes());
        JFileChooser jf = new JFileChooser();
        jf.setFileFilter(imageFilter);
        jf.showOpenDialog(aThis);
        File arFile = jf.getSelectedFile();
        if (arFile != null) {
            ImageIcon imageIco = new ImageIcon(arFile.getAbsolutePath()); //Sets the image to be displayed as an icon
            Image image = imageIco.getImage(); // transform it 
            Image newimg = image.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            imageIco = new ImageIcon(newimg);  // transform it back
            txtImage.setIcon(imageIco);
            return new ImageIcon(jf.getSelectedFile().getAbsolutePath());
        }
        return null;
    }

}
