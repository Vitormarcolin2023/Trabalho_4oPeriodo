package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.Editora;
import com.biblioteca.biblioteca.repository.EditoraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditoraService {

    public EditoraService(EditoraRepository editoraRepository){

        this.editoraRepository = editoraRepository;
    }

    private final EditoraRepository editoraRepository;

    public List<Editora> findAll(){
        return  editoraRepository.getEditoras();
    }

    public Editora findById(Integer id){
        return editoraRepository.getEditoras(id);
    }

    public Editora save(Editora editora){
        return editoraRepository.save(editora);
    }

    public void delete(Integer id){
        editoraRepository.delete(id);
    }

    public Editora update(Integer id, Editora editoraUpdate){
        return editoraRepository.update(id, editoraUpdate);
    }
}
