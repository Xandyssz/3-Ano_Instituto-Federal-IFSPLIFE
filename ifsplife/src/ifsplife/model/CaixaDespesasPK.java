package ifsplife.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CaixaDespesasPK implements Serializable {

    
    @Column(name = "codigo_caixa", nullable = false)
    private int codigoCaixa;
    
    @Column(name = "codigo_despesa", nullable = false)
    private int codigoDespesa;

    public CaixaDespesasPK() {
    }

    public CaixaDespesasPK(int codigoCaixa, int codigoDespesa) {
        this.codigoCaixa = codigoCaixa;
        this.codigoDespesa = codigoDespesa;
    }

    public int getCodigoCaixa() {
        return codigoCaixa;
    }

    public void setCodigoCaixa(int codigoCaixa) {
        this.codigoCaixa = codigoCaixa;
    }

    public int getCodigoDespesa() {
        return codigoDespesa;
    }

    public void setCodigoDespesa(int codigoDespesa) {
        this.codigoDespesa = codigoDespesa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoCaixa;
        hash += (int) codigoDespesa;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CaixaDespesasPK)) {
            return false;
        }
        CaixaDespesasPK other = (CaixaDespesasPK) object;
        if (this.codigoCaixa != other.codigoCaixa) {
            return false;
        }
        if (this.codigoDespesa != other.codigoDespesa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifsplife.model.CaixaDespesasPK[ codigoCaixa=" + codigoCaixa + ", codigoDespesa=" + codigoDespesa + " ]";
    }
    
}
