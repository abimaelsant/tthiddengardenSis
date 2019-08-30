package servico;

import cliente.EditarCliente;
import cliente.ListaClientes;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ListaServicos extends javax.swing.JFrame {

    public ListaServicos() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        tabServico.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabServico.setRowHeight(50);
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        tabServico.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        lista();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabServico = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabServico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Descrição", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabServico.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabServico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabServicoMouseClicked(evt);
            }
        });
        tabServico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabServicoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabServico);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 680, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabServicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabServicoKeyPressed
        
    }//GEN-LAST:event_tabServicoKeyPressed

    private void tabServicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabServicoMouseClicked
        if (evt.getClickCount() == 1) {
            Object id = (tabServico.getValueAt(tabServico.getSelectedRow(), 0));
            Object nome = (tabServico.getValueAt(tabServico.getSelectedRow(), 1));
            Object descricao = (tabServico.getValueAt(tabServico.getSelectedRow(), 2));
            Object valor = (tabServico.getValueAt(tabServico.getSelectedRow(), 3));
            EditarServico editar = new EditarServico(id.toString(), nome.toString(), descricao.toString(), valor.toString());
            editar.setVisible(true);
            this.dispose();
        }
        if (evt.getClickCount() == 2) {
            Object descricao = (tabServico.getValueAt(tabServico.getSelectedRow(), 2));
            JOptionPane.showMessageDialog(null, "\nDescrição: \n"+descricao.toString());
        }
    }//GEN-LAST:event_tabServicoMouseClicked
    
    public final void lista() throws SQLException {
        try {
            ServicoCrud servCrud = new ServicoCrud();
            List<Servico> lista;

            DefaultTableModel table;
            table = (DefaultTableModel) tabServico.getModel();
            ((DefaultTableModel) tabServico.getModel()).setNumRows(0);
            tabServico.updateUI();

            lista = (ArrayList<Servico>) servCrud.lista();
            DecimalFormat df = new DecimalFormat("###,##0.00");
            for (int i = 0; i < lista.size(); i++) {
                table.addRow(new Object[]{lista.get(i).getId(), lista.get(i).getNome(), lista.get(i).getDescricao(), df.format(lista.get(i).getValor())});
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ListaServicos().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ListaServicos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabServico;
    // End of variables declaration//GEN-END:variables
}
