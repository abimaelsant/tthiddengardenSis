package servico;

import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EditarServico extends javax.swing.JFrame {

    public EditarServico() {
        initComponents();
    }

    public EditarServico(String Id, String nome, String descricao, String valor) {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        id.setText(Id);
        nomeServ.setText(nome);
        desc.setText(descricao);
        valorServ.setText(valor);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nomeServ = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        desc = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        valorServ = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nome do Serviço:  ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));
        getContentPane().add(nomeServ, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 360, 30));

        jLabel2.setText("Descrição:   ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, 50));

        desc.setColumns(20);
        desc.setRows(5);
        jScrollPane1.setViewportView(desc);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 360, -1));

        jLabel3.setText("Valor do Serviço:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));
        getContentPane().add(valorServ, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 160, 30));

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 160, 40));

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 150, 40));

        jLabel4.setText("Código:  ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        id.setEnabled(false);
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 60, 30));

        jButton3.setText("Deletar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, 110, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            boolean verifica = false;
            if (nomeServ.getText().isEmpty()) {
                verifica = true;
                JOptionPane.showMessageDialog(null, "O CAMPO NOME É OBRIGATÓRIO.");
            } else if (desc.getText().isEmpty()) {
                verifica = true;
                JOptionPane.showMessageDialog(null, "O CAMPO DESCRIÇÃO É OBRIGATÓRIO.");
            } else if (valorServ.getText().isEmpty()) {
                verifica = true;
                JOptionPane.showMessageDialog(null, "O CAMPO VALOR É OBRIGATÓRIO.");
            }
            if (verifica == false) {
                NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
                Number number1 = format.parse(valorServ.getText());
                double valor = number1.doubleValue();
                Servico servico = new Servico(nomeServ.getText(), desc.getText(), valor);
                ServicoCrud servCrud = new ServicoCrud();
                servico.setId(Integer.parseInt(id.getText()));
                servCrud.edita(servico);
                this.dispose();
                ListaServicos lServicos = new ListaServicos();
                lServicos.setVisible(true);
            }
        } catch (ParseException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ListaServicos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            this.dispose();
            ListaServicos lServicos = new ListaServicos();
            lServicos.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(EditarServico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            int input = JOptionPane.showConfirmDialog(null, "TEM CERTEZA QUE DESEJA DELETAR O SERVIÇO?");
            if (input == 0) {
                Servico serv = new Servico();
                serv.setId(Integer.parseInt(id.getText()));
                ServicoCrud servCrud = new ServicoCrud();
                servCrud.deleta(serv);
                this.dispose();
                ListaServicos lServicos = new ListaServicos();
                lServicos.setVisible(true);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(EditarServico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarServico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea desc;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeServ;
    private javax.swing.JTextField valorServ;
    // End of variables declaration//GEN-END:variables
}
