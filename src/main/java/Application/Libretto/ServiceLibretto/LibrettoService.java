package Application.Libretto.ServiceLibretto;


import Storage.Libretto.LibrettoBean;

import java.util.ArrayList;

/**
 * Interfaccia per i metodi del sottosistema Libretto
 */
public interface LibrettoService {

    /**
     * Firma del metodo che implementa la funzionalità di visualizzazione di tutti i libretti
     * @return ArrayList di LibrettoBean
     */
    public ArrayList<LibrettoBean> visualizzaLibretto();

    /**
     * Firma del metodo che implementa la funzionalità di visualizzazione il libretto dell'utente dato da idUtente
     * @return LibrettoBean
     */
    public LibrettoBean visualizzaLibrettoDiUtente(int idUtente);

    /**
     * Firma del metodo che implementa la funzionalità di visualizzazione di singolo libretto con idLibretto
     * @return ArrayList di LibrettoBean
     */
    public LibrettoBean visualizzaLibretto(int id);

    /**
     * Firma del metodo che implementa la funzionalità di inserimento di singolo libretto
     * @return ArrayList di LibrettoBean
     */
    public LibrettoBean inserisciLibretto(int ne, int cc, float media);

    /**
     * Firma del metodo che implementa la funzionalità  di eliminazione di singolo libretto
     * @param l
     * @return un boolean (true se è stato elieminato, false se non è stato eliminato)
     */
    public boolean eliminaLibretto(LibrettoBean l);

    /**
     * Firma del metodo che implementa la funzionalità di modifica di singolo libretto
     * @param l
     * @return un LibrettoBean modificato
     */
    public LibrettoBean modificaLibretto(LibrettoBean l);

}
