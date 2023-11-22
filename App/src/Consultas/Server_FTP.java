/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Consultas;

import Modelo.GeneralClass;
import Vista.frmPadre;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import Útil.GetIconFromAssets;
import Útil.PropertiesCache;

/**
 *
 * @author diego
 */
public class Server_FTP {

    public static void InsertarServer(String carpeta, InputStream imagen, int id) throws IOException {
        FTPClient cliente = new FTPClient();
        String servFTP = PropertiesCache.BBDD.getProperty("ip"); // servidor FTP
        cliente.connect(servFTP);
        cliente.enterLocalPassiveMode();
        cliente.login("server", "79346626F");
        cliente.changeWorkingDirectory(carpeta);
        cliente.setFileType(FTPClient.BINARY_FILE_TYPE);
        BufferedInputStream in = new BufferedInputStream(imagen);
        cliente.storeFile(id + ".png", in);
        cliente.disconnect();
    }

    public static void GetImage(String carpeta, String cod, JLabel label, frmPadre frm) throws IOException, InterruptedException {
        FTPClient cliente = new FTPClient();
        String servFTP = PropertiesCache.BBDD.getProperty("ip"); // servidor FTP
        cliente.connect(servFTP);
        cliente.enterLocalPassiveMode();
        cliente.login("server", "79346626F");
        cliente.changeWorkingDirectory(carpeta);
        cliente.setFileType(FTPClient.BINARY_FILE_TYPE);
        FileOutputStream out = new FileOutputStream(new File("./Temp" + (carpeta.equals("VideoJuegos") ? "V" : "E") + ".png"));
        Runnable run = () -> {
            try {
                cliente.retrieveFile(cod + ".png", out);
            } catch (IOException ex) {
                Logger.getLogger(Server_FTP.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                label.setIcon(GetIconFromAssets.GetIcon(new FileInputStream(new File("./Temp" + (carpeta.equals("VideoJuegos") ? "V" : "E") + ".png"))));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Server_FTP.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    cliente.disconnect();
                } catch (IOException ex) {
                    Logger.getLogger(Server_FTP.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        cliente.setFileType(FTPClient.BINARY_FILE_TYPE);
        Thread t = new Thread(run);
        t.start();
    }

    public static void BorrarImage(String carpeta, String id) throws IOException {
        FTPClient cliente = new FTPClient();
        String servFTP = PropertiesCache.BBDD.getProperty("ip"); // servidor FTP
        cliente.connect(servFTP);
        cliente.setFileType(FTPClient.BINARY_FILE_TYPE);
        cliente.enterLocalPassiveMode();
        cliente.login("server", "79346626F");
        cliente.changeWorkingDirectory(carpeta);
        cliente.deleteFile(id + ".png");
        cliente.disconnect();
    }

    public static void BorrarImagenes(String carpeta, ArrayList<GeneralClass> list) throws IOException {
        FTPClient cliente = new FTPClient();
        String servFTP = PropertiesCache.BBDD.getProperty("ip"); // servidor FTP
        cliente.connect(servFTP);
        cliente.setFileType(FTPClient.BINARY_FILE_TYPE);
        cliente.enterLocalPassiveMode();
        cliente.login("server", "79346626F");
        cliente.changeWorkingDirectory(carpeta);
        for (GeneralClass generalClass : list) {
            cliente.deleteFile(generalClass.getId() + ".png");
        }
        cliente.disconnect();
    }
}
