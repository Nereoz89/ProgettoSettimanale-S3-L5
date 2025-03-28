package it.epicode.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "rent")
public class Rent {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;
    private LocalDate dataInizioPrestito = LocalDate.now();
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "articolo_prestato_libro_id")
    private Libro articoloPrestatoLibro;

    private LocalDate dataRestituzionePrevista;

    private LocalDate dataRestituzioneEffettiva;

    public Rent() {
    }

    public Rent(Utente utente, Libro articoloPrestatoLibro) {
        this.utente = utente;
        this.articoloPrestatoLibro = articoloPrestatoLibro;
        this.dataRestituzionePrevista = LocalDate.now().plus(30, ChronoUnit.DAYS);
    }


    public Long getId() {
        return id;
    }

    public Utente getUtente() {
        return utente;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public Libro getArticoloPrestatoLibro() {
        return articoloPrestatoLibro;
    }


    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestitutioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestitutioneEffettiva;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", utente=" + utente +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", articoloPrestatoLibro=" + articoloPrestatoLibro +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista +
                ", dataRestitutioneEffettiva=" + dataRestituzioneEffettiva +
                '}';
    }
}