package Application.Esame.ServiceEsame;


import Storage.Esame.EsameBean;

import java.time.LocalDate;
import java.util.Date;

public interface EsameService {

    public EsameBean inserisciEsame(String nome, String nomeProfessore, float voto, int cfu, LocalDate data,int idLibretto);

    public EsameBean eliminaEsame(EsameBean e);

    public EsameBean modificaEsame(EsameBean e);
}
