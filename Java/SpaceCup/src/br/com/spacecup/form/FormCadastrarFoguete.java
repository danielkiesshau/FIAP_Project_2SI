/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.spacecup.form;

import br.com.spacecup.dao.FogueteDAO;
import br.com.spacecup.modelo.Equipe;
import br.com.spacecup.modelo.Foguete;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Wesley
 */
public class FormCadastrarFoguete extends javax.swing.JFrame {

    private Color corFiap = new Color(237, 25, 93);
    private Equipe equipe = null;

    public FormCadastrarFoguete() {
        initComponents();
    }

    public FormCadastrarFoguete(Equipe equipe) {
        initComponents();
        this.equipe = equipe;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JPanel();
        lblRegistrar = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JPanel();
        lblLimpar = new javax.swing.JLabel();
        lblSair = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        lblCor = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        lblPeso = new javax.swing.JLabel();
        rdoVerde = new javax.swing.JRadioButton();
        rdoAzul = new javax.swing.JRadioButton();
        rdoVermelho = new javax.swing.JRadioButton();
        rdoAmarelo = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegistrar.setBackground(new java.awt.Color(237, 25, 93));
        btnRegistrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseExited(evt);
            }
        });

        lblRegistrar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        lblRegistrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegistrar.setText("CADASTRAR FOGUETE");

        javax.swing.GroupLayout btnRegistrarLayout = new javax.swing.GroupLayout(btnRegistrar);
        btnRegistrar.setLayout(btnRegistrarLayout);
        btnRegistrarLayout.setHorizontalGroup(
            btnRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblRegistrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );
        btnRegistrarLayout.setVerticalGroup(
            btnRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblRegistrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        btnLimpar.setBackground(new java.awt.Color(237, 25, 93));
        btnLimpar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimparMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLimparMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLimparMouseExited(evt);
            }
        });

        lblLimpar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblLimpar.setForeground(new java.awt.Color(255, 255, 255));
        lblLimpar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLimpar.setText("LIMPAR");

        javax.swing.GroupLayout btnLimparLayout = new javax.swing.GroupLayout(btnLimpar);
        btnLimpar.setLayout(btnLimparLayout);
        btnLimparLayout.setHorizontalGroup(
            btnLimparLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );
        btnLimparLayout.setVerticalGroup(
            btnLimparLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        jPanel1.add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, -1, -1));

        lblSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/spacecup/fotos/sair.png"))); // NOI18N
        lblSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSairMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSairMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSairMouseExited(evt);
            }
        });
        jPanel1.add(lblSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        lblTitulo.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/spacecup/fotos/foguetefocus.png"))); // NOI18N
        lblTitulo.setText("CADASTRAR FOGUETE");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        txtNome.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtNome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNome.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtNome.setSelectionColor(new java.awt.Color(234, 25, 93));
        jPanel1.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 140, -1));

        lblNome.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setText("NOME DO FOGUETE");
        jPanel1.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        lblCor.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblCor.setForeground(new java.awt.Color(255, 255, 255));
        lblCor.setText("COR DO FOGUETE");
        jPanel1.add(lblCor, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        txtPeso.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtPeso.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPeso.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtPeso.setSelectionColor(new java.awt.Color(234, 25, 93));
        jPanel1.add(txtPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 140, -1));

        lblPeso.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblPeso.setForeground(new java.awt.Color(255, 255, 255));
        lblPeso.setText("PESO DO FOGUETE");
        jPanel1.add(lblPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        rdoVerde.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(rdoVerde);
        rdoVerde.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        rdoVerde.setForeground(new java.awt.Color(255, 255, 255));
        rdoVerde.setText("Verde");
        jPanel1.add(rdoVerde, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, -1, -1));

        rdoAzul.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(rdoAzul);
        rdoAzul.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        rdoAzul.setForeground(new java.awt.Color(255, 255, 255));
        rdoAzul.setSelected(true);
        rdoAzul.setText("Azul");
        jPanel1.add(rdoAzul, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, -1, -1));

        rdoVermelho.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(rdoVermelho);
        rdoVermelho.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        rdoVermelho.setForeground(new java.awt.Color(255, 255, 255));
        rdoVermelho.setText("Vermelho");
        jPanel1.add(rdoVermelho, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, -1, -1));

        rdoAmarelo.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(rdoAmarelo);
        rdoAmarelo.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        rdoAmarelo.setForeground(new java.awt.Color(255, 255, 255));
        rdoAmarelo.setText("Amarelo");
        jPanel1.add(rdoAmarelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseEntered
        btnRegistrar.setBackground(Color.WHITE);
        lblRegistrar.setForeground(corFiap);
    }//GEN-LAST:event_btnRegistrarMouseEntered

    private void btnRegistrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseExited
        btnRegistrar.setBackground(corFiap);
        lblRegistrar.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnRegistrarMouseExited

    private void btnLimparMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimparMouseEntered
        btnLimpar.setBackground(Color.WHITE);
        lblLimpar.setForeground(corFiap);
    }//GEN-LAST:event_btnLimparMouseEntered

    private void btnLimparMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimparMouseExited
        btnLimpar.setBackground(corFiap);
        lblLimpar.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnLimparMouseExited

    private void lblSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSairMouseClicked
        FormLogin fm = new FormLogin();
        this.dispose();
        fm.setVisible(true);
    }//GEN-LAST:event_lblSairMouseClicked

    private void lblSairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSairMouseEntered
        ImageIcon icon = new ImageIcon(getClass().getResource("/br/com/spacecup/fotos/sairfocus.png"));
        lblSair.setIcon(icon);
    }//GEN-LAST:event_lblSairMouseEntered

    private void lblSairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSairMouseExited
        ImageIcon icon = new ImageIcon(getClass().getResource("/br/com/spacecup/fotos/sair.png"));
        lblSair.setIcon(icon);
    }//GEN-LAST:event_lblSairMouseExited

    private void btnLimparMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimparMouseClicked
        limpar();
    }//GEN-LAST:event_btnLimparMouseClicked

    private void btnRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseClicked
        if (txtNome.getText().isEmpty() || txtPeso.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campos obrigatorios em branco");
        } else {
            try{                
     
            String nome = txtNome.getText();
            Double peso = Double.parseDouble(txtPeso.getText());
            String cor = "";
            if (rdoAzul.isSelected()) {
                cor = "Azul";
            } else if (rdoAmarelo.isSelected()) {
                cor = "Amarelo";
            } else if (rdoVerde.isSelected()) {
                cor = "Verde";
            } else {
                cor = "Vermelho";
            }
            Foguete foguete = new Foguete(nome, peso, cor, equipe);
            FogueteDAO dao = new FogueteDAO();
            if (dao.registrarFoguete(foguete)) {
                JOptionPane.showMessageDialog(this, "Foguete cadastrado com sucesso!");
                FormMenu fm = new FormMenu(equipe);
                this.dispose();
                fm.setVisible(true);
            }
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(this, "Dados invalidos");
            }
        }

    }//GEN-LAST:event_btnRegistrarMouseClicked

    private void limpar() {
        txtNome.setText("");
        txtPeso.setText("");
        rdoAzul.setSelected(true);
    }

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FormCadastrarFoguete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCadastrarFoguete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCadastrarFoguete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCadastrarFoguete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormCadastrarFoguete().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnLimpar;
    private javax.swing.JPanel btnRegistrar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCor;
    private javax.swing.JLabel lblLimpar;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblRegistrar;
    private javax.swing.JLabel lblSair;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JRadioButton rdoAmarelo;
    private javax.swing.JRadioButton rdoAzul;
    private javax.swing.JRadioButton rdoVerde;
    private javax.swing.JRadioButton rdoVermelho;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPeso;
    // End of variables declaration//GEN-END:variables
}