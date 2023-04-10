package ifsplife.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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

@Entity
@Table(name = "compras", catalog = "ifsplife", schema = "")
@NamedQueries({
    @NamedQuery(name = "Compras.findAll", query = "SELECT c FROM Compras c"),
    @NamedQuery(name = "Compras.findByCodigoCompra", query = "SELECT c FROM Compras c WHERE c.codigoCompra = :codigoCompra"),
    @NamedQuery(name = "Compras.findByDataCompra", query = "SELECT c FROM Compras c WHERE c.dataCompra = :dataCompra"),
    @NamedQuery(name = "Compras.findByFormaPagamento", query = "SELECT c FROM Compras c WHERE c.formaPagamento = :formaPagamento"),
    @NamedQuery(name = "Compras.findByValortotal", query = "SELECT c FROM Compras c WHERE c.valortotal = :valortotal")})
public class Compras implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "codigo_compra", nullable = false)
    private Integer codigoCompra;

    @Column(name = "data_compra", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataCompra;

    @Column(name = "forma_pagamento", nullable = false)
    private Character formaPagamento;

    @Column(name = "valortotal", nullable = false)
    private double valortotal;

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
