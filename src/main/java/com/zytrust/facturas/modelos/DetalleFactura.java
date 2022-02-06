package com.zytrust.facturas.modelos;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "FAC_DETALLE_FACTURAS")
public class DetalleFactura {

    @EmbeddedId
    private DetalleFacturaId detalleFacturaId;

    @Column(name = "DETFACT_CANTIDAD",nullable = false)
    private BigDecimal cantidad;

    @Column(name = "DETFACT_IMPORTE",precision=7, scale=2, nullable = false)
    private BigDecimal importe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FACT_ID", nullable = false)
    @MapsId("DETFACT_FACT_ID")
    private Factura factura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROD_ID", nullable = false)
    @MapsId("DETFACT_PROD_ID")
    private Producto producto;

}

@Data
@Embeddable
class DetalleFacturaId implements Serializable {

    @Column(name = "DETFACT_FACT_ID")
    private String facturaId;

    @Column(name = "DETFACT_PROD_ID")
    private String productoId;
}
