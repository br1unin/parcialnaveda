package org.example.dao;

import org.example.model.Autor;
import org.example.util.ConexionBD;
import util.Log;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutorDAO implements GenericDAO<Autor> {

    @Override
    public boolean insertar(Autor autor) {
        String sql = "INSERT INTO Autor (id, nombre) VALUES (?, ?)";
        try (PreparedStatement stmt = ConexionBD.obtenerConexion().prepareStatement(sql)) {

            stmt.setInt(1, autor.getId());
            stmt.setString(2, autor.getNombre());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            Log.error("Error al insertar autor", e);
            return false;
        }
    }

    @Override
    public Autor buscarPorId(int id) {
        String sql = "SELECT * FROM Autor WHERE id = ?";
        try (PreparedStatement stmt = ConexionBD.obtenerConexion().prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Autor(rs.getInt("id"), rs.getString("nombre"));
            }

        } catch (SQLException e) {
            Log.error("Error al buscar autor por ID", e);
        }
        return null;
    }

    @Override
    public boolean actualizar(Autor autor) {
        String sql = "UPDATE Autor SET nombre = ? WHERE id = ?";
        try (PreparedStatement stmt = ConexionBD.obtenerConexion().prepareStatement(sql)) {

            stmt.setString(1, autor.getNombre());
            stmt.setInt(2, autor.getId());

            int filas = stmt.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            Log.error("Error al actualizar autor", e);
            return false;
        }
    }

    @Override
    public boolean eliminar(Autor autor) {
        String sql = "DELETE FROM Autor WHERE id = ?";
        try (PreparedStatement stmt = ConexionBD.obtenerConexion().prepareStatement(sql)) {

            stmt.setInt(1, autor.getId());
            int filas = stmt.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            Log.error("Error al eliminar autor", e);
            return false;
        }
    }

    @Override
    public List<Autor> listarTodos() {
        List<Autor> autores = new ArrayList<>();
        String sql = "SELECT * FROM Autor";

        try (Statement stmt = ConexionBD.obtenerConexion().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                autores.add(new Autor(rs.getInt("id"), rs.getString("nombre")));
            }

        } catch (SQLException e) {
            Log.error("Error al listar autores", e);
        }

        return autores;
    }
}
