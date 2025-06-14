package com.keko.peliculas.services;

import com.keko.peliculas.entities.Actor;

import java.util.List;

public interface IActorService {
    public List<Actor> findAll();
    public List<Actor> findAllById(List<Long> ids);
}
