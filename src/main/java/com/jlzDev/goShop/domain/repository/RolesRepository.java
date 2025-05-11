package com.jlzDev.goShop.domain.repository;

import com.jlzDev.goShop.domain.model.Roles;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define las operaciones disponibles para acceder y manipular roles.
 */
public interface RolesRepository {
    /**
     * Obtiene todos los roles.
     * @return Lista de roles.
     */
    List<Roles> getAll();

    /**
     * Busca un rol por su ID.
     * @param rolId ID del rol a buscar.
     * @return Optional que contiene el rol si existe.
     */
    Optional<Roles> getRol(int rolId);

    /**
     * Busca un rol por su nombre.
     * @param nombre Nombre del rol.
     * @return Optional que contiene el rol si existe.
     */
    Optional<Roles> getByNombre(String nombre);

    /**
     * Guarda o actualiza un rol.
     * @param rol Rol a guardar o actualizar.
     * @return Rol guardado con su ID asignado.
     */
    Roles save(Roles rol);

    /**
     * Actualiza un rol existente
     * @param rolId ID del rol a actualizar
     * @param rol Datos actualizados del rol
     * @return Optional que contiene el rol actualizado si existe
     */
    Optional<Roles> update(int rolId, Roles rol);

    /**
     * Elimina un rol por su ID.
     * @param rolId ID del rol a eliminar.
     * @return true si se eliminó correctamente, false si no.
     */
    boolean delete(int rolId);

    boolean existsById(int rolId);
}