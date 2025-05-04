package com.jlzDev.goShop.persistence.repository;

import com.jlzDev.goShop.persistence.entity.MovimientosInventarioEntity;
import com.jlzDev.goShop.persistence.entity.BodegasEntity;
import com.jlzDev.goShop.persistence.entity.PuntosVentaEntity;
import com.jlzDev.goShop.domain.layer.TipoMovimientoEnum;
import com.jlzDev.goShop.domain.layer.EstadoMovimientoEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovimientosInventarioCrudRepository extends JpaRepository<MovimientosInventarioEntity, Integer> {
    List<MovimientosInventarioEntity> findByBodegaOrigen(BodegasEntity bodegaOrigen);
    List<MovimientosInventarioEntity> findByBodegaDestino(BodegasEntity bodegaDestino);
    List<MovimientosInventarioEntity> findByPuntoVentaOrigen(PuntosVentaEntity puntoVentaOrigen);
    List<MovimientosInventarioEntity> findByPuntoVentaDestino(PuntosVentaEntity puntoVentaDestino);
    List<MovimientosInventarioEntity> findByTipoMovimiento(TipoMovimientoEnum tipoMovimiento);
    List<MovimientosInventarioEntity> findByEstado(EstadoMovimientoEnum estado);
    List<MovimientosInventarioEntity> findByFechaBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);
}