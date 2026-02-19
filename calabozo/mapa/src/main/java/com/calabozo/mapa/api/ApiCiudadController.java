package com.calabozo.mapa.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calabozo.mapa.model.Calabozo;
import com.calabozo.mapa.model.Ciudad;
import com.calabozo.mapa.repository.CiudadRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controlador REST para gestionar las operaciones CRUD de Ciudades a través de
 * una API.
 * 
 * @RestController - Combina @Controller y @ResponseBody, indicando que cada
 *                 método devuelve datos para el cuerpo de la respuesta
 * @RequestMapping - Define la ruta base "/api/ciudades" para todos los
 *                 endpoints de este controlador
 * 
 *                 Este controlador proporciona una API RESTful para:
 *                 - Consultar ciudades (GET)
 *                 - Crear nuevas ciudades (POST)
 *                 - Actualizar ciudades existentes (PUT)
 *                 - Eliminar ciudades (DELETE)
 * 
 *                 Enlace uso api con postman
 *                 https://.postman.co/workspace/My-Workspace~f9433d83-02a1-4516-8cb3-894eddd635ea/request/42012055-e386de48-c9ee-4c59-9d97-484accfdd84d?action=share&creator=42012055&ctx=documentation
 */
@RestController
@RequestMapping("/api/ciudades")
public class ApiCiudadController {

    /**
     * Inyección del repositorio de ciudades.
     * 
     * @Autowired - Inyecta automáticamente una instancia del repositorio
     */
    @Autowired
    private CiudadRepository ciudadRepository;

    /**
     * Endpoint que devuelve todas las ciudades ordenadas por país y número de
     * habitantes.
     * 
     * @GetMapping - Mapea las peticiones HTTP GET a este método
     * @return List<Ciudad> - Lista de ciudades ordenada, que Spring convertirá
     *         automáticamente a JSON
     * 
     *         Ejemplo de uso: GET http://localhost:8080/api/ciudades
     * 
     *         Conceptos clave:
     *         - Sort: Permite especificar el orden de los resultados
     *         - findAll(): Método de JpaRepository que recupera todas las entidades
     */
    @GetMapping
    public List<Ciudad> getAllCiudades() {
        // Creamos un objeto Sort para ordenar por país y número de habitantes
        Sort sortPaisNumHab = Sort.by(
                Sort.Order.asc("pais"), // Primer criterio: país (ascendente)
                Sort.Order.asc("numHabitantes")); // Segundo criterio: habitantes (ascendente)

        // Retornamos la lista ordenada que automáticamente se convertirá a JSON
        return ciudadRepository.findAll(sortPaisNumHab);
    }

    @GetMapping("/paginado")
    public Page<Ciudad> resultadosPaginados(
            @RequestParam(name = "pag", defaultValue = "0") int pag, // por defecto 0
            @RequestParam(name = "tam", defaultValue = "10") int tam // por defecto 10
    ) {

        // En esta variación paginamos y a la vez ordenamos
        Sort sortPaisdesc = Sort.by("pais").descending();

        Pageable page = PageRequest.of(pag, tam, sortPaisdesc);

        Page<Ciudad> ciudades = ciudadRepository.findAll(page);

        return ciudades;

    }

    @PostMapping("/crear")
    public Ciudad createCity(@RequestBody Ciudad ciudad) {
        // TODO: process POST request
        return ciudadRepository.save(ciudad);
    }

    // http://localhost:8080/api/ciudades/103 (por ejemplo y por put)
    @PutMapping("/{id}")
    public ResponseEntity<Ciudad> updateCity(@PathVariable Long id, @RequestBody Ciudad ciudadRecibida) {

        Optional<Ciudad> ciudadBD = ciudadRepository.findById(id);

        // En caso de que no este en BD no se puede actualizar devolvemos no encontrado
        if (!ciudadBD.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        // Como la ciudad existe, la guardamos en una entidad para trabajar con ella
        Ciudad ciudad = ciudadBD.get();

        // Cargamos la ciudad de BD con la recibida
        ciudad.setExtension(ciudadRecibida.getExtension());
        ciudad.setFechaFundacion(ciudadRecibida.getFechaFundacion());
        ciudad.setNombre(ciudadRecibida.getNombre());
        ciudad.setNumHabitantes(ciudadRecibida.getNumHabitantes());
        ciudad.setPais(ciudadRecibida.getPais());

        // Guardamos en BD
        ciudadRepository.save(ciudad);

        return ResponseEntity.ok().body(ciudad);

    }

    /*
     * Creamos en endpoing para sacar una unica entidad
     * A la hora de recibir parametros se pueden coger como parametros url
     * o parametros get, es decir que vayan directamente en la url /api/ciudades/3 o
     * que sea con el formato
     * /api/ciudades?sexo=M&ciudad=madrid
     */
    @GetMapping("/{id}")
    public ResponseEntity<Ciudad> getCiudadById(@PathVariable Long id) {

        /*
         * La función devuelve un ResponseEntity a la solicitud de la api, es una
         * respuesta completa
         * con multiples configuraciones
         * primero sacamos la ciudad asociada a dicho id y si existe mapeamos la salida
         * a una responseEntity
         * que tiene como cuerpo los datos de la entidad ciudad del id
         * Si no existe nos devuelve notfound, es obligatorio poner orElse ya que map
         * devuelve
         * un optional, es decir es posible que no exista una ciudad con dicho id
         */
        return ciudadRepository.findById(id).map(ciudad -> ResponseEntity.ok().body(ciudad))
                .orElse(ResponseEntity.noContent().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCity(@PathVariable Long id) {

        if (!ciudadRepository.existsById(id))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        // Borramos la ciudad
        ciudadRepository.deleteById(id);

        // Devolvemos que se ha borrado
        return ResponseEntity.ok().build();

    }

    /**
     * Buscar ciudades por país o lista de países
     * GET /api/ciudades/buscar-por-pais?pais=España
     * GET /api/ciudades/buscar-por-pais?pais=España,Francia,Italia
     */
    @GetMapping("/buscar-por-pais")
    public ResponseEntity<?> buscarCiudadesPorPais(@RequestParam String pais) {
        try {
            // Si contiene comas, es una lista de países
            if (pais.contains(",")) {
                List<String> listaPaises = List.of(pais.split(","))
                        .stream()
                        .map(String::trim)
                        .collect(Collectors.toList());

                List<Ciudad> ciudades = ciudadRepository.findByPaisIn(listaPaises);

                Map<String, Object> response = new HashMap<>();
                response.put("paises_buscados", listaPaises);
                response.put("total_ciudades", ciudades.size());
                response.put("ciudades", ciudades);

                return ResponseEntity.ok(response);
            } else {
                // Búsqueda por un solo país
                List<Ciudad> ciudades = ciudadRepository.findByPais(pais.trim());

                Map<String, Object> response = new HashMap<>();
                response.put("pais", pais.trim());
                response.put("total_ciudades", ciudades.size());
                response.put("ciudades", ciudades);

                return ResponseEntity.ok(response);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al buscar ciudades: " + e.getMessage());
        }
    }

    /**
     * Buscar ciudades con patrón de país y nombre o extensión
     * mayor/igual
     * GET /api/ciudades/busqueda-avanzada?patron=Esp&nombre=Madrid&extension=500
     * Si fuese por post tambien lo recogeria con @requestparam
     * POST <form action=/api/ciudades/busqueda-avanzada method=POST>
     * <input type=text name="nombre">
     * <input type=text name="patron">
     * </fomr>
     */
    @GetMapping("/busqueda-avanzada")
    public ResponseEntity<?> busquedaAvanzada(
            @RequestParam(defaultValue = "null") String patron,
            @RequestParam(defaultValue = "null") String nombre,
            @RequestParam(defaultValue = "0") int extension) {

        try {
            List<Ciudad> ciudades = ciudadRepository
                    .findByPaisLikeAndNombreOrExtensionGreaterThanEqual(
                            "%" + patron + "%",
                            nombre,
                            extension);

            // También incluimos el conteo de ciudades con extensión mayor
            int ciudadesConMayorExtension = ciudadRepository.countByExtensionGreaterThan(extension);

            Map<String, Object> response = new HashMap<>();
            response.put("criterios_busqueda", Map.of(
                    "patron_pais", patron,
                    "nombre_ciudad", nombre,
                    "extension_minima", extension));
            response.put("total_resultados", ciudades.size());
            response.put("ciudades_con_mayor_extension", ciudadesConMayorExtension);
            response.put("ciudades", ciudades);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error en búsqueda avanzada: " + e.getMessage());
        }
    }

    /**
     * Obtener ciudades con mínimo número de calabozos
     * GET /api/ciudades/con-calabozos?minimo=3
     */
    @GetMapping("/con-calabozos")
    public ResponseEntity<?> ciudadesConCalabozos(
            @RequestParam(defaultValue = "1") int minimo) {

        try {
            if (minimo < 0) {
                return ResponseEntity.badRequest()
                        .body("El número mínimo de calabozos debe ser mayor o igual a 0");
            }

            List<Ciudad> ciudades = ciudadRepository.ciudadesConMinCalabozos(minimo);

            // Complementamos con la primera ciudad por nombre con mayor extensión si hay
            // resultados
            Ciudad ciudadMayorExtension = null;
            if (!ciudades.isEmpty()) {
                ciudadMayorExtension = ciudadRepository
                        .findFirstByNombreOrderByExtensionDesc(ciudades.get(0).getNombre());
            }

            Map<String, Object> response = new HashMap<>();
            response.put("minimo_calabozos", minimo);
            response.put("total_ciudades", ciudades.size());
            response.put("ciudades", ciudades);

            if (ciudadMayorExtension != null) {
                response.put("ciudad_mayor_extension", ciudadMayorExtension);
            }

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al buscar ciudades con calabozos: " + e.getMessage());
        }
    }

    /**
     * Obtener estadísticas de ciudades agrupadas por país
     * GET /api/ciudades/estadisticas-por-pais
     */
    @GetMapping("/estadisticas-por-pais")
    public ResponseEntity<?> obtenerEstadisticasPorPais() {
        try {
            List<Object[]> estadisticasRaw = ciudadRepository.obtenerEstadisticasPorPais();

            List<Map<String, Object>> estadisticas = estadisticasRaw.stream()
                    .map(row -> {
                        Map<String, Object> stat = new HashMap<>();
                        stat.put("pais", row[0]);
                        stat.put("total_ciudades", row[1]);
                        stat.put("promedio_habitantes", row[2]);
                        stat.put("extension_total", row[3]);
                        return stat;
                    })
                    .collect(Collectors.toList());

            Map<String, Object> response = new HashMap<>();
            response.put("total_paises", estadisticas.size());
            response.put("estadisticas", estadisticas);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al obtener estadísticas: " + e.getMessage());
        }
    }

    @GetMapping("/calabozos/{idCiudad}")
    public List<Calabozo> getCalabozosCiudad(@PathVariable Long idCiudad) {

        List<Calabozo> calabozos = new ArrayList<Calabozo>();
        Optional<Ciudad> ciudadOp = ciudadRepository.findById(idCiudad);

        if (ciudadOp.isPresent()) {
            Ciudad ciudad = ciudadOp.get();
            calabozos = ciudad.getCalabozos();
        }

        return calabozos;

    }

}
