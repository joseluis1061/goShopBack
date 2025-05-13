package com.jlzDev.goShop.web.controller;

import com.jlzDev.goShop.domain.model.Categorias;
import com.jlzDev.goShop.domain.model.Productos;
import com.jlzDev.goShop.domain.model.Roles;
import com.jlzDev.goShop.domain.service.imp.ProductoService;
import com.jlzDev.goShop.domain.service.imp.RolesService;
import com.jlzDev.goShop.web.dto.productos.ProductosCreateDTO;
import com.jlzDev.goShop.web.dto.productos.ProductosDTO;
import com.jlzDev.goShop.web.dto.productos.ProductosUpdateDTO;
import com.jlzDev.goShop.web.dto.roles.RolesDTO;
import com.jlzDev.goShop.web.mapper.ProductosDTOMapper;
import com.jlzDev.goShop.web.mapper.RolesDTOMapper;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @GetMapping("/categoria/{categoriaId}")
    public ResponseEntity<List<ProductosDTO>> getByCategoria(
            @Parameter(description = "Buscar producto por CategoriaId", required = true)
            @PathVariable("categoriaId") int categoriaId
    ) {
        List<Productos> productos = productoService.getByIdCategoria(categoriaId);
        List<ProductosDTO> productosDTOS = productosDTOMapper.toProductosDTO(productos);
        return ResponseEntity.ok(productosDTOS);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<ProductosDTO>> getByNombre(
            @Parameter(description = "Buscar productos por nombre", required = true)
            @PathVariable("nombre") String nombre
    ) {
        List<Productos> productos = productoService.getByNombre(nombre);
        List<ProductosDTO> productosDTOS = productosDTOMapper.toProductosDTO(productos);
        return ResponseEntity.ok(productosDTOS);
    }

    @GetMapping("/precio/{precio}")
    public ResponseEntity<List<ProductosDTO>> getByPrecioMenorIgual(
            @Parameter(description = "Buscar productos por precio", required = true)
            @PathVariable("precio") double precio
    ) {
        List<Productos> productos = productoService.getByPrecioMenorIgual(precio);
        List<ProductosDTO> productosDTOS = productosDTOMapper.toProductosDTO(productos);
        return ResponseEntity.ok(productosDTOS);
    }

    @GetMapping("/precio-rango")
    public ResponseEntity<List<ProductosDTO>> getByRangoPrecio(
            @Parameter(description = "Buscar productos por rango precio menor", required = true)
            @RequestParam("min") double precioMinimo,
            @Parameter(description = "Buscar productos por rango precio mayor", required = true)
            @RequestParam("max") double precioMaximo
    ) {
        List<Productos> productos = productoService.getByRangoPrecio(precioMinimo, precioMaximo);
        List<ProductosDTO> productosDTOS = productosDTOMapper.toProductosDTO(productos);
        return ResponseEntity.ok(productosDTOS);
    }

    @PostMapping
    public ResponseEntity<ProductosDTO> create(
            @Parameter(description = "Producto nuevo a crear", required = true)
            @Valid @RequestBody ProductosCreateDTO productoDTO
    ) {
        Productos producto = productosDTOMapper.toProductoFromCreateDTO(productoDTO);
        producto.setCreatedAt(LocalDateTime.now());
        producto.setUpdatedAt(LocalDateTime.now());
        Productos savedProducto = productoService.save(producto);
        return new ResponseEntity<>(productosDTOMapper.toProductoDto(savedProducto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductosDTO> update(
            @Parameter(description = "Id producto a actualizar", required = true)
            @PathVariable("id") Integer productoId,
            @Parameter(description = "Datos de actualización", required = true)
            @Valid @RequestBody ProductosUpdateDTO productoDTO
    ) {

        log.info("REST request para actualizar el producto con ID: {} con datos: {}", productoId, productoDTO);

        // Verificar que el ID en la URL coincide con el del cuerpo
        if (!productoId.equals(productoDTO.getIdProducto())) {
            log.warn("El ID de la URL ({}) no coincide con el ID en el cuerpo ({})", productoId, productoDTO.getIdProducto());
            return ResponseEntity.badRequest().body(null);
        }

        // Verificar si el producto existe
        if (!productoService.existsById(productoId)) {
            log.warn("No existe un producto con ID: {}", productoId);
            return ResponseEntity.notFound().build();
        }

        // Obtener el producto actual para preservar datos que no deben actualizarse
        Productos productosExistente = productoService.getProducto(productoId).orElse(null);
        if (productosExistente == null) {
            log.warn("No se pudo obtener la producto con ID: {}", productoId);
            return ResponseEntity.notFound().build();
        }

        // Mapear desde el DTO de actualización al dominio
        Productos update = productosDTOMapper.toProductoFromUpdateDTO(productoDTO);

        // Mantener la fecha de creación y actualizar la fecha de última modificación
        update.setCreatedAt(productosExistente.getCreatedAt());
        update.setUpdatedAt(LocalDateTime.now());

        return productoService.update(productoId, update)
                .map(productosDTOMapper::toProductoDto)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(
            @Parameter(description = "Id producto a eliminar", required = true)
            @PathVariable("id") int productoId
    ) {
        if(!productoService.existsById(productoId)){
            log.warn("No se encontro producto con ID {}", productoId);
            // Crear objeto de respuesta de error
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("mensaje", "El ID del producto '" + productoId + "' no existe");
            errorResponse.put("error", "El producto no existe");

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorResponse);
        }

        try {
            boolean eliminado = productoService.delete(productoId);
            if (eliminado) {
                log.info("Producto con ID: {} eliminado exitosamente", productoId);
                return ResponseEntity.noContent().build();
            } else {
                log.warn("No se pudo eliminar el producto con ID: {}", productoId);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (IllegalStateException e) {
            log.warn("No se puede eliminar el producto con ID: {} porque está siendo utilizado: {}", productoId, e.getMessage());

            // Crear un objeto de respuesta de error
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "El producto no puede ser eliminado porque está siendo utilizado");
            errorResponse.put("message", e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(errorResponse);
        } catch (Exception e) {
            log.error("Error inesperado al eliminar el producto con ID: {}: {}", productoId, e.getMessage(), e);

            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Error inesperado al eliminar el producto");
            errorResponse.put("message", e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(errorResponse);
        }
    }

}

/*

private final ProductoService productoService;








    @PostMapping
    public ResponseEntity<ProductosDTO> save(@RequestBody ProductoDTO producto) {
        return new ResponseEntity<>(productoService.save(producto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductosDTO> update(@PathVariable("id") int productoId, @RequestBody ProductoDTO producto) {
        producto.setIdProducto(productoId);
        return ResponseEntity.ok(productoService.save(producto));
    }


 */