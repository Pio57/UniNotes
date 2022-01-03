package Storage.Libretto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LibrettoExtractor {

    public LibrettoBean extract(ResultSet resultSet) throws SQLException {
        LibrettoBean lb = new LibrettoBean();
        lb.setIdLibretto(resultSet.getInt("l.id"));
        lb.setNunEsami(resultSet.getInt("l.numEsami"));
        lb.setMedia(resultSet.getFloat("l.media"));
        lb.setCfuCrediti(resultSet.getInt("l.cfuCrediti"));

        return lb;
    }
}
