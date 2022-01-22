package Application.ListaPreferiti.ServiceListaPreferiti;

import Storage.Corso.CorsoBean;
import Storage.Corso.CorsoDao;
import Storage.ListaPreferiti.ListaPreferitiBean;
import Storage.ListaPreferiti.ListaPreferitiDao;
import Storage.MaterialeDidattico.MaterialeDidatticoBean;

import java.util.ArrayList;

public class ListaPreferitiImpl implements ListaPreferitiService{

    @Override
    public ListaPreferitiBean visualizzaListaPreferiti(int id) {
        ListaPreferitiDao ld = new ListaPreferitiDao();
        return ld.doRetriveAllByIdUtente(id);
    }

    @Override
    public ListaPreferitiBean visualizzaListaUtente(int idUtente) {
        ListaPreferitiDao ld = new ListaPreferitiDao();
        return ld.doRetriveAllByIdUtente(idUtente);
    }

    @Override
    public void inserisciInListaPreferiti(int idUtente, int idCorso) {
        ListaPreferitiDao ld = new ListaPreferitiDao();
        ld.doSave(idUtente, idCorso);
    }

    @Override
    public void rimuoviDaListaPreferiti(int idUtente,int idCorso) {
        ListaPreferitiDao ld = new ListaPreferitiDao();
        ld.doDelateCorso(idUtente,idCorso);
    }

    @Override
    public ArrayList<Integer> idCorsi(int idUtente) {
        ArrayList<Integer> ids = new ArrayList<>();
        for(CorsoBean c : visualizzaListaUtente(idUtente).getCorsi()) {
            ids.add(c.getId());
        }
        return ids;
    }
}
