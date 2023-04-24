package ifsplife.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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

    @Id

    @Column(name = "codigo_caixa", nullable = false)
    private Integer codigoCaixa;

    @Column(name = "status", nullable = false)
    private Character status;

    @Column(name = "abertura", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date abertura;

    @Column(name = "valorabertura", nullable = false)
    private double valorabertura;

    @Column(name = "totalentradas", nullable = false)
    private double totalentradas;

    @Column(name = "fechamento", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date fechamento;

    @Column(name = "totalsaidas", nullable = false)
    private double totalsaidas;

    @Column(name = "saldo", nullable = false)
    private double saldo;

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
