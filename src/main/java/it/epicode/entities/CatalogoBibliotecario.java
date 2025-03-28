package it.epicode.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class CatalogoBibliotecario {
    @Id
    @GeneratedValue
    private long isbn;
    private String titolo;
    private long annoDiPubblicazione;
    private int numeroDiPagine;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "catalogo_libro",
            joinColumns = @JoinColumn(name = "catalogo_id"),
            inverseJoinColumns = @JoinColumn(name = "libro_id")
    )
    private List<Libro> libri = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "catalogo_rivista",
            joinColumns = @JoinColumn(name = "catalogo_id"),
            inverseJoinColumns = @JoinColumn(name = "rivista_id")
    )
    private List<Rivista> riviste = new ArrayList<>();


    public CatalogoBibliotecario(){}
    public CatalogoBibliotecario(java.lang.String titolo, long annoDiPubblicazione, int numeroDiPagine) {
        this.titolo = titolo;
        this.annoDiPubblicazione = annoDiPubblicazione;
        this.numeroDiPagine = numeroDiPagine;
    }

    public long getString() {
        return isbn;
    }

    public java.lang.String getTitolo() {
        return titolo;
    }

    public long getAnnoDiPubblicazione() {
        return annoDiPubblicazione;
    }

    public int getNumeroDiPagine() {
        return numeroDiPagine;
    }

    public void setTitolo(java.lang.String titolo) {
        this.titolo = titolo;
    }

    public void setAnnoDiPubblicazione(long annoDiPubblicazione) {
        this.annoDiPubblicazione = annoDiPubblicazione;
    }

    public void setNumeroDiPagine(int numeroDiPagine) {
        this.numeroDiPagine = numeroDiPagine;
    }

    @Override
    public java.lang.String toString() {
        return "CatalogoBibliotecario{" +
                "String=" + isbn +
                ", titolo='" + titolo + '\'' +
                ", annoDiPubblicazione=" + annoDiPubblicazione +
                ", numeroDiPagine=" + numeroDiPagine +
                '}';
    }
}
