package produtoDao;

import com.mysql.jdbc.Connection;
import java.sql.SQLException;

public interface ConexaoInterface {
    Connection conexao(Connection driver);
    void fecha(Connection conexao) throws SQLException;
}
