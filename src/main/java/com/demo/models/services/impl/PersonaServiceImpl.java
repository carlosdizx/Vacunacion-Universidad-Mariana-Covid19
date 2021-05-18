package com.demo.models.services.impl;

import com.demo.models.dao.IPersonaDao;
import com.demo.models.entity.*;
import com.demo.models.services.api.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService
{
    @Autowired
    private IPersonaDao dao;

    @Override
    @Transactional(readOnly = true)
    public List<?> findAllDataOrderByEstadoAndPrograma()
    {
        return dao.findAllDataOrderByEstadoAndPrograma();
    }

    @Override
    @Transactional(readOnly = true)
    public List<?> findAllDataOrderyByTipoAndEstado()
    {
        return dao.findAllDataOrderyByTipoAndEstado();
    }

    @Override
    @Transactional(readOnly = true)
    public Persona findById(Long pId)
    {
        return dao.findById(pId).orElse(null);
    }

    @Override
    @Transactional
    public Persona save(Persona persona)
    {
        return dao.save(persona);
    }

    @Override
    @Transactional
    public void delete(Long pId)
    {
        dao.deleteById(pId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Tipo> findAllTipos()
    {
        return dao.findAllTipos();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Eps> findAllEps()
    {
        return dao.findAllEps();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Estado> findAllEstados()
    {
        return dao.findAllEstados();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Facultad> findAllFacultades()
    {
        return dao.findAllFacultades();
    }

    @Override
    public List<Programa> findAllProgramas() {
        return dao.findAllProgramas();
    }

    @Override
    @Transactional(readOnly = true)
    public List<?> findTiposPersonas(int id)
    {
        return dao.findTiposPersonas(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Persona> findEstadosPersonas(int id)
    {
        return dao.findEstadosPersonas(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<?> findPersoonasPosibleAsistencia()
    {
        return dao.findPersoonasPosibleAsistencia();
    }
    @Override
    @Transactional(readOnly = true)
    public List<?>findByFacultadPersonasPosibles(int id)
    {
        return dao.findByFacultadPersonasPosibles(id);
    }

    @Override
    public List<?> countByTipoAndProgramaAndFacultadPosibles() {
        return dao.countByTipoAndProgramaAndFacultadPosibles();
    }

    @Override
    @Transactional(readOnly = true)
    public List<?> countPosiblesTipos()
    {
        return dao.countPosiblesTipos();
    }
}
