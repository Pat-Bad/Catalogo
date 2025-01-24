package org.example.DAO;
import org.example.CLASSI.Pubblicazione;

public interface pubblicazioneDao {
    void save (Pubblicazione pubblicazione);
    Pubblicazione findById(Long id);
    void deleteById(Long id);
}
