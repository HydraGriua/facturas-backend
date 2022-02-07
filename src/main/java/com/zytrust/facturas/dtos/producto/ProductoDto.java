package com.zytrust.facturas.dtos.producto;

import javax.persistence.Column;
import java.math.BigDecimal;

public class ProductoDto {

    private String productoId;
    private String nombre;
    private String descripcion;
    private BigDecimal precioUnitario;
    private String categoriaId;
}
