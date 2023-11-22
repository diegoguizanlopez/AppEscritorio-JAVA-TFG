/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Útil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.net.examples.Main;

/**
 *
 * @author diegogl
 */
public class PropertiesCache {

    public static ResourceBundle Idiomas = ResourceBundle.getBundle("Ajustes.Idiomas");
    public static Properties BBDD = new Properties();

    private PropertiesCache() {
        try {
            //Private constructor to restrict new instances
            BBDD.load(new FileInputStream("./BBDD.properties"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    //Bill Pugh Solution for singleton pattern
    private static class LazyHolder {

        private static final PropertiesCache INSTANCE = new PropertiesCache();
    }

    public static PropertiesCache getInstance() {
        return LazyHolder.INSTANCE;
    }

    public String getProperty(String key) {
        return BBDD.getProperty(key);
    }

    public Set<String> getAllPropertyNames() {
        return BBDD.stringPropertyNames();
    }

    public boolean containsKey(String key) {
        return BBDD.containsKey(key);
    }

    public void setProperty(String key, String value) {
        BBDD.setProperty(key, value);
    }

    public void flush() throws FileNotFoundException, IOException, URISyntaxException {
        try (final OutputStream outputstream
                = new FileOutputStream(new File("./BBDD.properties"))) {
            BBDD.store(outputstream, "File Updated");
            outputstream.close();
        }
    }
}
