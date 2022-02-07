package com.zytrust.facturas.servicios.implementaciones;

import com.zytrust.facturas.dtos.detalle.CreateDetalleFacturaDto;
import com.zytrust.facturas.dtos.detalle.DetalleFacturaDto;
import com.zytrust.facturas.modelos.DetalleFactura;
import com.zytrust.facturas.modelos.Factura;
import com.zytrust.facturas.modelos.Producto;
import com.zytrust.facturas.repositorios.DetalleFacturaRepositorio;
import com.zytrust.facturas.repositorios.FacturaRepositorio;
import com.zytrust.facturas.repositorios.ProductoRepositorio;
import com.zytrust.facturas.servicios.DetalleFacturaServicio;
import com.zytrust.facturas.utiles.ConvertidorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DetalleFacturaServicioImpl implements DetalleFacturaServicio {

    @Autowired
    FacturaRepositorio facturaRepositorio;

    @Autowired
    ProductoRepositorio productoRepositorio;

    @Autowired
    DetalleFacturaRepositorio detalleFacturaRepositorio;

    @Autowired
    private ConvertidorDto converter;

    @Override
    @Transactional(readOnly = true)
    public List<DetalleFacturaDto> getAll() {
        return converter.detalleFacturaToDto(detalleFacturaRepositorio.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<DetalleFacturaDto> getAllByFacturaId(String facturaId) throws Exception {
        if (!facturaRepositorio.existsById(facturaId)) {
            throw new Exception("No se encontro Factura con id:" + facturaId);
        }
        return converter.detalleFacturaToDto(detalleFacturaRepositorio.findAllByFacturaFacturaId(facturaId));
    }

    @Override
    @Transactional(readOnly = true)
    public DetalleFacturaDto getDetalleFactura(String facturaId, String productoId) throws Exception {
        return converter.detalleFacturaToDto(detalleFacturaRepositorio.findDetalleFactura(facturaId,productoId)
                .orElseThrow(() -> new Exception("No se encontro Detalle de Factura con Factura Id:" + facturaId
                        + "y Producto Id:" + productoId)));
    }

    @Override
    @Transactional
    public DetalleFacturaDto createDetalleFactura(CreateDetalleFacturaDto detalle) throws Exception {
        Factura factura = facturaRepositorio.findById(detalle.getFacturaId())
                .orElseThrow(() -> new Exception("No se encontro Factura con id:" + detalle.getFacturaId()));

        Producto producto = productoRepositorio.findById(detalle.getProductoId())
                .orElseThrow(() -> new Exception("No se encontro Producto con id:" + detalle.getProductoId()));

        DetalleFactura detalleFactura = DetalleFactura.builder()
                .factura(factura)
                .producto(producto)
                .cantidad(detalle.getCantidad())
                .importe(producto.getPrecioUnitario().multiply(detalle.getCantidad()))
                .build();


        /* TODO: Mejorar la logica o confirmar */
        DetalleFactura detalleFacturaBD = detalleFacturaRepositorio.save(detalleFactura);
        factura.setSubtotal(factura.getSubtotal().add(detalleFacturaBD.getImporte()));
        factura.setImpuesto(factura.getSubtotal().multiply(new BigDecimal("0.18")));
        factura.setTotal(factura.getSubtotal().add(factura.getImpuesto()));

        facturaRepositorio.save(factura);

        return converter.detalleFacturaToDto(detalleFacturaBD);
    }
}
