package com.keko.peliculas.controllers;

import com.keko.peliculas.dao.IGeneroRepository;
import com.keko.peliculas.entities.Genero;
import com.keko.peliculas.services.IGeneroService;
import org.springframework.web.bind.annotation.*;

@RestController
public class GeneroController {

    private IGeneroService service;

    public GeneroController(IGeneroService service) {
        this.service = service;
    }

    @PostMapping("genero")
    public Long guardar(@RequestParam String nombre) {
        Genero genero = new Genero();
        genero.setNombre(nombre);

        service.save(genero);

        return genero.getId();
    }

    @GetMapping("genero/{id}")
    public String buscarPorId(@PathVariable(name = "id") Long id) {
        return service.findById(id).getNombre();
    }
}
