package com.jlzDev.goShop.domain.repository;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define las operaciones disponibles para acceder y manipular roles.
 */
public interface RolRepository {
    /**
     * Obtiene todos los roles.
     * @return Lista de roles.
     */
    List<Object> getAll();

    /**
     * Busca un rol por su ID.
     * @param rolId ID del rol a buscar.
     * @return Optional que contiene el rol si existe.
     */
    Optional<Object> getRol(int rolId);

    /**
     * Busca un rol por su nombre.
     * @param nombre Nombre del rol.
     * @return Optional que contiene el rol si existe.
     */
    Optional<Object> getByNombre(String nombre);

    /**
     * Guarda o actualiza un rol.
     * @param rol Rol a guardar o actualizar.
     * @return Rol guardado con su ID asignado.
     */
    Object save(Object rol);

    /**
     * Elimina un rol por su ID.
     * @param rolId ID del rol a eliminar.
     * @return true si se eliminó correctamente, false si no.
     */
    boolean delete(int rolId);
}