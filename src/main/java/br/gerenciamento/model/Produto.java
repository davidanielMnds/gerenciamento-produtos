package br.gerenciamento.model;

public class Produto {
    
    private Integer id;
    private String nome;
    private int quantidade;
    private double preco;
    
//---------------------CONSTRUTOR--------------------------
    public Produto(String nome, int quantidade, double preco)
    {
        this.nome=nome;
        this.quantidade=quantidade;
        this.preco=preco;
    }
//---------------------GETTERS---------------------------------
    public Integer getID() { return id;}
    public String getNome() { return nome;}
    public int getQuantidade() { return quantidade;}
    public double getPreco() { return preco;}
//---------------------SETTERS---------------------------------
    public void setID(Integer novoID){this.id=novoID;}
    public void setNome(String novoNome){nome=novoNome;}
    public void setQuantidade(int novaQuantidade){quantidade=novaQuantidade;}
    public void setPreco(double novoPreco){preco=novoPreco;}
}
