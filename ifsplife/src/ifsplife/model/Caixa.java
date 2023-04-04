package ifsplife.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "caixa", catalog = "ifsplife", schema = "")
@NamedQueries({
    @NamedQuery(name = "Caixa.findAll", query = "SELECT c FROM Caixa c"),
    @NamedQuery(name = "Caixa.findByCodigoCaixa", query = "SELECT c FROM Caixa c WHERE c.codigoCaixa = :codigoCaixa"),
    @NamedQuery(name = "Caixa.findByStatus", query = "SELECT c FROM Caixa c WHERE c.status = :status"),
    @NamedQuery(name = "Caixa.findByAbertura", query = "SELECT c FROM Caixa c WHERE c.abertura = :abertura"),
    @NamedQuery(name = "Caixa.findByValorabertura", query = "SELECT c FROM Caixa c WHERE c.valorabertura = :valorabertura"),
    @NamedQuery(name = "Caixa.findByTotalentradas", query = "SELECT c FROM Caixa c WHERE c.totalentradas = :totalentradas"),
    @NamedQuery(name = "Caixa.findByFechamento", query = "SELECT c FROM Caixa c WHERE c.fechamento = :fechamento"),
    @NamedQuery(name = "Caixa.findByTotalsaidas", query = "SELECT c FROM Caixa c WHERE c.totalsaidas = :totalsaidas"),
    @NamedQuery(name = "Caixa.findBySaldo", query = "SELECT c FROM Caixa c WHERE c.saldo = :saldo")})
public class Caixa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo_caixa", nullable = false)
    private Integer codigoCaixa;
    @Basic(optional = false)
    @Column(name = "status", nullable = false)
    private Character status;
    @Basic(optional = false)
    @Column(name = "abertura", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date abertura;
    @Basic(optional = false)
    @Column(name = "valorabertura", nullable = false)
    private double valorabertura;
    @Basic(optional = false)
    @Column(name = "totalentradas", nullable = false)
    private double totalentradas;
    @Basic(optional = false)
    @Column(name = "fechamento", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date fechamento;
    @Basic(optional = false)
    @Column(name = "totalsaidas", nullable = false)
    private double totalsaidas;
    @Basic(optional = false)
    @Column(name = "saldo", nullable = false)
    private double saldo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caixaIdcaixa")
    private Collection<Vendas> vendasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caixaIdcaixa")
    private Collection<Pagamentocompra> pagamentocompraCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caixa")
    private Collection<Movimentacao> movimentacaoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caixa")
    private Collection<CaixaDespesas> caixaHasDespesasCollection;

    public Caixa() {
    }

    public Caixa(Integer codigoCaixa) {
        this.codigoCaixa = codigoCaixa;
    }

    public Caixa(Integer codigoCaixa, Character status, Date abertura, double valorabertura, double totalentradas, Date fechamento, double totalsaidas, double saldo) {
        this.codigoCaixa = codigoCaixa;
        this.status = status;
        this.abertura = abertura;
        this.valorabertura = valorabertura;
        this.totalentradas = totalentradas;
        this.fechamento = fechamento;
        this.totalsaidas = totalsaidas;
        this.saldo = saldo;
    }

    public Integer getCodigoCaixa() {
        return codigoCaixa;
    }

    public void setCodigoCaixa(Integer codigoCaixa) {
        this.codigoCaixa = codigoCaixa;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Date getAbertura() {
        return abertura;
    }

    public void setAbertura(Date abertura) {
        this.abertura = abertura;
    }

    public double getValorabertura() {
        return valorabertura;
    }

    public void setValorabertura(double valorabertura) {
        this.valorabertura = valorabertura;
    }

    public double getTotalentradas() {
        return totalentradas;
    }

    public void setTotalentradas(double totalentradas) {
        this.totalentradas = totalentradas;
    }

    public Date getFechamento() {
        return fechamento;
    }

    public void setFechamento(Date fechamento) {
        this.fechamento = fechamento;
    }

    public double getTotalsaidas() {
        return totalsaidas;
    }

    public void setTotalsaidas(double totalsaidas) {
        this.totalsaidas = totalsaidas;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Collection<Vendas> getVendasCollection() {
        return vendasCollection;
    }

    public void setVendasCollection(Collection<Vendas> vendasCollection) {
        this.vendasCollection = vendasCollection;
    }

    public Collection<Pagamentocompra> getPagamentocompraCollection() {
        return pagamentocompraCollection;
    }

    public void setPagamentocompraCollection(Collection<Pagamentocompra> pagamentocompraCollection) {
        this.pagamentocompraCollection = pagamentocompraCollection;
    }

    public Collection<Movimentacao> getMovimentacaoCollection() {
        return movimentacaoCollection;
    }

    public void setMovimentacaoCollection(Collection<Movimentacao> movimentacaoCollection) {
        this.movimentacaoCollection = movimentacaoCollection;
    }

    public Collection<CaixaDespesas> getCaixaHasDespesasCollection() {
        return caixaHasDespesasCollection;
    }

    public void setCaixaHasDespesasCollection(Collection<CaixaDespesas> caixaHasDespesasCollection) {
        this.caixaHasDespesasCollection = caixaHasDespesasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCaixa != null ? codigoCaixa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Caixa)) {
            return false;
        }
        Caixa other = (Caixa) object;
        if ((this.codigoCaixa == null && other.codigoCaixa != null) || (this.codigoCaixa != null && !this.codigoCaixa.equals(other.codigoCaixa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifsplife.model.Caixa[ codigoCaixa=" + codigoCaixa + " ]";
    }
    
}
