package Model.Utente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class UtenteExtractor {

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
