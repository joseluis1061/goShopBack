package com.jlzDev.goShop.persistence.entity;
import jakarta.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="productos")
@Getter
@Setter
@NoArgsConstructor
public class ProductosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "imagen_url")
    private String imagenUrl;

    @Column(name = "estado")
    private Boolean estado;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    private CategoriasEntity categoria;

    @OneToMany(mappedBy = "producto")
    private List<InventariosEntity> inventarios;

    @OneToMany(mappedBy = "producto")
    private List<InventariosPVEntity> inventariosPV;

    @OneToMany(mappedBy = "producto")
    private List<DetalleVentaEntity> detallesVenta;

    @OneToMany(mappedBy = "producto")
    private List<DetalleMovimientoEntity> detallesMovimiento;
}
