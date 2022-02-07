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

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * Esta clase representa a un dto de factura y debe ser usada para almacenar
 * datos y mapearlos con una entidad factura.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

@Getter
@Setter
public class FacturaDto {

    private String facturaId; /** Identificador de factura */
    private String direccion; /** Direccion de emision de factura */
    private LocalDateTime fechaEmision; /** Fecha y Hora de emision de factura */
    private LocalDateTime fechaPago; /** Fecha y Hora de pago de factura */
    private String tipoPago; /** Tipo de pago de factura */
    private Character estado; /** Estado de factura */
    private BigDecimal subtotal; /** subtotal a pagar de factura */
    private BigDecimal impuesto; /** Impuesto a pagar de factura */
    private BigDecimal total; /** Total a pagar de factura */
    private String clienteId; /** Identificador de cliente */
}
