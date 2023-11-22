/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class PersonalizedExc extends Exception{

    public PersonalizedExc() {
    }

    public PersonalizedExc(String message) {
        super(message);
    }
    
    public  void GetError(String error){
        JOptionPane.showMessageDialog(null, error,"ERROR",JOptionPane.ERROR_MESSAGE);
    }
            
}

