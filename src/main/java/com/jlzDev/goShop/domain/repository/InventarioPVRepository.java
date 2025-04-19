package com.jlzDev.goShop.domain.repository;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define las operaciones disponibles para acceder y manipular inventarios de puntos de venta.
 */
public interface InventarioPVRepository {
    /**
     * Obtiene todos los registros de inventario de puntos de venta.
     * @return Lista de inventarios de puntos de venta.
     */
    List<Object> getAll();

    /**
     * Busca un registro de inventario por su ID.
     * @param inventarioPVId ID del inventario a buscar.
     * @return Optional que contiene el inventario si existe.
     */
    Optional<Object> getInventarioPV(int inventarioPVId);

    /**
     * Obtiene inventarios por punto de venta.
     * @param puntoVentaId ID del punto de venta.
     * @return Lista de inventarios del punto de venta.
     */
    List<Object> getByPuntoVenta(int puntoVentaId);

    /**
     * Obtiene inventarios por producto.
     * @param productoId ID del producto.
     * @return Lista de inventarios del producto en diferentes puntos de venta.
     */
    List<Object> getByProducto(int productoId);

    /**
     * Busca un inventario específico por producto y punto de venta.
     * @param productoId ID del producto.
     * @param puntoVentaId ID del punto de venta.
     * @return Optional que contiene el inventario si existe.
     */
    Optional<Object> getByProductoAndPuntoVenta(int productoId, int puntoVentaId);

    /**
     * Obtiene inventarios con stock por debajo del mínimo.
     * @return Lista de inventarios con stock bajo.
     */
    List<Object> getWithStockBelowMinimum();

    /**
     * Guarda o actualiza un registro de inventario.
     * @param inventarioPV Inventario a guardar o actualizar.
     * @return Inventario guardado con su ID asignado.
     */
    Object save(Object inventarioPV);

    /**
     * Actualiza el stock de un producto en un punto de venta.
     * @param productoId ID del producto.
     * @param puntoVentaId ID del punto de venta.
     * @param cantidad Cantidad a añadir (positivo) o restar (negativo).
     * @return true si se actualizó correctamente, false si no.
     */
    boolean updateStock(int productoId, int puntoVentaId, int cantidad);

    /**
     * Elimina un registro de inventario por su ID.
     * @param inventarioPVId ID del inventario a eliminar.
     * @return true si se eliminó correctamente, false si no.
     */
    boolean delete(int inventarioPVId);
}