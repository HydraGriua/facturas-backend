package com.zytrust.facturas.repositorios;

import com.zytrust.facturas.modelos.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleFacturaRepositorio extends JpaRepository<DetalleFactura,String> {
    List<DetalleFactura> findAllByFacturaFacturaId(String facturaId);
}
