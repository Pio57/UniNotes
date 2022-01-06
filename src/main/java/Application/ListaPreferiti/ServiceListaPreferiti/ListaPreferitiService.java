package Application.ListaPreferiti.ServiceListaPreferiti;

import Storage.Corso.CorsoBean;
import Storage.ListaPreferiti.ListaPreferitiBean;
import Storage.MaterialeDidattico.MaterialeDidatticoBean;

import java.util.ArrayList;

public interface ListaPreferitiService {


    public ListaPreferitiBean visualizzaListaPreferiti(int id);

    public void inserisciInListaPreferiti(int idUtente, int idCorso);

    public void rimuoviDaListaPreferiti(int idCorso);

}
