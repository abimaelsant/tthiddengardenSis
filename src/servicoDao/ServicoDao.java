package servicoDao;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JOptionPane;
import servico.Servico;

public class ServicoDao {
    private Connection c;

    public ServicoDao(Connection c) throws SQLException {
        this.c = c;
    }

    public void insere(Servico servico) {
        String sql = "INSERT INTO servico(nome, descricao, valor) VALUES (?,?,?)";

        try {
            try (PreparedStatement stmt = (PreparedStatement) c.prepareStatement(sql)) {
                stmt.setString(1, servico.getNome());
                stmt.setString(2, servico.getDescricao());
                stmt.setDouble(3, servico.getValor());
                stmt.execute();
                JOptionPane.showMessageDialog(null, "SERVIÇO CADASTRADO COM SUCESSO.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO. POR FAVOR TENTE NOVAMENTE.");
            System.out.println(e);
        }
    }

    public void edita(Servico servico) {
        String sql = "UPDATE servico set nome=?,descricao=?, valor=? where id=?";

        try {

            try (PreparedStatement stmt = (PreparedStatement) c.prepareStatement(sql)) {
                stmt.setString(1, servico.getNome());
                stmt.setString(2, servico.getDescricao());
                stmt.setDouble(3, servico.getValor());
                stmt.setInt(4, servico.getId());
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "SERVIÇO EDITADO COM SUCESSO.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO. POR FAVOR TENTE NOVAMENTE. " + e);
        }
    }

    public void deleta(Servico servico) {

        String sql = "DELETE FROM servico WHERE id=? ";

        try {
            try (PreparedStatement stmt = (PreparedStatement) c.prepareStatement(sql)) {
                stmt.setInt(1, servico.getId());
                stmt.execute();
                JOptionPane.showMessageDialog(null, "SERVIÇO DELETADO COM SUCESSO.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO. POR FAVOR TENTE NOVAMENTE.");
        }
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

    public Servico buscaServico(int id) {

        Servico servico = new Servico();

        try {

            PreparedStatement sql = c.prepareStatement("select from servico WHERE id= '" + id + "'");

            ResultSet rs = sql.executeQuery();

            while (rs.next()) {

                servico.setId(rs.getInt("id"));
                servico.setNome(rs.getString("nome"));
                servico.setDescricao(rs.getString("descricao"));
                servico.setValor(rs.getDouble("valor"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO. POR FAVOR TENTE NOVAMENTE.");
        }
        return servico;
    }
}
