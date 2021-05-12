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

INSERT INTO estados (nombre) VALUES ('Portador');
INSERT INTO estados (nombre) VALUES ('Sano');
INSERT INTO estados (nombre) VALUES ('Anteriormente con covid19');
INSERT INTO estados (nombre) VALUES ('Anteriormente vacunado, pendiente segunda dosis');
INSERT INTO estados (nombre) VALUES ('Vacunado');

INSERT INTO tipos (nombre) VALUES ('Estudiante');
INSERT INTO tipos (nombre) VALUES ('Docente');
INSERT INTO tipos (nombre) VALUES ('Administrativo');

INSERT INTO facultades (nombre) VALUES ('Ingeniería');
INSERT INTO facultades (nombre) VALUES ('Ciencias de la Salud');
INSERT INTO facultades (nombre) VALUES ('Ciencias contables, Economicas y financieras');
INSERT INTO facultades (nombre) VALUES ('Humanidades y Ciencias y Sociales');
INSERT INTO facultades (nombre) VALUES ('Administrativa, secretartia y logistica');


/*
INSERT INTO personas (documento, apellidos, celular, correo, fecha_nacimiento, nombres, sangre, eps_id, estado_id, facultdad_id, tipo_id);
*/
INSERT INTO personas VALUES (1089, 'DAVID', 300888004, '5 loquesea @ umariana.edu.co', '1980-09-20 00:00:00.000000', 'FRANCISCO', 'O-', 5, 1, 3);
INSERT INTO personas VALUES (1087, 'JOSE', 300888002, '3 loquesea @ umariana.edu.co', '2001-03-20 00:00:00.000000', 'JUAN', 'A+', 3, 4, 3);
INSERT INTO personas VALUES (1090, 'JUAN', 300888005, '6 loquesea @ umariana.edu.co', '1960-12-20 00:00:00.000000', 'LUIS', 'O+', 4, 3, 1);
INSERT INTO personas VALUES (1091, 'JOSE ANTONIO', 300888006, '7 loquesea @ umariana.edu.co', '2002-01-20 00:00:00.000000', 'JAVIER', 'B+', 8, 2, 4, 2);
INSERT INTO personas VALUES (1086, 'MANUEL', 300888001, '2 loquesea @ umariana.edu.co', '2000-02-07 00:00:00.000000', 'ANTONIO', 'B+', 12, 2, 2, 2);
INSERT INTO personas VALUES (1085, 'ANTONIO', 300888000, '1 loquesea @ umariana.edu.co', '1999-07-15 00:00:00.000000', 'JOSE', 'O+', 1, 1, 1, 1);
INSERT INTO personas VALUES (1092, 'JAVIER', 300888007, '8 loquesea @ umariana.edu.co', '1995-03-28 00:00:00.000000', 'MIGUEL', 'O+', 8, 2, 1, 2);
INSERT INTO personas VALUES (1088, 'FRANCISCO', 300888003, '4 loquesea @ umariana.edu.co', '1978-06-20 00:00:00.000000', 'MANUEL', 'AB-', 13, 4, 3, 1);
INSERT INTO personas VALUES (1093, 'DANIEL', 300888008, '9 loquesea @ umariana.edu.co', '1999-07-15 00:00:00.000000', 'CARLOS', 'O+', 1, 1, 1, 1);
INSERT INTO personas VALUES (1094, 'JOSE LUIS', 300888009, '10 loquesea @ umariana.edu.co', '2000-02-07 00:00:00.000000', 'ANGEL', 'B+', 12, 2, 2, 2);
INSERT INTO personas VALUES (1095, 'FRANCISCO JAVIER', 300888010, '11 loquesea @ umariana.edu.co', '2001-03-20 00:00:00.000000', 'JESUS', 'A+', 10, 3, 4, 3);
INSERT INTO personas VALUES (1096, 'CARLOS', 300888011, '12 loquesea @ umariana.edu.co', '1978-06-20 00:00:00.000000', 'DAVID', 'AB-', 13, 4, 3, 1);
INSERT INTO personas VALUES (1097, 'JESUS', 300888012, '13 loquesea @ umariana.edu.co', '1980-09-20 00:00:00.000000', 'PEDRO', 'O-', 11, 5, 5, 3);
INSERT INTO personas VALUES (1098, 'ALEJANDRO', 300888013, '14 loquesea @ umariana.edu.co', '1960-12-20 00:00:00.000000', 'DANIEL', 'O+', 7, 1, 3, 1);
INSERT INTO personas VALUES (1099, 'Basante', 3163930876, 'carlodiaz @ umariana.edu.co', '1998-01-13 00:00:00.000000', 'Ernesto', 'B+', 2, 3, 1, 1);
INSERT INTO personas VALUES (10001, 'JOSE MANUEL', 300888015, '16 loquesea @ umariana.edu.co', '1995-03-28 00:00:00.000000', 'MARIA', 'O+', 2, 3, 2, 2);
INSERT INTO personas VALUES (10002, 'RAFAEL', 300888016, '17 loquesea @ umariana.edu.co', '1999-07-15 00:00:00.000000', 'ALBERTO', 'O+', 1, 4, 1, 1);
INSERT INTO personas VALUES (10003, 'MIGUEL ANGEL', 300888017, '18 loquesea @ umariana.edu.co', '2000-02-07 00:00:00.000000', 'RAFAEL', 'B+', 12, 5, 2, 2);
INSERT INTO personas VALUES (10004, 'PEDRO', 300888018, '19 loquesea @ umariana.edu.co', '2001-03-20 00:00:00.000000', 'FERNANDO', 'A+', 10, 4, 5, 3);
INSERT INTO personas VALUES (10005, 'PABLO', 300888019, '20 loquesea @ umariana.edu.co', '1978-06-20 00:00:00.000000', 'PABLO', 'AB-', 13, 2, 3, 1);
INSERT INTO personas VALUES (10006, 'ANGEL', 300888020, '21 loquesea @ umariana.edu.co', '1980-09-20 00:00:00.000000', 'JORGE', 'O-', 11, 1, 1, 3);
INSERT INTO personas VALUES (10007, 'SERGIO', 300888021, '22 loquesea @ umariana.edu.co', '1960-12-20 00:00:00.000000', 'RAMON', 'O+', 7, 2, 3, 1);
INSERT INTO personas VALUES (10008, 'JOSE MARIA', 300888022, '23 loquesea @ umariana.edu.co', '2002-01-20 00:00:00.000000', 'SERGIO', 'B+', 8, 3, 4, 2);
INSERT INTO personas VALUES (10009, 'FERNANDO', 300888023, '24 loquesea @ umariana.edu.co', '1995-03-28 00:00:00.000000', 'ENRIQUE', 'O+', 2, 4, 2, 2);
INSERT INTO personas VALUES (10011, 'JORGE', 300888024, '25 loquesea @ umariana.edu.co', '1999-07-15 00:00:00.000000', 'ANDRES', 'O+', 1, 5, 1, 1);
INSERT INTO personas VALUES (10012, 'LUIS', 300888025, '26 loquesea @ umariana.edu.co', '2000-02-07 00:00:00.000000', 'DIEGO', 'B+', 12, 1, 2, 2);
INSERT INTO personas VALUES (10013, 'ALBERTO', 300888026, '27 loquesea @ umariana.edu.co', '2001-03-20 00:00:00.000000', 'VICENTE', 'A+', 10, 2, 4, 3);
INSERT INTO personas VALUES (10014, 'JUAN CARLOS', 300888027, '28 loquesea @ umariana.edu.co', '1978-06-20 00:00:00.000000', 'VICTOR', 'AB-', 13, 3, 3, 1);
INSERT INTO personas VALUES (10015, 'ALVARO', 300888028, '29 loquesea @ umariana.edu.co', '1980-09-20 00:00:00.000000', 'ADRIAN', 'O+', 11, 4, 1, 1);
INSERT INTO personas VALUES (10016, 'ADRIAN', 300888029, '30 loquesea @ umariana.edu.co', '1960-12-20 00:00:00.000000', 'IGNACIO', 'B+', 7, 5, 3, 2);
INSERT INTO personas VALUES (10017, 'JUAN JOSE', 300888030, '31 loquesea @ umariana.edu.co', '2002-01-20 00:00:00.000000', 'ALVARO', 'A+', 8, 4, 4, 3);
INSERT INTO personas VALUES (10018, 'DIEGO', 300888031, '32 loquesea @ umariana.edu.co', '1995-03-28 00:00:00.000000', 'RAUL', 'AB-', 2, 2, 2, 1);
INSERT INTO personas VALUES (10019, 'RAUL', 300888032, '33 loquesea @ umariana.edu.co', '1960-12-20 00:00:00.000000', 'EDUARDO', 'O-', 11, 2, 5, 3);
INSERT INTO personas VALUES (10020, 'IVAN', 300888033, '34 loquesea @ umariana.edu.co', '2002-01-20 00:00:00.000000', 'IVAN', 'O+', 7, 2, 1, 1);
INSERT INTO personas VALUES (10021, 'JUAN ANTONIO', 300888034, '35 loquesea @ umariana.edu.co', '1995-03-28 00:00:00.000000', 'OSCAR', 'B+', 8, 1, 5, 2);
