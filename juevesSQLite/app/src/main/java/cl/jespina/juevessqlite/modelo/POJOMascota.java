package cl.jespina.juevessqlite.modelo;

public class POJOMascota {
    private int id;
    private String nombre;
    private double peso;
    private String genero;

    public POJOMascota() {}

    public POJOMascota(String nombre, double peso, String genero) {
        this.nombre = nombre;
        this.peso = peso;
        this.genero = genero;
    }

    public POJOMascota(int id, String nombre, double peso, String genero) {
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
