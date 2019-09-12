package venda;

import cliente.Cliente;
import cliente.ListaClientes;
import java.awt.event.WindowAdapter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import produto.Produto;

public class VendaCliente extends javax.swing.JFrame {
    int clienteId, verifica = 0;
    List<VendaGeral> listaVendas = new ArrayList<>();
    
    public VendaCliente() {
        initComponents();
    }
    
    public VendaCliente(int Id) throws SQLException, ClassNotFoundException {
        initComponents();
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        clienteId = Id;
        tabCliente.setRowHeight(30);
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        tabCliente.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        tabCliente.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        tabCliente.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        tabCliente.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        tabCliente.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        buscaVendasCliente(Id);
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
    
    public final void buscaVendasCliente(int id) throws SQLException, ClassNotFoundException {
        try {
                ArrayList<VendaGeral> vendas = new ArrayList<>();
                VendaCrud vendaCrud = new VendaCrud();
                vendas = (ArrayList<VendaGeral>) vendaCrud.buscaVendasCliente(id);
                this.listaVendas = vendas;
                if (vendas.size() > 0) {
                    DefaultTableModel table;
                    table = (DefaultTableModel) tabCliente.getModel();
                    ((DefaultTableModel) tabCliente.getModel()).setNumRows(0);
                    tabCliente.updateUI();
                    for (int i = 0; i < vendas.size(); i++) {
                        Cliente cliente = new Cliente();
                        Produto produto = new Produto();
                        Venda venda = new Venda();
                        cliente = vendas.get(i).getCliente();
                        produto = vendas.get(i).getProduto();
                        venda = vendas.get(i).getVenda();
                        table.addRow(new Object[]{cliente.getNome(), insereMascaraCpf(cliente.getCpf()), produto.getNome(), venda.getValorV(), venda.getQuantidade()});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "NENHUM DADO ENCONTRADO.");
                }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ListaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabCliente = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "CPF", "Produto", "Valor", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabCliente);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 680, 340));

        jButton1.setText("Finalizar a Venda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 240, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Venda venda = new Venda();
            venda.setClienteId(clienteId);
            VendaCrud vendaCrud = new VendaCrud();
            vendaCrud.finalizaVendaCliente(venda, listaVendas);
            this.dispose();
            RealizaVenda rVenda = new RealizaVenda();
            rVenda.setVisible(true);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(VendaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VendaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabCliente;
    // End of variables declaration//GEN-END:variables
}
