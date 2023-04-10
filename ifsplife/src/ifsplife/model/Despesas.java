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
@Table(name = "despesas", catalog = "ifsplife", schema = "")
@NamedQueries({
    @NamedQuery(name = "Despesas.findAll", query = "SELECT d FROM Despesas d"),
    @NamedQuery(name = "Despesas.findByCodigoDespesa", query = "SELECT d FROM Despesas d WHERE d.codigoDespesa = :codigoDespesa"),
    @NamedQuery(name = "Despesas.findByNome", query = "SELECT d FROM Despesas d WHERE d.nome = :nome"),
    @NamedQuery(name = "Despesas.findByDescricao", query = "SELECT d FROM Despesas d WHERE d.descricao = :descricao"),
    @NamedQuery(name = "Despesas.findByValor", query = "SELECT d FROM Despesas d WHERE d.valor = :valor"),
    @NamedQuery(name = "Despesas.findByDataVencimento", query = "SELECT d FROM Despesas d WHERE d.dataVencimento = :dataVencimento"),
    @NamedQuery(name = "Despesas.findByStatus", query = "SELECT d FROM Despesas d WHERE d.status = :status")})
public class Despesas implements Serializable {

    @Id

    @Column(name = "codigo_despesa", nullable = false)
    private Integer codigoDespesa;

    @Column(name = "nome", nullable = false, length = 45)
    private String nome;

    @Column(name = "descricao", nullable = false, length = 255)
    private String descricao;

    @Column(name = "valor", nullable = false)
    private double valor;

    @Column(name = "data_vencimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    public Despesas() {
    }

    public Despesas(Integer codigoDespesa) {
        this.codigoDespesa = codigoDespesa;
    }

    public Despesas(Integer codigoDespesa, String nome, String descricao, double valor, Date dataVencimento, String status) {
        this.codigoDespesa = codigoDespesa;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.status = status;
    }

    public Integer getCodigoDespesa() {
        return codigoDespesa;
    }

    public void setCodigoDespesa(Integer codigoDespesa) {
        this.codigoDespesa = codigoDespesa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoDespesa != null ? codigoDespesa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Despesas)) {
            return false;
        }
        Despesas other = (Despesas) object;
        if ((this.codigoDespesa == null && other.codigoDespesa != null) || (this.codigoDespesa != null && !this.codigoDespesa.equals(other.codigoDespesa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifsplife.model.Despesas[ codigoDespesa=" + codigoDespesa + " ]";
    }

}