package venda;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import produtoDao.Conexao;
import servico.Servico;
import servico.ServicoCrud;
import vendaDao.VendaDao;

public class VendaCrud {

    VendaDao dao;
    Conexao conexao;
    Connection driver;

    public VendaCrud() throws SQLException, ClassNotFoundException {
        this.conexao = new Conexao();
        driver = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dbsis", "root", "qwe123");
        this.dao = new VendaDao(conexao.conexao(driver));
    }

    public void insere(Venda venda) throws ClassNotFoundException {
        try {
            this.dao.verificaAddProduto(venda);
            this.conexao.fecha(conexao.conexao(this.driver));
        } catch (SQLException ex) {
            Logger.getLogger(VendaCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void edita(Venda venda) {
        try {
            this.dao.edita(venda);
            this.conexao.fecha(conexao.conexao(this.driver));
        } catch (SQLException ex) {
            Logger.getLogger(VendaCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleta(Venda venda) {
        try {
            this.dao.deleta(venda);
            this.conexao.fecha(conexao.conexao(this.driver));
        } catch (SQLException ex) {
            Logger.getLogger(VendaCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Collection<Servico> lista() {
        List<Servico> lista;
        lista = (ArrayList<Servico>) this.dao.lista();
        try {
            this.conexao.fecha(conexao.conexao(this.driver));
        } catch (SQLException ex) {
            Logger.getLogger(ServicoCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    public Collection<VendaGeral> buscaVendasCliente(int idCliente) {
        List<VendaGeral> lista;
        lista = (ArrayList<VendaGeral>) this.dao.buscaVendasCliente(idCliente);
        try {
            this.conexao.fecha(conexao.conexao(this.driver));
        } catch (SQLException ex) {
            Logger.getLogger(ServicoCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public void finalizaVendaCliente(Venda venda, List<VendaGeral> lista) throws ClassNotFoundException {
        this.dao.finalizaVendaCliente(venda, lista);
        //this.conexao.fecha(conexao.conexao(this.driver));
    }
}
