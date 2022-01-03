package Application.Utente.ServiceUtente;


import Storage.Utente.UtenteBean;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UtenteService {

    public void registrazione(String nome, String cognome, String cf, String email, String password, String data) throws SQLException;


    public UtenteBean login(String email, String password);

    public void interireInListaPreferiti(int u, int c);

    public  void rimuoviDaListaPreferiti(int c);

    public ArrayList<UtenteBean> visualizzaUtenti() throws SQLException;

    public void rendiAdmin(UtenteBean u);

}
