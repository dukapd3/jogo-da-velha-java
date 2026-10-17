import jogo.*;

public class AnalistaSituacional
{
    private Tabuleiro tabDoJogo;

    public AnalistaSituacional (Tabuleiro tab) throws Exception
    {
        // colocar tab em tabDoJogo
        // (sem clonar, para enxergar as jogadas
        // feitas pelos jogadores no mesmo tabuleiro)

        if (tab == null)
            throw new Exception ("Tabuleiro nao fornecido");

        this.tabDoJogo = tab;
    }

    // retorna a marca que ocupa as 3 posicoes fornecidas,
    // ou null, caso elas nao estejam todas ocupadas
    // pela mesma marca
    private Marca getMarcaDaSequencia (int lin1, int col1,
                                       int lin2, int col2,
                                       int lin3, int col3) throws Exception
    {
        Marca primeira = this.tabDoJogo.getMarcaNaPosicao (lin1, col1);

        if (primeira == null)
            return null;

        if (!primeira.equals (this.tabDoJogo.getMarcaNaPosicao (lin2, col2)))
            return null;

        if (!primeira.equals (this.tabDoJogo.getMarcaNaPosicao (lin3, col3)))
            return null;

        return primeira;
    }

    public Marca getMarcaDoVencedor ()
    {
        // descobrir se ha um vencedor e retornar
        // a marca dele; retornara null, quando
        // nao houver vencedor

        Marca ret = null;

        try
        {
            // linhas 0, 1 e 2
            for (int lin=0; lin<3 && ret==null; lin++)
                ret = this.getMarcaDaSequencia (lin,0, lin,1, lin,2);

            // colunas 0, 1 e 2
            for (int col=0; col<3 && ret==null; col++)
                ret = this.getMarcaDaSequencia (0,col, 1,col, 2,col);

            // diagonal principal
            if (ret == null)
                ret = this.getMarcaDaSequencia (0,0, 1,1, 2,2);

            // diagonal secundaria
            if (ret == null)
                ret = this.getMarcaDaSequencia (0,2, 1,1, 2,0);
        }
        catch (Exception erro)
        {} // sei que nao vai dar erro, pois so uso posicoes validas

        return ret;
    }

    private boolean tabuleiroCheio ()
    {
        // verificar se todas as posicoes do
        // tabuleiro estao preenchidas (!=null)
        // retornando true em caso afirmativo,
        // ou false em caso negativo

        try
        {
            for (int lin=0; lin<3; lin++)
                for (int col=0; col<3; col++)
                    if (!this.tabDoJogo.haMarcaNaPosicao (lin, col))
                        return false;
        }
        catch (Exception erro)
        {} // sei que nao vai dar erro, pois so uso posicoes validas

        return true;
    }

    public boolean fimDeJogo ()
    {
        // se getMarcaDoVencedor != null,
        // retorna true
        // se tabuleiroCheio == true,
        // retorna true
        // caso contrario, retorna false

        if (this.getMarcaDoVencedor () != null)
            return true;

        if (this.tabuleiroCheio ())
            return true;

        return false;
    }

    @Override
    public String toString ()
    {
        String situacao;
        Marca  vencedor = this.getMarcaDoVencedor ();

        if (vencedor != null)
            situacao = "Vencedor: " + vencedor;
        else
            if (this.tabuleiroCheio ())
                situacao = "Deu velha";
            else
                situacao = "Em andamento";

        return situacao + "\n" + this.tabDoJogo;
    }

    @Override
    public boolean equals (Object obj)
    {
        // retornar true se this for igual a obj ou false caso contrario

        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (this.getClass() != obj.getClass())
            return false;

        AnalistaSituacional analista = (AnalistaSituacional)obj;

        if (!this.tabDoJogo.equals (analista.tabDoJogo))
            return false;

        return true;
    }

    @Override
    public int hashCode ()
    {
        int ret = 1;

        ret = 13*ret + this.tabDoJogo.hashCode();

        return ret;
    }
}
