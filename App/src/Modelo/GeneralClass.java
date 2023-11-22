/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDateTime;

/**
 *
 * @author diego
 */
public abstract class GeneralClass implements Comparable<GeneralClass>{

    Integer Id;
    String Nombre;
    LocalDateTime Auth_CreadoFecha, Auth_ActualizadoFecha;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public LocalDateTime getAuth_CreadoFecha() {
        return Auth_CreadoFecha;
    }

    public void setAuth_CreadoFecha(LocalDateTime Auth_CreadoFecha) {
        this.Auth_CreadoFecha = Auth_CreadoFecha;
    }

    public LocalDateTime getAuth_ActualizadoFecha() {
        return Auth_ActualizadoFecha;
    }

    public void setAuth_ActualizadoFecha(LocalDateTime Auth_ActualizadoFecha) {
        this.Auth_ActualizadoFecha = Auth_ActualizadoFecha;
    }

    @Override
    public int compareTo(GeneralClass o){
        return this.getId().compareTo(o.getId());
    }
    
}
