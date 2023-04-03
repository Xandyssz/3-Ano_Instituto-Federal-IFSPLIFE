/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifsplife.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author xandy
 */
@Entity
@Table(name = "compras", catalog = "ifsplife", schema = "")
@NamedQueries({
    @NamedQuery(name = "Compras.findAll", query = "SELECT c FROM Compras c"),
    @NamedQuery(name = "Compras.findByCodigoCompra", query = "SELECT c FROM Compras c WHERE c.codigoCompra = :codigoCompra"),
    @NamedQuery(name = "Compras.findByDataCompra", query = "SELECT c FROM Compras c WHERE c.dataCompra = :dataCompra"),
    @NamedQuery(name = "Compras.findByFormaPagamento", query = "SELECT c FROM Compras c WHERE c.formaPagamento = :formaPagamento"),
    @NamedQuery(name = "Compras.findByValortotal", query = "SELECT c FROM Compras c WHERE c.valortotal = :valortotal")})
public class Compras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_compra", nullable = false)
    private Integer codigoCompra;
    @Basic(optional = false)
    @Column(name = "data_compra", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataCompra;
    @Basic(optional = false)
    @Column(name = "forma_pagamento", nullable = false)
    private Character formaPagamento;
    @Basic(optional = false)
    @Column(name = "valortotal", nullable = false)
    private double valortotal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compras")
    private Collection<Itemcompra> itemcompraCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "compras")
    private Pagamentocompra pagamentocompra;
    @JoinColumn(name = "codigo_fornecedor", referencedColumnName = "codigo_fornecedor", nullable = false)
    @ManyToOne(optional = false)
    private Fornecedores codigoFornecedor;

    public Compras() {
    }

    public Compras(Integer codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public Compras(Integer codigoCompra, Date dataCompra, Character formaPagamento, double valortotal) {
        this.codigoCompra = codigoCompra;
        this.dataCompra = dataCompra;
        this.formaPagamento = formaPagamento;
        this.valortotal = valortotal;
    }

    public Integer getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(Integer codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Character getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(Character formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public double getValortotal() {
        return valortotal;
    }

    public void setValortotal(double valortotal) {
        this.valortotal = valortotal;
    }

    public Collection<Itemcompra> getItemcompraCollection() {
        return itemcompraCollection;
    }

    public void setItemcompraCollection(Collection<Itemcompra> itemcompraCollection) {
        this.itemcompraCollection = itemcompraCollection;
    }

    public Pagamentocompra getPagamentocompra() {
        return pagamentocompra;
    }

    public void setPagamentocompra(Pagamentocompra pagamentocompra) {
        this.pagamentocompra = pagamentocompra;
    }

    public Fornecedores getCodigoFornecedor() {
        return codigoFornecedor;
    }

    public void setCodigoFornecedor(Fornecedores codigoFornecedor) {
        this.codigoFornecedor = codigoFornecedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCompra != null ? codigoCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compras)) {
            return false;
        }
        Compras other = (Compras) object;
        if ((this.codigoCompra == null && other.codigoCompra != null) || (this.codigoCompra != null && !this.codigoCompra.equals(other.codigoCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifsplife.model.Compras[ codigoCompra=" + codigoCompra + " ]";
    }
    
}
