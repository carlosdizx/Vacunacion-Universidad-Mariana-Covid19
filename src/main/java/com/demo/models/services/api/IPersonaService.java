package com.demo.models.services.api;

import com.demo.models.entity.*;

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

    List<Facultad>findAllFacultades();

    List<Persona>findTiposPersonas(int id);

    List<Persona>findEstadosPersonas(int id);

    List<Persona>findPosibles();

    List<Persona>findFacultadPersonas(int id);
}
