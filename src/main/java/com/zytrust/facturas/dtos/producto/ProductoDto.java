/*
 * @(#)ProductoDto.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.dtos.producto;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Esta clase representa a un dto de producto y debe ser usada para almacenar
 * datos y mapearlos con una entidad producto.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductoDto implements Serializable{

    /** Id de serializacion */
    private static final long serialVersionUID = 1L;

    /** Identificador de producto */
    private String productoId;

    /** Nombre de producto */
    private String nombre;

    /** Descripcion de producto */
    private String descripcion;

    /** Precio de venta unitario de producto */
    private BigDecimal precioUnitario;

    /** Categoria de producto */
    private String categoriaId;
}
