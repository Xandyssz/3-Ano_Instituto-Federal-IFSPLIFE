package ifsplife.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "vendas", catalog = "ifsplife", schema = "")
@NamedQueries({
    @NamedQuery(name = "Vendas.findAll", query = "SELECT v FROM Vendas v"),
    @NamedQuery(name = "Vendas.findByCodigoVenda", query = "SELECT v FROM Vendas v WHERE v.codigoVenda = :codigoVenda"),
    @NamedQuery(name = "Vendas.findByDataVenda", query = "SELECT v FROM Vendas v WHERE v.dataVenda = :dataVenda"),
    @NamedQuery(name = "Vendas.findByValorVenda", query = "SELECT v FROM Vendas v WHERE v.valorVenda = :valorVenda"),
    @NamedQuery(name = "Vendas.findByFormaPagamento", query = "SELECT v FROM Vendas v WHERE v.formaPagamento = :formaPagamento")})
public class Vendas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_venda", nullable = false)
    private Integer codigoVenda;

    @Column(name = "data_venda", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataVenda;

    @Column(name = "valor_venda", nullable = false)
    private float valorVenda;

    @Column(name = "forma_pagamento", nullable = false)
    private Character formaPagamento;
    @JoinColumn(name = "caixa_idcaixa", referencedColumnName = "codigo_caixa", nullable = false)
    @ManyToOne(optional = false)
    private Caixa caixaIdcaixa;
    @JoinColumn(name = "codigo_convenio", referencedColumnName = "codigo_convenio", nullable = false)
    @ManyToOne(optional = false)
    private Convenios codigoConvenio;

    public Vendas() {
    }

    public Vendas(Integer codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public Vendas(Integer codigoVenda, Date dataVenda, float valorVenda, Character formaPagamento) {
        this.codigoVenda = codigoVenda;
        this.dataVenda = dataVenda;
        this.valorVenda = valorVenda;
        this.formaPagamento = formaPagamento;
    }

    public Integer getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(Integer codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Character getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(Character formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Caixa getCaixaIdcaixa() {
        return caixaIdcaixa;
    }

    public void setCaixaIdcaixa(Caixa caixaIdcaixa) {
        this.caixaIdcaixa = caixaIdcaixa;
    }

    public Convenios getCodigoConvenio() {
        return codigoConvenio;
    }

    public void setCodigoConvenio(Convenios codigoConvenio) {
        this.codigoConvenio = codigoConvenio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoVenda != null ? codigoVenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Vendas)) {
            return false;
        }
        Vendas other = (Vendas) object;
        if ((this.codigoVenda == null && other.codigoVenda != null) || (this.codigoVenda != null && !this.codigoVenda.equals(other.codigoVenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifsplife.model.Vendas[ codigoVenda=" + codigoVenda + " ]";
    }

}
