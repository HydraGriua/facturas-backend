package com.zytrust.facturas.modelos.DTOS;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface FacturaDTO {
    String getCodFactura();
    String getDireccion();
    LocalDateTime getFechaHoraEmision();
    LocalDateTime getFechaHoraPago();
    String getTipoPago();
    String getEstado();
    BigDecimal getSubtotal();
    BigDecimal getImpuesto();
    BigDecimal getTotal();
    String getCodCliente();
    Integer getNumProductos();
}
