/*
 * @(#)Factura.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.modelos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

/**
 * Esta clase representa a una factura y debe ser usada para almacenar
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
@Table(name = "FAC_FACTURAS")
public class Factura {

    /** Identificador de factura */
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "FACT_ID", length = 50, nullable = false)
    private String facturaId;

    /** Direccion de emision de factura */
    @Column(name = "FACT_DIRECCION", length = 200, nullable = false)
    private String direccion;

    /** Fecha y Hora de emision de factura */
    @Column(name = "FACT_FECHA_EMISION", nullable = false)
    private LocalDateTime fechaHoraEmision;

    /** Fecha y Hora de pago de factura */
    @Column(name = "FACT_FECHA_PAGO")
    private LocalDateTime fechaHoraPago;

    /** Tipo de pago de factura */
    @Column(name = "FACT_TIPO_PAGO", length = 20)
    private String tipoPago;

    /** Estado de factura */
    @Column(name = "FACT_ESTADO", nullable = false)
    private Character estado;

    /** subtotal a pagar de factura */
    @Column(name = "FACT_SUBTOTAL", precision = 7, scale = 2, nullable = false)
    private BigDecimal subtotal;

    /** Impuesto a pagar de factura */
    @Column(name = "FACT_IMPUESTO", precision = 7, scale = 2, nullable = false)
    private BigDecimal impuesto;

    /** Total a pagar de factura */
    @Column(name = "FACT_TOTAL", precision = 7, scale = 2, nullable = false)
    private BigDecimal total;

    /** Cliente al que pertenece factura */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLI_ID", nullable = false)
    private Cliente cliente;

    /** Detalle de factura */
    @OneToMany(mappedBy = "factura", fetch = FetchType.LAZY)
    private List<DetalleFactura> detalles;
}
