package com.zytrust.facturas.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.math.BigDecimal;

@Getter
@Setter
public class CreateProductoDto {
    private String nombre;

    private String descripcion;

    private BigDecimal precioUnitario;

    private String categoriaId;
}
