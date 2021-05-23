package com.demo.models.dao;

import com.demo.models.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPersonaDao extends JpaRepository<Persona, Long>
{
    Persona.PersonaSencilla sencilla = null;

    @Query("SELECT p.documento, p.tipo,p.programa,p.estado from Persona AS p ORDER BY p.estado.id,p.programa.id")
    List<?> findAllDataOrderByEstadoAndPrograma();

    @Query("SELECT p.documento, p.tipo,p.programa,p.estado from Persona AS p ORDER BY p.tipo.id,p.estado.id")
    List<?> findAllDataOrderyByTipoAndEstado();

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

    @Query("SELECT p.documento,p.tipo,p.programa,p.estado FROM Persona p WHERE p.estado.id>4 ORDER BY p.tipo.id,p.programa.id")
    List<?> findPersoonasPosibleAsistencia();

    @Query("SELECT p.documento,p.tipo,p.programa,p.estado FROM Persona p" +
            "   INNER JOIN Programa p2 ON p2.id= p.programa.id " +
            " WHERE p.estado.id>=5 AND p2.facultad.id=?1 ORDER BY p.tipo.id,p.programa.id")
    List<?>findByFacultadPersonasPosibles(int id);

    /**
     * SELECT t.nombre AS cargo,count(*) AS cantidad,prog.nombre AS programa, f.nombre AS facultad
     * FROM personas p
     *      INNER JOIN programas prog on prog.id = p.programa_id
     *      INNER JOIN facultades f on f.id = prog.facultad_id
     *      INNER JOIN tipos t on t.id = p.tipo_id
     * WHERE p.estado_id >= 5
     * GROUP BY t.nombre,f.nombre,t.id,prog.nombre
     * ORDER BY f.nombre,t.nombre;
     */
    @Query(value = "SELECT new com.demo.models.entity.ResumenFacultad(t.nombre,count(p),prog.nombre, f.nombre) FROM Persona p " +
            "INNER JOIN Programa prog ON prog.id = p.programa.id " +
            "INNER JOIN Facultad f ON f.id = prog.facultad.id " +
            "INNER JOIN Tipo t ON t.id = p.tipo.id " +
            "WHERE p.estado.id>=5 " +
            "GROUP BY t.nombre,f.nombre,t.id,prog.nombre " +
            "ORDER BY f.nombre")
    List<?> countByTipoAndProgramaAndFacultadPosibles();

    /**
     * SELECT count(*) AS cantiada,e.nombre,t.nombre FROM personas p
     *     INNER JOIN estados e on e.id = p.estado_id
     *     INNER JOIN tipos t on t.id = p.tipo_id
     * WHERE p.estado_id>=5
     * GROUP BY t.nombre,e.nombre;
     */
    @Query("SELECT new com.demo.models.entity.ResumenTipo(count(p),e.nombre,t.nombre) FROM Persona p " +
            "INNER JOIN Estado e  ON e.id=p.estado.id " +
            "INNER JOIN Tipo t  ON t.id=p.tipo.id " +
            "GROUP BY t.nombre,e.nombre " +
            "ORDER BY t.nombre,e.nombre")
    List<?> countPosiblesTipos();
}
