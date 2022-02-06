package com.zytrust.facturas.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class FacturaDto {
    private String facturaId;

    private String direccion;

    private LocalDateTime fechaEmision;

    private LocalDateTime fechaPago;

    private String tipoPago;

    private BigDecimal subtotal;

    private BigDecimal impuesto;

    private BigDecimal total;

    private String clienteId;
}
