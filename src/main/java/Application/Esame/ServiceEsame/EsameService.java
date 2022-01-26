package Application.Esame.ServiceEsame;


import Storage.Esame.EsameBean;

import java.time.LocalDate;
import java.util.Date;

/**
 * Interfaccia per i metodi del sottosistema Esame
 */
public interface EsameService {

    /**
     * Firma del metodo che implementa la funzionalità di inserimento di un singolo esame
     * @param nome
     * @param nomeProfessore
     * @param voto
     * @param cfu
     * @param data
     * @param idLibretto
     * @return un EsameBean
     */
    public EsameBean inserisciEsame(String nome, String nomeProfessore, float voto, int cfu, LocalDate data,int idLibretto);

    /**
     * Firma del metodo che implementa la funzionalità di eliminazione di un singolo esame
     * @param id
     * @return un boolean (true se è stato eliminato, false se non è stato eliminato)
     */
    public boolean eliminaEsame(int id);


    /**
     * Firma del metodo che implementa la funzionalità di modifica di un singolo esame
     * @param id
     * @param nome
     * @param nomeProfessore
     * @param voto
     * @param cfu
     * @param data
     * @return un EsameBean
     */
    public EsameBean modificaEsame(int id,String nome, String nomeProfessore, float voto, int cfu, LocalDate data);
}
