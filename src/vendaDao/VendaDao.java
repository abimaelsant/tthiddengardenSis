package vendaDao;

import cliente.Cliente;
import com.mysql.jdbc.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JOptionPane;
import produto.Produto;
import produto.ProdutoCrud;
import servico.Servico;
import venda.Venda;
import venda.VendaGeral;

public class VendaDao {

    private Connection c;

    public VendaDao(Connection c) throws SQLException {
        this.c = c;
    }

    public void insere(Venda venda) {
        String sql = "INSERT INTO venda(produtoId, quantidade, clienteId, valor, dataV, statusV) VALUES (?,?,?,?,?,?)";

        try {
            try (PreparedStatement stmt = (PreparedStatement) c.prepareStatement(sql)) {
                stmt.setInt(1, venda.getProdutoId());
                stmt.setInt(2, venda.getQuantidade());
                stmt.setInt(3, venda.getClienteId());
                stmt.setDouble(4, venda.getValorV());
                stmt.setDate(5, (Date) venda.getDataV());
                stmt.setBoolean(6, venda.isStatusV());
                stmt.execute();
                JOptionPane.showMessageDialog(null, "PRODUTO ADICIONADO À VENDA DO CLIENTE.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO. POR FAVOR TENTE NOVAMENTE.");
            System.out.println(e);
        }
    }

    public void edita(Venda venda) {
        String sql = "UPDATE venda set produtoId=?,quantidade=?, clienteId=?, valor=?, dataV=? where id=? AND statusV=?";

        try {
            try (PreparedStatement stmt = (PreparedStatement) c.prepareStatement(sql)) {
                stmt.setInt(1, venda.getProdutoId());
                stmt.setInt(2, venda.getQuantidade());
                stmt.setInt(3, venda.getClienteId());
                stmt.setDouble(4, venda.getValorV());
                stmt.setDate(5, (Date) venda.getDataV());
                stmt.setInt(6, venda.getId());
                stmt.setBoolean(7, false);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "PRODUTO ADICIONADO À VENDA DO CLIENTE.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO. POR FAVOR TENTE NOVAMENTE. ");
        }
    }

    public void verificaAddProduto(Venda venda) throws SQLException, ClassNotFoundException {
        String sql = "SELECT *FROM venda WHERE produtoId=? AND statusV=?";
        boolean verifica = false;
        try (PreparedStatement stmt = (PreparedStatement) c.prepareStatement(sql)) {
            stmt.setInt(1, venda.getProdutoId());
            stmt.setBoolean(2, false);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                verifica = true;
                int quantidade = rs.getInt("quantidade");
                venda.setQuantidade(quantidade + venda.getQuantidade());
                double valorAtual = rs.getDouble("valor");
                venda.setId(rs.getInt("id"));
                venda.setValorV(valorAtual + venda.getValorV());
                Produto produto = new Produto();
                ProdutoCrud prodCrud = new ProdutoCrud();
                produto = prodCrud.buscaProduto(venda.getProdutoId());
                if (produto.getQuantidade() >= venda.getQuantidade()) {
                    edita(venda);
                } else {
                    JOptionPane.showMessageDialog(null, "O PRODUTO NÃO POSSUI QUANTIDADE SUFICIENTE.");
                }
            }
            if (verifica == false) {
                Produto produto = new Produto();
                ProdutoCrud prodCrud = new ProdutoCrud();
                produto = prodCrud.buscaProduto(venda.getProdutoId());
                if (produto.getQuantidade() >= venda.getQuantidade()) {
                    insere(venda);
                } else {
                    JOptionPane.showMessageDialog(null, "O PRODUTO NÃO POSSUI QUANTIDADE SUFICIENTE. EXISTEM APENAS " + (Integer.parseInt(String.valueOf(produto.getQuantidade())) - Integer.parseInt(String.valueOf(venda.getQuantidade()))) + " ITENS DESSE PRODUTO.");
                }
            }
        }
    }

    public void deleta(Venda venda) {

        String sql = "DELETE FROM servico WHERE id=? ";

        try {
            try (PreparedStatement stmt = (PreparedStatement) c.prepareStatement(sql)) {
                stmt.setInt(1, venda.getId());
                stmt.execute();
                JOptionPane.showMessageDialog(null, "VENDA DELETADO COM SUCESSO.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO. POR FAVOR TENTE NOVAMENTE.");
        }
    }

    public void finalizaVendaCliente(Venda venda, List<VendaGeral> lista) throws ClassNotFoundException {
        String sql = "UPDATE venda set statusV=? where clienteId=? AND statusV=?";

        try {

            try (PreparedStatement stmt = (PreparedStatement) c.prepareStatement(sql)) {
                stmt.setBoolean(1, true);
                stmt.setInt(2, venda.getClienteId());
                stmt.setBoolean(3, false);
                stmt.executeUpdate();
                ProdutoCrud prodCrud = new ProdutoCrud();
                for(int i = 0; i < lista.size(); i++) {
                    Produto prod = new Produto();
                    prod.setId(lista.get(i).getVenda().getProdutoId());
                    prod.setQuantidade(lista.get(i).getProduto().getQuantidade() - lista.get(i).getVenda().getQuantidade());
                    prodCrud.atuaizaEstoque(prod);
                }
                JOptionPane.showMessageDialog(null, "Venda Finalizada.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO. POR FAVOR TENTE NOVAMENTE. "+e);
        }
    }

    public List<VendaGeral> buscaVendasCliente(int idCliente) {

        String sql = "SELECT *FROM venda WHERE clienteId=? AND statusV=?";
        List<VendaGeral> lista = new ArrayList<>();
        try {
            try (PreparedStatement stmt = (PreparedStatement) c.prepareStatement(sql)) {
                stmt.setInt(1, idCliente);
                stmt.setBoolean(2, false);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Produto produto = new Produto();
                    Cliente cliente = new Cliente();
                    Venda venda = new Venda();

                    venda.setClienteId(rs.getInt("clienteId"));
                    venda.setProdutoId(rs.getInt("produtoId"));
                    venda.setDataV(rs.getDate("dataV"));
                    venda.setValorV(rs.getDouble("valor"));
                    venda.setQuantidade(rs.getInt("quantidade"));

                    String sqlCliente = "SELECT *FROM cliente WHERE id=?";
                    PreparedStatement stmtCliente = (PreparedStatement) c.prepareStatement(sqlCliente);
                    stmtCliente.setInt(1, venda.getClienteId());
                    ResultSet rsCliente = stmtCliente.executeQuery();
                    while (rsCliente.next()) {
                        cliente.setId(rsCliente.getInt("id"));
                        cliente.setNome(rsCliente.getString("nome"));
                        cliente.setCpf(rsCliente.getString("cpf"));
                        cliente.setRg(rsCliente.getString("rg"));
                        cliente.setDataNascimento(rsCliente.getDate("dataNascimento"));
                        cliente.setSexo(rsCliente.getString("sexo"));
                    }

                    String sqlProduto = "SELECT *FROM produto WHERE id=?";
                    PreparedStatement stmtProduto = (PreparedStatement) c.prepareStatement(sqlProduto);
                    stmtProduto.setInt(1, venda.getProdutoId());
                    ResultSet rsProduto = stmtProduto.executeQuery();
                    while (rsProduto.next()) {
                        produto.setId(rsProduto.getInt("id"));
                        produto.setNome(rsProduto.getString("nome"));
                        produto.setQuantidade(rsProduto.getInt("quantidade"));
                        produto.setPrecoUnitario(rsProduto.getDouble("precoUnitario"));
                    }

                    VendaGeral vGeral = new VendaGeral();
                    vGeral.setCliente(cliente);
                    vGeral.setProduto(produto);
                    vGeral.setVenda(venda);
                    lista.add(vGeral);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO. POR FAVOR TENTE NOVAMENTE. " + e);
        }
        return lista;
    }

    public Collection<Servico> lista() {

        List<Servico> servicos = new ArrayList<>();

        try {

            PreparedStatement sql = c.prepareStatement("select * from servico");
            ResultSet rs = sql.executeQuery();

            while (rs.next()) {

                Servico servico = new Servico();

                servico.setId(rs.getInt("id"));
                servico.setNome(rs.getString("nome"));
                servico.setDescricao(rs.getString("descricao"));
                servico.setValor(rs.getDouble("valor"));
                servicos.add(servico);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO. POR FAVOR TENTE NOVAMENTE.");
        }
        return (servicos);
    }
}
