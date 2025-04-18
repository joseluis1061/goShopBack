package com.jlzDev.goShop.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "detalle_movimiento")
public class DetalleMovimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_movimiento")
    private Integer idDetalleMovimiento;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "id_movimiento")
    private MovimientosInventario movimientoInventario;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Productos producto;
}