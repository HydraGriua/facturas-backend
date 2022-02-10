package com.zytrust.facturas.excepciones;

import com.zytrust.facturas.utiles.CodigoError;

public class FacturasException extends RuntimeException {
    private CodigoError codigoError;

	public FacturasException(CodigoError codigoError) {
		this.codigoError = codigoError;
	}

}
