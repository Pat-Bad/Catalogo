package org.example;
import jakarta.persistence.EntityManager;
import org.example.CLASSI.Libro;
import org.example.CLASSI.Utente;
import org.example.DAO.*;

import java.time.LocalDate;

import static org.example.MyEntityManager.getEntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager em = getEntityManager();
        utenteDao utenteDao = new utenteDaoImpl(); //così importo i metodi da usare
        prestitoDao prestitoDao = new prestitoDaoImpl();
        libroDao libroDao = new libroDaoImpl();
        rivistaDao rivistaDao = new rivistaDaoImpl();

        Utente patricia = new Utente();
        patricia.setNome("Patricia");
        patricia.setCognome("Badji");
        patricia.setDataDiNascita(LocalDate.of(1989,06,29));
        patricia.setNumeroTessera(0000001);
        utenteDao.save(patricia);

        Libro libro1 = new Libro();
        libro1.setAutore("Anna Del Bo Boffino");
        libro1.setGenere("Saggistica");
        libro1.setTitolo("Figli di mamma");
        libro1.setAnnoPubblicazione(1985);
        libro1.setNumeroPagine(187);
        libro1.setISBN(123456789);
        libroDao.save(libro1);




    }
}