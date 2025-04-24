package com.jlzDev.goShop.web.controller;

import com.jlzDev.goShop.domain.dto.ProductoDTO;
import com.jlzDev.goShop.domain.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> getAll() {
        return ResponseEntity.ok(productoService.getAll());
    }

    @GetMapping("/activos")
    public ResponseEntity<List<ProductoDTO>> getAllActive() {
        return ResponseEntity.ok(productoService.getAllActive());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> getProducto(@PathVariable("id") int productoId) {
        return productoService.getProducto(productoId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<ProductoDTO> getProductoByCodigo(@PathVariable("codigo") String codigo) {
        return productoService.getProductoByCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/categoria/{categoriaId}")
    public ResponseEntity<List<ProductoDTO>> getByCategoria(@PathVariable("categoriaId") int categoriaId) {
        return ResponseEntity.ok(productoService.getByCategoria(categoriaId));
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<ProductoDTO>> getByNombre(@PathVariable("nombre") String nombre) {
        return ResponseEntity.ok(productoService.getByNombre(nombre));
    }

    @GetMapping("/precio/{precio}")
    public ResponseEntity<List<ProductoDTO>> getByPrecio(@PathVariable("precio") double precio) {
        return ResponseEntity.ok(productoService.getByPrecioMenorIgual(precio));
    }

    @GetMapping("/precio-rango")
    public ResponseEntity<List<ProductoDTO>> getByRangoPrecio(
            @RequestParam("min") double precioMinimo,
            @RequestParam("max") double precioMaximo) {
        return ResponseEntity.ok(productoService.getByRangoPrecio(precioMinimo, precioMaximo));
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> save(@RequestBody ProductoDTO producto) {
        return new ResponseEntity<>(productoService.save(producto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> update(@PathVariable("id") int productoId, @RequestBody ProductoDTO producto) {
        producto.setIdProducto(productoId);
        return ResponseEntity.ok(productoService.save(producto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int productoId) {
        return productoService.delete(productoId)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }
}