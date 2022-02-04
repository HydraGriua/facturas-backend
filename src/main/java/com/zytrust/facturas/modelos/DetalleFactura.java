package com.zytrust.facturas.modelos;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "fac_detalle_facturas")
public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "detfact_id",nullable = false)
    private String detalleId;

    @Column(name = "detfact_cantidad",nullable = false)
    private BigDecimal cantidad;

    @Column(name = "detfact_importe",precision=7, scale=2, nullable = false)
    private BigDecimal importe;

    // TODO: ORM Factura - Producto
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fact_id", nullable = false)
    private Factura factura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prod_id", nullable = false)
    private Producto producto;

}
