package Storage.ListaPreferiti;

import Storage.Corso.CorsoBean;
import Storage.Utente.UtenteBean;

import java.util.ArrayList;

/**
 * Questa classe rappresenta una lista di corsi preferita.
 * Una lista possiede un idUtente a cui appartiene,
 * e la lista di corsi che l'utente preferisce.
 */
public class ListaPreferitiBean {

    /**
     * Rappresenta l'id del utente a cui appartiene al lista.
     */
    private int idUtente;

    /**
     * Rappresenta la lista dei corsi che l'utente preferisce.
     */
    private ArrayList<CorsoBean> corsi;

    /**
     * Costruttore vuoto.
     */
    public ListaPreferitiBean() { }


    /**
     * Costruttore del ListaPreferitiBean.
     * @param idUtente id del utente a cui appartiene al lista.
     * @param corsi la lista dei corsi che l'utente preferisce.
     */
    public ListaPreferitiBean(int idUtente,ArrayList<CorsoBean> corsi) {
        this.idUtente = idUtente;
        this.corsi = corsi;
    }

    /**
     * Costruttore del ListaPreferitiBean.
     * @param corsi la lista dei corsi che l'utente preferisce.
     */
    public ListaPreferitiBean(ArrayList<CorsoBean> corsi) {
        this.corsi = corsi;
    }

    /*//valutare se togliere
    public void addCorso(CorsoBean c){
        corsi.add(c);
    }*/

    /**
     * Ritorna l'id del utente a cui appartiene la lista.
     * @return l'id del utente a cui appartiene la lista.
     */
    public int getIdUtente() {
        return idUtente;
    }

    /**
     * Ritorna la lista dei corsi che l'utente preferisce.
     * @return la lista dei corsi che l'utente preferisce.
     */
    public ArrayList<CorsoBean> getCorsi() {
        return corsi;
    }

    /**
     * Set id del utente a cui appartiene la lista.
     * @param idUtente id del utente a cui appartiene la lista.
     */
    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    /**
     * Set dei corsi che l'utente preferisce.
     * @param corsi corsi che l'utente preferisce.
     */
    public void setCorsi(ArrayList<CorsoBean> corsi) {
        this.corsi = corsi;
    }



}
