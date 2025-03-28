package it.epicode.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Rivista extends CatalogoBibliotecario{
    @Enumerated(EnumType.STRING)
    private PERIODICITA periodicita;

    @ManyToMany
    @JoinTable(
            name = "rivista_catalogo",
            joinColumns = @JoinColumn(name = "rivista_id"),
            inverseJoinColumns = @JoinColumn(name = "catalogo_id")
    )
    private List<Rivista> riviste = new ArrayList<>();


    public Rivista(){}
    public Rivista(java.lang.String titolo, long annoDiPubblicazione, int numeroDiPagine, PERIODICITA periodicita) {
        super(titolo, annoDiPubblicazione, numeroDiPagine);
        this.periodicita = periodicita;
    }

    public PERIODICITA getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(PERIODICITA periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public java.lang.String toString() {
        return "Rivista{" +
                "periodicita=" + periodicita +
                '}';
    }
}
