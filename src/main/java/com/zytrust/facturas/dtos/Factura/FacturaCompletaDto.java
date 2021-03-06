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

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.zytrust.facturas.dtos.detalle.CreateDetalleSimpleDto;

/**
 * Esta clase representa a un dto de creacion de factura completa y debe ser usada para almacenar
 * datos y mapearlos con entidades factura y detalle de factura.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 08/02/2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FacturaCompletaDto implements Serializable{

    /** Id de serializacion */
    private static final long serialVersionUID = 1L;

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
