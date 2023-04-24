package ifsplife.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "pagamento", catalog = "ifsplife", schema = "")
@NamedQueries({
    @NamedQuery(name = "Pagamento.findAll", query = "SELECT p FROM Pagamento p"),
    @NamedQuery(name = "Pagamento.findByCodigoPagamento", query = "SELECT p FROM Pagamento p WHERE p.pagamentoPK.codigoPagamento = :codigoPagamento"),
    @NamedQuery(name = "Pagamento.findByCodigoVenda", query = "SELECT p FROM Pagamento p WHERE p.pagamentoPK.codigoVenda = :codigoVenda"),
    @NamedQuery(name = "Pagamento.findByValor", query = "SELECT p FROM Pagamento p WHERE p.valor = :valor"),
    @NamedQuery(name = "Pagamento.findByForma", query = "SELECT p FROM Pagamento p WHERE p.forma = :forma")})
public class Pagamento implements Serializable {

    
    @EmbeddedId
    protected PagamentoId pagamentoPK;
    
    @Column(name = "valor", nullable = false)
    private double valor;
    
    @Column(name = "forma", nullable = false, length = 10)
    private String forma;
    @JoinColumn(name = "codigo_venda", referencedColumnName = "codigo_venda", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Vendas vendas;

    public Pagamento() {
    }

    public Pagamento(PagamentoId pagamentoPK) {
        this.pagamentoPK = pagamentoPK;
    }

    public Pagamento(PagamentoId pagamentoPK, double valor, String forma) {
        this.pagamentoPK = pagamentoPK;
        this.valor = valor;
        this.forma = forma;
    }

    public Pagamento(int codigoPagamento, int codigoVenda) {
        this.pagamentoPK = new PagamentoId(codigoPagamento, codigoVenda);
    }

    public PagamentoId getPagamentoPK() {
        return pagamentoPK;
    }

    public void setPagamentoPK(PagamentoId pagamentoPK) {
        this.pagamentoPK = pagamentoPK;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public Vendas getVendas() {
        return vendas;
    }

    public void setVendas(Vendas vendas) {
        this.vendas = vendas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pagamentoPK != null ? pagamentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Pagamento)) {
            return false;
        }
        Pagamento other = (Pagamento) object;
        if ((this.pagamentoPK == null && other.pagamentoPK != null) || (this.pagamentoPK != null && !this.pagamentoPK.equals(other.pagamentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifsplife.model.Pagamento[ pagamentoPK=" + pagamentoPK + " ]";
    }
    
}
