package dev.uniamerica.carrosapi.service;


import dev.uniamerica.carrosapi.model.Biblioteca;
import dev.uniamerica.carrosapi.repository.BibliotecaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotecaService {

    public BibliotecaService(BibliotecaRepository bibliotecaRepository){
        this.bibliotecaRepository = bibliotecaRepository;
    }

    private final BibliotecaRepository bibliotecaRepository;

    public List<Biblioteca> findAll(){
        return  bibliotecaRepository.getBibliotecas();
    }

    public Biblioteca findById(Integer id){
        return bibliotecaRepository.getBibliotecas(id);
    }

    public Biblioteca save(Biblioteca biblioteca){
        return bibliotecaRepository.save(biblioteca);
    }

    public void delete(Integer id){
        bibliotecaRepository.delete(id);
    }

    public Biblioteca update(Integer id, Biblioteca bibliotecaUpdate){
        return bibliotecaRepository.update(id, bibliotecaUpdate);
    }
}
