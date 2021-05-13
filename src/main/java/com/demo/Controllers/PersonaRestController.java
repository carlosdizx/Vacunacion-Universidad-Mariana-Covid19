package com.demo.Controllers;

import com.demo.models.entity.*;
import com.demo.models.services.api.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
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

    @GetMapping("/tipos/{id}")
    public ResponseEntity<HashMap<String,Object>> findTiposPersonas(@PathVariable int id)
    {
        final Map<String,Object> response = new HashMap<>();
        try
        {
            final List<Persona> listado = service.findTiposPersonas(id);
            if (listado.isEmpty())
            {
                response.put("Mensaje","No hay personas del tipo: '"+id+"'");
                return new ResponseEntity(response, HttpStatus.NOT_FOUND);
            }
            response.put("Lista",listado);
            return new ResponseEntity(response, HttpStatus.OK);
        }
        catch (DataAccessException e)
        {
            response.put("Mensaje","No se ha logrado realizar la consulta en la base de datos");
            response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage() ));
            return new ResponseEntity(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
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

    @GetMapping("/estados/{id}")
    public ResponseEntity<HashMap<String,Object>> findEstadosPersonas(@PathVariable int id)
    {
        final Map<String,Object> response = new HashMap<>();
        try
        {
            final List<Persona> listado = service.findEstadosPersonas(id);
            if (listado.isEmpty())
            {
                response.put("Mensaje","No hay personas en el estado: '"+id+"'");
                return new ResponseEntity(response, HttpStatus.NOT_FOUND);
            }
            response.put("Lista",listado);
            return new ResponseEntity(response, HttpStatus.OK);
        }
        catch (DataAccessException e)
        {
            response.put("Mensaje","No se ha logrado realizar la consulta en la base de datos");
            response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage() ));
            return new ResponseEntity(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/facultades")
    public List<Facultad> findAllFacultades()
    {
        return service.findAllFacultades();
    }

    @GetMapping("/posibles")
    public List<Persona> findPosibles()
    {
        return service.findPosibles();
    }

    @GetMapping("/graficas/1")
    public ResponseEntity<HashMap<String,Object>> graficOne()
    {
        final Map<String,Object> response = new HashMap<>();
        try
        {
            final int total = list().size();
            final int estudiantes = service.findTiposPersonas(1).size();
            final int docentes = service.findTiposPersonas(2).size();
            final int administrativos = service.findTiposPersonas(3).size();
            final int directivos = service.findTiposPersonas(4).size();
            final int posibles = service.findPosibles().size();
            if( total<0 || total!=(estudiantes+docentes+administrativos+directivos) )
            {
                response.put("Mensaje","No hay personas registradas en las bases de datos, o los datos cargados son incorrectos!");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            final DecimalFormat df = new DecimalFormat("###.##");
            final String estudiantesPor = df.format((double) 100*estudiantes/total);
            final String docentesPor = df.format((double)100*docentes/total);
            final String administrativosPor = df.format((double)100*administrativos/total);
            final String directivosPor = df.format((double)100*directivos/total);
            final String posiblesPor = df.format((double)100*posibles/total);
            response.put("Total 100%",total);
            response.put("Estudiantes "+estudiantesPor+"%",estudiantes);
            response.put("Docentes "+docentesPor+"%",docentes);
            response.put("Administrativos "+administrativosPor+"%",administrativos);
            response.put("Directivos "+directivosPor+"%",directivos);
            response.put("Posibles "+posiblesPor+"%",posibles);
            return new ResponseEntity(response, HttpStatus.OK);
        }
        catch (DataAccessException e)
        {
            response.put("Mensaje","No se ha logrado realizar la consulta en la base de datos");
            response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage() ));
            return new ResponseEntity(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/graficas/2")
    public ResponseEntity<HashMap<String,Object>> graficTwo()
    {
        final Map<String,Object> response = new HashMap<>();
        try
        {

            return new ResponseEntity(response, HttpStatus.OK);
        }
        catch (DataAccessException e)
        {
            response.put("Mensaje","No se ha logrado realizar la consulta en la base de datos");
            response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage() ));
            return new ResponseEntity(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
