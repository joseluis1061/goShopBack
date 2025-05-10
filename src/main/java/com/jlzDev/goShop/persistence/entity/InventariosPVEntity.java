package com.jlzDev.goShop.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "inventarios_pv")
public class InventariosPVEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_inventario_pv")
    private Integer idInventarioPV;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "stock_minimo")
    private Integer stockMinimo;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private ProductosEntity producto;

    @ManyToOne
    @JoinColumn(name = "id_punto_venta")
    private PuntosVentaEntity puntoVenta;

}
