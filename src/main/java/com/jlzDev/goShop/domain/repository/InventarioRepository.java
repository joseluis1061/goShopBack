package com.jlzDev.goShop.domain.repository;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define las operaciones disponibles para acceder y manipular inventarios de bodegas.
 */
public interface InventarioRepository {
    /**
     * Obtiene todos los registros de inventario.
     * @return Lista de inventarios.
     */
    List<Object> getAll();

    /**
     * Busca un registro de inventario por su ID.
     * @param inventarioId ID del inventario a buscar.
     * @return Optional que contiene el inventario si existe.
     */
    Optional<Object> getInventario(int inventarioId);

    /**
     * Obtiene inventarios por bodega.
     * @param bodegaId ID de la bodega.
     * @return Lista de inventarios de la bodega.
     */
    List<Object> getByBodega(int bodegaId);

    /**
     * Obtiene inventarios por producto.
     * @param productoId ID del producto.
     * @return Lista de inventarios del producto en diferentes bodegas.
     */
    List<Object> getByProducto(int productoId);

    /**
     * Busca un inventario específico por producto y bodega.
     * @param productoId ID del producto.
     * @param bodegaId ID de la bodega.
     * @return Optional que contiene el inventario si existe.
     */
    Optional<Object> getByProductoAndBodega(int productoId, int bodegaId);

    /**
     * Obtiene inventarios con stock por debajo del mínimo.
     * @return Lista de inventarios con stock bajo.
     */
    List<Object> getWithStockBelowMinimum();

    /**
     * Guarda o actualiza un registro de inventario.
     * @param inventario Inventario a guardar o actualizar.
     * @return Inventario guardado con su ID asignado.
     */
    Object save(Object inventario);

    /**
     * Actualiza el stock de un producto en una bodega.
     * @param productoId ID del producto.
     * @param bodegaId ID de la bodega.
     * @param cantidad Cantidad a añadir (positivo) o restar (negativo).
     * @return true si se actualizó correctamente, false si no.
     */
    boolean updateStock(int productoId, int bodegaId, int cantidad);

    /**
     * Elimina un registro de inventario por su ID.
     * @param inventarioId ID del inventario a eliminar.
     * @return true si se eliminó correctamente, false si no.
     */
    boolean delete(int inventarioId);
}