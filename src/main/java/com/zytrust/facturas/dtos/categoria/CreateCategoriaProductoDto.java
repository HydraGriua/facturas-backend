package com.zytrust.facturas.dtos.categoria;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateCategoriaProductoDto {

    @NotEmpty
    @Size(min = 4, message = "Debe contener al menos 4 caracteres")
    private String nombre;

    @NotEmpty
    @Size(min = 4, message = "Debe contener al menos 4 caracteres")
    private String descripcion;
}
