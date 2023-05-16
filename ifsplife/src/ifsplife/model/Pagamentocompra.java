package ifsplife.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
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
    @NamedQuery(name = "Pagamentocompra.findAll", query = "SELECT p FROM Pagamentocompra p")})
public class Pagamentocompra implements Serializable {

    @Column(name = "parcela", nullable = false)
    private int parcela;

    @Column(name = "valor", nullable = false)
    private float valor;

    @Column(name = "vencimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date vencimento;

    @ManyToOne
    @JoinColumn(name = "caixa_idcaixa", referencedColumnName = "codigo_caixa")
    private Caixa caixa_idcaixa;

    @Id
    @OneToOne
    @JoinColumn(name = "codigo_compra", referencedColumnName = "codigo_compra")
    private Compras codigo_compra;

    public Pagamentocompra() {
    }

    public Pagamentocompra(int parcela, float valor, Date vencimento, Caixa caixa_idcaixa, Compras codigo_compra) {
        this.parcela = parcela;
        this.valor = valor;
        this.vencimento = vencimento;
        this.caixa_idcaixa = caixa_idcaixa;
        this.codigo_compra = codigo_compra;
    }

    public int getParcela() {
        return parcela;
    }

    public void setParcela(int parcela) {
        this.parcela = parcela;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public Caixa getCaixa_idcaixa() {
        return caixa_idcaixa;
    }

    public void setCaixa_idcaixa(Caixa caixa_idcaixa) {
        this.caixa_idcaixa = caixa_idcaixa;
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
        hash = 67 * hash + Objects.hashCode(this.caixa_idcaixa);
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
        if (!Objects.equals(this.caixa_idcaixa, other.caixa_idcaixa)) {
            return false;
        }
        return Objects.equals(this.codigo_compra, other.codigo_compra);
    }

}
