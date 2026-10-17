import jogo.*;
import jogador.JogadorAutomatico;

public class TesteAutomatico
{
    private static Tabuleiro criarTabuleiro (String casas) throws Exception
    {
        Tabuleiro tab = new Tabuleiro();
        for (int i = 0; i < 9; i++)
            if (casas.charAt(i) != '-')
                tab.setMarcaNaPosicao(new Marca(casas.charAt(i)), i / 3, i % 3);
        return tab;
    }

    private static void testarJogada (String casas, char simbolo, int lin, int col) throws Exception
    {
        Tabuleiro tab = criarTabuleiro(casas);
        Marca marca = new Marca(simbolo);
        JogadorAutomatico jogador = new JogadorAutomatico(tab, marca);
        if (jogador.getMarca() != marca)
            throw new Exception("Marca do jogador incorreta");

        jogador.facaSuaJogada();

        for (int i = 0; i < 9; i++)
        {
            Marca atual = tab.getMarcaNaPosicao(i / 3, i % 3);
            char esperado = i == lin * 3 + col ? simbolo : casas.charAt(i);
            if (esperado == '-')
            {
                if (atual != null)
                    throw new Exception("Jogou em mais de uma casa");
            }
            else if (atual == null || atual.getSimbolo() != esperado)
                throw new Exception("Jogada incorreta em " + i / 3 + "," + i % 3);
        }
    }

    private static void testarVitoriasEBloqueios () throws Exception
    {
        int[][] sequencias = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}
        };

        for (char simbolo : new char[] {'X', 'O'})
        {
            char adversario = simbolo == 'X' ? 'O' : 'X';
            for (int[] sequencia : sequencias)
                for (int vazia = 0; vazia < 3; vazia++)
                {
                    char[] casas = "---------".toCharArray();
                    for (int i = 0; i < 3; i++)
                        if (i != vazia)
                            casas[sequencia[i]] = simbolo;
                    int posicao = sequencia[vazia];
                    testarJogada(new String(casas), simbolo, posicao / 3, posicao % 3);

                    for (int i = 0; i < 3; i++)
                        if (i != vazia)
                            casas[sequencia[i]] = adversario;
                    testarJogada(new String(casas), simbolo, posicao / 3, posicao % 3);
                }
        }
    }

    private static void testarPrioridades () throws Exception
    {
        testarJogada("XX-OO----", 'X', 0, 2);
        testarJogada("OO-X-----", 'X', 0, 2);
    }

    private static void testarJogadasDeFuturo () throws Exception
    {
        testarJogada("X--------", 'X', 0, 1);
        testarJogada("-X-------", 'X', 0, 0);
        testarJogada("--X------", 'X', 0, 0);
    }

    private static void testarCasasLivres () throws Exception
    {
        testarJogada("---------", 'O', 0, 0);
        testarJogada("XOX-XOOXO", 'X', 1, 0);
        testarJogada("XOXXOOOXX", 'O', 0, 1);
    }

    private static void testarMarcaSorteadaETabuleiroCompartilhado () throws Exception
    {
        Tabuleiro tab = new Tabuleiro();
        JogadorAutomatico jogador = new JogadorAutomatico(tab);
        char simbolo = jogador.getMarca().getSimbolo();
        if (simbolo != 'X' && simbolo != 'O')
            throw new Exception("Marca sorteada invalida");
        jogador.facaSuaJogada();
        if (!jogador.getMarca().equals(tab.getMarcaNaPosicao(0, 0)))
            throw new Exception("Tabuleiro nao foi compartilhado");
    }

    private static void testarConstrutoresInvalidos () throws Exception
    {
        Tabuleiro tab = new Tabuleiro();

        for (int caso = 0; caso < 3; caso++)
        {
            boolean rejeitou = false;
            try
            {
                if (caso == 0)
                    new JogadorAutomatico(null);
                else if (caso == 1)
                    new JogadorAutomatico(null, new Marca('X'));
                else
                    new JogadorAutomatico(tab, null);
            }
            catch (Exception erro)
            {
                rejeitou = true;
            }
            if (!rejeitou)
                throw new Exception("Construtor aceitou valor nulo");
        }
    }

    public static void main (String[] args) throws Exception
    {
        testarVitoriasEBloqueios();
        testarPrioridades();
        testarJogadasDeFuturo();
        testarCasasLivres();
        testarMarcaSorteadaETabuleiroCompartilhado();
        testarConstrutoresInvalidos();

        System.out.println("Testes do jogador automatico passaram.");
    }
}
