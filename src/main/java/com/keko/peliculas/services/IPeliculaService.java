package com.keko.peliculas.services;

import com.keko.peliculas.entities.Pelicula;

import java.util.List;

public interface IPeliculaService {
    public void save(Pelicula pelicula);
    public Pelicula findById(Long id);
    public List<Pelicula> findAll();
    public void delete(Long id);
}
