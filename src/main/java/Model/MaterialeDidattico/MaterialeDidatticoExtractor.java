package Model.MaterialeDidattico;

import Model.Dao.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MaterialeDidatticoExtractor implements ResultSetExtractor<MaterialeDidatticoBean> {


    @Override
    public MaterialeDidatticoBean extract(ResultSet resultSet) throws SQLException {
        MaterialeDidatticoBean m = new MaterialeDidatticoBean();
        m.setId(resultSet.getInt("m.id"));
        m.setNome(resultSet.getString("m.nome"));
        m.setPathFile(resultSet.getString("m.pathFile"));

        return m;

    }
}
