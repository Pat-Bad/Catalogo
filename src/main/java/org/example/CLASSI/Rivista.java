package org.example.CLASSI;
import jakarta.persistence.*;

@Entity
@Table (name="riviste")
public class Rivista extends Pubblicazione{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String periodicita;

    @ManyToOne
    @JoinColumn(name = "prestito_id")
    private Prestito prestito;
    public Prestito getPrestito() {return prestito;}
    public void setPrestito(Prestito prestito) {this.prestito = prestito;}

    public Rivista(){};
    public Rivista (Long id, int ISBN, String t, int ap, int p, String periodicita){
        super(id,ISBN,t,ap,p);
        this.periodicita = periodicita;
    }

    public String getPeriodicita() {return periodicita;}
    public void setPeriodicita(String periodicita) {this.periodicita = periodicita;}

    @Override
    public String toString(){return "Dati della rivista: " + "\nTitolo: " + getTitolo()
                            + "\nAnno di pubblicazione; " + getAnnoPubblicazione() +
                            "\nPeriodicità: " + periodicita;}
}
