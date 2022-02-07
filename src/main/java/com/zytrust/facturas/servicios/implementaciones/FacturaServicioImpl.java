package com.zytrust.facturas.servicios.implementaciones;

import com.zytrust.facturas.dtos.Factura.CreateFacturaDto;
import com.zytrust.facturas.dtos.Factura.FacturaDto;
import com.zytrust.facturas.modelos.Cliente;
import com.zytrust.facturas.modelos.Factura;
import com.zytrust.facturas.repositorios.ClienteRepositorio;
import com.zytrust.facturas.repositorios.FacturaRepositorio;
import com.zytrust.facturas.servicios.FacturaServicio;
import com.zytrust.facturas.utiles.ConvertidorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class FacturaServicioImpl implements FacturaServicio {

    @Autowired
    FacturaRepositorio facturaRepositorio;

    @Autowired
    ClienteRepositorio clienteRepositorio;

    @Autowired
    private ConvertidorDto converter;

    @Override
    @Transactional(readOnly = true)
    public List<FacturaDto> getAll() {
        return converter.facturaToDto(facturaRepositorio.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public FacturaDto getFactura(String id) throws Exception {
        return converter.facturaToDto(facturaRepositorio.findById(id)
                .orElseThrow(() -> new Exception("No se encontro Factura con id:" + id)));
    }

    @Override
    @Transactional
    public FacturaDto createFactura(CreateFacturaDto factura) throws Exception {

        Cliente cliente = clienteRepositorio.findById(factura.getClienteId())
                .orElseThrow(() -> new Exception("No se encontro Cliente con id:" + factura.getClienteId()));

        LocalDate hoy = LocalDate.now();
        LocalTime ahora = LocalTime.now();
        LocalDateTime fecha = LocalDateTime.of(hoy, ahora);

        Factura facturaEntidad = Factura.builder()
                .cliente(cliente)
                .direccion(factura.getDireccion())
                .fechaHoraEmision(fecha)
                .estado('i')
                .subtotal(new BigDecimal("0"))
                .impuesto(new BigDecimal("0"))
                .total(new BigDecimal("0"))
                .build();

        return converter.facturaToDto(facturaRepositorio.save(facturaEntidad));
    }

    @Override
    public FacturaDto updateEstadoFactura(Character estado, String facturaId) throws Exception {
        Factura factura = facturaRepositorio.findById(facturaId)
                .orElseThrow(() -> new Exception("No se encontro Factura con id:" + facturaId));

        factura.setEstado(estado);

        return converter.facturaToDto(facturaRepositorio.save(factura));
    }

    @Override
    public FacturaDto pagoFactura(String tipoPago, String facturaId) throws Exception {
        Factura factura = facturaRepositorio.findById(facturaId)
                .orElseThrow(() -> new Exception("No se encontro Factura con id:" + facturaId));

        factura.setEstado('c');
        factura.setTipoPago(tipoPago);

        LocalDate hoy = LocalDate.now();
        LocalTime ahora = LocalTime.now();
        LocalDateTime fecha = LocalDateTime.of(hoy, ahora);
        factura.setFechaHoraPago(fecha);

        return converter.facturaToDto(facturaRepositorio.save(factura));
    }

}
