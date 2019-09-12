package produto;

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

public final class ListaProdutos extends javax.swing.JFrame {

    public ListaProdutos() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        tabProduto.setRowHeight(30);
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        tabProduto.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        busca();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabProduto = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        nomeProd = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabProduto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tabProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Quantidade", "Custo do Lote", "Frete Total", "Frete Unit.", "Custo Unit. ", "Custo Unit. + Frete", "Preço Unit.", "Lucro Unit.", "Lucro Lote"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1240, 220));

        jLabel2.setText("Pesquisar (nome):  ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));
        getContentPane().add(nomeProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 250, 30));

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 110, 30));

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void busca() throws SQLException {
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
                table.addRow(new Object[]{lista.get(i).getId(), lista.get(i).getNome(), lista.get(i).getQuantidade(), df.format(lista.get(i).getCustoLote()), df.format(lista.get(i).getFreteTotal()), df.format(lista.get(i).getFreteUnitario()), df.format(lista.get(i).getCustoUnitario()), df.format(lista.get(i).getCustoUnitarioComFrete()), df.format(lista.get(i).getPrecoUnitario()), df.format(lista.get(i).getLucroUnitario()), df.format(lista.get(i).getLucroLote())});
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void tabProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabProdutoMouseClicked
        if (evt.getClickCount() == 1) {
            Object id = (tabProduto.getValueAt(tabProduto.getSelectedRow(), 0));
            Object nome = (tabProduto.getValueAt(tabProduto.getSelectedRow(), 1));
            Object quantidade = (tabProduto.getValueAt(tabProduto.getSelectedRow(), 2));
            Object custoLote = (tabProduto.getValueAt(tabProduto.getSelectedRow(), 3));
            Object freteTotal = (tabProduto.getValueAt(tabProduto.getSelectedRow(), 4));
            Object freteUnit = (tabProduto.getValueAt(tabProduto.getSelectedRow(), 5));
            Object custoUnit = (tabProduto.getValueAt(tabProduto.getSelectedRow(), 6));
            Object custoUnitFrete = (tabProduto.getValueAt(tabProduto.getSelectedRow(), 7));
            Object precoUnit = (tabProduto.getValueAt(tabProduto.getSelectedRow(), 8));
            Object lucroUnit = (tabProduto.getValueAt(tabProduto.getSelectedRow(), 9));
            Object lucroLote = (tabProduto.getValueAt(tabProduto.getSelectedRow(), 10));

            EditarProduto editar = new EditarProduto(String.valueOf(id), String.valueOf(nome), String.valueOf(quantidade), String.valueOf(custoLote), String.valueOf(freteTotal), String.valueOf(freteUnit), String.valueOf(custoUnit), String.valueOf(custoUnitFrete), String.valueOf(precoUnit), String.valueOf(lucroUnit), String.valueOf(lucroLote));
            editar.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_tabProdutoMouseClicked

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
                    for(int i = 0; i < produtos.size(); i++) {
                        Produto produto = new Produto();
                        produto = produtos.get(i);
                        table.addRow(new Object[]{produto.getId(), produto.getNome(), produto.getQuantidade(), df.format(produto.getCustoLote()), df.format(produto.getFreteTotal()), df.format(produto.getFreteUnitario()), df.format(produto.getCustoUnitario()), df.format(produto.getCustoUnitarioComFrete()), df.format(produto.getPrecoUnitario()), df.format(produto.getLucroUnitario()), df.format(produto.getLucroLote())});
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            busca();
        } catch (SQLException ex) {
            Logger.getLogger(ListaProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ListaProdutos().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ListaProdutos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeProd;
    private javax.swing.JTable tabProduto;
    // End of variables declaration//GEN-END:variables
}
