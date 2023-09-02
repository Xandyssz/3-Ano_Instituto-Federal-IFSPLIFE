package ifsplife.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
    @NamedQuery(name = "Pagamentocompra.findByVencimento", query = "SELECT p FROM Pagamentocompra p WHERE p.vencimento = :vencimento"),
    @NamedQuery(name = "Pagamentocompra.findByPeriodo", query = "SELECT p FROM Pagamentocompra p WHERE p.vencimento BETWEEN :inicio AND :fim"),
    @NamedQuery(name = "Pagamentocompra.findByCaixaAndStatusPago", query = "SELECT p FROM Pagamentocompra p WHERE p.codigo_caixa = :caixa AND p.status = 'Pago'"),
    @NamedQuery(name = "Pagamentocompra.findByCodigoCompra", query = "SELECT p FROM Pagamentocompra p WHERE p.codigo_compra = :codigoCompra")

})

@IdClass(PagamentocompraId.class)
public class Pagamentocompra implements Serializable {

    @Id
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "codigo_compra", referencedColumnName = "codigo_compra")
    private Compras codigo_compra;

    @Id
    @Column(name = "parcela", nullable = false)
    private int parcela;

    @Column(name = "valor", nullable = false)
    private Double valor;

    @Column(name = "vencimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date vencimento;

    @Column(name = "status", nullable = true, length = 45)
    private String status = "Pendente";

    @ManyToOne
    @JoinColumn(name = "codigo_caixa", referencedColumnName = "codigo_caixa")
    private Caixa codigo_caixa;

    public Pagamentocompra() {
    }

    public Pagamentocompra(int parcela, Double valor, Date vencimento, String status, Caixa codigo_caixa, Compras codigo_compra) {
        this.parcela = parcela;
        this.valor = valor;
        this.vencimento = vencimento;
        this.status = status;
        this.codigo_caixa = codigo_caixa;
        this.codigo_compra = codigo_compra;
    }

    public int getParcela() {
        return parcela;
    }

    public void setParcela(int parcela) {
        this.parcela = parcela;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Caixa getcodigo_caixa() {
        return codigo_caixa;
    }

    public void setcodigo_caixa(Caixa codigo_caixa) {
        this.codigo_caixa = codigo_caixa;
    }

    public Compras getCodigo_compra() {
        return codigo_compra;
    }

    public void setCodigo_compra(Compras codigo_compra) {
        this.codigo_compra = codigo_compra;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.codigo_caixa);
        hash = 67 * hash + Objects.hashCode(this.codigo_compra);
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
        final Pagamentocompra other = (Pagamentocompra) obj;
        if (!Objects.equals(this.codigo_caixa, other.codigo_caixa)) {
            return false;
        }
        return Objects.equals(this.codigo_compra, other.codigo_compra);
    }

}
