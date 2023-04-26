package ifsplife.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "caixa_despesas")
@NamedQueries({
    @NamedQuery(name = "CaixaDespesas.findAll", query = "SELECT c FROM CaixaDespesas c"),
    @NamedQuery(name = "CaixaDespesas.findByCodigoCaixa", query = "SELECT c FROM CaixaDespesas c WHERE c.caixaDespesasPK.codigoCaixa = :codigoCaixa"),
    @NamedQuery(name = "CaixaDespesas.findByCodigoDespesa", query = "SELECT c FROM CaixaDespesas c WHERE c.caixaDespesasPK.codigoDespesa = :codigoDespesa"),
    @NamedQuery(name = "CaixaDespesas.findByDataPagamento", query = "SELECT c FROM CaixaDespesas c WHERE c.dataPagamento = :dataPagamento")})
public class CaixaDespesas implements Serializable {

    @EmbeddedId
    protected CaixaDespesasID caixaDespesasPK;

    @Column(name = "data_pagamento")
    @Temporal(TemporalType.DATE)
    private Date dataPagamento;
    @JoinColumn(name = "codigo_caixa", referencedColumnName = "codigo_caixa", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Caixa caixa;
    @JoinColumn(name = "codigo_despesa", referencedColumnName = "codigo_despesa", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Despesas despesas;

    public CaixaDespesas() {
    }

    public CaixaDespesas(CaixaDespesasID caixaDespesasPK) {
        this.caixaDespesasPK = caixaDespesasPK;
    }

    public CaixaDespesas(CaixaDespesasID caixaDespesasPK, Date dataPagamento) {
        this.caixaDespesasPK = caixaDespesasPK;
        this.dataPagamento = dataPagamento;
    }

    public CaixaDespesas(int codigoCaixa, int codigoDespesa) {
        this.caixaDespesasPK = new CaixaDespesasID(codigoCaixa, codigoDespesa);
    }

    public CaixaDespesasID getCaixaDespesasPK() {
        return caixaDespesasPK;
    }

    public void setCaixaDespesasPK(CaixaDespesasID caixaDespesasPK) {
        this.caixaDespesasPK = caixaDespesasPK;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public Despesas getDespesas() {
        return despesas;
    }

    public void setDespesas(Despesas despesas) {
        this.despesas = despesas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (caixaDespesasPK != null ? caixaDespesasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CaixaDespesas)) {
            return false;
        }
        CaixaDespesas other = (CaixaDespesas) object;
        if ((this.caixaDespesasPK == null && other.caixaDespesasPK != null) || (this.caixaDespesasPK != null && !this.caixaDespesasPK.equals(other.caixaDespesasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifsplife.model.CaixaDespesas[ caixaDespesasPK=" + caixaDespesasPK + " ]";
    }

}
