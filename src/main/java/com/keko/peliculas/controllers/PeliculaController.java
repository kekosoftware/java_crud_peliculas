package com.keko.peliculas.controllers;

import com.keko.peliculas.entities.Pelicula;
import com.keko.peliculas.services.IGeneroService;
import com.keko.peliculas.services.IPeliculaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PeliculaController {
    private IPeliculaService service;
    private IGeneroService generoService;

    public PeliculaController(IPeliculaService service, IGeneroService generoService) {
        this.service = service;
        this.generoService = generoService;
    }

    @GetMapping(value = "/pelicula")
    public String crear(Model model) {
        Pelicula pelicula = new Pelicula();
        model.addAttribute("pelicula", pelicula);
        model.addAttribute("generos", generoService.findAll());
        model.addAttribute("titulo", "Nueva Pelicula");

        return "pelicula";
    }

    @GetMapping(value = "/pelicula/{id}")
    public String editar(@PathVariable(name = "id") Long id, Model model) {
        Pelicula pelicula = new Pelicula();
        model.addAttribute("pelicula", pelicula);
        model.addAttribute("generos", generoService.findAll());
        model.addAttribute("titulo", "Editar Pelicula");

        return "pelicula";
    }

    @PostMapping("/pelicula")
    public String guardar(Pelicula pelicula) {
        service.save(pelicula);
        return "redirect:home";
    }

    @GetMapping({"/", "/home", "/index"})
    public String home() {
        return "home";
    }
}
