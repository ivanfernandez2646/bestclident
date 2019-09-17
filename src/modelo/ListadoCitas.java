/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author IVÁN-PC
 */
public class ListadoCitas {
    
    private String dniCliente;
    private String nombreCliente;
    private String id_nombreServicio;
    private String dni_nombreDoctor;
    private LocalDate fecha;
    private LocalTime hora;

    public ListadoCitas() {
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getId_nombreServicio() {
        return id_nombreServicio;
    }

    public void setId_nombreServicio(String id_nombreServicio) {
        this.id_nombreServicio = id_nombreServicio;
    }

    public String getDni_nombreDoctor() {
        return dni_nombreDoctor;
    }

    public void setDni_nombreDoctor(String dni_nombreDoctor) {
        this.dni_nombreDoctor = dni_nombreDoctor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
}
