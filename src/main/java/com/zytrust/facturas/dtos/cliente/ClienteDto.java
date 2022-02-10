/*
 * @(#)ClienteDto.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.dtos.cliente;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Esta clase representa a un dto de cliente y debe ser usada para almacenar
 * datos y mapearlos con una entidad cliente.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClienteDto implements Serializable{

    /** Id de serializacion */
    private static final long serialVersionUID = 1L;

    /** Identificador de cliente */
    private String clienteId;

    /** Numero identificador de documento de cliente */
    private String numDocumento;

    /** Tipo de documento de cliente */
    private String tipoDocumento;

    /** Primer nombre de cliente */
    private String primerNombre;

    /** Primer apellido de cliente */
    private String primerApellido;

    /** Fecha de nacimiento de cliente */
    private LocalDate fechaNacimiento;

     /** Genero de cliente */
    private Character genero;

    /** Email de cliente */
    private String email;

    /** Celular de cliente */
    private String celular;

    /** Direccion de cliente */
    private String direccion;

    /** Nombre de empresa donde labora el cliente */
    private String nombreEmpresa;
}
