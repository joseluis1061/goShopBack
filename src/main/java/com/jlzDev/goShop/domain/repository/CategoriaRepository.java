package com.jlzDev.goShop.domain.repository;

import com.jlzDev.goShop.domain.model.Categorias;
import com.jlzDev.goShop.domain.model.Roles;

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
    List<Categorias> getAll();

    /**
     * Obtiene todas las categorías activas.
     * @return Lista de categorías activas.
     */
    List<Categorias> getAllActive();

    /**
     * Busca una categoría por su ID.
     * @param categoriaId ID de la categoría a buscar.
     * @return Optional que contiene la categoría si existe.
     */
    Optional<Categorias> getCategoria(int categoriaId);

    /**
     * Busca una categoría por su nombre.
     * @param nombre Nombre de la categoría.
     * @return Optional que contiene la categoría si existe.
     */
    Optional<Categorias> getByNombre(String nombre);

    /**
     * Guarda o actualiza una categoría.
     * @param categoria Categoría a guardar o actualizar.
     * @return Categoría guardada con su ID asignado.
     */
    Categorias save(Categorias categoria);

    /**
     * Actualiza una categoría existente
     * @param categoriaId ID de categoría a actualizar
     * @param categoria Datos actualizados de la categoría
     * @return Optional que contiene el rol actualizado si existe
     */
    Optional<Categorias> update(int categoriaId, Categorias categoria);

    /**
     * Elimina una categoría por su ID.
     * @param categoriaId ID de la categoría a eliminar.
     * @return true si se eliminó correctamente, false si no.
     */
    boolean delete(int categoriaId);

    boolean existsById(int rolId);
}
