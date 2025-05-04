package com.jlzDev.goShop.domain.service.imp;

import com.jlzDev.goShop.domain.dto.ProductoDTO;
import com.jlzDev.goShop.domain.repository.ProductoRepository;
import com.jlzDev.goShop.persistence.repository.ProductosCrudRepository;
import com.jlzDev.goShop.persistence.entity.CategoriasEntity;
import com.jlzDev.goShop.persistence.entity.ProductosEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductoRepositoryImpl implements ProductoRepository {

    private final ProductosCrudRepository productosCrudRepository;

    @Autowired
    public ProductoRepositoryImpl(ProductosCrudRepository productosCrudRepository) {
        this.productosCrudRepository = productosCrudRepository;
    }

    @Override
    public List<Object> getAll() {
        List<ProductosEntity> productos = (List<ProductosEntity>) productosCrudRepository.findAll();
        return productos.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<Object> getAllActive() {
        List<ProductosEntity> productos = productosCrudRepository.findByEstadoTrue();
        return productos.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Object> getProducto(int productoId) {
        return productosCrudRepository.findById(productoId)
                .map(this::mapToDTO);
    }

    @Override
    public Optional<Object> getProductoByCodigo(String codigo) {
        return productosCrudRepository.findByCodigo(codigo)
                .map(this::mapToDTO);
    }

    @Override
    public List<Object> getByCategoria(int categoriaId) {
        CategoriasEntity categoria = new CategoriasEntity();
        categoria.setIdCategoria(categoriaId);

        List<ProductosEntity> productos = productosCrudRepository.findByCategoria(categoria);
        return productos.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<Object> getByNombre(String nombre) {
        List<ProductosEntity> productos = productosCrudRepository.findByNombreContaining(nombre);
        return productos.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<Object> getByPrecioMenorIgual(double precio) {
        List<ProductosEntity> productos = productosCrudRepository.findByPrecioLessThanEqual(precio);
        return productos.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<Object> getByRangoPrecio(double precioMinimo, double precioMaximo) {
        List<ProductosEntity> productos = productosCrudRepository.findByPrecioVentaBetweenAndEstadoTrue(precioMinimo, precioMaximo);
        return productos.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Object save(Object producto) {
        ProductoDTO productoDTO = (ProductoDTO) producto;
        ProductosEntity productoEntity = mapToEntity(productoDTO);
        ProductosEntity savedProducto = productosCrudRepository.save(productoEntity);
        return mapToDTO(savedProducto);
    }

    @Override
    public boolean delete(int productoId) {
        if (productosCrudRepository.existsById(productoId)) {
            productosCrudRepository.deleteById(productoId);
            return true;
        }
        return false;
    }

    // Métodos de mapeo entre entidad y DTO
    private ProductoDTO mapToDTO(ProductosEntity producto) {
        ProductoDTO dto = new ProductoDTO();
        dto.setIdProducto(producto.getIdProducto());
        dto.setIdCategoria(producto.getCategoria() != null ? producto.getCategoria().getIdCategoria() : null);
        dto.setNombreCategoria(producto.getCategoria() != null ? producto.getCategoria().getNombre() : null);
        dto.setCodigo(producto.getCodigo());
        dto.setNombre(producto.getNombre());
        dto.setDescripcion(producto.getDescripcion());
        dto.setPrecioVenta(producto.getPrecioVenta());
        dto.setImagenUrl(producto.getImagenUrl());
        dto.setEstado(producto.getEstado());
        dto.setCreatedAt(producto.getCreatedAt());
        dto.setUpdatedAt(producto.getUpdatedAt());
        return dto;
    }

    private ProductosEntity mapToEntity(ProductoDTO dto) {
        ProductosEntity entity = new ProductosEntity();
        entity.setIdProducto(dto.getIdProducto());

        if (dto.getIdCategoria() != null) {
            CategoriasEntity categoria = new CategoriasEntity();

            categoria.setIdCategoria(dto.getIdCategoria());
            entity.setCategoria(categoria);
        }

        entity.setCodigo(dto.getCodigo());
        entity.setNombre(dto.getNombre());
        entity.setDescripcion(dto.getDescripcion());
        entity.setPrecioVenta(dto.getPrecioVenta());
        entity.setImagenUrl(dto.getImagenUrl());
        entity.setEstado(dto.getEstado());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        return entity;
    }
}