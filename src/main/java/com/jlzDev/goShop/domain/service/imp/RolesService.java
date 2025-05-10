package com.jlzDev.goShop.domain.service.imp;

import com.jlzDev.goShop.domain.repository.RolesRepository;
import com.jlzDev.goShop.domain.model.Roles;
import com.jlzDev.goShop.persistence.entity.RolesEntity;
import com.jlzDev.goShop.persistence.mapper.RolesMapper;
import com.jlzDev.goShop.persistence.repository.RolesCrudRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Implementación de la interfaz RolesService.
 * Proporciona la lógica de negocio para las operaciones relacionadas con roles.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class RolesService implements RolesRepository {
    private final RolesCrudRepository rolesCrudRepository;
    private final RolesMapper rolesMapper;

    @Autowired
    public RolesService(RolesMapper rolesMapper, RolesCrudRepository rolesCrudRepository){
        this.rolesMapper = rolesMapper;
        this.rolesCrudRepository = rolesCrudRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Roles> getAll() {
        List<RolesEntity> entities = rolesCrudRepository.findAll();
        return rolesMapper.toRoles(entities);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Roles> getRol(int rolId) {
        return rolesCrudRepository.findById(rolId)
                .map(rolesMapper::toRol);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Roles> getByNombre(String nombre) {
        return rolesCrudRepository.findByNombre(nombre)
                .map(rolesMapper::toRol);
    }

    @Override
    @Transactional
    public Roles save(Roles rol) {
        log.info("Guardando nuevo documento: {}", rol);
        if (rol == null) {
            throw new IllegalArgumentException("El rol no puede ser nulo");
        }

        if (rol.getNombre() == null || rol.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre del rol no puede ser nulo o vacío");
        }

        RolesEntity entity = rolesMapper.toRolEntity(rol);
        RolesEntity entitySave = rolesCrudRepository.save(entity);
        log.info("Role guardado con exito: {}", entitySave);

        return rolesMapper.toRol(entitySave);
    }

    @Override
    @Transactional
    public Optional<Roles> update(String codigoDocumento, Roles rol) {
        log.info("Guardando nuevo documento: {}", rol);
        if (codigoDocumento == null) {
            throw new IllegalArgumentException("El código del rol no puede ser nulo");
        }

        if (rol == null) {
            throw new IllegalArgumentException("El rol no puede ser nulo");
        }

        if (rol.getNombre() == null || rol.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre del rol no puede ser nulo o vacío");
        }

        RolesEntity entity = rolesMapper.toRolEntity(rol);
        RolesEntity entitySave = rolesCrudRepository.save(entity);
        log.info("Role guardado con exito: {}", entitySave);

        return Optional.of(rolesMapper.toRol(entitySave));
    }

    @Override
    @Transactional
    public boolean delete(int rolId) {
        if (rolId == 0 || rolId <= 0 ) {
            throw new IllegalArgumentException("El id del rol no puede ser 0 o negativo");
        }

        if (!existsById(rolId)) {
            log.warn("No se encontró rol con rolId: {}", rolId);
            return false;
        }

        try {
            rolesCrudRepository.deleteById(rolId);
            log.info("Rol eliminado correctamente");
            return true;
        } catch (Exception e) {
            log.error("Error al eliminar rol: {}", e.getMessage());
            throw new IllegalStateException("No se puede eliminar el rol porque está siendo utilizado", e);
        }

    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(int rolId) {
        return rolesCrudRepository.existsById(rolId);
    }
}
