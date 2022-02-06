package com.zytrust.facturas.servicios;

import com.zytrust.facturas.dtos.CreateFacturaDto;
import com.zytrust.facturas.dtos.FacturaDto;
import com.zytrust.facturas.modelos.Factura;

import java.util.List;

public interface FacturaServicio {
    List<FacturaDto> getAll();
    FacturaDto getFactura(String id) throws Exception;
    FacturaDto createFactura(CreateFacturaDto factura) throws Exception;
}
