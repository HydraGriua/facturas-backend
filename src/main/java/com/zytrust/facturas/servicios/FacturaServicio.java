package com.zytrust.facturas.servicios;

import com.zytrust.facturas.dtos.Factura.CreateFacturaDto;
import com.zytrust.facturas.dtos.Factura.FacturaDto;

import java.util.List;

public interface FacturaServicio {
    List<FacturaDto> getAll();
    FacturaDto getFactura(String id) throws Exception;
    FacturaDto createFactura(CreateFacturaDto factura) throws Exception;
}
