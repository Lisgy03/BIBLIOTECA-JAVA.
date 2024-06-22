package Gestion_Biblioteca;

public class Categoria {
    private String nombre;

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
    }

    public static void main(String[] args) {
        Categoria categoria = new Categoria("Literatura");
        categoria.mostrarInfo();
        categoria.setNombre("Ciencia Ficción");
        categoria.mostrarInfo();
    }
}
