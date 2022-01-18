package Storage.Esame;

import Storage.ConPool;

import java.sql.*;
import java.util.ArrayList;

public class EsameDao {

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


    public ArrayList<EsameBean> doRetriveById(int id){
        ArrayList<EsameBean> esame= new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =con.prepareStatement("SELECT * FROM  Esame e  WHERE e.id = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            EsameExtractor ee= new EsameExtractor();

            if (rs.next()) {
                esame.add(ee.extract(rs));
                while(rs.next()) {
                    esame.add(ee.extract(rs));
                }
            }
            con.close();
            return esame;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean doDelate(int id){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM Esame e WHERE id = ?", Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, id);

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


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
