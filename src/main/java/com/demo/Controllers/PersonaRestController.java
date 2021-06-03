package com.demo.Controllers;

import com.demo.models.entity.*;
import com.demo.models.entity.auxliar.PersonaSencilla;
import com.demo.models.entity.auxliar.Resumen;
import com.demo.models.services.api.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:4200","https://trazabilidad-vacuna-covid19-umariana.netlify.app/bio"})
@RestController
@RequestMapping("/personas")
public class PersonaRestController
{
    // final static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###.##");

    final static Map<String,Object> RESPONSE = new HashMap<>();

    @Autowired
    private IPersonaService service;

    @GetMapping("/all/estadoPrograma")
    public List<PersonaSencilla> findAllDataOrderByEstadoAndPrograma()
    {
        return service.findAllDataOrderByEstadoAndPrograma();
    }
    @GetMapping("/all/tipoEstado")
    public List<PersonaSencilla> findAllDataOrderyByTipoAndEstado()
    {
        return service.findAllDataOrderyByTipoAndEstado();
    }

    @GetMapping("/{documento}")
    public ResponseEntity<HashMap<String,Object>> findById(@PathVariable Long documento)
    {
        RESPONSE.clear();
        try
        {
            Persona persona = service.findById(documento);
            if (persona==null)
            {
                RESPONSE.put("Mensaje","No hay una persona con el documento: ".concat(documento.toString()));
                return new ResponseEntity(RESPONSE, HttpStatus.NOT_FOUND);
            }
            else
            {
                RESPONSE.put("Persona",persona);
                return new ResponseEntity(RESPONSE, HttpStatus.OK);
            }
        }
        catch (DataAccessException e)
        {
            RESPONSE.put("Mensaje","No se ha logrado realizar la consulta en la base de datos");
            RESPONSE.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage() ));
            return new ResponseEntity(RESPONSE,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/programas")
    public List<Programa>findAllProgramas()
    {
        return service.findAllProgramas();
    }

    @GetMapping("/tipos")
    public List<Tipo> findAllTipos()
    {
        return service.findAllTipos();
    }

    @GetMapping("/tipos/{id}")
    public ResponseEntity<HashMap<String,Object>> findTiposPersonas(@PathVariable int id)
    {
        RESPONSE.clear();
        try
        {
            final List<PersonaSencilla> listado = service.findTiposPersonas(id);
            if (listado.isEmpty())
            {
                RESPONSE.put("Mensaje","No hay personas del tipo: '"+id+"'");
                return new ResponseEntity(RESPONSE, HttpStatus.NOT_FOUND);
            }
            RESPONSE.put("Lista",listado);
            return new ResponseEntity(RESPONSE, HttpStatus.OK);
        }
        catch (DataAccessException e)
        {
            RESPONSE.put("Mensaje","No se ha logrado realizar la consulta en la base de datos");
            RESPONSE.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage() ));
            return new ResponseEntity(RESPONSE,HttpStatus.INTERNAL_SERVER_ERROR);
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
        RESPONSE.clear();
        try
        {
            final List<PersonaSencilla> listado = service.findEstadosPersonas(id);
            if (listado.isEmpty())
            {
                RESPONSE.put("Mensaje","No hay personas en el estado: '"+id+"'");
                return new ResponseEntity(RESPONSE, HttpStatus.NOT_FOUND);
            }
            RESPONSE.put("Lista",listado);
            return new ResponseEntity(RESPONSE, HttpStatus.OK);
        }
        catch (DataAccessException e)
        {
            RESPONSE.put("Mensaje","No se ha logrado realizar la consulta en la base de datos");
            RESPONSE.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage() ));
            return new ResponseEntity(RESPONSE,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/facultades")
    public List<Facultad> findAllFacultades()
    {
        return service.findAllFacultades();
    }

    @GetMapping("posible/facultades/{id}")
    public ResponseEntity<HashMap<String,Object>>findByFacultadPersonasPosibles(@PathVariable int id)
    {
        RESPONSE.clear();
        final List<PersonaSencilla> list = service.findByFacultadPersonasPosibles(id);
        if (list.isEmpty())
        {
            RESPONSE.put("Mensaje","No hay personas posibles en la facultad con el id: '"+id+"'");
            return new ResponseEntity(RESPONSE, HttpStatus.NOT_FOUND);
        }
        RESPONSE.put("Lista",list);
        return new ResponseEntity(RESPONSE, HttpStatus.OK);
    }

    @GetMapping("/posibles")
    public ResponseEntity<HashMap<String,Object>> findPersoonasPosibleAsistencia()
    {
        RESPONSE.clear();
        try
        {
            final List<PersonaSencilla> listado = service.findPersoonasPosibleAsistencia();
            if (listado.isEmpty())
            {
                RESPONSE.put("Mensaje","No hay personas que puedan asistir a la Universidad");
                return new ResponseEntity(RESPONSE, HttpStatus.OK);
            }
            RESPONSE.put("Lista",listado);
            return new ResponseEntity(RESPONSE, HttpStatus.OK);
        }
        catch (DataAccessException e)
        {
            RESPONSE.put("Mensaje","No se ha logrado realizar la consulta en la base de datos");
            RESPONSE.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage() ));
            return new ResponseEntity(RESPONSE,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/posiblesFacultades")
    public ResponseEntity<HashMap<String,Object>> countByTipoAndProgramaAndFacultadPosibles()
    {
        RESPONSE.clear();
        try
        {
            final List<Resumen> list = service.countByTipoAndProgramaAndFacultadPosibles();
            RESPONSE.put("Lista",list);
            return new ResponseEntity(RESPONSE, HttpStatus.OK);
        }
        catch (DataAccessException e)
        {
            RESPONSE.put("Mensaje","No se ha logrado realizar la consulta en la base de datos");
            RESPONSE.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage() ));
            return new ResponseEntity(RESPONSE,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/graficas/1")
    public ResponseEntity<HashMap<String,Object>> graficOne()
    {
        RESPONSE.clear();
        try
        {
            List<Resumen> resumen = service.countByTipo();
            RESPONSE.put("Resumen",resumen);
            return new ResponseEntity(RESPONSE, HttpStatus.OK);
        }
        catch (DataAccessException e)
        {
            RESPONSE.put("Mensaje","No se ha logrado realizar la consulta en la base de datos");
            RESPONSE.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage() ));
            return new ResponseEntity(RESPONSE,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/graficas/2")
    public ResponseEntity<HashMap<String,Object>> graficTwo()
    {
        RESPONSE.clear();
        try
        {
            final List<Resumen> list = service.countByEstado();
            RESPONSE.put("Resumen",list);
            return new ResponseEntity(RESPONSE, HttpStatus.OK);
        }
        catch (DataAccessException e)
        {
            RESPONSE.put("Mensaje","No se ha logrado realizar la consulta en la base de datos");
            RESPONSE.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage() ));
            return new ResponseEntity(RESPONSE,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/graficas/3")
    public ResponseEntity<HashMap<String,Object>> graficThree()
    {
        RESPONSE.clear();
        try
        {
            final List<Resumen> list = service.countPersonaByEstadoAndFacultad();
            if (list.isEmpty())
            {
                RESPONSE.put("Mensaje","No hay facultades que tengan la posibilidad de asistir a la Universidad Mariana");
                return new ResponseEntity(RESPONSE,HttpStatus.OK);
            }
            RESPONSE.put("Resumen",list);
            return new ResponseEntity(RESPONSE,HttpStatus.OK);
        }
        catch (DataAccessException e)
        {
            RESPONSE.put("Mensaje","No se ha logrado realizar la consulta en la base de datos");
            RESPONSE.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage() ));
            return new ResponseEntity(RESPONSE,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/graficas/4")
    public ResponseEntity<HashMap<String,Object>> graficFour()
    {
        RESPONSE.clear();
        try
        {
            final List<?> listado = service.countPosiblesTipos();
            if (listado.isEmpty())
            {
                RESPONSE.put("Mensaje", "No hay datos en la base de datos!");
                return new ResponseEntity(RESPONSE, HttpStatus.NOT_FOUND);
            }
            RESPONSE.put("Lista",listado);
            return new ResponseEntity(RESPONSE, HttpStatus.OK);
        }
        catch (DataAccessException e)
        {
            RESPONSE.put("Mensaje","No se ha logrado realizar la consulta en la base de datos");
            RESPONSE.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage() ));
            return new ResponseEntity(RESPONSE,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
