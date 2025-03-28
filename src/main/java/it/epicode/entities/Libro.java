package it.epicode.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Libro extends CatalogoBibliotecario{
    private String autore;
    @Enumerated(EnumType.STRING)
    private GENERE genere;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "catalogo_libro",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "catalogo_id")
    )
    private List<CatalogoBibliotecario> catalogo = new ArrayList<>();

    public Libro(){}
    public Libro(java.lang.String titolo, long annoDiPubblicazione,
                 int numeroDiPagine, java.lang.String autore,
                 GENERE genere) {
        super(titolo, annoDiPubblicazione, numeroDiPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public java.lang.String getAutore() {
        return autore;
    }

    public GENERE getGenere() {
        return genere;
    }

    public void setAutore(java.lang.String autore) {
        this.autore = autore;
    }

    public void setGenere(GENERE genere) {
        this.genere = genere;
    }

    @Override
    public java.lang.String toString() {
        return "Libro{" +
                "autore='" + autore + '\'' +
                ", genere=" + genere +
                '}';
    }
}