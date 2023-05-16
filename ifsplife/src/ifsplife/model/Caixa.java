package ifsplife.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
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
@Table(name = "caixa")
@NamedQueries({
    @NamedQuery(name = "Caixa.findAll", query = "SELECT c FROM Caixa c")})
public class Caixa implements Serializable {

    @Id
    @Column(name = "codigo_caixa", nullable = false)
    private Integer codigo_caixa;

    @Column(name = "abertura", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date abertura;

    @Column(name = "fechamento", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date fechamento;

    @Column(name = "saldo", nullable = false)
    private double saldo;

    @Column(name = "status", nullable = false)
    private Character status;

    @Column(name = "totalentradas", nullable = false)
    private double totalentradas;

    @Column(name = "totalsaidas", nullable = false)
    private double totalsaidas;

    @Column(name = "valorabertura", nullable = false)
    private double valorabertura;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "caixa_idcaixa")
    private List<Vendas> vendas = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
             mappedBy = "caixa_idcaixa")
    private List<Pagamentocompra> pagamentocompra = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
             mappedBy = "codigo_caixa")
    private List<Movimentacao> movimentacao = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
             mappedBy = "codigo_caixa")
    private List<Sangria> sangria = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
             mappedBy = "codigo_caixa")
    private List<CaixaDespesas> caixaDespesas = new ArrayList<>();

    public Caixa() {
    }

    public Caixa(Integer codigo_caixa, Date abertura, Date fechamento, double saldo, Character status, double totalentradas, double totalsaidas, double valorabertura, List<Vendas> vendas, List<Pagamentocompra> pagamentocompra, List<Movimentacao> movimentacao, List<Sangria> sangria, List<CaixaDespesas> caixaDespesas) {
        this.codigo_caixa = codigo_caixa;
        this.abertura = abertura;
        this.fechamento = fechamento;
        this.saldo = saldo;
        this.status = status;
        this.totalentradas = totalentradas;
        this.totalsaidas = totalsaidas;
        this.valorabertura = valorabertura;
        this.vendas = vendas;
        this.pagamentocompra = pagamentocompra;
        this.movimentacao = movimentacao;
        this.sangria = sangria;
        this.caixaDespesas = caixaDespesas;
    }

    public Integer getCodigo_caixa() {
        return codigo_caixa;
    }

    public void setCodigo_caixa(Integer codigo_caixa) {
        this.codigo_caixa = codigo_caixa;
    }

    public Date getAbertura() {
        return abertura;
    }

    public void setAbertura(Date abertura) {
        this.abertura = abertura;
    }

    public Date getFechamento() {
        return fechamento;
    }

    public void setFechamento(Date fechamento) {
        this.fechamento = fechamento;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public double getTotalentradas() {
        return totalentradas;
    }

    public void setTotalentradas(double totalentradas) {
        this.totalentradas = totalentradas;
    }

    public double getTotalsaidas() {
        return totalsaidas;
    }

    public void setTotalsaidas(double totalsaidas) {
        this.totalsaidas = totalsaidas;
    }

    public double getValorabertura() {
        return valorabertura;
    }

    public void setValorabertura(double valorabertura) {
        this.valorabertura = valorabertura;
    }

    public List<Vendas> getVendas() {
        return vendas;
    }

    public void setVendas(List<Vendas> vendas) {
        this.vendas = vendas;
    }

    public List<Pagamentocompra> getPagamentocompra() {
        return pagamentocompra;
    }

    public void setPagamentocompra(List<Pagamentocompra> pagamentocompra) {
        this.pagamentocompra = pagamentocompra;
    }

    public List<Movimentacao> getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(List<Movimentacao> movimentacao) {
        this.movimentacao = movimentacao;
    }

    public List<Sangria> getSangria() {
        return sangria;
    }

    public void setSangria(List<Sangria> sangria) {
        this.sangria = sangria;
    }

    public List<CaixaDespesas> getCaixaDespesas() {
        return caixaDespesas;
    }

    public void setCaixaDespesas(List<CaixaDespesas> caixaDespesas) {
        this.caixaDespesas = caixaDespesas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.codigo_caixa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Caixa other = (Caixa) obj;
        return Objects.equals(this.codigo_caixa, other.codigo_caixa);
    }

}
