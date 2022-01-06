package Application.Utente.ServiceUtente;


import Storage.Utente.UtenteBean;
import Storage.Utente.UtenteDao;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface UtenteService {

    public UtenteBean registrazione(String nome, String cognome, String cf, String email, String password, String data) throws SQLException, NoSuchAlgorithmException;


    public UtenteBean login(String email, String password);

    public UtenteBean aggiorna(UtenteBean u);

    public void interireInListaPreferiti(int u, int c);

    public  void rimuoviDaListaPreferiti(int c);

    public ArrayList<UtenteBean> visualizzaUtenti();

    public void rendiAdmin(UtenteBean u);



}
