/**
  1. Primero crear una base de datos de forma manual o por consola
  2. Ejecutar sobre esa base de datos el siguiente script
 */

DROP TABLE IF EXISTS covenio;
DROP TABLE IF EXISTS eps;
DROP TABLE IF EXISTS personas;
DROP TABLE IF EXISTS estado;

/**
  ----------------------------- Estado de la persona --------------------------
 */

DROP TABLE IF EXISTS estado;
CREATE TABLE estado
(
    id SERIAL NOT NULL PRIMARY KEY,
    nombre VARCHAR NOT NULL
);

INSERT INTO estado (nombre) VALUES ('Sano');
INSERT INTO estado (nombre) VALUES ('Portador');
INSERT INTO estado (nombre) VALUES ('Anteriormente con covid19');
INSERT INTO estado (nombre) VALUES ('Anteriormente vacunado');
INSERT INTO estado (nombre) VALUES ('Vacunado');

SELECT * FROM estado;

/**
  ----------------------------- Persona --------------------------
 */

DROP TABLE IF EXISTS personas;
CREATE TABLE personas
(
    documento BIGINT NOT NULL PRIMARY KEY,
    nombres VARCHAR NOT NULL,
    apellidos VARCHAR NOT NULL,
    fehca_nacimiento DATE NOT NULL,
    tipo INT NOT NULL,
    sangre VARCHAR(3) NOT NULL,
    tipo_estado INT NOT NULL,
    correo VARCHAR UNIQUE NOT NULL,
    celular BIGINT NOT NULL,
    FOREIGN KEY (tipo) REFERENCES estado (id)
);
INSERT INTO personas
VALUES (1082749257,'Carlos Ernesto','Díaz Basante','15-10-2021',1,'B+',1,'carlodiaz@umariana.edu.co',3163930876);
SELECT * FROM personas;

/**
  ----------------------------- EPS de la persona --------------------------
 */

DROP TABLE IF EXISTS eps;
CREATE TABLE eps
(
    id SERIAL NOT NULL PRIMARY KEY,
    nombre VARCHAR  NOT NULL
);

INSERT INTO eps (nombre) VALUES ('Cafe Salud');
INSERT INTO eps (nombre) VALUES ('ProINSalud');
INSERT INTO eps (nombre) VALUES ('ColSanitas');
INSERT INTO eps (nombre) VALUES ('Coomeva');
INSERT INTO eps (nombre) VALUES ('Salud Colmena EPS');
INSERT INTO eps (nombre) VALUES ('Salud Total');
INSERT INTO eps (nombre) VALUES ('Compensar');
INSERT INTO eps (nombre) VALUES ('Sura');
INSERT INTO eps (nombre) VALUES ('Nueva EPS');
INSERT INTO eps (nombre) VALUES ('Cruz Blanca');
INSERT INTO eps (nombre) VALUES ('EPS SOS');
INSERT INTO eps (nombre) VALUES ('Medimas');
INSERT INTO eps (nombre) VALUES ('Comfamiliar');
INSERT INTO eps (nombre) VALUES ('Emssanar');

SELECT * FROM eps;

DROP TABLE IF EXISTS convenio;

CREATE TABLE covenio
(
    id_eps SERIAL NOT NULL,
    documento BIGINT,
    FOREIGN KEY (id_eps) REFERENCES eps (id),
    FOREIGN KEY (documento) REFERENCES personas (documento),
    regimen VARCHAR NOT NULL
);
