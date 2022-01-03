package Application.Utente.ServiceUtente;




import Storage.ListaPreferiti.ListaPreferitiDao;
import Storage.Utente.UtenteBean;
import Storage.Utente.UtenteDao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class UtenteServiceImpl implements UtenteService {

    public void registrazione(String nome, String cognome, String cf, String email, String password, String data) throws SQLException {
        UtenteBean utente = new UtenteBean();
        UtenteDao ud = new UtenteDao();

        utente.setNome(nome);
        utente.setCognome(cognome);
        utente.setCognome(cf);
        utente.setEmail(email);
        utente.setPassword(password);
        utente.setDdn(LocalDate.parse(data));

        ud.doSave(utente);
    }

    public UtenteBean login(String email, String password) {
        UtenteDao ud = new UtenteDao();
        UtenteBean utente = new UtenteBean();
        utente = ud.findAccount(email, password);
        return utente;
    }

    public void interireInListaPreferiti(int u, int c) {
        ListaPreferitiDao ld = new ListaPreferitiDao();
        ld.doSave(u,c);
    }

    public void rimuoviDaListaPreferiti(int c) {
        ListaPreferitiDao ld = new ListaPreferitiDao();
        ld.doDelateCorso(c);
    }

    public ArrayList<UtenteBean> visualizzaUtenti() throws SQLException {
        ArrayList<UtenteBean> utenti = new ArrayList<>();
        UtenteDao ud = new UtenteDao();
        utenti = ud.doRetriveAll();
        return utenti;
    }

    public void rendiAdmin(UtenteBean u) {
        UtenteDao ud = new UtenteDao();
        ud.doUpdateAdmin(u);
    }




}
