package modelo;

public class Servicio {

    private int id;                  //PK
    private String dniDoctor;
    private String nombre;
    private double precio;

    public Servicio() {
        id = 0;
        dniDoctor = "";
        nombre = "";
        precio = 0.0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDniDoctor() {
        return dniDoctor;
    }

    public void setDniDoctor(String dni) {
        this.dniDoctor = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
