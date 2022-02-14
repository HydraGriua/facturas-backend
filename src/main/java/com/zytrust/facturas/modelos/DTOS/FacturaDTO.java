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
import java.time.LocalDateTime;

/**
 * Esta interfaz representa un dto de factura y debe ser usada para obtener
 * datos a traves de los repositorios.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 11/02/2022
 */

public interface FacturaDTO {

    /** Identificador de factura */
    String getCodFactura();

    /** Direccion de emision de factura */
    String getDireccion();

    /** Fecha y Hora de emision de factura */
    LocalDateTime getFechaHoraEmision();

    /** Fecha y Hora de pago de factura */
    LocalDateTime getFechaHoraPago();

    /** Tipo de pago de factura */
    String getTipoPago();

    /** Estado de factura */
    String getEstado();

    /** subtotal a pagar de factura */
    BigDecimal getSubtotal();

    /** Impuesto a pagar de factura */
    BigDecimal getImpuesto();

    /** Total a pagar de factura */
    BigDecimal getTotal();

    /** Identificador de cliente al que pertenece factura */
    String getCodCliente();

    /** Cantidad del productos en la factura */
    Integer getNumProductos();
}
