package Model.MaterialeDidattico;

import Model.ConPool;

import java.sql.*;
import java.util.ArrayList;

public class MaterialeDidatticoDao {

    public boolean doSave(MaterialeDidatticoBean m){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO MaterialeDidattico (nome, pathFile) VALUES(?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, m.getNome());
            ps.setString(2, m.getPathFile());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            m.setId(id);
            con.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<MaterialeDidatticoBean> doRetriveAll(){
        ArrayList<MaterialeDidatticoBean> materiale = new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM MaterialeDidattico m");
            ResultSet rs = ps.executeQuery();
            MaterialeDidatticoExtractor ce = new MaterialeDidatticoExtractor();
            while (rs.next()) {

                MaterialeDidatticoBean m = ce.extract(rs);

                materiale.add(m);

            }
            con.close();
            return materiale;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public MaterialeDidatticoBean doRetriveById(int id){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM MaterialeDidattico m WHERE m.Id = ?");

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            MaterialeDidatticoBean m = new MaterialeDidatticoBean();
            MaterialeDidatticoExtractor ce = new MaterialeDidatticoExtractor();
            if (rs.next()) {
                m = ce.extract(rs);
            }
            con.close();
            return m;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doDelate(int id){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM MaterialeDidattico  WHERE id = ?",

                    Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, id);

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean doUpdate(MaterialeDidatticoBean m){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE MaterialeDidattico SET nome = ?, pathFile = ?   WHERE id = " + m.getId());

            ps.setString(1,m.getNome());
            ps.setString(2, m.getPathFile());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("UPDATE error.");
            }
            con.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<MaterialeDidatticoBean> doRetriveAllByIdUtente(int idUtente){
        ArrayList<MaterialeDidatticoBean> materiale = new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM MaterialeDidattico m WHERE m.idUtente = "+idUtente);
            ResultSet rs = ps.executeQuery();
            MaterialeDidatticoExtractor ce = new MaterialeDidatticoExtractor();
            while (rs.next()) {

                MaterialeDidatticoBean m = ce.extract(rs);

                materiale.add(m);

            }
            con.close();
            return materiale;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<MaterialeDidatticoBean> doRetriveAllByIdCorso(int idCorso){
        ArrayList<MaterialeDidatticoBean> materiale = new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM MaterialeDidattico m WHERE m.idCorso = "+idCorso);
            ResultSet rs = ps.executeQuery();
            MaterialeDidatticoExtractor ce = new MaterialeDidatticoExtractor();
            while (rs.next()) {

                MaterialeDidatticoBean m = ce.extract(rs);

                materiale.add(m);

            }
            con.close();
            return materiale;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}
