package Application.Esame.ServiceEsame;



import Storage.Esame.EsameBean;
import Storage.Esame.EsameDao;

import java.time.LocalDate;
import java.util.Date;

public class EsameServiceImpl implements EsameService{


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

    public boolean eliminaEsame(int id){
        EsameDao ed = new EsameDao();
        if(ed.doDelate(id))
            return true;
        return false;
    }

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
