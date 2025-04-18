package com.jlzDev.goShop.persistence.entity;

import com.jlzDev.goShop.domain.model.EstadoVenta;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
@Entity
@Table(name = "ventas")
public class Ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Integer idVenta;

    @Column(name = "numero_factura")
    private String numeroFactura;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Column(name = "subtotal")

    private Double subtotal;

    @Column(name = "impuesto")
    private Double impuesto;

    @Column(name = "total")
    private Double total;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoVenta estado;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "id_punto_venta")
    private PuntosVenta puntoVenta;

    @OneToMany(mappedBy = "venta")
    private List<DetalleVenta> detallesVenta;
}
