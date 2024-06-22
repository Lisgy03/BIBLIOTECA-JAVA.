package Gestion_Biblioteca;

public class Libro {
    private String titulo;
    private String isbn;
    private Autor autor;
    private Categoria categoria;

    public Libro(String titulo, String isbn, Autor autor, Categoria categoria) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void mostrarInfo() {
        System.out.println("Título: " + titulo);
        System.out.println("ISBN: " + isbn);
        System.out.println("Autor: " + autor.getNombre() + " " + autor.getApellido());
        System.out.println("Categoría: " + categoria.getNombre());
    }

    public static void main(String[] args) {
        Autor autor = new Autor("Gabriel", "García Márquez");
        Categoria categoria = new Categoria("Literatura");
        Libro libro = new Libro("Cien Años de Soledad", "978-3-16-148410-0", autor, categoria);
        libro.mostrarInfo();
    }
}
