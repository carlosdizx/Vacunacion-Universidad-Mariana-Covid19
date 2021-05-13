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
    final static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###.##");

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
            if( total<=0 || total!=(estudiantes+docentes+administrativos+directivos) )
            {
                response.put("Mensaje","No hay personas registradas en las bases de datos, o los datos cargados son incorrectos!");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            final String estudiantesPor = DECIMAL_FORMAT.format((double) 100*estudiantes/total);
            final String docentesPor = DECIMAL_FORMAT.format((double)100*docentes/total);
            final String administrativosPor = DECIMAL_FORMAT.format((double)100*administrativos/total);
            final String directivosPor = DECIMAL_FORMAT.format((double)100*directivos/total);
            final String posiblesPor = DECIMAL_FORMAT.format((double)100*posibles/total);
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
            final int total = list().size();
            final int desconocidos = service.findEstadosPersonas(1).size();
            final int contagiados = service.findEstadosPersonas(2).size();
            final int saludabes = service.findEstadosPersonas(3).size();
            final int preContagiados = service.findEstadosPersonas(4).size();
            final int preVacunados = service.findEstadosPersonas(5).size();
            final int vacunados = service.findEstadosPersonas(6).size();
            if( total<=0 || total!=(desconocidos+contagiados+saludabes+preContagiados+preVacunados+vacunados) )
            {
                response.put("Mensaje","No hay personas registradas en las bases de datos, o los datos cargados son incorrectos!");
                response.put("Mensaje2","Total personas: "+total+", sumatoria: "+(desconocidos+contagiados+saludabes+preContagiados+preVacunados+vacunados));
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            final String desconocidosPor = DECIMAL_FORMAT.format((double) 100*desconocidos/total);
            final String contagiosPor = DECIMAL_FORMAT.format((double) 100*contagiados/total);
            final String saludablesPor = DECIMAL_FORMAT.format((double) 100*saludabes/total);
            final String preContagiadosPor = DECIMAL_FORMAT.format((double) 100*preContagiados/total);
            final String preVacunadosPor = DECIMAL_FORMAT.format((double) 100*preVacunados/total);
            final String vacunadosPor = DECIMAL_FORMAT.format((double) 100*vacunados/total);
            response.put("Total 100%",total);
            response.put("Desconocidos "+desconocidosPor+"%",desconocidos);
            response.put("Contagiados "+contagiosPor+"%",contagiados);
            response.put("Saludables "+saludablesPor+"%",saludabes);
            response.put("Anteriormente contagiados "+preContagiadosPor+"%",preContagiados);
            response.put("Pendiente segunda dosis "+preVacunadosPor+"%",preVacunados);
            response.put("Vacunados "+vacunadosPor+"%",vacunados);
            return new ResponseEntity(response, HttpStatus.OK);
        }
        catch (DataAccessException e)
        {
            response.put("Mensaje","No se ha logrado realizar la consulta en la base de datos");
            response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage() ));
            return new ResponseEntity(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/graficas/3")
    public ResponseEntity<HashMap<String,Object>> graficThree()
    {
        final Map<String,Object> response = new HashMap<>();
        try
        {
            final int total = list().size();
            final int educacion = service.findFacultadPersonas(1).size();
            final int ingenieria = service.findFacultadPersonas(2).size();
            final int salud = service.findFacultadPersonas(3).size();
            final int contables = service.findFacultadPersonas(4).size();
            final int humanidades = service.findFacultadPersonas(5).size();
            final int administrativas = service.findFacultadPersonas(6).size();
            if(total!=(educacion+ingenieria+salud+contables+humanidades+administrativas) || total <=0)
            {
                response.put("Mensaje","No hay personas registradas en las bases de datos, o los datos cargados son incorrectos!");
                response.put("Mensaje2","Total personas: "+total+", sumatoria: "+(educacion+ingenieria+salud+contables+humanidades+administrativas));
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            final String educacionPor = DECIMAL_FORMAT.format((double) 100*educacion/total);
            final String ingenieriaPor = DECIMAL_FORMAT.format((double) 100*ingenieria/total);
            final String saludPor = DECIMAL_FORMAT.format((double) 100*salud/total);
            final String contablesPor = DECIMAL_FORMAT.format((double) 100*contables/total);
            final String humanidadesPor = DECIMAL_FORMAT.format((double) 100*humanidades/total);
            final String administrativasPor = DECIMAL_FORMAT.format((double) 100*administrativas/total);
            response.put("Total 100%",total);
            response.put("Educación "+educacionPor+"%",educacion);
            response.put("Ingeniería "+ingenieriaPor+"%",ingenieria);
            response.put("Salud "+saludPor+"%",salud);
            response.put("Contables, Economicas y financieras "+contablesPor+"%",contables);
            response.put("Humanidades y Sociales "+humanidadesPor+"%",humanidades);
            response.put("Administración "+administrativasPor+"%",administrativas);
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
