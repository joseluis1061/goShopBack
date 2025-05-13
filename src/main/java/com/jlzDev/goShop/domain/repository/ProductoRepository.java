package com.jlzDev.goShop.domain.repository;

import com.jlzDev.goShop.domain.model.Productos;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define las operaciones disponibles para acceder y manipular productos.
 */
public interface ProductoRepository {
    /**
     * Obtiene todos los productos disponibles.
     * @return Lista de productos.
     */
    List<Productos> getAll();

    /**
     * Obtiene todos los productos activos.
     * @return Lista de productos activos.
     */
    List<Productos> getAllActive();

    /**
     * Busca un producto por su ID.
     * @param productoId ID del producto a buscar.
     * @return Optional que contiene el producto si existe.
     */
    Optional<Productos> getProducto(int productoId);

    /**
     * Busca un producto por su código.
     * @param codigo Código único del producto.
     * @return Optional que contiene el producto si existe.
     */
    Optional<Productos> getProductoByCodigo(String codigo);

    /**
     * Obtiene productos por categoría.
     * @param categoriaId ID de la categoría.
     * @return Lista de productos de la categoría.
     */
    List<Productos> getByIdCategoria(int categoriaId);

    /**
     * Busca productos que contengan el nombre especificado.
     * @param nombre Nombre o parte del nombre a buscar.
     * @return Lista de productos que coinciden con la búsqueda.
     */
    List<Productos> getByNombre(String nombre);

    /**
     * Busca productos con precio menor o igual al especificado.
     * @param precio Precio máximo a buscar.
     * @return Lista de productos con precio menor o igual.
     */
    List<Productos> getByPrecioMenorIgual(double precio);

    /**
     * Busca productos en un rango de precios.
     * @param precioMinimo Precio mínimo del rango.
     * @param precioMaximo Precio máximo del rango.
     * @return Lista de productos dentro del rango de precios.
     */
    List<Productos> getByRangoPrecio(double precioMinimo, double precioMaximo);

    /**
     * Guarda o actualiza un producto.
     * @param producto Producto a guardar.
     * @return Producto guardado con su ID asignado.
     */
    Productos save(Productos producto);

    /**
     * Guarda o actualiza un producto.
     * @param productoId Id producto actualizar.
     * @param producto Producto a guardar o actualizar.
     * @return Producto guardado con su ID asignado.
     */
    Optional<Productos> update(Integer productoId, Productos producto);


    /**
     * Elimina un producto por su ID.
     * @param productoId ID del producto a eliminar.
     * @return true si se eliminó correctamente, false si no.
     */
    boolean delete(int productoId);

    boolean existsById(int productoId);
}