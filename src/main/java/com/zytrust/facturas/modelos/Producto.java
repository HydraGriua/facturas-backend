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
@Table(name = "FAC_PRODUCTOS")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PROD_ID",nullable = false)
    private String productoId;

    @Column(name = "PROD_NOM",nullable = false)
    private String nombre;

    @Column(name = "PROD_DESCRIPCION",nullable = false)
    private String descripcion;

    @Column(name = "PROD_PRECIO_UNIT",precision=5, scale=2,nullable = false)
    private BigDecimal precioUnitario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATPROD_ID", nullable = false)
    private CategoriaProducto categoria;
}
