package org.example;
import jakarta.persistence.EntityManager;
import org.example.CLASSI.Libro;
import org.example.CLASSI.Prestito;
import org.example.CLASSI.Utente;
import org.example.DAO.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        patricia.setNumeroTessera(00045);
        utenteDao.save(patricia);

       Libro libro1 = new Libro();
        libro1.setAutore("Anna Del Bo Boffino");
        libro1.setGenere("Saggistica");
        libro1.setTitolo("Figli di mamma");
        libro1.setAnnoPubblicazione(1985);
        libro1.setNumeroPagine(187);
        libro1.setISBN(123456789);
        libroDao.save(libro1);

        Prestito prestito1 = new Prestito();
        prestito1.setDataInizioPrestito(new Date());
        prestito1.setDataRestituzionePrevista(new Date());
        prestito1.setDataRestituzioneEffettiva(new Date());

        libro1.setPrestito(prestito1);
        prestitoDao.save(prestito1);


      Libro libro2 = new Libro();  //ho provato a togliere il vincolo not nulla per capire se mi salvava sul db
        libro2.setISBN(454546);
        libro2.setTitolo("Whatever");
        libro2.setAutore("Me");
        libro2.setGenere("saggistica");
        libro2.setNumeroPagine(45);
        libro2.setAnnoPubblicazione(2025);




    }
}