package com.biblioteca.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Livro {

    private Integer id;
    private String issn;
    private String titulo;
    private String sinope;
    private Integer ano;
    private Integer NrPaginas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getSinope() {
        return sinope;
    }

    public void setSinope(String sinope) {
        this.sinope = sinope;
    }

    public Integer getNrPaginas() {
        return NrPaginas;
    }

    public void setNrPaginas(Integer nrPaginas) {
        NrPaginas = nrPaginas;
    }
}
