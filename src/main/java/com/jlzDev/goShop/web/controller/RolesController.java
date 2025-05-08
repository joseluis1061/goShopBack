package com.jlzDev.goShop.web.controller;


import com.jlzDev.goShop.domain.dto.RolDTO;
import com.jlzDev.goShop.domain.model.Roles;
import com.jlzDev.goShop.domain.service.imp.RolesService;
import com.jlzDev.goShop.web.dto.roles.RolesDTO;
import com.jlzDev.goShop.web.mapper.RolesDTOMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para operaciones relacionadas con roles.
 */
@RestController
@RequestMapping("/roles")
@CrossOrigin(origins = "*")
//@RequiredArgsConstructor
@Slf4j
public class RolesController {
    private final RolesService rolRepositoryImp;
    private final RolesDTOMapper rolesDTOMapper;

    @Autowired
    public RolesController(RolesService rolRepositoryImp, RolesDTOMapper rolesDTOMapper){
        this.rolRepositoryImp = rolRepositoryImp;
        this.rolesDTOMapper = rolesDTOMapper;
    }

    /**
     * Obtiene todas las roles.
     * @return Lista de roles.
     */
    @GetMapping
    public ResponseEntity<List<RolesDTO>> getAllSucursales() {
        List<Roles> roles = rolRepositoryImp.getAll();
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
        return rolRepositoryImp.getRol(Integer.parseInt(rolId))
                .map(rolesDTOMapper::toRolDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }
}
