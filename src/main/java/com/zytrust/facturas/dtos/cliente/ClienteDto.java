package com.zytrust.facturas.dtos.cliente;

import javax.persistence.Column;
import java.time.LocalDate;

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
