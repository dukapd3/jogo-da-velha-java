package jogador;

import jogo.*;

public class JogadorAutomatico implements Jogador
{
    private Marca marca = null;
    private Tabuleiro tabDoJogo = null;

    public JogadorAutomatico (Tabuleiro tab) throws Exception
    {
        if (tab == null)
            throw new Exception("Tabuleiro invalido");

        this.tabDoJogo = tab;
        if ((int)(Math.random() * 2) == 0)
            this.marca = new Marca('X');
        else
            this.marca = new Marca('O');
    }

    public JogadorAutomatico (Tabuleiro tab, Marca mrc) throws Exception
    {
        if (tab == null || mrc == null)
            throw new Exception("Tabuleiro ou marca invalida");

        this.tabDoJogo = tab;
        this.marca = mrc;
    }

    public Marca getMarca ()
    {
        return this.marca;
    }

    public void facaSuaJogada ()
    {
        try
        {
            Marca adv = new Marca(marca.getSimbolo() == 'X' ? 'O' : 'X');

            if (!tabDoJogo.haMarcaNaPosicao(0,0) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(0,1)) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(0,2)))
                tabDoJogo.setMarcaNaPosicao(marca,0,0);
            else if (marca.equals(tabDoJogo.getMarcaNaPosicao(0,0)) &&
                     !tabDoJogo.haMarcaNaPosicao(0,1) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(0,2)))
                tabDoJogo.setMarcaNaPosicao(marca,0,1);
            else if (marca.equals(tabDoJogo.getMarcaNaPosicao(0,0)) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(0,1)) &&
                     !tabDoJogo.haMarcaNaPosicao(0,2))
                tabDoJogo.setMarcaNaPosicao(marca,0,2);

            else if (!tabDoJogo.haMarcaNaPosicao(1,0) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(1,1)) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(1,2)))
                tabDoJogo.setMarcaNaPosicao(marca,1,0);
            else if (marca.equals(tabDoJogo.getMarcaNaPosicao(1,0)) &&
                     !tabDoJogo.haMarcaNaPosicao(1,1) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(1,2)))
                tabDoJogo.setMarcaNaPosicao(marca,1,1);
            else if (marca.equals(tabDoJogo.getMarcaNaPosicao(1,0)) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(1,1)) &&
                     !tabDoJogo.haMarcaNaPosicao(1,2))
                tabDoJogo.setMarcaNaPosicao(marca,1,2);

            else if (!tabDoJogo.haMarcaNaPosicao(2,0) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(2,1)) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(2,2)))
                tabDoJogo.setMarcaNaPosicao(marca,2,0);
            else if (marca.equals(tabDoJogo.getMarcaNaPosicao(2,0)) &&
                     !tabDoJogo.haMarcaNaPosicao(2,1) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(2,2)))
                tabDoJogo.setMarcaNaPosicao(marca,2,1);
            else if (marca.equals(tabDoJogo.getMarcaNaPosicao(2,0)) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(2,1)) &&
                     !tabDoJogo.haMarcaNaPosicao(2,2))
                tabDoJogo.setMarcaNaPosicao(marca,2,2);

            else if (!tabDoJogo.haMarcaNaPosicao(0,0) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(1,0)) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(2,0)))
                tabDoJogo.setMarcaNaPosicao(marca,0,0);
            else if (marca.equals(tabDoJogo.getMarcaNaPosicao(0,0)) &&
                     !tabDoJogo.haMarcaNaPosicao(1,0) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(2,0)))
                tabDoJogo.setMarcaNaPosicao(marca,1,0);
            else if (marca.equals(tabDoJogo.getMarcaNaPosicao(0,0)) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(1,0)) &&
                     !tabDoJogo.haMarcaNaPosicao(2,0))
                tabDoJogo.setMarcaNaPosicao(marca,2,0);

            else if (!tabDoJogo.haMarcaNaPosicao(0,1) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(1,1)) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(2,1)))
                tabDoJogo.setMarcaNaPosicao(marca,0,1);
            else if (marca.equals(tabDoJogo.getMarcaNaPosicao(0,1)) &&
                     !tabDoJogo.haMarcaNaPosicao(1,1) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(2,1)))
                tabDoJogo.setMarcaNaPosicao(marca,1,1);
            else if (marca.equals(tabDoJogo.getMarcaNaPosicao(0,1)) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(1,1)) &&
                     !tabDoJogo.haMarcaNaPosicao(2,1))
                tabDoJogo.setMarcaNaPosicao(marca,2,1);

            else if (!tabDoJogo.haMarcaNaPosicao(0,2) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(1,2)) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(2,2)))
                tabDoJogo.setMarcaNaPosicao(marca,0,2);
            else if (marca.equals(tabDoJogo.getMarcaNaPosicao(0,2)) &&
                     !tabDoJogo.haMarcaNaPosicao(1,2) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(2,2)))
                tabDoJogo.setMarcaNaPosicao(marca,1,2);
            else if (marca.equals(tabDoJogo.getMarcaNaPosicao(0,2)) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(1,2)) &&
                     !tabDoJogo.haMarcaNaPosicao(2,2))
                tabDoJogo.setMarcaNaPosicao(marca,2,2);

            else if (!tabDoJogo.haMarcaNaPosicao(0,0) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(1,1)) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(2,2)))
                tabDoJogo.setMarcaNaPosicao(marca,0,0);
            else if (marca.equals(tabDoJogo.getMarcaNaPosicao(0,0)) &&
                     !tabDoJogo.haMarcaNaPosicao(1,1) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(2,2)))
                tabDoJogo.setMarcaNaPosicao(marca,1,1);
            else if (marca.equals(tabDoJogo.getMarcaNaPosicao(0,0)) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(1,1)) &&
                     !tabDoJogo.haMarcaNaPosicao(2,2))
                tabDoJogo.setMarcaNaPosicao(marca,2,2);

            else if (!tabDoJogo.haMarcaNaPosicao(0,2) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(1,1)) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(2,0)))
                tabDoJogo.setMarcaNaPosicao(marca,0,2);
            else if (marca.equals(tabDoJogo.getMarcaNaPosicao(0,2)) &&
                     !tabDoJogo.haMarcaNaPosicao(1,1) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(2,0)))
                tabDoJogo.setMarcaNaPosicao(marca,1,1);
            else if (marca.equals(tabDoJogo.getMarcaNaPosicao(0,2)) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(1,1)) &&
                     !tabDoJogo.haMarcaNaPosicao(2,0))
                tabDoJogo.setMarcaNaPosicao(marca,2,0);


            else if (!tabDoJogo.haMarcaNaPosicao(0,0) &&
                     adv.equals(tabDoJogo.getMarcaNaPosicao(0,1)) &&
                     adv.equals(tabDoJogo.getMarcaNaPosicao(0,2)))
                tabDoJogo.setMarcaNaPosicao(marca,0,0);
            else if (adv.equals(tabDoJogo.getMarcaNaPosicao(0,0)) &&
                     !tabDoJogo.haMarcaNaPosicao(0,1) &&
                     adv.equals(tabDoJogo.getMarcaNaPosicao(0,2)))
                tabDoJogo.setMarcaNaPosicao(marca,0,1);
            else if (adv.equals(tabDoJogo.getMarcaNaPosicao(0,0)) &&
                     adv.equals(tabDoJogo.getMarcaNaPosicao(0,1)) &&
                     !tabDoJogo.haMarcaNaPosicao(0,2))
                tabDoJogo.setMarcaNaPosicao(marca,0,2);

            else if (!tabDoJogo.haMarcaNaPosicao(1,0) &&
                     adv.equals(tabDoJogo.getMarcaNaPosicao(1,1)) &&
                     adv.equals(tabDoJogo.getMarcaNaPosicao(1,2)))
                tabDoJogo.setMarcaNaPosicao(marca,1,0);
            else if (adv.equals(tabDoJogo.getMarcaNaPosicao(1,0)) &&
                     !tabDoJogo.haMarcaNaPosicao(1,1) &&
                     adv.equals(tabDoJogo.getMarcaNaPosicao(1,2)))
                tabDoJogo.setMarcaNaPosicao(marca,1,1);
            else if (adv.equals(tabDoJogo.getMarcaNaPosicao(1,0)) &&
                     adv.equals(tabDoJogo.getMarcaNaPosicao(1,1)) &&
                     !tabDoJogo.haMarcaNaPosicao(1,2))
                tabDoJogo.setMarcaNaPosicao(marca,1,2);

            else if (!tabDoJogo.haMarcaNaPosicao(2,0) &&
                     adv.equals(tabDoJogo.getMarcaNaPosicao(2,1)) &&
                     adv.equals(tabDoJogo.getMarcaNaPosicao(2,2)))
                tabDoJogo.setMarcaNaPosicao(marca,2,0);
            else if (adv.equals(tabDoJogo.getMarcaNaPosicao(2,0)) &&
                     !tabDoJogo.haMarcaNaPosicao(2,1) &&
                     adv.equals(tabDoJogo.getMarcaNaPosicao(2,2)))
                tabDoJogo.setMarcaNaPosicao(marca,2,1);
            else if (adv.equals(tabDoJogo.getMarcaNaPosicao(2,0)) &&
                     adv.equals(tabDoJogo.getMarcaNaPosicao(2,1)) &&
                     !tabDoJogo.haMarcaNaPosicao(2,2))
                tabDoJogo.setMarcaNaPosicao(marca,2,2);

            else if (!tabDoJogo.haMarcaNaPosicao(0,0) &&
                     adv.equals(tabDoJogo.getMarcaNaPosicao(1,0)) &&
                     adv.equals(tabDoJogo.getMarcaNaPosicao(2,0)))
                tabDoJogo.setMarcaNaPosicao(marca,0,0);
            else if (adv.equals(tabDoJogo.getMarcaNaPosicao(0,0)) &&
                     !tabDoJogo.haMarcaNaPosicao(1,0) &&
                     adv.equals(tabDoJogo.getMarcaNaPosicao(2,0)))
                tabDoJogo.setMarcaNaPosicao(marca,1,0);
            else if (adv.equals(tabDoJogo.getMarcaNaPosicao(0,0)) &&
                     adv.equals(tabDoJogo.getMarcaNaPosicao(1,0)) &&
                     !tabDoJogo.haMarcaNaPosicao(2,0))
                tabDoJogo.setMarcaNaPosicao(marca,2,0);

            else if (!tabDoJogo.haMarcaNaPosicao(0,1) &&
                     adv.equals(tabDoJogo.getMarcaNaPosicao(1,1)) &&
                     adv.equals(tabDoJogo.getMarcaNaPosicao(2,1)))
                tabDoJogo.setMarcaNaPosicao(marca,0,1);
            else if (adv.equals(tabDoJogo.getMarcaNaPosicao(0,1)) &&
                     !tabDoJogo.haMarcaNaPosicao(1,1) &&
                     adv.equals(tabDoJogo.getMarcaNaPosicao(2,1)))
                tabDoJogo.setMarcaNaPosicao(marca,1,1);
            else if (adv.equals(tabDoJogo.getMarcaNaPosicao(0,1)) &&
                     adv.equals(tabDoJogo.getMarcaNaPosicao(1,1)) &&
                     !tabDoJogo.haMarcaNaPosicao(2,1))
                tabDoJogo.setMarcaNaPosicao(marca,2,1);

            else if (!tabDoJogo.haMarcaNaPosicao(0,2) &&
                     adv.equals(tabDoJogo.getMarcaNaPosicao(1,2)) &&
                     adv.equals(tabDoJogo.getMarcaNaPosicao(2,2)))
                tabDoJogo.setMarcaNaPosicao(marca,0,2);
            else if (adv.equals(tabDoJogo.getMarcaNaPosicao(0,2)) &&
                     !tabDoJogo.haMarcaNaPosicao(1,2) &&
                     adv.equals(tabDoJogo.getMarcaNaPosicao(2,2)))
                tabDoJogo.setMarcaNaPosicao(marca,1,2);
            else if (adv.equals(tabDoJogo.getMarcaNaPosicao(0,2)) &&
                     adv.equals(tabDoJogo.getMarcaNaPosicao(1,2)) &&
                     !tabDoJogo.haMarcaNaPosicao(2,2))
                tabDoJogo.setMarcaNaPosicao(marca,2,2);

            else if (!tabDoJogo.haMarcaNaPosicao(0,0) &&
                     adv.equals(tabDoJogo.getMarcaNaPosicao(1,1)) &&
                     adv.equals(tabDoJogo.getMarcaNaPosicao(2,2)))
                tabDoJogo.setMarcaNaPosicao(marca,0,0);
            else if (adv.equals(tabDoJogo.getMarcaNaPosicao(0,0)) &&
                     !tabDoJogo.haMarcaNaPosicao(1,1) &&
                     adv.equals(tabDoJogo.getMarcaNaPosicao(2,2)))
                tabDoJogo.setMarcaNaPosicao(marca,1,1);
            else if (adv.equals(tabDoJogo.getMarcaNaPosicao(0,0)) &&
                     adv.equals(tabDoJogo.getMarcaNaPosicao(1,1)) &&
                     !tabDoJogo.haMarcaNaPosicao(2,2))
                tabDoJogo.setMarcaNaPosicao(marca,2,2);

            else if (!tabDoJogo.haMarcaNaPosicao(0,2) &&
                     adv.equals(tabDoJogo.getMarcaNaPosicao(1,1)) &&
                     adv.equals(tabDoJogo.getMarcaNaPosicao(2,0)))
                tabDoJogo.setMarcaNaPosicao(marca,0,2);
            else if (adv.equals(tabDoJogo.getMarcaNaPosicao(0,2)) &&
                     !tabDoJogo.haMarcaNaPosicao(1,1) &&
                     adv.equals(tabDoJogo.getMarcaNaPosicao(2,0)))
                tabDoJogo.setMarcaNaPosicao(marca,1,1);
            else if (adv.equals(tabDoJogo.getMarcaNaPosicao(0,2)) &&
                     adv.equals(tabDoJogo.getMarcaNaPosicao(1,1)) &&
                     !tabDoJogo.haMarcaNaPosicao(2,0))
                tabDoJogo.setMarcaNaPosicao(marca,2,0);


            else if (marca.equals(tabDoJogo.getMarcaNaPosicao(0,0)) &&
                     !tabDoJogo.haMarcaNaPosicao(0,1) &&
                     !tabDoJogo.haMarcaNaPosicao(0,2))
                tabDoJogo.setMarcaNaPosicao(marca,0,1);
            else if (!tabDoJogo.haMarcaNaPosicao(0,0) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(0,1)) &&
                     !tabDoJogo.haMarcaNaPosicao(0,2))
                tabDoJogo.setMarcaNaPosicao(marca,0,0);
            else if (!tabDoJogo.haMarcaNaPosicao(0,0) &&
                     !tabDoJogo.haMarcaNaPosicao(0,1) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(0,2)))
                tabDoJogo.setMarcaNaPosicao(marca,0,0);

            else if (marca.equals(tabDoJogo.getMarcaNaPosicao(1,0)) &&
                     !tabDoJogo.haMarcaNaPosicao(1,1) &&
                     !tabDoJogo.haMarcaNaPosicao(1,2))
                tabDoJogo.setMarcaNaPosicao(marca,1,1);
            else if (!tabDoJogo.haMarcaNaPosicao(1,0) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(1,1)) &&
                     !tabDoJogo.haMarcaNaPosicao(1,2))
                tabDoJogo.setMarcaNaPosicao(marca,1,0);
            else if (!tabDoJogo.haMarcaNaPosicao(1,0) &&
                     !tabDoJogo.haMarcaNaPosicao(1,1) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(1,2)))
                tabDoJogo.setMarcaNaPosicao(marca,1,0);

            else if (marca.equals(tabDoJogo.getMarcaNaPosicao(2,0)) &&
                     !tabDoJogo.haMarcaNaPosicao(2,1) &&
                     !tabDoJogo.haMarcaNaPosicao(2,2))
                tabDoJogo.setMarcaNaPosicao(marca,2,1);
            else if (!tabDoJogo.haMarcaNaPosicao(2,0) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(2,1)) &&
                     !tabDoJogo.haMarcaNaPosicao(2,2))
                tabDoJogo.setMarcaNaPosicao(marca,2,0);
            else if (!tabDoJogo.haMarcaNaPosicao(2,0) &&
                     !tabDoJogo.haMarcaNaPosicao(2,1) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(2,2)))
                tabDoJogo.setMarcaNaPosicao(marca,2,0);

            else if (marca.equals(tabDoJogo.getMarcaNaPosicao(0,0)) &&
                     !tabDoJogo.haMarcaNaPosicao(1,0) &&
                     !tabDoJogo.haMarcaNaPosicao(2,0))
                tabDoJogo.setMarcaNaPosicao(marca,1,0);
            else if (!tabDoJogo.haMarcaNaPosicao(0,0) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(1,0)) &&
                     !tabDoJogo.haMarcaNaPosicao(2,0))
                tabDoJogo.setMarcaNaPosicao(marca,0,0);
            else if (!tabDoJogo.haMarcaNaPosicao(0,0) &&
                     !tabDoJogo.haMarcaNaPosicao(1,0) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(2,0)))
                tabDoJogo.setMarcaNaPosicao(marca,0,0);

            else if (marca.equals(tabDoJogo.getMarcaNaPosicao(0,1)) &&
                     !tabDoJogo.haMarcaNaPosicao(1,1) &&
                     !tabDoJogo.haMarcaNaPosicao(2,1))
                tabDoJogo.setMarcaNaPosicao(marca,1,1);
            else if (!tabDoJogo.haMarcaNaPosicao(0,1) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(1,1)) &&
                     !tabDoJogo.haMarcaNaPosicao(2,1))
                tabDoJogo.setMarcaNaPosicao(marca,0,1);
            else if (!tabDoJogo.haMarcaNaPosicao(0,1) &&
                     !tabDoJogo.haMarcaNaPosicao(1,1) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(2,1)))
                tabDoJogo.setMarcaNaPosicao(marca,0,1);

            else if (marca.equals(tabDoJogo.getMarcaNaPosicao(0,2)) &&
                     !tabDoJogo.haMarcaNaPosicao(1,2) &&
                     !tabDoJogo.haMarcaNaPosicao(2,2))
                tabDoJogo.setMarcaNaPosicao(marca,1,2);
            else if (!tabDoJogo.haMarcaNaPosicao(0,2) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(1,2)) &&
                     !tabDoJogo.haMarcaNaPosicao(2,2))
                tabDoJogo.setMarcaNaPosicao(marca,0,2);
            else if (!tabDoJogo.haMarcaNaPosicao(0,2) &&
                     !tabDoJogo.haMarcaNaPosicao(1,2) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(2,2)))
                tabDoJogo.setMarcaNaPosicao(marca,0,2);

            else if (marca.equals(tabDoJogo.getMarcaNaPosicao(0,0)) &&
                     !tabDoJogo.haMarcaNaPosicao(1,1) &&
                     !tabDoJogo.haMarcaNaPosicao(2,2))
                tabDoJogo.setMarcaNaPosicao(marca,1,1);
            else if (!tabDoJogo.haMarcaNaPosicao(0,0) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(1,1)) &&
                     !tabDoJogo.haMarcaNaPosicao(2,2))
                tabDoJogo.setMarcaNaPosicao(marca,0,0);
            else if (!tabDoJogo.haMarcaNaPosicao(0,0) &&
                     !tabDoJogo.haMarcaNaPosicao(1,1) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(2,2)))
                tabDoJogo.setMarcaNaPosicao(marca,0,0);

            else if (marca.equals(tabDoJogo.getMarcaNaPosicao(0,2)) &&
                     !tabDoJogo.haMarcaNaPosicao(1,1) &&
                     !tabDoJogo.haMarcaNaPosicao(2,0))
                tabDoJogo.setMarcaNaPosicao(marca,1,1);
            else if (!tabDoJogo.haMarcaNaPosicao(0,2) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(1,1)) &&
                     !tabDoJogo.haMarcaNaPosicao(2,0))
                tabDoJogo.setMarcaNaPosicao(marca,0,2);
            else if (!tabDoJogo.haMarcaNaPosicao(0,2) &&
                     !tabDoJogo.haMarcaNaPosicao(1,1) &&
                     marca.equals(tabDoJogo.getMarcaNaPosicao(2,0)))
                tabDoJogo.setMarcaNaPosicao(marca,0,2);


            else
            {
                for (int lin = 0; lin < 3; lin++)
                    for (int col = 0; col < 3; col++)
                        if (!tabDoJogo.haMarcaNaPosicao(lin, col))
                        {
                            tabDoJogo.setMarcaNaPosicao(marca, lin, col);
                            return;
                        }
            }
        }
        catch (Exception erro)
        {}
    }
}
