package Application.Corso.ServiceCorso;

import Storage.Corso.CorsoBean;
import Storage.Corso.CorsoDao;
import Storage.MaterialeDidattico.MaterialeDidatticoBean;

import java.util.ArrayList;

/**
 * Implementa la classe che esplicita i metodi
 * definiti nell'interfaccia service
 */
public class CorsoServiceImpl implements CorsoService {


    /**
     * Implementa la funzionalità di tutti i corsi
     * per un Utente registrato.
     * @return una lista di Corsi.
     */
    public ArrayList<CorsoBean> visualizzaCorsi(){
        CorsoDao cd = new CorsoDao();
        return cd.doRetriveAll();
    }


    /**
     * Implementa la funzionalità di visualizzazione di un corso per un Utente registrato
     * @param id Id del corso da visualizzare
     * @return il corso con quel id.
     */
    public CorsoBean visualizzaCorso(int id){
        CorsoDao cd = new CorsoDao();
        return cd.doRetriveById(id);
    }


    /**
     * Implementa la funzionalità di inserimento di un nuovo corso
     * @param nome nome del corso.
     * @param descrizione descrizione del corso.
     * @param nomeProfessore nome del professore del corso.
     * @return il corso con quel id.
     */
    public CorsoBean inserisciCorso( String nome, String descrizione,String nomeProfessore){ //ho modificato i parametri da passare --> modifira nell' odd
        CorsoBean c = new CorsoBean(nome,descrizione,nomeProfessore);
        CorsoDao cd = new CorsoDao();
        if(cd.doSave(c))
            return c;
        return null;
    }

    /**
     * Implementa la funzionalità di eliminazione di un corso
     * @param idCorso id del corso da eliminare.
     * @return true se il corso è stato eliminato, altrimenti false.
     */
    public boolean eliminaCorso(int idCorso){//qui ho aggiunto l'id per individuare il corso --> modificare nell'odd
        CorsoDao cd = new CorsoDao();
        if(cd.doDelate(idCorso))
            return true;
        return false;
    }


    /**
     * Implementa la funzionalità di modifica di un corso
     * @param id id del corso da modificare.
     * @param nome nome del corso.
     * @param descrizione descrizione del corso.
     * @param nomeProfessore nome del professore del corso.
     * @return il corso aggiornato.
     */
    public CorsoBean modificaCorso(int id,String nome, String descrizione,String nomeProfessore){
        CorsoDao cd = new CorsoDao();
        CorsoBean c = new CorsoBean(id,nome,descrizione,nomeProfessore);
        if(cd.doUpdate(c))
            return c;
        return null;
    }

    /**
     * Implementa la funzionalità di visualizzare il materiale di un corso
     * @param id id del corso.
     * @return una lista di materiale.
     */
    public ArrayList<MaterialeDidatticoBean> visualizzaTuttoIlMateriale(int id){
        CorsoDao cd = new CorsoDao();
        return cd.doRetriveById(id).getListaMateriale();
    }

}
