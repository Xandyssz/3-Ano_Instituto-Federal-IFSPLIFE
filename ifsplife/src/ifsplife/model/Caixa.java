package ifsplife.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @NamedQuery(name = "Caixa.findAll", query = "SELECT c FROM Caixa c"),
    @NamedQuery(name = "Caixa.findByAbertura", query = "SELECT c FROM Caixa c WHERE c.data_abertura BETWEEN :inicio AND :fim"),
    @NamedQuery(name = "Caixa.findByFechamento", query = "SELECT c FROM Caixa c WHERE c.data_fechamento IS NULL")})

public class Caixa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_caixa", nullable = false)
    private int codigo_caixa;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "data_abertura", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data_abertura;

    @Column(name = "horario_abertura", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horario_abertura;

    @Column(name = "data_fechamento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data_fechamento;

    @Column(name = "horario_fechamento", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horario_fechamento;

    @Column(name = "total_entradas")
    private double total_entradas;

    @Column(name = "total_saidas")
    private double total_saidas;

    @Column(name = "valor_abertura")
    private double valor_abertura;

    @Column(name = "valor_fechamento")
    private double valor_fechamento;

    @OneToMany(cascade = CascadeType.REFRESH,
            mappedBy = "codigo_caixa")
    private List<Vendas> vendas = new ArrayList<>();

    @OneToMany(cascade = CascadeType.REFRESH,
            mappedBy = "codigo_caixa")
    private List<Pagamentocompra> pagamentocompra = new ArrayList<>();

    @OneToMany(cascade = CascadeType.REFRESH,
            mappedBy = "codigo_caixa")
    private List<Movimentacao> movimentacao = new ArrayList<>();

    @OneToMany(cascade = CascadeType.REFRESH,
            mappedBy = "codigo_caixa")
    private List<CaixaDespesas> caixaDespesas = new ArrayList<>();

    public Caixa() {
    }

    public Caixa(int codigo_caixa, String status, Date data_abertura, Date horario_abertura, Date data_fechamento, Date horario_fechamento, double total_entradas, double total_saidas, double valor_abertura, double valor_fechamento) {
        this.codigo_caixa = codigo_caixa;
        this.status = status;
        this.data_abertura = data_abertura;
        this.horario_abertura = horario_abertura;
        this.data_fechamento = data_fechamento;
        this.horario_fechamento = horario_fechamento;
        this.total_entradas = total_entradas;
        this.total_saidas = total_saidas;
        this.valor_abertura = valor_abertura;
        this.valor_fechamento = valor_fechamento;
    }

    public int getCodigo_caixa() {
        return codigo_caixa;
    }

    public void setCodigo_caixa(int codigo_caixa) {
        this.codigo_caixa = codigo_caixa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getSangria() {
        double soma_sangria = 0;
        for (Movimentacao mo : this.movimentacao) {
            if (mo.getTipo().equals("Sangria")) {
                soma_sangria += mo.getValor();
            }
        }
        return soma_sangria;
    }

    public double getSuplementacao() {
        double soma_suplementacao = 0;
        for (Movimentacao mo : this.movimentacao) {
            if (mo.getTipo().equals("Suplementação")) {
                soma_suplementacao += mo.getValor();
            }
        }
        return soma_suplementacao;
    }

    public Date getData_abertura() {
        return data_abertura;
    }

    public void setData_abertura(Date data_abertura) {
        this.data_abertura = data_abertura;
    }

    public Date getHorario_abertura() {
        return horario_abertura;
    }

    public void setHorario_abertura(Date horario_abertura) {
        this.horario_abertura = horario_abertura;
    }

    public Date getData_fechamento() {
        return data_fechamento;
    }

    public void setData_fechamento(Date data_fechamento) {
        this.data_fechamento = data_fechamento;
    }

    public Date getHorario_fechamento() {
        return horario_fechamento;
    }

    public void setHorario_fechamento(Date horario_fechamento) {
        this.horario_fechamento = horario_fechamento;
    }

    public Double getTotal_entradas() {
        return total_entradas;
    }

    public void setTotal_entradas(double total_entradas) {
        this.total_entradas = total_entradas;
    }

    public Double getTotal_saidas() {
        return total_saidas;
    }

    public void setTotal_saidas(double total_saidas) {
        this.total_saidas = total_saidas;
    }

    public Double getValor_abertura() {
        return valor_abertura;
    }

    public void setValor_abertura(double valor_abertura) {
        this.valor_abertura = valor_abertura;
    }

    public Double getValor_fechamento() {
        return valor_fechamento;
    }

    public void setValor_fechamento(double valor_fechamento) {
        this.valor_fechamento = valor_fechamento;
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

    public List<CaixaDespesas> getCaixaDespesas() {
        return caixaDespesas;
    }

    public void setCaixaDespesas(List<CaixaDespesas> caixaDespesas) {
        this.caixaDespesas = caixaDespesas;
    }

    public double getTotalMovimentacao() {
        double total = valor_abertura; // Start with the opening value
        for (Movimentacao m : movimentacao) {
            if (m.getTipo().equals("Sangria")) {
                total -= m.getValor(); // Subtract sangria
            } else {
                total += m.getValor();
            }
        }
        return total;
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
