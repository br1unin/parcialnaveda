package org.example;

import org.example.util.ConexionBD;

public class Main {
    public static void main(String[] args) {
        if (ConexionBD.inicializar()) {
            BibliotecaMenu bibliotecaMenu = new BibliotecaMenu();
            bibliotecaMenu.mostrarMenu(); // <- el bucle termina cuando el usuario elige "0"
            ConexionBD.cerrarConexion(); // <- solo aquí es seguro cerrar
        } else {
            System.out.println("No se pudo inicializar la base de datos.");
        }
    }
}