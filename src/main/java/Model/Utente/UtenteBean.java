package Model.Utente;

import Model.Libretto.LibrettoBean;
import Model.ListaPreferiti.ListaPreferitiBean;

import java.time.LocalDate;

public class UtenteBean {
    private int idUtente;
    private String nome;
    private String cognome;
    private String cf;
    private String email;
    private LocalDate ddn;
    private String password;
    private boolean tipo;
    private LibrettoBean libretto;
    private ListaPreferitiBean listaPreferiti;

    public UtenteBean(){ }


    public UtenteBean(String nome, String cognome, String cf, String MaterialeDidatticoemail, LocalDate ddn, String password, boolean tipo) {
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.email = email;
        this.ddn = ddn;
        this.password = password;
        this.tipo = tipo;
    }

    public UtenteBean(int idUtente, String nome, String cognome, String cf, String email, LocalDate ddn, String password, boolean tipo) {
        this.idUtente = idUtente;
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.email = email;
        this.ddn = ddn;
        this.password = password;
        this.tipo = tipo;
    }

    public UtenteBean(int idUtente, String nome, String cognome, String cf, String email, LocalDate ddn, String password, boolean tipo,LibrettoBean libretto) {
        this.idUtente = idUtente;
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.email = email;
        this.ddn = ddn;
        this.password = password;
        this.tipo = tipo;
        this.libretto = libretto;
    }

    public UtenteBean(int idUtente, String nome, String cognome, String cf, String email, LocalDate ddn, String password, boolean tipo,LibrettoBean libretto,ListaPreferitiBean listaPreferiti) {
        this.idUtente = idUtente;
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.email = email;
        this.ddn = ddn;
        this.password = password;
        this.tipo = tipo;
        this.libretto = libretto;
        this.listaPreferiti = listaPreferiti;
    }


    public LibrettoBean getLibretto() {
        return libretto;
    }

    public ListaPreferitiBean getListaPreferiti() {
        return listaPreferiti;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDdn(LocalDate ddn) {
        this.ddn = ddn;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDdn() {
        return ddn;
    }

    public String getPassword() {
        return password;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setLibretto(LibrettoBean libretto) {
        this.libretto = libretto;
    }

    public void setListaPreferiti(ListaPreferitiBean listaPreferiti) {
        this.listaPreferiti = listaPreferiti;
    }
}
