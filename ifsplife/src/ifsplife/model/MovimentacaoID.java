package ifsplife.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MovimentacaoID implements Serializable {

    @Column(name = "codigo_movimentacao")
    private int codigoMovimentacao;

    @Column(name = "caixa_codigo_caixa")
    private int caixaCodigoCaixa;

    public MovimentacaoID() {
    }

    public MovimentacaoID(int codigoMovimentacao, int caixaCodigoCaixa) {
        this.codigoMovimentacao = codigoMovimentacao;
        this.caixaCodigoCaixa = caixaCodigoCaixa;
    }

    public int getCodigoMovimentacao() {
        return codigoMovimentacao;
    }

    public void setCodigoMovimentacao(int codigoMovimentacao) {
        this.codigoMovimentacao = codigoMovimentacao;
    }

    public int getCaixaCodigoCaixa() {
        return caixaCodigoCaixa;
    }

    public void setCaixaCodigoCaixa(int caixaCodigoCaixa) {
        this.caixaCodigoCaixa = caixaCodigoCaixa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoMovimentacao;
        hash += (int) caixaCodigoCaixa;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof MovimentacaoID)) {
            return false;
        }
        MovimentacaoID other = (MovimentacaoID) object;
        if (this.codigoMovimentacao != other.codigoMovimentacao) {
            return false;
        }
        if (this.caixaCodigoCaixa != other.caixaCodigoCaixa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifsplife.model.MovimentacaoPK[ codigoMovimentacao=" + codigoMovimentacao + ", caixaCodigoCaixa=" + caixaCodigoCaixa + " ]";
    }

}
