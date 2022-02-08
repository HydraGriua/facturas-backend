/*
 * @(#)CreateDetalleSimpleDto.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.dtos.detalle;

import java.math.BigDecimal;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * Esta clase representa a un dto de creacion de detalle de factura simple y debe ser usada para almacenar
 * datos e intercambioarlos con FacturaCompletaDto.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 08/02/2022
 */

@Getter
@Setter
public class CreateDetalleSimpleDto {

    /** cantidad de producto  en el detalle de factura*/
    private BigDecimal cantidad;

    /** Identificador de producto */
    @NotEmpty
    @Size(min = 4, message = "Debe contener al menos 4 caracteres")
    private String productoId;
}
