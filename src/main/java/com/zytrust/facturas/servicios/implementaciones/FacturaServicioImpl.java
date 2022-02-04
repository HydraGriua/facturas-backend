package com.zytrust.facturas.servicios.implementaciones;

import com.zytrust.facturas.dtos.CreateFacturaDto;
import com.zytrust.facturas.modelos.Cliente;
import com.zytrust.facturas.modelos.Factura;
import com.zytrust.facturas.repositorios.ClienteRepositorio;
import com.zytrust.facturas.repositorios.FacturaRepositorio;
import com.zytrust.facturas.servicios.FacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaServicioImpl implements FacturaServicio {

    @Autowired
    FacturaRepositorio facturaRepositorio;

    @Autowired
    ClienteRepositorio clienteRepositorio;

    @Override
    public List<Factura> getAll() {
        return facturaRepositorio.findAll();
    }

    @Override
    public Factura getFactura(String id) throws Exception {
        return facturaRepositorio.findById(id).orElseThrow(()-> new Exception("No se encontro Factura con id:" + id));
    }

    @Override
    public Factura createFactura(CreateFacturaDto factura) throws Exception {
        Cliente cliente = clienteRepositorio.findById(factura.getClienteId()).orElseThrow(()-> new Exception("No se encontro Cliente con id:" + factura.getClienteId()));
        Factura facturaEntidad = Factura.builder()
                .cliente(cliente)
                .direccion(factura.getDireccion())
                .fechaEmision(factura.getFechaEmision())
                .fechaPago(factura.getFechaPago())
                .tipoPago(factura.getTipoPago())
                .estado(factura.getEstado())
                .subtotal(factura.getSubtotal())
                .impuesto(factura.getImpuesto())
                .total(factura.getTotal())
                .build();
        return facturaRepositorio.save(facturaEntidad);
    }
}
