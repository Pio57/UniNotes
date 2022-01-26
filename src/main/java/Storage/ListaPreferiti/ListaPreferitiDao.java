package Storage.ListaPreferiti;

import Storage.ConPool;
import Storage.Corso.CorsoBean;
import Storage.Corso.CorsoDao;
import Storage.Corso.CorsoExtractor;
import Storage.Utente.UtenteBean;
import Storage.Utente.UtenteExtractor;

import java.sql.*;
import java.util.ArrayList;

/**
 * Classe implementata per le operazioni sul database.
 */
public class ListaPreferitiDao {

    /**
     * Metodo per salvare una nuova corrispondenza nella lista dell'utente
     * con id del utente e id del corso.
     * @param idUtente id del utente che è interessato al corso.
     * @param idCorso id del corso a cui l'utente è interessato.
     * @return true se è stato salvato, false altrimenti.
     */
    public boolean doSave(int idUtente, int idCorso) {

        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO ListaPreferiti (idUtente, idCorso) VALUES(?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, idUtente);
            ps.setInt(2, idCorso);

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();

            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    /**
     * Ritorna tutti i corsi che un utente ha nella sua lista preferiti.
     * @param id del utente.
     * @return una lista preferiti (ListaPreferitiBean).
     */
    public ListaPreferitiBean doRetriveAllByIdUtente(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM ListaPreferiti l WHERE l.idUtente = ?");

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            ListaPreferitiBean l = new ListaPreferitiBean();
            ListaPreferitiExtractor le = new ListaPreferitiExtractor();
            CorsoDao cd = new CorsoDao();
            CorsoExtractor ce = new CorsoExtractor();
            ArrayList<CorsoBean> corsi = new ArrayList<>();

            while (rs.next()) {
                l = le.extract(rs);
                corsi.add(cd.doRetriveById(rs.getInt("l.idCorso")));
            }
            l.setCorsi(corsi);

            return l;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    /**
     * Ritorna tutti gli utenti che sono interessati ad un corso.
     * @param idCorso del corso interessato.
     * @return la lista di tutti gli utenti interessati a quel corso.
     */
    public ArrayList<UtenteBean> doRetriveAllByIdCorso(int idCorso) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM ListaPreferiti l ,Utente u WHERE (l.idUtente = u.id) AND l.idCorso = ?");

            ps.setInt(1, idCorso);

            ResultSet rs = ps.executeQuery();
            ListaPreferitiBean l = new ListaPreferitiBean();
            ListaPreferitiExtractor le = new ListaPreferitiExtractor();
            CorsoDao cd = new CorsoDao();
            CorsoExtractor ce = new CorsoExtractor();
            UtenteExtractor ue = new UtenteExtractor();
            ArrayList<UtenteBean> utenti = new ArrayList<>();

            while (rs.next()) {
                utenti.add(ue.extract(rs));
            }

            return utenti;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * Elimina una corso dalla lista preferiti del utente.
     * @param idUtente id del utente.
     * @param idCorso id del corso.
     */
    public void doDelateCorso(int idUtente, int idCorso) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM ListaPreferiti  WHERE idCorso = ? AND idUtente = ?",

                    Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, idCorso);
            ps.setInt(2, idUtente);

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
