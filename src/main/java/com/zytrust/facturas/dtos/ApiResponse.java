/*
 * @(#)ApiResponse.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.dtos;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * Esta clase representa a un objeto response para el API y debe ser usada para almacenar
 * datos y exponerlos en los controladores.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

@Data
@ToString
public class ApiResponse<T> implements Serializable {

    /** Id de serializacion */
    private static final long serialVersionUID = 1L;

    /** Descripcion de estado del response */
    private String status;

    /** Codigo HTTP del response */
    private String code;

    /** Mensaje del response */
    private String message;

    /** Data que transporta el response */
    private T data;

    /**
     * Permite instanciar un response sin data para los controladores
     * @param status Estado del response a enviar
     * @param code Codigo HTTP a enviar
     * @param message Mensaje que se enviara con el response
     */
    public ApiResponse(String status, String code, String message){
        this.status = status;
        this.code = code;
        this.message = message;
    }

    /**
     * Permite instanciar un response conteniendo data para los controladores
     * @param status Estado del response a enviar
     * @param code Codigo HTTP a enviar
     * @param message Mensaje que se enviara con el response
     * @param data Objeto que se enviara junto con el Response
     */
    public ApiResponse(String status, String code, String message, T data){
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
