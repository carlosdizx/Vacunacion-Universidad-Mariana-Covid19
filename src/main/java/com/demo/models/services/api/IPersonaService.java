package com.demo.models.services.api;

import com.demo.models.entity.Eps;
import com.demo.models.entity.Estado;
import com.demo.models.entity.Persona;
import com.demo.models.entity.Tipo;

import java.util.List;

public interface IPersonaService
{
    List<Persona> findAll();

    Persona findById(Long pId );

    Persona save(Persona persona);

    void delete( Long pId );

    List<Tipo>findAllTipos();

    List<Eps>findAllEps();

    List<Estado>findAllEstados();
}
