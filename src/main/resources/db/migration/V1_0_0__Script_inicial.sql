CREATE TABLE `fac_categoria_productos` (
  `catprod_id` varchar(50) NOT NULL,
  `catprod_descripcion` varchar(255) NOT NULL,
  `catprod_nom` varchar(40) NOT NULL,
  PRIMARY KEY (`catprod_id`)
) ENGINE=InnoDB;

CREATE TABLE `fac_productos` (
  `prod_id` varchar(50) NOT NULL,
  `prod_descripcion` varchar(255) NOT NULL,
  `prod_nom` varchar(40) NOT NULL,
  `prod_precio_unit` decimal(5,2) NOT NULL,
  `catprod_id` varchar(50) NOT NULL,
  PRIMARY KEY (`prod_id`),
  KEY `FKd9pag9cyvtgjbaa63ni3pdvce` (`catprod_id`),
  CONSTRAINT `FKd9pag9cyvtgjbaa63ni3pdvce` FOREIGN KEY (`catprod_id`) REFERENCES `fac_categoria_productos` (`catprod_id`)
) ENGINE=InnoDB;

CREATE TABLE `fac_clientes` (
  `clie_id` varchar(50) NOT NULL,
  `clie_celular` varchar(20) NOT NULL,
  `clie_direccion` varchar(255) NOT NULL,
  `clie_email` varchar(30) NOT NULL,
  `clie_fecha_nacimiento` date NOT NULL,
  `clie_genero` char(1) NOT NULL,
  `clie_nom_empresa` varchar(100) NOT NULL,
  `clie_num_doc` varchar(20) NOT NULL,
  `clie_prim_apellido` varchar(40) NOT NULL,
  `clie_prim_nombre` varchar(40) NOT NULL,
  `clie_tipo_doc` varchar(20) NOT NULL,
  PRIMARY KEY (`clie_id`)
) ENGINE=InnoDB;

CREATE TABLE `fac_facturas` (
  `fact_id` varchar(50) NOT NULL,
  `fact_direccion` varchar(255) NOT NULL,
  `fact_estado` char(1) NOT NULL,
  `fact_fecha_emision` datetime(6) NOT NULL,
  `fact_fecha_pago` datetime(6) DEFAULT NULL,
  `fact_impuesto` decimal(7,2) NOT NULL,
  `fact_subtotal` decimal(7,2) NOT NULL,
  `fact_tipo_pago` varchar(20) DEFAULT NULL,
  `fact_total` decimal(7,2) NOT NULL,
  `cli_id` varchar(50) NOT NULL,
  PRIMARY KEY (`fact_id`),
  KEY `FK3du3182eupe9k6fskm7bookwf` (`cli_id`),
  CONSTRAINT `FK3du3182eupe9k6fskm7bookwf` FOREIGN KEY (`cli_id`) REFERENCES `fac_clientes` (`clie_id`)
) ENGINE=InnoDB;

CREATE TABLE `fac_detalle_facturas` (
  `detfact_cantidad` decimal(19,2) NOT NULL,
  `detfact_importe` decimal(7,2) NOT NULL,
  `fact_id` varchar(50) NOT NULL,
  `prod_id` varchar(50) NOT NULL,
  PRIMARY KEY (`fact_id`,`prod_id`),
  KEY `FKnlnm51dlc68u54qmpliybgyr5` (`prod_id`),
  CONSTRAINT `FK95wobgjigx25rhieq5i5oyjl8` FOREIGN KEY (`fact_id`) REFERENCES `fac_facturas` (`fact_id`),
  CONSTRAINT `FKnlnm51dlc68u54qmpliybgyr5` FOREIGN KEY (`prod_id`) REFERENCES `fac_productos` (`prod_id`)
) ENGINE=InnoDB;



