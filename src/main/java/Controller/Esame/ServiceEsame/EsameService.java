package Controller.Esame.ServiceEsame;

import Model.Esame.EsameBean;
import Model.Esame.EsameDao;

import java.util.Date;

public interface EsameService {

    public EsameBean inserisciEsame(String nome, String nomeProfessore, float voto, int cfu, Date data);

    public EsameBean eliminaEsame(EsameBean e);

    public EsameBean modificaEsame(EsameBean e);
}
