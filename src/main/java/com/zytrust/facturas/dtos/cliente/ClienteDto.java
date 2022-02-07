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

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 * Esta clase representa a un dto de cliente y debe ser usada para almacenar
 * datos y mapearlos con una entidad cliente.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

@Getter
@Setter
public class ClienteDto {

    private String clienteId; /** Identificador de cliente */
    private String numDocumento; /** Numero identificador de documento de cliente */
    private String tipoDocumento; /** Tipo de documento de cliente */
    private String primerNombre; /** Primer nombre de cliente */
    private String primerApellido; /** Primer apellido de cliente */
    private LocalDate fechaNacimiento; /** Fecha de nacimiento de cliente */
    private Character genero; /** Genero de cliente */
    private String email; /** Email de cliente */
    private String celular; /** Celular de cliente */
    private String direccion; /** Direccion de cliente */
    private String nombreEmpresa; /** Nombre de empresa donde labora el cliente */
}
