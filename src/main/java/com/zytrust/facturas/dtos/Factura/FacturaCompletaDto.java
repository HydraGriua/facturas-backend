/*
 * @(#)FacturaCompletaDto.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */


package com.zytrust.facturas.dtos.Factura;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import com.zytrust.facturas.dtos.detalle.CreateDetalleSimpleDto;

/**
 * Esta clase representa a un dto de creacion de factura completa y debe ser usada para almacenar
 * datos y mapearlos con entidades factura y detalle de factura.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 08/02/2022
 */

@Getter
@Setter
public class FacturaCompletaDto {
    /** Direccion de emision de factura */
    @NotEmpty
    @Size(min = 4, message = "Debe contener al menos 4 caracteres")
    private String direccion;

    /** Identificador de cliente */
    @NotEmpty
    @Size(min = 4, message = "Debe contener al menos 4 caracteres")
    private String clienteId;

    /** Lista de dto simples de creacion para detalles */
    private CreateDetalleSimpleDto[] detalles;
}
