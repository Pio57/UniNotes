package Application.ListaPreferiti.ServiceListaPreferiti;

import Storage.Corso.CorsoBean;
import Storage.Corso.CorsoDao;
import Storage.ListaPreferiti.ListaPreferitiBean;
import Storage.ListaPreferiti.ListaPreferitiDao;
import Storage.MaterialeDidattico.MaterialeDidatticoBean;
import Storage.Utente.UtenteBean;

import java.util.ArrayList;

/**
 * Implementa la classe che esplicita i metodi
 * definiti nell'interfaccia service
 */
public class ListaPreferitiImpl implements ListaPreferitiService{

    /**
     * Implementa la funzionalità di visualizzazione della lista preferiti
     * @return una ListaPreferitiBean
     */
    @Override
    public ListaPreferitiBean visualizzaListaPreferiti(int id) {
        ListaPreferitiDao ld = new ListaPreferitiDao();
        return ld.doRetriveAllByIdUtente(id);
    }

    /**
     * Implementa la funzionalità di visualizzazione della lista preferiti di uno specifico utente (con idUtente)
     * @param idUtente
     * @return una ListaPreferitiBean
     */
    @Override
    public ListaPreferitiBean visualizzaListaUtente(int idUtente) {
        ListaPreferitiDao ld = new ListaPreferitiDao();
        return ld.doRetriveAllByIdUtente(idUtente);
    }

    /**
     * Implementa la funzionalità di visualizzazione della lista preferiti di uno specifico corso (con idCorso)
     * @param idCorso
     * @return una ListaPreferitiBean
     */
    @Override
    public ArrayList<UtenteBean> visualizzaListaCorso(int idCorso) {
        ListaPreferitiDao ld = new ListaPreferitiDao();
        return ld.doRetriveAllByIdCorso(idCorso);
    }

    /**
     * Implementa la funzionalità di inserimento di uno specifico corso (con idCorso) in una lista preferiti di uno specifico utente (con idUtente)
     * @param idUtente
     * @param idCorso
     */
    @Override
    public void inserisciInListaPreferiti(int idUtente, int idCorso) {
        ListaPreferitiDao ld = new ListaPreferitiDao();
        ld.doSave(idUtente, idCorso);
    }

    /**
     * Implementa la funzionalità di rimozione di uno specifico corso (con idCorso) in una lista preferiti di uno specifico utente (con idUtente)
     * @param idUtente
     * @param idCorso
     */
    @Override
    public void rimuoviDaListaPreferiti(int idUtente,int idCorso) {
        ListaPreferitiDao ld = new ListaPreferitiDao();
        ld.doDelateCorso(idUtente,idCorso);
    }

    /**
     * Implementa la funzionalità di ricerca che restituisce tutti gli id dei corsi della lista preferiti di uno specifico utete (idUtente)
     * @param idUtente
     * @return un ArrayList di Integer
     */
    @Override
    public ArrayList<Integer> idCorsi(int idUtente) {
        ArrayList<Integer> ids = new ArrayList<>();
        for(CorsoBean c : visualizzaListaUtente(idUtente).getCorsi()) {
            ids.add(c.getId());
        }
        return ids;
    }
}
