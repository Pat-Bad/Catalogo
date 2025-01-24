package org.example.DAO;
import jakarta.persistence.EntityManager;
import org.example.CLASSI.Pubblicazione;
import static org.example.MyEntityManager.getEntityManager;

public class pubblicazioneDaoImpl implements pubblicazioneDao{
EntityManager em = (EntityManager) getEntityManager();

    @Override
    public void save(Pubblicazione pubblicazione) {
        try {
            em.getTransaction().begin();
            if (pubblicazione.getId() == null) em.persist(pubblicazione);
            else em.merge(pubblicazione);
            em.getTransaction().commit();
        }
        catch(Exception e){ if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
            e.printStackTrace();}
        finally{em.close();}
    }

    @Override
    public Pubblicazione findById(Long id) {
        try {
            em.getTransaction().begin();
            Pubblicazione pubblicazioneCercata = em.find(Pubblicazione.class, id);
            em.getTransaction().commit();
            return pubblicazioneCercata;
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
            Pubblicazione pubblicazioneDaEliminare = em.find(Pubblicazione.class, id);
            if (pubblicazioneDaEliminare != null) {
                em.remove(pubblicazioneDaEliminare);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {em.close();}
    }
}
