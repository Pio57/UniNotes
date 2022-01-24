package Storage.Utente;

import Application.util.EmailSender;
import Application.util.Observer;
import Application.util.Subject;
import Storage.Corso.CorsoBean;
import Storage.Libretto.LibrettoBean;
import Storage.ListaPreferiti.ListaPreferitiBean;
import Storage.MaterialeDidattico.MaterialeDidatticoBean;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;

public class UtenteBean implements Observer{
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
    private ArrayList<MaterialeDidatticoBean> materiale;



    public UtenteBean(){ }


    public UtenteBean(String nome, String cognome, String cf, String email, LocalDate ddn, String password, boolean tipo) {
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

    public ArrayList<MaterialeDidatticoBean> getMateriale() {
        return materiale;
    }

    public void setMateriale(ArrayList<MaterialeDidatticoBean> materiale) {
        this.materiale = materiale;
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

    public void setPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
        byte[] hashedPad = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder builder = new StringBuilder();
        for(byte bit : hashedPad){
            builder.append(String.format("%02x", bit)); //inseriemo in ogni bit del bit formattata "%02x" caratteri miniuscoli
        }
        this.password = builder.toString();
    }

    public void setPss(String password){
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
       if(this.libretto.getListaEsami()!=null){
           this.libretto.aggiorna();
       }
    }

    public void setListaPreferiti(ListaPreferitiBean listaPreferiti) {
        for(CorsoBean c : listaPreferiti.getCorsi()){
            c.addObserver(this);
        }
        this.listaPreferiti = listaPreferiti;
    }



    @Override
    public void update() {
        EmailSender emailSender = EmailSender.GetInstance();
        emailSender.SendEmail("Aggiornamento corso", "Gentile " + this.nome + ", è stata aggiunto del nuovo materiale. Saluti da UniNotes.", this.email);
    }
}
