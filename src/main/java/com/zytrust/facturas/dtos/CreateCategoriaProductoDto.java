package com.zytrust.facturas.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class CreateCategoriaProductoDto {
    private String nombre;

    private String descripcion;
}
