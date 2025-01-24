package org.example.DAO;
import jakarta.persistence.EntityManager;
import org.example.CLASSI.Rivista;
import static org.example.MyEntityManager.getEntityManager;

public class rivistaDaoImpl implements rivistaDao{
    EntityManager em = (EntityManager) getEntityManager();

    @Override
    public void save(Rivista rivista) {
        try {
            em.getTransaction().begin();
            if (rivista.getId() == null) em.persist(rivista);
            else em.merge(rivista);
            em.getTransaction().commit();
        }
        catch(Exception e){ if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
            e.printStackTrace();}
        finally{em.close();}
    }


    @Override
    public Rivista findById(Long id) {
        try {
            em.getTransaction().begin();
            Rivista rivistaCercata = em.find(Rivista.class, id);
            em.getTransaction().commit();
            return rivistaCercata;
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
       Rivista rivistaDaEliminare = em.find(Rivista.class, id);
        if (rivistaDaEliminare != null) {
            em.remove(rivistaDaEliminare);
        }
        em.getTransaction().commit();
    } catch (Exception e) {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        e.printStackTrace();
    } finally {em.close();}}

    }

