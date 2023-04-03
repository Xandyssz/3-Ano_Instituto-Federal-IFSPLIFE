/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifsplife.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author xandy
 */
@Embeddable
public class CaixaHasDespesasPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "codigo_caixa", nullable = false)
    private int codigoCaixa;
    @Basic(optional = false)
    @Column(name = "codigo_despesa", nullable = false)
    private int codigoDespesa;

    public CaixaHasDespesasPK() {
    }

    public CaixaHasDespesasPK(int codigoCaixa, int codigoDespesa) {
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CaixaHasDespesasPK)) {
            return false;
        }
        CaixaHasDespesasPK other = (CaixaHasDespesasPK) object;
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
        return "ifsplife.model.CaixaHasDespesasPK[ codigoCaixa=" + codigoCaixa + ", codigoDespesa=" + codigoDespesa + " ]";
    }
    
}
