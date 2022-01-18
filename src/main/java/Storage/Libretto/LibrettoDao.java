package Storage.Libretto;

import Storage.ConPool;
import Storage.Esame.EsameBean;
import Storage.Esame.EsameExtractor;

import java.sql.*;
import java.util.ArrayList;

public class LibrettoDao {


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




    public ArrayList<LibrettoBean> doRetriveAll(){    // da vedere
        ArrayList<LibrettoBean> lb = new ArrayList<>();
        ArrayList<EsameBean> esameBeans=new ArrayList<>();;
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM esame e, libretto l WHERE (l.id = e.idCorso) ");
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




    public LibrettoBean doRetriveById(int id){
        ArrayList<EsameBean> eb = new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM esame e, libretto l WHERE (l.id = e.idLibretto) AND l.id = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            LibrettoBean lb = new LibrettoBean();

            LibrettoExtractor le = new LibrettoExtractor();
            EsameExtractor ee = new EsameExtractor();


            if (rs.next()) {
                lb = le.extract(rs);
                eb.add(ee.extract(rs));
                while(rs.next()){
                    eb.add(ee.extract(rs));
                }
            }
            lb.setListaEsami(eb);
            con.close();
            return lb;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


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

    public boolean doUpdate(LibrettoBean lb){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE libretto SET numEsami = ?,media = ? ,crediti = ? WHERE id =? " + lb.getIdLibretto()+"");
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
