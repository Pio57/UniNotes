package Application.Esame.ServiceEsame;

import Model.Esame.EsameBean;
import Model.Esame.EsameDao;

import java.util.Date;

public class EsameServiceImpl implements EsameService{


    public EsameBean inserisciEsame(String nome,String nomeProfessore,float voto,int cfu, Date data){
        EsameDao ed = new EsameDao();
        EsameBean e=new EsameBean();
        e.setCfu(cfu);
        e.setData(data);
        e.setNome(nome);
        e.setNomeProfessore(nomeProfessore);
        e.setVoto(voto);

        if( ed.doSave(e))
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
