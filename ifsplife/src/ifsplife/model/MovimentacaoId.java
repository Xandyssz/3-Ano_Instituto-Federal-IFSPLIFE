package ifsplife.model;

import java.io.Serializable;

public class MovimentacaoId implements Serializable {

    private int codigo_caixa;
    private int codigo_movimentacao;

    public MovimentacaoId() {
    }

    public MovimentacaoId(int codigo_caixa, int codigo_movimentacao) {
        this.codigo_caixa = codigo_caixa;
        this.codigo_movimentacao = codigo_movimentacao;
    }

    public int getCodigo_caixa() {
        return codigo_caixa;
    }

    public void setCodigo_caixa(int codigo_caixa) {
        this.codigo_caixa = codigo_caixa;
    }

    public int getCodigo_movimentacao() {
        return codigo_movimentacao;
    }

    public void setCodigo_movimentacao(int codigo_movimentacao) {
        this.codigo_movimentacao = codigo_movimentacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.codigo_caixa;
        hash = 97 * hash + this.codigo_movimentacao;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MovimentacaoId other = (MovimentacaoId) obj;
        if (this.codigo_caixa != other.codigo_caixa) {
            return false;
        }
        return this.codigo_movimentacao == other.codigo_movimentacao;
    }


}
