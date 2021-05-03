package com.demo.Controllers;

import com.demo.models.entity.*;
import com.demo.models.services.api.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"*","http://localhost:4200"})
@RestController
@RequestMapping("/personas")
public class PersonaRestController
{
    @Autowired
    private IPersonaService service;

    @GetMapping("/all")
    public List<Persona> list()
    {
        return service.findAll();
    }

    @GetMapping("/{documento}")
    public ResponseEntity<HashMap<String,Object>> findById(@PathVariable Long documento)
    {

        final Map<String,Object> response = new HashMap<>();
        try
        {
            Persona persona = service.findById(documento);
            if (persona==null)
            {
                response.put("Mensaje","No hay una persona con el documento: ".concat(documento.toString()));
                return new ResponseEntity(response, HttpStatus.NOT_FOUND);
            }
            else
            {
                response.put("Persona",persona);
                return new ResponseEntity(response, HttpStatus.OK);
            }
        }
        catch (DataAccessException e)
        {
            response.put("Mensaje","No se ha logrado realizar la consulta en la base de datos");
            response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage() ));
            return new ResponseEntity(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tipos")
    public List<Tipo> findAllTipos()
    {
        return service.findAllTipos();
    }

    @GetMapping("/eps")
    public List<Eps> findAllEps()
    {
        return service.findAllEps();
    }

    @GetMapping("/estados")
    public List<Estado> findAllEstados()
    {
        return service.findAllEstados();
    }

    @GetMapping("/facultades")
    public List<Facultad> findAllFacultades()
    {
        return service.findAllFacultades();
    }

    @GetMapping("/docentes")
    public List<Persona> findDocentes()
    {
        return service.findDocentes();
    }

    @GetMapping("/docentesPosibles")
    public List<Persona> findPosiblesDocentes()
    {
        return service.findPosiblesDocentes();
    }
}
