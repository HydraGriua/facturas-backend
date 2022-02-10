/*
 * @(#)CreateFacturaDto.java
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

/**
 * Esta clase representa a un dto de creacion de factura y debe ser usada para almacenar
 * datos y mapearlos con una entidad factura.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateFacturaDto implements Serializable{

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
}
