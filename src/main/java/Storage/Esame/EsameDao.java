package Storage.Esame;

import Storage.ConPool;
import Storage.Utente.UtenteBean;
import Storage.Utente.UtenteExtractor;

import java.sql.*;
import java.util.ArrayList;
    /**
     * Classe implementata per le operazioni sul database.
     */
public class EsameDao {
    /**
     * Metodo che ritorna tutti gli esami presenti nel DB
     * @return l'arrei di esami presenti nel DB
     */
    public ArrayList<EsameBean> doRetriveAll(){
        ArrayList<EsameBean> esameBeans = new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM MaterialeDidattico m");
            ResultSet rs = ps.executeQuery();
            EsameExtractor ee = new EsameExtractor();
            while (rs.next()) {

                EsameBean eb = ee.extract(rs);

                esameBeans.add(eb);

            }
            con.close();
            return esameBeans;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        /**
         * Metodo per salvare un nuovo Esame(EsameBean)
         * @param esameBean Nuovo esame da inserire new DataBase
         * @param idLibretto Nuovo id del libretto da inserire new DataBase
         * @return true se è stato salvato, false altrimenti.
         */
    public boolean doSave(EsameBean esameBean,int idLibretto) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Esame (nome, voto, cfu, dataEsame, nomeProfessore, idLibretto) VALUES(?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            System.out.println(idLibretto);

            ps.setString(1, esameBean.getNome());
            ps.setFloat(2, esameBean.getVoto());
            ps.setInt(3, esameBean.getCfu());
            ps.setObject(4, esameBean.getData());
            ps.setString(5, esameBean.getNomeProfessore());
            ps.setInt(6, idLibretto);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            esameBean.setId(id);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        /**
         * Questo metodo ritorna un Esame che ha id(id).
         * @param id è l'id dell'esame da ritornare.
         * @return l'Esame con id(id).
         */
    public EsameBean doRetriveById(int id){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =con.prepareStatement("SELECT * FROM  Esame e  WHERE e.id = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            EsameBean e = new EsameBean();
            EsameExtractor ee= new EsameExtractor();

            if (rs.next()) {
                e = ee.extract(rs);
            }


            return e;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        /**
         * Elimina un Esame con id(id).
         * @param id id dell'esame da eliminare.
         * @return true se l'esame viene elimanto, false altrimenti.
         */
    public boolean doDelate(int id){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM Esame e WHERE id = ?", Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, id);

            if (ps.executeUpdate() != 1) {//ho modificato il ritorno di questo metodo per fare il testing
                //throw new RuntimeException("INSERT error.");
                return false;
            }
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        /**
         * Modifica un esame presente sul database.
         * @param eb l' esame con i parametri modificati.
         * @return true se è stato modificato, false altrimenti
         */

    public boolean doUpdate(EsameBean eb){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE Esame e SET nome=?, voto=?, cfu=?, dataEsame=?, nomeProfessore=? WHERE id = " + eb.getId()+"");
            ps.setString(1, eb.getNome());
            ps.setFloat(2,eb.getVoto());
            ps.setInt(3,eb.getCfu());
            ps.setObject(4,eb.getData());
            ps.setString(5, eb.getNomeProfessore());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("Update error.");
            }
            return true;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }


}
