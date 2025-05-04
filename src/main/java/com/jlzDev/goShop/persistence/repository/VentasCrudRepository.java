package com.jlzDev.goShop.persistence.repository;

import com.jlzDev.goShop.persistence.entity.VentasEntity;
import com.jlzDev.goShop.persistence.entity.UsuariosEntity;
import com.jlzDev.goShop.persistence.entity.PuntosVentaEntity;
import com.jlzDev.goShop.domain.layer.EstadoVentaEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface VentasCrudRepository extends JpaRepository<VentasEntity, Integer> {
    Optional<VentasEntity> findByNumeroFactura(String numeroFactura);
    List<VentasEntity> findByUsuario(UsuariosEntity usuario);
    List<VentasEntity> findByPuntoVenta(PuntosVentaEntity puntoVenta);
    List<VentasEntity> findByEstado(EstadoVentaEnum estado);
    List<VentasEntity> findByFechaBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    @Query("SELECT SUM(v.total) FROM Ventas v WHERE v.fecha BETWEEN :fechaInicio AND :fechaFin AND v.estado = 'PAGADA'")
    Double sumTotalByFechaBetweenAndEstadoPagada(@Param("fechaInicio") LocalDateTime fechaInicio, @Param("fechaFin") LocalDateTime fechaFin);

    @Query("SELECT SUM(v.total) FROM Ventas v WHERE v.fecha BETWEEN :fechaInicio AND :fechaFin")
    Double sumTotalByFechaBetween(@Param("fechaInicio") LocalDateTime fechaInicio, @Param("fechaFin") LocalDateTime fechaFin);
}