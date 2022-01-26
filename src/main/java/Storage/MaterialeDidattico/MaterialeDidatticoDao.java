package Storage.MaterialeDidattico;

import Storage.ConPool;

import java.sql.*;
import java.util.ArrayList;

/**
 * Classe implementata per le operazioni sul database.
 */
public class MaterialeDidatticoDao {

    /**
     * Metodo per salvare un nuovo materiale (MaterialeDidatticoBean).
     * @param idCorso
     * @param idUtente
     * @return true se è stato salvato, false altrimenti.
     */
    public boolean doSave(MaterialeDidatticoBean m, int idCorso,int idUtente){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO MaterialeDidattico (nome, pathFile,idCorso,idUtente) VALUES(?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, m.getNome());
            ps.setString(2, m.getPathFile());
            ps.setInt(3,idCorso);
            ps.setInt(4,idUtente);

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

    /**
     * Ritirna tutto il materiale presente nel Database.
     * @return un ArrayList di MaterialeDidatticoBean
     */
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

    /**
     * Questo metodo ritorna un materiale che ha id(id)
     * @param id
     * @return un MaterialeDidatticoBean
     */
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

    /**
     * Elimina un materiale con id(id).
     * @param id id del materiale da eliminare.
     * @return true se il materiale viene elimanto, false altrimenti.
     */
    public boolean doDelate(int id){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM MaterialeDidattico  WHERE id = ?",

                    Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, id);

            if (ps.executeUpdate() != 1) {
                //throw new RuntimeException("INSERT error.");
                return false;
            }
            con.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Modifica un materiale presente sul database.
     * @param m il materiale
     * @return true se è stato modificato, false altrimenti.
     */
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

    /**
     * Questo metodo ritorna il materiale di un Utente
     * @param idUtente id del utente proprietario del materiale.
     * @return il materiale del utente con id(id).
     */
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

    /**
     * Questo metodo ritorna il materiale di un Corso
     * @param idCorso id del corso con il materiale.
     * @return il materiale del corso con id(id).
     */
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
