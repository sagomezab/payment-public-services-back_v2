DROP DATABASE PaymentPublicServices;

CREATE DATABASE PaymentPublicServices;

use PaymentPublicServices;

-- Tabla 'rol'
CREATE TABLE PaymentPublicServices.rol (
    id varchar(36) PRIMARY KEY,
    rol VARCHAR(255) NOT NULL
);

-- Tabla 'usuario'
CREATE TABLE PaymentPublicServices.usuario (
    id varchar(36) PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    correo VARCHAR(255) NOT NULL,
    telefono VARCHAR(15),
    direccion VARCHAR(255)
);


ALTER TABLE PaymentPublicServices.usuario ADD COLUMN id_rol varchar(36),ADD FOREIGN KEY (id_rol) REFERENCES PaymentPublicServices.rol(id);

ALTER TABLE  PaymentPublicServices.usuario MODIFY COLUMN id_rol varchar(36) DEFAULT 1;

-- Tabla 'servicio'
CREATE TABLE PaymentPublicServices.servicio (
    id varchar(36) PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);


##DROP TABLE PaymentPublicServices.factura;

-- Tabla 'facturas'
CREATE TABLE PaymentPublicServices.factura (
    id varchar(36) PRIMARY KEY,
    id_usuario VARCHAR(255),
    id_servicio varchar(36),
    valor DECIMAL(10, 2) NOT NULL,
    estado VARCHAR(50) NOT NULL,
    fecha_factura DATE NOT NULL,
    id_txr varchar(36),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    FOREIGN KEY (id_servicio) REFERENCES servicio(id)
);

##DROP TABLE PaymentPublicServices.transaccion;

-- Tabla 'transaccion'
CREATE TABLE PaymentPublicServices.transaccion (
    id varchar(36) PRIMARY KEY,
    id_factura  varchar(36),
    fecha_trx DATE NOT NULL,
    estado VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_factura) REFERENCES factura(id)
);

##DROP TABLE PaymentPublicServices.solicitudes;

-- Tabla 'solicitudes'
CREATE TABLE solicitudes (
    id_solicitud varchar(36) PRIMARY KEY,
    id_usuario_creador VARCHAR(255),
    id_usuario_aprobador VARCHAR(255),
    detalle TEXT NOT NULL,
    estado VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_usuario_creador) REFERENCES usuario(id),
    FOREIGN KEY (id_usuario_aprobador) REFERENCES usuario(id)
);


