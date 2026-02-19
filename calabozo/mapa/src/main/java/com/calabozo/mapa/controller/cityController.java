package com.calabozo.mapa.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.calabozo.mapa.model.Ciudad;
import com.calabozo.mapa.repository.CiudadRepository;

/**
 * Controlador MVC para gestionar las operaciones CRUD de Ciudades a través de
 * vistas HTML.
 * 
 * @Controller - Indica que esta clase es un controlador Spring MVC
 *             @RequestMapping("/ciudades") - Todas las rutas en este
 *             controlador empiezan con /ciudades
 * 
 *             A diferencia del ApiCiudadController, este controlador:
 *             - Devuelve vistas HTML en lugar de JSON
 *             - Utiliza Model para pasar datos a las vistas
 *             - Maneja formularios y redirecciones
 */
@Controller
@RequestMapping("/ciudades")
public class cityController {

    /**
     * Logger para registrar eventos y errores
     * Útil para depuración y monitoreo de la aplicación
     */
    private Logger logger = LoggerFactory.getLogger(cityController.class);

    /**
     * Repositorio de ciudades inyectado automáticamente
     */
    @Autowired
    private CiudadRepository ciudadRepository;

    /**
     * Maneja las peticiones GET a /ciudades
     * Muestra la lista de todas las ciudades
     * 
     * @param model Objeto Model de Spring para pasar datos a la vista
     * @return String Nombre de la vista a renderizar (listaCiudades.html)
     * 
     *         Conceptos clave:
     *         - Model: Contenedor para pasar datos del controlador a la vista
     *         - findAll(): Obtiene todos los registros de la tabla ciudades
     */
    @GetMapping
    public String listCities(Model model) {
        // Recuperamos todas las ciudades de la base de datos
        List<Ciudad> listaCiudades = ciudadRepository.findAll();

        // Añadimos la lista al modelo para que esté disponible en la vista
        // En la vista se accederá como ${ciudades}
        model.addAttribute("ciudades", listaCiudades);

        // Devolvemos el nombre de la plantilla Thymeleaf
        return "listaCiudades";
    }

    /**
     * Maneja las peticiones GET a /ciudades/eliminar/{id}
     * Elimina una ciudad por su ID
     * 
     * @param id        ID de la ciudad a eliminar
     * @param redAttrib Objeto para añadir mensajes flash que sobreviven a una
     *                  redirección
     * @return String Redirección a la lista de ciudades
     * 
     *         Conceptos clave:
     *         - @PathVariable: Captura variables de la URL
     *         - RedirectAttributes: Permite pasar mensajes entre redirecciones
     */
    @GetMapping("/eliminar/{id}")
    public String removeCity(@PathVariable Long id, RedirectAttributes redAttrib) {
        // Verificamos si la ciudad existe antes de intentar eliminarla
        if (!ciudadRepository.existsById(id)) {
            // Si no existe, añadimos un mensaje de error que se mostrará en la siguiente
            // vista
            redAttrib.addFlashAttribute("error", "La ciudad no Existe");
            // Registramos el error en el log
            logger.error("No existe la ciudad");
        } else {
            ciudadRepository.deleteById(id);
            redAttrib.addFlashAttribute("success", "Se ha borrado Correctamente la ciudad con id " + id);
            logger.info("Se ha borrado Correctamente la ciudad con id " + id);
        }

        return "redirect:/ciudades";
    }

    @GetMapping("/nuevo")
    public String newCity(Model model) {

        // Creamos una ciudad para que el formulario
        // la asocie a sus datos
        Ciudad ciudad = new Ciudad();
        // La guardamos en el model para que le llegue al formulario
        model.addAttribute("ciudad", ciudad);
        // Cargamos la vista nuevaCiudad
        return "nuevaCiudad";
    }

    @PostMapping("/crear")
    public String createCity(@ModelAttribute("ciudad") Ciudad ciudad) {

        ciudadRepository.save(ciudad);

        logger.info("Se ha creado la ciudad con id " + ciudad.getId());

        return "redirect:/ciudades";
    }

    @GetMapping("/editar/{id}")
    public String editCity(@PathVariable Long id, Model model) {

        // Primero creo una ciudad en blanco
        Ciudad ciudad = new Ciudad();

        // Si no existe la ciudad con id en la bd devuelo el error
        if (!ciudadRepository.existsById(id))
            model.addAttribute("error", "La ciudad no Existe");
        // Si existe la ciudad en bd la cargamos
        else
            ciudad = ciudadRepository.findById(id).get();
        // Cargamos la ciudad en el model y cargamos la vista
        model.addAttribute("ciudad", ciudad);

        return "editarCiudad";
    }

    @PostMapping("/modificar")
    public String modifyCity(@ModelAttribute("ciudad") Ciudad ciudad, Model model) {

        try {
            // Guardamos la ciudad
            ciudadRepository.save(ciudad);

        } catch (Exception e) {
            model.addAttribute("error", "La ciudad no Existe");
            return "redirect:/ciudades";
        }

        return "redirect:/ciudades";

    }

}
