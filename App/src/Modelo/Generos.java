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
public class Generos extends GeneralClass{

    public Generos() {
    }

    public Generos(Integer Id, String Nombre,LocalDateTime Auth_CreadoFecha, LocalDateTime Auth_ActualizadoFecha) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Auth_CreadoFecha = Auth_CreadoFecha;
        this.Auth_ActualizadoFecha = Auth_ActualizadoFecha;
    }

    @Override
    public String toString() {
        return Id+"   "+Nombre;
    }
    
}
