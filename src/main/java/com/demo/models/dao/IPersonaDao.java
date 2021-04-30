package com.demo.models.dao;

import com.demo.models.entity.Persona;
import com.demo.models.entity.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPersonaDao extends JpaRepository<Persona, Long>
{
    @Query("from Tipo")
    List<Tipo>findAllTipos();
}
