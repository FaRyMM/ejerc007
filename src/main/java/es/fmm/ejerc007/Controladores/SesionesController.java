package es.fmm.ejerc007.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import es.fmm.ejerc007.Sesion;
import es.fmm.ejerc007.Ventas;
import es.fmm.ejerc007.Servicios.SessionesService;


@RestController
@RequestMapping("/salas")
public class SesionesController {

    private final SessionesService sessionServices;

    @Autowired
    public SesionesController(SessionesService sessionServices) {
        this.sessionServices = sessionServices;
    }

    @GetMapping("/{id}")
    public Sesion getSession(@PathVariable Long id) {
        return sessionServices.getSessionId(id);
    }
    
}
