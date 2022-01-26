package Storage.MaterialeDidattico;

import Storage.Dao.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Questa classe facilita l'estrazione dei dati
 * dal ResultSet restituito da una query.
 */
public class MaterialeDidatticoExtractor implements ResultSetExtractor<MaterialeDidatticoBean> {


    /**
     * Metodo chiamato quando si estrarre un elemento da un ResultSet.
     * @param resultSet
     * @return un MaterialeDidatticoBean
     * @throws SQLException
     */
    @Override
    public MaterialeDidatticoBean extract(ResultSet resultSet) throws SQLException {
        MaterialeDidatticoBean m = new MaterialeDidatticoBean();
        m.setId(resultSet.getInt("m.id"));
        m.setNome(resultSet.getString("m.nome"));
        m.setPathFile(resultSet.getString("m.pathFile"));

        return m;

    }
}
