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
 * Esta interfaz representa un dto de detalle de factura y debe ser usada
 * para obtener datos a traves de los repositorios.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 14/02/2022
 */

public interface DetalleFacturaDTO {

    /** Identificador de factura */
    String getCodFactura();

    /** Identificador de producto */
    String getCodProducto();

    /** Cantidad del producto en el detalle de factura */
    BigDecimal getCantidadProducto();

    /** Importe a pagar en detalle de factura */
    BigDecimal getImporteDetalle();
}
