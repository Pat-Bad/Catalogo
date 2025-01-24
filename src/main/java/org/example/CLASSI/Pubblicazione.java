package org.example.CLASSI;

import java.util.Date;

public abstract class Pubblicazione {
    private Long id;
    private int ISBN;
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;

    public Pubblicazione(){};
    public Pubblicazione(Long id, int ISBN, String t, int ap, int p){
        this.id = id;
        this.ISBN = ISBN;
        this.titolo = t;
        this.annoPubblicazione = ap;
        this.numeroPagine = p;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public int getISBN() {return ISBN;}
    public void setISBN(int ISBN) {this.ISBN = ISBN;}

    public String getTitolo() {return titolo;}
    public void setTitolo(String titolo) {this.titolo = titolo;}

    public int getAnnoPubblicazione() {return annoPubblicazione;}
    public void setAnnoPubblicazione(int annoPubblicazione) {this.annoPubblicazione = annoPubblicazione;}

    public int getNumeroPagine() {return numeroPagine;}
    public void setNumeroPagine(int numeroPagine) {this.numeroPagine = numeroPagine;}

@Override
   public String toString(){
        return "Dati pubblicazione: " +"\n" + titolo + ", pubblicata nel "
                + annoPubblicazione + ", numero pagine" + numeroPagine;}

}
