package com.jlzDev.goShop.persistence.crud;

import com.jlzDev.goShop.persistence.entity.PuntosVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PuntosVentaCrudRepository extends JpaRepository<PuntosVenta, Integer> {
    List<PuntosVenta> findByEstadoTrue();
    PuntosVenta findByNombre(String nombre);
}