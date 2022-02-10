/*
 * @(#)CreateClienteDto.java
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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Esta clase representa a un dto de creacion de cliente y debe ser usada para almacenar
 * datos y mapearlos con una entidad cliente.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateClienteDto implements Serializable{

    /** Id de serializacion */
    private static final long serialVersionUID = 1L;

    /** Numero identificador de documento de cliente */
    @NotEmpty
    @Size(min = 4, message = "Debe contener al menos 4 caracteres")
    private String numDocumento;

    /** Tipo de documento de cliente */
    @NotEmpty
    @Size(min = 4, message = "Debe contener al menos 4 caracteres")
    private String tipoDocumento;

    /** Primer nombre de cliente */
    @NotEmpty
    @Size(min = 4, message = "Debe contener al menos 4 caracteres")
    private String primerNombre;

    /** Primer apellido de cliente */
    @NotEmpty
    @Size(min = 4, message = "Debe contener al menos 4 caracteres")
    private String primerApellido;

    /** Fecha de nacimiento de cliente */
    private LocalDate fechaNacimiento;

    /** Genero de cliente */
    private Character genero;

    /** Email de cliente */
    @NotEmpty
    @Size(min = 4, message = "Debe contener al menos 4 caracteres")
    private String email;

    /** Celular de cliente */
    @NotEmpty
    @Size(min = 4, message = "Debe contener al menos 4 caracteres")
    private String celular;

    /** Direccion de cliente */
    @NotEmpty
    @Size(min = 4, message = "Debe contener al menos 4 caracteres")
    private String direccion;

    /** Nombre de empresa donde labora el cliente */
    @NotEmpty
    @Size(min = 4, message = "Debe contener al menos 4 caracteres")
    private String nombreEmpresa;
}
