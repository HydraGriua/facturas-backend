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

/**
 * Esta interfaz representa un dto de categoria de producto y debe ser usada para obtener
 * datos a traves de los repositorios.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 11/02/2022
 */

public interface CategoriaProductoDTO {

    /** Identificador de categoria de productos */
    String getCodCategoria();

    /** Nombre de categoria de productos */
    String getNombre();

    /** Descripcion de categoria de productos */
    String getDescripcion();

    /** Cantidad de productos que pertenecen a la categoria */
    Integer getNumProductos();
}
