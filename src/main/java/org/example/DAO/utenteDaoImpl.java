package org.example.DAO;

import jakarta.persistence.EntityManager;
import org.example.CLASSI.Utente;

import static org.example.MyEntityManager.getEntityManager;

public class utenteDaoImpl implements utenteDao{
    EntityManager em = (EntityManager) getEntityManager();

    @Override
    public void save(Utente utente) {
        try {
            em.getTransaction().begin();
            if (utente.getId() == null) em.persist(utente);
            else em.merge(utente);
            em.getTransaction().commit();
        }
        catch(Exception e){ if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
            e.printStackTrace();}
        finally{em.close();}
    }

    @Override
    public Utente findById(Long id) {
        try {
            em.getTransaction().begin();
            Utente utenteCercato = em.find(Utente.class, id);
            em.getTransaction().commit();
            return utenteCercato;
        }
        catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();

            e.printStackTrace();
            return null;
        }
        finally {
            em.close();}
    }

    @Override
    public void deleteById(Long id) {
        try {em.getTransaction().begin();
            Utente utenteDaEliminare = em.find(Utente.class, id);
            if (utenteDaEliminare != null) {
                em.remove(utenteDaEliminare);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {em.close();}}

    }

