package com.zytrust.facturas.dtos.detalle;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
public class CreateDetalleFacturaDto {

    private BigDecimal cantidad;

    @NotEmpty
    @Size(min = 4, message = "Debe contener al menos 4 caracteres")
    private String facturaId;

    @NotEmpty
    @Size(min = 4, message = "Debe contener al menos 4 caracteres")
    private String productoId;

}
