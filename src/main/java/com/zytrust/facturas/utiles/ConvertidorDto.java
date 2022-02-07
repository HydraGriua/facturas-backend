/*
 * @(#)ConvertidorDto.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas.utiles;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;
import com.zytrust.facturas.dtos.Factura.FacturaDto;
import com.zytrust.facturas.dtos.categoria.CategoriaProductoDto;
import com.zytrust.facturas.dtos.cliente.ClienteDto;
import com.zytrust.facturas.dtos.detalle.DetalleFacturaDto;
import com.zytrust.facturas.dtos.producto.ProductoDto;
import com.zytrust.facturas.modelos.*;

/**
 * Esta clase representa a un componente convertidor de entidades y debe ser
 * usada para transformar
 * clases Entidades en clases Dto.
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

@Component
public class ConvertidorDto {

    /** Instanciacion de un objeto de tipo ModelMapper */
    private final ModelMapper modelMapper = new ModelMapper();

    /**
     * Permite transformar un objeto de tipo Factura a uno de tipo FacturaDto usando
     * el ModelMapper
     *
     * @param factura Objeto de tipo Factura
     * @return Objeto de tipo FacturaDto
     */
    public FacturaDto facturaToDto(Factura factura) {
        return modelMapper.map(factura, FacturaDto.class);
    }

    /**
     * Permite transformar una lista de objetos de tipo Factura a una de objetos de
     * tipo FacturaDto usando el ModelMapper
     *
     * @param facturas Lista de objetos de tipo Factura
     * @return Lista dto de objetos de tipo FacturaDto
     */
    public List<FacturaDto> facturaToDto(List<Factura> facturas) {
        return facturas.stream()
                .map(this::facturaToDto)
                .collect(Collectors.toList());
    }

    /**
     * Permite transformar un objeto de tipo Cliente a uno de tipo ClienteDto usando
     * el ModelMapper
     *
     * @param factura Objeto de tipo Cliente
     * @return Objeto de tipo ClienteDto
     */
    public ClienteDto clienteToDto(Cliente cliente) {
        return modelMapper.map(cliente, ClienteDto.class);
    }

    /**
     * Permite transformar una lista de objetos de tipo Cliente a una de objetos de
     * tipo ClienteDto usando el ModelMapper
     *
     * @param facturas Lista de objetos de tipo Cliente
     * @return Lista dto de objetos de tipo ClienteDto
     */
    public List<ClienteDto> clienteToDto(List<Cliente> clientes) {
        return clientes.stream()
                .map(this::clienteToDto)
                .collect(Collectors.toList());
    }

    /**
     * Permite transformar un objeto de tipo Producto a uno de tipo ProductoDto
     * usando el ModelMapper
     *
     * @param factura Objeto de tipo Producto
     * @return Objeto de tipo ProductoDto
     */
    public ProductoDto productoToDto(Producto producto) {
        return modelMapper.map(producto, ProductoDto.class);
    }

    /**
     * Permite transformar una lista de objetos de tipo Producto a una de objetos de
     * tipo ProductoDto usando el ModelMapper
     *
     * @param facturas Lista de objetos de tipo Producto
     * @return Lista dto de objetos de tipo ProductoDto
     */
    public List<ProductoDto> productoToDto(List<Producto> productos) {
        return productos.stream()
                .map(this::productoToDto)
                .collect(Collectors.toList());
    }

    /**
     * Permite transformar un objeto de tipo CategoriaProducto a uno de tipo
     * CategoriaProductoDto usando el ModelMapper
     *
     * @param factura Objeto de tipo CategoriaProducto
     * @return Objeto de tipo CategoriaProductoDto
     */
    public CategoriaProductoDto categoriaProductoToDto(CategoriaProducto categoriaProducto) {
        return modelMapper.map(categoriaProducto, CategoriaProductoDto.class);
    }

    /**
     * Permite transformar una lista de objetos de tipo CategoriaProducto a una de
     * objetos de tipo CategoriaProductoDto usando el ModelMapper
     *
     * @param facturas Lista de objetos de tipo CategoriaProducto
     * @return Lista dto de objetos de tipo CategoriaProductoDto
     */
    public List<CategoriaProductoDto> categoriaProductoToDto(List<CategoriaProducto> categoriaProductos) {
        return categoriaProductos.stream()
                .map(this::categoriaProductoToDto)
                .collect(Collectors.toList());
    }

    /**
     * Permite transformar un objeto de tipo DetalleFactura a uno de tipo
     * DetalleFacturaDto usando el ModelMapper y propiedades de mapping
     *
     * @param factura Objeto de tipo DetalleFactura
     * @return Objeto de tipo DetalleFacturaDto
     */
    public DetalleFacturaDto detalleFacturaToDto(DetalleFactura detalleFactura) {
        TypeMap<DetalleFactura, DetalleFacturaDto> propertyMapper = modelMapper.createTypeMap(DetalleFactura.class,
                DetalleFacturaDto.class);
        propertyMapper
                .addMappings(
                        mapper -> mapper.map(src -> src.getFactura().getFacturaId(), DetalleFacturaDto::setFacturaId))
                .addMappings(mapper -> mapper.map(src -> src.getProducto().getProductoId(),
                        DetalleFacturaDto::setProductoId));
        return modelMapper.map(detalleFactura, DetalleFacturaDto.class);
    }

    /**
     * Permite transformar una lista de objetos de tipo DetalleFactura a una de
     * objetos de tipo DetalleFacturaDto usando el ModelMapper
     *
     * @param facturas Lista de objetos de tipo DetalleFactura
     * @return Lista dto de objetos de tipo DetalleFacturaDto
     */
    public List<DetalleFacturaDto> detalleFacturaToDto(List<DetalleFactura> detalleFacturas) {
        return detalleFacturas.stream()
                .map(this::detalleFacturaToDto)
                .collect(Collectors.toList());
    }
}
