package com.jlzDev.goShop.domain.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define las operaciones disponibles para acceder y manipular ventas.
 */
public interface VentaRepository {
    /**
     * Obtiene todas las ventas.
     * @return Lista de ventas.
     */
    List<Object> getAll();

    /**
     * Busca una venta por su ID.
     * @param ventaId ID de la venta a buscar.
     * @return Optional que contiene la venta si existe.
     */
    Optional<Object> getVenta(int ventaId);

    /**
     * Busca una venta por su número de factura.
     * @param numeroFactura Número de factura de la venta.
     * @return Optional que contiene la venta si existe.
     */
    Optional<Object> getByNumeroFactura(String numeroFactura);

    /**
     * Obtiene ventas por usuario.
     * @param usuarioId ID del usuario.
     * @return Lista de ventas realizadas por el usuario.
     */
    List<Object> getByUsuario(int usuarioId);

    /**
     * Obtiene ventas por punto de venta.
     * @param puntoVentaId ID del punto de venta.
     * @return Lista de ventas realizadas en el punto de venta.
     */
    List<Object> getByPuntoVenta(int puntoVentaId);

    /**
     * Obtiene ventas por estado.
     * @param estado Estado de las ventas a buscar.
     * @return Lista de ventas con el estado especificado.
     */
    List<Object> getByEstado(String estado);

    /**
     * Obtiene ventas en un rango de fechas.
     * @param fechaInicio Fecha inicial del rango.
     * @param fechaFin Fecha final del rango.
     * @return Lista de ventas dentro del rango de fechas.
     */
    List<Object> getByFechaBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    /**
     * Calcula el total de ventas en un rango de fechas.
     * @param fechaInicio Fecha inicial del rango.
     * @param fechaFin Fecha final del rango.
     * @return Suma total de ventas en el período.
     */
    Double getTotalVentasByFechaBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    /**
     * Guarda o actualiza una venta.
     * @param venta Venta a guardar o actualizar.
     * @return Venta guardada con su ID asignado.
     */
    Object save(Object venta);

    /**
     * Cambia el estado de una venta.
     * @param ventaId ID de la venta.
     * @param nuevoEstado Nuevo estado para la venta.
     * @return true si se actualizó correctamente, false si no.
     */
    boolean updateEstado(int ventaId, String nuevoEstado);

    /**
     * Elimina una venta por su ID.
     * @param ventaId ID de la venta a eliminar.
     * @return true si se eliminó correctamente, false si no.
     */
    boolean delete(int ventaId);
}