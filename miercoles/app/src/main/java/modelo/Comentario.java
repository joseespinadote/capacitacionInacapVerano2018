package modelo;

public class Comentario {
    private String nombre;
    private String texto;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Comentario(String nombre, String texto) {
        this.nombre = nombre;
        this.texto = texto;
    }
}
