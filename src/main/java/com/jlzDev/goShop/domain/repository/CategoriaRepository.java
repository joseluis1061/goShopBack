package com.jlzDev.goShop.domain.repository;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define las operaciones disponibles para acceder y manipular categorías.
 */
public interface CategoriaRepository {
    /**
     * Obtiene todas las categorías.
     * @return Lista de categorías.
     */
    List<Object> getAll();

    /**
     * Obtiene todas las categorías activas.
     * @return Lista de categorías activas.
     */
    List<Object> getAllActive();

    /**
     * Busca una categoría por su ID.
     * @param categoriaId ID de la categoría a buscar.
     * @return Optional que contiene la categoría si existe.
     */
    Optional<Object> getCategoria(int categoriaId);

    /**
     * Busca una categoría por su nombre.
     * @param nombre Nombre de la categoría.
     * @return Optional que contiene la categoría si existe.
     */
    Optional<Object> getByNombre(String nombre);

    /**
     * Guarda o actualiza una categoría.
     * @param categoria Categoría a guardar o actualizar.
     * @return Categoría guardada con su ID asignado.
     */
    Object save(Object categoria);

    /**
     * Elimina una categoría por su ID.
     * @param categoriaId ID de la categoría a eliminar.
     * @return true si se eliminó correctamente, false si no.
     */
    boolean delete(int categoriaId);
}
