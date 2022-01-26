package Storage.Corso;

import Application.util.Subject;
import Storage.MaterialeDidattico.MaterialeDidatticoBean;
import Storage.Utente.UtenteBean;

import java.util.ArrayList;

/**
 * Questa classe rappresenta un Corso.
 * Un corso possiede un nome, una descrizione,
 * il nome del professore che conduce il corso
 * e la lista del materiale relativo al corso.
 * Questa classe estende Subject per la realizzazione
 * del Design Pattern Observer
 */
public class CorsoBean extends Subject {

    /**
     * Rappresenta l'id del corso.
     */
    private int id;

    /**
     * Rappresenta il nome del corso.
     */
    private String nome;

    /**
     *  Rappresenta la descrizione del corso
     */
    private String descrizione;

    /**
     *  Rappresenta il nome del professore che conduce
     *  il corso.
     */
    private String nomeProfessore;

    /**
     *  Rappresenta la lista di materiale relativo al corso.
     */
    private ArrayList<MaterialeDidatticoBean> listaMateriale;


    /**
     * Costruttore vuoto.
     */
    public CorsoBean(){}


    /**
     * Costruttore del CorsoBean.
     * @param nome è il nome del corso.
     * @param descrizione è la descrizione del corso.
     * @param nomeProfessore è il nome del professore che conduce il corso.
     */
    public CorsoBean(String nome,String descrizione,String nomeProfessore){
        this.nome = nome;
        this.descrizione = descrizione;
        this.nomeProfessore = nomeProfessore;
    }

    /**
     * Costruttore del CorsoBean.
     * @param nome è il nome del corso.
     * @param descrizione è la descrizione del corso.
     * @param nomeProfessore è il nome del professore che conduce il corso.
     * @param listaMateriale è il materiale relativo al corso.
     */
    public CorsoBean(String nome,String descrizione,String nomeProfessore, ArrayList<MaterialeDidatticoBean> listaMateriale){
        this.nome = nome;
        this.descrizione = descrizione;
        this.nomeProfessore = nomeProfessore;
        this.listaMateriale = listaMateriale;
    }


    /**
     * Costruttore del CorsoBean.
     * @param id è l'id del corso.
     * @param nome è il nome del corso.
     * @param descrizione è la descrizione del corso.
     * @param nomeProfessore è il nome del professore che conduce il corso.
     * @param listaMateriale è il materiale relativo al corso.
     */
    public CorsoBean(int id,String nome,String descrizione,String nomeProfessore, ArrayList<MaterialeDidatticoBean> listaMateriale){
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.nomeProfessore = nomeProfessore;
        this.listaMateriale = listaMateriale;
    }


    /**
     * Costruttore del CorsoBean.
     * @param id è l'id del corso.
     * @param nome è il nome del corso.
     * @param descrizione è la descrizione del corso.
     * @param nomeProfessore è il nome del professore che conduce il corso.
     */
    public CorsoBean(int id,String nome,String descrizione,String nomeProfessore){
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.nomeProfessore = nomeProfessore;
    }

    /**
     * Ritorna l'id del corso.
     * @return l'id del corso.
     */
    public int getId() {
        return id;
    }

    /**
     * Ritorna il nome del corso.
     * @return il nome del corso.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Ritorna la descrizione del corso.
     * @return la descrizione del corso.
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * Ritorna il nome del professore.
     * @return il nome del professore.
     */
    public String getNomeProfessore() {
        return nomeProfessore;
    }

    /**
     * Ritorna la lista di materiale del corso.
     * @return la lista di materiale del corso.
     */
    public ArrayList<MaterialeDidatticoBean> getListaMateriale() {
        return listaMateriale;
    }

    /**
     * Set id del corso.
     * @param id id del corso;
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Set nome del corso.
     * @param nome nome del corso.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Set descrizione del corso.
     * @param descrizione decrizione del corso.
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * Set nome del professore.
     * @param nomeProfessore nome del professore che conduce il corso.
     */
    public void setNomeProfessore(String nomeProfessore) {
        this.nomeProfessore = nomeProfessore;
    }

    /**
     * Metodo per aggiungere un nuovo materiale al corso.
     * @param m Materiale didattico da inserire al corso.
     */
    public void aggiungiMateriale(MaterialeDidatticoBean m){
        listaMateriale.add(m);
        this.notifyObservers();
    }

    /**
     * Set materiale del corso
     * @param listaMateriale lista del materiale da inserire al corso.
     */
    public void setListaMateriale(ArrayList<MaterialeDidatticoBean> listaMateriale) {
        this.listaMateriale = listaMateriale;
    }

    /**
     * Questo metodo serve per andare a settare gli osservatori del corso
     * in modo che quando viene aggiunto un nuovo materiale vengono tutti
     * notificati.
     * @param utenti utenti che hanno il corso nella lista dei corsi preferiti.
     */
    public void setObservers(ArrayList<UtenteBean> utenti){
        for(UtenteBean u : utenti){
            this.addObserver(u);
        }
    }

}
