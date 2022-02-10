/*
 * @(#)CodigoError.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.utiles;

/**
 * Esta clase representa a un enum para codigos de error
 * y debe ser usada dentro de una excepcion
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

public enum CodigoError {

    CLIENTE_NO_EXISTE("El cliente con el id indicado no existe"),
    FACTURA_NO_EXISTE("La factura con el id indicado no existe"),
    DETALLE_FACTURA_NO_EXISTE("El detalle de factura con los id indicados no existe"),
    CATEGORIA_PRODUCTO_NO_EXISTE("La categoria de producto con el id indicado no existe"),
    PRODUCTO_NO_EXISTE("El producto con el id indicado no existe");

    private final String descripcion;

    CodigoError(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }
}
