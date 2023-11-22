/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author diego
 */
public class VideoJuegos extends GeneralClass{
    String Descripcion,Foto;
    Generos genero;

    public VideoJuegos() {
    }
    
    public VideoJuegos(Integer Id, String Nombre, String Descripcion, String Foto, Generos genero, LocalDateTime Auth_CreadoFecha, LocalDateTime Auth_ActualizadoFecha) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Foto = Foto;
        this.genero = genero;
        this.Auth_CreadoFecha = Auth_CreadoFecha;
        this.Auth_ActualizadoFecha = Auth_ActualizadoFecha;
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

    public Generos getGenero() {
        return genero;
    }

    public void setGenero(Generos genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return Id+" - "+Nombre;
    }
    
}
