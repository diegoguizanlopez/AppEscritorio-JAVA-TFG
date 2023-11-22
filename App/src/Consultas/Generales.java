/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Consultas;

import Connector.ConexionSQL;
import Modelo.Empresas;
import Modelo.GeneralClass;
import Modelo.Generos;
import Modelo.VideoJuegos;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class Generales {

    public static Integer GetNextID(String tableName) {
        try (PreparedStatement ps = ConexionSQL.getBD().prepareStatement("""
                                                                        SELECT AUTO_INCREMENT FROM information_schema.TABLES
                                                                        WHERE TABLE_SCHEMA = 'VideoJuegos'
                                                                        AND TABLE_NAME = ?
                                                                        """)) {
            ps.setString(1, tableName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return 0;
    }

    public static ArrayList<GeneralClass> GetBusqueda(String column, String id, String nombre, LocalDate fechaCreación, LocalDate fechaActualización) throws Exception {
        StringBuilder consulta = new StringBuilder();
        ArrayList<GeneralClass> list = new ArrayList<>();
        Statement cs = ConexionSQL.getBD().createStatement();
        if (!id.isEmpty()) {
            if (!consulta.isEmpty()) {
                consulta.append(" AND ");
            }
            consulta.append(" Id = ").append(id).append(" ");
        }
        if (!nombre.isEmpty()) {
            if (!consulta.isEmpty()) {
                consulta.append(" AND ");
            }
            consulta.append(" Nombre Like ('%").append(nombre).append("%') ");
        }
        if (fechaCreación != null) {
            if (!consulta.isEmpty()) {
                consulta.append(" AND ");
            }
            consulta.append(" str_to_date(Auth_CreadoFecha,'%Y-%m-%d') = '").append(Date.valueOf(fechaCreación)).append("' ");
        }
        if (fechaActualización != null) {
            if (!consulta.isEmpty()) {
                consulta.append(" AND ");
            }
            consulta.append(" str_to_date(Auth_ActualizadoFecha,'%Y-%m-%d') = '").append(Date.valueOf(fechaActualización)).append("' ");
        }
        if (!consulta.isEmpty()) {
            consulta.insert(0, " WHERE ");
        }
        ResultSet rs = cs.executeQuery("Select * from " + column + " " + consulta.toString());
        while (rs.next()) {
            if (column.equals("VideoJuegos")) {
                list.add(new VideoJuegos(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), GenerosSQL.BuscarGenero("Id", String.valueOf(rs.getInt(5)), null).get(0), rs.getTimestamp(6).toLocalDateTime(), (rs.getTimestamp(7) == null ? null : rs.getTimestamp(7).toLocalDateTime())));
            }
            if (column.equals("Géneros")) {
                list.add(new Generos(rs.getInt(1), rs.getString(2), rs.getTimestamp(3).toLocalDateTime(), (rs.getTimestamp(4) == null ? null : rs.getTimestamp(4).toLocalDateTime())));
            }
            if(column.equals("Empresa")){ 
                list.add(new Empresas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getTimestamp(5).toLocalDateTime(), (rs.getTimestamp(6) == null ? null : rs.getTimestamp(6).toLocalDateTime())));
            }
        }
        return list;
    }
}
