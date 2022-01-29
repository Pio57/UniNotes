package Storage.Libretto;

import Storage.ConPool;
import Storage.Esame.EsameBean;
import Storage.Esame.EsameExtractor;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Classe implementata per le operazioni sul database.
 */
public class LibrettoDao {


    /**
     * Metodo per salvare un nuovo Libretto (LibrettoBean).
     * @param l Nuovo libretto da inserire nel DataBase.
     * @return true se è stato salvato, false altrimenti.
     */
    public boolean doSave(LibrettoBean l){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO libretto (numEsami,media,crediti) VALUES(?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, l.getNunEsami());
            ps.setFloat(2, l.getMedia());
            ps.setInt(3, l.getCfuCrediti());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            l.setIdLibretto(id);
            con.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Ritirna tutti i libretti presenti nel Database.
     * @return Lista di tutti i libretti presenti nel Datobase.
     */
    public ArrayList<LibrettoBean> doRetriveAll(){
        ArrayList<LibrettoBean> lb = new ArrayList<>();
        ArrayList<EsameBean> esameBeans=new ArrayList<>();;
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Esame e, Libretto l WHERE (l.id = e.idCorso) ");
            ResultSet rs = ps.executeQuery();


            EsameExtractor ee = new EsameExtractor();
            LibrettoExtractor le = new LibrettoExtractor();

            while (rs.next()) {
                LibrettoBean l = new LibrettoBean();
                l=le.extract(rs);
                esameBeans.add(ee.extract(rs));
                lb.add(l);
            }
            return lb;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Questo metodo ritorna un Libretto che ha id(id)
     * @param id id del libretto da ritornare.
     * @return il Libretto con id(id).
     */
    public LibrettoBean doRetriveById(int id){
        ArrayList<EsameBean> eb = new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Esame e, Libretto l WHERE (l.id = e.idLibretto) AND l.id = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            LibrettoBean lb = new LibrettoBean();

            LibrettoExtractor le = new LibrettoExtractor();
            EsameExtractor ee = new EsameExtractor();


            while(rs.next()){
                lb = le.extract(rs);
                eb.add(ee.extract(rs));
            }
            if(eb.size() > 0){
                lb.setListaEsami(eb);
            }else{
                lb.setListaEsami(null);
                lb.setIdLibretto(id);
                lb.setMedia(0);
                lb.setNunEsami(0);
                lb.setCfuCrediti(0);
            }

            con.close();
            return lb;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Questo metodo ritorna il libretto di un Utente
     * @param idUtente id del utente proprietario del libretto.
     * @return il Libretto del utente con id(id).
     */
    public LibrettoBean doRetriveByIdUtente(int idUtente){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM libretto l, Utente u WHERE (l.id = u.idLibretto) AND u.id = ?");
            ps.setInt(1, idUtente);

            ResultSet rs = ps.executeQuery();
            LibrettoBean lb = new LibrettoBean();

            LibrettoExtractor le = new LibrettoExtractor();


            if (rs.next()) {
                lb = le.extract(rs);
            }
            lb.setListaEsami(null);
            con.close();
            return lb;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Elimina un Libretto con id(id).
     * @param id id del libretto da eliminare.
     * @return true se il libretto viene elimanto, false altrimenti.
     */
    public boolean doDelate(int id){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM libretto WHERE id = ?", Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, id);

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     *  Modifica un libretto presente sul database.
     * @param lb il libretto con i parametri modificati.
     * @return true se è stato modificato, false altrimenti.
     */
    public boolean doUpdate(LibrettoBean lb){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE Libretto SET numEsami = ?,media = ? ,crediti = ? WHERE id = "+ lb.getIdLibretto()+"");
            ps.setInt(1, lb.getNunEsami());
            ps.setFloat(2,lb.getMedia());
            ps.setInt(3,lb.getCfuCrediti());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("Update error.");
            }
            return true;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
