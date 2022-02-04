package com.zytrust.facturas.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
public class CreateClienteDto {

    @NotEmpty
    @Size(min = 4, message = "Debe contener al menos 4 caracteres")
    private String numDocumento;

    @NotEmpty
    @Size(min = 4, message = "Debe contener al menos 4 caracteres")
    private String tipoDocumento;

    @NotEmpty
    @Size(min = 4, message = "Debe contener al menos 4 caracteres")
    private String primerNombre;

    @NotEmpty
    @Size(min = 4, message = "Debe contener al menos 4 caracteres")
    private String primerApellido;

    private LocalDate fechaNacimiento;

    private Character genero;

    @NotEmpty
    @Size(min = 4, message = "Debe contener al menos 4 caracteres")
    private String email;

    @NotEmpty
    @Size(min = 4, message = "Debe contener al menos 4 caracteres")
    private String celular;

    @NotEmpty
    @Size(min = 4, message = "Debe contener al menos 4 caracteres")
    private String direccion;

    @NotEmpty
    @Size(min = 4, message = "Debe contener al menos 4 caracteres")
    private String nombreEmpresa;
}
