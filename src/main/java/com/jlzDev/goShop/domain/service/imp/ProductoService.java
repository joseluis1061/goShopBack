package com.jlzDev.goShop.domain.service.imp;

import com.jlzDev.goShop.domain.model.Productos;
import com.jlzDev.goShop.domain.repository.ProductoRepository;
import com.jlzDev.goShop.domain.repository.CategoriaRepository;
import com.jlzDev.goShop.persistence.entity.ProductosEntity;
import com.jlzDev.goShop.persistence.mapper.ProductosMapper;
import com.jlzDev.goShop.persistence.repository.ProductosCrudRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductoService implements ProductoRepository {
    private final ProductosCrudRepository productosCrudRepository;
    private final ProductosMapper productosMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Productos> getAll() {
        List<ProductosEntity> entities = productosCrudRepository.findAll();
        return productosMapper.toProductos(entities);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Productos> getAllActive() {
        List<ProductosEntity> entities = productosCrudRepository.findByEstadoTrue();
        return productosMapper.toProductos(entities);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Productos> getProducto(int productoId) {
        return productosCrudRepository.findById(productoId)
                .map(productosMapper::toProducto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Productos> getProductoByCodigo(String codigo) {
        return productosCrudRepository.findByCodigo(codigo)
                .map(productosMapper::toProducto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Productos> getByIdCategoria(int categoriaId) {
        List<ProductosEntity> entities = productosCrudRepository.findByIdCategoria(categoriaId);
        return productosMapper.toProductos(entities);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Productos> getByNombre(String nombre) {
        List<ProductosEntity> entities = productosCrudRepository.findByNombreContaining(nombre);
        return productosMapper.toProductos(entities);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Productos> getByPrecioMenorIgual(double precio) {
        List<ProductosEntity> entities = productosCrudRepository.findByPrecioLessThanEqual(precio);
        return productosMapper.toProductos(entities);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Productos> getByRangoPrecio(double precioMinimo, double precioMaximo) {
        List<ProductosEntity> entities = productosCrudRepository.findByPrecioVentaBetweenAndEstadoTrue(precioMinimo, precioMaximo);
        return productosMapper.toProductos(entities);
    }

    @Override
    @Transactional
    public Productos save(Productos producto) {
        if(producto == null){
            log.warn("El producto es nulo");
            throw new IllegalArgumentException("El id del producto no puede nulo");
        }

        if(producto.getCodigo() == null || producto.getNombre() == null || producto.getCategoria() == null || producto.getPrecioVenta() == null || producto.getEstado() == null){
            log.warn("Los valores código {} nombre {} categoría{} precio de venta {} estado {} no pueden ser nulos o vacios", producto.getCodigo(), producto.getNombre(), producto.getCategoria(), producto.getPrecioVenta(), producto.getEstado());
            throw new IllegalArgumentException("El código, nombre, categoría, precio de venta, estado del producto no pueden ser nulos o vacios");
        }

        ProductosEntity entity = productosMapper.toProductoEntity(producto);
        ProductosEntity entitySave = productosCrudRepository.save(entity);

        return productosMapper.toProducto(entitySave);
    }

    @Override
    @Transactional
    public Optional<Productos> update(Integer productoId, Productos producto) {
        log.info("Actualizando producto con ID: {}", producto);

        if (productoId <= 0) {
            throw new IllegalArgumentException("El id del producto no puede ser 0 o negativo");
        }

        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }

        if(producto.getCodigo() == null || producto.getNombre() == null || producto.getCategoria() == null || producto.getPrecioVenta() == null || producto.getEstado() == null){
            log.warn("Los valores código {} nombre {} categoría{} precio de venta {} estado {} no pueden ser nulos o vacios", producto.getCodigo(), producto.getNombre(), producto.getCategoria(), producto.getPrecioVenta(), producto.getEstado());
            throw new IllegalArgumentException("El código, nombre, categoría, precio de venta, estado del producto no pueden ser nulos o vacios");
        }

        ProductosEntity entity = productosMapper.toProductoEntity(producto);
        ProductosEntity entityUpdate = productosCrudRepository.save(entity);

        return Optional.of(productosMapper.toProducto(entityUpdate));
    }

    @Override
    public boolean delete(int productoId) {

        if (productoId <= 0 ) {
            throw new IllegalArgumentException("El id del productoId no puede ser 0 o negativo");
        }

        if (!existsById(productoId)) {
            log.warn("No se encontró rol con productoId: {}", productoId);
            return false;
        }

        try {
            productosCrudRepository.deleteById(productoId);
            log.info("Producto eliminado correctamente");
            return true;
        } catch (Exception e) {
            log.error("Error al eliminar producto: {}", e.getMessage());
            throw new IllegalStateException("No se puede eliminar el producto porque está siendo utilizado", e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(int rolId) {
        return productosCrudRepository.existsById(rolId);
    }
}