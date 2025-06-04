package org.example.dao;

import org.example.model.Libro;
import org.example.util.ConexionBD;
import util.Log;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO implements GenericDAO<Libro> {

    @Override
    public boolean insertar(Libro libro) {
        String sql = "INSERT INTO Libro (numero, titulo, clasificacion, tema) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = ConexionBD.obtenerConexion().prepareStatement(sql)) {

            stmt.setInt(1, libro.getNumero());
            stmt.setString(2, libro.getTitulo());
            stmt.setString(3, libro.getClasificacion());
            stmt.setString(4, libro.getTema());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            Log.error("Error al insertar libro", e);
            return false;
        }
    }

    @Override
    public Libro buscarPorId(int numero) {
        String sql = "SELECT * FROM Libro WHERE numero = ?";
        try (PreparedStatement stmt = ConexionBD.obtenerConexion().prepareStatement(sql)) {

            stmt.setInt(1, numero);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Libro(
                        rs.getString("titulo"),
                        rs.getInt("numero"),
                        rs.getString("clasificacion"),
                        rs.getString("tema")
                );
            }

        } catch (SQLException e) {
            Log.error("Error al buscar libro por número", e);
        }
        return null;
    }

    @Override
    public boolean actualizar(Libro libro) {
        String sql = "UPDATE Libro SET titulo = ?, clasificacion = ?, tema = ? WHERE numero = ?";
        try (PreparedStatement stmt = ConexionBD.obtenerConexion().prepareStatement(sql)) {

            stmt.setString(1, libro.getTitulo());
            stmt.setString(2, libro.getClasificacion());
            stmt.setString(3, libro.getTema());
            stmt.setInt(4, libro.getNumero());

            int filas = stmt.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            Log.error("Error al actualizar libro", e);
            return false;
        }
    }

    @Override
    public boolean eliminar(Libro libro) {
        String sql = "DELETE FROM Libro WHERE numero = ?";
        try (PreparedStatement stmt = ConexionBD.obtenerConexion().prepareStatement(sql)) {

            stmt.setInt(1, libro.getNumero());
            int filas = stmt.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            Log.error("Error al eliminar libro", e);
            return false;
        }
    }

    @Override
    public List<Libro> listarTodos() {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM Libro";

        try (Statement stmt = ConexionBD.obtenerConexion().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                libros.add(new Libro(
                        rs.getString("titulo"),
                        rs.getInt("numero"),
                        rs.getString("clasificacion"),
                        rs.getString("tema")
                ));
            }

        } catch (SQLException e) {
            Log.error("Error al listar libros", e);
        }

        return libros;
    }
}

