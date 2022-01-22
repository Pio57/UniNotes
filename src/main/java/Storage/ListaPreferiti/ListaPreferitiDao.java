package Storage.ListaPreferiti;

import Storage.ConPool;
import Storage.Corso.CorsoBean;
import Storage.Corso.CorsoDao;
import Storage.Corso.CorsoExtractor;

import java.sql.*;
import java.util.ArrayList;

public class ListaPreferitiDao {

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
