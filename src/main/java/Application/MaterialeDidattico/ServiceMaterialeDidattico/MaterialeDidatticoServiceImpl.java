package Application.MaterialeDidattico.ServiceMaterialeDidattico;

import Storage.MaterialeDidattico.MaterialeDidatticoBean;
import Storage.MaterialeDidattico.MaterialeDidatticoDao;

import java.util.ArrayList;

/**
 * Implementa la classe che esplicita i metodi
 * definiti nell'interfaccia service
 */
public class MaterialeDidatticoServiceImpl implements MaterialeDidatticoService {

    /**
     * Implementa la funzionalità di inserimento di un materiale
     * @param nome del materiale da inserire
     * @param pathFile del materiale da inserire
     * @param idCorso del materiale da inserire
     * @param idUtente del materiale da inserire
     * @return boolean true se è stato inserito con successo altrimenti false
     */
    public boolean inserireMateriale(String nome,String pathFile , int idCorso,int idUtente){//qui ho aggiunto un parametro in più , e ho campbiato il valore di ritorno in un booleano
        MaterialeDidatticoBean m = new MaterialeDidatticoBean(nome,pathFile);
        MaterialeDidatticoDao md = new MaterialeDidatticoDao();
        if( md.doSave(m,idCorso,idUtente))
            return true;
        return false;
    }

    /**
     * Implementa la funzionalità di eliminazione di un materiale
     * @param id del materiale da eliminare
     * @return boolean true se è stato eliminato
     */
    public boolean eliminaMateriale(int id){
        MaterialeDidatticoDao md = new MaterialeDidatticoDao();
        return md.doDelate(id);

    }
    /*
        private ArrayList<MaterialeDidatticoBean> eliminaMateriale(MaterialeDidatticoBean m, CorsoBean c){
            MaterialeDidatticoDao md = new MaterialeDidatticoDao();
            md.doDelate(m.getId());
            return md.doRetriveAllByIdUtente(u.getIdUtente());
        }
    */

    /**
     * Implementa la funzionalità di modifica di un materiale
     * @param id del materiale da modificare
     * @param nome del materiale da modificare
     * @param fileName del materiale da modificare
     * @return boolean se il materiale è stato modificato con succeso altrimenti false
     */
    public boolean modificaMateriale(int id,String nome,String fileName){
        MaterialeDidatticoDao md = new MaterialeDidatticoDao();
        MaterialeDidatticoBean m = new MaterialeDidatticoBean(id,nome,fileName);
        if(md.doUpdate(m))
            return true;
        return false;
    }

    /**
     * Implementa la funzionalità di visualizzazione del singolo materiale
     * @param id del materiale da visualizzare
     * @return un MaterialeDidatticoBean
     */
    public MaterialeDidatticoBean visualizza(int id){
        MaterialeDidatticoDao md = new MaterialeDidatticoDao();
        return md.doRetriveById(id);
    }

    /**
     * Implementa la funzionalità di visualizzazione di tutti i materiali
     * @return un ArrayList di MaterialeDidatticoBean
     */
    public ArrayList<MaterialeDidatticoBean> visualizzaTutti(){
        MaterialeDidatticoDao md = new MaterialeDidatticoDao();
        return md.doRetriveAll();
    }

    /**
     * Implementa la funzionalità di visualizzazione del materiale di uno specifico utente con inUtente
     * @param idUtente
     * @return un ArrayList di MaterialeDidatticoBean
     */
    @Override
    public ArrayList<MaterialeDidatticoBean> visualizzaMaterialeDiUnUtente(int idUtente) {
        MaterialeDidatticoDao md = new MaterialeDidatticoDao();
        return md.doRetriveAllByIdUtente(idUtente);
    }

    /**
     * Implementa la funzionalità di visualizzazione del materiale di uno specifico corso con idCorso
     * @param idCorso
     * @return un ArrayList di MaterialeDidatticoBean
     */
    @Override
    public ArrayList<MaterialeDidatticoBean> visualizzaMaterialeDiUnCorso(int idCorso) {
        MaterialeDidatticoDao md = new MaterialeDidatticoDao();
        return md.doRetriveAllByIdCorso(idCorso);
    }

}
