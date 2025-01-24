package org.example.DAO;
import org.example.CLASSI.Prestito;

public interface prestitoDao {
    void save (Prestito utente);
    Prestito findById(Long id);
    void deleteById(Long id);
}
