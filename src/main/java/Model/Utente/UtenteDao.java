package Model.Utente;

import Model.ConPool;

import java.sql.*;
import java.util.ArrayList;

public class UtenteDao {

   public boolean doSave(UtenteBean utente) throws SQLException {
       try(Connection con = ConPool.getConnection()) {
           PreparedStatement ps = con.prepareStatement(
                   "INSERT INTO Utente(nome, cognome, cf, mail, dataDiNascita, password, tipo) VALUES(?,?,?,?,?,?,?)",
                   Statement.RETURN_GENERATED_KEYS);

           ps.setString(1, utente.getNome());
           ps.setString(2, utente.getCognome());
           ps.setString(3, utente.getCf());
           ps.setString(4, utente.getEmail());
           ps.setObject(5, utente.getDdn());
           ps.setBoolean(6, utente.isTipo());

           if (ps.executeUpdate() != 1) {
               throw new RuntimeException("INSERT error.");
           }
           ResultSet rs = ps.getGeneratedKeys();
           rs.next();
           int id = rs.getInt(1);
           utente.setIdUtente(id);
           return true;

       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
   }

   public ArrayList<UtenteBean> doRetriveAll() throws SQLException {
       ArrayList<UtenteBean> utenti = new ArrayList<>();
       try (Connection con = ConPool.getConnection()) {
           PreparedStatement ps = con.prepareStatement("SELECT * FROM Utente u");
           ResultSet rs = ps.executeQuery();
           UtenteExtractor ue = new UtenteExtractor();

           while (rs.next()) {
               UtenteBean u = ue.extract(rs);
               utenti.add(u);
           }
           return utenti;
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
   }

       public UtenteBean doRetriveById ( int id){
           try (Connection con = ConPool.getConnection()) {
               PreparedStatement ps =
                       con.prepareStatement("SELECT * FROM Utente u WHERE u.id = ?");

               ps.setInt(1, id);

               ResultSet rs = ps.executeQuery();
               UtenteBean u = new UtenteBean();
               UtenteExtractor ue = new UtenteExtractor();
               if (rs.next()) {

                   u = ue.extract(rs);

               }
               return u;
           } catch (SQLException e) {
               throw new RuntimeException(e);
           }

       }


    public void doDelate(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM Utente  WHERE id = ?",

                    Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, id);

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean doUpdate(UtenteBean u) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE Utente SET nome = ?, cognome = ?, cf = ?, email = ?, dataDiNascita= ?, password = ?, tipo = ? WHERE id = " + u.getIdUtente());

            ps.setString(1,u.getNome());
            ps.setString(2, u.getCognome());
            ps.setString(3, u.getCf());
            ps.setString(4, u.getEmail());
            ps.setObject(5, u.getDdn());
            ps.setString(6, u.getPassword());
            ps.setBoolean(7, u.isTipo());


            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("UPDATE error.");
            }
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean doUpdateAdmin(UtenteBean u) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE Utente SET tipo = "+!u.isTipo()+" WHERE id = " + u.getIdUtente());


            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("UPDATE error.");
            }
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public UtenteBean findAccount(String email, String password) {
        try (Connection con = ConPool.getConnection()) {

            PreparedStatement ps = con.prepareStatement("SELECT * FROM Utente u WHERE u.email = ? AND u.password = ?");

            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            UtenteExtractor ue = new UtenteExtractor();
            UtenteBean u = null;

            if (rs.next()) {

                u = ue.extract(rs);
            }
            return u;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
