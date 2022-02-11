/*
 * @(#)CategoriaProducto.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.modelos;

import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.annotations.GenericGenerator;

/**
 * Esta clase representa a una categoria de producto y debe ser usada para
 * almacenar
 * datos e intercambiarlos con otros objetos.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

@Getter
@Setter
@ToString
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "FAC_CATEGORIA_PRODUCTOS")
public class CategoriaProducto {

    /** Identificador de categoria de productos */
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "CATPROD_ID", length = 50, nullable = false)
    private String categoriaId;

    /** Nombre de categoria de productos */
    @Column(name = "CATPROD_NOM", length = 40, nullable = false)
    private String nombre;

    /** Descripcion de categoria de productos */
    @Column(name = "CATPROD_DESCRIPCION", nullable = false)
    private String descripcion;

    /** Productos que pertenecen a la categoria */
    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Producto> productos;
}
