package dev.uniamerica.carrosapi.repository;


import dev.uniamerica.carrosapi.model.Livro;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class LivroRepository {

    private final List<Livro> livros = new ArrayList<>();

    private final AtomicInteger atomicInteger = new AtomicInteger(10);

    public List<Livro> getLivros(){
        return Collections.unmodifiableList(livros);
    }

    public Livro getLivros(Integer id){
        for (Livro livro : livros){
            if (livro.getId().equals(id)){
                return livro;
            }
        }
        return null;
    }

    @PostConstruct
    public void init(){
        Livro livro = new Livro();
        livro.setId(1);
        livro.setIssn("13");
        livro.setTitulo("Era uma vez");
        livro.setSinope("Infantil");
        livro.setAno(2025);
        livro.setNrPaginas(250);
    }

    public Livro save(Livro livro) {
        // incrementa +1 no id e obtem o valor
        atomicInteger.incrementAndGet();
        livro.setId(atomicInteger.get());
        livros.add(livro);
        return livro;
    }

    public void delete(Integer id) {
        for (Livro livro : livros) {
            if (livro.getId().equals(id)) {
                livros.remove(livro);
                return; // sair do loop
            }
        }
    }

    public Livro update(Integer id, Livro livroUpdate) {
        for (Livro livro : livros) {
            if (livro.getId().equals(id)) {
                // nome e marca podem correr risco de ser null
                // interessante validar antes de fazer o SET
                livro.setIssn(livro.getIssn());
                livro.setTitulo(livro.getTitulo());
                livro.setSinope(livro.getSinope());
                livro.setAno(livro.getAno());
                livro.setNrPaginas(livro.getNrPaginas());
                return livro;
            }
        }
        return null;
    }
}
