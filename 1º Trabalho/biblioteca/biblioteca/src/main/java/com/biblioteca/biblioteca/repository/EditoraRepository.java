package dev.uniamerica.carrosapi.repository;



import dev.uniamerica.carrosapi.model.Editora;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EditoraRepository {

    private final List<Editora> editoras = new ArrayList<>();

    private final AtomicInteger atomicInteger = new AtomicInteger(10);

    public List<Editora> getEditoras(){
        return Collections.unmodifiableList(editoras);
    }

    public Editora getEditoras(Integer id){
        for (Editora editora : editoras){
            if (editora.getId().equals(id)){
                return editora;
            }
        }
        return null;
    }

    @PostConstruct
    public void init(){
        Editora editora = new Editora();
        editora.setId(1);
        editora.setNome("Municipal");
        editora.setEndereco("Ruas");
        editora.setTelefone("(45) 3236-8300");
    }

    public Editora save(Editora editora) {
        // incrementa +1 no id e obtem o valor
        atomicInteger.incrementAndGet();
        editora.setId(atomicInteger.get());
        editoras.add(editora);
        return editora;
    }

    public void delete(Integer id) {
        for (Editora editora : editoras) {
            if (editora.getId().equals(id)) {
                editoras.remove(editora);
                return; // sair do loop
            }
        }
    }

    public Editora update(Integer id, Editora editoraUpdate) {
        for (Editora editora : editoras) {
            if (editora.getId().equals(id)) {
                // nome e marca podem correr risco de ser null
                // interessante validar antes de fazer o SET
                editora.setNome(editora.getNome());
                editora.setEndereco(editora.getEndereco());
                editora.setTelefone(editora.getTelefone());
                return editora;
            }
        }
        return null;
    }
}
