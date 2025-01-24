package org.example.CLASSI;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy="prestito") //un prestito per tanti libri
    private List<Libro> elementoPrestato;
    @OneToMany(mappedBy="prestito")
    private List<Rivista> elementoPrestato2; //un prestito per tante riviste
    @Temporal(TemporalType.DATE)
    private Date dataInizioPrestito;
    @Temporal(TemporalType.DATE)
    private Date dataRestituzionePrevista;
    @Temporal(TemporalType.DATE)
    private Date dataRestituzioneEffettiva;

    //il prestito fa capo a diversi utenti.
    @ManyToOne
    @JoinColumn (name = "utente_id")
    public Utente utente;
    public Utente getUtente(){return utente;}
    public void setUtente(Utente utente){this.utente = utente;}

        //costruttori
    public Prestito(){};
    public Prestito(Long id, Date di, Date dp, Date dr){
        this.id = id;
        this.dataInizioPrestito = di;
        this.dataRestituzionePrevista = dp;
        this.dataRestituzioneEffettiva = dr;
    }

    //METODI

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public List<Libro> getElementoPrestato() {return elementoPrestato;}
    public void setElementoPrestato(List<Libro>elementoPrestato) {this.elementoPrestato = elementoPrestato;}
    public List<Rivista> getElementoPrestato2(){return elementoPrestato2;}
    public void setElementoPrestato2(List<Rivista>elementoPrestato2){this.elementoPrestato2=elementoPrestato2;}

    public Date getDataInizioPrestito() {return dataInizioPrestito;}
    public void setDataInizioPrestito(Date dataInizioPrestito) {this.dataInizioPrestito = dataInizioPrestito;}

    public Date getDataRestituzionePrevista() {return dataRestituzionePrevista;}
    public void setDataRestituzionePrevista(Date dataRestituzionePrevista)
                                            {this.dataRestituzionePrevista = dataRestituzionePrevista;}

    public Date getDataRestituzioneEffettiva() {return dataRestituzioneEffettiva;}
    public void setDataRestituzioneEffettiva(Date dataRestituzioneEffettiva)
                                             {this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;}

    @Override
    public String toString(){
        return "Dati del prestito: " + "\nPubblicazione prestata: " + elementoPrestato + "\nData inizio prestito: "
                + dataInizioPrestito + "\nData di restituzione prevista: " + dataRestituzionePrevista +
                "\nData restituzione effettiva: " + dataRestituzioneEffettiva;
    }
}
