/*
 * @(#)CreateDetalleFacturaDto.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.dtos.detalle;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Esta clase representa a un dto de creacion de detalle de factura y debe ser usada para almacenar
 * datos y mapearlos con una entidad detalle de factura.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateDetalleFacturaDto implements Serializable{

    /** Id de serializacion */
    private static final long serialVersionUID = 1L;

    /** cantidad de producto  en el detalle de factura*/
    private BigDecimal cantidad;

    /** Identificador de factura */
    @NotEmpty
    @Size(min = 4, message = "Debe contener al menos 4 caracteres")
    private String facturaId;

    /** Identificador de producto */
    @NotEmpty
    @Size(min = 4, message = "Debe contener al menos 4 caracteres")
    private String productoId;

}
