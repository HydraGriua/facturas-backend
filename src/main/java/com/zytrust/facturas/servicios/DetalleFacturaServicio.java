package com.zytrust.facturas.servicios;

import com.zytrust.facturas.dtos.detalle.CreateDetalleFacturaDto;
import com.zytrust.facturas.dtos.detalle.DetalleFacturaDto;
import com.zytrust.facturas.modelos.DetalleFactura;

import java.util.List;

public interface DetalleFacturaServicio {
    List<DetalleFacturaDto> getAll();
    List<DetalleFacturaDto> getAllByFacturaId(String facturaId) throws Exception;
    DetalleFacturaDto getDetalleFactura(String facturaId, String productoId) throws Exception;
    DetalleFacturaDto createDetalleFactura(CreateDetalleFacturaDto detalle) throws Exception;
}
