package Model.Utente;

import java.time.LocalDate;

public class UtenteBean {
    private int idUtente;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate ddn;
    private String password;
    private boolean tipo;

    public UtenteBean(){ }

    public UtenteBean(int idUtente, String nome, String cognome, String email, LocalDate ddn, String password, boolean tipo) {
        this.idUtente = idUtente;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.ddn = ddn;
        this.password = password;
        this.tipo = tipo;
    }

    public UtenteBean(String nome, String cognome, String email, LocalDate ddn, String password, boolean tipo) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.ddn = ddn;
        this.password = password;
        this.tipo = tipo;
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
}
