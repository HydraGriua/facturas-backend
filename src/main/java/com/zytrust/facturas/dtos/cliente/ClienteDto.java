package com.zytrust.facturas.dtos.cliente;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ClienteDto {

    private String clienteId;
    private String numDocumento;
    private String tipoDocumento;
    private String primerNombre;
    private String primerApellido;
    private LocalDate fechaNacimiento;
    private Character genero;
    private String email;
    private String celular;
    private String direccion;
    private String nombreEmpresa;
}
