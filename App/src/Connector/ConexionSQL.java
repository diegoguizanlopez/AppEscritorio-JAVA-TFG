/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connector;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class ConexionSQL {

    private static Connection con;
    private static boolean isConected;

    public static boolean Conectar(String ip, String port, String bd, String user, String password) {
        try
        {
            con = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + bd, user, password);
            isConected=true;
        } catch (SQLException e)
        {
            isConected=false;
            //JOptionPane.showMessageDialog(null,"CONNECTION SQL ERROR: "+e.getMessage());
            return false;
        }
        return true;
    }

    public static Connection getBD() {
        return con;
    }

    public static void setCon(Connection con) {
        ConexionSQL.con = con;
    }

    public static void Cerrar() {
        try
        {
            if (con != null)
            {
                con.close();
                isConected=false;
            }
        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "CLOSE SQL ERROR: " + e.getMessage());
        }
    }

    public static boolean IsConected() {
        return isConected;
    }
    
}
