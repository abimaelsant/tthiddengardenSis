package venda;

import cliente.Cliente;
import cliente.ClienteCrud;
import cliente.ListaClientes;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import produto.ListaProdutos;
import produto.Produto;
import produto.ProdutoCrud;

public class RealizaVenda extends javax.swing.JFrame {

    public RealizaVenda() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        tabCliente.setRowHeight(30);
        tabProduto.setRowHeight(30);
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        tabCliente.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        tabCliente.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        tabCliente.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        tabProduto.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        tabProduto.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        tabProduto.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        busca();
        lista();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jFrame1 = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabProduto = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabCliente = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        rg = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nomeProd = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        codigoProd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        quantidade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        nomeCli = new javax.swing.JTextField();
        valorV = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        codCli = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        nomeCli1 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Quantidade", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabProduto);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 490, 310));

        tabCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód.", "Nome", "CPF", "RG"
            }
        ));
        tabCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabClienteMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabCliente);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 300, 650, 310));

        jLabel3.setText("Pesquisar por RG:  ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, -1, -1));

        jButton2.setText("Pesquisar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 180, -1, -1));

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 180, -1, -1));

        rg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rgActionPerformed(evt);
            }
        });
        getContentPane().add(rg, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, 200, 30));

        jLabel4.setText("Pesquisar (nome):  ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));
        getContentPane().add(nomeProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 200, 30));

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 90, 30));

        jButton4.setText("Cancelar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, 80, -1));

        jLabel1.setText("Código:  ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        codigoProd.setEnabled(false);
        getContentPane().add(codigoProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 70, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Quantidade:  ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        quantidade.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                quantidadePropertyChange(evt);
            }
        });
        quantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantidadeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                quantidadeKeyTyped(evt);
            }
        });
        getContentPane().add(quantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 160, 30));

        jLabel5.setText("Cliente:   ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, -1));

        nomeCli.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nomeCli.setEnabled(false);
        getContentPane().add(nomeCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 380, 30));
        getContentPane().add(valorV, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 160, 50));

        jLabel6.setText("Valor:  ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, -1, -1));

        jButton5.setText("Adicionar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 80, 110, 40));

        codCli.setEnabled(false);
        codCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codCliActionPerformed(evt);
            }
        });
        getContentPane().add(codCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 20, -1));

        jButton6.setText("Buscar dados da Venda");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 180, -1, -1));
        getContentPane().add(nomeCli1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 240, 290, 30));

        jButton7.setText("Pesquisar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 240, -1, -1));

        jLabel7.setText("Nome Cli. ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public final void busca() throws SQLException {
        try {
            ProdutoCrud prodCrud = new ProdutoCrud();
            List<Produto> lista;

            DefaultTableModel table;
            table = (DefaultTableModel) tabProduto.getModel();
            ((DefaultTableModel) tabProduto.getModel()).setNumRows(0);
            tabProduto.updateUI();

            lista = (ArrayList<Produto>) prodCrud.lista();
            DecimalFormat df = new DecimalFormat("###,##0.00");
            for (int i = 0; i < lista.size(); i++) {
                table.addRow(new Object[]{lista.get(i).getId(), lista.get(i).getNome(), lista.get(i).getQuantidade(), df.format(lista.get(i).getPrecoUnitario())});
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String insereMascaraCpf(String cpf) {
        String c2 = "";
        for (int i = 0; i < cpf.length(); i++) {
            c2 += cpf.charAt(i);
            if (i == 2 || i == 5) {
                c2 += ".";
            }
            if (i == 8) {
                c2 += "-";
            }
        }
        return c2;
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            if (!rg.getText().isEmpty()) {
                Cliente cliente = new Cliente();
                ClienteCrud cliCrud = new ClienteCrud();
                cliente = cliCrud.buscaRg(rg.getText());

                if (cliente.getCpf() != null) {
                    DefaultTableModel table;
                    table = (DefaultTableModel) tabCliente.getModel();
                    ((DefaultTableModel) tabCliente.getModel()).setNumRows(0);
                    tabCliente.updateUI();
                    table.addRow(new Object[]{cliente.getId(), cliente.getNome(), insereMascaraCpf(cliente.getCpf()), cliente.getRg()});

                } else {
                    JOptionPane.showMessageDialog(null, "NENHUM DADO ENCONTRADO.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "DIGITE O CPF DE UM CLIENTE PARA PESQUISAR.");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(RealizaVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public final void lista() throws SQLException {
        try {
            ClienteCrud cliCrud = new ClienteCrud();
            List<Cliente> lista;

            DefaultTableModel table;
            table = (DefaultTableModel) tabCliente.getModel();
            ((DefaultTableModel) tabCliente.getModel()).setNumRows(0);
            tabCliente.updateUI();

            lista = (ArrayList<Cliente>) cliCrud.lista();
            for (int i = 0; i < lista.size(); i++) {
                table.addRow(new Object[]{lista.get(i).getId(), lista.get(i).getNome(), insereMascaraCpf(lista.get(i).getCpf()), lista.get(i).getRg()});
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            lista();
        } catch (SQLException ex) {
            Logger.getLogger(RealizaVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if (!nomeProd.getText().isEmpty()) {
                ArrayList<Produto> produtos = new ArrayList<>();
                ProdutoCrud prodCrud = new ProdutoCrud();
                produtos = (ArrayList<Produto>) prodCrud.buscaNome(nomeProd.getText());

                DecimalFormat df = new DecimalFormat("###,##0.00");
                if (produtos.size() > 0) {
                    DefaultTableModel table;
                    table = (DefaultTableModel) tabProduto.getModel();
                    ((DefaultTableModel) tabProduto.getModel()).setNumRows(0);
                    tabProduto.updateUI();
                    for (int i = 0; i < produtos.size(); i++) {
                        Produto produto = new Produto();
                        produto = produtos.get(i);
                        table.addRow(new Object[]{produto.getId(), produto.getNome(), produto.getQuantidade(), df.format(produto.getPrecoUnitario())});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "NENHUM DADO ENCONTRADO.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "DIGITE O NOME DE UM PRODUTO PARA PESQUISAR.");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ListaProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            busca();
        } catch (SQLException ex) {
            Logger.getLogger(ListaProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tabProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabProdutoMouseClicked
        if (evt.getClickCount() == 1) {
            quantidade.setText("");
            valorV.setText("");
            Object id = (tabProduto.getValueAt(tabProduto.getSelectedRow(), 0));
            codigoProd.setText(String.valueOf(id));
        }
    }//GEN-LAST:event_tabProdutoMouseClicked

    private void codCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codCliActionPerformed

    private void tabClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabClienteMouseClicked
        if (evt.getClickCount() == 1) {
            Object id = (tabCliente.getValueAt(tabCliente.getSelectedRow(), 0));
            Object nome = (tabCliente.getValueAt(tabCliente.getSelectedRow(), 1));
            Object Rg = (tabCliente.getValueAt(tabCliente.getSelectedRow(), 3));
            codCli.setText(String.valueOf(id));
            nomeCli.setText(String.valueOf(nome));
            rg.setText(String.valueOf(Rg));
        }
    }//GEN-LAST:event_tabClienteMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (codigoProd.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O CÓDIGO DO PRODUTO É OBRIGATÓRIO.");
        } else if (quantidade.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "A QUANTIDADE DO PRODUTO É OBRIGATÓRIO.");
        } else if (codCli.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O CÓDIGO DO CLIENTE É OBRIGATÓRIO.");
        } else if (valorV.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O VALOR DA VENDA É OBRIGATÓRIO.");
        } else {
            try {
                Venda venda = new Venda(Integer.parseInt(codigoProd.getText()), Integer.parseInt(quantidade.getText()), Integer.parseInt(codCli.getText()), Double.parseDouble(valorV.getText()), false);
                VendaCrud vCrud = new VendaCrud();
                vCrud.insere(venda);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(RealizaVenda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void quantidadePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_quantidadePropertyChange

    }//GEN-LAST:event_quantidadePropertyChange

    private void quantidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantidadeKeyReleased
        try {
            Produto prod = new Produto();
            ProdutoCrud prodCrud = new ProdutoCrud();
            int idProd = Integer.parseInt(codigoProd.getText());
            prod = prodCrud.buscaProduto(idProd);
            double valor = Integer.parseInt(quantidade.getText()) * prod.getPrecoUnitario();
            valorV.setText(String.valueOf(valor));
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(RealizaVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_quantidadeKeyReleased

    private void quantidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantidadeKeyTyped

    }//GEN-LAST:event_quantidadeKeyTyped

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (!rg.getText().isEmpty()) {
            try {
                Cliente cliente = new Cliente();
                ClienteCrud cliCrud = new ClienteCrud();
                cliente = cliCrud.buscaRg(rg.getText());
                if(cliente.getCpf() != null) {
                    VendaCliente vCliente = new VendaCliente(cliente.getId());
                    vCliente.setVisible(true);
                    this.dispose();
                } else JOptionPane.showMessageDialog(null, "CLIENTE NÃO ENCONTRADO.");
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(RealizaVenda.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else JOptionPane.showMessageDialog(null, "RG INVÁLIDO.");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            if (!nomeCli1.getText().isEmpty()) {
                ArrayList<Cliente> clientes = new ArrayList<>();
                ClienteCrud cliCrud = new ClienteCrud();
                clientes = (ArrayList<Cliente>) cliCrud.buscaNome(nomeCli1.getText());

                if (clientes.size() > 0) {
                    DefaultTableModel table;
                    table = (DefaultTableModel) tabCliente.getModel();
                    ((DefaultTableModel) tabCliente.getModel()).setNumRows(0);
                    tabCliente.updateUI();
                    for (int i = 0; i < clientes.size(); i++) {
                        Cliente cliente = new Cliente();
                        table.addRow(new Object[]{clientes.get(i).getId(), clientes.get(i).getNome(), insereMascaraCpf(clientes.get(i).getCpf()), clientes.get(i).getRg()});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "NENHUM DADO ENCONTRADO.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "DIGITE O NOME DE UM CLIENTE PARA PESQUISAR.");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ListaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void rgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rgActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new RealizaVenda().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(RealizaVenda.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codCli;
    private javax.swing.JTextField codigoProd;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField nomeCli;
    private javax.swing.JTextField nomeCli1;
    private javax.swing.JTextField nomeProd;
    private javax.swing.JTextField quantidade;
    private javax.swing.JTextField rg;
    private javax.swing.JTable tabCliente;
    private javax.swing.JTable tabProduto;
    private javax.swing.JTextField valorV;
    // End of variables declaration//GEN-END:variables
}
