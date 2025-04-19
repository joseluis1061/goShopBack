package com.jlzDev.goShop.domain.repository;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define las operaciones disponibles para acceder y manipular bodegas.
 */
public interface BodegaRepository {
    /**
     * Obtiene todas las bodegas.
     * @return Lista de bodegas.
     */
    List<Object> getAll();

    /**
     * Obtiene todas las bodegas activas.
     * @return Lista de bodegas activas.
     */
    List<Object> getAllActive();

    /**
     * Busca una bodega por su ID.
     * @param bodegaId ID de la bodega a buscar.
     * @return Optional que contiene la bodega si existe.
     */
    Optional<Object> getBodega(int bodegaId);

    /**
     * Busca una bodega por su nombre.
     * @param nombre Nombre de la bodega.
     * @return Optional que contiene la bodega si existe.
     */
    Optional<Object> getByNombre(String nombre);

    /**
     * Guarda o actualiza una bodega.
     * @param bodega Bodega a guardar o actualizar.
     * @return Bodega guardada con su ID asignado.
     */
    Object save(Object bodega);

    /**
     * Elimina una bodega por su ID.
     * @param bodegaId ID de la bodega a eliminar.
     * @return true si se eliminó correctamente, false si no.
     */
    boolean delete(int bodegaId);
}