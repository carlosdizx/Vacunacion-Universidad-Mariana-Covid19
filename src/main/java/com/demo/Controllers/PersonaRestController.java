package com.demo.Controllers;

import com.demo.models.entity.*;
import com.demo.models.services.api.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/personas")
public class PersonaRestController
{
    final static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###.##");

    final static Map<String,Object> RESPONSE = new HashMap<>();

    @Autowired
    private IPersonaService service;

    @GetMapping("/all")
    public List<PersonaSencilla> findAllDataOrderByEstadoAndPrograma()
    {
        final List<?> list = service.findAllDataOrderByEstadoAndPrograma();
        final List<PersonaSencilla> listSencilla = new ArrayList<>();
        for (int i = 0 ; i < list.size() ; i++)
        {
            final Object[] o = (Object[]) list.get(i);
            listSencilla.add(new PersonaSencilla((Long) o[0],(Tipo) o[1],(Programa) o[2],(Estado) o[3]));
        }
        return listSencilla;
    }
    @GetMapping("/2all")
    public List<PersonaSencilla> findAllDataOrderyByTipoAndEstado()
    {
        final List<?> list = service.findAllDataOrderyByTipoAndEstado();
        final List<PersonaSencilla> listSencilla = new ArrayList<>();
        for (int i = 0 ; i < list.size() ; i++)
        {
            final Object[] o = (Object[]) list.get(i);
            listSencilla.add(new PersonaSencilla((Long) o[0],(Tipo) o[1],(Programa) o[2],(Estado) o[3]));
        }
        return listSencilla;
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
            final List<?> listado = service.findTiposPersonas(id);
            final List<PersonaSencilla> listSencilla = new ArrayList<>();
            for (int i = 0 ; i < listado.size() ; i++)
            {
                final Object[] o = (Object[]) listado.get(i);
                listSencilla.add(new PersonaSencilla((Long) o[0],null,(Programa) o[1],(Estado) o[2]));
            }
            if (listado.isEmpty())
            {
                RESPONSE.put("Mensaje","No hay personas del tipo: '"+id+"'");
                return new ResponseEntity(RESPONSE, HttpStatus.NOT_FOUND);
            }
            RESPONSE.put("Lista",listSencilla);
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
            final List<Persona> listado = service.findEstadosPersonas(id);
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

    @GetMapping("/facultades/{id}")
    public List<?>findByFacultadPersonasPosibles(@PathVariable int id)
    {
        return service.findByFacultadPersonasPosibles(id);
    }

    @GetMapping("/posibles")
    public ResponseEntity<HashMap<String,Object>> findPersoonasPosibleAsistencia()
    {
        RESPONSE.clear();
        try
        {
            final List<?> listado = service.findPersoonasPosibleAsistencia();
            final List<PersonaSencilla> listSencilla = new ArrayList<>();
            for (int i = 0 ; i < listado.size() ; i++)
            {
                final Object[] o = (Object[]) listado.get(i);
                listSencilla.add(new PersonaSencilla((Long) o[0],(Tipo) o[1],(Programa) o[2],(Estado) o[3]));
            }
            if (listSencilla.isEmpty())
            {
                RESPONSE.put("Mensaje","No hay personas que puedan asistir a la Universidad");
                return new ResponseEntity(RESPONSE, HttpStatus.NOT_FOUND);
            }
            RESPONSE.put("Lista",listSencilla);
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
            final List<?> list = service.countByTipoAndProgramaAndFacultadPosibles();
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


    @GetMapping("/graficas")
    public ResponseEntity<HashMap<String,Object>> graficas()
    {
        final HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("Grafico 1",graficOne().getBody());
        hashMap.put("Grafico 2",graficTwo().getBody());
        hashMap.put("Grafico 3",graficThree().getBody());
        return new ResponseEntity(hashMap, HttpStatus.OK);
    }

    @GetMapping("/graficas/1")
    public ResponseEntity<HashMap<String,Object>> graficOne()
    {
        RESPONSE.clear();
        try
        {
            final int total = service.findAllDataOrderByEstadoAndPrograma().size();
            final int estudiantes = service.findTiposPersonas(1).size();
            final int docentes = service.findTiposPersonas(2).size();
            final int administrativos = service.findTiposPersonas(3).size();
            final int directivos = service.findTiposPersonas(4).size();
            final int posibles = service.findPersoonasPosibleAsistencia().size();
            if( total<=0 || total!=(estudiantes+docentes+administrativos+directivos) )
            {
                RESPONSE.put("Mensaje","No hay personas registradas en las bases de datos, o los datos cargados son incorrectos!");
                return new ResponseEntity(RESPONSE, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            final String estudiantesPor = DECIMAL_FORMAT.format((double) 100*estudiantes/total);
            final String docentesPor = DECIMAL_FORMAT.format((double)100*docentes/total);
            final String administrativosPor = DECIMAL_FORMAT.format((double)100*administrativos/total);
            final String directivosPor = DECIMAL_FORMAT.format((double)100*directivos/total);
            final String posiblesPor = DECIMAL_FORMAT.format((double)100*posibles/total);
            RESPONSE.put("Total 100%",total);
            RESPONSE.put("Estudiantes "+estudiantesPor+"%",estudiantes);
            RESPONSE.put("Docentes "+docentesPor+"%",docentes);
            RESPONSE.put("Administrativos "+administrativosPor+"%",administrativos);
            RESPONSE.put("Directivos "+directivosPor+"%",directivos);
            RESPONSE.put("Posibles "+posiblesPor+"%",posibles);
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
            final int total = service.findAllDataOrderByEstadoAndPrograma().size();
            final int desconocidos = service.findEstadosPersonas(1).size();
            final int contagiados = service.findEstadosPersonas(2).size();
            final int saludabes = service.findEstadosPersonas(3).size();
            final int preContagiados = service.findEstadosPersonas(4).size();
            final int preVacunados = service.findEstadosPersonas(5).size();
            final int vacunados = service.findEstadosPersonas(6).size();
            if( total<=0 || total!=(desconocidos+contagiados+saludabes+preContagiados+preVacunados+vacunados) )
            {
                RESPONSE.put("Mensaje","No hay personas registradas en las bases de datos, o los datos cargados son incorrectos!");
                RESPONSE.put("Mensaje2","Total personas: "+total+", sumatoria: "+(desconocidos+contagiados+saludabes+preContagiados+preVacunados+vacunados));
                return new ResponseEntity(RESPONSE, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            final String desconocidosPor = DECIMAL_FORMAT.format((double) 100*desconocidos/total);
            final String contagiosPor = DECIMAL_FORMAT.format((double) 100*contagiados/total);
            final String saludablesPor = DECIMAL_FORMAT.format((double) 100*saludabes/total);
            final String preContagiadosPor = DECIMAL_FORMAT.format((double) 100*preContagiados/total);
            final String preVacunadosPor = DECIMAL_FORMAT.format((double) 100*preVacunados/total);
            final String vacunadosPor = DECIMAL_FORMAT.format((double) 100*vacunados/total);
            RESPONSE.put("Total 100%",total);
            RESPONSE.put("Desconocidos "+desconocidosPor+"%",desconocidos);
            RESPONSE.put("Contagiados "+contagiosPor+"%",contagiados);
            RESPONSE.put("Saludables "+saludablesPor+"%",saludabes);
            RESPONSE.put("Anteriormente contagiados "+preContagiadosPor+"%",preContagiados);
            RESPONSE.put("Pendiente segunda dosis "+preVacunadosPor+"%",preVacunados);
            RESPONSE.put("Vacunados "+vacunadosPor+"%",vacunados);
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
            final int total = service.findPersoonasPosibleAsistencia().size();
            final int educacion = service.findByFacultadPersonasPosibles(1).size();
            final int ingenieria = service.findByFacultadPersonasPosibles(2).size();
            final int salud = service.findByFacultadPersonasPosibles(3).size();
            final int contables = service.findByFacultadPersonasPosibles(4).size();
            final int humanidades = service.findByFacultadPersonasPosibles(5).size();
            final int administrativas = service.findByFacultadPersonasPosibles(6).size();
            if (total == (educacion + ingenieria + salud + contables + humanidades + administrativas) && total > 0) {
                final String educacionPor = DECIMAL_FORMAT.format((double) 100 * educacion / total);
                final String ingenieriaPor = DECIMAL_FORMAT.format((double) 100 * ingenieria / total);
                final String saludPor = DECIMAL_FORMAT.format((double) 100 * salud / total);
                final String contablesPor = DECIMAL_FORMAT.format((double) 100 * contables / total);
                final String humanidadesPor = DECIMAL_FORMAT.format((double) 100 * humanidades / total);
                final String administrativasPor = DECIMAL_FORMAT.format((double) 100 * administrativas / total);
                RESPONSE.put("Total 100%", total);
                RESPONSE.put("Educación " + educacionPor + "%", educacion);
                RESPONSE.put("Ingeniería " + ingenieriaPor + "%", ingenieria);
                RESPONSE.put("Salud " + saludPor + "%", salud);
                RESPONSE.put("Contables, Economicas y financieras " + contablesPor + "%", contables);
                RESPONSE.put("Humanidades y Sociales " + humanidadesPor + "%", humanidades);
                RESPONSE.put("Administración " + administrativasPor + "%", administrativas);
                return new ResponseEntity(RESPONSE, HttpStatus.OK);
            } else {
                RESPONSE.put("Mensaje", "No hay personas registradas en las bases de datos, o los datos cargados son incorrectos!");
                RESPONSE.put("Mensaje2", "Total personas: " + total + ", sumatoria: " + (educacion + ingenieria + salud + contables + humanidades + administrativas));
                return new ResponseEntity(RESPONSE, HttpStatus.INTERNAL_SERVER_ERROR);
            }
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
            RESPONSE.put("Listado",listado);
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
