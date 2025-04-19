package com.jlzDev.goShop.domain.repository;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define las operaciones disponibles para acceder y manipular usuarios.
 */
public interface UsuarioRepository {
    /**
     * Obtiene todos los usuarios.
     * @return Lista de usuarios.
     */
    List<Object> getAll();

    /**
     * Obtiene todos los usuarios activos.
     * @return Lista de usuarios activos.
     */
    List<Object> getAllActive();

    /**
     * Busca un usuario por su ID.
     * @param usuarioId ID del usuario a buscar.
     * @return Optional que contiene el usuario si existe.
     */
    Optional<Object> getUsuario(int usuarioId);

    /**
     * Busca un usuario por su email.
     * @param email Email del usuario.
     * @return Optional que contiene el usuario si existe.
     */
    Optional<Object> getByEmail(String email);

    /**
     * Obtiene usuarios por rol.
     * @param rolId ID del rol.
     * @return Lista de usuarios con ese rol.
     */
    List<Object> getByRol(int rolId);

    /**
     * Obtiene usuarios por punto de venta.
     * @param puntoVentaId ID del punto de venta.
     * @return Lista de usuarios asignados a ese punto de venta.
     */
    List<Object> getByPuntoVenta(int puntoVentaId);

    /**
     * Guarda o actualiza un usuario.
     * @param usuario Usuario a guardar o actualizar.
     * @return Usuario guardado con su ID asignado.
     */
    Object save(Object usuario);

    /**
     * Elimina un usuario por su ID.
     * @param usuarioId ID del usuario a eliminar.
     * @return true si se eliminó correctamente, false si no.
     */
    boolean delete(int usuarioId);
}