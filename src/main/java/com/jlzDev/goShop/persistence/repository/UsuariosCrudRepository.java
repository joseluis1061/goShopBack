package com.jlzDev.goShop.persistence.repository;

import com.jlzDev.goShop.persistence.entity.PuntosVentaEntity;
import com.jlzDev.goShop.persistence.entity.RolesEntity;
import com.jlzDev.goShop.persistence.entity.UsuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuariosCrudRepository extends JpaRepository<UsuariosEntity, Integer> {
    Optional<UsuariosEntity> findByEmail(String email);
    List<UsuariosEntity> findByRol(RolesEntity rol);
    List<UsuariosEntity> findByPuntoVenta(PuntosVentaEntity puntoVenta);
    List<UsuariosEntity> findByEstadoTrue();
}
