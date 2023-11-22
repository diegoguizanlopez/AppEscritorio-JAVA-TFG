/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Útil;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author diego
 */
public class HiloGestorNotificaciones extends Thread{

    JLabel label;
    String text;
    boolean bueno;

    public HiloGestorNotificaciones(JLabel label, String text, boolean bueno) {
        this.label = label;
        this.text = text;
        this.bueno = bueno;
    }

    
    
    
    @Override
    public void run() {
        label.setText(text);
        if(bueno){
            label.setForeground(Color.green);
        }else{
            label.setForeground(Color.red);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloGestorNotificaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        label.setText("");
        
    }
    
}
