package com.demo.models.dao;

import com.demo.models.entity.Eps;
import com.demo.models.entity.Estado;
import com.demo.models.entity.Persona;
import com.demo.models.entity.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPersonaDao extends JpaRepository<Persona, Long>
{
    @Query("from Persona ")
    List<Persona>findAll();

    @Query("from Tipo")
    List<Tipo>findAllTipos();

    @Query("from Eps")
    List<Eps>findAllEps();

    @Query("from Estado ")
    List<Estado>findAllEstados();
}
