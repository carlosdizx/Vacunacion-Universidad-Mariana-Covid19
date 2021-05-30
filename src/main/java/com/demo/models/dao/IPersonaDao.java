package com.demo.models.dao;

import com.demo.models.entity.*;
import com.demo.models.entity.auxliar.PersonaSencilla;
import com.demo.models.entity.auxliar.Resumen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPersonaDao extends JpaRepository<Persona, Long>
{

    @Query("SELECT new com.demo.models.entity.auxliar.PersonaSencilla(p.documento,t,prog,e) " +
            "FROM Persona p " +
            "INNER JOIN Programa prog ON prog.id = p.programa.id " +
            "INNER JOIN Estado e ON e.id = p.estado.id " +
            "INNER JOIN Tipo t ON t.id = p.tipo.id " +
            "ORDER BY p.estado.id,p.programa.id")
    List<PersonaSencilla> findAllDataOrderByEstadoAndPrograma();

    @Query("SELECT new com.demo.models.entity.auxliar.PersonaSencilla(p.documento, t,prog,e) " +
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

    @Query("SELECT new com.demo.models.entity.auxliar.PersonaSencilla(p.documento,t,prog,e) " +
            "FROM Persona p " +
            "INNER JOIN Programa prog ON prog.id = p.programa.id " +
            "INNER JOIN Estado e ON e.id = p.estado.id " +
            "INNER JOIN Tipo t ON t.id = p.tipo.id " +
            "WHERE p.tipo.id=?1 ORDER BY p.estado.id")
    List<PersonaSencilla>findTiposPersonas(int id);

    @Query("SELECT new com.demo.models.entity.auxliar.PersonaSencilla(p.documento,t,prog,e) " +
            "FROM Persona p " +
            "INNER JOIN Programa prog ON prog.id = p.programa.id " +
            "INNER JOIN Estado e ON e.id = p.estado.id " +
            "INNER JOIN Tipo t ON t.id = p.tipo.id " +
            "WHERE p.estado.id=?1 ORDER BY p.estado.id")
    List<PersonaSencilla>findEstadosPersonas(int id);

    @Query("SELECT new com.demo.models.entity.auxliar.PersonaSencilla(p.documento,t,prog,e) " +
            "FROM Persona p " +
            "INNER JOIN Programa prog ON prog.id = p.programa.id " +
            "INNER JOIN Estado e ON e.id = p.estado.id " +
            "INNER JOIN Tipo t ON t.id = p.tipo.id " +
            "WHERE p.estado.id>4 ORDER BY p.tipo.id,p.programa.id")
    List<PersonaSencilla> findPersoonasPosibleAsistencia();

    @Query("SELECT new com.demo.models.entity.auxliar.PersonaSencilla(p.documento,t,prog,e) " +
            "FROM Persona p " +
            "INNER JOIN Programa prog ON prog.id = p.programa.id " +
            "INNER JOIN Estado e ON e.id = p.estado.id " +
            "INNER JOIN Tipo t ON t.id = p.tipo.id " +
            " WHERE p.estado.id>=5 AND prog.facultad.id=?1 ORDER BY p.tipo.id,p.programa.id")
    List<PersonaSencilla>findByFacultadPersonasPosibles(int id);

    @Query(value = "SELECT new com.demo.models.entity.auxliar.Resumen(concat(f.nombre,'-',t.nombre),count(p) )" +
            "FROM Persona p " +
            "INNER JOIN Tipo t ON t.id = p.tipo.id " +
            "INNER JOIN Programa prog ON prog.id = p.programa.id " +
            "INNER JOIN Facultad f ON f.id = prog.facultad.id " +
            "WHERE p.estado.id>=5 " +
            "GROUP BY f.nombre,t.nombre " +
            "ORDER BY f.nombre")
    List<Resumen> countByTipoAndProgramaAndFacultadPosibles();

    // ------------------------------- Metodos de Resumen -------------------------------

    @Query("SELECT new com.demo.models.entity.auxliar.Resumen(t.nombre, count(p.tipo.id)) " +
            "FROM Persona p " +
            "INNER JOIN Tipo t on t.id = p.tipo.id " +
            "GROUP BY t.nombre")
    List<Resumen> countByTipo();

    @Query("SELECT new com.demo.models.entity.auxliar.Resumen(e.nombre, count(p.estado.id)) " +
            "FROM Persona p " +
            "INNER JOIN Estado e on e.id = p.estado.id GROUP BY e.nombre")
    List<Resumen> countByEstado();

    @Query("SELECT new com.demo.models.entity.auxliar.Resumen(f.nombre,count(p)) "+
            "FROM Persona p " +
            "INNER JOIN Programa p2 on p2.id = p.programa.id " +
            "INNER JOIN Facultad f on f.id = p2.facultad.id " +
            "WHERE p.estado.id>=5 " +
            "GROUP BY f.nombre " +
            "ORDER BY f.nombre")
    List<Resumen> countPersonaByEstadoAndFacultad();

    /**
     SELECT concat(t.nombre,'-',e.nombre),count(p)
     FROM personas p
     INNER JOIN tipos t on t.id = p.tipo_id
     INNER JOIN estados e on e.id = p.estado_id
     GROUP BY t.nombre, e.nombre
     ORDER BY e.nombre;
     */
    @Query("SELECT new com.demo.models.entity.auxliar.ResumenTipo(count(p),e.nombre,t.nombre) FROM Persona p " +
            "INNER JOIN Estado e  ON e.id=p.estado.id " +
            "INNER JOIN Tipo t  ON t.id=p.tipo.id " +
            "GROUP BY t.nombre,e.nombre " +
            "ORDER BY t.nombre,e.nombre")
    List<?> countPosiblesTipos();
}
