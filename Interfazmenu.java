package Gestion_Biblioteca;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Interfazmenu {
    private JFrame frame;
    private JTextField usuarioField;
    private JTextField idField;
    private JTextField libroField;
    private JTextField autorField;
    private JTextField categoriaField;
    private Biblioteca biblioteca;

    public Interfazmenu() {
        biblioteca = new Biblioteca(); // Instancia de la biblioteca

        frame = new JFrame("Biblioteca Socrática");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(253, 245, 230)); // Color de fondo

        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        northPanel.setBackground(new Color(253, 245, 230));
        ImageIcon icon = new ImageIcon(getClass().getResource("Biblioteca.png"));
        JLabel imagenLabel = new JLabel(icon);
        northPanel.add(imagenLabel);
        frame.add(northPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBackground(new Color(253, 245, 230));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Campos y etiquetas
        JLabel usuarioLabel = new JLabel("Nombre de Usuario:");
        usuarioLabel.setFont(new Font("Helvetica", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(usuarioLabel, gbc);

        usuarioField = new JTextField(20);
        usuarioField.setBackground(new Color(255, 248, 220));
        gbc.gridx = 1;
        gbc.gridy = 0;
        centerPanel.add(usuarioField, gbc);

        JLabel idLabel = new JLabel("Identificación:");
        idLabel.setFont(new Font("Helvetica", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        centerPanel.add(idLabel, gbc);

        idField = new JTextField(20);
        idField.setBackground(new Color(255, 248, 220));
        gbc.gridx = 1;
        gbc.gridy = 1;
        centerPanel.add(idField, gbc);

        JLabel libroLabel = new JLabel("Título del Libro:");
        libroLabel.setFont(new Font("Helvetica", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        centerPanel.add(libroLabel, gbc);

        libroField = new JTextField(20);
        libroField.setBackground(new Color(255, 248, 220));
        gbc.gridx = 1;
        gbc.gridy = 2;
        centerPanel.add(libroField, gbc);

        JLabel autorLabel = new JLabel("Autor del Libro:");
        autorLabel.setFont(new Font("Helvetica", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 3;
        centerPanel.add(autorLabel, gbc);

        autorField = new JTextField(20);
        autorField.setBackground(new Color(255, 248, 220));
        gbc.gridx = 1;
        gbc.gridy = 3;
        centerPanel.add(autorField, gbc);

        JLabel categoriaLabel = new JLabel("Categoría:");
        categoriaLabel.setFont(new Font("Helvetica", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 4;
        centerPanel.add(categoriaLabel, gbc);

        categoriaField = new JTextField(20);
        categoriaField.setBackground(new Color(255, 248, 220));
        gbc.gridx = 1;
        gbc.gridy = 4;
        centerPanel.add(categoriaField, gbc);

        // Botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.setBackground(new Color(253, 245, 230));

        JButton prestamoButton = new JButton("Realizar Préstamo");
        prestamoButton.setBackground(new Color(227, 197, 101));
        prestamoButton.setForeground(new Color(139, 69, 19));
        prestamoButton.setFont(new Font("Helvetica", Font.BOLD, 14));
        prestamoButton.setFocusPainted(false);
        prestamoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarPrestamo();
            }
        });
        buttonPanel.add(prestamoButton);

        JButton mostrarRegistrosButton = new JButton("Mostrar Registros");
        mostrarRegistrosButton.setBackground(new Color(227, 197, 101));
        mostrarRegistrosButton.setForeground(new Color(139, 69, 19));
        mostrarRegistrosButton.setFont(new Font("Helvetica", Font.BOLD, 14));
        mostrarRegistrosButton.setFocusPainted(false);
        mostrarRegistrosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarRegistros();
            }
        });
        buttonPanel.add(mostrarRegistrosButton);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        centerPanel.add(buttonPanel, gbc);

        frame.add(centerPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void realizarPrestamo() {
        String nombreUsuario = usuarioField.getText();
        String idUsuarioStr = idField.getText();

        // Validar si idUsuarioStr es numérico antes de intentar convertirlo
        int idUsuario;
        try {
            idUsuario = Integer.parseInt(idUsuarioStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "El campo Identificación debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si no se puede convertir a entero
        }

        String nombreLibro = libroField.getText();
        String autorLibro = autorField.getText();
        String categoriaLibro = categoriaField.getText();

        Autor autor = new Autor(autorLibro, "");
        Categoria categoria = new Categoria(categoriaLibro);
        Libro libro = new Libro(nombreLibro, "", autor, categoria);
        Usuario usuario = new Usuario(nombreUsuario, "", idUsuario);

        biblioteca.realizarPrestamo(new Prestamo(libro, usuario, new Date(), null));

        JOptionPane.showMessageDialog(frame, "El préstamo se realizó con éxito.");

        usuarioField.setText("");
        idField.setText("");
        libroField.setText("");
        autorField.setText("");
        categoriaField.setText("");
    }

    private void mostrarRegistros() {
        ArrayList<Prestamo> prestamos = biblioteca.getPrestamos();

        if (prestamos.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No hay préstamos registrados.", "Registros de Préstamos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder registrosTexto = new StringBuilder();
        for (Prestamo prestamo : prestamos) {
            registrosTexto.append("Nombre de Usuario: ").append(prestamo.getUsuario().getNombre()).append("\n");
            registrosTexto.append("Identificación: ").append(prestamo.getUsuario().getIdUsuario()).append("\n");
            registrosTexto.append("Título del Libro: ").append(prestamo.getLibro().getTitulo()).append("\n");
            registrosTexto.append("Autor del Libro: ").append(prestamo.getLibro().getAutor().getNombre()).append("\n");
            registrosTexto.append("Categoría: ").append(prestamo.getLibro().getCategoria().getNombre()).append("\n");
            registrosTexto.append("-".repeat(40)).append("\n");
        }

        JOptionPane.showMessageDialog(frame, registrosTexto.toString(), "Registros de Préstamos", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Interfazmenu::new);
    }
}
