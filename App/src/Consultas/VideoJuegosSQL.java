/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Consultas;

import Connector.ConexionSQL;
import Modelo.Empresas;
import Modelo.Generos;
import Modelo.VideoJuegos;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import Útil.ConsultaNullChecker;

/**
 *
 * @author diego
 */
public class VideoJuegosSQL {

    public static ArrayList<VideoJuegos> BuscarVideoJuego(String limit, String column, String cod, String auth_CreadoFecha_desc) {
        ArrayList<VideoJuegos> ls = new ArrayList<>();
        column = ConsultaNullChecker.GetString(column);
        cod = ConsultaNullChecker.GetString(cod);
        limit = limit == null ? "" : " Limit " + limit;
        try (PreparedStatement ps = ConexionSQL.getBD().prepareStatement("Select * from VideoJuegos where " + column + "=? order by " + auth_CreadoFecha_desc + limit)) {
            ps.setString(1, cod);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ls.add(new VideoJuegos(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), GenerosSQL.BuscarGenero("Id", String.valueOf(rs.getInt(5)), null).get(0), rs.getTimestamp(6).toLocalDateTime(), (rs.getTimestamp(7) == null ? null : rs.getTimestamp(7).toLocalDateTime())));
            }
            return ls;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    public static void Anhadir(String Nombre, String Desc, InputStream Icon, Generos g) {
        int id = Generales.GetNextID("VideoJuegos");
        try (PreparedStatement ps = ConexionSQL.getBD().prepareStatement("Insert into VideoJuegos(Nombre,Descripcion,Foto,Genero,Auth_CreadoFecha) Values(?,?,?,?,?)")) {
            Server_FTP.InsertarServer("VideoJuegos", Icon, id);
            ps.setString(1, Nombre);
            ps.setString(2, Desc);
            ps.setString(3, id + ".png");
            ps.setInt(4, g.getId());
            ps.setObject(5, LocalDateTime.now());
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void InsertarVideoJuegos_Empresa(VideoJuegos v, Enumeration<Empresas> values) {
        Iterator<Empresas> it = values.asIterator();
        StringBuilder cons = new StringBuilder("Values ");
        while (it.hasNext()) {
            Empresas es = it.next();
            cons.append("(").append(v.getId()).append(",").append(es.getId()).append("),");
        }
        cons = cons.delete(cons.length() - 1, cons.length());
        try (PreparedStatement ps = ConexionSQL.getBD().prepareStatement("Insert into VideoJuegos_Empresa " + cons)) {
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void Update(Integer id, String nombre, String desc, Integer generoId, InputStream VideoJuegoImagen) {
        try (PreparedStatement ps = ConexionSQL.getBD().prepareStatement("Update VideoJuegos set Nombre=? , Descripcion=?, Genero=?, Auth_ActualizadoFecha=? where Id=?")) {
            ps.setString(1, nombre);
            ps.setString(2, desc);
            ps.setInt(3, generoId);
            ps.setObject(4, LocalDateTime.now());
            ps.setInt(5, id);
            ps.executeUpdate();
            Server_FTP.InsertarServer("VideoJuegos", VideoJuegoImagen, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void BorrarEmpresa(VideoJuegos v, Enumeration<Empresas> deleteValues) throws Exception {
        Iterator<Empresas> it = deleteValues.asIterator();
        StringBuilder cons = new StringBuilder("-1");
        while (it.hasNext()) {
            Empresas es = it.next();
            cons.append(",").append(es.getId());
        }
        try (PreparedStatement ps = ConexionSQL.getBD().prepareStatement("Delete from VideoJuegos_Empresa  where IdV = ? and IdE in (" + cons + ")")) {
            ps.setInt(1, v.getId());
            ps.executeUpdate();
        }
    }

    public static ResultSet BuscarEmpresa(String column, String id, String order) {
        column = ConsultaNullChecker.GetString(column);
        id = ConsultaNullChecker.GetString(id);
        try {
            PreparedStatement ps = ConexionSQL.getBD().prepareStatement("Select * from VideoJuegos_Empresa where " + column + "=? order by " + order);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    public static void BorrarVideoJuego(String column, String value) {
        try (PreparedStatement ps = ConexionSQL.getBD().prepareStatement("Delete from VideoJuegos  where " + column + "= ? ")) {
            ps.setString(1, value);
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void BorrarRelacion(String columnV, String relaV, String valueV, String columnE, String relaE, String valueE) throws Exception {
        columnV = ConsultaNullChecker.GetString(columnV);
        valueV = ConsultaNullChecker.GetString(valueV);
        relaV = relaV == null ? "=" : relaV;
        relaE = relaE == null ? "=" : relaE;
        columnE = ConsultaNullChecker.GetString(columnE);
        valueE = ConsultaNullChecker.GetString(valueE);
        try (PreparedStatement ps = ConexionSQL.getBD().prepareStatement("Delete from VideoJuegos_Empresa where " + columnV + " " + relaV + valueV + " and " + columnE + " " + relaE + " " + valueE)) {
            ps.executeUpdate();
        }
    }

}
