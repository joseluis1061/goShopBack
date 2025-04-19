package com.jlzDev.goShop.domain.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define las operaciones disponibles para acceder y manipular movimientos de inventario.
 */
public interface MovimientoInventarioRepository {
    /**
     * Obtiene todos los movimientos de inventario.
     * @return Lista de movimientos.
     */
    List<Object> getAll();

    /**
     * Busca un movimiento por su ID.
     * @param movimientoId ID del movimiento a buscar.
     * @return Optional que contiene el movimiento si existe.
     */
    Optional<Object> getMovimiento(int movimientoId);

    /**
     * Obtiene movimientos por bodega de origen.
     * @param bodegaId ID de la bodega de origen.
     * @return Lista de movimientos desde la bodega.
     */
    List<Object> getByBodegaOrigen(int bodegaId);

    /**
     * Obtiene movimientos por bodega de destino.
     * @param bodegaId ID de la bodega de destino.
     * @return Lista de movimientos hacia la bodega.
     */
    List<Object> getByBodegaDestino(int bodegaId);

    /**
     * Obtiene movimientos por punto de venta de origen.
     * @param puntoVentaId ID del punto de venta de origen.
     * @return Lista de movimientos desde el punto de venta.
     */
    List<Object> getByPuntoVentaOrigen(int puntoVentaId);

    /**
     * Obtiene movimientos por punto de venta de destino.
     * @param puntoVentaId ID del punto de venta de destino.
     * @return Lista de movimientos hacia el punto de venta.
     */
    List<Object> getByPuntoVentaDestino(int puntoVentaId);

    /**
     * Obtiene movimientos por tipo.
     * @param tipoMovimiento Tipo de movimiento.
     * @return Lista de movimientos del tipo especificado.
     */
    List<Object> getByTipoMovimiento(String tipoMovimiento);

    /**
     * Obtiene movimientos por estado.
     * @param estado Estado de los movimientos.
     * @return Lista de movimientos con el estado especificado.
     */
    List<Object> getByEstado(String estado);

    /**
     * Obtiene movimientos en un rango de fechas.
     * @param fechaInicio Fecha inicial del rango.
     * @param fechaFin Fecha final del rango.
     * @return Lista de movimientos dentro del rango de fechas.
     */
    List<Object> getByFechaBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    /**
     * Guarda o actualiza un movimiento.
     * @param movimiento Movimiento a guardar o actualizar.
     * @return Movimiento guardado con su ID asignado.
     */
    Object save(Object movimiento);

    /**
     * Cambia el estado de un movimiento.
     * @param movimientoId ID del movimiento.
     * @param nuevoEstado Nuevo estado para el movimiento.
     * @return true si se actualizó correctamente, false si no.
     */
    boolean updateEstado(int movimientoId, String nuevoEstado);

    /**
     * Ejecuta un movimiento de inventario.
     * Este método implica actualizar el stock en origen y destino.
     * @param movimientoId ID del movimiento a ejecutar.
     * @return true si se ejecutó correctamente, false si no.
     */
    boolean ejecutarMovimiento(int movimientoId);

    /**
     * Elimina un movimiento por su ID.
     * @param movimientoId ID del movimiento a eliminar.
     * @return true si se eliminó correctamente, false si no.
     */
    boolean delete(int movimientoId);
}