package dev.uniamerica.carrosapi.repository;


import dev.uniamerica.carrosapi.model.Autor;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AutorRepository {

    private final List<Autor> autores = new ArrayList<>();

    private final AtomicInteger atomicInteger = new AtomicInteger(10);

    public List<Autor> getAutores(){
        return Collections.unmodifiableList(autores);
    }

    public Autor getAutores(Integer id){
        for (Autor autor : autores){
            if (autor.getId().equals(id)){
                return autor;
            }
        }
        return null;
    }

    @PostConstruct
    public void init(){
        Autor autor = new Autor();
        autor.setId(1);
        autor.setNome("Vitor");
        autor.setCpf("123");
        autor.setIdade(20);
    }

    public Autor save(Autor autor) {
        // incrementa +1 no id e obtem o valor
        atomicInteger.incrementAndGet();
        autor.setId(atomicInteger.get());
        autores.add(autor);
        return autor;
    }

    public void delete(Integer id) {
        for (Autor autor : autores) {
            if (autor.getId().equals(id)) {
                autores.remove(autor);
                return; // sair do loop
            }
        }
    }

    public Autor update(Integer id, Autor autorUpdate) {
        for (Autor autor : autores) {
            if (autor.getId().equals(id)) {
                // nome e marca podem correr risco de ser null
                // interessante validar antes de fazer o SET
                autor.setNome(autorUpdate.getNome());
                autor.setCpf(autorUpdate.getCpf());
                autor.setIdade(autorUpdate.getIdade());
                return autor;
            }
        }
        return null;
    }


}
