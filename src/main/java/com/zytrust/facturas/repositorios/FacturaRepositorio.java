package com.zytrust.facturas.repositorios;

import com.zytrust.facturas.modelos.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepositorio extends JpaRepository<Factura,String> {
}
