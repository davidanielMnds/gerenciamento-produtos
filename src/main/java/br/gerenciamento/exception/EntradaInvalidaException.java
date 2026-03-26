package br.gerenciamento.exception;

public class EntradaInvalidaException extends Exception{
    public EntradaInvalidaException(String campo)
    {
        super("Erro no campo: " + campo);
    }
}
