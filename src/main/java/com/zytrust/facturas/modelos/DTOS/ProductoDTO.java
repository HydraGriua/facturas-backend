/*
 * @(#)CategoriaProducto.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.modelos.DTOS;

import java.math.BigDecimal;

/**
 * Esta interfaz representa un dto de producto y debe ser usada para obtener
 * datos a traves de los repositorios.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 14/02/2022
 */

public interface ProductoDTO {

    /** Identificador de producto */
    String getCodProducto();

    /** Nombre de producto */
    String getNombre();

    /** Descripcion de producto */
    String getDescripcion();

    /** Precio de venta unitario de producto */
    BigDecimal getPrecioVenta();

    /** Identificador de Categoria de producto */
    String getCodCategoria();
}
