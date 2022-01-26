package Storage.Libretto;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Questa classe facilita l'estrazione dei dati
 * dal ResultSet restituito da una query.
 */
public class LibrettoExtractor {

    /**
     * Metodo chiamato quando si estrarre un elemento da un ResultSet.
     * @param resultSet
     * @return Ritorna un oggetto LibrettoBean.
     * @throws SQLException
     */
    public LibrettoBean extract(ResultSet resultSet) throws SQLException {
        LibrettoBean lb = new LibrettoBean();
        lb.setIdLibretto(resultSet.getInt("l.id"));
        lb.setNunEsami(resultSet.getInt("l.numEsami"));
        lb.setMedia(resultSet.getFloat("l.media"));
        lb.setCfuCrediti(resultSet.getInt("l.crediti"));

        return lb;
    }
}
