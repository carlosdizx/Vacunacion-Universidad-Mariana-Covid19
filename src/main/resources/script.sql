/**
  muestra los registros repetidos por tabla
 */
SELECT
    nspname AS schemaname,relname,reltuples::integer
FROM pg_class C
         LEFT JOIN pg_namespace N ON (N.oid = C.relnamespace)
WHERE
        nspname NOT IN ('pg_catalog', 'information_schema') AND
        relkind='r'
ORDER BY reltuples DESC;

/**
  cuenta la cantidad de programas que tiene cada facultad
 */
SELECT count(*) AS cantidad,f.nombre AS facultad FROM programas p INNER JOIN facultades f on f.id = p.facultad_id GROUP BY f.nombre;

/**
  cuenta la cantidad de personas que tiene cada programa
 */
SELECT count(*) AS cantidad,p.nombre AS programa FROM personas INNER JOIN programas p on p.id = personas.programa_id GROUP BY p.nombre;

/**
  cuenta la cantidad de personas que tiene cada facultad
 */
SELECT count(*) AS cantidad,f.nombre AS facultad FROM personas
                                                          INNER JOIN programas p on p.id = personas.programa_id
                                                          INNER JOIN facultades f on f.id = p.facultad_id
GROUP BY f.nombre;

/**
  cuenta la cantidad de personas que podrian asistir a la universidad sin correr ningun riesgo
 */
SELECT count(*) AS cantidad,f.nombre AS facultad FROM personas
                                                          INNER JOIN programas p on p.id = personas.programa_id
                                                          INNER JOIN facultades f on f.id = p.facultad_id
WHERE personas.estado_id>=5
GROUP BY f.nombre;

/**
  muestra la edad promedio por cada facultad
 */
SELECT avg(date_part('YEAR',age(fecha_nacimiento))),f.nombre AS edad FROM personas
                                                                              INNER JOIN programas p on p.id = personas.programa_id
                                                                              INNER JOIN facultades f on f.id = p.facultad_id
GROUP BY f.nombre;

/**
    cuenta la cantidad de personas por el los estados posibles (grafica 2)
 */
SELECT count(*) AS cantidad,e.nombre FROM personas
                                              INNER JOIN estados e on e.id = personas.estado_id
GROUP BY e.nombre;

/**
  para cambiar el estado/situacion en que se encuentran las personas
 */
CREATE OR REPLACE FUNCTION aletorios() RETURNS void
AS
$$
UPDATE personas SET estado_id = round(5) * random() + 1;
$$
Language SQL;

SELECT aletorios();

/**
  cuenta las personas que pueden ir a la U sin correr riesgo
 */

SELECT count(p)
FROM personas p
WHERE p.estado_id>=5;

/**
  cuenta las personas que pueden ir a la U sin correr riesgo por facultades
 */
SELECT f.nombre,count(p)
FROM personas p
         INNER JOIN programas p2 on p2.id = p.programa_id
         INNER JOIN facultades f on f.id = p2.facultad_id
WHERE p.estado_id>=5
GROUP BY f.nombre
ORDER BY f.nombre;


/**
  como convertir los datos de una tabla (personas) en un json
 */

CREATE OR REPLACE FUNCTION convertir_a_json()
    RETURNS json as $$
DECLARE
    respuesta json;
begin
    SELECT  array_to_json(array_agg(row_to_json(datos.*)))
    FROM(
            SELECT *
            FROM personas
            ORDER BY apellidos,nombres
        ) AS datos INTO respuesta;
    return respuesta;
end;
$$
    LANGUAGE plpgsql;

SELECT convertir_a_json();