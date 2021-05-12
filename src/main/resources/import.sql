/**
  Insercón en eps
 */
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

/**
  Insercón en estados
 */
INSERT INTO estados (nombre) VALUES ('Desconocido');
INSERT INTO estados (nombre) VALUES ('Contagiado');
INSERT INTO estados (nombre) VALUES ('Saludable');
INSERT INTO estados (nombre) VALUES ('Anteriormente con contagiado');
INSERT INTO estados (nombre) VALUES ('Primera dosis, pendiente vacunación');
INSERT INTO estados (nombre) VALUES ('Vacunado');

/**
  Insercón en tipos
 */
INSERT INTO tipos (nombre) VALUES ('Estudiante');
INSERT INTO tipos (nombre) VALUES ('Docente');
INSERT INTO tipos (nombre) VALUES ('Administrativo');
INSERT INTO tipos (nombre) VALUES ('Directivo');

/**
  Insercón en facultades
 */
INSERT INTO facultades (nombre) VALUES ('Educación');
INSERT INTO facultades (nombre) VALUES ('Ingeniería');
INSERT INTO facultades (nombre) VALUES ('Ciencias de la Salud');
INSERT INTO facultades (nombre) VALUES ('Ciencias contables, Economicas y financieras');
INSERT INTO facultades (nombre) VALUES ('Humanidades y Ciencias y Sociales');
INSERT INTO facultades (nombre) VALUES ('Administrativa');

/**
  Insercón en programas
 */
INSERT INTO programas (nombre, facultad_id) VALUES ('Licenciatura en Educación Básica Primaria',1);
INSERT INTO programas (nombre, facultad_id) VALUES ('Licenciatura en Educación Infantil',1);
INSERT INTO programas (nombre, facultad_id) VALUES ('Licenciatura en Matemáticas',1);
INSERT INTO programas (nombre, facultad_id) VALUES ('Licenciatura en Literatura',1);
INSERT INTO programas (nombre, facultad_id) VALUES ('Ingeniería de Procesos',2);
INSERT INTO programas (nombre, facultad_id) VALUES ('Ingeniería Ambiiental',2);
INSERT INTO programas (nombre, facultad_id) VALUES ('Ingeniería de Sistemas',2);
INSERT INTO programas (nombre, facultad_id) VALUES ('Ingeniería Civil',2);
INSERT INTO programas (nombre, facultad_id) VALUES ('Ingeniería Mecatronica',2);
INSERT INTO programas (nombre, facultad_id) VALUES ('Administración de negocios Internacionales',3);
INSERT INTO programas (nombre, facultad_id) VALUES ('Contaduria Pública',3);
INSERT INTO programas (nombre, facultad_id) VALUES ('Mercadeo',3);
INSERT INTO programas (nombre, facultad_id) VALUES ('Nutrición y dietetica',4);
INSERT INTO programas (nombre, facultad_id) VALUES ('Fisioterapia',4);
INSERT INTO programas (nombre, facultad_id) VALUES ('Terapia Ocupacional',4);
INSERT INTO programas (nombre, facultad_id) VALUES ('Enfermería',4);
INSERT INTO programas (nombre, facultad_id) VALUES ('Psicología',5);
INSERT INTO programas (nombre, facultad_id) VALUES ('Comunicación Social',5);
INSERT INTO programas (nombre, facultad_id) VALUES ('Trabajo Social',5);
INSERT INTO programas (nombre, facultad_id) VALUES ('Derecho',5);
INSERT INTO programas (nombre, facultad_id) VALUES ('Administración universitaria',6);

/**
  Insercón en personas
 */
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (1, 'Apellido 1', 3163930876, '1 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 1', 'B+', 6, 12, 4);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (2, 'Apellido 2', 3163930877, '2 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 2', 'O+', 6, 11, 3);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (3, 'Apellido 3', 3163930878, '3 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 3', 'A+', 2, 6, 1);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (4, 'Apellido 4', 3163930879, '4 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 4', 'AB+', 6, 2, 3);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (5, 'Apellido 5', 3163930880, '5 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 5', 'B-', 1, 13, 4);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (6, 'Apellido 6', 3163930881, '6 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 6', 'O-', 5, 11, 4);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (7, 'Apellido 7', 3163930882, '7 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 7', 'A-', 6, 9, 3);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (8, 'Apellido 8', 3163930883, '8 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 8', 'AB-', 6, 15, 4);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (9, 'Apellido 9', 3163930884, '9 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 9', 'B+', 6, 15, 4);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (10, 'Apellido 10', 3163930885, '10 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 10', 'O+', 2, 12, 2);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (11, 'Apellido 11', 3163930886, '11 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 11', 'A+', 4, 20, 4);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (12, 'Apellido 12', 3163930887, '12 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 12', 'AB+', 5, 12, 4);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (13, 'Apellido 13', 3163930888, '13 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 13', 'B-', 2, 10, 1);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (14, 'Apellido 14', 3163930889, '14 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 14', 'O-', 5, 5, 3);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (15, 'Apellido 15', 3163930890, '15 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 15', 'A-', 2, 8, 2);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (16, 'Apellido 16', 3163930891, '16 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 16', 'AB-', 6, 5, 2);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (17, 'Apellido 17', 3163930892, '17 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 17', 'B+', 1, 6, 3);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (18, 'Apellido 18', 3163930893, '18 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 18', 'O+', 5, 18, 1);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (19, 'Apellido 19', 3163930894, '19 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 19', 'A+', 1, 6, 2);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (20, 'Apellido 20', 3163930895, '20 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 20', 'AB+', 5, 20, 4);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (21, 'Apellido 21', 3163930896, '21 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 21', 'B-', 2, 17, 1);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (22, 'Apellido 22', 3163930897, '22 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 22', 'O-', 4, 16, 4);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (23, 'Apellido 23', 3163930898, '23 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 23', 'A-', 3, 3, 1);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (24, 'Apellido 24', 3163930899, '24 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 24', 'AB-', 5, 6, 4);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (25, 'Apellido 25', 3163930900, '25 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 25', 'B+', 5, 15, 4);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (26, 'Apellido 26', 3163930901, '26 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 26', 'O+', 3, 8, 4);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (27, 'Apellido 27', 3163930902, '27 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 27', 'A+', 2, 10, 1);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (28, 'Apellido 28', 3163930903, '28 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 28', 'AB+', 3, 11, 3);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (29, 'Apellido 29', 3163930904, '29 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 29', 'B-', 6, 15, 4);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (30, 'Apellido 30', 3163930905, '30 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 30', 'O-', 5, 3, 4);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (31, 'Apellido 31', 3163930906, '31 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 31', 'A-', 6, 8, 2);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (32, 'Apellido 32', 3163930907, '32 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 32', 'AB-', 4, 14, 2);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (33, 'Apellido 33', 3163930908, '33 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 33', 'B+', 2, 20, 1);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (34, 'Apellido 34', 3163930909, '34 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 34', 'O+', 4, 7, 1);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (35, 'Apellido 35', 3163930910, '35 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 35', 'A+', 6, 18, 1);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (36, 'Apellido 36', 3163930911, '36 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 36', 'AB+', 3, 15, 2);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (37, 'Apellido 37', 3163930912, '37 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 37', 'B-', 3, 4, 1);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (38, 'Apellido 38', 3163930913, '38 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 38', 'O-', 2, 11, 2);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (39, 'Apellido 39', 3163930914, '39 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 39', 'A-', 6, 5, 3);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (40, 'Apellido 40', 3163930915, '40 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 40', 'AB-', 5, 12, 4);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (41, 'Apellido 41', 3163930916, '41 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 41', 'B+', 2, 9, 4);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (42, 'Apellido 42', 3163930917, '42 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 42', 'O+', 3, 12, 2);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (43, 'Apellido 43', 3163930918, '43 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 43', 'A+', 6, 10, 3);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (44, 'Apellido 44', 3163930919, '44 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 44', 'AB+', 5, 7, 2);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (45, 'Apellido 45', 3163930920, '45 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 45', 'B-', 6, 1, 1);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (46, 'Apellido 46', 3163930921, '46 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 46', 'O-', 1, 4, 2);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (47, 'Apellido 47', 3163930922, '47 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 47', 'A-', 2, 5, 3);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (48, 'Apellido 48', 3163930923, '48 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 48', 'AB-', 3, 16, 3);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (49, 'Apellido 49', 3163930924, '49 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 49', 'B+', 6, 3, 3);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (50, 'Apellido 50', 3163930925, '50 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 50', 'O+', 1, 4, 3);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (51, 'Apellido 51', 3163930926, '51 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 51', 'A+', 4, 7, 1);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (52, 'Apellido 52', 3163930927, '52 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 52', 'AB+', 6, 9, 2);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (53, 'Apellido 53', 3163930928, '53 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 53', 'B-', 2, 7, 2);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (54, 'Apellido 54', 3163930929, '54 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 54', 'O-', 3, 19, 3);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (55, 'Apellido 55', 3163930930, '55 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 55', 'A-', 2, 5, 1);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (56, 'Apellido 56', 3163930931, '56 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 56', 'AB-', 3, 16, 2);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (57, 'Apellido 57', 3163930932, '57 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 57', 'B+', 4, 14, 3);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (58, 'Apellido 58', 3163930933, '58 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 58', 'O+', 1, 13, 4);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (59, 'Apellido 59', 3163930934, '59 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 59', 'A+', 1, 4, 1);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (60, 'Apellido 60', 3163930935, '60 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 60', 'AB+', 3, 15, 1);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (61, 'Apellido 61', 3163930936, '61 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 61', 'B-', 2, 18, 1);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (62, 'Apellido 62', 3163930937, '62 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 62', 'O-', 4, 12, 2);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (63, 'Apellido 63', 3163930938, '63 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 63', 'A-', 4, 3, 2);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (64, 'Apellido 64', 3163930939, '64 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 64', 'AB-', 2, 8, 1);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (65, 'Apellido 65', 3163930940, '65 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 65', 'B+', 2, 16, 2);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (66, 'Apellido 66', 3163930941, '66 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 66', 'O+', 6, 20, 2);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (67, 'Apellido 67', 3163930942, '67 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 67', 'A+', 6, 10, 3);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (68, 'Apellido 68', 3163930943, '68 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 68', 'AB+', 2, 14, 3);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (69, 'Apellido 69', 3163930944, '69 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 69', 'B-', 3, 4, 3);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (70, 'Apellido 70', 3163930945, '70 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 70', 'O-', 3, 9, 2);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (71, 'Apellido 71', 3163930946, '71 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 71', 'A-', 6, 1, 2);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (72, 'Apellido 72', 3163930947, '72 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 72', 'AB-', 1, 5, 1);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (73, 'Apellido 73', 3163930948, '73 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 73', 'B+', 1, 5, 4);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (74, 'Apellido 74', 3163930949, '74 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 74', 'O+', 6, 13, 1);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (75, 'Apellido 75', 3163930950, '75 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 75', 'A+', 2, 19, 4);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (76, 'Apellido 76', 3163930951, '76 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 76', 'AB+', 2, 17, 4);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (77, 'Apellido 77', 3163930952, '77 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 77', 'B-', 6, 5, 1);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (78, 'Apellido 78', 3163930953, '78 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 78', 'O-', 3, 16, 2);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (79, 'Apellido 79', 3163930954, '79 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 79', 'A-', 6, 5, 2);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (80, 'Apellido 80', 3163930955, '80 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 80', 'AB-', 4, 9, 1);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (81, 'Apellido 81', 3163930956, '81 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 81', 'B+', 2, 18, 3);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (82, 'Apellido 82', 3163930957, '82 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 82', 'O+', 6, 17, 3);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (83, 'Apellido 83', 3163930958, '83 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 83', 'A+', 5, 5, 1);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (84, 'Apellido 84', 3163930959, '84 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 84', 'AB+', 2, 11, 3);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (85, 'Apellido 85', 3163930960, '85 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 85', 'B-', 3, 4, 2);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (86, 'Apellido 86', 3163930961, '86 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 86', 'O-', 6, 10, 4);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (87, 'Apellido 87', 3163930962, '87 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 87', 'A-', 5, 10, 2);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (88, 'Apellido 88', 3163930963, '88 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 88', 'B-', 1, 6, 3);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (89, 'Apellido 89', 3163930964, '89 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 89', 'O-', 4, 13, 3);
insert into public.personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, estado_id, programa_id, tipo_id) values (90, 'Apellido 90', 3163930965, '90 correo@umariana.edu.co', '2000-01-13 00:00:00.000000', 'Nombre 90', 'A-', 4, 18, 1);

/**
  Insercón en convenios (se añade a 1 persona con una eps como minimo)
 */
insert into public.convenios (persona_id, eps_id) values (1, 14);
insert into public.convenios (persona_id, eps_id) values (2, 6);
insert into public.convenios (persona_id, eps_id) values (3, 6);
insert into public.convenios (persona_id, eps_id) values (4, 7);
insert into public.convenios (persona_id, eps_id) values (5, 4);
insert into public.convenios (persona_id, eps_id) values (6, 11);
insert into public.convenios (persona_id, eps_id) values (7, 5);
insert into public.convenios (persona_id, eps_id) values (8, 3);
insert into public.convenios (persona_id, eps_id) values (9, 2);
insert into public.convenios (persona_id, eps_id) values (10, 6);
insert into public.convenios (persona_id, eps_id) values (11, 5);
insert into public.convenios (persona_id, eps_id) values (12, 12);
insert into public.convenios (persona_id, eps_id) values (13, 5);
insert into public.convenios (persona_id, eps_id) values (14, 3);
insert into public.convenios (persona_id, eps_id) values (15, 1);
insert into public.convenios (persona_id, eps_id) values (16, 9);
insert into public.convenios (persona_id, eps_id) values (17, 3);
insert into public.convenios (persona_id, eps_id) values (18, 6);
insert into public.convenios (persona_id, eps_id) values (19, 4);
insert into public.convenios (persona_id, eps_id) values (20, 8);
insert into public.convenios (persona_id, eps_id) values (21, 14);
insert into public.convenios (persona_id, eps_id) values (22, 12);
insert into public.convenios (persona_id, eps_id) values (23, 8);
insert into public.convenios (persona_id, eps_id) values (24, 1);
insert into public.convenios (persona_id, eps_id) values (25, 8);
insert into public.convenios (persona_id, eps_id) values (26, 6);
insert into public.convenios (persona_id, eps_id) values (27, 9);
insert into public.convenios (persona_id, eps_id) values (28, 2);
insert into public.convenios (persona_id, eps_id) values (29, 3);
insert into public.convenios (persona_id, eps_id) values (30, 13);
insert into public.convenios (persona_id, eps_id) values (31, 12);
insert into public.convenios (persona_id, eps_id) values (32, 3);
insert into public.convenios (persona_id, eps_id) values (33, 12);
insert into public.convenios (persona_id, eps_id) values (34, 8);
insert into public.convenios (persona_id, eps_id) values (35, 10);
insert into public.convenios (persona_id, eps_id) values (36, 4);
insert into public.convenios (persona_id, eps_id) values (37, 5);
insert into public.convenios (persona_id, eps_id) values (38, 7);
insert into public.convenios (persona_id, eps_id) values (39, 5);
insert into public.convenios (persona_id, eps_id) values (40, 7);
insert into public.convenios (persona_id, eps_id) values (41, 6);
insert into public.convenios (persona_id, eps_id) values (42, 8);
insert into public.convenios (persona_id, eps_id) values (43, 2);
insert into public.convenios (persona_id, eps_id) values (44, 14);
insert into public.convenios (persona_id, eps_id) values (45, 7);
insert into public.convenios (persona_id, eps_id) values (46, 5);
insert into public.convenios (persona_id, eps_id) values (47, 7);
insert into public.convenios (persona_id, eps_id) values (48, 13);
insert into public.convenios (persona_id, eps_id) values (49, 11);
insert into public.convenios (persona_id, eps_id) values (50, 11);
insert into public.convenios (persona_id, eps_id) values (51, 1);
insert into public.convenios (persona_id, eps_id) values (52, 10);
insert into public.convenios (persona_id, eps_id) values (53, 1);
insert into public.convenios (persona_id, eps_id) values (54, 7);
insert into public.convenios (persona_id, eps_id) values (55, 2);
insert into public.convenios (persona_id, eps_id) values (56, 11);
insert into public.convenios (persona_id, eps_id) values (57, 12);
insert into public.convenios (persona_id, eps_id) values (58, 12);
insert into public.convenios (persona_id, eps_id) values (59, 8);
insert into public.convenios (persona_id, eps_id) values (60, 11);
insert into public.convenios (persona_id, eps_id) values (61, 7);
insert into public.convenios (persona_id, eps_id) values (62, 3);
insert into public.convenios (persona_id, eps_id) values (63, 2);
insert into public.convenios (persona_id, eps_id) values (64, 3);
insert into public.convenios (persona_id, eps_id) values (65, 4);
insert into public.convenios (persona_id, eps_id) values (66, 11);
insert into public.convenios (persona_id, eps_id) values (67, 5);
insert into public.convenios (persona_id, eps_id) values (68, 5);
insert into public.convenios (persona_id, eps_id) values (69, 8);
insert into public.convenios (persona_id, eps_id) values (70, 10);
insert into public.convenios (persona_id, eps_id) values (71, 14);
insert into public.convenios (persona_id, eps_id) values (72, 6);
insert into public.convenios (persona_id, eps_id) values (73, 10);
insert into public.convenios (persona_id, eps_id) values (74, 2);
insert into public.convenios (persona_id, eps_id) values (75, 5);
insert into public.convenios (persona_id, eps_id) values (76, 6);
insert into public.convenios (persona_id, eps_id) values (77, 9);
insert into public.convenios (persona_id, eps_id) values (78, 14);
insert into public.convenios (persona_id, eps_id) values (79, 6);
insert into public.convenios (persona_id, eps_id) values (80, 5);
insert into public.convenios (persona_id, eps_id) values (81, 12);
insert into public.convenios (persona_id, eps_id) values (82, 11);
insert into public.convenios (persona_id, eps_id) values (83, 10);
insert into public.convenios (persona_id, eps_id) values (84, 13);
insert into public.convenios (persona_id, eps_id) values (85, 6);
insert into public.convenios (persona_id, eps_id) values (86, 14);
insert into public.convenios (persona_id, eps_id) values (87, 10);
insert into public.convenios (persona_id, eps_id) values (88, 4);
insert into public.convenios (persona_id, eps_id) values (89, 14);
insert into public.convenios (persona_id, eps_id) values (90, 5);

/**
  Inserción en convenios (se agrega una o dos convenios mas para algunas personas)
 */
INSERT INTO convenios (persona_id, eps_id) VALUES (1,2);
INSERT INTO convenios (persona_id, eps_id) VALUES (1,13);
INSERT INTO convenios (persona_id, eps_id) VALUES (90,2);
INSERT INTO convenios (persona_id, eps_id) VALUES (45,2);
