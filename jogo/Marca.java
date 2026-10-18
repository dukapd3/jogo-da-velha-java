package jogo;

public class Marca
{
    private char simbolo;

    public Marca (char smb) throws Exception
    {
        if (smb != 'X' && smb != 'O') throw new Exception("Simbolo incorreto");

        simbolo = smb;
        // validar smb, garantindo que ele
        // seja 'X' ou 'O' e coloca-lo em
        // simbolo
        // dar excecao em caso de valor invalido
    }

    public char getSimbolo ()
    {
        return simbolo;
    }

    @Override
    public String toString ()
    {
        return ""+simbolo;
    }

    @Override
    public boolean equals (Object obj)
    {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        Marca mark = (Marca) obj;

        if (mark.simbolo != this.simbolo ) return false;

        return true;
    }

    @Override
    public int hashCode ()
    {
        int retorno = 1;

        retorno = retorno * 2 + ((Character) this.simbolo).hashCode();

        if (retorno < 0) retorno = -retorno;
        return retorno;
    }
}