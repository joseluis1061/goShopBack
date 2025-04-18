package com.jlzDev.goShop.persistence.entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
@Entity
@Table(name="usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "estado")
    private Boolean estado;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Roles rol;

    @ManyToOne
    @JoinColumn(name = "id_punto_venta")
    private PuntosVenta puntoVenta;

    @OneToMany(mappedBy= "usuario")
    private List<Ventas> ventas;
}
