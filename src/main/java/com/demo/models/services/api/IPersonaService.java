package com.demo.models.services.api;

import com.demo.models.entity.*;
import com.demo.models.entity.auxliar.PersonaSencilla;
import com.demo.models.entity.auxliar.Resumen;

import java.util.List;

public interface IPersonaService
{
    List<PersonaSencilla> findAllDataOrderByEstadoAndPrograma();

    List<PersonaSencilla> findAllDataOrderyByTipoAndEstado();

    Persona findById(Long pId );

    Persona save(Persona persona);

    void delete( Long pId );

    List<Tipo>findAllTipos();

    List<Eps>findAllEps();

    List<Estado>findAllEstados();

    List<Facultad>findAllFacultades();

    List<Programa>findAllProgramas();

    List<PersonaSencilla>findTiposPersonas(int id);

    List<PersonaSencilla>findEstadosPersonas(int id);

    List<PersonaSencilla>findPersoonasPosibleAsistencia();

    List<PersonaSencilla>findByFacultadPersonasPosibles(int id);

    List<?>countByTipoAndProgramaAndFacultadPosibles();

    List<?> countPosiblesTipos();

    List<Resumen> countByTipo();

    List<Resumen> countByEstado();
}
