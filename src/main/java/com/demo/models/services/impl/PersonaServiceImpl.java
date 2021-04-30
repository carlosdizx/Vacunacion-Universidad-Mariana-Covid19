package com.demo.models.services.impl;

import com.demo.models.dao.IPersonaDao;
import com.demo.models.entity.Persona;
import com.demo.models.services.api.IPersonaService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class PersonaServiceImpl implements IPersonaService
{

    private IPersonaDao dao;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> findAll()
    {
        return dao.findAll();
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
}
