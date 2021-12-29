package Model.Libretto;

import Model.Esame.EsameBean;
import Model.Utente.UtenteBean;

import java.util.ArrayList;

public class LibrettoBean {
    private ArrayList<EsameBean> listaEsami;
    private int idLista,nunEsami,cfuCrediti;
    private float media;


    public LibrettoBean() { }

    public LibrettoBean(int idLista, ArrayList<EsameBean> esami) {
        this.idLista = idLista;
        this.listaEsami = esami;
    }

    public LibrettoBean(ArrayList<EsameBean> esame) {
        this.listaEsami = esame;
    }

    public int getIdLista() {
        return idLista;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    public ArrayList<EsameBean> getListaEsami() {
        return listaEsami;
    }

    public void setListaEsami(ArrayList<EsameBean> esami) {
        this.listaEsami = esami;
    }

    public int getNunEsami() {
        return nunEsami;
    }

    public void setNunEsami(int nunEsami) {
        this.nunEsami = nunEsami;
    }

    public int getCfuCrediti() {
        return cfuCrediti;
    }

    public void setCfuCrediti(int cfuCrediti) {
        this.cfuCrediti = cfuCrediti;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }
}
