/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Interfaces;

import DTOs.PedidoDTO;
import Modelos.StatusPedido;
import Modelos.cliente.Cliente;
import Modelos.delivery.Entrega;

/**
 *
 * @author i
 */
public class PedidoCriarPainel extends PainelInterface {
    public PedidoCriarPainel() {
        initComponents();
    }
    
    @Override
    public InterfaceDTO getData() {
        PedidoDTO pdto = new PedidoDTO();

        String id = this.JTA_id.getText();
        String clienteid = this.jTA_cliente.getText();
        String statusid = this.jTA_status.getText();
        String entregaid = this.jTA_entrega.getText();
        String reembolso = this.jTA_reembolso.getText();

        if (id != null && !id.isEmpty()) {
            pdto.id = Integer.parseInt(id);
        }
        if (clienteid != null && !clienteid.isEmpty()) {
            pdto.cliente = new Cliente(Integer.parseInt(clienteid), null, null);
        }
        if (statusid != null && !statusid.isEmpty()) {
            pdto.status = new StatusPedido(Integer.parseInt(statusid), null);
        }
        if (entregaid != null && !entregaid.isEmpty()) {
            pdto.entrega = new Entrega(Integer.parseInt(entregaid), null, null, null);
        }
        pdto.reembolso = reembolso;

        return (InterfaceDTO) pdto;
    }
    
    @Override
    public void setDados(InterfaceDTO dto) {
        this.JTA_id.setText(String.valueOf(((PedidoDTO) dto).id));
        this.jTA_cliente.setText(String.valueOf(((PedidoDTO) dto).cliente.getId()));
        this.jTA_status.setText(String.valueOf(((PedidoDTO) dto).status.getId()));
        this.jTA_entrega.setText(String.valueOf(((PedidoDTO) dto).entrega.getId()));
        this.jTA_reembolso.setText(((PedidoDTO) dto).reembolso);
    }

    @Override
    public void clear() {
        this.JTA_id.setText("");
        this.jTA_cliente.setText("");
        this.jTA_status.setText("");
        this.jTA_entrega.setText("");
        this.jTA_reembolso.setText("");
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTA_id = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTA_cliente = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTA_status = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTA_entrega = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTA_reembolso = new javax.swing.JTextArea();

        setLayout(new java.awt.GridLayout(5, 1, 5, 5));

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("ID");
        jPanel1.add(jLabel1, java.awt.BorderLayout.CENTER);

        JTA_id.setColumns(20);
        JTA_id.setRows(1);
        jScrollPane1.setViewportView(JTA_id);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.PAGE_END);

        add(jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("Cliente ID");
        jPanel2.add(jLabel2, java.awt.BorderLayout.CENTER);

        jTA_cliente.setColumns(20);
        jTA_cliente.setRows(1);
        jScrollPane2.setViewportView(jTA_cliente);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.PAGE_END);

        add(jPanel2);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel4.setText("Status ID");
        jPanel4.add(jLabel4, java.awt.BorderLayout.CENTER);

        jTA_status.setColumns(20);
        jTA_status.setRows(1);
        jScrollPane4.setViewportView(jTA_status);

        jPanel4.add(jScrollPane4, java.awt.BorderLayout.PAGE_END);

        add(jPanel4);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel5.setText("Entrega ID");
        jPanel5.add(jLabel5, java.awt.BorderLayout.CENTER);

        jTA_entrega.setColumns(20);
        jTA_entrega.setRows(1);
        jScrollPane5.setViewportView(jTA_entrega);

        jPanel5.add(jScrollPane5, java.awt.BorderLayout.PAGE_END);

        add(jPanel5);

        jPanel6.setLayout(new java.awt.BorderLayout());

        jLabel6.setText("Reembolso");
        jPanel6.add(jLabel6, java.awt.BorderLayout.CENTER);

        jTA_reembolso.setColumns(20);
        jTA_reembolso.setRows(1);
        jScrollPane6.setViewportView(jTA_reembolso);

        jPanel6.add(jScrollPane6, java.awt.BorderLayout.PAGE_END);

        add(jPanel6);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea JTA_id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea jTA_cliente;
    private javax.swing.JTextArea jTA_entrega;
    private javax.swing.JTextArea jTA_reembolso;
    private javax.swing.JTextArea jTA_status;
    // End of variables declaration//GEN-END:variables
}
