package com.zytrust.facturas.modelos;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "fac_facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fact_id",nullable = false)
    private String facturaId;

    @Column(name = "fact_direccion",nullable = false)
    private String direccion;

    @Column(name = "fact_fecha_emision",nullable = false)
    private LocalDateTime fechaEmision;

    @Column(name = "fact_fecha_pago",nullable = false)
    private LocalDateTime fechaPago;

    @Column(name = "fact_tipo_pago",nullable = false)
    private String tipoPago;

    @Column(name = "fact_estado",nullable = false)
    private Character estado;

    @Column(name = "fact_subtotal", precision=7, scale=2, nullable = false)
    private BigDecimal subtotal;

    @Column(name = "fact_impuesto",precision=7, scale=2, nullable = false)
    private BigDecimal impuesto;

    @Column(name = "fact_total", precision=7, scale=2, nullable = false)
    private BigDecimal total;


    // TODO: ORM Cliente - Detalles
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cli_id", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "factura", fetch = FetchType.LAZY)
    private List<DetalleFactura> detalles;
}
