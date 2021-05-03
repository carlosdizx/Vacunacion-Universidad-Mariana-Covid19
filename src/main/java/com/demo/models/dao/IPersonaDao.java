package com.demo.models.dao;

import com.demo.models.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPersonaDao extends JpaRepository<Persona, Long>
{
    @Query("SELECT p from Persona p ORDER BY p.estado.id")
    List<Persona>findAll();

    @Query("from Tipo")
    List<Tipo>findAllTipos();

    @Query("from Eps")
    List<Eps>findAllEps();

    @Query("from Estado")
    List<Estado>findAllEstados();

    @Query("from Facultad")
    List<Facultad>findAllFacultades();

    @Query("SELECT p FROM Persona p WHERE p.tipo.id=2 ORDER BY p.facultad.nombre,p.estado.nombre")
    List<Persona>findDocentes();

    @Query("SELECT p FROM Persona p WHERE p.tipo.id=2 AND p.estado.id>=4")
    List<Persona>findPosiblesDocentes();
}
