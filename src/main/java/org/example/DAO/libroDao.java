package org.example.DAO;
import org.example.CLASSI.Libro;

public interface libroDao {
        void save (Libro libro);
        Libro findById(Long id);
        void deleteById(Long id);}
