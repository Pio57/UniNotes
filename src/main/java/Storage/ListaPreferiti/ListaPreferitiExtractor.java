package Storage.ListaPreferiti;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Questa classe facilita l'estrazione dei dati
 * dal ResultSet restituito da una query.
 */
public class ListaPreferitiExtractor {

    /**
     * Metodo chiamato quando si estrarre un elemento da un ResultSet.
     * @param resultSet
     * @return Ritorna un oggetto CorsoBean.
     * @throws SQLException
     */
    public ListaPreferitiBean extract(ResultSet resultSet) throws SQLException {
        ListaPreferitiBean l = new ListaPreferitiBean();
        l.setIdUtente(resultSet.getInt("l.idUtente"));
        return l;
    }
}
