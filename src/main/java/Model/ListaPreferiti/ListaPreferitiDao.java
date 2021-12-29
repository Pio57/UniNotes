package Model.ListaPreferiti;

import Model.ConPool;
import Model.Corso.CorsoBean;
import Model.Corso.CorsoExtractor;

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
            CorsoExtractor ce = new CorsoExtractor();
            ArrayList<CorsoBean> corsi = new ArrayList<>();

            while (rs.next()) {
                l = le.extract(rs);
                corsi.add(ce.extract(rs));
            }
            l.setCorsi(corsi);

            return l;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void doDelateCorso(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM ListaPreferiti  WHERE idCorso = ?",

                    Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, id);

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
