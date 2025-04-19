package com.jlzDev.goShop.persistence.crud;

import com.jlzDev.goShop.persistence.entity.DetalleVenta;
import com.jlzDev.goShop.persistence.entity.Ventas;
import com.jlzDev.goShop.persistence.entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DetalleVentaCrudRepository extends JpaRepository<DetalleVenta, Integer> {
    List<DetalleVenta> findByVenta(Ventas venta);
    List<DetalleVenta> findByProducto(Productos producto);

    @Query("SELECT SUM(d.cantidad) FROM DetalleVenta d WHERE d.producto.idProducto = :productoId")
    Integer sumCantidadByProductoId(@Param("productoId") Integer productoId);
}