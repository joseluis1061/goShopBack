package com.jlzDev.goShop.persistence.crud;

import com.jlzDev.goShop.persistence.entity.PuntosVenta;
import com.jlzDev.goShop.persistence.entity.Roles;
import com.jlzDev.goShop.persistence.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuariosCrudRepository extends JpaRepository<Usuarios, Integer> {
    Optional<Usuarios> findByEmail(String email);
    List<Usuarios> findByRol(Roles rol);
    List<Usuarios> findByPuntoVenta(PuntosVenta puntoVenta);
    List<Usuarios> findByEstadoTrue();
}
