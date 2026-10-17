package jogador;

import java.io.*;
import jogo.*;

public class JogadorHumano implements Jogador
{
    private Marca          marca     = null;
    private Tabuleiro      tabDoJogo = null;
    private BufferedReader teclado   = new BufferedReader
                                        (new InputStreamReader
                                        (System.in));

    // le uma linha do teclado, ja sem espacos nas pontas;
    // da excecao se a entrada de dados tiver sido encerrada
    private String leiaUmaLinha () throws Exception
    {
        String linha = this.teclado.readLine ();

        if (linha == null)
            throw new Exception ("Entrada de dados encerrada");

        return linha.trim ();
    }

    public JogadorHumano (Tabuleiro tab) throws Exception
    {
        // atribuir tab para tabDoJogo
        // pedir para o jogador escolher
        // sua marca e permitir digitacao
        // intanciando marca

        if (tab == null)
            throw new Exception ("Tabuleiro nao fornecido");

        this.tabDoJogo = tab;

        for (;;)
        {
            System.out.print ("Escolha sua marca (X ou O): ");
            String linha = this.leiaUmaLinha ();

            if (linha.length () != 1)
                System.err.println ("Marca invalida! Digite X ou O...");
            else
                try
                {
                    this.marca = new Marca (Character.toUpperCase (linha.charAt (0)));
                    break;
                }
                catch (Exception erro)
                {
                    System.err.println ("Marca invalida! Digite X ou O...");
                }
        }
    }

    public JogadorHumano (Tabuleiro tab, Marca mrc) throws Exception
    {
        // atribuir tab para tabDoJogo
        // e mrc para marca

        if (tab == null)
            throw new Exception ("Tabuleiro nao fornecido");

        if (mrc == null)
            throw new Exception ("Marca nao fornecida");

        this.tabDoJogo = tab;
        this.marca     = mrc;
    }

    public Marca getMarca ()
    {
        // retorna a marca do jogador

        return this.marca;
    }

    public void facaSuaJogada ()
    {
        // pergunta para o jogador onde ele quer
        // jogar, permitindo digitacao e chamando
        // os métodos apropriados de tabDoJogo

        System.out.println ();
        System.out.println (this.tabDoJogo);
        System.out.println ("Sua vez (" + this.marca + ")");

        for (;;)
        {
            try
            {
                System.out.print ("Linha  (1 a 3): ");
                int lin = Integer.parseInt (this.leiaUmaLinha ()) - 1;

                System.out.print ("Coluna (1 a 3): ");
                int col = Integer.parseInt (this.leiaUmaLinha ()) - 1;

                if (lin < 0 || lin > 2 || col < 0 || col > 2)
                    System.err.println ("Posicao invalida! Digite valores de 1 a 3...");
                else
                    if (this.tabDoJogo.haMarcaNaPosicao (lin, col))
                        System.err.println ("Posicao ocupada! Escolha outra...");
                    else
                    {
                        this.tabDoJogo.setMarcaNaPosicao (this.marca, lin, col);
                        break;
                    }
            }
            catch (NumberFormatException erro)
            {
                System.err.println ("Nao foi digitado um numero inteiro! Tente novamente...");
            }
            catch (Exception erro)
            {
                // so acontece se a entrada de dados for encerrada;
                // nao ha mais como ler a jogada
                System.err.println (erro.getMessage ());
                return;
            }
        }
    }

    public void vcGanhou ()
    {
        // mostra mensagem indicando vitoria

        System.out.println ();
        System.out.println (this.tabDoJogo);
        System.out.println ("Parabens! Voce ganhou!");
        System.out.println ();
    }

    public void vcPerdeu ()
    {
        // mostra mensagem indicando derrota

        System.out.println ();
        System.out.println (this.tabDoJogo);
        System.out.println ("Que pena! Voce perdeu!");
        System.out.println ();
    }

    public void deuVelha ()
    {
        // mostra mensagem indicando empate

        System.out.println ();
        System.out.println (this.tabDoJogo);
        System.out.println ("Deu velha! Ninguem ganhou!");
        System.out.println ();
    }

    public boolean querMaisUmaPartida ()
    {
        // perguntar se deseja jogar de novo
        // permitindo digitacao e retornando
        // true ou false, conforme a resposta

        for (;;)
        {
            System.out.print ("Jogar de novo? (S/N): ");

            try
            {
                String linha = this.leiaUmaLinha ();

                if (linha.equalsIgnoreCase ("S"))
                    return true;

                if (linha.equalsIgnoreCase ("N"))
                    return false;

                System.err.println ("Opcao invalida! Digite S ou N...");
            }
            catch (Exception erro)
            {
                return false; // entrada encerrada; nao ha como continuar jogando
            }
        }
    }

    @Override
    public String toString ()
    {
        return "Jogador humano (" + this.marca + ")";
    }

    @Override
    public boolean equals (Object obj)
    {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (this.getClass() != obj.getClass())
            return false;

        JogadorHumano jogador = (JogadorHumano)obj;

        if (!this.marca.equals (jogador.marca))
            return false;

        if (!this.tabDoJogo.equals (jogador.tabDoJogo))
            return false;

        return true;
    }

    @Override
    public int hashCode ()
    {
        int ret = 1;

        ret = 13*ret + this.marca    .hashCode();
        ret = 13*ret + this.tabDoJogo.hashCode();

        return ret;
    }
}
