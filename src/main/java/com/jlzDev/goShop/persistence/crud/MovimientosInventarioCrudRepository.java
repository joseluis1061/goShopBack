package com.jlzDev.goShop.persistence.crud;

import com.jlzDev.goShop.persistence.entity.MovimientosInventario;
import com.jlzDev.goShop.persistence.entity.Bodegas;
import com.jlzDev.goShop.persistence.entity.PuntosVenta;
import com.jlzDev.goShop.domain.model.TipoMovimiento;
import com.jlzDev.goShop.domain.model.EstadoMovimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovimientosInventarioCrudRepository extends JpaRepository<MovimientosInventario, Integer> {
    List<MovimientosInventario> findByBodegaOrigen(Bodegas bodegaOrigen);
    List<MovimientosInventario> findByBodegaDestino(Bodegas bodegaDestino);
    List<MovimientosInventario> findByPuntoVentaOrigen(PuntosVenta puntoVentaOrigen);
    List<MovimientosInventario> findByPuntoVentaDestino(PuntosVenta puntoVentaDestino);
    List<MovimientosInventario> findByTipoMovimiento(TipoMovimiento tipoMovimiento);
    List<MovimientosInventario> findByEstado(EstadoMovimiento estado);
    List<MovimientosInventario> findByFechaBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);
}