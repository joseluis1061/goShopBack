package com.jlzDev.goShop.persistence.entity;

import com.jlzDev.goShop.domain.model.EstadoMovimiento;
import com.jlzDev.goShop.domain.model.TipoMovimiento;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "movimientos_inventario")
public class MovimientosInventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento")
    private Integer idMovimiento;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_movimiento")
    private TipoMovimiento tipoMovimiento;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoMovimiento estado;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bodega_origen")
    private Bodegas bodegaOrigen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bodega_destino")
    private Bodegas bodegaDestino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_punto_venta_origen")
    private PuntosVenta puntoVentaOrigen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_punto_venta_destino")
    private PuntosVenta puntoVentaDestino;

    @OneToMany(mappedBy = "movimientoInventario")
    private List<DetalleMovimiento> movimientosInventario;

}
