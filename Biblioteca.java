package Gestion_Biblioteca;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Libro> libros;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Prestamo> prestamos;

    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(ArrayList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public void registrarLibro(Libro libro) {
        libros.add(libro);
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void realizarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    public void devolverLibro(Prestamo prestamo) {
        prestamos.remove(prestamo);
    }

    public void mostrarLibros() {
        for (Libro libro : libros) {
            libro.mostrarInfo();
        }
    }
}
