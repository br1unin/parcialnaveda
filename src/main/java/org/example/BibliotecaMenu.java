package org.example;

import org.example.dao.AutorDAO;
import org.example.dao.LibroDAO;
import org.example.model.Autor;
import org.example.model.Libro;

import java.util.Scanner;

@SuppressWarnings("ALL")
public class BibliotecaMenu {
    private final Scanner scanner = new Scanner(System.in);
    private final AutorDAO autorDao = new AutorDAO();
    private final LibroDAO libroDao = new LibroDAO();

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== MENÚ BIBLIOTECA ===");
            System.out.println("1. Ingresar un autor");
            System.out.println("2. Ingresar un libro");
            System.out.println("3. Buscar un autor");
            System.out.println("4. Buscar un libro");
            System.out.println("5. Listar todos los autores");
            System.out.println("6. Listar todos los libros");
            System.out.println("7. Actualizar un autor");
            System.out.println("8. Actualizar un libro");
            System.out.println("9. Eliminar un autor");
            System.out.println("10. Eliminar un libro");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1 -> ingresarAutor();
                case 2 -> ingresarLibro();
                case 3 -> buscarAutor();
                case 4 -> buscarLibro();
                case 5 -> listarAutores();
                case 6 -> listarLibros();
                case 7 -> actualizarAutor();
                case 8 -> actualizarLibro();
                case 9 -> eliminarAutor();
                case 10 -> eliminarLibro();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);
        util.Log.debug("Saliendo del programa");
    }
    // MÉTODOS PARA AUTORES

    private void ingresarAutor() {
        System.out.print("Ingrese ID del autor: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese nombre del autor: ");
        String nombre = scanner.nextLine();
        autorDao.insertar(new Autor(id, nombre));
        System.out.println("Autor ingresado correctamente.");
    }

    private void buscarAutor() {
        System.out.print("Ingrese ID del autor: ");
        int id = scanner.nextInt();
        Autor autor = autorDao.buscarPorId(id);
        System.out.println(autor != null ? autor : "Autor no encontrado.");
    }

    private void listarAutores() {
        for (Autor autor : autorDao.listarTodos()) {
            System.out.println(autor);
        }
    }

    private void actualizarAutor() {
        System.out.print("Ingrese ID del autor a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese nuevo nombre del autor: ");
        String nuevoNombre = scanner.nextLine();
        Autor autor = new Autor(id, nuevoNombre);
        boolean actualizado = autorDao.actualizar(autor);
        System.out.println(actualizado ? "Autor actualizado." : "No se encontró el autor.");
    }

    private void eliminarAutor() {
        System.out.print("Ingrese ID del autor a eliminar: ");
        int id = scanner.nextInt();
        Autor autor = autorDao.buscarPorId(id);
        if (autor != null && autorDao.eliminar(autor)) {
            System.out.println("Autor eliminado.");
        } else {
            System.out.println("Autor no encontrado.");
        }
    }

    // MÉTODOS PARA LIBROS

    private void ingresarLibro() {
        System.out.print("Ingrese ID del libro: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese título del libro: ");
        String titulo = scanner.nextLine();
        libroDao.insertar(new Libro(id, titulo));
        System.out.println("Libro ingresado correctamente.");
    }

    private void buscarLibro() {
        System.out.print("Ingrese ID del libro: ");
        int id = scanner.nextInt();
        Libro libro = libroDao.buscarPorId(id);
        System.out.println(libro != null ? libro : "Libro no encontrado.");
    }

    private void listarLibros() {
        for (Libro libro : libroDao.listarTodos()) {
            System.out.println(libro);
        }
    }

    private void actualizarLibro() {
        System.out.print("Ingrese ID del libro a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese nuevo título del libro: ");
        String nuevoTitulo = scanner.nextLine();
        Libro libro = new Libro(id, nuevoTitulo);
        boolean actualizado = libroDao.actualizar(libro);
        System.out.println(actualizado ? "Libro actualizado." : "No se encontró el libro.");
    }

    private void eliminarLibro() {
        System.out.print("Ingrese ID del libro a eliminar: ");
        int id = scanner.nextInt();
        Libro libro = libroDao.buscarPorId(id);
        if (libro != null && libroDao.eliminar(libro)) {
            System.out.println("Libro eliminado.");
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

}