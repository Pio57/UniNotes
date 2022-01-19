package Application.Esame.ServiceEsame;


import Storage.Esame.EsameBean;

import java.time.LocalDate;
import java.util.Date;

public interface EsameService {

    public EsameBean inserisciEsame(String nome, String nomeProfessore, float voto, int cfu, LocalDate data,int idLibretto);

    public boolean eliminaEsame(int id);

    public EsameBean modificaEsame(int id,String nome, String nomeProfessore, float voto, int cfu, LocalDate data);
}
