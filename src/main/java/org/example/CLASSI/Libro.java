package org.example.CLASSI;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table (name="libri")
public class Libro extends Pubblicazione{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String autore;
    private String genere;

    //più libri possono andare in un prestito
    @ManyToOne
    @JoinColumn (name = "prestito_id")
    private Prestito prestito;
    public Prestito getPrestito() {return prestito;}
    public void setPrestito(Prestito prestito) {this.prestito = prestito;}

    public Libro(){};

    public Libro(Long id, int ISBN, String t, int ap, int p, String a, String g){
        super(id,ISBN,t,ap,p);
        this.autore = a;
        this.genere = g;
    }
    public String getAutore() {return autore;}
    public void setAutore(String autore) {this.autore = autore;}

    public String getGenere() {return genere;}
    public void setGenere(String genere) {this.genere = genere;}

    @Override
    public String toString(){return "Dettagli libro: " + "\n" + "Titolo: " + getTitolo() + "\nAutore: "
                + autore + "\nGenere: " + genere + "\nNumero di pagine: " + getNumeroPagine();}

}
