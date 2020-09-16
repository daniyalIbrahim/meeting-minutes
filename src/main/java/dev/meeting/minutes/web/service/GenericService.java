package dev.meeting.minutes.web.service;

import dev.meeting.minutes.web.repository.GenericRepository;

import java.util.Optional;

public abstract class GenericService<T> {

    public abstract GenericRepository<T> getRepository();

    public Iterable<T> findAll() {

        return getRepository().findAll();
    }

    public T save(T entity) {
        return getRepository().save(entity);
    }

    public void delete(String id){
        getRepository().deleteById(id);
    }

    public Optional<T> getoneobject(String id){
       Optional<T> opt = getRepository().findById(id);
        return opt;
    }


}


