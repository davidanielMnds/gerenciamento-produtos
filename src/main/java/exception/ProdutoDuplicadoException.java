package exception;

public class ProdutoDuplicadoException extends Exception{
    public ProdutoDuplicadoException(String nome)
    {
        super("Já existe um produto com o nome: + nome");
    }
}
