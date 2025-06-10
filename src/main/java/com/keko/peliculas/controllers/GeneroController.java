package com.keko.peliculas.controllers;

import com.keko.peliculas.dao.IGeneroRepository;
import com.keko.peliculas.entities.Genero;
import org.springframework.web.bind.annotation.*;

@RestController
public class GeneroController {

    private IGeneroRepository generoRepository;

    public GeneroController(IGeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    @PostMapping("genero")
    public Long guardar(@RequestParam String nombre) {
        Genero genero = new Genero();
        genero.setNombre(nombre);

        generoRepository.save(genero);

        return genero.getId();
    }

    @GetMapping("genero/{id}")
    public String buscarPorId(@PathVariable(name = "id") Long id) {
        // return generoRepository.findById(id).getNombre();
        return null;
    }
}
