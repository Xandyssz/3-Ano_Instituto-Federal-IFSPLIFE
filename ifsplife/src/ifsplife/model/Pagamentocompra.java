package ifsplife.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pagamentocompra")
@NamedQueries({
    @NamedQuery(name = "Pagamentocompra.findAll", query = "SELECT p FROM Pagamentocompra p"),
    @NamedQuery(name = "Pagamentocompra.findByCodigoCompra", query = "SELECT p FROM Pagamentocompra p WHERE p.codigoCompra = :codigoCompra"),
    @NamedQuery(name = "Pagamentocompra.findByParcela", query = "SELECT p FROM Pagamentocompra p WHERE p.parcela = :parcela"),
    @NamedQuery(name = "Pagamentocompra.findByVencimento", query = "SELECT p FROM Pagamentocompra p WHERE p.vencimento = :vencimento"),
    @NamedQuery(name = "Pagamentocompra.findByValor", query = "SELECT p FROM Pagamentocompra p WHERE p.valor = :valor")})
public class Pagamentocompra implements Serializable {

    @Id

    @Column(name = "codigo_compra")
    private Integer codigoCompra;

    @Column(name = "parcela")
    private int parcela;

    @Column(name = "vencimento")
    @Temporal(TemporalType.DATE)
    private Date vencimento;

    @Column(name = "valor")
    private float valor;
    @JoinColumn(name = "caixa_idcaixa", referencedColumnName = "codigo_caixa")
    @ManyToOne
    private Caixa caixaIdcaixa;
    @JoinColumn(name = "codigo_compra", referencedColumnName = "codigo_compra", insertable = false, updatable = false)
    @OneToOne
    private Compras compras;

    public Pagamentocompra() {
    }

    public Pagamentocompra(Integer codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public Pagamentocompra(Integer codigoCompra, int parcela, Date vencimento, float valor) {
        this.codigoCompra = codigoCompra;
        this.parcela = parcela;
        this.vencimento = vencimento;
        this.valor = valor;
    }

    public Integer getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(Integer codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public int getParcela() {
        return parcela;
    }

    public void setParcela(int parcela) {
        this.parcela = parcela;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Caixa getCaixaIdcaixa() {
        return caixaIdcaixa;
    }

    public void setCaixaIdcaixa(Caixa caixaIdcaixa) {
        this.caixaIdcaixa = caixaIdcaixa;
    }

    public Compras getCompras() {
        return compras;
    }

    public void setCompras(Compras compras) {
        this.compras = compras;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCompra != null ? codigoCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Pagamentocompra)) {
            return false;
        }
        Pagamentocompra other = (Pagamentocompra) object;
        if ((this.codigoCompra == null && other.codigoCompra != null) || (this.codigoCompra != null && !this.codigoCompra.equals(other.codigoCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifsplife.model.Pagamentocompra[ codigoCompra=" + codigoCompra + " ]";
    }

}
