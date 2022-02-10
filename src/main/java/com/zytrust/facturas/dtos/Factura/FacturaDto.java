/*
 * @(#)FacturaDto.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.dtos.Factura;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Esta clase representa a un dto de factura y debe ser usada para almacenar
 * datos y mapearlos con una entidad factura.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FacturaDto implements Serializable{

    /** Id de serializacion */
    private static final long serialVersionUID = 1L;

    /** Identificador de factura */
    private String facturaId;

    /** Direccion de emision de factura */
    private String direccion;

    /** Fecha y Hora de emision de factura */
    private LocalDateTime fechaEmision;

    /** Fecha y Hora de pago de factura */
    private LocalDateTime fechaPago;

    /** Tipo de pago de factura */
    private String tipoPago;

    /** Estado de factura */
    private Character estado;

    /** subtotal a pagar de factura */
    private BigDecimal subtotal;

    /** Impuesto a pagar de factura */
    private BigDecimal impuesto;

    /** Total a pagar de factura */
    private BigDecimal total;

    /** Identificador de cliente */
    private String clienteId;
}