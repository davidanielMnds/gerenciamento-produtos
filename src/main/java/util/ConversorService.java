package util;

import exception.EntradaInvalidaException;

public class ConversorService {
    public static int converterInt(String numero, String campo) throws EntradaInvalidaException
    {
        try
        {
            return Integer.parseInt(numero);
        } catch(NumberFormatException e)
            {
                throw new EntradaInvalidaException(campo);
            }
    }
    
    public static double converterDouble(String numero, String campo) throws EntradaInvalidaException
    {
        try
            {
                return Double.parseDouble(numero);
            }
        catch (NumberFormatException e)
            {
                throw new EntradaInvalidaException(campo);
            }
    }
}
