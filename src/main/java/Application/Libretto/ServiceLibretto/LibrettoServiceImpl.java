package Application.Libretto.ServiceLibretto;



import Storage.Libretto.LibrettoBean;
import Storage.Libretto.LibrettoDao;

import java.util.ArrayList;

/**
 * Implementa la classe che esplicita i metodi
 * definiti nell'interfaccia service
 */
public class LibrettoServiceImpl implements LibrettoService {


    /**
     * Implementa la funzionalità di visualizzazione di tutti i libretti
     * @return un arrayList di tutti i libretti
     */
    public ArrayList<LibrettoBean> visualizzaLibretto(){
        LibrettoDao ld = new LibrettoDao();
        return ld.doRetriveAll();
    }

    /**
     * Implementa la funzionalità di visualizzazione di singolo libretto dell'utente dato da idUtente
     * @return un LibrettoBean
     */
    @Override
    public LibrettoBean visualizzaLibrettoDiUtente(int idUtente) {
        LibrettoDao l = new LibrettoDao();
        return l.doRetriveByIdUtente(idUtente);
    }

    /**
     * Implementa la funzionalità di visualizzazione di singolo libretto con idLibretto
     * @return un LibrettoBean
     */
    public LibrettoBean visualizzaLibretto(int id){
        LibrettoDao lb = new LibrettoDao();
        return lb.doRetriveById(id);
    }

    /**
     * Implementa la funzionalità di inserimento di singolo libretto
     * @param ne
     * @param cc
     * @param media
     * @return un LibrettoBean
     */
    public LibrettoBean inserisciLibretto(int ne, int cc, float media){
        LibrettoBean l = new LibrettoBean(ne,cc,media);
        LibrettoDao ld = new LibrettoDao();
        if(ld.doSave(l))
            return l;
        return null;
    }

    /**
     * Implementa la funzionalità di eliminazione di singolo libretto
     * @param l
     * @return un boolean (true se è stato elieminato, false se non è stato eliminato)
     */
    public boolean eliminaLibretto(LibrettoBean l){
        LibrettoDao ld = new LibrettoDao();
        if(ld.doDelate(l.getIdLibretto()))
            return true;
        return false;
    }

    /**
     * Implementa la funzionalità di modifica di singolo libretto
     * @param l
     * @return un LibrettoBean modificato
     */
    public LibrettoBean modificaLibretto(LibrettoBean l){
        LibrettoDao ld = new LibrettoDao();
        if(ld.doUpdate(l))
            return l;
        return null;
    }

}
