/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Telas;

import Interfaces.ControllerInterface;
import Interfaces.PainelInterface;  
import java.awt.BorderLayout;
import javax.swing.JOptionPane;

/**
 *
 * @author i
 */
public class CadastroGeral extends javax.swing.JDialog {
    private final ControllerInterface ctrl;
    private final PainelInterface pain;
    
    public CadastroGeral(java.awt.Frame parent, boolean modal, ControllerInterface ctrl, PainelInterface pain) {
        super(parent, modal);
        initComponents();
        this.ctrl = ctrl;
        this.pain = pain;
        add(pain, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(parent);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jB_cancelar = new javax.swing.JButton();
        jB_salvar = new javax.swing.JButton();
        jB_puxarid = new javax.swing.JButton();
        jB_listagem = new javax.swing.JButton();
        jB_deletar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 50));

        jPanel1.setMinimumSize(new java.awt.Dimension(442, 35));
        jPanel1.setPreferredSize(new java.awt.Dimension(442, 35));

        jB_cancelar.setText("Cancelar");
        jB_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(jB_cancelar);

        jB_salvar.setText("Salvar");
        jB_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_salvarActionPerformed(evt);
            }
        });
        jPanel1.add(jB_salvar);

        jB_puxarid.setText("Puxar Por ID");
        jB_puxarid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_puxaridActionPerformed(evt);
            }
        });
        jPanel1.add(jB_puxarid);

        jB_listagem.setText("Listagem");
        jB_listagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_listagemActionPerformed(evt);
            }
        });
        jPanel1.add(jB_listagem);

        jB_deletar.setText("Deletar");
        jB_deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_deletarActionPerformed(evt);
            }
        });
        jPanel1.add(jB_deletar);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jB_cancelarActionPerformed

    private void jB_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_salvarActionPerformed
        try {
            this.ctrl.criar(this.pain.getData());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jB_salvarActionPerformed

    private void jB_listagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_listagemActionPerformed
        try {
            Object[][] data = this.ctrl.listar();
            String[] titulos = this.ctrl.titulos();

            new ListagemGeral(null, true, data, titulos);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao listar: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }        
    }//GEN-LAST:event_jB_listagemActionPerformed

    private void jB_deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_deletarActionPerformed
        try {
            this.ctrl.deletar(this.pain.getData());
            this.pain.clear();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao deletar", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jB_deletarActionPerformed

    private void jB_puxaridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_puxaridActionPerformed
        try {
            this.pain.setDados(this.ctrl.ler(this.pain.getData()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao puxar ID: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jB_puxaridActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_cancelar;
    private javax.swing.JButton jB_deletar;
    private javax.swing.JButton jB_listagem;
    private javax.swing.JButton jB_puxarid;
    private javax.swing.JButton jB_salvar;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
