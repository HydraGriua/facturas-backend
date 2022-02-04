package com.zytrust.facturas.servicios;

import com.zytrust.facturas.dtos.CreateFacturaDto;
import com.zytrust.facturas.modelos.Factura;

import java.util.List;

public interface FacturaServicio {
    List<Factura> getAll();
    Factura getFactura(String id) throws Exception;
    Factura createFactura(CreateFacturaDto factura) throws Exception;
}
