package Gestion_Biblioteca;

public class Autor {
    private String nombre;
    private String apellido;

    public Autor(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void mostrarInfo() {
        System.out.println("Su nombre es: " + nombre);
        System.out.println("Su apellido es: " + apellido);
    }

    public static void main(String[] args) {
        Autor autor = new Autor("Gabriel", "García Márquez");
        autor.mostrarInfo();
        autor.setNombre("Mario");
        autor.setApellido("Vargas Llosa");
        autor.mostrarInfo();
    }
}
