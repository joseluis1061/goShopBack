package com.jlzDev.goShop.persistence.entity;
import jakarta.persistence.*;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name="puntos_venta")
public class PuntosVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_punto_venta")
    private Integer idPuntoVenta;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "estado")
    private Boolean estado;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "puntoVenta")
    private List<Usuarios> usuarios;

    @OneToMany(mappedBy = "puntoVenta")
    private List<Ventas> ventas;

    @OneToMany(mappedBy = "puntoVenta")
    private List<InventariosPV> inventariosPV;

    @OneToMany(mappedBy = "puntoVentaOrigen")
    private List<MovimientosInventario> movimientosOrigen;

    @OneToMany(mappedBy = "puntoVentaDestino")
    private List<MovimientosInventario> movimientosDestino;
}
