package Model.Libretto;

import Model.Esame.EsameBean;

import java.util.ArrayList;

public class LibrettoBean {
    private ArrayList<EsameBean> listaEsami;
    private int idLista;

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

}
