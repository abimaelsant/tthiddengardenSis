package produtoDao;

import com.mysql.jdbc.Connection;
import java.sql.SQLException;

public class Conexao implements ConexaoInterface{
    @Override
    public Connection conexao(Connection driver) {
        Connection conexao = driver;
        System.out.println("Conectado!");
        return conexao;
    }
    
    @Override
    public void fecha(Connection conexao) throws SQLException{
        conexao.close();
    }
}
