package com.jlzDev.goShop.web.controller;

import com.jlzDev.goShop.domain.model.Roles;
import com.jlzDev.goShop.domain.service.imp.RolesService;
import com.jlzDev.goShop.web.dto.roles.RolesCreateDTO;
import com.jlzDev.goShop.web.dto.roles.RolesDTO;
import com.jlzDev.goShop.web.dto.roles.RolesUpdateDTO;
import com.jlzDev.goShop.web.mapper.RolesDTOMapper;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controlador REST para operaciones relacionadas con roles.
 */
@RestController
@RequestMapping("/roles")
@CrossOrigin(origins = "*")
//@RequiredArgsConstructor
@Slf4j
public class RolesController {
    private final RolesService rolesService;
    private final RolesDTOMapper rolesDTOMapper;

    @Autowired
    public RolesController(RolesService rolesService, RolesDTOMapper rolesDTOMapper){
        this.rolesService = rolesService;
        this.rolesDTOMapper = rolesDTOMapper;
    }

    /**
     * Obtiene todas las roles.
     * @return Lista de roles.
     */
    @GetMapping
    public ResponseEntity<List<RolesDTO>> getAllRoles() {
        List<Roles> roles = rolesService.getAll();
        List<RolesDTO> rolesDTOs = rolesDTOMapper.toRolesDTO(roles);
        return ResponseEntity.ok(rolesDTOs);
    }

    /**
     * Obtiene un role por su rolId
     * @param rolId RolId del Rol
     * @return El rol existe
     */
    @GetMapping("/{rolId}")
    public ResponseEntity<RolesDTO> getRoleById(
            @Parameter(description = "Código rol", required = true)
            @PathVariable String rolId ){
        log.info("REST request para obtener rol {}", rolId);
        return rolesService.getRol(Integer.parseInt(rolId))
                .map(rolesDTOMapper::toRolDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Crea un role por su rolId
     * @param rolCreate Role a crear
     * @return El nuevo role
     */
    @PostMapping
    public ResponseEntity<RolesDTO> createRol(
            @Parameter(description = "Datos del rol a crear", required = true)
            @Valid @RequestBody RolesCreateDTO rolCreate) {

        log.info("REST request para crear un nuevo rol {}", rolCreate);

        Roles rol = rolesDTOMapper.toRolFromCreateDTO(rolCreate);
        // Asignar fechas actuales
        rol.setCreatedAt(LocalDateTime.now());
        rol.setUpdatedAt(LocalDateTime.now());

        Roles rolCreado = rolesService.save(rol);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(rolesDTOMapper.toRolDTO(rolCreado));
    }

    @PutMapping("/{rolId}")
    public ResponseEntity<RolesDTO> updateRol(
            @Parameter(description = "ID del rol a actualizar", required = true)
            @PathVariable Integer rolId,
            @Parameter(description = "Datos del rol a actualizar", required = true)
            @Valid @RequestBody RolesUpdateDTO rolUpdateDTO) {

        log.info("REST request para actualizar el rol con ID: {} con datos: {}", rolId, rolUpdateDTO);

        // Verificar que el ID en la URL coincide con el del cuerpo
        if (!rolId.equals(rolUpdateDTO.getIdRol())) {
            log.warn("El ID de la URL ({}) no coincide con el ID en el cuerpo ({})", rolId, rolUpdateDTO.getIdRol());
            return ResponseEntity.badRequest().body(null);
        }

        // Verificar si el rol existe
        if (!rolesService.existsById(rolId)) {
            log.warn("No existe un rol con ID: {}", rolId);
            return ResponseEntity.notFound().build();
        }

        // Obtener el rol actual para preservar datos que no deben actualizarse
        Roles rolExistente = rolesService.getRol(rolId).orElse(null);
        if (rolExistente == null) {
            log.warn("No se pudo obtener el rol con ID: {}", rolId);
            return ResponseEntity.notFound().build();
        }

        // Mapear desde el DTO de actualización al dominio
        Roles rolUpdate = rolesDTOMapper.toRolFromUpdateDTO(rolUpdateDTO);

        // Mantener la fecha de creación y actualizar la fecha de última modificación
        rolUpdate.setCreatedAt(rolExistente.getCreatedAt());
        rolUpdate.setUpdatedAt(LocalDateTime.now());

        // Actualizar y devolver la respuesta
        return rolesService.update(rolId, rolUpdate)
                .map(rolesDTOMapper::toRolDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{rolId}")
    public ResponseEntity<?> deleteRol(
            @Parameter(description = "Id del rol a eliminar", required = true)
            @PathVariable Integer rolId) {

        log.info("REST request para eliminar un rol con ID: {}", rolId);

        // Verificar si el rol existe antes de intentar eliminarlo
        if (!rolesService.existsById(rolId)) {
            log.warn("No se encontró ningún rol con ID: {}", rolId);
            return ResponseEntity.notFound().build();
        }

        try {
            boolean eliminado = rolesService.delete(rolId);
            if (eliminado) {
                log.info("Rol con ID: {} eliminado exitosamente", rolId);
                return ResponseEntity.noContent().build();
            } else {
                log.warn("No se pudo eliminar el rol con ID: {}", rolId);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (IllegalStateException e) {
            log.warn("No se puede eliminar el rol con ID: {} porque está siendo utilizado: {}", rolId, e.getMessage());

            // Crear un objeto de respuesta de error
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "El rol no puede ser eliminado porque está siendo utilizado");
            errorResponse.put("message", e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(errorResponse);
        } catch (Exception e) {
            log.error("Error inesperado al eliminar el rol con ID: {}: {}", rolId, e.getMessage(), e);

            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Error inesperado al eliminar el rol");
            errorResponse.put("message", e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(errorResponse);
        }
    }

}
