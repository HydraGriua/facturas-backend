package com.zytrust.facturas.excepciones;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import com.zytrust.facturas.utiles.CodigoError;

@Getter
@Setter
public class FacturasException extends RuntimeException {
    private CodigoError codigoError;
	private List<String> detallesError = new ArrayList<>();
	public FacturasException(CodigoError codigoError) {
		this.codigoError = codigoError;
	}

}
