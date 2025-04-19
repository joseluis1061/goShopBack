package com.jlzDev.goShop.domain.repository;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define las operaciones disponibles para acceder y manipular puntos de venta.
 */
public interface PuntoVentaRepository {
    /**
     * Obtiene todos los puntos de venta.
     * @return Lista de puntos de venta.
     */
    List<Object> getAll();

    /**
     * Obtiene todos los puntos de venta activos.
     * @return Lista de puntos de venta activos.
     */
    List<Object> getAllActive();

    /**
     * Busca un punto de venta por su ID.
     * @param puntoVentaId ID del punto de venta a buscar.
     * @return Optional que contiene el punto de venta si existe.
     */
    Optional<Object> getPuntoVenta(int puntoVentaId);

    /**
     * Busca un punto de venta por su nombre.
     * @param nombre Nombre del punto de venta.
     * @return Optional que contiene el punto de venta si existe.
     */
    Optional<Object> getByNombre(String nombre);

    /**
     * Guarda o actualiza un punto de venta.
     * @param puntoVenta Punto de venta a guardar o actualizar.
     * @return Punto de venta guardado con su ID asignado.
     */
    Object save(Object puntoVenta);

    /**
     * Elimina un punto de venta por su ID.
     * @param puntoVentaId ID del punto de venta a eliminar.
     * @return true si se eliminó correctamente, false si no.
     */
    boolean delete(int puntoVentaId);
}