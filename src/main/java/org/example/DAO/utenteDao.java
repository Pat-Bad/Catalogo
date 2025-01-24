package org.example.DAO;
import org.example.CLASSI.Utente;

public interface utenteDao {
    void save (Utente utente);
    Utente findById(Long id);
    void deleteById(Long id);
}

