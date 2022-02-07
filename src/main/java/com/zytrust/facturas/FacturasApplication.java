/*
 * @(#)FacturasApplication.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.zytrust.facturas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Esta clase representa el componente principal de la aplicacion SpringBoot
 *
 * @author Flavio Saavedra Montenegro
 * @version 1, 07/02/2022
 */

@SpringBootApplication
public class FacturasApplication {

    public static void main(String[] args) {
        SpringApplication.run(FacturasApplication.class, args);
    }

}
