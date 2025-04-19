package com.jlzDev.goShop.persistence.crud;

import com.jlzDev.goShop.persistence.entity.Ventas;
import com.jlzDev.goShop.persistence.entity.Usuarios;
import com.jlzDev.goShop.persistence.entity.PuntosVenta;
import com.jlzDev.goShop.domain.model.EstadoVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface VentasCrudRepository extends JpaRepository<Ventas, Integer> {
    // Métodos personalizados si son necesarios
    Optional<Ventas> findByNumeroFactura(String numeroFactura);
    List<Ventas> findByUsuario(Usuarios usuario);
    List<Ventas> findByPuntoVenta(PuntosVenta puntoVenta);
    List<Ventas> findByEstado(EstadoVenta estado);
    List<Ventas> findByFechaBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    @Query("SELECT SUM(v.total) FROM Ventas v WHERE v.fecha BETWEEN :fechaInicio AND :fechaFin AND v.estado = 'PAGADA'")
    Double sumTotalByFechaBetweenAndEstadoPagada(@Param("fechaInicio") LocalDateTime fechaInicio, @Param("fechaFin") LocalDateTime fechaFin);

    @Query("SELECT SUM(v.total) FROM Ventas v WHERE v.fecha BETWEEN :fechaInicio AND :fechaFin")
    Double sumTotalByFechaBetween(@Param("fechaInicio") LocalDateTime fechaInicio, @Param("fechaFin") LocalDateTime fechaFin);
}