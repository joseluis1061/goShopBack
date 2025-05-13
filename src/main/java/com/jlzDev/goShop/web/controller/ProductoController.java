package com.jlzDev.goShop.web.controller;

import com.jlzDev.goShop.domain.model.Productos;
import com.jlzDev.goShop.domain.model.Roles;
import com.jlzDev.goShop.domain.service.imp.ProductoService;
import com.jlzDev.goShop.domain.service.imp.RolesService;
import com.jlzDev.goShop.web.dto.productos.ProductosDTO;
import com.jlzDev.goShop.web.dto.roles.RolesDTO;
import com.jlzDev.goShop.web.mapper.ProductosDTOMapper;
import com.jlzDev.goShop.web.mapper.RolesDTOMapper;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Slf4j
public class ProductoController {
    private ProductoService productoService;
    private ProductosDTOMapper productosDTOMapper;

    @Autowired
    public ProductoController(ProductoService productoService, ProductosDTOMapper productosDTOMapper){
        this.productoService = productoService;
        this.productosDTOMapper = productosDTOMapper;
    }

    @GetMapping
    public ResponseEntity<List<ProductosDTO>> getAll() {
        List<Productos> productos = productoService.getAll();
        List<ProductosDTO> productosDTOs = productosDTOMapper.toProductosDTO(productos);
        return ResponseEntity.ok(productosDTOs);
    }

    @GetMapping("/activos")
    public ResponseEntity<List<ProductosDTO>> getAllActive() {
        List<Productos> productos = productoService.getAllActive();
        List<ProductosDTO> productosDTOs = productosDTOMapper.toProductosDTO(productos);
        return ResponseEntity.ok(productosDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductosDTO> getProducto(@PathVariable("id") int productoId) {
        return productoService.getProducto(productoId)
                .map(productosDTOMapper::toProductoDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<ProductosDTO> getProductoByCodigo(
            @Parameter(description = "Código producto", required = true)
            @PathVariable String codigo
    ) {
        return productoService.getProductoByCodigo(codigo)
                .map(productosDTOMapper::toProductoDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}

/*

private final ProductoService productoService;




    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<ProductosDTO> getProductoByCodigo(@PathVariable("codigo") String codigo) {
        return productoService.getProductoByCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/categoria/{categoriaId}")
    public ResponseEntity<List<ProductosDTO>> getByCategoria(@PathVariable("categoriaId") int categoriaId) {
        return ResponseEntity.ok(productoService.getByCategoria(categoriaId));
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<ProductosDTO>> getByNombre(@PathVariable("nombre") String nombre) {
        return ResponseEntity.ok(productoService.getByNombre(nombre));
    }

    @GetMapping("/precio/{precio}")
    public ResponseEntity<List<ProductosDTO>> getByPrecio(@PathVariable("precio") double precio) {
        return ResponseEntity.ok(productoService.getByPrecioMenorIgual(precio));
    }

    @GetMapping("/precio-rango")
    public ResponseEntity<List<ProductosDTO>> getByRangoPrecio(
            @RequestParam("min") double precioMinimo,
            @RequestParam("max") double precioMaximo) {
        return ResponseEntity.ok(productoService.getByRangoPrecio(precioMinimo, precioMaximo));
    }

    @PostMapping
    public ResponseEntity<ProductosDTO> save(@RequestBody ProductoDTO producto) {
        return new ResponseEntity<>(productoService.save(producto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductosDTO> update(@PathVariable("id") int productoId, @RequestBody ProductoDTO producto) {
        producto.setIdProducto(productoId);
        return ResponseEntity.ok(productoService.save(producto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int productoId) {
        return productoService.delete(productoId)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }
 */