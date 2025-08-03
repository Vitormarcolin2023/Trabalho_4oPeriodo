package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.Autor;
import com.biblioteca.biblioteca.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    public AutorService(AutorRepository autorRepository){
        this.autorRepository = autorRepository;
    }

    private final AutorRepository autorRepository;

    public List<Autor> findAll(){
        return  autorRepository.getAutores();
    }

    public Autor findById(Integer id){
        return autorRepository.getAutores(id);
    }

    public Autor save(Autor autor){
        return autorRepository.save(autor);
    }

    public void delete(Integer id){
        autorRepository.delete(id);
    }

    public Autor update(Integer id, Autor autorUpdate){
        return autorRepository.update(id, autorUpdate);
    }
}
