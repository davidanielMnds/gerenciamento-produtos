package br.gerenciamento.ui;

import br.gerenciamento.exception.EntradaInvalidaException;
import br.gerenciamento.exception.PrecoMenor0Exception;
import br.gerenciamento.exception.ProdutoDuplicadoException;
import br.gerenciamento.exception.ProdutoNaoEncontradoException;
import br.gerenciamento.exception.QuantidadeMenor0Exception;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import br.gerenciamento.service.ProdutoService;

public class AtualizarProduto extends javax.swing.JFrame {    
    //----------------------INICIAR JANELA--------------------
    public AtualizarProduto() {
        initComponents();
    }
    
    //----------------------INICIAR JANELA COM FORMULARIO PREENCHIDO--------------------
    public AtualizarProduto(String id, String nome, String quantidade, String preco)
    {
        initComponents();
        preencherCampos(id, nome, quantidade, preco);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        root = new javax.swing.JPanel();
        pnlNorth = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        pnlCenter = new javax.swing.JPanel();
        pnlFormulario = new javax.swing.JPanel();
        pnlId = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        pnlNome = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        pnlQuantidade = new javax.swing.JPanel();
        lblQuantidade = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        pnlPreco = new javax.swing.JPanel();
        lblPreco = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        pnlBotoes = new javax.swing.JPanel();
        btnAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciamento de Produtos");
        setPreferredSize(new java.awt.Dimension(500, 500));
        setResizable(false);

        root.setLayout(new java.awt.BorderLayout());

        pnlNorth.setMinimumSize(new java.awt.Dimension(10, 70));
        pnlNorth.setPreferredSize(new java.awt.Dimension(500, 70));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblTitulo.setText("Atualizar produto");
        pnlNorth.add(lblTitulo);

        root.add(pnlNorth, java.awt.BorderLayout.PAGE_START);

        pnlCenter.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 80, 90));

        pnlFormulario.setBackground(new java.awt.Color(0, 51, 204));
        pnlFormulario.setPreferredSize(new java.awt.Dimension(300, 300));
        pnlFormulario.setLayout(new javax.swing.BoxLayout(pnlFormulario, javax.swing.BoxLayout.Y_AXIS));

        pnlId.setMinimumSize(new java.awt.Dimension(300, 40));
        pnlId.setPreferredSize(new java.awt.Dimension(300, 40));
        pnlId.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        lblId.setText("ID:");
        pnlId.add(lblId);

        txtId.setMinimumSize(new java.awt.Dimension(200, 26));
        txtId.setPreferredSize(new java.awt.Dimension(200, 26));
        pnlId.add(txtId);

        pnlFormulario.add(pnlId);

        pnlNome.setMinimumSize(new java.awt.Dimension(300, 40));
        pnlNome.setPreferredSize(new java.awt.Dimension(300, 40));
        pnlNome.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        lblNome.setText("Nome:");
        pnlNome.add(lblNome);

        txtNome.setPreferredSize(new java.awt.Dimension(200, 26));
        pnlNome.add(txtNome);

        pnlFormulario.add(pnlNome);

        pnlQuantidade.setMinimumSize(new java.awt.Dimension(300, 40));
        pnlQuantidade.setPreferredSize(new java.awt.Dimension(300, 40));
        pnlQuantidade.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        lblQuantidade.setText("Quantidade:");
        pnlQuantidade.add(lblQuantidade);

        txtQuantidade.setPreferredSize(new java.awt.Dimension(200, 26));
        pnlQuantidade.add(txtQuantidade);

        pnlFormulario.add(pnlQuantidade);

        pnlPreco.setMinimumSize(new java.awt.Dimension(300, 40));
        pnlPreco.setPreferredSize(new java.awt.Dimension(300, 40));
        pnlPreco.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        lblPreco.setText("Preço:");
        pnlPreco.add(lblPreco);

        txtPreco.setPreferredSize(new java.awt.Dimension(200, 26));
        pnlPreco.add(txtPreco);

        pnlFormulario.add(pnlPreco);

        pnlBotoes.setMinimumSize(new java.awt.Dimension(300, 40));
        pnlBotoes.setPreferredSize(new java.awt.Dimension(400, 40));
        pnlBotoes.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 0, 10));

        btnAtualizar.setBackground(new java.awt.Color(0, 153, 51));
        btnAtualizar.setText("Atualizar Produto");
        btnAtualizar.addActionListener(this::btnAtualizarActionPerformed);
        pnlBotoes.add(btnAtualizar);

        pnlFormulario.add(pnlBotoes);

        pnlCenter.add(pnlFormulario);

        root.add(pnlCenter, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(root, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(root, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        String id = txtId.getText();
        String nome = txtNome.getText();
        String quantidade = txtQuantidade.getText();
        String preco = txtPreco.getText();
        try{
            ProdutoService.getInstance().atualizarProduto(id, nome, quantidade, preco);
            JOptionPane.showMessageDialog(this, "O produto foi atualizado");
        }
        catch (ProdutoDuplicadoException 
                | ProdutoNaoEncontradoException 
                | PrecoMenor0Exception 
                | QuantidadeMenor0Exception 
                | SQLException 
                | EntradaInvalidaException ex) 
        { JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);}
        
    }//GEN-LAST:event_btnAtualizarActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new AtualizarProduto().setVisible(true));
    }
    private void preencherCampos(String id, String nome, String quantidade, String preco)
    {
        txtId.setText(id);
        txtNome.setText(nome);
        txtQuantidade.setText(quantidade);
        txtPreco.setText(preco);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBotoes;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlFormulario;
    private javax.swing.JPanel pnlId;
    private javax.swing.JPanel pnlNome;
    private javax.swing.JPanel pnlNorth;
    private javax.swing.JPanel pnlPreco;
    private javax.swing.JPanel pnlQuantidade;
    private javax.swing.JPanel root;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
