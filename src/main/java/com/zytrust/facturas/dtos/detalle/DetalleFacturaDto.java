/*
 * @(#)DetalleFacturaDto.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.dtos.detalle;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * Esta clase representa a un dto de detalle de factura y debe ser usada para almacenar
 * datos y mapearlos con una entidad detalle de factura.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

@Getter
@Setter
public class DetalleFacturaDto {

    private String facturaId; /** Identificador de factura */
    private String productoId; /** Identificador de producto */
    private BigDecimal cantidad; /** cantidad de producto  en el detalle de factura*/
    private BigDecimal importe; /** Importe a pagar en detalle de factura */

}
