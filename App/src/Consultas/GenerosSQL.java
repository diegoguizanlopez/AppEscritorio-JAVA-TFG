/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Consultas;

import Connector.ConexionSQL;
import Modelo.GeneralClass;
import Modelo.Generos;
import Modelo.VideoJuegos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author diego
 */
public class GenerosSQL {

    public static ArrayList<Generos> BuscarGenero(String column, String cod, String orderBy) {
        ArrayList<Generos> list = new ArrayList<Generos>();
        column = column == null ? "1" : column;
        cod = cod == null ? "1" : cod;
        orderBy = orderBy == null ? "Id" : orderBy;
        try (Statement st = ConexionSQL.getBD().createStatement()) {
            ResultSet rs = st.executeQuery("Select * from Géneros where " + column + " = '" + cod + "' Order by " + orderBy);
            while (rs.next()) {
                list.add(new Generos(rs.getInt(1), rs.getString(2), rs.getTimestamp(3).toLocalDateTime(), (rs.getTimestamp(4) == null ? null : rs.getTimestamp(4).toLocalDateTime())));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return list;
    }

    public static void BorrarGenero(String column, String cod, ArrayList<VideoJuegos> list) throws Exception {
        Server_FTP.BorrarImagenes("VideoJuegos", (ArrayList<GeneralClass>) (Object) list);
        try (PreparedStatement ps = ConexionSQL.getBD().prepareStatement("Delete from Géneros where " + column + "=?")) {
            ps.setString(1, cod);
            ps.executeUpdate();
        }
    }

    public static void Anhadir(String nombre) {
        try (PreparedStatement ps = ConexionSQL.getBD().prepareStatement("Insert into Géneros(Nombre,Auth_CreadoFecha) Values(?,?)")) {
            ps.setString(1, nombre);
            ps.setObject(2, LocalDateTime.now());
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void Update(Integer id, String nombre) {
        try (PreparedStatement ps = ConexionSQL.getBD().prepareStatement("Update Géneros set Nombre=? ,Auth_ActualizadoFecha=? where Id=?")) {
            ps.setString(1, nombre);
            ps.setObject(2, LocalDateTime.now());
            ps.setInt(3, id);
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void BorrarVideoJuegos(String column, String clave) throws Exception {
        StringBuilder cadena = new StringBuilder();
        try (PreparedStatement ps = ConexionSQL.getBD().prepareStatement("Select Id from VideoJuegos where Genero = ?")) {
            ps.setString(1, clave);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                cadena.append(id).append(",");
                Interfaces.Interfaz.modelV.removeById(id);
                Interfaces.Interfaz.modelV_Insert.removeById(id);
            }
            if (!cadena.isEmpty()) {
                cadena = cadena.replace(cadena.length() - 1, cadena.length(), "");
                VideoJuegosSQL.BorrarRelacion("IdV", "in", "(" + cadena.toString() + ")", null, null, null);
            }
        }
        try (PreparedStatement ps = ConexionSQL.getBD().prepareStatement("Delete from VideoJuegos where " + column + " = ?")) {
            ps.setString(1, clave);
            ps.executeUpdate();
        }
    }
}
