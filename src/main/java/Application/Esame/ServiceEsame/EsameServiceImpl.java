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

    public EsameBean eliminaEsame(EsameBean e){
        EsameDao ed = new EsameDao();
        ed.doDelate(e.getId());
        return e;
    }

    public EsameBean modificaEsame(EsameBean e){ /// da rivedere
        EsameDao ed = new EsameDao();
        if( ed.doUpdate(e))
            return e;
        return null;
    }
}
