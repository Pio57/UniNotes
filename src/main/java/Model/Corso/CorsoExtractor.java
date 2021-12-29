package Model.Corso;

import Model.Dao.ResultSetExtractor;
import Model.MaterialeDidattico.MaterialeDidatticoBean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CorsoExtractor implements ResultSetExtractor<CorsoBean> {

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
