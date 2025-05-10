package com.jlzDev.goShop.persistence.repository;

import com.jlzDev.goShop.persistence.entity.DetalleMovimientoEntity;
import com.jlzDev.goShop.persistence.entity.MovimientosInventarioEntity;
import com.jlzDev.goShop.persistence.entity.ProductosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DetalleMovimientoCrudRepository extends JpaRepository<DetalleMovimientoEntity, Integer> {
    List<DetalleMovimientoEntity> findByMovimientoInventario(MovimientosInventarioEntity movimientoInventario);
    List<DetalleMovimientoEntity> findByProducto(ProductosEntity producto);

    @Query("SELECT SUM(d.cantidad) FROM DetalleMovimientoEntity d WHERE d.producto.idProducto = :productoId AND d.movimientoInventario.estado = 'COMPLETADO'")
    Integer sumCantidadByProductoIdAndMovimientoCompletado(@Param("productoId") Integer productoId);
}