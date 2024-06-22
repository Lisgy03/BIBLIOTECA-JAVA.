package Gestion_Biblioteca;

public class Usuario {
    private String nombre;
    private String apellido;
    private int idUsuario;

    public Usuario(String nombre, String apellido, int idUsuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idUsuario = idUsuario;
    }

    public Usuario(String nombre, String apellido) {
        this(nombre, apellido, 0); // Llamar al constructor principal con un valor por defecto para idUsuario
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
