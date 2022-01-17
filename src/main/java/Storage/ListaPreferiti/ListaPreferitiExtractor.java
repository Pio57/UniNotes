package Storage.ListaPreferiti;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ListaPreferitiExtractor {

    public ListaPreferitiBean extract(ResultSet resultSet) throws SQLException {
        ListaPreferitiBean l = new ListaPreferitiBean();
        l.setIdUtente(resultSet.getInt("l.idUtente"));
        return l;
    }
}
