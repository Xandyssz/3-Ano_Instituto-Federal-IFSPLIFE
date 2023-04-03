/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifsplife.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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

/**
 *
 * @author xandy
 */
@Entity
@Table(name = "caixa_has_despesas", catalog = "ifsplife", schema = "")
@NamedQueries({
    @NamedQuery(name = "CaixaHasDespesas.findAll", query = "SELECT c FROM CaixaHasDespesas c"),
    @NamedQuery(name = "CaixaHasDespesas.findByCodigoCaixa", query = "SELECT c FROM CaixaHasDespesas c WHERE c.caixaHasDespesasPK.codigoCaixa = :codigoCaixa"),
    @NamedQuery(name = "CaixaHasDespesas.findByCodigoDespesa", query = "SELECT c FROM CaixaHasDespesas c WHERE c.caixaHasDespesasPK.codigoDespesa = :codigoDespesa"),
    @NamedQuery(name = "CaixaHasDespesas.findByDataPagamento", query = "SELECT c FROM CaixaHasDespesas c WHERE c.dataPagamento = :dataPagamento")})
public class CaixaHasDespesas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CaixaHasDespesasPK caixaHasDespesasPK;
    @Basic(optional = false)
    @Column(name = "data_pagamento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataPagamento;
    @JoinColumn(name = "codigo_caixa", referencedColumnName = "codigo_caixa", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Caixa caixa;
    @JoinColumn(name = "codigo_despesa", referencedColumnName = "codigo_despesa", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Despesas despesas;

    public CaixaHasDespesas() {
    }

    public CaixaHasDespesas(CaixaHasDespesasPK caixaHasDespesasPK) {
        this.caixaHasDespesasPK = caixaHasDespesasPK;
    }

    public CaixaHasDespesas(CaixaHasDespesasPK caixaHasDespesasPK, Date dataPagamento) {
        this.caixaHasDespesasPK = caixaHasDespesasPK;
        this.dataPagamento = dataPagamento;
    }

    public CaixaHasDespesas(int codigoCaixa, int codigoDespesa) {
        this.caixaHasDespesasPK = new CaixaHasDespesasPK(codigoCaixa, codigoDespesa);
    }

    public CaixaHasDespesasPK getCaixaHasDespesasPK() {
        return caixaHasDespesasPK;
    }

    public void setCaixaHasDespesasPK(CaixaHasDespesasPK caixaHasDespesasPK) {
        this.caixaHasDespesasPK = caixaHasDespesasPK;
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
        hash += (caixaHasDespesasPK != null ? caixaHasDespesasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CaixaHasDespesas)) {
            return false;
        }
        CaixaHasDespesas other = (CaixaHasDespesas) object;
        if ((this.caixaHasDespesasPK == null && other.caixaHasDespesasPK != null) || (this.caixaHasDespesasPK != null && !this.caixaHasDespesasPK.equals(other.caixaHasDespesasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifsplife.model.CaixaHasDespesas[ caixaHasDespesasPK=" + caixaHasDespesasPK + " ]";
    }
    
}
