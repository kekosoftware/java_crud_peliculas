package com.keko.peliculas.services;

import com.keko.peliculas.dao.IActorRepository;
import com.keko.peliculas.entities.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements IActorService{

    @Autowired
    private IActorRepository actorRepository;

    @Override
    public List<Actor> findAll() {
        return (List<Actor>) actorRepository.findAll();
    }

    @Override
    public List<Actor> findAllById(List<Long> ids) {
        return (List<Actor>) actorRepository.findAllById(ids);
    }
}

