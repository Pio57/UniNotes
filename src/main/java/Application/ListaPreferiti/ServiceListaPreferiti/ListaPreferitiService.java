package Application.ListaPreferiti.ServiceListaPreferiti;

import Storage.Corso.CorsoBean;
import Storage.ListaPreferiti.ListaPreferitiBean;
import Storage.MaterialeDidattico.MaterialeDidatticoBean;
import Storage.Utente.UtenteBean;

import java.util.ArrayList;

/**
 * Interfaccia per i metodi del sottosistema ListaPreferiti
 */
public interface ListaPreferitiService {

    /**
     * Firma del metodo che implementa la funzionalità di visualizzazione della lista preferiti
     * @return una ListaPreferitiBean
     */
    public ListaPreferitiBean visualizzaListaPreferiti(int id);

    /**
     * Firma del metodo che implementa la funzionalità di visualizzazione della lista preferiti di uno specifico utente (con idUtente)
     * @param idUtente
     * @return una ListaPreferitiBean
     */
    public ListaPreferitiBean visualizzaListaUtente(int idUtente);

    /**
     * Firma del metodo che implementa la funzionalità di visualizzazione della lista preferiti di uno specifico corso (con idCorso)
     * @param idCorso
     * @return una ListaPreferitiBean
     */
    public ArrayList<UtenteBean> visualizzaListaCorso(int idCorso);

    /**
     * Firma del metodo che implementa la funzionalità di inserimento di uno specifico corso (con idCorso) in una lista preferiti di uno specifico utente (con idUtente)
     * @param idUtente
     * @param idCorso
     */
    public void inserisciInListaPreferiti(int idUtente, int idCorso);

    /**
     * Firma del metodo che implementa la funzionalità di rimozione di uno specifico corso (con idCorso) in una lista preferiti di uno specifico utente (con idUtente)
     * @param idUtente
     * @param idCorso
     */
    public void rimuoviDaListaPreferiti(int idUtente,int idCorso);
    /**
     * Firma del metodo che implementa la funzionalità di ricerca che restituisce tutti gli id dei corsi della lista preferiti di uno specifico utete (idUtente)
     * @param idUtente
     * @return un ArrayList di Integer
     */
    public ArrayList<Integer> idCorsi(int idUtente);

}
