package com.zytrust.facturas.modelos;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "fac_productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "prod_id",nullable = false)
    private String productoId;

    @Column(name = "prod_nom",nullable = false)
    private String nombre;

    @Column(name = "prod_descripcion",nullable = false)
    private String descripcion;

    @Column(name = "prod_precio_unit",precision=5, scale=2,nullable = false)
    private BigDecimal precioUnitario;

    //TODO ORM Detalle - Categoria

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "catprod_id", nullable = false)
    private CategoriaProducto categoria;
}
