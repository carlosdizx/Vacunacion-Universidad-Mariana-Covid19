package com.demo.models.dao;

import com.demo.models.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPersonaDao extends JpaRepository<Persona, Long>
{
    PersonaSencilla sencilla = null;

    @Query("SELECT p.documento, p.tipo,p.programa,p.estado from Persona AS p ORDER BY p.estado.id,p.programa.id")
    List<?> findAllData();

    @Query("from Tipo")
    List<Tipo> findAllTipos();

    @Query("from Eps")
    List<Eps> findAllEps();

    @Query("from Estado")
    List<Estado> findAllEstados();

    @Query("from Facultad")
    List<Facultad> findAllFacultades();

    @Query("FROM Programa")
    List<Programa> findAllProgramas();

    @Query("SELECT p.documento,p.programa,p.estado FROM Persona p WHERE p.tipo.id=?1 ORDER BY p.estado.id")
    List<?>findTiposPersonas(int id);

    @Query("SELECT p FROM Persona p WHERE p.estado.id=?1 ORDER BY p.estado.id")
    List<Persona>findEstadosPersonas(int id);

    @Query("SELECT p FROM Persona p WHERE p.estado.id>4 ORDER BY p.tipo.id,p.estado.id")
    List<Persona>findPosibles();

    @Query("SELECT p FROM Persona p" +
            "   INNER JOIN Programa p2 ON p2.id= p.programa.id " +
            " WHERE p.estado.id>=5 AND p2.facultad.id=?1 ORDER BY p.estado.id")
    List<Persona>findFacultadPersonasPosibles(int id);

    /**
     * SELECT count(*) AS cantiada,e.nombre,t.nombre FROM personas p
     *     INNER JOIN estados e on e.id = p.estado_id
     *     INNER JOIN tipos t on t.id = p.tipo_id
     * WHERE p.estado_id>=5
     * GROUP BY t.nombre,e.nombre;
     */
    @Query("SELECT count(p) AS cantidad,e.nombre AS estado,t.nombre AS tipo_persona FROM Persona p " +
            "INNER JOIN Estado e  ON e.id=p.estado.id " +
            "INNER JOIN Tipo t  ON t.id=p.tipo.id " +
            "GROUP BY t.nombre,e.nombre")
    List<?> countPosiblesTipos();
}
