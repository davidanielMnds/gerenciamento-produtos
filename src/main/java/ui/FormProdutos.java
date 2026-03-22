package ui;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import model.Produto;
import service.ProdutoService;

public class FormProdutos extends javax.swing.JPanel {
    private DefaultTableModel modelo;
    public FormProdutos() {
        initComponents();
        modelo = (DefaultTableModel) tblProdutos.getModel();
        atualizarTabela();
        txtPesquisa.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
        public void insertUpdate(javax.swing.event.DocumentEvent e) { filtrarTabela(); }
        public void removeUpdate(javax.swing.event.DocumentEvent e) { filtrarTabela(); }
        public void changedUpdate(javax.swing.event.DocumentEvent e) { filtrarTabela(); }
    });
    }
    //----------------------------MÉTODO ATUALIZAR TABELA------------------------------------
    public void atualizarTabela()
    {
        try
        {
            modelo.setRowCount(0);
            List<Produto> lista = ProdutoService.getInstance().listarProdutos();
            for (Produto p : lista)
            {
                modelo.addRow(new Object[] {p.getID(), p.getNome(), p.getQuantidade(), p.getPreco()});
            }
        } catch(SQLException e) {JOptionPane.showMessageDialog(this, "ERRO:" + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);}
    }
    
    //----------------------------MÉTODO FILTRAR TABELA-----------------------------------------
    public void filtrarTabela()
    {
        try
        {
            String pesquisa = txtPesquisa.getText();
            List<Produto> lista = ProdutoService.getInstance().listarProdutosPesquisa(pesquisa);
            modelo.setRowCount(0);
            for(Produto p : lista)
            {
                modelo.addRow(new Object[]{p.getID(),p.getNome(),p.getQuantidade(),p.getPreco()});
            }
        } catch(SQLException e) {JOptionPane.showMessageDialog(this, "ERRO:" + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);}
    } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlNorth = new javax.swing.JPanel();
        lblPesquisa = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        btnDeletar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnAtualizarPagina = new javax.swing.JButton();
        tabelaProdutos = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(850, 600));
        setPreferredSize(new java.awt.Dimension(850, 600));
        setLayout(new java.awt.BorderLayout());

        pnlNorth.setMinimumSize(new java.awt.Dimension(50, 50));
        pnlNorth.setPreferredSize(new java.awt.Dimension(50, 50));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10);
        flowLayout1.setAlignOnBaseline(true);
        pnlNorth.setLayout(flowLayout1);

        lblPesquisa.setText("Pesquisa:");
        pnlNorth.add(lblPesquisa);

        txtPesquisa.setPreferredSize(new java.awt.Dimension(200, 26));
        txtPesquisa.addActionListener(this::txtPesquisaActionPerformed);
        pnlNorth.add(txtPesquisa);

        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(this::btnDeletarActionPerformed);
        pnlNorth.add(btnDeletar);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(this::btnEditarActionPerformed);
        pnlNorth.add(btnEditar);

        btnAtualizarPagina.setText("Atualizar");
        btnAtualizarPagina.addActionListener(this::btnAtualizarPaginaActionPerformed);
        pnlNorth.add(btnAtualizarPagina);

        add(pnlNorth, java.awt.BorderLayout.NORTH);

        tabelaProdutos.setPreferredSize(new java.awt.Dimension(100, 100));

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Quantidade", "Preço"
            }
        ));
        tabelaProdutos.setViewportView(tblProdutos);

        add(tabelaProdutos, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        try
        {
            int linhaSelecionada = tblProdutos.getSelectedRow();
            if(linhaSelecionada == -1)
            {
                JOptionPane.showMessageDialog(this, "Selecione um produto primeiro!", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            } 
            int id = Integer.parseInt(tblProdutos.getValueAt(linhaSelecionada, 0).toString());
            ProdutoService.getInstance().deletarProduto(id);
            JOptionPane.showMessageDialog(this, "O produto foi deletado!");
        }
        catch(SQLException e) {JOptionPane.showMessageDialog(this, "ERRO:" + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);}
        catch(exception.ProdutoNaoEncontradoException e) {JOptionPane.showMessageDialog(this, "ERRO:" + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);}
    }//GEN-LAST:event_btnDeletarActionPerformed
    
    private void btnAtualizarPaginaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarPaginaActionPerformed
        atualizarTabela();
    }//GEN-LAST:event_btnAtualizarPaginaActionPerformed

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed
        
    }//GEN-LAST:event_txtPesquisaActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int linhaSelecionada = tblProdutos.getSelectedRow();
        if(linhaSelecionada == -1) {new AtualizarProduto().setVisible(true);}
        else
        {
            String id = tblProdutos.getValueAt(linhaSelecionada, 0).toString();
            String nome = tblProdutos.getValueAt(linhaSelecionada, 1).toString();
            String quantidade = tblProdutos.getValueAt(linhaSelecionada, 2).toString();
            String preco = tblProdutos.getValueAt(linhaSelecionada, 3).toString();
            new AtualizarProduto(id, nome, quantidade, preco).setVisible(true);
        }
    }//GEN-LAST:event_btnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizarPagina;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JLabel lblPesquisa;
    private javax.swing.JPanel pnlNorth;
    private javax.swing.JScrollPane tabelaProdutos;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
