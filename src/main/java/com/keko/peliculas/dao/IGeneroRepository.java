package com.keko.peliculas.dao;

import com.keko.peliculas.entities.Genero;
import org.springframework.data.repository.CrudRepository;

public interface IGeneroRepository extends CrudRepository<Genero, Long> {
}
