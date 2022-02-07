/*
 * @(#)Producto.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.modelos;

import java.math.BigDecimal;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

/**
 * Esta clase representa a un producto y debe ser usada para almacenar
 * datos e intercambiarlos con otros objetos.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "FAC_PRODUCTOS")
public class Producto {

    /** Identificador de producto */
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "PROD_ID", length = 50, nullable = false)
    private String productoId;

    /** Nombre de producto */
    @Column(name = "PROD_NOM", length = 40, nullable = false)
    private String nombre;

    /** Descripcion de producto */
    @Column(name = "PROD_DESCRIPCION", nullable = false)
    private String descripcion;

    /** Precio de venta unitario de producto */
    @Column(name = "PROD_PRECIO_UNIT",precision=5, scale=2,nullable = false)
    private BigDecimal precioUnitario;

    /** Categoria de producto */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATPROD_ID", nullable = false)
    private CategoriaProducto categoria;
}
