package Storage.ListaPreferiti;

import Storage.Corso.CorsoBean;
import Storage.Utente.UtenteBean;

import java.util.ArrayList;

public class ListaPreferitiBean {

    private int idUtente;
    private ArrayList<CorsoBean> corsi;

    public ListaPreferitiBean() { }

    public ListaPreferitiBean(int idUtente,ArrayList<CorsoBean> corsi) {
        this.idUtente = idUtente;
        this.corsi = corsi;
    }

    public ListaPreferitiBean(ArrayList<CorsoBean> corsi) {
        this.corsi = corsi;
    }

    /*//valutare se togliere
    public void addCorso(CorsoBean c){
        corsi.add(c);
    }*/

    public int getIdUtente() {
        return idUtente;
    }

    public ArrayList<CorsoBean> getCorsi() {
        return corsi;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public void setCorsi(ArrayList<CorsoBean> corsi) {
        this.corsi = corsi;
    }



}
