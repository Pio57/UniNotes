package Storage.Esame;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Questa classe facilita l'estrazione dei dati
 * dal ResultSet restituito da una query.
 */
public class EsameExtractor {
    /**
     * Metodo chiamato quando si estrarre un elemento da un ResultSet.
     * @param rs
     * @return Ritorna un oggetto EsameBean.
     * @throws SQLException
     */
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
