package produto;
import produtoDao.ProdutoDao;
import produtoDao.Conexao;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoCrud {
    ProdutoDao dao;
    Conexao conexao;
    Connection driver;
    public ProdutoCrud() throws SQLException, ClassNotFoundException {
        this.conexao = new Conexao();
        driver = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dbsis", "root", "qwe123"); 
        this.dao = new ProdutoDao(conexao.conexao(driver));
    }

    public void insere(Produto produto) {
        try {
            this.dao.insere(produto);
            this.conexao.fecha(conexao.conexao(this.driver));
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void edita(Produto produto) {
        try {
            this.dao.edita(produto);
            this.conexao.fecha(conexao.conexao(this.driver));
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atuaizaEstoque(Produto produto) {
        this.dao.atualizaEstoque(produto);
        //this.conexao.fecha(conexao.conexao(this.driver));
    }

    public void deleta(Produto produto) {
        try {
            this.dao.deleta(produto);
            this.conexao.fecha(conexao.conexao(this.driver));
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Collection<Produto> lista() {
        List<Produto> lista ;
        lista = (ArrayList<Produto>) this.dao.lista();
        try {
            this.conexao.fecha(conexao.conexao(this.driver));
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public Collection<Produto> buscaNome(String nome) {
        return this.dao.buscaProdutoNome(nome);
    }
    
    public Produto buscaProduto(int id) {
        return this.dao.buscaProduto(id);
    }
}
