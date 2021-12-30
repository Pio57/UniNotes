package Model.Corso;

import Model.ConPool;
import Model.MaterialeDidattico.MaterialeDidatticoBean;
import Model.MaterialeDidattico.MaterialeDidatticoDao;
import Model.MaterialeDidattico.MaterialeDidatticoExtractor;

import java.sql.*;
import java.util.ArrayList;

public class CorsoDao {

    public boolean doSave(CorsoBean c){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Corso (nome, descrizione,nomeProfessore) VALUES(?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, c.getNome());
            ps.setString(2, c.getDescrizione());
            ps.setString(3, c.getNomeProfessore());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            c.setId(id);
            con.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    public ArrayList<CorsoBean> doRetriveAll(){//l'implementazione non è una delle migliori

        ArrayList<CorsoBean> corsi = new ArrayList<>();
        ArrayList<MaterialeDidatticoBean> materiali;
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM Corso c ");
            ResultSet rs = ps.executeQuery();


            CorsoExtractor ce = new CorsoExtractor();
            MaterialeDidatticoExtractor me = new MaterialeDidatticoExtractor();
            MaterialeDidatticoDao md = new MaterialeDidatticoDao();

            while (rs.next()) {
                CorsoBean c = ce.extract(rs);
                c.setListaMateriale(md.doRetriveAllByIdCorso(c.getId()));
               corsi.add(c);
            }
            con.close();
            return corsi;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    public CorsoBean doRetriveById(int id){
        ArrayList<MaterialeDidatticoBean> materiali = new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM Corso c WHERE c.id = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            CorsoBean c = new CorsoBean();

            CorsoExtractor ce = new CorsoExtractor();
            MaterialeDidatticoExtractor me = new MaterialeDidatticoExtractor();
            MaterialeDidatticoDao md = new MaterialeDidatticoDao();


            if (rs.next()) {
                c = ce.extract(rs);
            }

            c.setListaMateriale(md.doRetriveAllByIdCorso(id));
            con.close();
            return c;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean doDelate(int id){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM Corso WHERE id = ?",

                    Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, id);

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean doUpdate(CorsoBean c){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE Corso SET nome = ?,descrizione = ? ,nomeProfessore = ? WHERE id = " + c.getId()+"");
            ps.setString(1, c.getNome());
            ps.setString(2,c.getNome());
            ps.setString(3,c.getNomeProfessore());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("Update error.");
            }
            return true;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }



}
