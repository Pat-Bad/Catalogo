package org.example.DAO;
import org.example.CLASSI.Rivista;

public interface rivistaDao {
    void save (Rivista rivista);
    Rivista findById(Long id);
    void deleteById(Long id);}

