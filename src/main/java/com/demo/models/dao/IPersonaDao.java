package com.demo.models.dao;

import com.demo.models.entity.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IPersonaDao extends CrudRepository<Persona, Long>
{
    @Query("SELECT p from Persona p ORDER BY p.estado.id")
    List<Persona> findAll();

    @Query("from Tipo")
    List<Tipo> findAllTipos();

    @Query("from Eps")
    List<Eps> findAllEps();

    @Query("from Estado")
    List<Estado> findAllEstados();

    @Query("from Facultad")
    List<Facultad> findAllFacultades();

    /**
     *
     * SELECT p.nombres,p.apellidos,e.nombre,p2.nombre FROM personas p
     *     INNER JOIN programas p2 on p2.id = p.programa_id
     *     INNER JOIN estados e on e.id = p.estado_id
     * WHERE p2.id=1;
     */
    @Query("SELECT p from Persona p INNER JOIN Programa p2 on p2.id = p.programa.id WHERE p2.id=?1")
    List<Facultad>findProgramaById(int id);

    @Query("SELECT p FROM Persona p WHERE p.tipo.id=?1 ORDER BY p.estado.id")
    List<Persona>findTiposPersonas(int id);

    @Query("SELECT p FROM Persona p WHERE p.estado.id>4 ORDER BY p.tipo.id,p.estado.id")
    List<Persona>findPosibles();
}
