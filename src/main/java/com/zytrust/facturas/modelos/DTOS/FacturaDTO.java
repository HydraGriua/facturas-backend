/*
 * @(#)CategoriaProducto.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.modelos.DTOS;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Esta interfaz representa un dto de factura y debe ser usada para obtener
 * datos a traves de los repositorios.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 11/02/2022
 */

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
