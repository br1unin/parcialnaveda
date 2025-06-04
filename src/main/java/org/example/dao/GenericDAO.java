package org.example.dao;

import java.util.List;

public interface GenericDAO <E>{
    boolean insertar(E e);
    E buscarPorId(int id);
    boolean actualizar(E e);
    boolean eliminar(E e);
    List<E> listarTodos(); // <-- Método adicional necesario para el menú
}
