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

INSERT INTO estados (nombre) VALUES ('Sano');
INSERT INTO estados (nombre) VALUES ('Portador');
INSERT INTO estados (nombre) VALUES ('Anteriormente con covid19');
INSERT INTO estados (nombre) VALUES ('Anteriormente vacunado, pendiente!');
INSERT INTO estados (nombre) VALUES ('Vacunado');

INSERT INTO tipos (nombre) VALUES ('Estudiante');
INSERT INTO tipos (nombre) VALUES ('Docente');
INSERT INTO tipos (nombre) VALUES ('Administrativo');



INSERT INTO personas (documento, apellidos, celular, correo, fecha_nacimiento, nombre, sangre, eps_id, estado_id, tipo_id)
VALUES (1085,'Olaya Herrera',3008888000,'molaya@umariana.edu.co','1999-11-20','Micheal Stiven','O+',1,1,1);

INSERT INTO personas (documento, apellidos, celular, correo, fecha_nacimiento, nombre, sangre, eps_id, estado_id, tipo_id)
VALUES (1086,'Mecanico',3008888001,'javimeca@umariana.edu.co','1999-11-20','Javier','B+',2,4,3);