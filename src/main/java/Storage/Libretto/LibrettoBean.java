package Storage.Libretto;

import Storage.Esame.EsameBean;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Questa classe rappresenta il Libretto (LibrettoBean).
 * Un Libretto possiede un id, numero di esami sostenuti,
 * cfu accumulati, una media e una lista di esami.
 */
public class LibrettoBean{

    /**
     * Rappresenta la lista degli esami.
     */
    private ArrayList<EsameBean> listaEsami;

    /**
     * Rappresenta l'id del libretto.
     */
    private int idLibretto;

    /**
     * Rappresenta il numero di esami svolti.
     */
    private int numEsami;

    /**
     * Rappresenta i cfu accumulati.
     */
    private int cfuCrediti;

    /**
     * Rappresenta la media aritmentica del libretto.
     */
    private float media;


    /**
     * Costruttore vuoto.
     */
    public LibrettoBean() { }

    /**
     * Costruttore del LibrettoBean.
     * @param esame è la lista degli esami del libretto.
     */
    public LibrettoBean(ArrayList<EsameBean> esame) {
        this.listaEsami = esame;
    }


    /**
     * Costruttore del LibrettoBean.
     * @param idLibretto è l'id del libretto.
     * @param esami è la lista degli esami del libretto.
     */
    public LibrettoBean(int idLibretto, ArrayList<EsameBean> esami) {
        this.idLibretto = idLibretto;
        this.listaEsami = esami;
    }


    /**
     * Costruttore del LibrettoBean.
     * @param nunEsami è il numero di esami sostenuti.
     * @param cfuCrediti è il numero di crediti accumulati.
     * @param media è la media aritmetica del libretto.
     */
    public LibrettoBean(int nunEsami, int cfuCrediti, float media){
        this.numEsami=nunEsami;
        this.cfuCrediti=cfuCrediti;
        this.media=media;
    }

    /**
     * Rappresenta il metodo per stampare i campi di un singolo Libretto.
     * @return una stringa con tutti i campi del libretto.
     */
    @Override
    public String toString() {
        return "LibrettoBean{" +
                "listaEsami=" + listaEsami +
                ", idLibretto=" + idLibretto +
                ", numEsami=" + numEsami +
                ", cfuCrediti=" + cfuCrediti +
                ", media=" + media +
                '}';
    }

    /**
     * Metodo per aggiungere un nuovo esame al libretto.
     * @param esame il nuovo esame da aggiungere.
     */
    public void aggiungiEsame(EsameBean esame){
        if(listaEsami == null){
            listaEsami = new ArrayList<>();
        }
        if(esame != null){
            aggiorna();
            listaEsami.add(esame);
            numEsami++;
            cfuCrediti+=esame.getCfu();
            media = calcolaMedia();
        }
    }

    /**
     * Questo metodo è realizzato per aggiornare
     * lo stato del libretto con quello del DataBase
     */
    public void aggiorna(){//questo metodo è creato per aggiornare lo stato del libretto con quello nel db
        numEsami = listaEsami.size();
        cfuCrediti = 0;
        for(EsameBean e : listaEsami){
            cfuCrediti+=e.getCfu();
            media = calcolaMedia();
        }
    }

    /**
     * Questo metodo è privato e serve per calcolare la nuova media
     * dopo l'aggiunta di un nuovo esame.
     * @return la nuova media.
     */
    private float calcolaMedia(){
        float totVoti = 0;
        for(EsameBean e : listaEsami){
            totVoti+=e.getVoto();
        }
        if(totVoti > 0){
            return totVoti/numEsami;
        }
        return 0;
    }

    /**
     * Ritorna l'id del libretto.
     * @return l'id del libretto.
     */
    public int getIdLibretto() {
        return idLibretto;
    }

    /**
     * Set id del libretto
     * @param idLibretto id del libretto
     */
    public void setIdLibretto(int idLibretto) {
        this.idLibretto = idLibretto;
    }

    /**
     * Ritorna la lista degli esami svolti.
     * @return la lista degli esami svolti.
     */
    public ArrayList<EsameBean> getListaEsami() {
        return listaEsami;
    }

    /**
     * Set della lista degli esami svolti.
     * @param esami  lista degli esami svolti.
     */
    public void setListaEsami(ArrayList<EsameBean> esami) {
        this.listaEsami = esami;
    }

    /**
     * Ritorna il numero di esami svolti.
     * @return il numero di esami svolti.
     */
    public int getNunEsami() {
        return numEsami;
    }

    /**
     * Set del numero degli esami.
     * @param nunEsami numero degli esami svolti
     */
    public void setNunEsami(int nunEsami) {
        this.numEsami = nunEsami;
    }

    /**
     * Ritorna i cfu accumulati.
     * @return i cfu accumulati.
     */
    public int getCfuCrediti() {
        return cfuCrediti;
    }

    /**
     * Set dei cfu accumulati.
     * @param cfuCrediti cfu accumulati.
     */
    public void setCfuCrediti(int cfuCrediti) {
        this.cfuCrediti = cfuCrediti;
    }

    /**
     * Ritorna la media aritmetica.
     * @return la media aritmetica.
     */
    public float getMedia() {
        return media;
    }

    /**
     * Set della media aritmetica.
     * @param media media aritmetica.
     */
    public void setMedia(float media) {
        this.media = media;
    }
}
