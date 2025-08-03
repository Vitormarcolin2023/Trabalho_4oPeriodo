package com.biblioteca.biblioteca.repository;

import com.biblioteca.biblioteca.model.Biblioteca;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class BibliotecaRepository {

    private final List<Biblioteca> bibliotecas = new ArrayList<>();

    private final AtomicInteger atomicInteger = new AtomicInteger(10);

    public List<Biblioteca> getBibliotecas(){
        return Collections.unmodifiableList(bibliotecas);
    }

    public Biblioteca getBibliotecas(Integer id){
        for (Biblioteca biblioteca : bibliotecas){
            if (biblioteca.getId().equals(id)){
                return biblioteca;
            }
        }
        return null;
    }

    @PostConstruct
    public void init(){
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setId(1);
        biblioteca.setNome("Municipal");
        biblioteca.setTelefone("(45) 3236-8300");
    }

    public Biblioteca save(Biblioteca biblioteca) {
        // incrementa +1 no id e obtem o valor
        atomicInteger.incrementAndGet();
        biblioteca.setId(atomicInteger.get());
        bibliotecas.add(biblioteca);
        return biblioteca;
    }

    public void delete(Integer id) {
        for (Biblioteca biblioteca : bibliotecas) {
            if (biblioteca.getId().equals(id)) {
                bibliotecas.remove(biblioteca);
                return; // sair do loop
            }
        }
    }

    public Biblioteca update(Integer id, Biblioteca bibliotecaUpdate) {
        for (Biblioteca biblioteca : bibliotecas) {
            if (biblioteca.getId().equals(id)) {
                // nome e marca podem correr risco de ser null
                // interessante validar antes de fazer o SET
                biblioteca.setNome(biblioteca.getNome());
                biblioteca.setTelefone(bibliotecaUpdate.getTelefone());
                return biblioteca;
            }
        }
        return null;
    }
}