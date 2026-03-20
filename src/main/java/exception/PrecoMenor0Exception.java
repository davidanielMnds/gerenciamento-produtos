package exception;

public class PrecoMenor0Exception extends Exception{
    public PrecoMenor0Exception(double preco)
    {
        super("O preço : " + preco + " é menor que 0.");
    }
    
}
