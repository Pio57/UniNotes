package Application.MaterialeDidattico.ServiceMaterialeDidattico;

import Storage.MaterialeDidattico.MaterialeDidatticoBean;

import java.util.ArrayList;
/**
 * Interfaccia per i metodi del sottosistema Esame
 */
public interface MaterialeDidatticoService {

    /**
     * Firma del metodo che implementa la funzionalità di inserimento di un materiale
     * @param nome del materiale da inserire
     * @param pathFile del materiale da inserire
     * @param idCorso del materiale da inserire
     * @param idUtente del materiale da inserire
     * @return boolean true se è stato inserito con successo altrimenti false
     */
    public boolean inserireMateriale(String nome,String pathFile , int idCorso,int idUtente);//qui ho aggiunto un parametro in più , e ho campbiato il valore di ritorno in un booleano

    /**
     * Firma del metodo che implementa la funzionalità di eliminazione di un materiale
     * @param id del materiale da eliminare
     * @return boolean true se è stato eliminato
     */
    public boolean eliminaMateriale(int id);

    /*
        public ArrayList<MaterialeDidatticoBean> eliminaMateriale(MaterialeDidatticoBean m, CorsoBean c);

    */

    /**
     * Firma del metodo che implementa la funzionalità di modifica di un materiale
     * @param id del materiale da modificare
     * @param nome del materiale da modificare
     * @param fileName del materiale da modificare
     * @return boolean se il materiale è stato modificato con succeso altrimenti false
     */
    public boolean modificaMateriale(int id,String nome,String fileName);


    /**
     * Firma del metodo che implementa la funzionalità di visualizzazione del singolo materiale
     * @param id del materiale da visualizzare
     * @return un MaterialeDidatticoBean
     */
    public MaterialeDidatticoBean visualizza(int id);

    /**
     * Firma del metodo che implementa la funzionalità di visualizzazione di tutti i materiali
     * @return un ArrayList di MaterialeDidatticoBean
     */
    public ArrayList<MaterialeDidatticoBean> visualizzaTutti();

    /**
     * Firma del metodo che implementa la funzionalità di visualizzazione del materiale di uno specifico utente con inUtente
     * @param idUtente
     * @return un ArrayList di MaterialeDidatticoBean
     */
    public ArrayList<MaterialeDidatticoBean> visualizzaMaterialeDiUnUtente(int idUtente);

    /**
     * Firma del metodo che implementa la funzionalità di visualizzazione del materiale di uno specifico corso con idCorso
     * @param idCorso
     * @return un ArrayList di MaterialeDidatticoBean
     */
    public ArrayList<MaterialeDidatticoBean> visualizzaMaterialeDiUnCorso(int idCorso);

}
