package Storage.Utente;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Questa classe facilita l'estrazione dei dati
 * dal ResultSet restituito da una query.
 */

public class UtenteExtractor {
    /**
     * Metodo chiamato quando si estrarre un elemento da un ResultSet.
     * @param resultSet
     * @return Ritorna un oggetto UtenteBean.
     * @throws SQLException
     */
         public UtenteBean extract(ResultSet resultSet) throws SQLException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(resultSet.getInt("u.id"));
        u.setNome(resultSet.getString("u.nome"));
        u.setCognome(resultSet.getString("u.cognome"));
        u.setCf(resultSet.getString("u.cf"));
        u.setEmail(resultSet.getString("u.email"));
        u.setDdn(resultSet.getDate("u.dataDiNascita").toLocalDate());
        u.setTipo(resultSet.getBoolean("u.tipo"));

        return u;
    }
}
