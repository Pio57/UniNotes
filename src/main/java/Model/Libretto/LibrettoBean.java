package Model.Libretto;

import Model.Esame.EsameBean;

import java.util.ArrayList;

public class LibrettoBean {
    private ArrayList<EsameBean> listaEsami;
    private int idLibretto,nunEsami,cfuCrediti;
    private float media;


    public LibrettoBean() { }

    public LibrettoBean(int idLibretto, ArrayList<EsameBean> esami) {
        this.idLibretto = idLibretto;
        this.listaEsami = esami;
    }

    public LibrettoBean(int nunEsami, int cfuCrediti, float media){
        this.nunEsami=nunEsami;
        this.cfuCrediti=cfuCrediti;
        this.media=media;
    }



    public LibrettoBean(ArrayList<EsameBean> esame) {
        this.listaEsami = esame;
    }

    public int getIdLibretto() {
        return idLibretto;
    }

    public void setIdLibretto(int idLibretto) {
        this.idLibretto = idLibretto;
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
