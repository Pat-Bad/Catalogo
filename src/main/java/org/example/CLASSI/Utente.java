package org.example.CLASSI;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    //questa è la sua primary key
    private Long id;
    private String nome;
    private String cognome;
    @Column (name="data_di_nascita")
    private LocalDate dataDiNascita;
    @Column(name="numero_tessera")
    private int numeroTessera;



    @OneToMany (mappedBy = "utente")  //un utente può effettuare molti prestiti
    public List<Prestito> prestiti = new ArrayList<>();
    public void setPrestiti(List<Prestito> prestiti) {
        this.prestiti = prestiti;}
    public List<Prestito> getPrestiti() {
        return prestiti;
    }

    public Utente(){};
    public Utente(Long id, String n, String c, LocalDate d, int tessera){
        this.id = id;
        this.nome = n;
        this.cognome = c;
        this.dataDiNascita = d;
        this.numeroTessera = tessera;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getCognome() {return cognome;}
    public void setCognome(String cognome) {this.cognome = cognome;}

    public LocalDate getDataDiNascita() {return dataDiNascita;}
    public void setDataDiNascita(LocalDate dataDiNascita) {this.dataDiNascita = dataDiNascita;}

    public int getNumeroTessera() {return numeroTessera;}
    public void setNumeroTessera(int numeroTessera) {this.numeroTessera = numeroTessera;}

    @Override
    public String toString(){return "Dettagli utente: " + "\nNome: " + nome +  "\nCognome: "
                            + cognome + "\nNumero Tessera: " + numeroTessera;
    }


}
