package Gestion_Biblioteca;

import java.util.Date;

public class Prestamo {
    private Libro libro;
    private Usuario usuario;
    private Date fechaPrestamo;
    private Date fechaDevolucion;

    public Prestamo(Libro libro, Usuario usuario, Date fechaPrestamo, Date fechaDevolucion) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public void mostrarInfo() {
        System.out.println("Libro: " + libro.getTitulo());
        System.out.println("Usuario: " + usuario.getNombre());
        System.out.println("Fecha de préstamo: " + fechaPrestamo);
        System.out.println("Fecha de devolución: " + fechaDevolucion);
    }

    public static void main(String[] args) {
        Libro libro = new Libro("Cien Años de Soledad", "978-3-16-148410-0", new Autor("Gabriel", "García Márquez"), new Categoria("Literatura"));
        Usuario usuario = new Usuario("Juan", "Pérez", 1);
        Date fechaPrestamo = new Date();
        Date fechaDevolucion = new Date(fechaPrestamo.getTime() + (1000 * 60 * 60 * 24 * 14));

        Prestamo prestamo = new Prestamo(libro, usuario, fechaPrestamo, fechaDevolucion);
        prestamo.mostrarInfo();
    }
}
