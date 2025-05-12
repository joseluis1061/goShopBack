package com.jlzDev.goShop.web.controller;

import com.jlzDev.goShop.domain.model.Categorias;
import com.jlzDev.goShop.domain.model.Roles;
import com.jlzDev.goShop.domain.service.imp.CategoriaService;
import com.jlzDev.goShop.persistence.entity.CategoriasEntity;
import com.jlzDev.goShop.web.dto.categorias.CategoriasCreateDTO;
import com.jlzDev.goShop.web.dto.categorias.CategoriasDTO;
import com.jlzDev.goShop.web.dto.categorias.CategoriasUpdateDTO;
import com.jlzDev.goShop.web.mapper.CategoriasDTOMapper;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.transaction.Transactional;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Slf4j
public class CategoriasController {
    private final CategoriaService categoriaService;
    private final CategoriasDTOMapper categoriasDTOMapper;

    /*@Autowired
    public CategoriasController(CategoriaService categoriaService, CategoriasDTOMapper categoriasDTOMapper){
        this.categoriaService = categoriaService;
        this.categoriasDTOMapper = categoriasDTOMapper;
    }*/

    /**
     * Obtiene todas las categorias.
     * @return Lista de categorias.
     */
    @GetMapping
    public ResponseEntity<List<CategoriasDTO>> getAllCategorias(){
        List<Categorias> model = categoriaService.getAll();
        return ResponseEntity.ok(categoriasDTOMapper.toCategoriasDTO(model));
    }

    /**
     * Obtiene una categoria por su categoriaId.
     * @param categoriaId Id de la categoria
     * @return Categoria.
     */
    @GetMapping("/{categoriaId}")
    public ResponseEntity<CategoriasDTO> getCategoriaById(
            @Parameter(description = "Id de categoria", required = true)
            @PathVariable String categoriaId
    ){
        return categoriaService.getCategoria(Integer.parseInt(categoriaId))
                .map(categoriasDTOMapper::toCategoriaDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Crea una categoria usando CategoriasCreateDTO
     * @param categoriaCreate Categoria a crear
     * @return La nueva categoria o mensaje de error
     */
    @PostMapping
    public ResponseEntity<?> createCategoria(
            @Parameter(description = "Categoria nueva a crear", required = true)
            @Valid @RequestBody CategoriasCreateDTO categoriaCreate
    ) {
        // Verificar si ya existe una categoría con ese nombre
        Optional<Categorias> existingCategoria = categoriaService.getByNombre(categoriaCreate.getNombre());

        if(existingCategoria.isPresent()) {
            log.warn("El nombre de la categoría ({}) ya existe", categoriaCreate.getNombre());

            // Crear objeto de respuesta de error
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("mensaje", "El nombre de la categoría '" + categoriaCreate.getNombre() + "' ya existe");
            errorResponse.put("error", "Nombre duplicado");

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorResponse);
        }

        Categorias model = categoriasDTOMapper.toCategoriaFromCreateDTO(categoriaCreate);
        Categorias create = categoriaService.save(model);

        // Asignar fechas actuales
        create.setCreatedAt(LocalDateTime.now());
        create.setUpdatedAt(LocalDateTime.now());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoriasDTOMapper.toCategoriaDTO(create));
    }

    /**
     * Actualizar una categoria por su categoriaId
     * @param categoriaId Id Categoria a crear
     * @return La nueva categoria
     */
    @PutMapping("/{categoriaId}")
    public ResponseEntity<CategoriasDTO> updateCategoria(
            @Parameter(description = "Id categoria a actualizar", required = true)
            @PathVariable Integer categoriaId,
            @Parameter(description = "Datos de actualización", required = true)
            @Valid @RequestBody CategoriasUpdateDTO categiaUpdate
    ){

        log.info("REST request para actualizar el rol con ID: {} con datos: {}", categoriaId, categiaUpdate);

        // Verificar que el ID en la URL coincide con el del cuerpo
        if (!categoriaId.equals(categiaUpdate.getIdCategoria())) {
            log.warn("El ID de la URL ({}) no coincide con el ID en el cuerpo ({})", categoriaId, categiaUpdate.getIdCategoria());
            return ResponseEntity.badRequest().body(null);
        }

        // Verificar si el rol existe
        if (!categoriaService.existsById(categoriaId)) {
            log.warn("No existe una categoría con ID: {}", categoriaId);
            return ResponseEntity.notFound().build();
        }

        // Obtener el rol actual para preservar datos que no deben actualizarse
        Categorias rolExistente = categoriaService.getCategoria(categoriaId).orElse(null);
        if (rolExistente == null) {
            log.warn("No se pudo obtener la categoría con ID: {}", categoriaId);
            return ResponseEntity.notFound().build();
        }

        // Mapear desde el DTO de actualización al dominio
        Categorias update = categoriasDTOMapper.toCategoriaFromUpdateDTO(categiaUpdate);

        // Mantener la fecha de creación y actualizar la fecha de última modificación
        update.setCreatedAt(rolExistente.getCreatedAt());
        update.setUpdatedAt(LocalDateTime.now());

        return categoriaService.update(categoriaId, update)
                .map(categoriasDTOMapper::toCategoriaDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{categoriaId}")
    public ResponseEntity<?> deleteCategoria(
            @Parameter(description = "Id categoria a eliminar")
            @PathVariable Integer categoriaId
    ){
        if(!categoriaService.existsById(categoriaId)){
            log.warn("No se encontro categoriar con ID {}", categoriaId);
            // Crear objeto de respuesta de error
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("mensaje", "El ID de la categoría '" + categoriaId + "' no existe");
            errorResponse.put("error", "La categoría no existe");

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorResponse);
        }

        try {
            boolean eliminado = categoriaService.delete(categoriaId);
            if (eliminado) {
                log.info("Categoría con ID: {} eliminado exitosamente", categoriaId);
                return ResponseEntity.noContent().build();
            } else {
                log.warn("No se pudo eliminar la categoría con ID: {}", categoriaId);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (IllegalStateException e) {
            log.warn("No se puede eliminar la categoria con ID: {} porque está siendo utilizado: {}", categoriaId, e.getMessage());

            // Crear un objeto de respuesta de error
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "La categoría no puede ser eliminado porque está siendo utilizado");
            errorResponse.put("message", e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(errorResponse);
        } catch (Exception e) {
            log.error("Error inesperado al eliminar la categoría con ID: {}: {}", categoriaId, e.getMessage(), e);

            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Error inesperado al eliminar la categoria");
            errorResponse.put("message", e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(errorResponse);
        }

    }

}
