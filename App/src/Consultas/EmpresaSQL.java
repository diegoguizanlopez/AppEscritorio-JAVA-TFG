/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Consultas;

import Connector.ConexionSQL;
import Modelo.Empresas;
import Modelo.VideoJuegos;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class EmpresaSQL {

    public static ArrayList<Empresas> BuscarEmpresa(String column, String cod, String orderBy) {
        ArrayList<Empresas> list = new ArrayList<>();
        column = column == null ? "1" : column;
        cod = cod == null ? "1" : cod;
        orderBy = orderBy == null ? "Id" : orderBy;
        try ( Statement st = ConexionSQL.getBD().createStatement())
        {
            ResultSet rs = st.executeQuery("Select * from Empresa where " + column + " = '" + cod + "' Order by " + orderBy);
            while (rs.next())
            {
                list.add(new Empresas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getTimestamp(5).toLocalDateTime(), (rs.getTimestamp(6) == null ? null : rs.getTimestamp(6).toLocalDateTime())));
            }
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return list;
    }

    public static void Anhadir(String Nombre, String Desc, InputStream EmpresaImagen) {
        int id = Generales.GetNextID("Empresa");
        try ( PreparedStatement ps = ConexionSQL.getBD().prepareStatement("Insert into Empresa(Nombre,Descripcion,Foto,Auth_CreadoFecha) Values(?,?,?,?)"))
        {
            Server_FTP.InsertarServer("Empresas", EmpresaImagen, id);
            ps.setString(1, Nombre);
            ps.setString(2, Desc);
            ps.setString(3, id + ".png");
            ps.setObject(4, LocalDateTime.now());
            ps.executeUpdate();
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void Update(String Nombre, String Desc, Integer id, InputStream EmpresaImagen) {
        try ( PreparedStatement ps = ConexionSQL.getBD().prepareStatement("Update Empresa set Nombre=? , Descripcion=?,  Auth_ActualizadoFecha=? where Id=?"))
        {
            ps.setString(1, Nombre);
            ps.setString(2, Desc);
            ps.setObject(3, LocalDateTime.now());
            ps.setInt(4, id);
            ps.executeUpdate();
            Server_FTP.InsertarServer("Empresas", EmpresaImagen, id);
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void BorrarEmpresa(String column, String value) {
        try ( PreparedStatement ps = ConexionSQL.getBD().prepareStatement("Delete from Empresa where " + column + " = " + value))
        {
            ps.executeUpdate();
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void AnhadirVideoJuego(Empresas LocalEmpresa, Enumeration<VideoJuegos> values) {
        Iterator<VideoJuegos> it = values.asIterator();
        StringBuilder cons = new StringBuilder("Values ");
        while (it.hasNext())
        {
            VideoJuegos v = it.next();
            cons.append("(").append(v.getId()).append(",").append(LocalEmpresa.getId()).append("),");
        }
        cons.delete(cons.length()-1, cons.length());
        try ( PreparedStatement ps = ConexionSQL.getBD().prepareStatement("Insert into VideoJuegos_Empresa " + cons))
        {
            ps.executeUpdate();
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
