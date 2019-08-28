package cliente;

import clienteDao.ClienteDao;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import produto.Produto;
import produto.ProdutoCrud;
import produtoDao.Conexao;
import produtoDao.ProdutoDao;

public class ClienteCrud {
    ClienteDao dao;
    Conexao conexao;
    Connection driver;
    public ClienteCrud() throws SQLException, ClassNotFoundException {
        this.conexao = new Conexao();
        driver = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dbsis", "root", "qwe123"); 
        this.dao = new ClienteDao(conexao.conexao(driver));
    }

    public void insere(Cliente cliente) {
        try {
            this.dao.insere(cliente);
            this.conexao.fecha(conexao.conexao(this.driver));
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void edita(Cliente cliente) {
        try {
            this.dao.edita(cliente);
            this.conexao.fecha(conexao.conexao(this.driver));
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleta(Cliente cliente) {
        try {
            this.dao.deleta(cliente);
            this.conexao.fecha(conexao.conexao(this.driver));
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Collection<Cliente> lista() {
        List<Cliente> lista ;
        lista = (ArrayList<Cliente>) this.dao.lista();
        try {
            this.conexao.fecha(conexao.conexao(this.driver));
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public Collection<Cliente> buscaNome(String nome) {
        return this.dao.buscaClienteNome(nome);
    }
    
    public Cliente buscaCpf(String cpf) {
        return this.dao.buscaClienteCpf(cpf);
    }
    
    public boolean buscaCpfVerifica(String cpf) {
       Cliente cliente = new Cliente();
       cliente = this.dao.buscaClienteCpfVerifica(cpf);
       return cliente.getCpf() != null;
    }
    
    public boolean buscaCpfVerificaEdita(String cpf, int id) {
       Cliente cliente = new Cliente();
       cliente = this.dao.buscaClienteCpfVerifica(cpf);
       return cliente.getCpf() != null && cliente.getId() != id;
    }
}
