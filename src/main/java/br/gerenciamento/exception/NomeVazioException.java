package br.gerenciamento.exception;

public class NomeVazioException extends Exception{
    public NomeVazioException()
    {
        super("O campo nome não pode estar vazio.");
    }
}
