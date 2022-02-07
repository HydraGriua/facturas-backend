/*
 * @(#)DetalleFactura.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.modelos;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import lombok.*;

/**
 * Esta clase representa a un detalle de factura y debe ser usada para almacenar
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
@Table(name = "FAC_DETALLE_FACTURAS")
public class DetalleFactura {

    /** Identificador de detalle de factura */
    @EmbeddedId
    private DetalleFacturaId detalleFacturaId;

    /** cantidad de producto  en el detalle de factura*/
    @Column(name = "DETFACT_CANTIDAD",nullable = false)
    private BigDecimal cantidad;

    /** Importe a pagar en detalle de factura */
    @Column(name = "DETFACT_IMPORTE",precision=7, scale=2, nullable = false)
    private BigDecimal importe;

    /** Factura de pertenencia de detalle */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FACT_ID", nullable = false)
    @MapsId("DETFACT_FACT_ID")
    private Factura factura;

    /** Producto en detalle de factura */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROD_ID", nullable = false)
    @MapsId("DETFACT_PROD_ID")
    private Producto producto;

}

/**
 * Esta clase representa al identificador de un detalle de factura y debe ser usada para almacenar
 * datos e intercambiarlos con un objeto de tipo DetalleFactura.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

@Data
@Embeddable
class DetalleFacturaId implements Serializable {

    /** Identificador de factura */
    @Column(name = "DETFACT_FACT_ID")
    private String facturaId;

    /** Identificador de producto */
    @Column(name = "DETFACT_PROD_ID")
    private String productoId;
}
