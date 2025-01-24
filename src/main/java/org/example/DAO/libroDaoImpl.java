package org.example.DAO;
import jakarta.persistence.EntityManager;
import org.example.CLASSI.Libro;
import static org.example.MyEntityManager.getEntityManager;

public class libroDaoImpl implements libroDao {
    EntityManager em = (EntityManager) getEntityManager();

    @Override
    public void save(Libro libro) {
        try {
            em.getTransaction().begin();
            if (libro.getId() == null) em.persist(libro);
            else em.merge(libro);
            em.getTransaction().commit();
        }
        catch(Exception e){ if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
            e.printStackTrace();}
        finally{em.close();}
    }

    @Override
    public Libro findById(Long id) {
        try {
            em.getTransaction().begin();
           Libro libroCercato = em.find(Libro.class, id);
            em.getTransaction().commit();
            return libroCercato;
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
    public void deleteById(Long id) {try {em.getTransaction().begin();
        Libro libroDaEliminare = em.find(Libro.class, id);
        if (libroDaEliminare != null) {
            em.remove(libroDaEliminare);
        }
        em.getTransaction().commit();
    } catch (Exception e) {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        e.printStackTrace();
    } finally {em.close();}}

    }

