package com.zytrust.facturas.modelos;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

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
@Table(name = "FAC_FACTURAS")
public class Factura {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "FACT_ID",nullable = false)
    private String facturaId;

    @Column(name = "FACT_DIRECCION",nullable = false)
    private String direccion;

    @Column(name = "FACT_FECHA_EMISION",nullable = false)
    private LocalDateTime fechaHoraEmision;

    @Column(name = "FACT_FECHA_PAGO",nullable = false)
    private LocalDateTime fechaHoraPago;

    @Column(name = "FACT_TIPO_PAGO",nullable = false)
    private String tipoPago;

    @Column(name = "FACT_ESTADO",nullable = false)
    private Character estado;

    @Column(name = "FACT_SUBTOTAL", precision=7, scale=2, nullable = false)
    private BigDecimal subtotal;

    @Column(name = "FACT_IMPUESTO",precision=7, scale=2, nullable = false)
    private BigDecimal impuesto;

    @Column(name = "FACT_TOTAL", precision=7, scale=2, nullable = false)
    private BigDecimal total;


    // TODO:
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLI_id", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "factura", fetch = FetchType.LAZY)
    private List<DetalleFactura> detalles;
}
