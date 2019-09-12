package produto;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CadastroProduto extends javax.swing.JFrame {

    public CadastroProduto() {
        initComponents();
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        quantidade.setDocument(new SoNumeros());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nomeProd = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        custoLote = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        freteTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        freteUnitario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        custoUnitario = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        custoUnitFrete = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        precoUnitario = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        lucroUnitario = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        lucroLote = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        quantidade = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cadastroproduto.png"))); // NOI18N
        jLabel1.setText("Cadastro de Produtos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Nome:   ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));
        getContentPane().add(nomeProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 270, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Quant. Estoq: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Custo Lote: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));
        getContentPane().add(custoLote, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 80, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Frete Total:  ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));
        getContentPane().add(freteTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 80, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Frete Unitário:  ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, -1, -1));

        freteUnitario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                freteUnitarioFocusLost(evt);
            }
        });
        getContentPane().add(freteUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 90, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Custo Unitário:  ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        custoUnitario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                custoUnitarioFocusLost(evt);
            }
        });
        custoUnitario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                custoUnitarioMouseExited(evt);
            }
        });
        custoUnitario.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                custoUnitarioPropertyChange(evt);
            }
        });
        getContentPane().add(custoUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 80, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Custo Unit. + Frete:  ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, -1, -1));
        getContentPane().add(custoUnitFrete, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 90, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Preço Unitário:   ");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        precoUnitario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                precoUnitarioFocusLost(evt);
            }
        });
        precoUnitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                precoUnitarioKeyPressed(evt);
            }
        });
        getContentPane().add(precoUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 80, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Lucro Unitário:  ");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, -1, -1));

        lucroUnitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lucroUnitarioKeyPressed(evt);
            }
        });
        getContentPane().add(lucroUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 90, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Lucro Lote:  ");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, -1, -1));

        lucroLote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lucroLoteKeyPressed(evt);
            }
        });
        getContentPane().add(lucroLote, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, 90, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        jButton1.setText("Salvar");
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
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 160, 40));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancel.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 160, 40));
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, 70, 30));
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 310, 20, 10));
        getContentPane().add(quantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 80, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Código:   ");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        id.setEditable(false);
        id.setEnabled(false);
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 80, 30));

        jMenu1.setText("Produtos");

        jMenuItem1.setText("Cadastro de Pro");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

       salva();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void salva() {
        boolean verifica = false;
        if (nomeProd.getText().isEmpty()) {
            verifica = true;
            JOptionPane.showMessageDialog(null, "O CAMPO NOME É OBRIGATÓRIO.");
        } else if (quantidade.getText().isEmpty()) {
            verifica = true;
            JOptionPane.showMessageDialog(null, "O CAMPO QUANTIDADE É OBRIGATÓRIO.");
        } else if (custoLote.getText().isEmpty()) {
            verifica = true;
            JOptionPane.showMessageDialog(null, "O CAMPO CUSTO LOTE É OBRIGATÓRIO.");
        } else if (freteTotal.getText().isEmpty()) {
            verifica = true;
            JOptionPane.showMessageDialog(null, "O CAMPO FRETE TOTAL É OBRIGATÓRIO.");
        } else if (freteUnitario.getText().isEmpty()) {
            verifica = true;
            JOptionPane.showMessageDialog(null, "O CAMPO FRETE UNITÁRIO É OBRIGATÓRIO.");
        } else if (custoUnitario.getText().isEmpty()) {
            verifica = true;
            JOptionPane.showMessageDialog(null, "O CAMPO CUSTO UNITÁRIO É OBRIGATÓRIO.");
        } else if (custoUnitFrete.getText().isEmpty()) {
            verifica = true;
            JOptionPane.showMessageDialog(null, "O CAMPO CUSTO COM FRETE É OBRIGATÓRIO.");
        } else if (precoUnitario.getText().isEmpty()) {
            verifica = true;
            JOptionPane.showMessageDialog(null, "O CAMPO PREÇO UNITÁRIO É OBRIGATÓRIO.");
        } else if (lucroUnitario.getText().isEmpty()) {
            verifica = true;
            JOptionPane.showMessageDialog(null, "O CAMPO LUCRO UNITÁRIO É OBRIGATÓRIO.");
        } else if (lucroLote.getText().isEmpty()) {
            verifica = true;
            JOptionPane.showMessageDialog(null, "O CAMPO LUCRO LOTE É OBRIGATÓRIO.");
        }
        if (verifica == false) {
            try {
                NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
                Number number1 = format.parse(custoLote.getText());
                double custoLot = number1.doubleValue();
                //-----------------------------------------------------------
                Number number2 = format.parse(freteTotal.getText());
                double freteTot = number2.doubleValue();
                //-----------------------------------------------------------
                Number number3 = format.parse(freteUnitario.getText());
                double freteUnitar = number3.doubleValue();
                //-----------------------------------------------------------
                Number number4 = format.parse(custoUnitario.getText());
                double custoUnit = number4.doubleValue();
                //-----------------------------------------------------------
                Number number5 = format.parse(custoUnitFrete.getText());
                double custoUniF = number5.doubleValue();
                //-----------------------------------------------------------
                Number number6 = format.parse(precoUnitario.getText());
                double precoUni = number6.doubleValue();
                //-----------------------------------------------------------
                Number number7 = format.parse(lucroUnitario.getText());
                double lucroUni = number7.doubleValue();
                //-----------------------------------------------------------
                Number number8 = format.parse(lucroLote.getText());
                double lucroLot = number8.doubleValue();

                Produto produto = new Produto(nomeProd.getText(), Integer.parseInt(quantidade.getText()), custoLot, freteTot, freteUnitar, custoUnit, custoUniF, precoUni, lucroUni, lucroLot);
                ProdutoCrud prodCrud = new ProdutoCrud();
                prodCrud.insere(produto);
                this.limpaCampos();
            } catch (ParseException | SQLException | ClassNotFoundException ex) {
                Logger.getLogger(CadastroProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void custoUnitarioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_custoUnitarioPropertyChange

    }//GEN-LAST:event_custoUnitarioPropertyChange

    private void custoUnitarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_custoUnitarioMouseExited

    }//GEN-LAST:event_custoUnitarioMouseExited

    private void custoUnitarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_custoUnitarioFocusLost
        try {
            NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
            Number numero1 = format.parse(freteUnitario.getText());
            double freteUnitar = numero1.doubleValue();

            Number number2 = format.parse(custoUnitario.getText());
            double custoUnit = number2.doubleValue();
            double valor = freteUnitar + custoUnit;
            DecimalFormat df = new DecimalFormat("###,##0.00");
            custoUnitFrete.setText(String.valueOf(df.format(valor)));
        } catch (ParseException ex) {
            Logger.getLogger(CadastroProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_custoUnitarioFocusLost

    private void freteUnitarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_freteUnitarioFocusLost
        try {
            NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
            Number numero1 = format.parse(freteUnitario.getText());
            double freteUnitar = numero1.doubleValue();

            Number number2 = format.parse(custoUnitario.getText());
            double custoUnit = number2.doubleValue();
            double valor = freteUnitar + custoUnit;
            DecimalFormat df = new DecimalFormat("###,##0.00");
            custoUnitFrete.setText(String.valueOf(df.format(valor)));
        } catch (ParseException ex) {
            Logger.getLogger(CadastroProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_freteUnitarioFocusLost

    private void precoUnitarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_precoUnitarioFocusLost
        try {
            NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
            Number numero1 = format.parse(precoUnitario.getText());
            double precoUnitar = numero1.doubleValue();

            Number numero2 = format.parse(custoUnitFrete.getText());
            double custoUnitF = numero2.doubleValue();

            double valor = precoUnitar - custoUnitF;
            DecimalFormat df = new DecimalFormat("###,##0.00");
            lucroUnitario.setText(String.valueOf(df.format(valor)));
            
            Number numero3 = format.parse(custoLote.getText());
            double custoLot = numero3.doubleValue();
            
            double valorLucroLote = Integer.parseInt(quantidade.getText()) * precoUnitar;
            
            Number numero4 = format.parse(freteTotal.getText());
            double freteTot = numero4.doubleValue();
            
            double v = valorLucroLote - (custoLot + freteTot);
            
            lucroLote.setText(String.valueOf(df.format(v)));
        } catch (ParseException ex) {
            Logger.getLogger(CadastroProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_precoUnitarioFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.limpaCampos();
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void precoUnitarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precoUnitarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            salva();
        }
    }//GEN-LAST:event_precoUnitarioKeyPressed

    private void lucroUnitarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lucroUnitarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            salva();
        }
    }//GEN-LAST:event_lucroUnitarioKeyPressed

    private void lucroLoteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lucroLoteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            salva();
        }
    }//GEN-LAST:event_lucroLoteKeyPressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            salva();
        }
    }//GEN-LAST:event_jButton1KeyPressed

    public void limpaCampos() {
        nomeProd.setText("");
        quantidade.setText("");
        custoLote.setText("");
        freteTotal.setText("");
        freteUnitario.setText("");
        custoUnitario.setText("");
        custoUnitFrete.setText("");
        precoUnitario.setText("");
        lucroUnitario.setText("");
        lucroLote.setText("");
    }

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField custoLote;
    private javax.swing.JTextField custoUnitFrete;
    private javax.swing.JTextField custoUnitario;
    private javax.swing.JTextField freteTotal;
    private javax.swing.JTextField freteUnitario;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JTextField lucroLote;
    private javax.swing.JTextField lucroUnitario;
    private javax.swing.JTextField nomeProd;
    private javax.swing.JTextField precoUnitario;
    private javax.swing.JTextField quantidade;
    // End of variables declaration//GEN-END:variables
}
