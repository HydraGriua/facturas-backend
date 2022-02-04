package com.zytrust.facturas.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.math.BigDecimal;

@Getter
@Setter
public class CreateDetalleFacturaDto {
    private BigDecimal cantidad;

    private BigDecimal importe;

    private String facturaId;

    private String productoId;

}
