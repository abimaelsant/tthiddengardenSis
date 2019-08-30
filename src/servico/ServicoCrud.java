package servico;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import produtoDao.Conexao;
import servicoDao.ServicoDao;

public class ServicoCrud {
    ServicoDao dao;
    Conexao conexao;
    Connection driver;
    public ServicoCrud() throws SQLException, ClassNotFoundException {
        this.conexao = new Conexao();
        driver = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dbsis", "root", "qwe123"); 
        this.dao = new ServicoDao(conexao.conexao(driver));
    }
    
    public void insere(Servico servico) {
        try {
            this.dao.insere(servico);
            this.conexao.fecha(conexao.conexao(this.driver));
        } catch (SQLException ex) {
            Logger.getLogger(ServicoCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void edita(Servico servico) {
        try {
            this.dao.edita(servico);
            this.conexao.fecha(conexao.conexao(this.driver));
        } catch (SQLException ex) {
            Logger.getLogger(ServicoCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleta(Servico servico) {
        try {
            this.dao.deleta(servico);
            this.conexao.fecha(conexao.conexao(this.driver));
        } catch (SQLException ex) {
            Logger.getLogger(ServicoCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Collection<Servico> lista() {
        List<Servico> lista ;
        lista = (ArrayList<Servico>) this.dao.lista();
        try {
            this.conexao.fecha(conexao.conexao(this.driver));
        } catch (SQLException ex) {
            Logger.getLogger(ServicoCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public Servico buscaServico(int id) {
        return this.dao.buscaServico(id);
    }
}
