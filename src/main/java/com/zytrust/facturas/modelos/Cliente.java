/*
 * @(#)Cliente.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.modelos;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 * Esta clase representa a un cliente y debe ser usada para almacenar
 * datos e intercambiarlos con otros objetos.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "FAC_CLIENTES")
public class Cliente {

    /** Identificador de cliente */
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "CLIE_ID", length = 50, nullable = false)
    private String clienteId;

    /** Numero identificador de documento de cliente */
    @Column(name = "CLIE_NUM_DOC", length = 20, nullable = false)
    private String numDocumento;

    /** Tipo de documento de cliente */
    @Column(name = "CLIE_TIPO_DOC", length = 20, nullable = false)
    private String tipoDocumento;

    /** Primer nombre de cliente */
    @Column(name = "CLIE_PRIM_NOMBRE", length = 40, nullable = false)
    private String primerNombre;

    /** Primer apellido de cliente */
    @Column(name = "CLIE_PRIM_APELLIDO", length = 40, nullable = false)
    private String primerApellido;

    /** Fecha de nacimiento de cliente */
    @Column(name = "CLIE_FECHA_NACIMIENTO", nullable = false)
    private LocalDate fechaNacimiento;

    /** Genero de cliente */
    @Column(name = "CLIE_GENERO", nullable = false)
    private Character genero;

    /** Email de cliente */
    @Column(name = "CLIE_EMAIL", length = 30, nullable = false)
    private String email;

    /** Celular de cliente */
    @Column(name = "CLIE_CELULAR", length = 20, nullable = false)
    private String celular;

    /** Direccion de cliente */
    @Column(name = "CLIE_DIRECCION", nullable = false)
    private String direccion;

    /** Nombre de empresa donde labora el cliente */
    @Column(name = "CLIE_NOM_EMPRESA", length = 100, nullable = false)
    private String nombreEmpresa;

    /** Facturas pertenecientes al cliente */
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Factura> facturas;
}
