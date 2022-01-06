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
    public void inserisciInListaPreferiti(int idUtente, int idCorso) {
        ListaPreferitiDao ld = new ListaPreferitiDao();
        ld.doSave(idUtente, idCorso);
    }

    @Override
    public void rimuoviDaListaPreferiti(int idCorso) {
        ListaPreferitiDao ld = new ListaPreferitiDao();
        ld.doDelateCorso(idCorso);
    }
}
