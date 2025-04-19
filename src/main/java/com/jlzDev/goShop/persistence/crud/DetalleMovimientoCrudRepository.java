package com.jlzDev.goShop.persistence.crud;

import com.jlzDev.goShop.persistence.entity.DetalleMovimiento;
import com.jlzDev.goShop.persistence.entity.MovimientosInventario;
import com.jlzDev.goShop.persistence.entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DetalleMovimientoCrudRepository extends JpaRepository<DetalleMovimiento, Integer> {
    List<DetalleMovimiento> findByMovimientoInventario(MovimientosInventario movimientoInventario);
    List<DetalleMovimiento> findByProducto(Productos producto);

    @Query("SELECT SUM(d.cantidad) FROM DetalleMovimiento d WHERE d.producto.idProducto = :productoId AND d.movimientoInventario.estado = 'COMPLETADO'")
    Integer sumCantidadByProductoIdAndMovimientoCompletado(@Param("productoId") Integer productoId);
}