package Application.Utente.ServiceUtente;




import Storage.Libretto.LibrettoBean;
import Storage.ListaPreferiti.ListaPreferitiDao;
import Storage.MaterialeDidattico.MaterialeDidatticoBean;
import Storage.Utente.UtenteBean;
import Storage.Utente.UtenteDao;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class UtenteServiceImpl implements UtenteService {

    public UtenteBean registrazione(String nome, String cognome, String cf, String email, String password, String data, LibrettoBean l) throws SQLException, NoSuchAlgorithmException {
        UtenteBean utente = new UtenteBean();
        UtenteDao ud = new UtenteDao();

        utente.setNome(nome);
        utente.setCognome(cognome);
        utente.setCf(cf);
        utente.setEmail(email);
        utente.setPassword(password);
        utente.setDdn(LocalDate.parse(data));
        utente.setLibretto(l);

        utente = ud.doSave(utente);
        return utente;

    }

    public UtenteBean login(String email, String password) {
        UtenteDao ud = new UtenteDao();
        return ud.findAccount(email, password);
    }

    @Override
    public UtenteBean aggiorna(UtenteBean u) {
        UtenteDao ud = new UtenteDao();
        if(ud.doUpdate(u))
            return u;
        return null;
    }

    public void interireInListaPreferiti(int u, int c) {
        ListaPreferitiDao ld = new ListaPreferitiDao();
        ld.doSave(u,c);
    }

    public void rimuoviDaListaPreferiti(int c) {
        ListaPreferitiDao ld = new ListaPreferitiDao();
        ld.doDelateCorso(c);
    }

    @Override
    public boolean verificaProprioMateriale(ArrayList<MaterialeDidatticoBean> materiale, MaterialeDidatticoBean m) {
        for(MaterialeDidatticoBean ma : materiale){
            if(ma.getId() == m.getId())
                return true;
        }
        return false;
    }

    public ArrayList<UtenteBean> visualizzaUtenti(){
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
