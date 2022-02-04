package com.zytrust.facturas.servicios.implementaciones;

import com.zytrust.facturas.dtos.CreateDetalleFacturaDto;
import com.zytrust.facturas.dtos.CreateFacturaDto;
import com.zytrust.facturas.modelos.DetalleFactura;
import com.zytrust.facturas.modelos.Factura;
import com.zytrust.facturas.modelos.Producto;
import com.zytrust.facturas.repositorios.DetalleFacturaRepositorio;
import com.zytrust.facturas.repositorios.FacturaRepositorio;
import com.zytrust.facturas.repositorios.ProductoRepositorio;
import com.zytrust.facturas.servicios.DetalleFacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleFacturaServicioImpl implements DetalleFacturaServicio {

    @Autowired
    FacturaRepositorio facturaRepositorio;

    @Autowired
    ProductoRepositorio productoRepositorio;

    @Autowired
    DetalleFacturaRepositorio detalleFacturaRepositorio;

    @Override
    public List<DetalleFactura> getAll() {
        return detalleFacturaRepositorio.findAll();
    }

    @Override
    public List<DetalleFactura> getAllByFacturaId(String facturaId) throws Exception {
        if(! facturaRepositorio.existsById(facturaId)){
            throw  new Exception("No se encontro Factura con id:" + facturaId);
        }
        return detalleFacturaRepositorio.findAllByFacturaFacturaId(facturaId);
    }

    @Override
    public DetalleFactura getDetalleFactura(String id) throws Exception {
        return detalleFacturaRepositorio.findById(id).orElseThrow(()-> new Exception("No se encontro Detalle de Factura con id:" + id));
    }

    @Override
    public DetalleFactura createDetalleFactura(CreateDetalleFacturaDto detalle) throws Exception {
        Factura factura = facturaRepositorio.findById(detalle.getFacturaId()).orElseThrow(()-> new Exception("No se encontro Factura con id:" + detalle.getFacturaId()));
        Producto producto = productoRepositorio.findById(detalle.getProductoId()).orElseThrow(()-> new Exception("No se encontro Producto con id:" + detalle.getProductoId()));
        DetalleFactura detalleFactura = DetalleFactura.builder()
                .factura(factura)
                .producto(producto)
                .cantidad(detalle.getCantidad())
                .importe(detalle.getImporte())
                .build();
        return detalleFacturaRepositorio.save(detalleFactura);
    }
}
