package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author IVÁN-PC
 */
public class Cita {

    private int idServicio;
    private String dniCliente;
    private LocalDate fecha;
    private LocalTime hora;

    public Cita() {
        idServicio = 0;
        dniCliente = "";
        fecha = null;
        hora = null;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
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
