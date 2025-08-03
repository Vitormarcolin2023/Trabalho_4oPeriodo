package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.Livro;
import com.biblioteca.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    public LivroService(LivroRepository livroRepository){

        this.livroRepository = livroRepository;
    }

    private final LivroRepository livroRepository;

    public List<Livro> findAll(){
        return  livroRepository.getLivros();
    }

    public Livro findById(Integer id){
        return livroRepository.getLivros(id);
    }

    public Livro save(Livro livro){
        return livroRepository.save(livro);
    }

    public void delete(Integer id){
        livroRepository.delete(id);
    }

    public Livro update(Integer id, Livro livroUpdate){
        return livroRepository.update(id, livroUpdate);
    }
}
