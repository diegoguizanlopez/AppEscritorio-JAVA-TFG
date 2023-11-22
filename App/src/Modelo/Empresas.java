/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author diego
 */
public class Empresas extends GeneralClass {
    String  Descripcion, Foto;

    public Empresas(Integer Id, String Nombre, String Descripcion, String Foto, LocalDateTime Auth_CreadoFecha, LocalDateTime Auth_ActualizadoFecha) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Foto = Foto;
        this.Auth_CreadoFecha = Auth_CreadoFecha;
        this.Auth_ActualizadoFecha = Auth_ActualizadoFecha;
    }

    public Empresas() {
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String Foto) {
        this.Foto = Foto;
    }

    @Override
    public String toString() {
        return Id + " - " + Nombre;
    }

}
