package exception;

public class QuantidadeMenor0Exception extends Exception{
    public QuantidadeMenor0Exception(int quantidade)
    {
        super("A quantidade selecionada :" + quantidade + " é menor que 0");
    }
}
