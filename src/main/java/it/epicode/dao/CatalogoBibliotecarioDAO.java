package it.epicode.dao;

import it.epicode.entities.CatalogoBibliotecario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CatalogoBibliotecarioDAO {
    private final EntityManager em;

    public CatalogoBibliotecarioDAO(EntityManager em) {
        this.em = em;
    }
    public void save(CatalogoBibliotecario articolo){

        EntityTransaction transazione =  em.getTransaction();

        transazione.begin();

        em.persist(articolo);

        transazione.commit();

        System.out.println("L'articolo " + articolo.getTitolo() + " è stato inserito con successo");
    };
    public CatalogoBibliotecario cercaPerISBN(long isbn){
        CatalogoBibliotecario found = em.find(CatalogoBibliotecario.class, isbn);
        return found;
    };

    public void rimuoviElementoPerISBN(long isbn){
        CatalogoBibliotecario found = this.cercaPerISBN(isbn);

        if (found != null){
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();

            System.out.println("L'articolo " + " è stato rimosso");

        } else {
            System.out.println("L'articolo non trovato");
        }

    };
    public List<CatalogoBibliotecario> cercaPerAnnoPubblicazione(long anno) {
        TypedQuery<CatalogoBibliotecario> query = em.createQuery(
                "SELECT c FROM CatalogoBibliotecario c WHERE c.annoDiPubblicazione = :anno", CatalogoBibliotecario.class);
        query.setParameter("anno", anno);
        return query.getResultList();
    }

    public List<CatalogoBibliotecario> cercaPerAutore(String autore) {
        TypedQuery<CatalogoBibliotecario> query = em.createQuery(
                "SELECT c FROM CatalogoBibliotecario c WHERE c.autore = :autore", CatalogoBibliotecario.class);
        query.setParameter("autore", autore);
        return query.getResultList();
    }
}
