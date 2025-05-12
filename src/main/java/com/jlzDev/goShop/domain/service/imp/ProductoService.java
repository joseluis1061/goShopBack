package com.jlzDev.goShop.domain.service.imp;

import com.jlzDev.goShop.domain.repository.ProductoRepository;
import com.jlzDev.goShop.domain.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoService implements ProductoRepository {

    @Override
    public List<Object> getAll() {
        return List.of();
    }

    @Override
    public List<Object> getAllActive() {
        return List.of();
    }

    @Override
    public Optional<Object> getProducto(int productoId) {
        return Optional.empty();
    }

    @Override
    public Optional<Object> getProductoByCodigo(String codigo) {
        return Optional.empty();
    }

    @Override
    public List<Object> getByCategoria(int categoriaId) {
        return List.of();
    }

    @Override
    public List<Object> getByNombre(String nombre) {
        return List.of();
    }

    @Override
    public List<Object> getByPrecioMenorIgual(double precio) {
        return List.of();
    }

    @Override
    public List<Object> getByRangoPrecio(double precioMinimo, double precioMaximo) {
        return List.of();
    }

    @Override
    public Object save(Object producto) {
        return null;
    }

    @Override
    public boolean delete(int productoId) {
        return false;
    }
}

/*

 private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository, CategoriaRepository categoriaRepository) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public List<ProductoDTO> getAll() {
        List<Object> productos = productoRepository.getAll();
        return productos.stream()
                .map(obj -> (ProductoDTO) obj)
                .collect(Collectors.toList());
    }

    public List<ProductoDTO> getAllActive() {
        List<Object> productos = productoRepository.getAllActive();
        return productos.stream()
                .map(obj -> (ProductoDTO) obj)
                .collect(Collectors.toList());
    }

    public Optional<ProductoDTO> getProducto(int productoId) {
        Optional<Object> producto = productoRepository.getProducto(productoId);
        return producto.map(obj -> (ProductoDTO) obj);
    }

    public Optional<ProductoDTO> getProductoByCodigo(String codigo) {
        Optional<Object> producto = productoRepository.getProductoByCodigo(codigo);
        return producto.map(obj -> (ProductoDTO) obj);
    }

    public List<ProductoDTO> getByCategoria(int categoriaId) {
        List<Object> productos = productoRepository.getByCategoria(categoriaId);
        return productos.stream()
                .map(obj -> (ProductoDTO) obj)
                .collect(Collectors.toList());
    }

    public List<ProductoDTO> getByNombre(String nombre) {
        List<Object> productos = productoRepository.getByNombre(nombre);
        return productos.stream()
                .map(obj -> (ProductoDTO) obj)
                .collect(Collectors.toList());
    }

    public List<ProductoDTO> getByPrecioMenorIgual(double precio) {
        List<Object> productos = productoRepository.getByPrecioMenorIgual(precio);
        return productos.stream()
                .map(obj -> (ProductoDTO) obj)
                .collect(Collectors.toList());
    }

    public List<ProductoDTO> getByRangoPrecio(double precioMinimo, double precioMaximo) {
        List<Object> productos = productoRepository.getByRangoPrecio(precioMinimo, precioMaximo);
        return productos.stream()
                .map(obj -> (ProductoDTO) obj)
                .collect(Collectors.toList());
    }

    @Transactional
    public ProductoDTO save(ProductoDTO producto) {
        // Validar que la categoría existe
        if (producto.getIdCategoria() != null) {
            Optional<Object> categoriaOpt = categoriaRepository.getCategoria(producto.getIdCategoria());
            if (!categoriaOpt.isPresent()) {
                throw new IllegalArgumentException("La categoría especificada no existe");
            }
        }

        // Validar que el código no exista si es un nuevo producto
        if (producto.getIdProducto() == null) {
            Optional<ProductoDTO> existente = getProductoByCodigo(producto.getCodigo());
            if (existente.isPresent()) {
                throw new IllegalArgumentException("Ya existe un producto con ese código");
            }
        }

        Object resultado = productoRepository.save(producto);
        return (ProductoDTO) resultado;
    }

    @Transactional
    public boolean delete(int productoId) {
        return getProducto(productoId)
                .map(producto -> {
                    productoRepository.delete(productoId);
                    return true;
                })
                .orElse(false);
    }
 */