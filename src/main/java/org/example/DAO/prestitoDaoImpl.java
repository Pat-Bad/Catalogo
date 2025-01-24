package org.example.DAO;
import jakarta.persistence.EntityManager;
import org.example.CLASSI.Prestito;
import static org.example.MyEntityManager.getEntityManager;

public class prestitoDaoImpl implements prestitoDao{
    EntityManager em = (EntityManager) getEntityManager();

    @Override
    public void save(Prestito prestito) {
        try {
            em.getTransaction().begin();
            if (prestito.getId() == null) em.persist(prestito);
            else em.merge(prestito);
            em.getTransaction().commit();
        }
        catch(Exception e){ if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
            e.printStackTrace();}
        finally{em.close();}

    }

    @Override
    public Prestito findById(Long id) {
        try {
            em.getTransaction().begin();
            Prestito prestitoCercato = em.find(Prestito.class, id);
            em.getTransaction().commit();
            return prestitoCercato;
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
            Prestito prestitoDaEliminare = em.find(Prestito.class, id);
            if (prestitoDaEliminare != null) {
                em.remove(prestitoDaEliminare);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {em.close();}}

    }

