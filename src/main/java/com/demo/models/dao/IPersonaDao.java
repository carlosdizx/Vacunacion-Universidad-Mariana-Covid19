package com.demo.models.dao;

import com.demo.models.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface IPersonaDao extends JpaRepository<Persona, Long>
{

    @Query("SELECT new com.demo.models.entity.PersonaSencilla(p.documento,t,prog,e) " +
            "FROM Persona p " +
            "INNER JOIN Programa prog ON prog.id = p.programa.id " +
            "INNER JOIN Estado e ON e.id = p.estado.id " +
            "INNER JOIN Tipo t ON t.id = p.tipo.id " +
            "ORDER BY p.estado.id,p.programa.id")
    List<PersonaSencilla> findAllDataOrderByEstadoAndPrograma();

    @Query("SELECT new com.demo.models.entity.PersonaSencilla(p.documento, t,prog,e) " +
            "FROM Persona p " +
            "INNER JOIN Programa prog ON prog.id = p.programa.id " +
            "INNER JOIN Estado e ON e.id = p.estado.id " +
            "INNER JOIN Tipo t ON t.id = p.tipo.id " +
            "ORDER BY p.tipo.id,p.estado.id")
    List<PersonaSencilla> findAllDataOrderyByTipoAndEstado();

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

    @Query("SELECT new com.demo.models.entity.PersonaSencilla(p.documento,t,prog,e) " +
            "FROM Persona p " +
            "INNER JOIN Programa prog ON prog.id = p.programa.id " +
            "INNER JOIN Estado e ON e.id = p.estado.id " +
            "INNER JOIN Tipo t ON t.id = p.tipo.id " +
            "WHERE p.tipo.id=?1 ORDER BY p.estado.id")
    List<PersonaSencilla>findTiposPersonas(int id);

    @Query("SELECT new com.demo.models.entity.PersonaSencilla(p.documento,t,prog,e) " +
            "FROM Persona p " +
            "INNER JOIN Programa prog ON prog.id = p.programa.id " +
            "INNER JOIN Estado e ON e.id = p.estado.id " +
            "INNER JOIN Tipo t ON t.id = p.tipo.id " +
            "WHERE p.estado.id=?1 ORDER BY p.estado.id")
    List<PersonaSencilla>findEstadosPersonas(int id);

    @Query("SELECT new com.demo.models.entity.PersonaSencilla(p.documento,t,prog,e) " +
            "FROM Persona p " +
            "INNER JOIN Programa prog ON prog.id = p.programa.id " +
            "INNER JOIN Estado e ON e.id = p.estado.id " +
            "INNER JOIN Tipo t ON t.id = p.tipo.id " +
            "WHERE p.estado.id>4 ORDER BY p.tipo.id,p.programa.id")
    List<PersonaSencilla> findPersoonasPosibleAsistencia();

    @Query("SELECT new com.demo.models.entity.PersonaSencilla(p.documento,t,prog,e) " +
            "FROM Persona p " +
            "INNER JOIN Programa prog ON prog.id = p.programa.id " +
            "INNER JOIN Estado e ON e.id = p.estado.id " +
            "INNER JOIN Tipo t ON t.id = p.tipo.id " +
            " WHERE p.estado.id>=5 AND prog.facultad.id=?1 ORDER BY p.tipo.id,p.programa.id")
    List<PersonaSencilla>findByFacultadPersonasPosibles(int id);

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
    @Query(value = "SELECT t.nombre,count(p),prog.nombre, f.nombre FROM Persona p " +
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
