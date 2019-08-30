package servico;

import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CadastroServico extends javax.swing.JFrame {

    public CadastroServico() {
        initComponents();
        this.setLocationRelativeTo(null);
        //valorServ.setDocument(new SoNumeros());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nomeServ = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        desc = new javax.swing.JTextArea();
        valorServ = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nome do Serviço:  ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel2.setText("Descrição:   ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel3.setText("Valor do Serviço:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));
        getContentPane().add(nomeServ, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 360, 30));

        desc.setColumns(20);
        desc.setRows(5);
        jScrollPane1.setViewportView(desc);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 360, -1));
        getContentPane().add(valorServ, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 160, 30));

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 160, 40));

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, 150, 40));

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
            if(verifica == false) {
                NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
                Number number1 = format.parse(valorServ.getText());
                double valor = number1.doubleValue();
                Servico servico = new Servico(nomeServ.getText(), desc.getText(), valor);
                ServicoCrud servCrud = new ServicoCrud();
                servCrud.insere(servico);
                limpaCampos();
            }
        } catch (ParseException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CadastroServico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.limpaCampos();
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    public void limpaCampos() {
        nomeServ.setText("");
        desc.setText("");
        valorServ.setText("");
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroServico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea desc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeServ;
    private javax.swing.JTextField valorServ;
    // End of variables declaration//GEN-END:variables
}
