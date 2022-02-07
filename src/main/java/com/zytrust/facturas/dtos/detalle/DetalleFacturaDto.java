package com.zytrust.facturas.dtos.detalle;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DetalleFacturaDto {

    private String facturaId;
    private String productoId;
    private BigDecimal cantidad;
    private BigDecimal importe;

}
