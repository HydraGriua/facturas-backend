package com.zytrust.facturas.dtos.Factura;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class CreateFacturaDto {

    @NotEmpty
    @Size(min = 4, message = "Debe contener al menos 4 caracteres")
    private String direccion;

    private LocalDateTime fechaEmision;

    private LocalDateTime fechaPago;

    @NotEmpty
    @Size(min = 4, message = "Debe contener al menos 4 caracteres")
    private String tipoPago;

    private BigDecimal subtotal;

    @NotEmpty
    @Size(min = 4, message = "Debe contener al menos 4 caracteres")
    private String clienteId;
}
