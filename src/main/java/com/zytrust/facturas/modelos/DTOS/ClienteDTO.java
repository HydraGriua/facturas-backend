package com.zytrust.facturas.modelos.DTOS;

import java.time.LocalDate;

public interface ClienteDTO {
    String getCodCliente();
    String getNroDocumento();
    String getTipoDocumento();
    String getNombre();
    String getApellido();
    LocalDate getFechaNacimiento();
    Character getGenero();
    String getEmail();
    String getCelular();
    String getDireccion();
    String getNombreEmpresa();
    Integer getNumFacturas();
}
