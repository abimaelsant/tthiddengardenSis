package cliente;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ListaClientes extends javax.swing.JFrame {

    public ListaClientes() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        tabCliente.setRowHeight(30);
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        tabCliente.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        tabCliente.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        tabCliente.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        tabCliente.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        tabCliente.getColumnModel().getColumn(5).setCellRenderer(centralizado);
        lista();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabCliente = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        nomeCli = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        cpf = new javax.swing.JFormattedTextField();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CPF", "RG", "Data de Nascimento", "Sexo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabCliente);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 710, 340));

        jLabel1.setText("Pesquisa por nome:  ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));
        getContentPane().add(nomeCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 290, 30));

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, -1, -1));

        jLabel2.setText("Pesquisar por CPF:  ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jButton2.setText("Pesquisar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, -1, -1));

        try {
            cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 290, 30));

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if (!nomeCli.getText().isEmpty()) {
                ArrayList<Cliente> clientes = new ArrayList<>();
                ClienteCrud cliCrud = new ClienteCrud();
                clientes = (ArrayList<Cliente>) cliCrud.buscaNome(nomeCli.getText());

                if (clientes.size() > 0) {
                    DefaultTableModel table;
                    table = (DefaultTableModel) tabCliente.getModel();
                    ((DefaultTableModel) tabCliente.getModel()).setNumRows(0);
                    tabCliente.updateUI();
                    for (int i = 0; i < clientes.size(); i++) {
                        Cliente cliente = new Cliente();
                        table.addRow(new Object[]{clientes.get(i).getId(), clientes.get(i).getNome(), insereMascaraCpf(clientes.get(i).getCpf()), clientes.get(i).getRg(), formataData(clientes.get(i).getDataNascimento()), clientes.get(i).getSexo()});
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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            if (!cpf.getText().isEmpty()) {
                Cliente cliente = new Cliente();
                ClienteCrud cliCrud = new ClienteCrud();
                cliente = cliCrud.buscaCpf(cliente.retiraMascaraCpf(cpf.getText()));

                if (cliente.getCpf() != null) {
                    DefaultTableModel table;
                    table = (DefaultTableModel) tabCliente.getModel();
                    ((DefaultTableModel) tabCliente.getModel()).setNumRows(0);
                    tabCliente.updateUI();
                    table.addRow(new Object[]{cliente.getId(), cliente.getNome(), insereMascaraCpf(cliente.getCpf()), cliente.getRg(), formataData(cliente.getDataNascimento()), cliente.getSexo()});

                } else {
                    JOptionPane.showMessageDialog(null, "NENHUM DADO ENCONTRADO.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "DIGITE O CPF DE UM CLIENTE PARA PESQUISAR.");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ListaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            lista();
        } catch (SQLException ex) {
            Logger.getLogger(ListaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tabClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabClienteMouseClicked
        if (evt.getClickCount() == 1) {
            Object id = (tabCliente.getValueAt(tabCliente.getSelectedRow(), 0));
            Object nome = (tabCliente.getValueAt(tabCliente.getSelectedRow(), 1));
            Object Cpf = (tabCliente.getValueAt(tabCliente.getSelectedRow(), 2));
            Object Rg = (tabCliente.getValueAt(tabCliente.getSelectedRow(), 3));
            Object dataNascimento = (tabCliente.getValueAt(tabCliente.getSelectedRow(), 4));
            Object Sexo = (tabCliente.getValueAt(tabCliente.getSelectedRow(), 5));
            EditarCliente editar = new EditarCliente(String.valueOf(id), String.valueOf(nome), String.valueOf(Cpf), String.valueOf(Rg), String.valueOf(dataNascimento), String.valueOf(Sexo));
            editar.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_tabClienteMouseClicked

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

    public String acrescentaZero(int val) {
        if (val < 10) {
            return String.valueOf("0" + val);
        } else {
            return String.valueOf(val);
        }
    }

    public String formataData(Date data) {
        String dat = data.toString();
        String[] d = dat.split("-");
        dat = d[2] + '/' + d[1] + "/" + d[0];
        return dat;
    }

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
                table.addRow(new Object[]{lista.get(i).getId(), lista.get(i).getNome(), insereMascaraCpf(lista.get(i).getCpf()), lista.get(i).getRg(), formataData(lista.get(i).getDataNascimento()), lista.get(i).getSexo()});
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ListaClientes().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ListaClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField cpf;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeCli;
    private javax.swing.JTable tabCliente;
    // End of variables declaration//GEN-END:variables
}
