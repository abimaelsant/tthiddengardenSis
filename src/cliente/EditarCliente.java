package cliente;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import javax.swing.JOptionPane;

public class EditarCliente extends javax.swing.JFrame {

    public EditarCliente() {
        initComponents();
    }

    public EditarCliente(String Id, String nome, String Cpf, String Rg, String data) {
        initComponents();
        this.setLocationRelativeTo(null);
        id.setText(Id);
        nomecli.setText(nome);
        cpf.setText(Cpf);
        rg.setText(Rg);
        dataNasc.setText(data);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        nomecli = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cpf = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        rg = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dataNasc = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        id = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Nome:   ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));
        getContentPane().add(nomecli, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 340, 30));

        jLabel4.setText("CPF:    ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        try {
            cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfActionPerformed(evt);
            }
        });
        getContentPane().add(cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 210, 30));

        jLabel5.setText("RG:     ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));
        getContentPane().add(rg, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 210, 30));

        jLabel6.setText("Data de Nasc.");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        try {
            dataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dataNasc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dataNascKeyPressed(evt);
            }
        });
        getContentPane().add(dataNasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 210, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        jButton1.setText("Salvar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 300, 140, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancel.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 150, -1));

        id.setEnabled(false);
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 50, 30));

        jLabel1.setText("Código:  ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Deletar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 120, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfActionPerformed

    }//GEN-LAST:event_cpfActionPerformed

    private static int validarCPF(String cpf, boolean inicio) {

        if (cpf.matches("\\d{11}")) {
            boolean excecao = IntStream.range(0, 9).boxed().filter(num -> (((11111111111L * num) + "").equals(cpf))).findFirst().orElse(-1) != -1;
            int soma = 0, peso = inicio ? 10 : 11;
            //somando os digitos por um peso decrescente
            for (int i = 0; i < (inicio ? 9 : 10); i++) {
                soma += Integer.parseInt(cpf.charAt(i) + "") * peso--;
            }
            //calculando o resto
            peso = soma * 10 % 11 == 10 ? 0 : soma * 10 % 11;
            //se inicio = true a validação ocorre no index 9 do array, se não no index 11
            return excecao || !(peso + "").equals(cpf.charAt(inicio ? 9 : 10) + "") ? 0 : inicio ? validarCPF(cpf, false) : 1;
        } else {
            return 3;
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        salva();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            this.dispose();
            ListaClientes lClientes = new ListaClientes();
            lClientes.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(EditarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            int input = JOptionPane.showConfirmDialog(null, "TEM CERTEZA QUE DESEJA DELETAR O CLIENTE?");
            if (input == 0) {
                Cliente cliente = new Cliente();
                cliente.setId(Integer.parseInt(id.getText()));
                ClienteCrud cliCrud = new ClienteCrud();
                cliCrud.deleta(cliente);
                this.dispose();
                ListaClientes lClientes = new ListaClientes();
                lClientes.setVisible(true);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(EditarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered

    }//GEN-LAST:event_jButton1MouseEntered

    public void salva() {
        boolean verifica = false;
        if (nomecli.getText().isEmpty()) {
            verifica = true;
            JOptionPane.showMessageDialog(null, "O CAMPO NOME É OBRIGATÓRIO.");
        } else if (cpf.getText().isEmpty()) {
            verifica = true;
            JOptionPane.showMessageDialog(null, "O CAMPO CPF É OBRIGATÓRIO.");
        } else if (rg.getText().isEmpty()) {
            verifica = true;
            JOptionPane.showMessageDialog(null, "O CAMPO RG É OBRIGATÓRIO.");
        } else if (dataNasc.getText().isEmpty()) {
            verifica = true;
            JOptionPane.showMessageDialog(null, "O CAMPO DATA DE NASCIMENTO É OBRIGATÓRIO.");
        }
        if (verifica == false) {
            try {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date data = new java.sql.Date(format.parse(dataNasc.getText()).getTime());
                Cliente cliente = new Cliente(nomecli.getText(), cpf.getText(), rg.getText(), data);
                if (validarCPF(cliente.retiraMascaraCpf(cliente.getCpf()), true) == 1) {
                    if (cliente.verificaIdade(data)) {
                        ClienteCrud cliCrud = new ClienteCrud();
                        if (!cliCrud.buscaCpfVerificaEdita(cliente.retiraMascaraCpf(cliente.getCpf()), Integer.parseInt(id.getText()))) {
                            cliente.setCpf(cliente.retiraMascaraCpf(cliente.getCpf()));
                            cliente.setId(Integer.parseInt(id.getText()));
                            cliCrud.edita(cliente);
                            this.dispose();
                            ListaClientes lClientes = new ListaClientes();
                            lClientes.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "CPF JÁ CADASTRADO NO SISTEMA.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "O CLIENTE POSSUI IDADE MENOR QUE 18 ANOS.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "CPF INVÁLIDO.");
                }
            } catch (ParseException | SQLException | ClassNotFoundException ex) {
                Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            salva();
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void dataNascKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dataNascKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            salva();
        }
    }//GEN-LAST:event_dataNascKeyPressed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField cpf;
    private javax.swing.JFormattedTextField dataNasc;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField nomecli;
    private javax.swing.JTextField rg;
    // End of variables declaration//GEN-END:variables
}
