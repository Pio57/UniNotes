package Storage.Esame;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EsameExtractor {
    public EsameBean extract(ResultSet rs) throws SQLException {

        EsameBean esameBean = new EsameBean();
        esameBean.setId(rs.getInt("e.id"));
        esameBean.setNome(rs.getString("e.nome"));
        esameBean.setVoto(rs.getInt("e.voto"));
        esameBean.setCfu(rs.getInt("e.cfu"));
        esameBean.setData(rs.getDate("e.dataEsame").toLocalDate());
        esameBean.setNomeProfessore(rs.getString("e.nomeProfessore"));

        return esameBean;
    }
}
