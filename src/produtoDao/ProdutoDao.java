package produtoDao;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JOptionPane;
import produto.Produto;

public class ProdutoDao implements ProdutoInterface {

    private Connection c;

    public ProdutoDao(Connection c) throws SQLException {
        this.c = c;
    }

    @Override
    public void insere(Produto produto) {
        String sql = "INSERT INTO produto(nome, quantidade, custoLote, freteTotal, freteUnitario, custoUnitario, custoUnitarioComFrete, precoUnitario, lucroUnitario, lucroLote) VALUES (?,?,?,?,?,?,?,?,?,?)";

        try {
            try (PreparedStatement stmt = (PreparedStatement) c.prepareStatement(sql)) {
                stmt.setString(1, produto.getNome());
                stmt.setInt(2, produto.getQuantidade());
                stmt.setDouble(3, produto.getCustoLote());
                stmt.setDouble(4, produto.getFreteTotal());
                stmt.setDouble(5, produto.getFreteUnitario());
                stmt.setDouble(6, produto.getCustoUnitario());
                stmt.setDouble(7, produto.getCustoUnitarioComFrete());
                stmt.setDouble(8, produto.getPrecoUnitario());
                stmt.setDouble(9, produto.getLucroUnitario());
                stmt.setDouble(10, produto.getLucroLote());
                stmt.execute();
                JOptionPane.showMessageDialog(null, "PRODUTO CADASTRADO COM SUCESSO.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO. POR FAVOR TENTE NOVAMENTE.");
            System.out.println(e);
        }
    }

    @Override
    public void edita(Produto produto) {
        String sql = "UPDATE produto set nome=?,quantidade=?, custoLote=?, freteTotal=?, freteUnitario=?, custoUnitario=?, custoUnitarioComFrete=?, precoUnitario=?, lucroUnitario=?, lucroLote=? where id=?";

        try {

            try (PreparedStatement stmt = (PreparedStatement) c.prepareStatement(sql)) {
                stmt.setString(1, produto.getNome());
                stmt.setInt(2, produto.getQuantidade());
                stmt.setDouble(3, produto.getCustoLote());
                stmt.setDouble(4, produto.getFreteTotal());
                stmt.setDouble(5, produto.getFreteUnitario());
                stmt.setDouble(6, produto.getCustoUnitario());
                stmt.setDouble(7, produto.getCustoUnitarioComFrete());
                stmt.setDouble(8, produto.getPrecoUnitario());
                stmt.setDouble(9, produto.getLucroUnitario());
                stmt.setDouble(10, produto.getLucroLote());
                stmt.setInt(11, produto.getId());
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "PRODUTO EDITADO COM SUCESSO.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO. POR FAVOR TENTE NOVAMENTE. " + e);
        }
    }
    
    
    public void atualizaEstoque(Produto produto) {
        String sql = "UPDATE produto set quantidade=? where id=?";

        try {

            try (PreparedStatement stmt = (PreparedStatement) c.prepareStatement(sql)) {
                stmt.setInt(1, produto.getQuantidade());
                stmt.setInt(2, produto.getId());
                stmt.executeUpdate();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO. POR FAVOR TENTE NOVAMENTE. "+e);
        }
    }

    @Override
    public void deleta(Produto produto) {

        String sql = "DELETE FROM produto WHERE id=? ";

        try {
            try (PreparedStatement stmt = (PreparedStatement) c.prepareStatement(sql)) {
                stmt.setInt(1, produto.getId());
                stmt.execute();
                JOptionPane.showMessageDialog(null, "PRODUTO DELETADO COM SUCESSO.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO. POR FAVOR TENTE NOVAMENTE.");
        }
    }

    @Override
    public Collection<Produto> lista() {

        List<Produto> produtos = new ArrayList<>();

        try {

            PreparedStatement sql = c.prepareStatement("select * from produto");
            ResultSet rs = sql.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();

                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setCustoLote(rs.getDouble("custoLote"));
                produto.setFreteTotal(rs.getDouble("freteTotal"));
                produto.setFreteUnitario(rs.getDouble("freteUnitario"));
                produto.setCustoUnitario(rs.getDouble("custoUnitario"));
                produto.setCustoUnitarioComFrete(rs.getDouble("custoUnitarioComFrete"));
                produto.setPrecoUnitario(rs.getDouble("precoUnitario"));
                produto.setLucroUnitario(rs.getDouble("lucroUnitario"));
                produto.setLucroLote(rs.getDouble("lucroLote"));
                produtos.add(produto);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO. POR FAVOR TENTE NOVAMENTE.");
        }
        return (produtos);
    }

    @Override
    public Produto buscaProduto(int id) {

        Produto produto = new Produto();

        try {

            String sql = "SELECT * FROM produto where id=?";
            PreparedStatement ps = this.c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setCustoLote(rs.getDouble("custoLote"));
                produto.setFreteTotal(rs.getDouble("freteTotal"));
                produto.setFreteUnitario(rs.getDouble("freteUnitario"));
                produto.setCustoUnitario(rs.getDouble("custoUnitario"));
                produto.setCustoUnitarioComFrete(rs.getDouble("custoUnitarioComFrete"));
                produto.setPrecoUnitario(rs.getDouble("precoUnitario"));
                produto.setLucroUnitario(rs.getDouble("lucroUnitario"));
                produto.setLucroLote(rs.getDouble("lucroLote"));

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO. POR FAVOR TENTE NOVAMENTE.");
        }
        return produto;
    }

    public Collection<Produto> buscaProdutoNome(String nome) {

        List<Produto> produtos = new ArrayList<>();
        try {

            //PreparedStatement sql = c.prepareStatement("select from produto WHERE nome like '"+nome+"'");
            String sql = "SELECT * FROM produto where nome like ?";
            PreparedStatement ps = this.c.prepareStatement(sql);
            ps.setString(1, "%" + nome + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setCustoLote(rs.getDouble("custoLote"));
                produto.setFreteTotal(rs.getDouble("freteTotal"));
                produto.setFreteUnitario(rs.getDouble("freteUnitario"));
                produto.setCustoUnitario(rs.getDouble("custoUnitario"));
                produto.setCustoUnitarioComFrete(rs.getDouble("custoUnitarioComFrete"));
                produto.setPrecoUnitario(rs.getDouble("precoUnitario"));
                produto.setLucroUnitario(rs.getDouble("lucroUnitario"));
                produto.setLucroLote(rs.getDouble("lucroLote"));
                produtos.add(produto);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO. POR FAVOR TENTE NOVAMENTE.");
        }
        return produtos;
    }
}
