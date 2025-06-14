package com.keko.peliculas.controllers;

import com.keko.peliculas.entities.Actor;
import com.keko.peliculas.entities.Pelicula;
import com.keko.peliculas.services.IActorService;
import com.keko.peliculas.services.IGeneroService;
import com.keko.peliculas.services.IPeliculaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PeliculaController {
    private IPeliculaService service;
    private IGeneroService generoService;
    private IActorService actorService;

    public PeliculaController(IPeliculaService service,
                              IGeneroService generoService,
                              IActorService actorService) {
        this.service = service;
        this.generoService = generoService;
        this.actorService = actorService;
    }

    @GetMapping(value = "/pelicula")
    public String crear(Model model) {
        Pelicula pelicula = new Pelicula();
        model.addAttribute("pelicula", pelicula);
        model.addAttribute("generos", generoService.findAll());
        model.addAttribute("actores", actorService.findAll());
        model.addAttribute("titulo", "Nueva Pelicula");

        return "pelicula";
    }

    @GetMapping(value = "/pelicula/{id}")
    public String editar(@PathVariable(name = "id") Long id, Model model) {
        Pelicula pelicula = new Pelicula();
        model.addAttribute("pelicula", pelicula);
        model.addAttribute("generos", generoService.findAll());
        model.addAttribute("actores", actorService.findAll());
        model.addAttribute("titulo", "Editar Pelicula");

        return "pelicula";
    }

    @PostMapping("/pelicula")
    public String guardar(@Valid Pelicula pelicula, BindingResult br, @ModelAttribute(name = "ids") String ids, Model model) {

        if(br.hasErrors()) {
            model.addAttribute("generos", generoService.findAll());
            model.addAttribute("actores", actorService.findAll());
            return "pelicula"; // Retorna al formulario, porque hubo un error
        }

        List<Long> idsProtagonistas = Arrays.stream(ids.split(",")).map(Long::parseLong).collect(Collectors.toList());
        List<Actor> protagonistas = actorService.findAllById(idsProtagonistas);
        pelicula.setProtagonistas(protagonistas);

        service.save(pelicula);
        return "redirect:home";
    }

    @GetMapping({"/", "/home", "/index"})
    public String home(Model model) {
        model.addAttribute("peliculas", service.findAll());
        model.addAttribute("msj", "Catalogo actualizado a 2023");
        model.addAttribute("tipoMsj", "success");
        return "home";
    }
}
