package Storage.Corso;

import Storage.Dao.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Questa classe facilita l'estrazione dei dati
 * dal ResultSet restituito da una query.
 */
public class CorsoExtractor implements ResultSetExtractor<CorsoBean> {

    /**
     * Metodo chiamato quando si estrarre un elemento da un ResultSet.
     * @param resultSet
     * @return Ritorna un oggetto CorsoBean.
     * @throws SQLException
     */
    @Override
    public CorsoBean extract(ResultSet resultSet) throws SQLException {
        CorsoBean c = new CorsoBean();
        c.setId(resultSet.getInt("c.id"));
        c.setNome(resultSet.getString("c.nome"));
        c.setDescrizione(resultSet.getString("c.descrizione"));
        c.setNomeProfessore(resultSet.getString("c.nomeProfessore"));

        return c;
    }
}
