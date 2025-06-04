package org.example.model;

public class Libro {
    int numero;
    String titulo;
    String clasificacion;
    String tema;

    public Libro(String titulo, int numero, String clasificacion, String tema) {
        this.titulo = titulo;
        this.numero = numero;
        this.clasificacion = clasificacion;
        this.tema = tema;
    }

    public Libro(int numero, String titulo) {
        this.numero = numero;
        this.titulo = titulo;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public String getTema() {
        return tema;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "numero=" + numero +
                ", titulo='" + titulo + '\'' +
                ", clasificacion='" + clasificacion + '\'' +
                ", tema='" + tema + '\'' +
                '}';
    }
}
