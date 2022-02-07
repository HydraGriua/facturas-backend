package com.zytrust.facturas.servicios;

import com.zytrust.facturas.dtos.detalle.CreateDetalleFacturaDto;
import com.zytrust.facturas.modelos.DetalleFactura;

import java.util.List;

public interface DetalleFacturaServicio {
    List<DetalleFactura> getAll();
    List<DetalleFactura> getAllByFacturaId(String facturaId) throws Exception;
    DetalleFactura getDetalleFactura(String id) throws Exception;
    DetalleFactura createDetalleFactura(CreateDetalleFacturaDto detalle) throws Exception;
}
