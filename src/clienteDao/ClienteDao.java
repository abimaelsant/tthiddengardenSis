package clienteDao;

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

public class ClienteDao implements ClienteInterface{
    private Connection c;

    public ClienteDao(Connection c) throws SQLException {
        this.c = c;
    }

    @Override
    public void insere(Cliente cliente) {
        String sql = "INSERT INTO cliente(nome, cpf, rg, dataNascimento) VALUES (?,?,?,?)";

        try {
            try (PreparedStatement stmt = (PreparedStatement) c.prepareStatement(sql)) {
                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getCpf());
                stmt.setString(3, cliente.getRg());
                stmt.setDate(4, (Date) cliente.getDataNascimento());
                stmt.execute();
                JOptionPane.showMessageDialog(null, "CLIENTE CADASTRADO COM SUCESSO.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO. POR FAVOR TENTE NOVAMENTE.");
            System.out.println(e);
        }
    }

    @Override
    public void edita(Cliente cliente) {
        String sql = "UPDATE cliente set nome=?,cpf=?, rg=?, dataNascimento=? where id=?";

        try {

            try (PreparedStatement stmt = (PreparedStatement) c.prepareStatement(sql)) {
                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getCpf());
                stmt.setString(3, cliente.getRg());
                stmt.setDate(4, (Date) cliente.getDataNascimento());
                stmt.setInt(5, cliente.getId());
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "CLIENTE EDITADO COM SUCESSO.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO. POR FAVOR TENTE NOVAMENTE. " + e);
        }
    }

    @Override
    public void deleta(Cliente cliente) {

        String sql = "DELETE FROM cliente WHERE id=? ";

        try {
            try (PreparedStatement stmt = (PreparedStatement) c.prepareStatement(sql)) {
                stmt.setInt(1, cliente.getId());
                stmt.execute();
                JOptionPane.showMessageDialog(null, "CLIENTE DELETADO COM SUCESSO.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO. POR FAVOR TENTE NOVAMENTE.");
        }
    }

    @Override
    public Collection<Cliente> lista() {

        List<Cliente> clientes = new ArrayList<>();

        try {

            PreparedStatement sql = c.prepareStatement("select * from cliente");
            ResultSet rs = sql.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));
                cliente.setDataNascimento(rs.getDate("dataNascimento"));
                clientes.add(cliente);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO. POR FAVOR TENTE NOVAMENTE.");
        }
        return (clientes);
    }

    @Override
    public Cliente buscaCliente(int id) {

        Cliente cliente = new Cliente();

        try {

            PreparedStatement sql = c.prepareStatement("select from cliente WHERE id= '" + id + "'");

            ResultSet rs = sql.executeQuery();

            while (rs.next()) {

                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));
                cliente.setDataNascimento(rs.getDate("dataNascimento"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO. POR FAVOR TENTE NOVAMENTE.");
        }
        return cliente;
    }

    public Collection<Cliente> buscaClienteNome(String nome) {

        List<Cliente> clientes = new ArrayList<>();
        try {

            //PreparedStatement sql = c.prepareStatement("select from produto WHERE nome like '"+nome+"'");
            String sql = "SELECT * FROM cliente where nome like ?";
            PreparedStatement ps = this.c.prepareStatement(sql);
            ps.setString(1, "%" + nome + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));
                cliente.setDataNascimento(rs.getDate("dataNascimento"));
                clientes.add(cliente);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO. POR FAVOR TENTE NOVAMENTE.");
        }
        return clientes;
    }
    
    public Cliente buscaClienteCpf(String cpf) {
        Cliente cliente = new Cliente();
        try {
            //PreparedStatement sql = c.prepareStatement("select from produto WHERE nome like '"+nome+"'");
            String sql = "SELECT * FROM cliente where cpf like ?";
            PreparedStatement ps = this.c.prepareStatement(sql);
            ps.setString(1, "%" + cpf + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));
                cliente.setDataNascimento(rs.getDate("dataNascimento"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO. POR FAVOR TENTE NOVAMENTE.");
        }
        return cliente;
    }
    
    public Cliente buscaClienteCpfVerifica(String cpf) {
        Cliente cliente = new Cliente();
        try {
            //PreparedStatement sql = c.prepareStatement("select from produto WHERE nome like '"+nome+"'");
            String sql = "SELECT * FROM cliente where cpf like ?";
            PreparedStatement ps = this.c.prepareStatement(sql);
            ps.setString(1, "%" + cpf + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                cliente.setId(rs.getInt("id"));
                cliente.setCpf(rs.getString("cpf"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO. POR FAVOR TENTE NOVAMENTE.");
        }
        return cliente;
    }
}
