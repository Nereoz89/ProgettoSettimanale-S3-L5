package it.epicode.dao;

import it.epicode.entities.Rent;
import it.epicode.entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class RentDAO {
    private final EntityManager em;

    public RentDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Rent utente){

        EntityTransaction transazione =  em.getTransaction();

        transazione.begin();

        em.persist(utente);

        transazione.commit();

    };

    public Utente getById(long id){
        Utente found = em.find(Utente.class, id);
        return found;
    };

    public void findByIdAndDelete(long id){
        Utente found = this.getById(id);

        if (found != null){
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();



        } else {
            System.out.println("Utente non trovato");
        }

    }
}

