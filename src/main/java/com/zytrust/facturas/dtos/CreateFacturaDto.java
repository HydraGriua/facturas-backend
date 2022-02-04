package com.zytrust.facturas.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class CreateFacturaDto {
    private String direccion;

    private LocalDateTime fechaEmision;

    private LocalDateTime fechaPago;

    private String tipoPago;

    private Character estado;

    private BigDecimal subtotal;

    private BigDecimal impuesto;

    private BigDecimal total;

    private String clienteId;
}
