package ifsplife.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MovimentacaoId implements Serializable {

    
    @Column(name = "codigo_movimentacao", nullable = false)
    private int codigoMovimentacao;
    
    @Column(name = "caixa_codigo_caixa", nullable = false)
    private int caixaCodigoCaixa;

    public MovimentacaoId() {
    }

    public MovimentacaoId(int codigoMovimentacao, int caixaCodigoCaixa) {
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovimentacaoId)) {
            return false;
        }
        MovimentacaoId other = (MovimentacaoId) object;
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
