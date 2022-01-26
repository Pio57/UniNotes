package Application.Esame.ServiceEsame;



import Storage.Esame.EsameBean;
import Storage.Esame.EsameDao;

import java.time.LocalDate;
import java.util.Date;

/**
 * Implementa la classe che esplicita i metodi
 * definiti nell'interfaccia service
 */
public class EsameServiceImpl implements EsameService{

    /**
     * Implementa la funzionalità di inserimento di un singolo esame
     * @param nome
     * @param nomeProfessore
     * @param voto
     * @param cfu
     * @param data
     * @param idLibretto
     * @return un EsameBean
     */
    public EsameBean inserisciEsame(String nome, String nomeProfessore, float voto, int cfu, LocalDate data,int idLibretto){
        EsameDao ed = new EsameDao();
        EsameBean e=new EsameBean();
        e.setCfu(cfu);
        e.setData(data);
        e.setNome(nome);
        e.setNomeProfessore(nomeProfessore);
        e.setVoto(voto);

        if( ed.doSave(e,idLibretto))
            return e;
        return null;
    }

    /**
     * Implementa la funzionalità di eliminazione di un singolo esame
     * @param id
     * @return un boolean (true se è stato eliminato, false se non è stato eliminato)
     */
    public boolean eliminaEsame(int id){
        EsameDao ed = new EsameDao();
        if(ed.doDelate(id))
            return true;
        return false;
    }

    /**
     * Implementa la funzionalità di modifica di un singolo esame
     * @param id
     * @param nome
     * @param nomeProfessore
     * @param voto
     * @param cfu
     * @param data
     * @return un EsameBean
     */
    public EsameBean modificaEsame(int id,String nome, String nomeProfessore, float voto, int cfu, LocalDate data){ /// da rivedere
        EsameDao ed = new EsameDao();
        EsameBean e=new EsameBean();
        e.setId(id);
        e.setCfu(cfu);
        e.setData(data);
        e.setNome(nome);
        e.setNomeProfessore(nomeProfessore);
        e.setVoto(voto);
        if( ed.doUpdate(e))
            return e;
        return null;
    }
}
