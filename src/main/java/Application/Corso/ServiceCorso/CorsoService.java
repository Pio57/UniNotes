package Application.Corso.ServiceCorso;

import Storage.Corso.CorsoBean;
import Storage.MaterialeDidattico.MaterialeDidatticoBean;

import java.util.ArrayList;


/**
 * Interfaccia per i metodi del sottosistema Corso.
 */
public interface CorsoService {


    /**
     * Firma del metodo che implementa la funzionalità di tutti i corsi
     * per un Utente registrato.
     * @return una lista di Corsi.
     */
    public ArrayList<CorsoBean> visualizzaCorsi();

    /**
     * Firma del metodo che implementa la funzionalità di visualizzazione di un corso per un Utente registrato
     * @param id Id del corso da visualizzare
     * @return il corso con quel id.
     */
    public CorsoBean visualizzaCorso(int id);


    /**
     * Firma del metodo che implementa la funzionalità di inserimento di un nuovo corso
     * @param nome nome del corso.
     * @param descrizione descrizione del corso.
     * @param nomeProfessore nome del professore del corso.
     * @return il corso con quel id.
     */
    public CorsoBean inserisciCorso( String nome, String descrizione,String nomeProfessore); //ho modificato i parametri da passare --> modifira nell' odd

    /**
     * Firma del metodo che implementa la funzionalità di eliminazione di un corso
     * @param idCorso id del corso da eliminare.
     * @return true se il corso è stato eliminato, altrimenti false.
     */
    public boolean eliminaCorso(int idCorso);//qui ho aggiunto l'id per individuare il corso --> modificare nell'odd

    /**
     * Firma del metodo che implementa la funzionalità di modifica di un corso
     * @param id id del corso da modificare.
     * @param nome nome del corso.
     * @param descrizione descrizione del corso.
     * @param nomeProfessore nome del professore del corso.
     * @return il corso aggiornato.
     */
    public CorsoBean modificaCorso(int id,String nome, String descrizione,String nomeProfessore);


    /**
     * Firma del metodo che implementa la funzionalità di visualizzare il materiale di un corso
     * @param id id del corso.
     * @return una lista di materiale.
     */
    public ArrayList<MaterialeDidatticoBean> visualizzaTuttoIlMateriale(int id);
}
