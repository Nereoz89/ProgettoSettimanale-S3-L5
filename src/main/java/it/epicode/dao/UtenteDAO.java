package it.epicode.dao;

import it.epicode.entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UtenteDAO {
    private final EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }
    public void save(Utente utente){

        EntityTransaction transazione =  em.getTransaction();

        transazione.begin();

        em.persist(utente);

        transazione.commit();

        System.out.println("Utente " + utente.getNome() + " " + utente.getCognome() + " è stato registrato con successo");
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

            System.out.println("Utente " + " è stato cancellato cancellato");

        } else {
            System.out.println("L'Utente non trovato");
        }

    }
}
