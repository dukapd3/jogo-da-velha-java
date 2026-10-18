package jogo;

public class Tabuleiro implements Cloneable {
    private Marca matriz[][] = new Marca[3][3];

    public Tabuleiro() {
    }


    private void validarTabuleiro(int lin, int col) throws Exception {
        if (lin < 0 || lin > 2 || col > 2 || col < 0) throw new Exception("Posicao invalida");
    }

    public boolean haMarcaNaPosicao(int lin, int col) throws Exception {
        validarTabuleiro(lin, col);

        return matriz[lin][col] != null;

    }

    public Marca getMarcaNaPosicao(int lin, int col) throws Exception {
        validarTabuleiro(lin, col);

        return this.matriz[lin][col];

    }

    public void setMarcaNaPosicao(Marca mrc, int lin, int col) throws Exception {
        if (haMarcaNaPosicao(lin, col)) throw new Exception("Posicao ja ocupada");
        if (mrc == null) throw new Exception("Valor Vazio");

        matriz[lin][col] = mrc;

    }

    @Override
    public String toString() {
        String ret = "    1   2   3\n";

        for (int l = 0; l < 3; l++) {
            ret += (l + 1) + "  ";

            for (int c = 0; c < 3; c++) {
                ret += " " + (this.matriz[l][c] == null ? " " : this.matriz[l][c].toString()) + " ";

                if (c < 2) ret += "|";
            }

            ret += "\n";

            if (l < 2) ret += "   ---+---+---\n";
        }

        return ret;
        // retornar em um String o tabuleiro
        // formatado para ser exibido na tela
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        Tabuleiro tab = (Tabuleiro) obj;

        for (int l = 0; l < 3; l++) {
            for (int c = 0; c < 3; c++) {
                if (this.matriz[l][c] == null) {
                    if (tab.matriz[l][c] != null) {
                        return false;
                    }
                } else {
                    if (!this.matriz[l][c].equals(tab.matriz[l][c])) {
                        return false;
                    }
                }
            }
        }

        return true;
        // retornar true se this for igual a obj ou false caso contrario
    }

    @Override
    public int hashCode() {
        int retorno = 1;

        for (int l = 0; l < 3; l++) {
            for (int c = 0; c < 3; c++) {
                retorno = retorno * 2 + (this.matriz[l][c] == null ? 0 : this.matriz[l][c].hashCode());
            }
        }
        if (retorno < 0) retorno = -retorno;

        return retorno;
    }

    public Tabuleiro(Tabuleiro modelo) throws Exception {
        if (modelo == null) {
            throw new Exception("Modelo Ausente");

        }

        for (int l = 0; l < 3; l++) {
            for (int c = 0; c < 3; c++) {
                this.matriz[l][c] = modelo.matriz[l][c];
            }
        }
    }

    @Override
    public Object clone() {
        Tabuleiro retorno = null;

        try {
            retorno = new Tabuleiro(this);
        } catch (Exception erro) {
        }
        return retorno;
    }
}