package br.gerenciamento.exception;

public class ProdutoNaoEncontradoException extends Exception{
    public ProdutoNaoEncontradoException(Integer id)
    {
        super("Produto não encontrado: " + id);
    }
    
}
