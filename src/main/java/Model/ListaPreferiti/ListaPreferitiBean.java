package Model.ListaPreferiti;

import Model.Corso.CorsoBean;

import java.util.ArrayList;

public class ListaPreferitiBean {

    private int idLista;
    private ArrayList<CorsoBean> corsi;

    public ListaPreferitiBean() { }

    public ListaPreferitiBean(int idLista, ArrayList<CorsoBean> corsi) {
        this.idLista = idLista;
        this.corsi = corsi;
    }

    public ListaPreferitiBean(ArrayList<CorsoBean> corsi) {
        this.corsi = corsi;
    }

    public int getIdLista() {
        return idLista;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    public ArrayList<CorsoBean> getCorsi() {
        return corsi;
    }

    public void setCorsi(ArrayList<CorsoBean> corsi) {
        this.corsi = corsi;
    }



}
