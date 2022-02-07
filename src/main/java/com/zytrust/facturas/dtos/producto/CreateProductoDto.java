package com.zytrust.facturas.dtos.producto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
public class CreateProductoDto {

    @NotEmpty
    @Size(min = 4, message = "Debe contener al menos 4 caracteres")
    private String nombre;

    @NotEmpty
    @Size(min = 4, message = "Debe contener al menos 4 caracteres")
    private String descripcion;

    private BigDecimal precioUnitario;

    @NotEmpty
    @Size(min = 4, message = "Debe contener al menos 4 caracteres")
    private String categoriaId;
}
