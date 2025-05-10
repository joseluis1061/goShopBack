package com.jlzDev.goShop.persistence.repository;

import com.jlzDev.goShop.persistence.entity.DetalleVentaEntity;
import com.jlzDev.goShop.persistence.entity.VentasEntity;
import com.jlzDev.goShop.persistence.entity.ProductosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DetalleVentaCrudRepository extends JpaRepository<DetalleVentaEntity, Integer> {
    List<DetalleVentaEntity> findByVenta(VentasEntity venta);
    List<DetalleVentaEntity> findByProducto(ProductosEntity producto);

    @Query("SELECT SUM(d.cantidad) FROM DetalleVentaEntity d WHERE d.producto.idProducto = :productoId")
    Integer sumCantidadByProductoId(@Param("productoId") Integer productoId);
}